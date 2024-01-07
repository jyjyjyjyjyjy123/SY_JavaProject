package com.java.user;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import com.java.data.RentData;
import com.java.data.UserData;
import com.java.reader.RentReader;
import com.java.reader.UserReader;


public class UserInfoCorrection {
	static Scanner scan = new Scanner(System.in);
	static String changeName = null;
	public static void correction(){
		boolean loop = true;
		while (loop) {
			UserPrint.informationCorrection();
			System.out.print("            수정할 정보: ");
			
			String inputCorrection = scan.nextLine();
			switch (inputCorrection) {
			case "1":
				changeName = "아이디";
				change(inputCorrection);
				scan.nextLine();
				continue;
			case "2":
				changeName = "비밀번호";
				change(inputCorrection);
				scan.nextLine();
				continue;
			case "3":
				changeName = "이름";
				change(inputCorrection);
				scan.nextLine();
				continue;
			case "4":
				changeName = "생년월일";
				change(inputCorrection);
				scan.nextLine();
				continue;
			case "5":
				changeName = "전화번호";
				change(inputCorrection);
				scan.nextLine();
				continue;
			case "6":
				changeName = "계좌번호";
				change(inputCorrection);
				scan.nextLine();
				continue;
			case "7":
				changeName = "주소";
				change(inputCorrection);
				scan.nextLine();
				continue;
			case "8":
				update();
				scan.nextLine();
				continue;
			case "9":
				secession();
				scan.nextLine();
				continue;
			case "0":
				loop = false;
				break;
			default:
				System.out.println("잘못된 메뉴 입니다.");
				scan.nextLine();
				continue;
			}
			
		}
	}
	private static void writer() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("Data\\UserData.txt"));
			for (UserData udr : UserReader.list) {
				if (udr.getNum().equals(UserMain.loginUser[0])) {
					System.out.println("삭제됨");
				}else {
					writer.write(String.format("%s,%s,%s,%s,%s,%s,%s,%s\n"
							,udr.getNum()
							,udr.getID()
							,udr.getPW()
							,udr.getName()
							,udr.getBirth()
							,udr.getPhone()
							,udr.getBank()
							,udr.getAddress()));
				}
			}
			writer.close();
		} catch (Exception e) {
		}
	}
	
	public static void secession() {
		RentReader.list = new ArrayList<RentData>();
		RentReader.reader();
		for (RentData rd : RentReader.list) {
			if (rd.getUserNum().equals(UserMain.loginUser[0])) {
				System.err.println("            계약중에는 탈퇴할 수 없습니다.");
				return;
			}
		}
		System.out.print("            탈퇴하시겠습니까?(Y/N): ");
		String choice = scan.nextLine();
		if (choice.equals("Y") || choice.equals("y")) {
			System.out.print("            현재 비밀번호: ");
			String inputPw = scan.nextLine();
			if (!UserMain.loginUser[2].equals(inputPw)) {
				System.out.println("                  틀린 비밀번호입니다.");
				return;
			}
			UserInfoCorrection.writer();
			System.out.println("                  탈퇴되었습니다.");
			System.exit(0);
		}else{
			System.out.println("                  취소되었습니다.");
		}
	}
	public static void update() {
		try {
			UserReader.list = new ArrayList<UserData>();
			UserReader.reader(null);
			BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\git\\Project\\Data\\userData.txt"));
			for (UserData ud : UserReader.list) {
				if (ud.getNum().equals(UserMain.loginUser[0])) {
					ud.setNum(UserMain.loginUser[0]);
					ud.setID(UserMain.loginUser[1]);
					ud.setPW(UserMain.loginUser[2]);
					ud.setName(UserMain.loginUser[3]);
					ud.setBirth(UserMain.loginUser[4]);
					ud.setPhone(UserMain.loginUser[5]);
					ud.setBank(UserMain.loginUser[6]);
					ud.setAddress(UserMain.loginUser[7]);
				}
				writer.write(String.format("%s,%s,%s,%s,%s,%s,%s,%s\n"
						,ud.getNum()
						,ud.getID()
						,ud.getPW()
						,ud.getName()
						,ud.getBirth()
						,ud.getPhone()
						,ud.getBank()
						,ud.getAddress()));
			}
			System.out.println("                  저장되었습니다");
			writer.close();
		} catch (Exception e) {
		}
	}
	
	public static void change(String inputCorrection) {
		String inputChange = null;
		if (inputCorrection.equals("2")) {
			System.out.print("            현재 비밀번호: ");
			String inputPw = scan.nextLine();
			if (!UserMain.loginUser[2].equals(inputPw)) {
				System.out.println("                  틀린 비밀번호입니다.");
				return;
			}
			System.out.print("            변경할 "+changeName+": ");
			inputChange = scan.nextLine();
		}else if (inputCorrection.equals("6")) {
			System.out.print("            변경할 "+changeName+" 은행: ");
			inputChange = scan.nextLine();
			System.out.print("            변경할 "+changeName+" 번호: ");
			inputChange += " " + scan.nextLine();
		}else {			
			System.out.print("            변경할 "+changeName+": ");
			inputChange = scan.nextLine();
		}
		if (test(inputCorrection, inputChange)==false) {
			return;
		}
		System.out.print("            변경하시겠습니까?(Y/N): ");
		String choice = scan.nextLine();
		System.out.println("");
		if (choice.equals("Y") || choice.equals("y")) {
			UserMain.loginUser[Integer.parseInt(inputCorrection)] = inputChange;
			System.out.println("                  변경되었습니다");
		}else{
			System.out.println("                  취소되었습니다.");
		}
	}
	private static boolean test(String inputCorrection, String inputChange) {
		boolean result = true;
		if (inputCorrection.equals("1")) {
			if (inputChange.length() < 4 || inputChange.length() > 16) {
				System.out.println();
				System.out.println("                  4자~16자 이내로 입력하시오.");
				System.out.println();
				result = false;
			}
			char ch = inputChange.charAt(0);
			if(Character.isUpperCase(ch) == true || Character.isDigit(ch) == true) {
				System.out.println();
				System.out.println("                  아이디 첫글자는 영어 소문자만 가능합니다.");
				System.out.println();
				result = false;
			}
			UserReader.list = new ArrayList<UserData>();
			UserReader.reader(null);
			for (UserData ud : UserReader.list) {
				if (ud.getID().equals(inputChange)) {
					System.out.println();
					System.out.println("                  이미 사용중인 아이디입니다.");
					System.out.println();
					result = false;
					break;
				}
			}
		}else if(inputCorrection.equals("2")){
			if (inputChange.length() < 8 || inputChange.length() > 12) {
				System.out.println();
				System.out.println("                  8자~12자 이내로 입력하시오.");
				System.out.println();
				result = false;
			} 
			for (int i=0; i < inputChange.length(); i++){
				char c = inputChange.charAt(i);
				if ((c < 'a' || c > 'z') && (c <'A' || c > 'Z')) {
				System.out.println();
				System.out.println("                  영어 소문자,대문자 만 가능합니다.");
				System.out.println();
				result = false;
				break;
			}  
		}
		}else if(inputCorrection.equals("3")){
			if(inputChange.length() < 2 || inputChange.length() > 5) {
				System.out.println();
				System.out.println("                  2자~5자 이내로 입력하시오.");
				System.out.println();
				result = false;
			}
			for (int i=0; i < inputChange.length(); i++) {
				char c = inputChange.charAt(i);
				if (c < '가' || c > '힣') {
					System.out.println();
					System.out.println("      한글만 입력 가능합니다.");
					System.out.println();
					result = false;
					break;
				}
			}
		}else if(inputCorrection.equals("4")){
			if (inputChange.length() != 8) {
				System.out.println();
				System.out.println("                  생년월일을 8자리로 입력하시오.");
				System.out.println();
				result = false; 
			}
			int year = Integer.parseInt(inputChange.substring(0, 4));
			int month = Integer.parseInt(inputChange.substring(4,6));
			int day = Integer.parseInt(inputChange.substring(6)); //끝까지 뽑음
			//날짜
			if (day < 1 || day > 31) {
				System.out.println();
				System.out.println("                  생년월일 일을 다시 입력하시오.");
				System.out.println();
				result = false; 
			}
			//월
			if (month < 1 || month > 12) {
				System.out.println();
				System.out.println("                  생년월일 월을 다시 입력하시오.");
				System.out.println();
				result = false; 
			}
		}else if(inputCorrection.equals("5")){
			if (inputChange.length() < 10 || inputChange.length() >14) {
				System.out.println();
				System.out.println("           전화번호를 확인해 주세요.");
				System.out.println();
				result = false;
			}
			int count = 0;
			for (int i=0; i < inputChange.length(); i++){
				char c = inputChange.charAt(i);
				if (c == '-') {
					count++;
					if (count > 2) {
						System.out.println();
						System.out.println("           전화번호를 확인해 주세요.");
						System.out.println();
						result = false;
						break;
						}
					continue;
				}
				if (c < '0' || c > '9') {
					System.out.println();
					System.out.println("           숫자만 입력하세요.");
					System.out.println();
					result = false; 
				}
			}
		}else if(inputCorrection.equals("6")){
			String[] temp = inputChange.split(" ");
			for (int i=0; i < temp[0].length(); i++) {
				char c = temp[0].charAt(i);
				if (c < '가' || c > '힣') {
					System.out.println();
					System.out.println("      한글만 입력 가능합니다.");
					System.out.println();
					result = false;
					break;
				} 
			}
			for (int j=0; j < temp[1].length(); j++) {
				char h = temp[1].charAt(j);
				if (h < '0' || h > '9') {
				System.out.println();
				System.out.println("      숫자만 입력 가능합니다.");
				System.out.println();
				result = false;
				break;
			
				}
			}
		}
		return result;
	}
}
