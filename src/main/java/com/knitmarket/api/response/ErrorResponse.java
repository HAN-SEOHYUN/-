package com.knitmarket.api.response;

import lombok.RequiredArgsConstructor;

import java.util.HashMap;

/**
* {
 *     "code" : "400",
 *     "message" : "잘못된 요청입니다",
 *     "validation" : {
 *         "title" : "값을 입력해주세요"
 *     }
 * }
* */

@RequiredArgsConstructor
public class ErrorResponse {
    private final String code;
    private final String message;

    @RequiredArgsConstructor
    private class ValidationTuple{

        private final String fieldNmae;
        private final String errorMessage;

    }
}
