package com.franc.app.controller;


import com.franc.app.code.Code;
import com.franc.app.dto.CouponIssueDTO;
import com.franc.app.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/cpns")
@RequiredArgsConstructor
public class CouponController {
    private static final Logger logger = LoggerFactory.getLogger(CouponController.class);

    private final CouponService couponService;

    @PutMapping
    public ResponseEntity<?> issue(@RequestBody @Valid CouponIssueDTO.Request request) throws Exception {
        CouponIssueDTO.Response response = new CouponIssueDTO.Response();

        logger.info("쿠폰발급_Request => {}", request.toString());

        // #1. 쿠폰발급
        couponService.issueCoupon(request.getAccountNo());

        // #2. 응답처리
        response.setResultCode(Code.RESPONSE_CODE_SUCCESS);
        response.setResultMessage(Code.RESPONSE_MESSAGE_SUCCESS);

        logger.info("멤버십가입_Response => {}", response.toString());

        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }


}
