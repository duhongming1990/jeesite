package com.thinkgem.jeesite.common.security.util;


import com.thinkgem.jeesite.common.security.enums.EnumCipherAlgorithm;
import com.thinkgem.jeesite.common.security.enums.EnumKeyAlgorithm;
import com.thinkgem.jeesite.common.utils.NumberUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
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
	public static byte[] encrypt(EnumCipherAlgorithm cipherAlgorithm, String strHexKey, byte[] byteData)
			throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		return encrypt(cipherAlgorithm, NumberUtil.strHexToBytes(strHexKey), byteData);
		
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
	public static byte[] encrypt(EnumCipherAlgorithm cipherAlgorithm,  byte[] byteKey, byte[] byteData)
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

		return encrypt(cipherAlgorithm, key, byteData);
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
	public static byte[] encrypt(EnumCipherAlgorithm cipherAlgorithm, Key key, byte[] byteData)
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

	/**
	 * DES加密
	 * @param key
	 * @param plaintext
	 * @return
	 */
	public static String encodeDES(String key,String plaintext){
		try{
			SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), EnumKeyAlgorithm.DES.name());
			//现在，获取数据并加密
            byte[] e = encrypt(EnumCipherAlgorithm.DES_ECB_PKCS5Padding,keyspec.getEncoded(),plaintext.getBytes());
            //现在，获取数据并编码
			byte[] temp = Base64.encodeBase64(e);
			return IOUtils.toString(temp,"UTF-8");
		}catch(Throwable e){
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * AES加密
	 * @param key
	 * @param plaintext
	 * @return
	 */
	public static String encodeAES(String key,String plaintext){
		try{
			SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), EnumKeyAlgorithm.AES.name());
			//现在，获取数据并加密
			byte[] e = encrypt(EnumCipherAlgorithm.AES_ECB_PKCS5Padding,keyspec.getEncoded(),plaintext.getBytes());
			//现在，获取数据并编码
			byte[] temp = Base64.encodeBase64(e);
			return IOUtils.toString(temp,"UTF-8");
		}catch(Throwable e){
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * DES解密
	 * @param key
	 * @param ciphertext
	 * @return
	 * @throws Exception
	 */
	public static String decodeDES(String key,String ciphertext) {
        try {
			SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), EnumKeyAlgorithm.DES.name());
            // 真正开始解码操作
            byte[] temp = Base64.decodeBase64(ciphertext);
            // 真正开始解密操作
            byte[] e = decrypt(EnumCipherAlgorithm.DES_ECB_PKCS5Padding,keyspec.getEncoded(),temp);
            return IOUtils.toString(e,"UTF-8");
        }catch(Throwable e){
            e.printStackTrace();
            return null;
        }
	}

	/**
	 * AES解密
	 * @param key
	 * @param ciphertext
	 * @return
	 * @throws Exception
	 */
	public static String decodeAES(String key,String ciphertext) {
		try {
			SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), EnumKeyAlgorithm.AES.name());
			// 真正开始解码操作
			byte[] temp = Base64.decodeBase64(ciphertext);
			// 真正开始解密操作
			byte[] e = decrypt(EnumCipherAlgorithm.AES_ECB_PKCS5Padding,keyspec.getEncoded(),temp);
			return IOUtils.toString(e,"UTF-8");
		}catch(Throwable e){
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) throws Exception {

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
				    log.info("对称加密的密钥： {}",secretKey.getEncoded());
					byte[] e = encrypt(cipherAlgorithm,NumberUtil.bytesToStrHex(secretKey.getEncoded()), dataString.getBytes());
					log.info("对称加密后数据： {}", NumberUtil.bytesToStrHex(e));
					byte[] d = decrypt(cipherAlgorithm, secretKey.getEncoded(), e);
					log.info("对称解密后数据： {}", new String(d));
				}else{
                    /**
                     * 公钥密码(非对称密码) - 用公钥加密，用私钥解密
                     * RSA
                     */
					KeyPair keyPair = KeyUtil.generateKeyPair(cipherAlgorithm.getKeyAlgorithm(), null);
					log.info("非对称加密的公钥： {}\n非对称加密的私钥： {}",keyPair.getPublic().getEncoded(),keyPair.getPrivate().getEncoded());
					byte[] e = encrypt(cipherAlgorithm, keyPair.getPublic().getEncoded(),dataString.getBytes());
					log.info("非对称加密后数据： {}", NumberUtil.bytesToStrHex(e));
					byte[] d = decrypt(cipherAlgorithm, keyPair.getPrivate().getEncoded(), e);
					log.info("非对称解密后数据： {}", new String(d));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//DES的key长度为8位的字符串，否则会报错
		log.info("前后台通用DES加密：{}",encodeDES("des@enc@","我有一个消息"));
		log.info("前后台通用DES解密：{}",decodeDES("des@enc@","06tpmY+9V9mPI6AaHXO+IgeLDlDkWUbN"));
		//AES的key长度为16位的字符串，否则会报错
		log.info("前后台通用AES加密：{}",encodeAES("aes@encrypt@key@","我有一个消息"));
		log.info("前后台通用AES加密：{}",decodeAES("aes@encrypt@key@","SFNUNGMqvMrMdP9+00Iov6BiefbHpN3e0KTMWo/nHtI="));
	}

}
