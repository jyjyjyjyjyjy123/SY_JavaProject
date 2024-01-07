package com.java.user;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import com.java.data.CatManageData;
import com.java.data.CatInfoData;
import com.java.data.EndRentData;
import com.java.data.EntData;
import com.java.data.RentData;
import com.java.reader.CatManageReader;
import com.java.reader.CatInfoReader;
import com.java.reader.EndRentReader;
import com.java.reader.EntReader;
import com.java.reader.RentReader;

public class UserReturnItem {
	public static void returnitem(){
		boolean loop = true;
		while (loop) {
			Scanner scan = new Scanner(System.in);
			UserPrint.returnItem();
			System.out.print("                                         메뉴 입력: ");
			String inputMenuNum = scan.nextLine();
			if (inputMenuNum.equals("1")) {
				UserReturnItem.penalty();
			}else if(inputMenuNum.equals("0")){
				loop=false;
			}else {
				System.out.println("                                    잘못된 메뉴 입니다.");
				scan.nextLine();
			}
			
		}
	}
	public static void penalty() {
		Scanner scan = new Scanner(System.in);
		System.out.print("반납 항목 선택: ");
		String intputItme = scan.nextLine();
		int count = 0;
		for (RentData RM : RentReader.list) {
			if (RM.getUserNum().equals(UserMain.loginUser[0])) {
				count++;
				if (count == Integer.parseInt(intputItme)) {
					if (RM.getStatus().equals("반납대기중")) {
						System.out.println("반납 대기중인 제품입니다.");
						scan.nextLine();
						return;
					}
					String code = RM.getCode();
					String[] category = code.split("_");
					int rentMoney = money(code);
					String period = RM.getPeriod();
					long day = Dday(period);
					if(day<0) {
						day = day*-1;
					}
					int penaltyMoney = 0;
					if (day >= 90) {
						penaltyMoney = rentMoney*2;
					}else if (day >= 60) {
						penaltyMoney = rentMoney;
					}else if (day >= 30) {
						penaltyMoney = rentMoney/2;
					}
					System.out.println("");
					System.out.printf("예상 위약금: %,d원\n", penaltyMoney);						
					System.out.println("1. 반납신청");
					System.out.println("0. 이전 페이지");
					System.out.print("메뉴 입력: ");
					System.out.println("");
					String inputMenuNum = scan.nextLine();
					if (inputMenuNum.equals("1")) {
						EntReader.reader();
						CatInfoReader.reader(category[0]);
						for (CatInfoData cid : CatInfoReader.list) {
							for (EntData ed : EntReader.list) {
								if (cid.getCode().equals(code) && ed.getName().equals(cid.getEntName())) {										
									System.out.printf("반납 위약금: %,d원\n", penaltyMoney);
									System.out.printf("위약금 입금계좌: %s\n", ed.getBank());
									RM.setStatus("반납대기중");
									System.out.print("반납하시겠습니까?(Y/N): ");
									String choice = scan.nextLine();
									if (choice.equals("Y") || choice.equals("y")) {
										System.out.println("");
										UserReturnItem.wirter();
										System.out.println("반납 신청이 완료되었습니다.");
									}
									return;
								}
							}
						}
					}else if (inputMenuNum.equals("0")) {
						return;
					}else {
						System.out.println("잘못된 메뉴 입니다.");
					}
					
				}
			}
		}
		System.out.println("해당 번호의 제품은 없습니다.");
		scan.nextLine();
	}
	private static void wirter() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\git\\Project\\Data\\RentManage.txt"));
			for (RentData writerRM : RentReader.list) {
				writer.write(String.format("%s,%s,%s,%s,%s,%s\n"
						,writerRM.getCode()
						,writerRM.getPeriod()
						,writerRM.getStatus()
						,writerRM.getDays()
						,writerRM.getNextVisit()
						,writerRM.getUserNum()));
			}
			writer.close();
		} catch (IOException e) {
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
