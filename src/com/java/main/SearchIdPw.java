package com.java.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.java.data.EntData;
import com.java.data.UserData;
import com.java.reader.EntReader;
import com.java.reader.UserReader;


public class SearchIdPw {
	
	Join join = new Join();
	Login login = new Login();
	Data data = new Data();
	
	
	
	private static String id;
	private static String pw;
	private static String name;
	private static String birth;
	private static String phone;
	

	//아이디,비밀번호 찾기 화면 번호 입력 이동 
	public static void findOutput() {
		Scanner scan = new Scanner(System.in);
		boolean loop = true;
		
		while(loop) {
		
			MainOutput.searchImage();
			String input = scan.nextLine();
			
			if(input.equals("1")) {
				searchId();
				break;
			} else if(input.equals("2")) {
				searchPw();
				break;
			} else if(input.equals("0")) {
				Main.main(null);
				loop=false;
			} else {
				System.out.println();
				System.out.println("       올바른 번호를 입력해주세요.");
			}
			
		
		}
	}//findOutput
	
	//비밀번호 찾기 
	private static void searchPw() {
		
		boolean loop = true;
		while(loop) {
			Scanner scan = new Scanner(System.in);
		
			System.out.println();
			System.out.println("===================================");
			System.out.println("            비밀번호 찾기     ");
			System.out.println("===================================");
			System.out.println();
			System.out.println("  회원가입시 등록했던 정보를 입력해주세요. ");
			System.out.println();
			System.out.print("   -아이디(사업자등록번호) :  \n");
			id = scan.nextLine();
	        System.out.print("   -전화번호 :  \n");
	        phone = scan.nextLine();
        
	        	if(!searchPw(id,phone)) {
	        		System.out.println();
	        		System.out.println("       비밀번호를 찾을 수 없습니다.");
	        		System.out.println();
				
	        	}
        		afterSearchPw();
		}
	}

//비밀번호 
	private static boolean searchPw(String id, String phone) {
	
		 try {
				
				UserReader.list = new ArrayList<UserData>();
				UserReader.reader(null);
				for (UserData ud : UserReader.list) {
						 if(ud.getID().equals(id) && ud.getPhone().equals(phone)) {
							 MainOutput.findPw(ud.getID(),ud.getPW());
							 return true;
						 }
				}
				
				EntReader.list = new ArrayList<EntData>();
				EntReader.reader();
				for (EntData ed : EntReader.list) {
					if (ed.getID().equals(id) && ed.getPhone().equals(phone)) {
						MainOutput.findPw(ed.getID(),ed.getPW());
						return true;
					}
				}
			 } catch (Exception e) {
				 
				 e.printStackTrace();
			 }
		
		
		return false;
	}
	
	public static void afterSearchPw() {
		boolean loop = true;
		while(loop) {
			MainOutput.afterFindPw();
			Scanner scan = new Scanner(System.in);
			String input = scan.nextLine();
			
			if(input.equals("1")) {
				Login.loginInput(); //로그인 화면
			} else if(input.equals("2")) {
				SearchIdPw.searchId(); //아이디 찾기
			} else if(input.equals("0")) {
				Main.main(null); //메인
				loop = false;
			} else {
				System.out.println();
				System.out.println(" 번호를 다시 입력해주세요.");
		}
	}
}

	//아이디 찾기 
	public static void searchId() {
		
		boolean loop = true;
		
		while(loop) {
			
			Scanner scan = new Scanner(System.in);
			
			System.out.println();
			System.out.println("===================================");
			System.out.println("            아이디 찾기     ");
			System.out.println("===================================");
			System.out.println();
			System.out.println("  회원가입시 등록했던 정보를 입력해주세요. ");
			System.out.println();
			System.out.print("   -이름 :  \n");
			name = scan.nextLine();
			System.out.print("   -생년월일 :  \n");
			birth = scan.nextLine();
			System.out.print("   -전화번호 :  \n");
			phone = scan.nextLine();
			
			
			if(!searchId(name, birth, phone)) {
				System.out.println();
				System.out.println("       아이디를 찾을 수 없습니다.");
				System.out.println();
				
			}
			
			afterSearchId();
		}
	}

	//입력정보 찾는 메소드

	private static boolean searchId(String name, String birth, String phone) {
		
		 try {
			
				 UserReader.list = new ArrayList<UserData>();
				 UserReader.reader(null);
				 
						for (UserData ud : UserReader.list) {
							if(ud.getName().equals(name) && ud.getBirth().equals(birth) && ud.getPhone().equals(phone)) {
								MainOutput.findId(ud.getName(),ud.getID());
								return true;
				 }
			
				 
			}
			
		 } catch (Exception e) {
			 
			 e.printStackTrace();
		 }
			return false;
			
		}
	
	public static void afterSearchId() {
		
		boolean loop = true;
		while(loop) {
			MainOutput.afterFindId();
			Scanner scan = new Scanner(System.in);
			String input = scan.nextLine();
			
			if(input.equals("1")) {
				Login.loginInput(); //로그인 화면
			} else if(input.equals("2")) {
				SearchIdPw.searchPw(); //비밀번호 찾기
			} else if(input.equals("0")) {
				Main.main(null); //메인
				loop = false;
			} else {
				System.out.println();
				System.out.println(" 번호를 다시 입력해주세요.");
			}
		
		}
	}

}


