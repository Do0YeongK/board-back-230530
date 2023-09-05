package com.doyeong.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.doyeong.back.entity.BoardEntity;
import com.doyeong.back.entity.resultSet.BoardListResultSet;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {
  boolean existsByBoardNumber(Integer boardNumber);
  
  BoardEntity findByBoardNumber(Integer boardNumber);

  @Query(
    value=
    "SELECT " + 
    "B.board_Number AS boardNumber, " + 
    "B.title AS title, " +
    "B.contents AS contents, " +
    "B.image_url AS imageUrl, " +
    "B.view_count AS viewCount, " +
    "B.comment_count AS commentCount, " +
    "B.favorite_count AS favoriteCount, " +
    "B.write_datetime AS writeDatetime, " +
    "U.profile_image_url AS writerProfileImage, " +
    "U.nickname AS writerNickname " +
    "FROM board AS B " +
    "INNER JOIN user AS U " +
    "ON B.writer_email = U.email " +
    "ORDER BY B.write_datetime DESC " +
    "LIMIT ?1, 50",
    // nativeQuery = true : 실제 데이터(SQL)를 읽겠다 //
    nativeQuery = true
  )
  List<BoardListResultSet> getCurrentList(Integer section);
}
