package com.mnlt24.sb_sample.controllers;


import com.mnlt24.sb_sample.models.Member;
import com.mnlt24.sb_sample.services.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
