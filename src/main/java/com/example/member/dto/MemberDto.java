package com.example.member.dto;

import com.example.member.domain.AuthType;
import com.example.member.domain.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberDto {
    private Long id;
    private String username;
    private AuthType authType;

    public MemberDto(Member member) {
        id = member.getId();
        username = member.getUsername();
        authType = member.getAuthType();
    }

}
