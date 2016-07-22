package cn.com.duiba.ds.tools;

import cn.com.duiba.ds.encrypt.BlowfishUtils;

public class AppSecrectDecode {
	//解密的秘钥
	private static final String secretKey="Ziy66Kf";
	//需要解密的code
	private static final String appSecretCode="2e2YVbXG9drQfBtjax8pqbPSMdK7xPGpLWw626W";
	public static void main(String[] args) {
		String appSecret=BlowfishUtils.decryptBlowfish(appSecretCode, secretKey);
		System.out.println(appSecret);
	}
}