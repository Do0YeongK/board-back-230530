package com.doyeong.back.service;

import org.springframework.http.ResponseEntity;

import com.doyeong.back.dto.request.board.PatchBoardRequestDto;
import com.doyeong.back.dto.request.board.PostBoardRequestDto;
import com.doyeong.back.dto.request.board.PostCommentRequestDto;
import com.doyeong.back.dto.request.board.PutFavoriteRequestDto;
import com.doyeong.back.dto.response.board.DeleteBoardResponseDto;
import com.doyeong.back.dto.response.board.GetBoardResponseDto;
import com.doyeong.back.dto.response.board.GetCommentListResponseDto;
import com.doyeong.back.dto.response.board.GetCurrentBoardResponseDto;
import com.doyeong.back.dto.response.board.GetFavoriteListResponseDto;
import com.doyeong.back.dto.response.board.GetSearchBoardResponseDto;
import com.doyeong.back.dto.response.board.GetTop3ResponseDto;
import com.doyeong.back.dto.response.board.GetUserListResponseDto;
import com.doyeong.back.dto.response.board.PatchBoardResponseDto;
import com.doyeong.back.dto.response.board.PostBoardResponseDto;
import com.doyeong.back.dto.response.board.PostCommentResponseDto;
import com.doyeong.back.dto.response.board.PutFavoriteResponseDto;

public interface BoardService {
  
  // method : Top3 게시물 불러오기 메서드 //
  ResponseEntity<? super GetTop3ResponseDto> getTop3();
  // method : 최신 게시물 리스트 불러오기 메서드 //
  ResponseEntity<? super GetCurrentBoardResponseDto> getCurrentBoard(Integer section);
  // method : 게시물 불러오기 메서드 //
  ResponseEntity<? super GetBoardResponseDto> getBoard(Integer boardNumber);
  // method : 검색 게시물 리스트 불러오기 //
  ResponseEntity<? super GetSearchBoardResponseDto> getSearchBoard(String searchWord, String relationWord);
  // method : 특정 게시물의 좋아요 리스트 불러오기 //
  ResponseEntity<? super GetFavoriteListResponseDto> getFavoriteList(Integer boardNumber);
  // method : 특정 게시물의 댓글 리스트 불러오기 //
  ResponseEntity<? super GetCommentListResponseDto> getCommentList(Integer boardNumber);
  // method : 특정 유저의 게시물 리스트 불러오기 //
  ResponseEntity<? super GetUserListResponseDto> getUserList(String email);
  // method : 게시물 작성 메서드 //
  ResponseEntity<? super PostBoardResponseDto> postBoard(String email, PostBoardRequestDto dto);
  // method : 댓글 작성 메서드 //
  ResponseEntity<? super PostCommentResponseDto> postComment(Integer boardNumber, String email, PostCommentRequestDto dto);
  // mehtod : 좋아요 기능 메서드 //
  ResponseEntity<? super PutFavoriteResponseDto> putFavorite(Integer boardNumber, String email);
  // method : 게시물 수정 메서드 //
  ResponseEntity<? super PatchBoardResponseDto> patchBoard(Integer boardNumber, String email, PatchBoardRequestDto dto);
  // method : 게시물 삭제 메서드 //
  ResponseEntity<? super DeleteBoardResponseDto> deleteBoard(Integer boardNumber, String email);

}
