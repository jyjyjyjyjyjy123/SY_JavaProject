package com.java.user;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Scanner;

import com.java.data.AsData;
import com.java.data.RentData;
import com.java.reader.AsReader;
import com.java.reader.RentReader;

public class UserAsPage {
	public static void as(){
		Scanner scan = new Scanner(System.in);
		String code = null;
		String period = null;
		RentReader.list = new ArrayList<RentData>();
		RentReader.reader();
		System.out.print("번호 입력:");
		int choice = scan.nextInt();
		int count = 0;
		case1: for (RentData RM : RentReader.list) {
			if (RM.getUserNum().equals(UserMain.loginUser[0])) {
				AsReader.list = new ArrayList<AsData>();
				AsReader.reader();
				for (AsData ad : AsReader.list) {
					if (RM.getCode().equals(ad.getCode())) {
						continue case1;
					}
				}
				count++;
				if (count == choice) {
					try {
						Calendar todqy = Calendar.getInstance();
						System.out.print("파손사유를 적으세요: ");
						String s1 = scan.nextLine();
						s1 = scan.nextLine();
						BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\git\\Project\\Data\\ASinfo.txt",true));
						writer.write(String.format("%s,%s,%s,%tF,%s,%s\n"
								,RM.getCode(), s1, "확인중",todqy,null,UserMain.login));
						writer.close();
						System.out.println("신청 되었습니다.");
						scan.nextLine();
						return;
					} catch (Exception e) {
						e.printStackTrace();
					}
				}else {
					System.out.println("해당 번호의 제품은 존재하지 않습니다.");
					scan.nextLine();
					return;
				}
			}
		}
	}
}
