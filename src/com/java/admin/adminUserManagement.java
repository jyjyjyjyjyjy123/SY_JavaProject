package com.java.admin;

import java.util.ArrayList;
import java.util.Scanner;

import com.java.data.UserData;
import com.java.reader.UserReader;


public class adminUserManagement {
		
			
	public static void userMenu(){
		
			
			
			
			int num = 0;
			Scanner scan = new Scanner(System.in);
			
			System.out.println(" _____   ___   _     ______  _____  _   _  _____ \r\n"
		               + "|_   _| / _ \\ | |    | ___ \\|  ___|| \\ | ||_   _|\r\n"
		               + "  | |  / /_\\ \\| |    | |_/ /| |__  |  \\| |  | |  \r\n"
		               + "  | |  |  _  || |    |    / |  __| | . ` |  | |  \r\n"
		               + "  | |  | | | || |____| |\\ \\ | |___ | |\\  |  | |  \r\n"
		               + "  \\_/  \\_| |_/\\_____/\\_| \\_|\\____/ \\_| \\_/  \\_/  \r\n"
		               + "");
		         System.out.println("                                      ");
		         System.out.println("         ┌─────────────────────┐      ");
		         System.out.println("         │   1.회원 정보(수정/삭제)　│      ");
		         System.out.println("         ├─────────────────────┤      ");
		         System.out.println("         │   2.회원검색       　　 │      ");
		         System.out.println("         ├─────────────────────┤      ");
		         System.out.println("         │   0.이전화면       　 　│      ");
		         System.out.println("         └─────────────────────┘      ");
		         System.out.print("                메뉴 입력: ");
			
	
			num = scan.nextInt();
			System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
			
			if(num ==1) {
				adminUserList.UserInfoPrint();
				adminUserModify.menu();
				
				
			}else if(num == 2) {
				userInfoSearch();
			}else if(num ==0) {
//				Main.main();
			}
				
			
		
		
		}
	
	static void userInfoSearch() {
		UserReader.list = new ArrayList<UserData>();
		UserReader.reader(null);
		Scanner scan = new Scanner(System.in);
		System.out.println("1. 회원번호로 검색하기");
		System.out.println("2. 아이디로 검색하기");
		System.out.println("3. 이름으로 검색하기");
		System.out.print("번호 입력 : ");
		int menuNum = scan.nextInt();
		System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
		scan.nextLine();
		if(menuNum == 1) {
			System.out.print("회원번호 : ");
			String memberNum = scan.nextLine();
			
			System.out.println("                                                           찾은 회원정보");
			System.out.println("─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
			
			for (UserData ud : UserReader.list) {
				if(ud.getNum().equals(memberNum)) {
					System.out.printf("%4s \t│%10s\t│%12s\t│%6s\t│ %10s\t│ %15s\t│ %20s|%15s\n", ud.getNum(), ud.getID(), ud.getPW(), ud.getName()
							, ud.getBirth(), ud.getPhone(), ud.getAddress(), ud.getBank());
				
				}
			}
			
			
		}else if(menuNum == 2) {
			System.out.print("아이디 : ");
			String memberID = scan.nextLine();
			
			System.out.println("                                                           찾은 회원정보");
			System.out.println("─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
			
			for (UserData ud : UserReader.list) {
				if(ud.getID().equals(memberID)) {
					System.out.printf("%5s \t│%15s\t│%15s\t│%8s\t│ %15s\t│ %17s\t│ %20s|%20s\n", ud.getNum(), ud.getID(), ud.getPW(), ud.getName()
							, ud.getBirth(), ud.getPhone(), ud.getAddress(), ud.getBank());
				

				}
			}
				
		}else if(menuNum ==3) {
			System.out.print("이름 : ");
			String memberName = scan.nextLine();
			  
			System.out.println("                                                         찾은 회원정보");
			System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
			for (UserData ud : UserReader.list) {
				if(ud.getName().equals(memberName)) {
					System.out.printf("%5s \t│%15s\t│%15s\t│%8s\t│ %15s\t│ %17s\t│ %20s|%20s\n", ud.getNum(), ud.getID(), ud.getPW(), ud.getName()
							, ud.getBirth(), ud.getPhone(), ud.getAddress(), ud.getBank());
				

				}
			}
		}else {
			System.out.println("유효한 번호를 입력하세요");
		}
		
		System.out.println();
		System.out.println("0. 이전화면");;
		int temp = scan.nextInt();
		if(temp == 0) {
			userMenu();
		}
		
	

	}
	
	

}
