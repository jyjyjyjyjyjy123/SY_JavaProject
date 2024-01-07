package com.java.user;

import java.util.Calendar;
import java.util.Scanner;

import com.java.data.CatManageData;
import com.java.data.CatInfoData;
import com.java.reader.CatManageReader;
import com.java.reader.CatInfoReader;

public class UserStatus {
	public static void status(){
		boolean loop = true;
		
		while (loop) {
			Scanner scan = new Scanner(System.in);
			UserPrint.userStatus();
			System.out.print("                                     메뉴 입력: ");
			String inputMenuNum = scan.nextLine();
			if ( inputMenuNum.equals("0")) {
				loop=false;
			}else if(inputMenuNum.equals("1")){
					UserAsPage.as();
			}else {
				System.out.println("                                    잘못된 메뉴 입니다.");
				scan.nextLine();
			}
			
		}
	}
	public static String itemName(String code) {
		String[] category = code.split("_");
		CatInfoReader.reader(category[0]);
		for (CatInfoData cid : CatInfoReader.list) {
			if (cid.getCode().equals(code)) {
				return cid.getItemName();
			}
		}
		return null;
	}
	public static int money(String code) {
		String[] category = code.split("_");
		CatManageReader.reader(category[0]);
		for (CatManageData cmd : CatManageReader.list) {
			if (cmd.getCode().equals(code)) {
				return Integer.parseInt(cmd.getMoney());
			}
		}
		return 0;
	}

	public static long Dday(String period) {
		Calendar calendar = Calendar.getInstance();
		Calendar endcalendar = Calendar.getInstance();
		String[] endDays = period.split("~");
		String[] days = endDays[1].split("-");
		endcalendar.set(Integer.parseInt(days[0]), Integer.parseInt(days[1])-1, Integer.parseInt(days[2]));
		long today = calendar.getTimeInMillis();
		long endday = endcalendar.getTimeInMillis();
		return (endday-today)/1000/60/60/24;
	}
}
