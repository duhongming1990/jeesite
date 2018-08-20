package com.thinkgem.jeesite.test;

import com.alibaba.fastjson.JSON;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * @Author duhongming
 * @Email 935720334@qq.com
 * @Date 2018/7/21 15:40
 */
public class do2vo {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        StringUtils.isNotBlank("");
        StringUtils.isBlank("");
        CollectionUtils.isNotEmpty(new ArrayList());
        CollectionUtils.isEmpty(new HashSet());
        BeanUtils.copyProperties(Object source, Object target);
        User user = new User();
        user.setUserName("duhongming");
        user.setRealName("杜洪明");
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(user,userVo,"userName");
        System.out.println(JSON.toJSONString(userVo));

    }
    static class User{
        private String userName;
        private String realName;
        private String checkName;

        public User() {
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getRealName() {
            return realName;
        }

        public void setRealName(String realName) {
            this.realName = realName;
        }

        public String getCheckName() {
            return checkName;
        }

        public void setCheckName(String checkName) {
            this.checkName = checkName;
        }
    }

   static  class UserVo{
        private String userName;
        private String realName;
        private String nothing;

        public UserVo() {
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

       public String getRealName() {
           return realName;
       }

       public void setRealName(String realName) {
           this.realName = realName;
       }

       public String getNothing() {
           return nothing;
       }

       public void setNothing(String nothing) {
           this.nothing = nothing;
       }
   }
}
