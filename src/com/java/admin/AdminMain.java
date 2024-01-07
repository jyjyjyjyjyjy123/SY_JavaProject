package com.java.admin;

import java.util.Scanner;


public class AdminMain {
	public static void adminMain(){
		boolean loop = true;
		Scanner scan = new Scanner(System.in);
		
		while (loop) {
			
			System.out.println(" _____   ___   _     ______  _____  _   _  _____ \r\n"
					+ "|_   _| / _ \\ | |    | ___ \\|  ___|| \\ | ||_   _|\r\n"
					+ "  | |  / /_\\ \\| |    | |_/ /| |__  |  \\| |  | |  \r\n"
					+ "  | |  |  _  || |    |    / |  __| | . ` |  | |  \r\n"
					+ "  | |  | | | || |____| |\\ \\ | |___ | |\\  |  | |  \r\n"
					+ "  \\_/  \\_| |_/\\_____/\\_| \\_|\\____/ \\_| \\_/  \\_/  \r\n"
					+ "");
			
			System.out.println("      ┌──────────────────────────────────┐");
			System.out.println("                      관리자		");
			System.out.println("      ├──────────────────────────────────┤");
			System.out.println("                   1. 회원 관리		");
			System.out.println("      ├──────────────────────────────────┤");		
			System.out.println("                   2. 제품 관리      　　");
			System.out.println("      └──────────────────────────────────┘");
			System.out.println("                                  0.로그아웃");
			System.out.print("      숫자 입력: ");
			String input = scan.nextLine();
			System.out.println();
			System.out.println();
			
			
			if (input.equals("1")) {
				adminUserManagement.userMenu();
			} else if (input.equals("2")) {
				adminManager.productManagement();	
			} else if (input.equals("0")){
				System.out.println("로그아웃 되었습니다");
				return;
			}else {
				System.out.println("잘못된 입력입니다. 올바른 숫자를 입력해주세요");
				adminManager.pause();
			}
		}
	}
	
}

