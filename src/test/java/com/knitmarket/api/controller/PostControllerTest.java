package com.knitmarket.api.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
class PostControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("/post요청시 출력")
    void test() throws Exception {

        // expected
        mockMvc.perform(post("/posts")
//                        .contentType(MediaType.APPLICATION_FORM_URLENCODED) //XXX어쩌구 데이터타입
                                .contentType(MediaType.APPLICATION_JSON) // MockMvc default dataType : json
                                .content("{\"title\":\"제목입니다.\",\"content\":\"내용입니다\"}") //json 형태로 데이터를 보냄
                ) //해당 url 로 요청함
                .andExpect(status().isOk()) // 응답 status 를 ok 로 테스트
                .andExpect(content().string("HELLO WORLD")) //content() ~로 내용등록
                .andDo(print()); //http 요청에 대한 summary 를 남겨주는 print 메서드
    }

    @Test
    @DisplayName("/post요청시 title 값은 필수다")
    void test2() throws Exception {

        // expected
        mockMvc.perform(post("/posts")
//                        .contentType(MediaType.APPLICATION_FORM_URLENCODED) //XXX어쩌구 데이터타입
                                .contentType(MediaType.APPLICATION_JSON) // MockMvc default dataType : json
                                .content("{\"title\":\"제목입니다.\",\"content\":\"내용입니다\"}") //json 형태로 데이터를 보냄
                ) //해당 url 로 요청함
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.code").value("400")) //content() ~로 내용등록
                .andExpect(jsonPath("$.message").value("잘못된 요청입니다")) //content() ~로 내용등록
                .andExpect(jsonPath("$.validation.title").value("타이틀을 입력해주세요.")) //content() ~로 내용등록
                .andDo(print()); //http 요청에 대한 summary 를 남겨주는 print 메서드
    }
}

