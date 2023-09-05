package com.doyeong.back.controller;

import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.doyeong.back.service.FileService;

import lombok.RequiredArgsConstructor;

// controller: 파일 컨트롤러 //
@RestController
@RequestMapping("/file")
@RequiredArgsConstructor
public class FileController {
  
  // 의존성 주입
  private final FileService fileService;

  // API : 파일 업로드 메서드 //
  @PostMapping("/upload")
  public String upload(
    // "" 안에 명을 key 명으로 해야 함
    @RequestParam("file") MultipartFile file
  ) {
    // System.out.println(file.getOriginalFilename());
    // System.out.println(file.getSize());

    String url = fileService.upload(file);
    return url;
  }

  // API : 이미지 불러오기 메서드 //
  // produces : 어떤 타입으로 반환할 건지 결정 //
  @GetMapping(value = "/{fileName}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
  public Resource getFile(
    @PathVariable(value = "fileName", required = true) String fileName
  ) {
    Resource resource = fileService.getFile(fileName);
    return resource;
  }
  
}
