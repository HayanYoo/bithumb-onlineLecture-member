package com.example.member.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Member {
    private Long id;
    private String username;
    private String password;
    private AuthType authType;
}
