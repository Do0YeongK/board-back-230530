package com.doyeong.back.controller;

import javax.validation.Valid;

// import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doyeong.back.dto.request.auth.SignInRequestDto;
import com.doyeong.back.dto.request.auth.SignUpRequestDto;
// import com.doyeong.back.dto.response.ResponseDto;
import com.doyeong.back.dto.response.auth.SignInResponseDto;
import com.doyeong.back.dto.response.auth.SignUpResponseDto;
import com.doyeong.back.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

  private final AuthService authService;

  // API : 회원가입 메서드 //
  @PostMapping("/sign-up")
  public ResponseEntity<?super SignUpResponseDto> signUp(
    /* Valid : 검증을 위해 추가 */
    @RequestBody @Valid SignUpRequestDto requestBody
  ) {
    ResponseEntity<?super SignUpResponseDto> response = authService.signUp(requestBody);
    return response;
  }

  // API : 로그인 메서드 //
  @PostMapping("/sign-in")
  // # public ResponseEntity<RequestDto> signIn( 
  // # : 이렇게 작성하면 나중에 코드 정보를 확인할 경우 SignInRequestDto가 아닌 RequestDto를 확인하게 되어 파악하기 힘듦
  // # 따라서 아래와 같이 표현하는게 좋음****
  public ResponseEntity<? super SignInResponseDto> signIn(

    @RequestBody @Valid SignInRequestDto requestBody
  ) {
   ResponseEntity<? super SignInResponseDto> response = authService.signIn(requestBody);
    return response;
  }
  
}
