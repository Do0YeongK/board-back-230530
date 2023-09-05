package com.doyeong.back.dto.response.search;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.doyeong.back.common.response.ResponseCode;
import com.doyeong.back.common.response.ResponseMessage;
import com.doyeong.back.dto.response.ResponseDto;
import com.doyeong.back.entity.resultSet.SearchWordResultSet;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetPopularListResponseDto extends ResponseDto {
  private List<String> popularList;

  private GetPopularListResponseDto(String code, String message, List<SearchWordResultSet> resultSets) {
    super(code, message);
    
    List<String> popularList = new ArrayList<>();

    for (SearchWordResultSet resultSet: resultSets) {
      String searchWord = resultSet.getSearchWord();
      popularList.add(searchWord);
    }

    this.popularList = popularList;
  }

  public static ResponseEntity<GetPopularListResponseDto> success(List<SearchWordResultSet> resultSets) {
    GetPopularListResponseDto result = new GetPopularListResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, resultSets);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }
}