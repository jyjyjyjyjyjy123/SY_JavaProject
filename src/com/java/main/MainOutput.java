package com.java.main;

import java.util.Scanner;

public class MainOutput {

	Scanner scan = new Scanner(System.in);
	
	public static void image() {
		System.out.println();
		System.out.println(""
				+ "  _____   ___   _     ______  _____  _   _  _____ \r\n"
				+ " |_   _| / _ \\ | |    | ___ \\|  ___|| \\ | ||_   _|\r\n"
				+ "   | |  / /_\\ \\| |    | |_/ /| |__  |  \\| |  | |  \r\n"
				+ "   | |  |  _  || |    |    / |  __| | . ` |  | |  \r\n"
				+ "   | |  | | | || |____| |\\ \\ | |___ | |\\  |  | |  \r\n"
				+ "   \\_/  \\_| |_/\\_____/\\_| \\_|\\____/ \\_| \\_/  \\_/  \r\n"
				+ "  \r\n"
				+ "");
		System.out.println();
	
		
	
	
		//메인화면 구성
		 	System.out.println("       ┌────────────────────────────────┐");
			System.out.println("       │      1. 회원가입            　 　  │ ");
			System.out.println("       │      2. 로그인　   　  　　  　　    │");
			System.out.println("       │      3. 아이디/비밀번호 찾기　　　　　　 │");
			System.out.println("       │      0. 종료    　         　 　 　│");
			System.out.println("       └────────────────────────────────┘");
			System.out.println();
			System.out.println();
			System.out.print( "        번호 입력: ");
			
		}
	
	//아이디 비밀번호 찾기 화면 구성
	
	public static void searchImage() {
		
		System.out.println();
		System.out.println();
		System.out.println("====================================");
		System.out.println("                                    ");
		System.out.println("          아이디/비밀번호 찾기 ");
		System.out.println("                             ");
		System.out.println("====================================");
		System.out.println("                   ");
		System.out.println("         1. 아이디 찾기");
		System.out.println("         2. 비밀번호 찾기 ");
		System.out.println("         0. 메인화면");
		System.out.println();
		System.out.println();
		System.out.print("         번호입력: ");
			
	}
	

	public static void findId(String name, String id) {
		System.out.println();
		System.out.println();
		System.out.printf("   [%s]님의 아이디는 [%s]입니다. " ,name, id);
		System.out.println();
		
	}
	
	//아이디 찾기 이후
	public static void afterFindId() {
		System.out.println();
		System.out.println();
		System.out.println("    1. 로그인 ");
		System.out.println("    2. 비밀번호 찾기 ");
		System.out.println("    0. 메인 ");
		System.out.println();
		System.out.println();
		System.out.print("   번호입력:");
		System.out.println();
		System.out.println("======================================");
		System.out.println();
	}
	
	
	public static void findPw(String id, String pw) {
		System.out.println();
		System.out.println();
		System.out.printf("   [%s]님의 비밀번호는 [%s]입니다. " , id, pw);
		System.out.println();
	}
	
	
	//비밀번호 찾기 이후
	public static void afterFindPw() {
		System.out.println();
		System.out.println();
		System.out.println("    1. 로그인 ");
		System.out.println("    2. 아이디 찾기 ");
		System.out.println("    0. 메인 ");
		System.out.println();
		System.out.println();
		System.out.print("   번호입력:");
		System.out.println();
		System.out.println("======================================");
		System.out.println();
	}
	
	
}
