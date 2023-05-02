package com.franc.app.service;


import com.franc.app.mapper.CouponMapper;
import com.franc.app.vo.CouponVO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(properties = {"spring.profiles.active=test"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class CouponServiceTests {

    @Autowired
    private CouponService couponService;

    @Autowired
    private CouponMapper couponMapper;


    @Test
    public void concurrency_test() throws Exception {
        // # Given
        Long account1 = 1L;
        Long account2 = 2L;

        String coupon1 = "C0001";
        String coupon2 = "C0002";

        // # When
        couponService.issueCoupon(account1);
        couponService.issueCoupon(account2);

        CouponVO result1 = couponMapper.findByAccountNo(account1);
        CouponVO result2 = couponMapper.findByAccountNo(account2);

        // # Then
        assertThat(result2).isNotNull();
        assertThat(result2.getCouponId()).isEqualTo(coupon2);

        assertThat(result1).isNotNull();
        assertThat(result1.getCouponId()).isEqualTo(coupon1);
    }
}
