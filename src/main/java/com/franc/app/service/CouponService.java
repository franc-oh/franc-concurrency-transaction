package com.franc.app.service;

import com.franc.app.exception.BizException;
import com.franc.app.exception.ExceptionResult;
import com.franc.app.mapper.CouponMapper;
import com.franc.app.vo.CouponVO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CouponService {
    private static final Logger logger = LoggerFactory.getLogger(CouponService.class);

    private final CouponMapper couponMapper;

    @Transactional
    public void issueCoupon(Long accountNo) throws Exception {

        // #1. 이미 발급 받았는지 체크
        if(null != couponMapper.findByAccountNo(accountNo)) {
            throw new BizException(ExceptionResult.ALEADY_ISSUED_COUPON);
        }

        // #2. 발급되지 않은 쿠폰 가져오기
        CouponVO targetCouponVo = couponMapper.findIssueTargetCoupon();
        if(targetCouponVo == null)
            throw new BizException(ExceptionResult.NOT_FOUND_TARGET_COUPON);

        logger.info("targetCoupon : " + targetCouponVo.toString());

        // #3. 쿠폰 발급
        targetCouponVo.setAccountNo(accountNo);
        couponMapper.issueCoupon(targetCouponVo);
    }


}
