drop table if exists TB_ACCOUNT;
drop table if exists TB_COUPON;

CREATE TABLE TB_ACCOUNT (
    ACCOUNT_NO BIGINT NOT NULL AUTO_INCREMENT COMMENT '회원번호',
    ACCOUNT_NM VARCHAR(50) NOT NULL COMMENT '이름',
    CONSTRAINT TB_ACCOUNT_PK PRIMARY KEY(ACCOUNT_NO)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '회원정보';

CREATE TABLE TB_COUPON (
    COUPON_ID VARCHAR(20) NOT NULL COMMENT '쿠폰번호',
    COUPON_NM VARCHAR(50) NOT NULL COMMENT '쿠폰이름',
    COUPON_AMT INT NOT NULL COMMENT '금액',
    ISS_DATE TIMESTAMP COMMENT '발급일자',
    ACCOUNT_NO BIGINT COMMENT '발급자',
    CONSTRAINT TB_COUPON_PK PRIMARY KEY (COUPON_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '쿠폰정보';

