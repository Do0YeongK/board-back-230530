package com.doyeong.back.dto.response.board;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.doyeong.back.common.response.ResponseCode;
import com.doyeong.back.common.response.ResponseMessage;
import com.doyeong.back.dto.response.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetCommentListResponseDto extends ResponseDto {
  
  private List<CommentListResponseDto> commentList;

  private GetCommentListResponseDto(String code, String message, List<CommentListResponseDto> commentList) {
    super(code, message);
    this.commentList = commentList;
  }

  public static ResponseEntity<GetCommentListResponseDto> success(List<CommentListResponseDto> commentList) {
    GetCommentListResponseDto result = new GetCommentListResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, commentList);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

}
