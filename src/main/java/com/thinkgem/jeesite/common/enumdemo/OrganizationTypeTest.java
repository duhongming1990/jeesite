package com.thinkgem.jeesite.common.enumdemo;

/**
 * @Author duhongming
 * @Email 19919902414@189.cn
 * @Date 2018/7/19 15:42
 */
public class OrganizationTypeTest {
    public static void main(String[] args) {

        System.out.println("企业类型:");
        OrganizationType.TYPE.show();

        System.out.println("根节点标识:");
        OrganizationType.ROOT_OU.show();

        System.out.println("注册渠道:");
        OrganizationType.ZQ.show();

        System.out.println("机构状态:");
        OrganizationType.STATE.show();

        System.out.println("机构性质:");
        OrganizationType.OU_PROP.show();

        System.out.println("叶子节点:");
        OrganizationType.OU_IS_LEAF.show();

        String s = String.format("%010d", 10);
        System.out.println(s);

    }
}