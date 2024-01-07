package com.java.main;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class LoginOutput {
	
	public static void loinStart() {
		
	
		System.out.println();
		System.out.println();
		System.out.println(" ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println();
		System.out.println(" 　     　        로    그    인　    　   　   　  ");	
		System.out.println();	
		
		Login.loginInput();
		
		
}

	


	public static void joinComplete() {
		boolean loop = true;
		
		while(loop) {
			Scanner scan = new Scanner(System.in);
			
		System.out.println();
		System.out.println("===========================================================");
		System.out.println();
		System.out.println("                 회원가입이 완료되었습니다.");
		System.out.println("                 로그인 하시겠습니까?");
		System.out.println();	
		
		System.out.println("                 1. 네");
		System.out.println("                 2. 아니오(초기화면으로 이동)");
		System.out.println();
		
		System.out.print("               번호 입력: ");
		System.out.println();
		String input = scan.nextLine();
		
		
		
		if(input.equals("1")) {
			LoginOutput.loinStart();
			loop = false;
			
		} else if(input.equals("2")) {
			Main.main(null);
			break;
		} else {
			System.out.println();
			System.out.println("     올바른 번호를 입력해주세요.");
		} 
		
	}
	
	
}
}
