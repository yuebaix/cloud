package com.jufan.cloud.sso;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

public class SimpleTest {
//	@Test
	public void testGenPwd() {
		String pwd = "nevergiveupnevergivein";
		PasswordEncoder pe = new BCryptPasswordEncoder();
		String genPwd = pe.encode(pwd);
		System.out.println(genPwd);
		System.out.println(pe.matches(pwd, genPwd));
	}

	@Test
	public void testSerial() throws Exception {
		ByteArrayOutputStream out2 = new ByteArrayOutputStream();//换一个输出流
		ObjectOutputStream oos2 = new ObjectOutputStream(out2);
		oos2.writeObject(new Object());
		oos2.flush();
		oos2.close();

		StringBuilder sb = new StringBuilder(1000);
		System.out.println(new String(out2.toByteArray(), "ascii"));
		for (byte b : out2.toByteArray()) {
//			System.out.println(b & 0xff);
			System.out.println(String.format("%#04x", b & 0xff));
			sb.append("\\x" + String.format("%#04x", b & 0xff).substring(2, 4));
		}
		System.out.println(sb.toString());
	}
}
