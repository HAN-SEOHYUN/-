package com.knitmarket.api.controller;

import com.knitmarket.api.domain.Post;
import com.knitmarket.api.request.PostCreate;
import com.knitmarket.api.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.image.ImageProducer;
import java.sql.ClientInfoStatus;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/posts")
    public void post(@RequestBody @Valid PostCreate request){
        postService.write(request);
    }


    //글 조회
    //posts => 글 전체 조회(검색 + 페이징)
    //posts/{postId} => 글 한개만 조회

    @GetMapping("/posts/{postId}")
    public Post get(@PathVariable(name= "postId") Long id){
       Post post = postService.get(id);
       return post;
    }




}
