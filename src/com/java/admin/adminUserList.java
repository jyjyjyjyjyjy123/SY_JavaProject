package com.java.admin;

import java.util.ArrayList;

import com.java.data.UserData;
import com.java.reader.UserReader;

public class adminUserList {

	
public static void UserInfoPrint() {

	UserReader.list = new ArrayList<UserData>();
	UserReader.reader(null);
	
	    System.out.println("                                                  < 회원목록 >");
	    System.out.println("────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
		System.out.println("  [번호]\t  |   \t[아이디]\t\t|   [이름]\t|       [생년월일]\t    |       [전화번호]\t\t   |    [주소]\t");
		System.out.println("────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
	
		
		for (UserData ud : UserReader.list) {
			if(ud == null) {break;}
				
			System.out.printf("%5s \t│%15s\t│%8s\t│ %15s\t│ %17s\t│ %20s\n", ud.getNum(), ud.getID(), ud.getName()
														, ud.getBirth(), ud.getPhone(), ud.getAddress());
			System.out.println("────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
			
			

		}
			System.out.println("");
			
			
			
	}
}
