package com.java.user;

import java.util.ArrayList;

import com.java.data.AsData;
import com.java.data.EndRentData;
import com.java.data.RentData;
import com.java.reader.AsReader;
import com.java.reader.EndRentReader;
import com.java.reader.RentReader;

public class UserPrint {
	public static void talrent(){
		System.out.println(" _____   ___   _     ______  _____  _   _  _____ \r\n"
				+ "|_   _| / _ \\ | |    | ___ \\|  ___|| \\ | ||_   _|\r\n"
				+ "  | |  / /_\\ \\| |    | |_/ /| |__  |  \\| |  | |  \r\n"
				+ "  | |  |  _  || |    |    / |  __| | . ` |  | |  \r\n"
				+ "  | |  | | | || |____| |\\ \\ | |___ | |\\  |  | |  \r\n"
				+ "  \\_/  \\_| |_/\\_____/\\_| \\_|\\____/ \\_| \\_/  \\_/  \r\n"
				+ "");
	}
	public static void main() {
		System.out.println("                                      1.마이페이지");
		System.out.println("  ┌──────────────┬──────────────┬──────────────┐");
		System.out.println("  │    2.가전제품　　│   3.전자제품 　　│     4.레저   　│");
		System.out.println("  ├──────────────┼──────────────┼──────────────┤");
		System.out.println("  │    5.중장비　　　│   6.생활용품 　　│    7.운동기구　　│");
		System.out.println("  └──────────────┴──────────────┴──────────────┘");
		System.out.println("                                       0.로그아웃");
		System.out.println("");
	}
	public static void myPage() {
		System.out.println("");
		System.out.println("          ┌───────────────────────────┐");
		System.out.println("          │         1. 기본정보       　　│");
		System.out.println("          ├───────────────────────────┤");		
		System.out.println("          │         2. 나의 현황      　　│");
		System.out.println("          ├───────────────────────────┤");		
		System.out.println("          │         3. 반납  　　     　　│");
		System.out.println("          ├───────────────────────────┤");		
		System.out.println("          │         0. 이전 페이지 　　 　　│");
		System.out.println("          └───────────────────────────┘");
		System.out.println("");
	}
	public static void information( ) {
		System.out.println("          ─────────────────────────────");
		System.out.println("                       회원정보");
		System.out.println("          ─────────────────────────────");
		System.out.println("");
		System.out.println("          아이디　: " + UserMain.loginUser[1]);
		System.out.println("          이름　　: " + UserMain.loginUser[3]);
		System.out.println("          생년월일: " + UserMain.loginUser[4]);
		System.out.println("          전화번호: " + UserMain.loginUser[5]);
		System.out.println("          계좌번호: " + UserMain.loginUser[6]);
		System.out.println("          주소　　: " + UserMain.loginUser[7]);
		System.out.println("");
		System.out.println("          ─────────────────────────────");
		System.out.println("          1. 정보수정           0. 이전 페이지");
		System.out.println("          ─────────────────────────────");
	}
	public static void informationCorrection() {
		System.out.println("          ─────────────────────────────");
		System.out.println("                       회원정보");
		System.out.println("          ─────────────────────────────");
		System.out.println("  ");
		System.out.println("          1.아이디　: " + UserMain.loginUser[1]);
		System.out.println("          2.비밀번호: " + "******");
		System.out.println("          3.이름　　: " + UserMain.loginUser[3]);
		System.out.println("          4.생년월일: " + UserMain.loginUser[4]);
		System.out.println("          5.전화번호: " + UserMain.loginUser[5]);
		System.out.println("          6.계좌번호: " + UserMain.loginUser[6]);
		System.out.println("          7.주소　　: " + UserMain.loginUser[7]);
		System.out.println("");
		System.out.println("          ─────────────────────────────");
		System.out.println("          8.저장");
		System.out.println("          9.탈퇴              0.이전 페이지");
		System.out.println("");
	}
	public static void userStatus() {
		String code = null;
		String period = null;
		RentReader.list = new ArrayList<RentData>();
		RentReader.reader();
		System.out.println("                                    나의 계약 현황");
		System.out.println("─────────────────────────────────────────────────────────────────────────────────────────");
		System.out.println(" 번호 │     계약번호       │           　  제품명   　　        │ 　   　　계약기간  　      │ 잔여일정  │  렌탈료(월)");
		System.out.println("─────────────────────────────────────────────────────────────────────────────────────────");
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
				code = RM.getCode();
				String item = UserStatus.itemName(code)+" ";
				int rentMoney = UserStatus.money(code);
				period = RM.getPeriod();
				long day = UserStatus.Dday(period);
				System.out.printf(" %3s │ %15s　│ %-24s\t│ %21s │  %4d  │%,8d원\n",count,code,item,period,day,rentMoney);
				}
			}
		EndRentReader.list = new ArrayList<EndRentData>();
		EndRentReader.reader();
		System.out.println("─────────────────────────────────────────────────────────────────────────────────────────");
		System.out.println("");
		
		System.out.println("");
		System.out.println("                                    제품 이용 내역");
		System.out.println("─────────────────────────────────────────────────────────────────────────────────────────");
		System.out.println("     계약번호      │           　  제품명   　        │ 　   　　계약기간  　      │ 잔여일정 │  렌탈료(월)");
		System.out.println("─────────────────────────────────────────────────────────────────────────────────────────");
		for (EndRentData ERM : EndRentReader.list) {
			if (ERM.getUserNum().equals(UserMain.loginUser[0])) {
				code = ERM.getCode();
				String item = UserStatus.itemName(code)+" ";
				int rentMoney = UserStatus.money(code);
				period = ERM.getPeriod();
				long day = 0;
				System.out.printf("%15s　│ %-24s\t│ %21s │  %3d  │%,8d원\n",code,item,period,day,rentMoney);
				}
			}
		System.out.println("─────────────────────────────────────────────────────────────────────────────────────────");
		System.out.println("1. a/s 신청                                                                     0. 이전 페이지");
		System.out.println("");
	}
	public static void returnItem() {
		String code = null;
		String period = null;
		RentReader.list = new ArrayList<RentData>();
		RentReader.reader();
		System.out.println("                                       나의 계약 현황");
		System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────");
		System.out.println("항목번호 │     계약번호      │     　     　  제품명   　   　    │ 　   　　계약기간  　      │  잔여일정 │  렌탈료(월)");
		System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────");
		int count = 0;
		for (RentData RM : RentReader.list) {
			if (RM.getUserNum().equals(UserMain.loginUser[0])) {
				code = RM.getCode();
				String item = UserReturnItem.itemName(code)+" ";
				int rentMoney = UserReturnItem.money(code);
				period = RM.getPeriod();
				long day = UserReturnItem.Dday(period);
				count++;
				if (RM.getStatus().equals("반납대기중")) {
					System.out.printf("  %d 　 │%15s　│ %-24s\t│ %21s │　반납대기중│월 %,8d원\n",count,code,item,period,rentMoney);
					continue;
				}
				System.out.printf("  %d 　 │%15s　│ %-24s\t│ %21s │  %4d  │월 %,8d원\n",count,code,item,period,day,rentMoney);
				}
			}
		System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────");
		System.out.println("1.반납신청                                                                                0. 이전 페이지");
	}
	public static void category1() {
		System.out.println("                                      1.마이페이지");
		System.out.println("  ┌──────────────┬──────────────┬──────────────┐");
		System.out.println("  │    2.냉장고　　　│   3.세탁기　 　　│   4.에어컨　 　　│");
		System.out.println("  ├──────────────┼──────────────┼──────────────┤");
		System.out.println("  │    5.안마의자　　│   6.TV  　 　　│   7.오븐　 　　　│");
		System.out.println("  └──────────────┴──────────────┴──────────────┘");
		System.out.println("                                     0.이전 페이지");
		System.out.println("");
	}
	public static void category2() {
		System.out.println("                                      1.마이페이지");
		System.out.println("  ┌──────────────┬──────────────┬──────────────┐");
		System.out.println("  │    2.노트북　　　│   3.태블릿　 　　│   4.모니터　 　　│");
		System.out.println("  ├──────────────┼──────────────┼──────────────┤");
		System.out.println("  │    5.빔프로젝트　│   6.카메라 　　　│          　　　│");
		System.out.println("  └──────────────┴──────────────┴──────────────┘");
		System.out.println("                                     0.이전 페이지");
		System.out.println("");
	}
	public static void category3() {
		System.out.println("                                      1.마이페이지");
		System.out.println("  ┌──────────────┬──────────────┬──────────────┐");
		System.out.println("  │    2.텐트　　　　│   3.캠핑카　 　　│   4.요트　　 　　│");
		System.out.println("  ├──────────────┼──────────────┼──────────────┤");
		System.out.println("  │    5.골프　　　　│         　 　　│   　 　  　　　　│");
		System.out.println("  └──────────────┴──────────────┴──────────────┘");
		System.out.println("                                     0.이전 페이지");
		System.out.println("");	
	}
	public static void category4() {
		System.out.println("                                      1.마이페이지");
		System.out.println("  ┌──────────────┬──────────────┬──────────────┐");
		System.out.println("  │    2.덤프트럭　　│   3.포크레인　 　│   4.레미콘　 　　│");
		System.out.println("  ├──────────────┼──────────────┼──────────────┤");
		System.out.println("  │    5.사다리차　　│   6.지게차 　　　│   7.크레인　　 　│");
		System.out.println("  └──────────────┴──────────────┴──────────────┘");
		System.out.println("                                     0.이전 페이지");
		System.out.println("");
	}
	public static void category5() {
		System.out.println("                                      1.마이페이지");
		System.out.println("  ┌──────────────┬──────────────┬──────────────┐");
		System.out.println("  │    2.유모차　　　│   3.쇼파     　│   4.침대　 　　　│");
		System.out.println("  ├──────────────┼──────────────┼──────────────┤");
		System.out.println("  │    5.그릇    　│   6.그릇     　│     　　　 　　　│");
		System.out.println("  └──────────────┴──────────────┴──────────────┘");
		System.out.println("                                     0.이전 페이지");
		System.out.println("");		
	}
	public static void category6() {
		System.out.println("                                      1.마이페이지");
		System.out.println("  ┌──────────────┬──────────────┬──────────────┐");
		System.out.println("  │    2.러닝머신　　│   3.스미스머신 　│   4.로잉머신　 　│");
		System.out.println("  ├──────────────┼──────────────┼──────────────┤");
		System.out.println("  │    5.사이클　　　│   　　　  　 　　│   　　　   　　　│");
		System.out.println("  └──────────────┴──────────────┴──────────────┘");
		System.out.println("                                     0.이전 페이지");
		System.out.println("");		
	}
}
