package util.encryption.base64;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
/**
 * 信息加密 解密工具类 BASE64
 * @author hzw
 */
public class EncryptionBASE64Util {

	private static Cipher enCipher;
	private static Cipher deCipher;
	public static final String KEY = "sclbxkey";
	public static final String VI = "sclbxkey";

	static {
		try {
			byte[] keyByte = KEY.getBytes();
			byte[] viByte =  VI.getBytes();
			// 创建md5散列对象
			MessageDigest md = MessageDigest.getInstance("MD5");
			// 散列密钥
			md.update(keyByte);
			byte[] key = md.digest();
			/*
			 * byte[] key2 = new byte[8]; for (int i = 0; i < 8; i++) { key2[i]
			 * = key[i]; } for (byte b : key) { System.out.println(b); }
			 */
			// System.out.println("key.length："+key.length);
			// 获得des密钥
			DESKeySpec desKey = new DESKeySpec(key);
			// 获得des加密密钥工厂
			SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
			// 获得加密后的des密钥
			SecretKey seKey = skf.generateSecret(desKey);
			// 获得初始化向量对象
			IvParameterSpec ivP = new IvParameterSpec(viByte);
			AlgorithmParameterSpec paramSpec = ivP;
			// 为加密算法指定填充方式，创建加密会话对象
			enCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
			deCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
			// 初始化加密回话对象
			enCipher.init(Cipher.ENCRYPT_MODE, seKey, paramSpec);
			deCipher.init(Cipher.DECRYPT_MODE, seKey, paramSpec);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see 信息加密  BASE64
	 * @param String
	 *            mes 要加密的信息
	 * @return String 返回加密后的信息
	 */
	public static String encrypt(String mes) {
		if (mes == null || "".equals(mes)) {
			return null;
		}
		byte[] data = mes.getBytes();
		byte[] enc = null;
		/*
		 * System.out.println("转化前："); for (byte b : data) {
		 * System.out.print(b); } System.out.println();
		 */
		synchronized (enCipher) {
			try {
				enc = enCipher.doFinal(data);
			} catch (IllegalBlockSizeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BadPaddingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/*
		 * System.out.println("BASE64Encoder处理前"); for (byte b : enc) {
		 * System.out.println(b); } System.out.println();
		 */
		if (enc != null) {
			return new BASE64Encoder().encode(enc);
		} else {
			return null;
		}
	}

	/**
	 * @see 信息解密  BASE64
	 * @param String
	 *            mes 加密后的信息
	 * @return String 返回解密后的信息
	 */
	public static String decrypt(String mes) throws IOException {
		if (mes == null || "".equals(mes)) {
			return null;
		}

		byte[] des = new BASE64Decoder().decodeBuffer(mes);
		byte[] enc = null;

		synchronized (deCipher) {
			try {
				enc = deCipher.doFinal(des);
			} catch (IllegalBlockSizeException e) {
				e.printStackTrace();
			} catch (BadPaddingException e) {
				e.printStackTrace();
			}
		}

		if (enc != null) {
			return new String(enc);
		} else {
			return null;
		}
	}

	public static void main(String[] arg) throws Exception {
		// 加密
//		System.out.println(EncryptionBASE64Util.encrypt("阿旺"));

		// 解密
//		System.out.println(EncryptionBASE64Util.decrypt("MyhPBxWyZMM="));
	}
}
