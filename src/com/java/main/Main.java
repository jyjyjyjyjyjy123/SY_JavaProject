package com.java.main;

import java.util.Scanner;

public class Main {
	

	public static void main(String[] args) {
		
		Join join = new Join();
		boolean loop = true;
		
		while (loop) {

			MainOutput.image();
			Scanner scan = new Scanner(System.in);
			
			String input = scan.nextLine();
			
			if(input.equals("1")) {
				Join.joinMenu();
				break;
			} else if(input.equals("2")) {
				LoginOutput.loinStart();
				break;
			} else if(input.equals("3")) {
				SearchIdPw.findOutput();
				break;
			} else if (input.equals("0")) {
				loop = false;
				System.out.println();
				System.out.println("        프로그램 종료");
			} else {
				System.out.println();
				System.out.println("     올바른 번호를 입력해주세요.");
			}
		}//while
		
		
		
	
	}
	

}
