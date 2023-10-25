package com.mnlt24.sb_sample.repositories;


import com.mnlt24.sb_sample.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * com.wesang.giftyo.bo.repository.MemberRepository
 *
 * @author suuuman
 * @version 1.0
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
  Optional<Member> findByName(String name);

  @Transactional
  @Modifying
  @Query(value = "truncate table member", nativeQuery = true)
  void truncate();
}
