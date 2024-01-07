package com.java.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import com.java.data.UserData;
import com.java.reader.UserReader;


public class UserJoin {

	
	//개인회원가입
	public static void userJoin() {
	
		String ID = "";
		String PW = "";
		String name = "";
		String birth = "";
		String phone = "";
		String bank = "";
		String bankNum = "";
		String address = "";
		Scanner scan = new Scanner(System.in);
		
		System.out.println(" ===============================================");
		System.out.println("                   개인 회원가입");
		System.out.println(" ===============================================");
		
		
		


		boolean mark = true;
		
		//아이디
		while (mark) {
			
			//아이디 입력 > 영어 소문자/대문자 구성, 첫글자는 소문자 입력
			System.out.print(" - 아이디 (4자-16자, 첫글자는 소문자로 입력하시오) : ");
			ID = scan.nextLine();
			
			if (ID.equals("")) {
				mark = false;
				Join.joinMenu();
			}
			if (checkId(ID)) {
				continue;
			} if (checkdouble(ID)) {
				continue;
			}
			break;
		}
		
		//비밀번호
		
		while (mark) {
			
			//영어 소문자/대문자로 구성, 8-12자로 제한
			System.out.print(" - 비밀번호 (8자-12자,영어 소문자/대문자로 입력하시오.) : ");
			PW = scan.nextLine();
			
			if (checkpw(PW)) {
				continue;
			} 
			
			break;
		}//while
		
	
		//이름
		while (mark) {
			System.out.print(" - 이름 (2자-5자,한글만 입력) : ");
			name = scan.nextLine();
			
			if (checkname(name)) {
				continue;
			}
			
			break;
			
		}//while
		
		//생년월일
		while (mark) {
			System.out.print(" - 생년월일 (년월일 8자리 숫자 입력) : ");
			birth = scan.nextLine();
			
			if (checkBirth(birth)) {
				continue;
			}
			break;
		}
		
		//전화번호/0-9사용
		while (mark) {
			System.out.print(" - 전화번호 : ");
			phone = scan.nextLine();
			
			if(checkPhone(phone)) {
				continue;
			}
			break;
		}
	
		//계좌번호
			
		while(mark) {
			System.out.print(" - 계좌번호 (은행명은 한글, 계좌번호는 숫자로 입력하시오.) 은헹명:   ");
			bank = scan.nextLine();
			System.out.print("                                           　계좌번호:   ");
			bankNum = scan.nextLine();
			
			if(checkBank(bank, bankNum)) {
				continue;
			} 
			
			break;
		}
		
		//주소
		
			System.out.print(" - 주소 : ");
			address = scan.nextLine();
			
		
			String num = getNum();
			
			UserData user = new UserData(num, ID , PW , name, birth, phone , bank+bankNum, address);
			UserReader.list = new ArrayList<UserData>();			
			UserReader.reader(null);
			UserReader.list.add(user);
			Data.save();
			LoginOutput.joinComplete();
			
		
	
	}//userJoin






	private static String getNum() { 
		
		//목록 다음 번호에 추가
		
		int max = 0;
		UserReader.list = new ArrayList<UserData>();			
		UserReader.reader(null);
		for (UserData u : UserReader.list) {
			max = Integer.parseInt(u.getNum());
		}
		return (max + 1) + "";
	}






	private static boolean checkAddress(String address) {
		
		// 주소 유효성 검사
		
		
		return false;
		
		
	}//checkAddress






	private static boolean checkBank(String bank, String bankNum) {
		
		//계좌번호 유효성 검사 / 은행명- 한글 , 계좌번호 숫자만 입력받음
		for (int i=0; i < bank.length(); i++) {
			char c = bank.charAt(i);
			if (c < '가' || c > '힣') {
				System.out.println();
				System.out.println("      한글만 입력 가능합니다.");
				System.out.println();
				return true;
			} 
		}
		
		for (int j=0; j < bankNum.length(); j++) {
			char h = bankNum.charAt(j);
			if (h < '0' || h > '9') {
			System.out.println();
			System.out.println("      숫자만 입력 가능합니다.");
			System.out.println();
			return true;
		
			}
			return false;
		}
		return false;

	}
	

	private static boolean checkPhone(String phone) {
		// 전화번호 유효성 검사 / 11자리

		if(phone.length() >= 14 || phone.length() <= 10) {
			System.out.println();
			System.out.println("             11자리로 입력하세요.");
			System.out.println();
			return true;
		}
	
		
			for (int i=0; i < phone.length(); i++){
				char c = phone.charAt(i);
				if (c < '0' || c > '9') {
					System.out.println();
					System.out.println("           숫자만 입력하세요.");
					System.out.println();
					return true;
				}
				return false;
		}
			return false;
		
	}




	private static boolean checkBirth(String birth) {
		
		// 생년월일 유효성 검사 / 8자리 숫자 입력(년/월/일), 하이픈(-)유무 상관없음
		
		if (birth.length() != 8) {
			System.out.println();
			System.out.println("            생년월일을 8자리로 입력하시오.");
			System.out.println();
			return true;
		}
		int year = Integer.parseInt(birth.substring(0, 4));
		int month = Integer.parseInt(birth.substring(4,6));
		int day = Integer.parseInt(birth.substring(6)); //끝까지 뽑음
		
		//날짜
		if (day < 1 || day > 31) {
			System.out.println();
			System.out.println("               생년월일 일을 다시 입력하시오.");
			System.out.println();
			return true;
		}
		
		//월
		if (month < 1 || month > 12) {
			System.out.println();
			System.out.println("               생년월일 월을 다시 입력하시오.");
			System.out.println();
			return true;
		}
		
		
		
		return false;
	}
	
	public static boolean isLeafYear(int year) {
		
		//윤년 테스트
		if (year % 4 == 0) {
			if (year % 100 == 0) { //false값을 돌려준다
				if (year % 400 == 0) {
					return true;
				} else {
					return false;
				}
			} else {
				return true;
			}
		} else {
			return false;
		}
	}
	
	public static int getLastDay(int year, int month) {
		//해당월 마지막 일
		switch (month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				return 31;

			case 4:
			case 6:
			case 9:
			case 11:
				return 30;

			case 2:

				return isLeafYear(year) ? 29 : 28;

		}
		return 0;
	}



	private static boolean checkname(String name) {
		
		//이름 유효성 검사
		// 2자~5자
		if(name.length() < 2 || name.length() > 5) {
			System.out.println();
			System.out.println("             2자~5자 이내로 입력하시오.");
			System.out.println();
			return true;
		}
		
		//한글만 입력 가능
		for (int i=0; i < name.length(); i++) {
			char c = name.charAt(i);
			if (c < '가' || c > '힣') {
				System.out.println();
				System.out.println("      한글만 입력 가능합니다.");
				System.out.println();
				return true;
			}
		}
		return false;
	}



	private static boolean checkpw(String pW) {
		
		//비밀번호 유효성 검사/ 길이 8-12로 제한
		if (pW.length() < 8 || pW.length() > 12) {
			System.out.println();
			System.out.println("             8자~12자 이내로 입력하시오.");
			System.out.println();
			return true;
		} 
			for (int i=0; i < pW.length(); i++){
			char c = pW.charAt(i);
			if ((c < 'a' || c > 'z') && (c <'A' || c > 'Z')) {
			System.out.println();
			System.out.println("      영어 소문자,대문자만 사용할 수 있습니다.");
			System.out.println();
			return true;
		}  
	}
			return false;
}


	private static boolean checkdouble(String iD) {
		
		//아이디 중복값 검사
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("C:\\git\\Project\\Data\\userData.txt"));
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split(",");
				if(temp[1].equals(iD)) {
					System.out.println();
					System.out.println("     이미 사용중인 아이디입니다.");
					System.out.println();
					return true;
				}
				
			}
			
		} catch (Exception e) {
	
		}
		
		return false;
	} //checkdouble


	private static boolean checkId(String iD) {
	
		char ch = iD.charAt(0);
		//아이디 길이 유효성 검사
		if(iD.length() < 4 || iD.length() > 16 ) {
			System.out.println();
			System.out.println("     4자~16자 이내로 작성하시오.");		
			System.out.println();
			return true;
			
		//아이디 첫번째 글자 소문자 유효성 검사
		} 
		if(Character.isUpperCase(ch) == true ) {
			System.out.println();
			System.out.println("      아이디 첫글자는 영어 소문자입니다.");
			System.out.println();
			
		} else if (Character.isDigit(ch) == true) {
			System.out.println();
			System.out.println("      아이디 첫글자는 영어 소문자입니다.");
			System.out.println();
			return true;
		}
		
		//아이디 소문자 대문자 사용 유효성 검사
			for (int i=0; i < iD.length(); i++){
				char c = iD.charAt(i);
				if ((c < 'a' || c > 'z') && (c <'A' || c > 'Z')) {
				System.out.println();
				System.out.println("      영어 소문자,대문자만 사용할 수 있습니다.");
				return true;
			}
		}
		return false;
	}//checkedId
}
