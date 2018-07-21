package com.thinkgem.jeesite.common.enumdemo;


/**
 * @Author duhongming
 * @Email 19919902414@189.cn
 * @Date 2018/7/19 15:37
 */
public class OrganizationType {

    /**
     * 企业类型
     */
    public enum TYPE{

        TYPE_QY(1,"企业"),
        TYPE_DW(2,"单位"),
        TYPE_BM(3,"部门");

        private Integer key;
        private String value;

        TYPE(Integer key, String value) {
            this.key = key;
            this.value = value;
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

        public static void show(){
            for(TYPE v : TYPE.values()){
                System.out.println(v + "： key=" + v.getKey() + " value=" + v.getValue());
            }
        }
    }

    /**
     * 根节点标识
     */
    public enum ROOT_OU{
        ROOT_OU_ELECCAR(1,"电动汽车"),
        ROOT_OU_CORPUSER(2,"企业用户"),
        ROOT_OU_ELEC_MERCHANT(3,"国网商户"),
        ROOT_OU_COMMON_MERCHANT(4,"社会商户"),
        ROOT_OU_PER_MERCHANT(5,"个人商户");

        private Integer key;
        private String value;

        ROOT_OU(Integer key, String value) {
            this.key = key;
            this.value = value;
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

        public static void show(){
            for(ROOT_OU v : ROOT_OU.values()){
                System.out.println(v + "： key=" + v.getKey() + " value=" + v.getValue());
            }
        }
    }

    /**
     * 注册渠道
     */
    public enum ZQ{

        ZQ_XT(1,"系统"),
        ZQ_YYT(2,"营业厅"),
        ZQ_WZ(3,"网站"),
        ZQ_SJAPP(4,"手机app"),
        ZQ_WX(5,"微信");

        private Integer key;
        private String value;

        ZQ(Integer key, String value) {
            this.key = key;
            this.value = value;
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

        public static void show(){
            for(ZQ v : ZQ.values()){
                System.out.println(v + "： key=" + v.getKey() + " value=" + v.getValue());
            }
        }
    }

    /**
     * 机构状态
     */
    public enum STATE{

        STATE_ZC(1,"正常"),
        STATE_DJ(2,"冻结"),
        STATE_XH(3,"销户"),
        STATE_LJSC(4,"逻辑删除");

        private Integer key;
        private String value;

        STATE(Integer key, String value) {
            this.key = key;
            this.value = value;
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

        public static void show(){
            for(STATE v : STATE.values()){
                System.out.println(v + "： key=" + v.getKey() + " value=" + v.getValue());
            }
        }
    }

    /**
     * 机构性质
     */
    public enum OU_PROP{

        OU_PROP_DDGS_ZB(12,"电动汽车公司总部"),
        OU_PROP_DDGS_SGS(13,"电动汽车省公司"),
        OU_PROP_DDGS_DS(14,"电动汽车地市公司"),
        OU_PROP_DDGS_YYT(15,"电动汽车公司营业厅"),
        OU_PROP_QY(21,"企业"),
        OU_PROP_QY_XS(22,"企业下属单位"),
        OU_PROP_DW_ZB(31,"国家电网公司"),
        OU_PROP_DW_SGS(32,"省电网公司"),
        OU_PROP_DW_DS(33,"地市电力公司"),
        OU_PROP_DW_XGS(34,"区县电力公司"),
        OU_PROP_DW_GDS(35,"供电所"),
        OU_PROP_SHQY(41,"社会商户"),
        OU_PROP_SHQY_XS(42,"社会商户下属单位"),
        OU_PROP_GR(50,"个人商户");

        private Integer key;
        private String value;

        OU_PROP(Integer key, String value) {
            this.key = key;
            this.value = value;
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

        public static void show(){
            for(OU_PROP v : OU_PROP.values()){
                System.out.println(v + "： key=" + v.getKey() + " value=" + v.getValue());
            }
        }
    }

    /**
     * 叶子节点
     */
    public enum OU_IS_LEAF{

        OU_IS_LEAF_TRUE(1,"叶子节点"),
        OU_IS_LEAF_FALSE(0,"不是叶子节点");

        private Integer key;
        private String value;

        OU_IS_LEAF(Integer key, String value) {
            this.key = key;
            this.value = value;
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

        public static void show(){
            for(OU_IS_LEAF v : OU_IS_LEAF.values()){
                System.out.println(v + "： key=" + v.getKey() + " value=" + v.getValue());
            }
        }
    }
}