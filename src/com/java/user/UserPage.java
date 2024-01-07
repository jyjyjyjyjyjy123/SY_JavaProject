package com.java.user;

import java.util.Scanner;

public class UserPage {
	public static void mypage(){
		Scanner scan = new Scanner(System.in);
		boolean loop = true;
		
		while (loop) {
			UserPrint.talrent();
			UserPrint.myPage();
			System.out.print("                 메뉴 입력: ");
			
			String inputMenuNum = scan.nextLine();
			String[] inputMenuNumTest = inputMenuNum.split("");
			
			switch (inputMenuNumTest[0]) {
			case "1":
				UserInfo.information();
				continue;
			case "2":
				UserStatus.status();
				continue;
			case "3":
				UserReturnItem.returnitem();
				continue;
			case "0":
				loop=false;
				break;
			default:
				System.out.println("               잘못된 메뉴 입니다.");
				scan.nextLine();
				continue;
			}
		}
		return;
	}
}
