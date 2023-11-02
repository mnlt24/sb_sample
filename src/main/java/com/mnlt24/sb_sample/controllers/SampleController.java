package com.mnlt24.sb_sample.controllers;


import com.mnlt24.sb_sample.models.Member;
import com.mnlt24.sb_sample.models.dto.MemberAddVo;
import com.mnlt24.sb_sample.services.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sample")
public class SampleController {
  private final SampleService sampleService;

  @Autowired
  public SampleController(SampleService service) {
    this.sampleService = service;
  }

  @GetMapping("/list")
  public List<Member> getAllMembers() {
    return this.sampleService.getAllMembers();
  }

  @GetMapping("/test")
  public String getTest() {
    return "This is a test message";
  }

  @PostMapping("/add")
  public MemberAddVo.Response postAddMember(@RequestBody MemberAddVo.Request requestVo) {
    final var member = this.sampleService.addMember(requestVo);
    return MemberAddVo.Response.builder()
        .id(member.getId())
        .name(member.getName())
        .build();
  }
}
