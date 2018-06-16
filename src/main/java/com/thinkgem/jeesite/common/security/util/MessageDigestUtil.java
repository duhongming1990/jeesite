package com.thinkgem.jeesite.common.security.util;


import com.thinkgem.jeesite.common.security.enums.EnumDigestAlgorithm;
import com.thinkgem.jeesite.common.utils.NumberUtil;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;


/**
 * 消息摘要工具类
 * @author ZGL
 *
 */
@Slf4j
public class MessageDigestUtil {
	public static byte[] encode(EnumDigestAlgorithm digestAlgorithm, byte[] byteData) throws NoSuchAlgorithmException{
		Security.addProvider(new BouncyCastleProvider());
		return MessageDigest.getInstance(digestAlgorithm.name()).digest(byteData);
	}
	
	public static void main(String[] args) throws NoSuchAlgorithmException {
		String dataString = "ZGL";
		/**
		 *
		 * MD是消息摘要（Message Digest），它们都不安全了。
		 * SHA-1已经不安全了，SHA-2还尚未被攻破。
		 */
		for (EnumDigestAlgorithm digestAlgorithm : EnumDigestAlgorithm.values()) {
			byte[] md = encode(digestAlgorithm, dataString.getBytes());
			log.info("{},摘要信息: {}", digestAlgorithm.getValue(), NumberUtil.bytesToStrHex(md));
		}
	
	}
}
