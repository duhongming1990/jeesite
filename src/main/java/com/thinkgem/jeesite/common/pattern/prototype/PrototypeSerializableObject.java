package com.thinkgem.jeesite.common.pattern.prototype;

/**
 * @Author duhongming
 * @Email 19919902414@189.cn
 * @Date 2018/6/19 10:03
 */
public class PrototypeSerializableObject extends SerializableObject{
    private String aaa;
    private int bbb;
    private double ccc;

    public PrototypeSerializableObject(String aaa, int bbb, double ccc) {
        this.aaa = aaa;
        this.bbb = bbb;
        this.ccc = ccc;
    }

    public String getAaa() {
        return aaa;
    }

    public void setAaa(String aaa) {
        this.aaa = aaa;
    }

    public int getBbb() {
        return bbb;
    }

    public void setBbb(int bbb) {
        this.bbb = bbb;
    }

    public double getCcc() {
        return ccc;
    }

    public void setCcc(double ccc) {
        this.ccc = ccc;
    }
}