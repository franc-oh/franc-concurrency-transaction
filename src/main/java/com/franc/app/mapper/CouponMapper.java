package com.franc.app.mapper;

import com.franc.app.vo.CouponVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CouponMapper {

    CouponVO findByAccountNo(@Param("accountNo")Long accountNo) throws Exception;

    CouponVO findIssueTargetCoupon() throws Exception;

    void issueCoupon(CouponVO vo) throws Exception;

}
