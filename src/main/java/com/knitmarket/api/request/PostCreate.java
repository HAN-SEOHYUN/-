package com.knitmarket.api.request;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@ToString
@Data
public class PostCreate {

    @NotBlank(message ="타이틀을 입력해주세요.")
    public String title;

    @NotBlank(message ="콘텐츠를 입력해주세요.")
    public String content;


}
