package com.java.admin;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.java.data.AsData;
import com.java.data.CatInfoData;
import com.java.data.RentData;
import com.java.data.UserData;
import com.java.reader.AsReader;
import com.java.reader.CatInfoReader;
import com.java.reader.RentReader;
import com.java.reader.UserReader;




public class adminAsMenu {

	public static void asmain() {
		boolean loop = true;
		while(loop) {
			Scanner scan = new Scanner(System.in);
			
			System.out.println();
			System.out.println("──────────────────────────────────────────────");
			System.out.println("                  A / S 관리");
			System.out.println("──────────────────────────────────────────────");
			
			System.out.println(" _____   ___   _     ______  _____  _   _  _____ \r\n"
					+ "|_   _| / _ \\ | |    | ___ \\|  ___|| \\ | ||_   _|\r\n"
					+ "  | |  / /_\\ \\| |    | |_/ /| |__  |  \\| |  | |  \r\n"
					+ "  | |  |  _  || |    |    / |  __| | . ` |  | |  \r\n"
					+ "  | |  | | | || |____| |\\ \\ | |___ | |\\  |  | |  \r\n"
					+ "  \\_/  \\_| |_/\\_____/\\_| \\_|\\____/ \\_| \\_/  \\_/  \r\n"
					+ "");
			System.out.println("                                      ");
			System.out.println("         ┌─────────────────────┐");
			System.out.println("         │    1.A/S 신청 목록　 　 │");
			System.out.println("         ├─────────────────────┤");
			System.out.println("         │    2.A/S 접수 목록　 　 │");
			System.out.println("         ├─────────────────────┤");
			System.out.println("         │    3.A/S 완료 목록　 　 │");
			System.out.println("         └─────────────────────┘");
			System.out.println("                         0. 이전화면 ");
			System.out.print("            메뉴 입력: ");
			
			
			
			int menuNum = scan.nextInt();
			
			if(menuNum == 1) {
				AsApplicationList();
			}else if(menuNum ==2) {
				AsreceiptList();
			}else if(menuNum == 3) {
				AscompleteList();
			}else if (menuNum == 0) {
				return;
			}
		}
		
	
		
		
		

	}

	private static void AscompleteList() {
		Scanner scan = new Scanner(System.in);
		UserReader.list = new ArrayList<UserData>();
		UserReader.reader(null);;
		AsReader.list = new ArrayList<AsData>();
		AsReader.reader();
		
		
		System.out.println("                  AS 완료목록");
		System.out.println();
		System.out.println("────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
		System.out.println(" [회원번호]  │    [이름]    │             [주소]             │          [전화번호]         │        　     [제품명]　　          　 │     [업체명]    │   [A/S접수일자]  │   [A/S방문일자]  ");
		System.out.println("────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
		int count =0;
		case1 : for (AsData ad : AsReader.list) {
			if(ad.getSituation().equals("수리 완료")) { //상태가 확인중이 아니고 완료날짜가 없으면
				for(UserData ud : UserReader.list) {
					if(ad.getUserNum().equals(ud.getNum())) { //고객번호가 일치하는 지 확인
						CatInfoReader.reader(ad.getCode().substring(0, 3)); //일치하면 dummy데이터의 제품코드 호출
						for(CatInfoData cd : CatInfoReader.list) {
							if(ad.getCode().equals(cd.getCode())) {
								count++;
								System.out.printf("%6d    │%5s\t│%23s\t│\t%13s\t   │ %-27s\t│%9s\t│%10s\t│%10s\n "
										                                     ,count, ud.getName(),
										                                 ud.getAddress(), ud.getPhone(),
										                                                           cd.getItemName(),
										                                                           cd.getEntName(), ad.getApplicationDay(),
										                                                           ad.getCompleteDay());
								System.out.println("────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
								continue case1;
							}
						}
						
					}
				}
			}
			
			
				
		}
		System.out.println("0. 이전화면");
		System.out.print("번호 입력: ");
		int applicationMenu = scan.nextInt();
		scan.nextLine();
		if (applicationMenu == 0) {
			return;
		}
	}

	private static void AsreceiptList() {
		Scanner scan = new Scanner(System.in);
		UserReader.list = new ArrayList<UserData>();
		UserReader.reader(null);
		AsReader.list = new ArrayList<AsData>();
		AsReader.reader();
		RentReader.list = new ArrayList<RentData>();
		RentReader.reader();
		
		System.out.println("========================");
		System.out.println("       AS 접수목록");
		System.out.println("========================");
		System.out.println();
		System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
		System.out.println("  　[번호]　 │    [이름]    │             [주소]             │          [전화번호]         │                   [제품명]                  │     [업체명]    │ [A/S접수일자]  ");
		System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
		int count = 0;
		case1 : for (AsData ad : AsReader.list) {
			if((!ad.getSituation().equals("확인중")) && (ad.getCompleteDay().equals("null"))) { //상태가 확인중이 아니고 완료날짜가 없으면
				for(UserData ud : UserReader.list) {
					if(ad.getUserNum().equals(ud.getNum())) { //고객번호가 일치하는 지 확인
						CatInfoReader.reader(ad.getCode().substring(0, 3)); //일치하면 dummy데이터의 제품코드 호출
						
						for(CatInfoData cd : CatInfoReader.list) {
							
							if(ad.getCode().equals(cd.getCode())) {
										count ++;
										System.out.printf(" %6d   │%5s\t│%23s\t│\t%13s\t   │\t   %-29s\t│%9s\t│%12s\n "
			                                     ,count, ud.getName(),
			                                 ud.getAddress(), ud.getPhone(),
			                                                           cd.getItemName(),
			                                                           cd.getEntName(), ad.getApplicationDay());
										System.out.println("─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
										continue case1;
									}
							}
						}
						
					}
				}	
		}
		System.out.println("0. 이전화면");
		System.out.print("번호 입력: ");
		int applicationMenu = scan.nextInt();
		scan.nextLine();
		if (applicationMenu == 0) {
			return;
		}
	}

	private static void AsApplicationList() {
		Scanner scan = new Scanner(System.in); 

		UserReader.list = new ArrayList<UserData>();
		UserReader.reader(null);;
		AsReader.list = new ArrayList<AsData>();
		AsReader.reader();
		//CatInfoReader.reader("CYC");
		
		System.out.println("                  AS 신청목록");
		System.out.println();
		System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
		System.out.println(" [회원번호] │   [이름]     │             [주소]             │          [전화번호]         │                [제품명]              │     [업체명]   │     [A/S사유]");
		System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
		int count = 0;
		case1 : for (AsData ad : AsReader.list) {
			if(ad.getSituation().equals("확인중")) { //상태가 확인중이면
				for(UserData ud : UserReader.list) {
					if(ad.getUserNum().equals(ud.getNum())) { //고객번호가 일치하는 지 확인
						CatInfoReader.reader(ad.getCode().substring(0, 3)); //일치하면 dummy데이터의 제품코드 호출
						
						for(CatInfoData cd : CatInfoReader.list) {
							
							if(ad.getCode().equals(cd.getCode())) {
								count++;
								System.out.printf("%6d   │%5s\t│%23s\t│\t%13s\t   │\t%18s\t\t│%9s\t│%10s\n "
										                                     ,count, ud.getName(),
										                                 ud.getAddress(), ud.getPhone(),
										                                                           cd.getItemName(),
										                                                           cd.getEntName(), ad.getReason());
								System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
								continue case1;
							}
						}
						
					}
				}
			}	
		}
		
		System.out.println("1. 신청접수 ");
		System.out.println("2. 신청삭제 ");
		System.out.println("0. 이전화면 ");
		System.out.println("──────────────────────────────────────────────────────────────────────────────────");
		System.out.print("번호 입력: ");
		int applicationMenu = scan.nextInt();
		scan.nextLine();
		if (applicationMenu == 0) {
			return;
		}
		if(applicationMenu ==1) {
			
			System.out.print("회원번호를 입력하세요 : ");
			String memberNum  = scan.nextLine();
			receiptApplication(memberNum);
			
		}else if(applicationMenu == 2) {
			System.out.print("회원번호를 입력하세요 : ");
			String memberNum  = scan.nextLine();
			try {
				deleteApplication(memberNum);
				System.out.println("데이터가 삭제되었습니다.");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("잘못된 메뉴 입니다.");
			return;
		}
		
	}
	
	

	private static void receiptApplication(String memberNum) {
		File f = new File("C:\\git\\Project\\Data\\ASinfo.txt");
		AsReader.list = new ArrayList<AsData>();
		AsReader.reader();
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
			int count = 1;;
			for (AsData ad : AsReader.list) {
				if (ad.getSituation().equals("확인중")) {
					if (count == Integer.parseInt(memberNum)) {
						bw.write(String.format("%s,%s,%s,%s,%s,%s\n",
									ad.getCode(),
									ad.getReason(),
									"기사 연결중",
									ad.getApplicationDay(),
									ad.getCompleteDay(),
									ad.getUserNum()));
						count++;
						continue;
					}else {
						bw.write(String.format("%s,%s,%s,%s,%s,%s\n",
								ad.getCode(),
								ad.getReason(),
								ad.getSituation(),
								ad.getApplicationDay(),
								ad.getCompleteDay(),
								ad.getUserNum()));
						count++;
						continue;
					}
				}else {
					bw.write(String.format("%s,%s,%s,%s,%s,%s\n",
							ad.getCode(),
							ad.getReason(),
							ad.getSituation(),
							ad.getApplicationDay(),
							ad.getCompleteDay(),
							ad.getUserNum()));
					continue;
				}
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("접수가 완료되었습니다.");
		
	}

	private static void deleteApplication(String memberNum) throws IOException {
		AsReader.list = new ArrayList<AsData>();
		AsReader.reader();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\git\\Project\\Data\\ASinfo.txt")));
		
		int count = 1;
		for (AsData ad : AsReader.list) {
			if (ad.getSituation().equals("확인중")) {
				if (count == Integer.parseInt(memberNum)) {
					count++;
					continue;
				}else {
					bw.write(String.format("%s,%s,%s,%s,%s,%s\n",
							ad.getCode(),
							ad.getReason(),
							ad.getSituation(),
							ad.getApplicationDay(),
							ad.getCompleteDay(),
							ad.getUserNum()));
					count++;
					continue;
				}
			}else {
				bw.write(String.format("%s,%s,%s,%s,%s,%s\n",
						ad.getCode(),
						ad.getReason(),
						ad.getSituation(),
						ad.getApplicationDay(),
						ad.getCompleteDay(),
						ad.getUserNum()));
				continue;
			}
		}
		bw.close();
		
	}

}
