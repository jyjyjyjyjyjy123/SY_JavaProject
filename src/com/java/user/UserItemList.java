package com.java.user;

import java.util.ArrayList;
import java.util.Scanner;

import com.java.data.CatManageData;
import com.java.data.CatInfoData;
import com.java.data.RentData;
import com.java.reader.CatManageReader;
import com.java.reader.CatInfoReader;
import com.java.reader.RentReader;

public class UserItemList {
	public static void itemList(String categoryCode) {
		Scanner scan = new Scanner(System.in);
		boolean loop = true;
		while (loop) {
			int count = 0;
			System.out.println("                                         제품 목록 ");
			System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
			System.out.println(" 항목번호 │　    제조사  　   │     　     　　　제품명   　   　    │    　색상　 　　 │    렌탈료　   │　최소계약기간　│     상세사항 ");
			System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
			CatInfoReader.list = new ArrayList<CatInfoData>();
			CatInfoReader.reader(categoryCode);
			CatManageReader.list = new ArrayList<CatManageData>();
			CatManageReader.reader(categoryCode);
			RentReader.list = new ArrayList<RentData>();
			RentReader.reader();
			loop1 : for (CatInfoData cid : CatInfoReader.list) {		
				for (CatManageData cmd : CatManageReader.list) {
					if (cmd.getCode().equals(cid.getCode())) {
						for (RentData RM : RentReader.list) {
							if (RM.getCode().equals(cid.getCode())) {
								continue loop1;
							}
						}
						count++;
						System.out.printf("　%6d│　%-10s\t│   %-20s\t │ %-7s\t│ %,9d원 │    %2s개월  │%s \n"
								, count, cid.getEntName(), cid.getItemName(), cid.getColor()
								, Integer.parseInt(cmd.getMoney()), cmd.getMinday(), cid.getStatus());
					}
				}
			}
			System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
			System.out.println("렌탈을 원하는 품목의 항목번호를 입력                                                                    0. 이전 페이지 ");
			System.out.print("                                             번호 입력: ");
			String inputMenuNum = scan.nextLine();
			if (inputMenuNum.equals("0")) {
				return;
			}else if (Integer.parseInt(inputMenuNum) > count) {
				System.out.println("해당 항목번호의 제품은 존재하지 않습니다.");
				scan.nextLine();
				continue;
			}
			UserItemList.choiceItem(inputMenuNum, categoryCode);
			
		}
	}
	public static void choiceItem(String inputMenuNum, String categoryCode) {
		Scanner scan = new Scanner(System.in);
		int count = 0;
		CatInfoReader.list = new ArrayList<CatInfoData>();
		CatInfoReader.reader(categoryCode);
		CatManageReader.list = new ArrayList<CatManageData>();
		CatManageReader.reader(categoryCode);
		RentReader.list = new ArrayList<RentData>();
		RentReader.reader();
		loop1 : for (CatInfoData cid : CatInfoReader.list) {		
			for (CatManageData cmd : CatManageReader.list) {
				if (cmd.getCode().equals(cid.getCode())) {
					for (RentData RM : RentReader.list) {
						if (RM.getCode().equals(cid.getCode())) {
							continue loop1;
						}
					}
					if (inputMenuNum.equals(inputMenuNum)) {
						count++;
						if (count == Integer.parseInt(inputMenuNum)) {
							UserRentPage.rentPage(cmd.getMinday(), cmd.getMoney(), cid.getEntName(), cid.getItemName(), cid.getCode(), cmd.getCycle());
							return;
						}
					}else {
						System.out.println("해당 항목번호의 제품은 존재하지 않습니다.");
						scan.nextLine();
					}
				}
			}
		}
	}
}
