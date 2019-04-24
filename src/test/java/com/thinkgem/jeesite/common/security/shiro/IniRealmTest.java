package com.thinkgem.jeesite.common.security.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * @Author duhongming
 * @Email 935720334@qq.com
 * @Date 2019/4/14 15:59
 * 认证
 */
public class IniRealmTest {
    private static final IniRealm iniRealm = new IniRealm("classpath:user.ini");

    @Test
    public void testAuthentication() {

        //1. 构建SecurityManager环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(iniRealm);

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
