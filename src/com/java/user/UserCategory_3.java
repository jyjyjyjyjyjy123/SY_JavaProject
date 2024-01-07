package com.java.user;

import java.util.Scanner;

public class UserCategory_3 {
	public static void category(){
		boolean loop = true;
		while (loop) {
			Scanner scan = new Scanner(System.in);
			
			UserPrint.talrent();
			UserPrint.category3();
			System.out.print("                 메뉴 입력: ");

			String inputMenuNum = scan.nextLine();
			String[] inputMenuNumTest = inputMenuNum.split("");
			switch (inputMenuNumTest[0]) {
			case "1":
				UserPage.mypage();
				continue;
			case "2":
				UserItemList.itemList("TNT");
				continue;
			case "3":
				UserItemList.itemList("CAC");
				continue;
			case "4":
				UserItemList.itemList("YAC");
				continue;
			case "5":
				UserItemList.itemList("GOL");
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
