package com.mnlt24.sb_sample.models;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Entity
public class Member {
  /** id - PK */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false)
  private Long id;

  /** name - 거래처 이름 */
  @Column(name = "name", nullable = false)
  private String name;

  public Member(String name) {
    this.name = name;
  }
}

