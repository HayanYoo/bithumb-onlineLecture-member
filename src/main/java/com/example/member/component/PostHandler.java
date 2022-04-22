package com.example.member.component;

import com.example.member.domain.AuthType;
import com.example.member.dto.MemberDto;
import com.example.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;


@Component
@RequiredArgsConstructor
public class PostHandler {

    private final WebClient webClient;
    private final MemberService memberService;

    //
//    public Mono<ServerResponse> createHello(ServerRequest serverRequest) {
//        String name = serverRequest.queryParam("name").orElse("");
//        Mono<InfoDto> infoDtoMono = webClient.get()
//                                        .uri(uriBuilder ->
//                                                uriBuilder.path("/info-service/uri")
//                                                        .queryParam("name", name)
//                                                        .build()
//                                        ).retrieve().bodyToMono(InfoDto.class);
//
//        Mono<HelloResponse> map = infoDtoMono.map(it -> new HelloResponse(name, it.getJob()));
//
//        return ServerResponse
//                .ok()
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(map, HelloResponse.class);
//    }
//
    public Mono<ServerResponse> login(ServerRequest serverRequest) {

        Mono<MemberDto> memberDto = memberService.login(serverRequest)
                .map(member -> new MemberDto(member));

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(memberDto, MemberDto.class);
    }

    public Mono<ServerResponse> registerStudent(ServerRequest serverRequest) {

        Mono<MemberDto> memberDto = memberService.registerStudent(serverRequest, AuthType.STUDENT)
                .map(member -> new MemberDto(member));

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(memberDto, MemberDto.class);
    }

    public Mono<ServerResponse> registerTeacher(ServerRequest serverRequest) {

        Mono<MemberDto> memberDto = memberService.registerTeacher(serverRequest, AuthType.TEACHER)
                .map(member -> new MemberDto(member));

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(memberDto, MemberDto.class);
    }
}
