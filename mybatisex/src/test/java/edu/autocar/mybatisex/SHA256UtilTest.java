package edu.autocar.mybatisex;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.autocar.base.sec.SHA256Util;

public class SHA256UtilTest {
	@Test
	public void testGenerateSalt() throws Exception {
		for (int i = 0; i < 10; i++) {
			String salt = SHA256Util.generateSalt();
			System.out.println(salt);
			
		}
		
	}
	

}
