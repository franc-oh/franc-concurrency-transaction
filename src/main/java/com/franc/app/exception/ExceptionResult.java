package com.franc.app.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ExceptionResult {

    ALEADY_ISSUED_COUPON(HttpStatus.BAD_REQUEST, "이미 쿠폰을 발급받았습니다."),
    NOT_FOUND_TARGET_COUPON(HttpStatus.BAD_REQUEST, "발급 가능한 쿠폰이 없습니다."),



    PARAMETER_NOT_VALID(HttpStatus.BAD_REQUEST, "잘못된 요청 데이터입니다."),
    UNKNOWN_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR, "오류가 발생했습니다. <br/>고객센터(1588-9999)로 문의주세요.");

    private final HttpStatus code;
    private final String message;
}
