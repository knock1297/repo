package com.erp.utils;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Service;

@Service
public class StringCrypto {
	public static String encrypt(String seed, String cleartext) throws Exception {
		byte[] rawKey = getRawKey(seed.getBytes()); // key 占쏙옙占쏙옙 占쏙옙占쏙옙트 占쏙옙占쏙옙
		byte[] result = encrypt(rawKey, cleartext.getBytes()); // rawKey占쏙옙占쏙옙
																// cleartext占쏙옙
																// 占쏙옙占쏙옙트
																// 占쏙옙占쏙옙占쏙옙
																// 占심곤옙占쏙옙
		return toHex(result);
	}

	private static byte[] getRawKey(byte[] seed) throws Exception {
		KeyGenerator kgen = KeyGenerator.getInstance("AES"); // aes占쏙옙占� 타占쏙옙
																// 占쏙옙占쌘듸옙 占쏙옙占�
		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG"); // 占쏙옙占쏙옙타占쏙옙
																// 占쏙옙큐占쏙옙티
																// 占쌘바띰옙占싱브러占쏙옙
		sr.setSeed(seed); // 占쏙옙占썲값 encrypt(String seed 占쏙옙 占쏙옙占쏙옙
		kgen.init(128, sr); // 192 占실댐옙 256 bits 占쏙옙 aes占쏙옙 占쏙옙占쏙옙
		SecretKey skey = kgen.generateKey(); // 占쏙옙크占쏙옙 키占쏙옙 占쏙옙占쏙옙 占쏙옙占� 占쌍는댐옙
												// 占쌘뱄옙 占쏙옙큐占쏙옙티 占쏙옙占싱브러占쏙옙
		byte[] raw = skey.getEncoded(); // 키占쏙옙 占쏙옙占쏙옙占싼곤옙占쏙옙 占쏙옙占쏙옙트占쏙옙占쏙옙占쏙옙
										// 占쏙옙占쏙옙
		return raw; // 占쏙옙占쏙옙
	}

	private static byte[] encrypt(byte[] raw, byte[] clear) throws Exception {
		SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
		byte[] encrypted = cipher.doFinal(clear);
		return encrypted;
	}

	public static String toHex(String txt) {
		return toHex(txt.getBytes());
	}

	public static String fromHex(String hex) {
		return new String(toByte(hex));
	}

	public static byte[] toByte(String hexString) {
		int len = hexString.length() / 2;
		byte[] result = new byte[len];
		for (int i = 0; i < len; i++)
			result[i] = Integer.valueOf(hexString.substring(2 * i, 2 * i + 2), 16).byteValue();
		return result;
	}

	public static String toHex(byte[] buf) {
		if (buf == null)
			return "";
		StringBuffer result = new StringBuffer(2 * buf.length);
		for (int i = 0; i < buf.length; i++) {
			appendHex(result, buf[i]);
		}
		return result.toString();
	}

	private final static String HEX = "0123456789ABCDEF";

	private static void appendHex(StringBuffer sb, byte b) {
		sb.append(HEX.charAt((b >> 4) & 0x0f)).append(HEX.charAt(b & 0x0f));
	}
}
