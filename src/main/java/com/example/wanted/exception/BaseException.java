package com.example.wanted.exception;

import org.springframework.http.HttpStatus;

public class BaseException extends RuntimeException {

    public String getMessage() {
        return "조회된 데이터가 없습니다.";
    }

    public HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
