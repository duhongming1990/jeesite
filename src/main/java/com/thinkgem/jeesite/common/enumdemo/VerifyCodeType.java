package com.thinkgem.jeesite.common.enumdemo;

/**
 * @Author duhongming
 * @Email 19919902414@189.cn
 * @Date 2018/7/18 14:58
 */
public enum VerifyCodeType {

    REGISTER(1,"注册","您的注册验证码为:"),
    QUICK_LOGIN(2,"快速登录","您正在进行快速登录，短信验证码为:"),
    CHANGE_PHONE(3,"更换手机","您正在进行更换手机，短信验证码为:"),
    RESET_PWD(4,"重置登录密码","您正在重置登录密码，短信验证码为:"),
    SET_PAY_PWD(5,"设置支付密码","您正在设置支付密码，短信验证码为:"),
    MODIFY_PAY_PWD(6,"修改支付密码","您正在修改支付密码，短信验证码为:"),
    EMAIL_BIND_PHONE(7,"通过email绑定手机号","您正在通过邮箱绑定手机号，短信验证码为:");

    public static final String SMS_TEXT_BOTTOM_ECHONG = "，请妥善保管,请勿泄露。短信验证码有效期为10分钟。";

    private Integer key;
    private String value;
    private String info;

    VerifyCodeType(Integer key,String value,String info){
        this.key = key;
        this.value = value;
        this.info = info;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getInfo() {
        return info + "{verifyCode}" + SMS_TEXT_BOTTOM_ECHONG;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public static void show(){
        for(VerifyCodeType v : VerifyCodeType.values()){
            System.out.println(v + "： key=" + v.getKey() + " value=" + v.getValue() + " info=" + v.getInfo());
        }
    }
}