package com.mnlt24.sb_sample.services;


import com.mnlt24.sb_sample.models.Member;
import com.mnlt24.sb_sample.models.dto.MemberAddVo;
import com.mnlt24.sb_sample.repositories.MemberRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SampleService {

  private final MemberRepository memberRepository;

  public SampleService(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  /**
   * @return 유저 정보 조회
   */
  public List<Member> getAllMembers() {
    return this.memberRepository.findAll();
  }

  @Transactional
  public Member addMember(MemberAddVo.Request requestVo) {
    final var newMember = new Member(requestVo.getName());
    return this.memberRepository.save(newMember);
  }
}
