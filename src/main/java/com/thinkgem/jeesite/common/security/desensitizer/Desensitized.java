package com.thinkgem.jeesite.common.security.desensitizer;

import java.lang.annotation.*;

/**
 * @Author duhongming
 * @Email 19919902414@189.cn
 * @Date 2018/9/6 14:52
 */
@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Desensitized {
    /*脱敏类型(规则)*/
    SensitiveTypeEnum type();

    RoleTypeEnum[] role() default RoleTypeEnum.ALL_ROLES;
}