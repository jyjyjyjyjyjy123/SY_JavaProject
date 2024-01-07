package com.java.user;

import com.java.reader.UserReader;

public class UserMain {
	public static String login = "";
	public static String[] loginUser = null;
	public static void usermain() {
			UserReader.reader(UserMain.login);
			UserMainPage.mainpage();
			System.out.println("로그아웃 되었습니다.");
	}
}
