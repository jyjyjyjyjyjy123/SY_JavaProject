package com.java.admin;

import java.util.ArrayList;
import java.util.Scanner;

import com.java.data.CatInfoData;
import com.java.data.RentData;
import com.java.data.UserData;
import com.java.reader.CatInfoReader;
import com.java.reader.RentReader;
import com.java.reader.UserReader;

public class adminContract {

	public static void contract() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println(" _____   ___   _     ______  _____  _   _  _____ \r\n"
				+ "|_   _| / _ \\ | |    | ___ \\|  ___|| \\ | ||_   _|\r\n"
				+ "  | |  / /_\\ \\| |    | |_/ /| |__  |  \\| |  | |  \r\n"
				+ "  | |  |  _  || |    |    / |  __| | . ` |  | |  \r\n"
				+ "  | |  | | | || |____| |\\ \\ | |___ | |\\  |  | |  \r\n"
				+ "  \\_/  \\_| |_/\\_____/\\_| \\_|\\____/ \\_| \\_/  \\_/  \r\n"
				+ "");
		
		
		System.out.println("     ┌──────────────────────────────────┐");
		System.out.println("                    계약 관리	");
		System.out.println("     ├──────────────────────────────────┤");
		System.out.println("                 1.회원 이름 검색		");
		System.out.println("     ├──────────────────────────────────┤");		
		System.out.println("                 0. 이전 화면     　　");
		System.out.println("     └──────────────────────────────────┘");
		 
		 System.out.print("     숫자 입력: "); 
		 String input = scan.nextLine();
		 
		 if (input.equals("1")) {
			 usernamesearch();
		 } else {
			 adminManager.productManagement();
		 }
		 
		 
	}
	
	
	
	
	private static void usernamesearch() {
	    Scanner scan = new Scanner(System.in);
	    System.out.print("     회원 이름 검색: ");
	    String userName = scan.nextLine();

	    UserReader.list = new ArrayList<UserData>();
	    UserReader.reader(null);
	    RentReader.list = new ArrayList<RentData>();
	    RentReader.reader();

	    boolean userExists = false; // 이름이 존재하는지 여부를 확인하는 변수

	    for (UserData userdate : UserReader.list) {
	        if (userdate.getName().equals(userName)) {
	            userExists = true;
	            break; // 이름이 존재하는 경우 반복문 종료
	        }
	    }

	    if (!userExists) {
	        System.out.println("존재하지 않는 회원입니다. 다시 입력해주세요.");
	        adminManager.pause();
	        return;
	    }

	    System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────");
		System.out.println(" 번호 │      신청일자      │ 주문자 이름 │           제품(모델명)          │ 대여 시작 날짜 │   반납 날짜   │  진행 사항   ");
		System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────");
		int count = 0;
	    for (UserData userdate : UserReader.list) {
	        if (userdate.getName().equals(userName)) {
	            for (RentData rd : RentReader.list) {
	                if (userdate.getNum().equals(rd.getUserNum())) {
	                    String[] temp = rd.getCode().split("_");
	                    CatInfoReader.list = new ArrayList<CatInfoData>();
	                    CatInfoReader.reader(temp[0]);
	                    for (CatInfoData category : CatInfoReader.list) {
	                        if (category.getCode().equals(rd.getCode())) {
	                        	count ++;
	                        	String[] dayTemp = rd.getPeriod().split("~");
	                            System.out.printf("%-5s│%-17s│%-9s│%-25s\t│%-12s│%-13s│%5s\n"
	                                    , count
	                                    , dayTemp[0]
	                                    , userdate.getName()
	                                    , category.getItemName()
	                                    , dayTemp[0]
	                                    , dayTemp[1]
	                                    , rd.getStatus());
	                        }
	                    }
	                }
	            }
	        }
	    }

	    adminManager.pause();
	}


}
