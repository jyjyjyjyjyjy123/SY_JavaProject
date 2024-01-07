package com.java.user;

import java.util.Scanner;

public class UserCategory_4 {
	public static void category(){
		boolean loop = true;
		while (loop) {
			Scanner scan = new Scanner(System.in);
			
			UserPrint.talrent();
			UserPrint.category4();
			System.out.print("                 메뉴 입력: ");

			String inputMenuNum = scan.nextLine();
			String[] inputMenuNumTest = inputMenuNum.split("");
			switch (inputMenuNumTest[0]) {
			case "1":
				UserPage.mypage();
				continue;
			case "2":
				UserItemList.itemList("DUM");
				continue;
			case "3":
				UserItemList.itemList("FOK");
				continue;
			case "4":
				UserItemList.itemList("REM");
				continue;
			case "5":
				UserItemList.itemList("LAT");
				continue;
			case "6":
				UserItemList.itemList("FLT");
				continue;
			case "7":
				UserItemList.itemList("CRA");
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
