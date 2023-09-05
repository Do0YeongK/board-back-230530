package com.doyeong.back.service;

import org.springframework.http.ResponseEntity;

import com.doyeong.back.dto.response.search.GetPopularListResponseDto;
import com.doyeong.back.dto.response.search.GetRelationListResonseDto;

public interface SearchService {
  // method : 인기 검색어 리스트 불러오기 메서드 //
  ResponseEntity<? super GetPopularListResponseDto> getPopularList();
  // method : 연관 검색어 리스트 불러오기 메서드 //
  ResponseEntity<? super GetRelationListResonseDto> getRelationList(String searchWord);
}
