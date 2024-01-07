package com.java.admin;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.java.data.CatInfoData;
import com.java.reader.CatInfoReader;

public class adminList {

	public static void list() {
		System.out.println(" _____   ___   _     ______  _____  _   _  _____ \r\n"
				+ "|_   _| / _ \\ | |    | ___ \\|  ___|| \\ | ||_   _|\r\n"
				+ "  | |  / /_\\ \\| |    | |_/ /| |__  |  \\| |  | |  \r\n"
				+ "  | |  |  _  || |    |    / |  __| | . ` |  | |  \r\n"
				+ "  | |  | | | || |____| |\\ \\ | |___ | |\\  |  | |  \r\n"
				+ "  \\_/  \\_| |_/\\_____/\\_| \\_|\\____/ \\_| \\_/  \\_/  \r\n"
				+ "");
	
		
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("      ┌──────────────────────────────────┐");
		System.out.println("                    제품 리스트 목록		");
		System.out.println("      ├──────────────────────────────────┤");
		System.out.println("                    1.카테고리 검색		");
		System.out.println("      ├──────────────────────────────────┤");		
		System.out.println("                    2.제품 삭제      　　");
		System.out.println("      ├──────────────────────────────────┤");	
		System.out.println("                    0.이전 화면          ");
		System.out.println("      └──────────────────────────────────┘");
		System.out.print("        숫자 입력: ");
		String listInput = scan.nextLine();
		System.out.println();
		System.out.println();

		
		
		if (listInput.equals("1")) {
			category();
		} else if (listInput.equals("2")) {
			delete();
		} else if (listInput.equals("0")) {
			adminManager.productManagement();
		} else {
			System.out.println("잘못된 입력입니다. 올바른 숫자를 입력해주세요");
			adminManager.pause();
		}
		
		
	}
	


	private static void delete() {
	    adminManager.subTitle("제품 삭제");
	    System.out.println("삭제할 제품의 관리번호를 작성해주세요.");
	    System.out.println("ex) CRA_20230814, TEV_20230814_3");
	    Scanner scan = new Scanner(System.in);
	    System.out.println("이전 페이지는 0번을 입력하세요.");
	    System.out.print("제품고유번호: ");
	    String code = scan.nextLine();
	    if (code.equals("0")) {
	    	return;
	    }
	    String[] category = code.split("_"); // 관리번호를 카테고리와 날짜로 분리

	    CatInfoReader.reader(category[0]); // 해당 카테고리에 대한 정보 로드

	    for (CatInfoData s : CatInfoReader.list) {
	        if (s.getCode().equals(code)) { // 관리번호가 일치하는 제품 정보를 찾음
	            CatInfoReader.list.remove(s); // 제품 정보 제거
	            break;
	        }
	    }

	    try {
	        CatInfoReader.list = new ArrayList<CatInfoData>();
	        CatInfoReader.reader(category[0]); // 변경된 정보 다시 로드
	        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\git\\Project\\Data\\" + category[0] + "info.txt"));
	        for (CatInfoData categorydata : CatInfoReader.list) {
	            if (categorydata.getCode().equals(code)) {
	                continue; // 삭제된 제품은 기록하지 않음
	            }
	            writer.write(String.format("%s,%s,%s,%s,%s,%s,%s\n"
	                    , categorydata.getCode()
	                    , categorydata.getCategoryName()
	                    , categorydata.getEntName()
	                    , categorydata.getItemName()
	                    , categorydata.getItemCode()
	                    , categorydata.getColor()
	                    , categorydata.getStatus().trim()));
	        }
	        writer.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    System.out.println("제품 삭제가 완료되었습니다.");
	    adminManager.pause();
	}





	public static void category() {
		
		System.out.println(" _____   ___   _     ______  _____  _   _  _____ \r\n"
				+ "|_   _| / _ \\ | |    | ___ \\|  ___|| \\ | ||_   _|\r\n"
				+ "  | |  / /_\\ \\| |    | |_/ /| |__  |  \\| |  | |  \r\n"
				+ "  | |  |  _  || |    |    / |  __| | . ` |  | |  \r\n"
				+ "  | |  | | | || |____| |\\ \\ | |___ | |\\  |  | |  \r\n"
				+ "  \\_/  \\_| |_/\\_____/\\_| \\_|\\____/ \\_| \\_/  \\_/  \r\n"
				+ "");

		Scanner scan = new Scanner(System.in);
		System.out.println("      ┌──────────────────────────────────┐");
		System.out.println("                    카테고리 검색		");
		System.out.println("      ├──────────────────────────────────┤");
		System.out.println("                    1.가전제품		");
		System.out.println("      ├──────────────────────────────────┤");		
		System.out.println("                    2.전자제품      　　");
		System.out.println("      ├──────────────────────────────────┤");	
		System.out.println("                    3.생활용품          ");
		System.out.println("      ├──────────────────────────────────┤");	
		System.out.println("                    4.중장비          ");
		System.out.println("      ├──────────────────────────────────┤");	
		System.out.println("                    5.레저          ");
		System.out.println("      ├──────────────────────────────────┤");	
		System.out.println("                    6.운동기구          ");
		System.out.println("      └──────────────────────────────────┘");
		System.out.print("      숫자 입력: ");
		String categoryInput = scan.nextLine();
		System.out.println();
		System.out.println();
		
		
		if(categoryInput.equals("1")) {
			homeProduct();
		} else if (categoryInput.equals("2")) {
			electronicProduct();
		} else if (categoryInput.equals("3")) {
			lifeProduct();
		} else if (categoryInput.equals("4")) {
			heavyEquipment();
		} else if (categoryInput.equals("5")) {
			leisure();
		} else if (categoryInput.equals("6")){
			fitnessEquipment();
		} else {
			System.out.println("잘못된 입력입니다. 올바른 번호를 입력하세요.");
		}
		
		
	}



	private static void fitnessEquipment() {
		System.out.println("   [관리번호]\t     [카테고리]\t[업체명]\t      [제품명]\t[제품번호]\t\t[색상]\t\t\t[상세사항]");
		String[] electronicProducrt = {"SMM", "RWM", "RUM", "CYC"};
		for (int i = 0; i < electronicProducrt.length; i++) {
			CatInfoReader.list = new ArrayList<CatInfoData>();
			CatInfoReader.reader(electronicProducrt[i]);
			for (CatInfoData s : CatInfoReader.list) {
				System.out.printf("%s\t%10s\t%5s\t%10s\t%6s\t%5s\t\t%10s\r\n"
						,s.getCode()
						,s.getCategoryName()
						,s.getEntName()
						,s.getItemName()
						,s.getItemCode()
						,s.getColor()
						,s.getStatus());
	
		}
	}
		adminManager.pause();
		
	}



	private static void leisure() {
		System.out.println("   [관리번호]\t\t[카테고리]\t\t[업체명]\t\t [제품명]\t\t[제품번호]\t\t[색상]\t\t[상세사항]");
		String[] electronicProducrt = {"TNT", "CAC", "YAC", "GOL"};
		for (int i = 0; i < electronicProducrt.length; i++) {
			CatInfoReader.list = new ArrayList<CatInfoData>();
			CatInfoReader.reader(electronicProducrt[i]);
			for (CatInfoData s : CatInfoReader.list) {
				System.out.printf("%10s\t%10s\t\t%-5s\t\t%-10s\t%-10s\t%-5s\t\t%-10s\r\n"
						,s.getCode()
						,s.getCategoryName()
						,s.getEntName()
						,s.getItemName()
						,s.getItemCode()
						,s.getColor()
						,s.getStatus());
	
		}
	}
		adminManager.pause();
}



	private static void heavyEquipment() {
		System.out.println("   [관리번호]\t  [카테고리]  [업체명]\t\t  [제품명]\t     [제품번호]\t  [색상]\t\t    [상세사항]");
		String[] electronicProducrt = {"FOK", "CRA", "FLT", "LAT", "REM", "DUM"};
		for (int i = 0; i < electronicProducrt.length; i++) {
			CatInfoReader.list = new ArrayList<CatInfoData>();
			CatInfoReader.reader(electronicProducrt[i]);
			for (CatInfoData s : CatInfoReader.list) {
				System.out.printf("%s\t%6s\t%8s\t%17s\t %12s\t %5s\t\t%10s\r\n"
						,s.getCode()
						,s.getCategoryName()
						,s.getEntName()
						,s.getItemName()
						,s.getItemCode()
						,s.getColor()
						,s.getStatus());
	
		}
	}	
		adminManager.pause();
}



	private static void lifeProduct() {
		System.out.println("   [관리번호]\t  [카테고리]   [업체명]\t[제품명]\t  [제품번호]\t  [색상]\t\t\t    [상세사항]");
		String[] electronicProducrt = {"BED", "BAC", "TAL", "COU", "BOW"};
		for (int i = 0; i < electronicProducrt.length; i++) {
			CatInfoReader.list = new ArrayList<CatInfoData>();
			CatInfoReader.reader(electronicProducrt[i]);
			for (CatInfoData s : CatInfoReader.list) {
				System.out.printf("%s\t%6s\t%8s%10s\t %s\t %8s\t\t%10s\r\n"
						,s.getCode()
						,s.getCategoryName()
						,s.getEntName()
						,s.getItemName()
						,s.getItemCode()
						,s.getColor()
						,s.getStatus());
	
		}
	}	
		adminManager.pause();
}



	private static void electronicProduct() {
			System.out.println("   [관리번호]\t  [카테고리]   [업체명]\t      [제품명]\t  [제품번호]\t [색상]\t\t\t\t[상세사항]");
			String[] electronicProducrt = {"LAP", "TAB", "MON", "BEP", "CAM"};
			for (int i = 0; i < electronicProducrt.length; i++) {
				CatInfoReader.list = new ArrayList<CatInfoData>();
				CatInfoReader.reader(electronicProducrt[i]);
				for (CatInfoData s : CatInfoReader.list) {
					System.out.printf("%s\t%6s\t%8s\t%10s\t %s\t %5s\t\t%s\n"
							
							,s.getCode()
							,s.getCategoryName()
							,s.getEntName()
							,s.getItemName()
							,s.getItemCode()
							,s.getColor()
							,s.getStatus());
		
		}
	}
			adminManager.pause();
}
	


	private static void homeProduct()  {
		System.out.println("   [관리번호]\t [카테고리]\t[업체명]\t\t    [제품명]\t\t  [제품번호]\t   [색상]\t\t\t[상세사항]");
		String[] homeProduct = {"REF", "WAS", "AIC", "MSC", "TEV", "OVN"};
		for (int i = 0; i < homeProduct.length; i++) {
			CatInfoReader.list = new ArrayList<CatInfoData>();
			CatInfoReader.reader(homeProduct[i]);
			for (CatInfoData s : CatInfoReader.list) {
				
				System.out.printf("%s\t %5s\t %8s\t %20s\t %s\t %5s\t\t%14s\r\n"
						,s.getCode()
						,s.getCategoryName()
						,s.getEntName()
						,s.getItemName()
						,s.getItemCode()
						,s.getColor()
						,s.getStatus());
			}
			
		}
		
		adminManager.pause();
		
	}

}
