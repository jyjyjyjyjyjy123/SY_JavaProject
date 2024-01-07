package com.java.main;

import java.util.Scanner;

public class Join {

	//회원가입 클래스
	
		public static void joinMenu() {
			
			UserJoin ujoin = new UserJoin();
			
			boolean loop = true;
		
		while (loop) {
			System.out.println();
			System.out.println("       ┌────────────────────────────────┐");
			System.out.println("       │         1. 개인회원           　　 │");
			System.out.println("       │         2. 기업회원         　　   │");
			System.out.println("       │         3. 초기화면        　　　　　│");
			System.out.println("       └────────────────────────────────┘");
			System.out.println();
			System.out.print("          번호 입력: ");
			

			Scanner scan = new Scanner(System.in);
			
			String input = scan.nextLine();
			
			if(input.equals("1")) {
				UserJoin.userJoin();
				break;
			} else if(input.equals("2")) {
				CorpJoin.Corpjoin();
				break;
			} else if (input.equals("3")) {
				Main.main(null);
				
			} else {
				System.out.println();
				System.out.println("     올바른 번호를 입력해주세요.");
			} 
			
			
	
	
		}//while

}
}
