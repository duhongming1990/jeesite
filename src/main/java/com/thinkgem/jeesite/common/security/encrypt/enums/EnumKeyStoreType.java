package com.thinkgem.jeesite.common.security.encrypt.enums;

public enum EnumKeyStoreType {
	JKS("JKS"),PKCS12("PKCS12");
	
	
	private String value;
	public String getValue() {
		return value;
	}
	private EnumKeyStoreType(String value){
		this.value = value;
	}
}
