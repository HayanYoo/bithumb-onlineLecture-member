package com.example.member.config;

import com.example.member.component.PostHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class RouterConfig {

//    @Bean
//    public RouterFunction<ServerResponse> route(PostHandler postHandler) {
//        return RouterFunctions.route()
//                .GET("/hello",
////                        accept(MediaType.APPLICATION_JSON),
//                        postHandler::createHello)
//                .build();
//
//    }


    @Bean
    public RouterFunction<ServerResponse> getRoute(PostHandler postHandler) {
        return RouterFunctions.route()
                .path("/member", builder -> builder
                        .POST("login", accept(APPLICATION_JSON), postHandler::login)
                        .POST("register/student", accept(APPLICATION_JSON), postHandler::registerStudent)
                        .POST("register/teacher", accept(APPLICATION_JSON), postHandler::registerTeacher)
                )
                .build();


    }


}
