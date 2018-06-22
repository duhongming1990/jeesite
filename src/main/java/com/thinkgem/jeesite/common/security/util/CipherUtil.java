package com.thinkgem.jeesite.common.security.util;


import com.thinkgem.jeesite.common.security.enums.EnumCipherAlgorithm;
import com.thinkgem.jeesite.common.security.enums.EnumKeyAlgorithm;
import com.thinkgem.jeesite.common.utils.NumberUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import static sun.security.x509.X509CertInfo.KEY;


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

	/**
	 * DES加密
	 * @param key
	 * @param ciphertext
	 * @return
	 */
	public static String encodeDES(String key,String ciphertext){
		try{
			SecureRandom random = new SecureRandom();
			DESKeySpec desKey = new DESKeySpec(key.getBytes());
			//创建一个密匙工厂，然后用它把DESKeySpec转换成
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(EnumKeyAlgorithm.DES.name());
			SecretKey securekey = keyFactory.generateSecret(desKey);
			//Cipher对象实际完成加密操作
			Cipher cipher = Cipher.getInstance(EnumKeyAlgorithm.DES.name());
			//用密匙初始化Cipher对象
			cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
			//现在，获取数据并加密
			byte[] temp = Base64.encodeBase64(cipher.doFinal(ciphertext.getBytes()));
			decrypt(EnumCipherAlgorithm.DES_ECB_PKCS5Padding,securekey,ciphertext.getBytes());
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
	public static String decodeDES(String key,String ciphertext) throws Exception {
		// DES算法要求有一个可信任的随机数源
		SecureRandom random = new SecureRandom();
		// 创建一个DESKeySpec对象
		DESKeySpec desKey = new DESKeySpec(key.getBytes());
		// 创建一个密匙工厂
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(EnumKeyAlgorithm.DES.name());
		// 将DESKeySpec对象转换成SecretKey对象
		SecretKey securekey = keyFactory.generateSecret(desKey);
		// Cipher对象实际完成解密操作
		Cipher cipher = Cipher.getInstance(EnumKeyAlgorithm.DES.name());
		// 用密匙初始化Cipher对象
		cipher.init(Cipher.DECRYPT_MODE, securekey, random);
		// 真正开始解密操作
		return IOUtils.toString(cipher.doFinal(Base64.decodeBase64(ciphertext)),"UTF-8");
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
					log.info("非对称加密的公钥： {}\n非对称加密的私钥： {}",keyPair.getPublic().getEncoded(),keyPair.getPrivate().getEncoded());
					byte[] e = encrpty(cipherAlgorithm, keyPair.getPublic().getEncoded(),dataString.getBytes());
					log.info("非对称加密后数据： {}", NumberUtil.bytesToStrHex(e));
					byte[] d = decrypt(cipherAlgorithm, keyPair.getPrivate().getEncoded(), e);
					log.info("非对称解密后数据： {}", new String(d));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.info(decodeDES("52ddqc1234567890","iDgKJpzE4E5+r+pH5tZM9ZJSGgTt5wT1"));
	}

}
