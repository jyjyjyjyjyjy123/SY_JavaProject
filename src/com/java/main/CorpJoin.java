package com.java.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import com.java.data.EntData;
import com.java.reader.EntReader;

public class CorpJoin {

	
	//개인회원가입
	
	public static void Corpjoin() {
		String ID = "";
		String PW = "";
		String name = "";
		String phone = "";
		String bank = "";
		String bankNum = "";
		String address = "";
		Scanner scan = new Scanner(System.in);
		
		System.out.println();
		System.out.println(" ===============================================");
		System.out.println("                   기업 회원가입");
		System.out.println(" ===============================================");
		
		boolean mark = true;
		
		while(mark) {
			//아이디 입력 >숫자만 입력 (10자리)
			System.out.print(" - 사업자등록번호(아이디) : ");
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
		
		while (mark) {
			System.out.print(" - 이름 (2자-20자,한글만 입력) : ");
			name = scan.nextLine();
			
			if (checkname(name)) {
				continue;
			}
			
			break;
			
		}//while
		
		//전화번호
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
		EntData user = new EntData(num, ID , PW, name, phone, bank+bankNum, address);
		EntReader.list = new ArrayList<EntData>();
		
		EntReader.reader();
		EntReader.list.add(user); 
		Data.save();
		
		LoginOutput.joinComplete();

	}
		
	
	
	
	private static String getNum() { 
			
			//목록 다음 번호에 추가
			
		int max = 0;
		
		EntReader.list = new ArrayList<EntData>();			
		EntReader.reader();
		for (EntData u : EntReader.list) {
			max = Integer.parseInt(u.getNum());
		}
		return (max + 1) + "";
	}
		

	private static boolean checkAddress(String address) {
		
		// 주소 유효성 검사
		
		
		return false;
		
		
	}//checkAddress

	private static boolean checkBank(String bank, String bankNum) {
		// 게좌번호 유효성 검사
		
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
		
		// 전화번호 유효성 검사
		if(phone.length() >= 14 || phone.length() <= 10) {
			System.out.println();
			System.out.println("             전화번호를 확인해 주세요.");
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

	private static boolean checkname(String name) {
		// 회사명 유효성 검사, 한글만 가능, 길이 유효성 검사 (2-20자)
		if(name.length() < 2 || name.length() > 20) {
			System.out.println();
			System.out.println("             2자~20자 이내로 입력하시오.");
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
		
		// 비밀번호 유효성검사
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
			
			BufferedReader reader = new BufferedReader(new FileReader("C:\\git\\Project\\Data\\companyList.txt"));
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split(",");
				if(temp[1].equals(iD)) {
					System.out.println();
					System.out.println("     이미 가입된 사용자입니다.");
					System.out.println();
					return true;
				}
				
			}
			
		} catch (Exception e) {
	
		}
		
		
		return false;
	}

	private static boolean checkId(String iD) {
		
		//아이디 숫자만 입력
		for (int i=0; i < iD.length(); i++){
			char c = iD.charAt(i);
			if (c < '0' || c > '9') {
				System.out.println();
				System.out.println("      숫자만 입력하시오.");
				System.out.println();
				return true;
			}
		
		char ch = iD.charAt(0);
		//아이디 길이 유효성 검사
		if(iD.length() < 10 || iD.length() > 10 ) {
			System.out.println();
			System.out.println("     10자 이내로 작성하시오.");		
			System.out.println();
			return true;
		
		}
		
			return false;
	}
	return false;
		
		
	}
}
