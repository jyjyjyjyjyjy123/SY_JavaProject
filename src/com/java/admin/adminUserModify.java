package com.java.admin;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.java.data.UserData;
import com.java.reader.UserReader;

public class adminUserModify {
	
	
	

	public static void  menu() {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
		System.out.println("(수정/삭제)할 회원번호를 입력하세요\n "
				+ "0. 이전화면 ");
		System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
		System.out.print("해당번호입력: ");
		System.out.println();
		int userNum = scan.nextInt();
		scan.nextLine();
		System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
		if(userNum != 0) {
			System.out.println("수정할 항목과 내용을 (,)으로 구분하여 입력하시오");
			System.out.println("삭제는 \"0\"을 입력하시오");
			System.out.print("번호 입력 : ");
			
			String deleteMenu = scan.nextLine();
			
			System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
			if(deleteMenu.equals("0")) {
				try {
					UserInfoDelet(userNum);
					System.out.println("데이터가 삭제되었습니다.");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else {
				try {
					UserInfoModify(userNum, deleteMenu);
				} catch (IOException e) {
					System.out.println("올바른 키워드를 입력하시오.");;
				}
			}
			
			System.out.println("0. 이전화면");
			int next = scan.nextInt();
			if(next == 0) {
				adminUserManagement.userMenu();
			}
		
		
	}
	
	
	
}


	private static void UserInfoModify(int userNum, String deleteMenu) throws IOException {
		
		String [] dir = deleteMenu.split(",");
		
		try {
					if(dir[0].equals("이름")) {
						if (test("3",dir[1])==false) {
							return;
						} 
					}else if(dir[0].equals("생년월일")) {
						if (test("4",dir[1])==false) {
							return;
						}
					}else if(dir[0].equals("전화번호")) {
						if (test("5",dir[1])==false) {
							return;
						}
					}else if(dir[0].equals("주소")) {
					}else {
						System.out.println("바꿀수 없는 항목입니다.");
						return;
					}

			
			UserReader.list = new ArrayList<UserData>();
			UserReader.reader(null);
			BufferedWriter bw2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\git\\Project\\Data\\userData.txt")));
			for (UserData ud: UserReader.list) {
				if (ud.getNum().equals(userNum+"")) {
					if(dir[0].equals("이름")) {
						bw2.write(String.format("%s,%s,%s,%s,%s,%s,%s,%s\n",ud.getNum(),ud.getID(),ud.getPW(),dir[1],ud.getBirth(),ud.getPhone(),ud.getBank(),ud.getAddress()));
						continue;
					}else if(dir[0].equals("생년월일")) {
						bw2.write(String.format("%s,%s,%s,%s,%s,%s,%s,%s\n",ud.getNum(),ud.getID(),ud.getPW(),ud.getName(),dir[1],ud.getPhone(),ud.getBank(),ud.getAddress()));
						continue;
					}else if(dir[0].equals("전화번호")) {
						bw2.write(String.format("%s,%s,%s,%s,%s,%s,%s,%s\n",ud.getNum(),ud.getID(),ud.getPW(),ud.getName(),ud.getBirth(),dir[1],ud.getBank(),ud.getAddress()));
						continue;
					}else if(dir[0].equals("주소")) {
						bw2.write(String.format("%s,%s,%s,%s,%s,%s,%s,%s\n",ud.getNum(),ud.getID(),ud.getPW(),ud.getName(),ud.getBirth(),ud.getPhone(),ud.getBank(),dir[1]));
						continue;
					}
				}
				bw2.write(String.format("%s,%s,%s,%s,%s,%s,%s,%s\n",ud.getNum(),ud.getID(),ud.getPW(),ud.getName(),ud.getBirth(),ud.getPhone(),ud.getBank(),ud.getAddress()));
			}
			bw2.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.printf("[%s]변경이 완료되었습니다.\n",dir[0]);
		System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
		
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


	private static String UserInfoDelet(int userNum) throws IOException {
		UserReader.list = new ArrayList<UserData>();
		UserReader.reader(null);
		Scanner scan = new Scanner(System.in);
		String temp = "";
		String line; //파일에서 받아온 라인을 저장
		UserReader.list = new ArrayList<UserData>();
		UserReader.reader(null);
		List<UserData> userList = new ArrayList<UserData>();
		//Path filePath = Paths.get("Data\\userData.txt");
		
		
		
		for (UserData ud : UserReader.list) {
			if(Integer.parseInt(ud.getNum()) == userNum) {
				temp = String.format("%s,%s,%s,%s,%s,%s,%s,%s",
						ud.getNum(),
						ud.getID(),
						ud.getPW(),
						ud.getName(),
						ud.getBirth(),
						ud.getPhone(),
						ud.getBank(),
						ud.getAddress());
				continue;
			}
			userList.add(ud);
			
		}

		BufferedWriter bw = null;
		
		
		try {
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\git\\Project\\Data\\userData.txt")));
			
			for(UserData ud2 : userList) {
				bw.write(String.format("%s,%s,%s,%s,%s,%s,%s,%s\n", ud2.getNum(),
																	ud2.getID(),
																	ud2.getPW(),
																	ud2.getName(),
																	ud2.getBirth(),
																	ud2.getPhone(),
																	ud2.getBank(),
																	ud2.getAddress()));
				
			}
			
			
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		bw.close();
		
		
		
		return temp;

		
	}
	
}



