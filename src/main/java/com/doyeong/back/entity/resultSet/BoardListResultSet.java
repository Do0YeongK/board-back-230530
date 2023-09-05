package com.doyeong.back.entity.resultSet;

// interface에는 1.추상메서드 2.(final)상수
public interface BoardListResultSet {
  int getBoardNumber();
  String getTitle();
  String getContents();
  String getImageUrl();
  int getViewCount();
  int getCommentCount();
  int getFavoriteCount();
  String getWriteDatetime();
  String getWriterProfileImage();
  String getWriterNickname();
}
