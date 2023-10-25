package com.mnlt24.sb_sample.models.dto;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberAddVo {

  @Getter
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Request {
    private String name;
  }

  @Builder
  @Getter
  @NoArgsConstructor
  @AllArgsConstructor
  @FieldDefaults(level = AccessLevel.PRIVATE)
  public static class Response {
    private Long id;
    private String name;
  }
}
