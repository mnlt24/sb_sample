package com.mnlt24.sb_sample.controllers;


import com.jayway.jsonpath.JsonPath;
import com.mnlt24.sb_sample.repositories.MemberRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 여기에 테스트 시나리오 작성 ( 예시 )

 * 성공
 1. 고객 정보 조회

 * 실패
 1. 등록되지 않은 고객 정보 조회
 */

@DisplayName("샘플 테스트")
class SampleControllerTest extends ControllerTest {
  // 테스트에 사용할 Repository 추가
  @Autowired
  private MemberRepository memberRepository;

  @Test
  @Order(1)
  @DisplayName("고객 정보 조회 성공")
  public void getAllMembersSuccess() throws Exception {
    // given
    final String url = "/sample/list";

    // when
    final ResultActions result = mockMvc.perform(get(url).  // 요청
        accept(MediaType.APPLICATION_JSON));

    // then
    MvcResult mvcResult = result.andExpect(status().isOk())
        // 응답의 0번째 값이 DB에 저장한 값과 같은지 확인
        .andExpect(jsonPath("$[0].id").value(10001))
        .andExpect(jsonPath("$[0].name").value("name 1"))
        .andReturn();

    /* assertJ check */
    String response = mvcResult.getResponse().getContentAsString();
    final var parsed = JsonPath.parse(response);
    Long memberId = ((Number)parsed.read("$[1].id")).longValue();
    assertThat(memberId).isEqualTo(10002);
  }

//  @Test
//  @Order(2)
//  @DisplayName("고객 정보 추가 성공")
//  public void insertMemberSuccess() throws Exception {
//    //...
//  }
}
