package com.franc.app.vo;

import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@ToString
@EqualsAndHashCode(of = "couponId")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CouponVO {
    private String couponId;
    private String couponNm;
    private int couponAmt;
    private LocalDateTime issDate;
    private Long accountNo;
}
