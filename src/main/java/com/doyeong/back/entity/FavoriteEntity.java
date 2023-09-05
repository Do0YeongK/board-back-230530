package com.doyeong.back.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.doyeong.back.entity.pk.FavoritePk;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "favorite")
@Table(name="favorite")
@IdClass(FavoritePk.class)
public class FavoriteEntity {
  @Id
  private int boardNumber;
  @Id
  private String userEmail;
}
