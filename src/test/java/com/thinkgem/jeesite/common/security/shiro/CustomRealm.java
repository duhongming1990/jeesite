package com.thinkgem.jeesite.common.security.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author duhongming
 * @Email 935720334@qq.com
 * @Date 2019/4/14 16:45
 */
public class CustomRealm extends AuthorizingRealm {
    //用户
    public static final Map<String,String> USERS = new HashMap<>();
    //角色
    public static final Set<String> ROLES = new HashSet<>();
    //权限
    public static final Set<String> PERMISSIONS = new HashSet<>();
    {
        USERS.put("Mark","283538989cef48f3d7d8a1c1bdf2008f");
        ROLES.add("admin");
        PERMISSIONS.add("user:delete");
        PERMISSIONS.add("user:update");
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName = (String)token.getPrincipal();
        if(USERS.get(userName) == null){
           return null;
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(userName,USERS.get(userName),"customRealm");
        simpleAuthenticationInfo.setCredentialsSalt(ByteSource.Util.bytes("Mark"));
        return simpleAuthenticationInfo;
    }


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String userName = (String)principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(ROLES);
        simpleAuthorizationInfo.setStringPermissions(PERMISSIONS);
        return simpleAuthorizationInfo;
    }

    public static void main(String[] args) {
        Md5Hash md5Hash = new Md5Hash("123456");
        System.out.println("md5Hash = " + md5Hash);
        md5Hash = new Md5Hash("123456","Mark");
        System.out.println("md5Hash salt = " + md5Hash);
    }


}
