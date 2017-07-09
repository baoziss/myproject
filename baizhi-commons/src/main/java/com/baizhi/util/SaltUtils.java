package com.baizhi.util;

import java.util.Random;

public class SaltUtils {
	public static String  getSalt(){
		char[] code ="1234567890ASDFGHJKLPOIUYTREWQZXCVBNMasdfghjklpoiuytrewqzxcvbnm!Q@W#E$R%T^Y&U".toCharArray();
		//随机数
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		//StringBuilder 线程不安全  轻量级    效率高
		for (int i = 0; i <4; i++) {
			sb.append(code[random.nextInt(code.length)]);
		}
		//System.out.println(sb.toString());
		return sb.toString();
	}
}
