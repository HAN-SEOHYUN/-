package com.knitmarket.api.controller;

import com.knitmarket.api.request.PostCreate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
public class PostController {

    //

    @PostMapping("/posts")
    public String post(@RequestBody @Valid PostCreate params, BindingResult result){

        log.info("params={}",params.toString());
        return "HELLO WORLD";
    }

}
