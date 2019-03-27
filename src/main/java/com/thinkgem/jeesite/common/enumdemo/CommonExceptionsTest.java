package com.thinkgem.jeesite.common.enumdemo;

/**
 * @Author duhongming
 * @Email 19919902414@189.cn
 * @Date 2018/8/31 15:50
 */
public class CommonExceptionsTest {
    public static void main(String[] args) {
        CommonExceptions.UserCommonException.show();
        throw CommonExceptions.UserCommonException.CUST_NOT_REGISTER.getCommonException();
    }
}