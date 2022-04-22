package com.example.member.service;

import com.example.member.domain.AuthType;
import com.example.member.domain.Member;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Mono;

@Configuration
public interface MemberService {

    //1. 학생 회원가입
    Mono<Member> registerStudent(ServerRequest serverRequest, AuthType authType);

    // 2. 강사 생성
    Mono<Member> registerTeacher(ServerRequest serverRequest, AuthType authType);

    //3. 로그인
    Mono<Member> login(ServerRequest serverRequest);

}
