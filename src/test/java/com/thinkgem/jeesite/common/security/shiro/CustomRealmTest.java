package com.thinkgem.jeesite.common.security.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * @Author duhongming
 * @Email 935720334@qq.com
 * @Date 2019/4/14 16:45
 */
public class CustomRealmTest {
    public static final CustomRealm CUSTOM_REALM = new CustomRealm();
    @Test
    public void testAuthentication() {

        //1. 构建SecurityManager环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(CUSTOM_REALM);

        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("md5");
        matcher.setHashIterations(1);
        CUSTOM_REALM.setCredentialsMatcher(matcher);

        //2. 主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        //3. 登录
        UsernamePasswordToken token = new UsernamePasswordToken("Mark","123456");
        subject.login(token);

        System.out.println("isAuthenticated : " + subject.isAuthenticated());

        //4. 授权
        subject.checkRole("admin");
        subject.checkPermissions("user:delete","user:update");
    }
}
