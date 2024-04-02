package com.util;

import java.security.MessageDigest;

/*
 * MD5 加密类
 * 这个类是网上获得的  通过这个类把
 *  一个字符串转化成一个16进制32位的字符串
 * */
public final class MD5 {

	public final static String md5(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' }; // 创建一个16进制数的数组
		try {
			byte[] strTemp = s.getBytes();// 把传入的字符串转化成数组
			MessageDigest mdTemp = MessageDigest.getInstance("MD5"); // 建立一个mdTemp
			// 类的对象
			// 对象名称叫做MD5实例
			mdTemp.update(strTemp);// 更新strTemp 数组
			byte[] md = mdTemp.digest(); // 通过digest() 方法重新定义一个数组
			int j = md.length; // md数组的长度
			char str[] = new char[j * 2]; // 定义一个字符数组 数组的长度是md数组长度的2倍
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i]; // 给byte0变量赋值
				str[k++] = hexDigits[byte0 >>> 4 & 0xf]; // 通过hexDigits[]
				// 把字符串s转化成16进制32位的字符串
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str); // 返回转换后的字符串
		} catch (Exception e) {
			return null;
		}
	}
}
