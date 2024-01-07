package com.java.user;

import java.util.Scanner;

public class UserInfo {
	public static void information() {
		boolean loop = true;
		
		while (loop) {
			Scanner scan = new Scanner(System.in);
			UserPrint.information();
			System.out.print("                 메뉴 입력: ");
			String inputMenuNum = scan.nextLine();
			String[] inputMenuNumTest = inputMenuNum.split("");
			switch (inputMenuNumTest[0]) {
			case "1":
				UserInfoCorrection.correction();
				continue;
			case "0":
				loop = false;
				continue;
			default:
				System.out.println("               잘못된 메뉴 입니다.");
				scan.nextLine();
				continue;
			}
		}
	}
}
