package com.thinkgem.jeesite.common.enumdemo;

/**
 * @Author duhongming
 * @Email 19919902414@189.cn
 * @Date 2018/8/31 15:45
 */
public class CommonExceptions {

    public enum UserCommonException{

        CUST_NOT_REGISTER(new CommonException(1000,"用户尚未注册")),
        CUST_NOT_FOUND(new CommonException( 1001,"用户不存在")),
        CUST_PASS_WRONG(new CommonException(1002,"用户名或密码错误")),
        CUST_VERIFY_WRONG(new CommonException(1003,"验证码错误，请重新尝试")),
        CUST_USER_NOT_AUTH(new CommonException(1004,"用户没有登录此平台的权限")),
        CUST_USER_EXITST(new CommonException(1005,"用户登录名已经存在")),
        CUST_USER_NOT_CHECKED(new CommonException(1006,"注册用户尚未审核通过，暂时不允许登录")),
        TOKEN_NOT_REQUEST(new CommonException(1007,"未传入isCheckToken参数")),
        TOKEN_NOT_FOUNT(new CommonException(1008,"token失效")),
        LOGIN_NOT_EXIST(new CommonException(1009,"您未登录")),
        OLDPWD_WRONG(new CommonException(1010,"原密码错误")),

        PHONE_PASSWORD_NOT_RECEIVE(new CommonException(1012,"手机号或密码不能为空")),
        CUST_VERIFY_NOT_NULL(new CommonException(1013,"验证码不能为空")),
        USER_ID_NOT_NULL(new CommonException(1014,"用户userid不能为空")),
        VERIFY_CODE_SEND_ERROR(new CommonException(1015,"短信发送失败")),
        PHONE_VERIFYCODE_NOT_RECEIVE(new CommonException(1016,"手机号或验证码不能为空")),
        OLD_AND_NEW_PASSWORD_NOT_NULL(new CommonException(1017,"旧密码或新密码不能为空")),
        CUSTOMER_AVATAR_NOT_RECEIVE(new CommonException(1018,"未传入用户头像")),
        ID_CARD_VERIFY_NOT_FULL(new CommonException(1019,"实名认证信息不完整")),
        CUSTOMER_PASSWORD_NOT_FOUND(new CommonException(1020,"用户密码不存在")),
        USERNAME_PASSWORD_EQUAL(new CommonException(1021,"用户名和密码不能相同")),
        USER_STATE_WRONG(new CommonException(1027,"用户已冻结或已注销")),
        USER_CENTER_CONNECT_FAIL(new CommonException(1028,"连接注册中心失败")),
        USER_CENTER_REGISTE_FAIL(new CommonException(1029,"用户中心注册失败")),

        PHONENO_INPUT_ERROR(new CommonException(2030,"手机号不符合规则")),
        USER_CENTER_UPDATE_FAIL(new CommonException(2031,"注册中心修改用户信息失败")),
        PARAM_NOT_COMPLETE(new CommonException(2032,"传入参数不完整")),
        USER_CENTER_SERVER_FAIL(new CommonException(2033,"注册中心暂不提供服务")),
        USER_CENTER_VALIDATE_FAIL(new CommonException(2034,"用户中心登陆验证失败，用户名或密码不正确")),
        USER_CENTER_MERGE_FAIL(new CommonException(2035,"合并失败（无主用户信息或登录名重复)")),
        USER_CENTER_EXIST_PHONE(new CommonException(2040,"合并失败,该登录名的手机或邮箱存在多条数据，请更换手机或邮箱合并")),
        USER_CENTER_PWD_WRONG(new CommonException(2036,"注册中心同步修改密码出错:-->用户名或原密码不正确")),
        USER_CENTER_PWD_EQUALS(new CommonException(2037,"注册中心同步修改密码出错:-->原密码不能与新密码相同")),
        USER_CENTER_RESETPWD_FAIL(new CommonException(2038,"注册中心重置密码失败")),
        CUSCORP_NOT_EXIS(new CommonException(2039,"查找的企业不存在")),
        CUSCORP_NOT_FOUND(new CommonException(2039,"此企业未查询到")),

        USER_CENTER_RESULT_FAIL(new CommonException(2041,"注册中心查询结果无数据或查询异常")),
        USER_CENTER_NOT_RETURN_PHONE(new CommonException(2047,"注册中心未返回手机号")),
        SERVICE_UNAVAILABLE(new CommonException(2042,"服务不可用  (此异常是控制用户注册和修改密码开关异常)")),
        ACCESS_CHANNEL_ERROR(new CommonException(2043,"访问渠道不正确")),
        USER_CARD_STATE_ERROR(new CommonException(2044,"输入的卡状态有误")),
        ALLOW_PAY_MODEL_ERROR(new CommonException(2045,"输入信息有误")),
        PAY_MODEL_NOT_EXIST(new CommonException(2046,"此卡业务设置信息不存在")),

        ID_TYPE_NOT_NULL (new CommonException( 2045,"证件类型不为空")),
        ID_NO_FORMAT_ERROR (new CommonException( 2055,"用户身份证格式不正确")),

        OLD_EQUAL_NEW(new CommonException(3042,"输入的新密码等于旧密码")),
        PWD_NOT_NULL(new CommonException(3043,"用户名或密码错误")),
        NEW_NOTEQUAL_CONFIRM(new CommonException(3041,"两次输入的密码不相同")),
        PWD_NOTEQUAL_THIRD(new CommonException(3044,"输入的新密码不能与最近三次密码相同"));

        private CommonException commonException;

        UserCommonException(CommonException commonException){
            this.commonException = commonException;
        }

        public CommonException getCommonException() {
            return commonException;
        }

        public void setCommonException(CommonException commonException) {
            this.commonException = commonException;
        }

        public static void show(){
            for(UserCommonException u : UserCommonException.values()){
                System.out.println(u + "： UserCommonException =" + u.getCommonException());
            }
        }
    }

}