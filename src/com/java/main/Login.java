package com.java.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.java.admin.AdminMain;
import com.java.data.EntData;
import com.java.data.UserData;
import com.java.ent.Entmain;
import com.java.reader.EntReader;
import com.java.reader.UserReader;
import com.java.user.UserMain;

public class Login {

	public static void loginInput() {
		
			
		Scanner scan = new Scanner(System.in);

			try {
				boolean loop = true;
				
				while (loop) {
					
					
					System.out.println("           - 0을 입력하면 메인 화면으로 이동합니다. ");
					System.out.println();
					System.out.print("\t  아이디 : ");
					String id = scan.nextLine();
					
					System.out.print("\t  비밀번호 : ");
					String pw = scan.nextLine();
					
					if (id.equals("0") && pw.equals("0")) { // 0을 입력하면 이전화면으로
						Main.main(null);
						break;
					}
						if (id.equals("adminN1234") && pw.equals("adminN1234")){
							AdminMain.adminMain();
							break;
						}
					
						UserReader.list = new ArrayList<UserData>();
						UserReader.reader(null);
						for (UserData ud : UserReader.list) {
							if (ud.getID().equals(id)&&ud.getPW().equals(pw)) {
								System.out.println();
								System.out.printf("             [%s]님 로그인이 완료되었습니다.\n", id);
								UserMain.login = ud.getNum();
								UserMain.usermain();
								loop = false;
								break;
							}
						}
						
						EntReader.list = new ArrayList<EntData>();
						EntReader.reader();
						for (EntData ed : EntReader.list) {
							
							if (ed.getID().equals(id)&&ed.getPW().equals(pw)) {
								System.out.println();
								System.out.printf("             [%s]님 로그인이 완료되었습니다.\n", id);
								Entmain.entLogin= ed.getName();
								Entmain.entmain();
								loop = false;
								break;
							}
						}
					
					
				
					if (loop) {
						System.out.println();
						System.out.println("	    아이디 또는 비밀번호가 일치하지 않습니다. \n");
					} 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
	
