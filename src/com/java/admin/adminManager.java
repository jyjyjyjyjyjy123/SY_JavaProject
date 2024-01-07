package com.java.admin;

import java.util.Scanner;

public class adminManager {

	
	//회원관리
	public static void memberManagement() {
		
		
		
	}
	
	//제품관리
	public static void productManagement() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println(" _____   ___   _     ______  _____  _   _  _____ \r\n"
				+ "|_   _| / _ \\ | |    | ___ \\|  ___|| \\ | ||_   _|\r\n"
				+ "  | |  / /_\\ \\| |    | |_/ /| |__  |  \\| |  | |  \r\n"
				+ "  | |  |  _  || |    |    / |  __| | . ` |  | |  \r\n"
				+ "  | |  | | | || |____| |\\ \\ | |___ | |\\  |  | |  \r\n"
				+ "  \\_/  \\_| |_/\\_____/\\_| \\_|\\____/ \\_| \\_/  \\_/  \r\n"
				+ "");
		
		
		System.out.println("      ┌──────────────────────────────────┐");
		System.out.println("                      제품 관리		");
		System.out.println("      ├──────────────────────────────────┤");
		System.out.println("                 1. 제품 리스트 목록		");
		System.out.println("      ├──────────────────────────────────┤");		
		System.out.println("                 2. 계약 관리      　　");
		System.out.println("      ├──────────────────────────────────┤");		
		System.out.println("                 3. A/S 관리   　　     　　   ");
		System.out.println("      ├──────────────────────────────────┤");		
		System.out.println("                 0. 메인 화면으로 이동　　 　　  ");
		System.out.println("      └──────────────────────────────────┘");
		System.out.println();
		System.out.print("       숫자 입력: ");
		String number = scan.nextLine();
		System.out.println();
		System.out.println();
		
		if (number.equals("1")) {
			adminList.list();
		} else if (number.equals("2")) { 
			adminContract.contract();
		} else if (number.equals("3")) {
			adminAsMenu.asmain();
			
		} else if (number.equals("0")) {
			AdminMain.adminMain();
		} else {
			System.out.println("잘못된 입력입니다. 올바른 숫자를 입력해주세요");
			adminManager.pause();
			
		}


				
		}
		
		
		


	public static void pause() {
		Scanner scan = new Scanner(System.in);
		System.out.println();
		System.out.println("계속하려면 엔터를 입력하시오.");
		scan.nextLine();
		
	}

	public static void subTitle(String title) {
		System.out.println();
		System.out.println();
		System.out.println("━━━━━━━━━━━━━━━━━");
		System.out.println("    "+title);
		System.out.println("━━━━━━━━━━━━━━━━━");
		System.out.println("");
		
	}
	
	

}
