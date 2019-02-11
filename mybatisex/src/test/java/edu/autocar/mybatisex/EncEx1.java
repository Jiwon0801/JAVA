package edu.autocar.mybatisex;

import edu.autocar.base.sec.SHA256Util;

public class EncEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String password = "1234";
		String salt = SHA256Util.generateSalt();
		String encPassword = SHA256Util.getEncrypt(password, salt);
		
		System.out.println("salt : " + salt);
		System.out.println("암호화된 비밀번호: " + encPassword);
		System.out.println("암호화된 비밀번호 길이: " + encPassword.length());

	}

}
