package com.doyeong.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.doyeong.back.entity.UserEntity;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
  boolean existsByEmail(String email);
  boolean existsByNickname(String nickname);
  boolean existsByTelNumber(String telNumber);

  UserEntity findByEmail(String email);  // email은 Unique한 값이니깐 List일 필요 없음

  @Query(
    value = 
    "SELECT * " +
    "FROM user " +
    "WHERE email IN ( " +
    "SELECT user_email " +
    "FROM favorite " +
    "WHERE board_number = ?1 " + /* ?1 : 이 자리에 첫번째(1) 매개변수가 들어감 */
    ")", nativeQuery = true
  )
  List<UserEntity> getFavoriteList(Integer boardNumber);  /* 첫번째(1) 매개변수 = boardNumber */
}
