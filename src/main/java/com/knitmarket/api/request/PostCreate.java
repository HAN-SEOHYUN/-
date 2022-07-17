package com.knitmarket.api.request;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@ToString
@Data
public class PostCreate {

    @NotBlank
    public String title;

    @NotBlank
    public String content;


}
