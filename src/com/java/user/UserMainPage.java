package com.java.user;

import java.util.Scanner;

public class UserMainPage {
	public static void mainpage(){
		boolean loop = true;
		while (loop) {
			Scanner scan = new Scanner(System.in);
			UserPrint.talrent();
			UserPrint.main();
			System.out.print("                 메뉴 입력: ");

			String inputMenuNum = scan.nextLine();
			String[] inputMenuNumTest = inputMenuNum.split("");
			switch (inputMenuNumTest[0]) {
			case "1":
				UserPage.mypage();
				continue;
			case "2":
				UserCategory_1.category();
				continue;
			case "3":
				UserCategory_2.category();
				continue;
			case "4":
				UserCategory_3.category();
				continue;
			case "5":
				UserCategory_4.category();
				continue;
			case "6":
				UserCategory_5.category();
				continue;
			case "7":
				UserCategory_6.category();
				continue;
			case "0":
				loop = false;
				break;
			default:
				System.out.println("               잘못된 메뉴 입니다.");
				scan.nextLine();
				continue;
			}
		}
		
	}
}
