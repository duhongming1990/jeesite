package com.thinkgem.jeesite.common.security.util;


import com.thinkgem.jeesite.common.security.enums.EnumCipherAlgorithm;
import com.thinkgem.jeesite.common.security.enums.EnumKeyAlgorithm;
import com.thinkgem.jeesite.common.utils.NumberUtil;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;


/**
 * 加解密工具类
 * 
 * @author ZGL
 * 
 */
@Slf4j
public class CipherUtil {

	/**
	 * 加密，非对称加密一般来说是公钥加密，私钥解密
	 * @param cipherAlgorithm 加密算法
	 * @param strHexKey 16进制字符串钥匙
	 * @param byteData 待加密数据
	 * @return
	 * @throws InvalidKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public static byte[] encrpty(EnumCipherAlgorithm cipherAlgorithm, String strHexKey, byte[] byteData)
			throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		return encrpty(cipherAlgorithm, NumberUtil.strHexToBytes(strHexKey), byteData);
		
	}
	
	/**
	 * 加密，非对称加密一般来说是公钥加密，私钥解密
	 * @param cipherAlgorithm 加密算法
	 * @param byteKey 二进制钥匙
	 * @param byteData 待加密数据
	 * @return
	 * @throws InvalidKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public static byte[] encrpty(EnumCipherAlgorithm cipherAlgorithm,  byte[] byteKey, byte[] byteData) 
			throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		Security.addProvider(new BouncyCastleProvider());
		// 生成秘密密钥或公钥
		Key key = null;
		switch (cipherAlgorithm.getKeyAlgorithm()) {
			case DES:
			case DESede:
			case AES:
			case IDEA:
			{
				key = new SecretKeySpec(byteKey, cipherAlgorithm.getKeyAlgorithm().name());
				break;
			}
			case RSA:
			case ElGamal:
			{
				try {
					// 尝试获取公钥
					X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(
							byteKey);
					key = KeyFactory.getInstance(cipherAlgorithm.getKeyAlgorithm().name())
							.generatePublic(x509EncodedKeySpec);
					break;
				} catch (Exception e) {
					try {
						// 尝试获取私钥
						PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(
								byteKey);
						key = KeyFactory.getInstance(cipherAlgorithm.getKeyAlgorithm().name())
								.generatePrivate(pkcs8EncodedKeySpec);
						break;
					} catch (Exception e2) {
						break;
					}
				}
				
			}
			default:
				break;
		}

		return encrpty(cipherAlgorithm, key, byteData);
	}
	
	/**
	 * 解密，非对称加密一般来说是公钥加密，私钥解密
	 * @param cipherAlgorithm 加密算法
	 * @param byteData 待解密数据
	 * @param key 钥匙
	 * @return
	 * @throws NoSuchPaddingException 
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeyException 
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException 
	 * @throws Exception
	 */
	public static byte[] encrpty(EnumCipherAlgorithm cipherAlgorithm, Key key, byte[] byteData) 
			throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		String algorithm = key.getAlgorithm();
		if(cipherAlgorithm != null){
			algorithm = cipherAlgorithm.getValue();
		}
		Cipher cipher = Cipher.getInstance(algorithm);
		cipher.init(Cipher.ENCRYPT_MODE, key);
		return cipher.doFinal(byteData);
	}
	
	
	
	
	
	
	
	/**
	 * 解密，非对称加密一般来说是公钥加密，私钥解密
	 * @param cipherAlgorithm 加密算法
	 * @param strHexKey 16进制字符串钥匙
	 * @param byteData 待解密数据
	 * @return
	 * @throws InvalidKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public static byte[] decrypt(EnumCipherAlgorithm cipherAlgorithm,  String strHexKey, byte[] byteData) 
			throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		return decrypt(cipherAlgorithm, NumberUtil.strHexToBytes(strHexKey), byteData);
	}

	/**
	 * 解密，非对称加密一般来说是公钥加密，私钥解密
	 * @param cipherAlgorithm 加密算法
	 * @param byteKey 二进制钥匙
	 * @param byteData 待解密数据
	 * @return
	 * @throws InvalidKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public static byte[] decrypt(EnumCipherAlgorithm cipherAlgorithm,  byte[] byteKey, byte[] byteData) 
			throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		Security.addProvider(new BouncyCastleProvider());
		// 生成秘密密钥或公钥
		Key key = null;
		switch (cipherAlgorithm.getKeyAlgorithm()) {
			case DES:
			case DESede:
			case AES:
			case IDEA:
			{
				key = new SecretKeySpec(byteKey, cipherAlgorithm.getKeyAlgorithm().name());
				break;
			}
			case RSA:
			case ElGamal:
			{
				try {
					// 尝试获取私钥
					PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(
							byteKey);
					key = KeyFactory.getInstance(cipherAlgorithm.getKeyAlgorithm().name())
							.generatePrivate(pkcs8EncodedKeySpec);
					break;
				} catch (Exception e) {
					try {
						// 尝试获取公钥
						X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(
								byteKey);
						key = KeyFactory.getInstance(cipherAlgorithm.getKeyAlgorithm().name())
								.generatePublic(x509EncodedKeySpec);
						break;
					} catch (Exception e2) {
						break;
					}
				}
			}
			default:
				break;
		}
		return decrypt(cipherAlgorithm, key, byteData);
	}
	/**
	 * 解密，非对称加密一般来说是公钥加密，私钥解密
	 * @param cipherAlgorithm 加密算法
	 * @param key 钥匙
	 * @param byteData 待解密数据
	 * @return
	 * @throws InvalidKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public static byte[] decrypt(EnumCipherAlgorithm cipherAlgorithm, Key key, byte[] byteData) 
			throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		String algorithm = key.getAlgorithm();
		if(cipherAlgorithm != null){
			algorithm = cipherAlgorithm.getValue();
		}
		Cipher cipher = Cipher.getInstance(algorithm);
		cipher.init(Cipher.DECRYPT_MODE, key);
		return cipher.doFinal(byteData);
	}

	public static void main(String[] args){

		try {
			String dataString = "ZGL";
			for (EnumCipherAlgorithm cipherAlgorithm : EnumCipherAlgorithm.values()) {
				log.info(cipherAlgorithm.getValue());
				if(EnumKeyAlgorithm.getSymmetric().contains(cipherAlgorithm.getKeyAlgorithm())){
                    /**
                     * 对称密码（共享密钥密码）- 用相同的密钥进行加密和解密
                     * DES（data encryption standard）- 淘汰
                     * 3DES（triple DES）- 目前被银行机构使用
                     * AES（advanced encryption standard）- 方向
                     * IDEA用于邮件加密，避开美国法律限制 – 国产
                     */
				    SecretKey secretKey = KeyUtil.generateKey(cipherAlgorithm.getKeyAlgorithm(), null);
					byte[] e = encrpty(cipherAlgorithm,NumberUtil.bytesToStrHex(secretKey.getEncoded()), dataString.getBytes());
					log.info("对称加密后数据： {}", NumberUtil.bytesToStrHex(e));
					byte[] d = decrypt(cipherAlgorithm, secretKey.getEncoded(), e);
					log.info("对称解密后数据： {}", new String(d));
				}else{
                    /**
                     * 公钥密码(非对称密码) - 用公钥加密，用私钥解密
                     * RSA
                     */
					KeyPair keyPair = KeyUtil.generateKeyPair(cipherAlgorithm.getKeyAlgorithm(), null);
					byte[] e = encrpty(cipherAlgorithm, keyPair.getPublic().getEncoded(),dataString.getBytes());
					log.info("非对称加密后数据： {}", NumberUtil.bytesToStrHex(e));
					byte[] d = decrypt(cipherAlgorithm, keyPair.getPrivate().getEncoded(), e);
					log.info("非解密后数据： {}", new String(d));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
