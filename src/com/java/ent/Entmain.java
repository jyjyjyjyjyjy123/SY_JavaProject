package com.java.ent;

import java.util.ArrayList;
import java.util.Scanner;

import com.java.data.AsData;
import com.java.data.CatInfoData;
import com.java.data.CatManageData;

public class Entmain {
	public static String entLogin = null;
	public static void entmain() {
		
		boolean loop = true;
		
		while (loop) {
			System.out.println("          ─────────────────────────────");
			System.out.println("                     기업회원 메뉴");
			System.out.println("          ─────────────────────────────");
			System.out.println();
			System.out.println("          ┌───────────────────────────┐");
			System.out.println("          │        1. 제품 목록 확인  　　　│");
			System.out.println("          ├───────────────────────────┤");		
			System.out.println("          │        2. 제품 등록       　　│");
			System.out.println("          ├───────────────────────────┤");		
			System.out.println("          │        3. 제품 정보 수정　 　　 │");
			System.out.println("          ├───────────────────────────┤");		
			System.out.println("          │        4. 제품 삭제하기 　 　 　│");
			System.out.println("          ├───────────────────────────┤");		
			System.out.println("          │        5. A/S 현황   　　 　　│");
			System.out.println("          └───────────────────────────┘");
			System.out.println("                               0. 로그아웃");

			
			Scanner scan = new Scanner(System.in);
			
			System.out.print("          번호입력 : ");
			
			int inputNum = scan.nextInt();
			
			if (inputNum == 1) {

				EntData.list = new ArrayList<AsData>();
				EntData.info = new ArrayList<CatInfoData>();
				EntData.manage = new ArrayList<CatManageData>();
				EntMeta meta = EntData.loadDetail(Entmain.entLogin);
				
				if(meta == null){

				} else {
					EntService.print(EntData.info, EntData.manage);
				}
				
				EntService.pause();
				
			} else if (inputNum == 2) {

				EntData.list = new ArrayList<AsData>();
				EntData.info = new ArrayList<CatInfoData>();
				EntData.manage = new ArrayList<CatManageData>();
				EntMeta meta = EntData.loadDetail(Entmain.entLogin);
				
				if(meta == null){

				}else{
					EntService.add(meta, Entmain.entLogin);
				}
				
			} else if (inputNum == 3) {

				EntData.list = new ArrayList<AsData>();
				EntData.info = new ArrayList<CatInfoData>();
				EntData.manage = new ArrayList<CatManageData>();
				EntMeta meta = EntData.loadDetail(Entmain.entLogin);
				
				if(meta == null){

				}else{
					EntService.print(EntData.info, EntData.manage);
					EntService.fix(EntData.info, EntData.manage);
				}
			} else if (inputNum == 4) {

				EntData.list = new ArrayList<AsData>();
				EntData.info = new ArrayList<CatInfoData>();
				EntData.manage = new ArrayList<CatManageData>();
				EntMeta meta = EntData.loadDetail(Entmain.entLogin);
				
				if(meta == null){
					
				}else{
					EntService.print(EntData.info, EntData.manage);
					EntService.delete(EntData.info, EntData.manage);
				}
				
				EntService.pause();
				
			} else if(inputNum == 5) {

				EntData.list = new ArrayList<AsData>();
				EntData.info = new ArrayList<CatInfoData>();
				EntData.manage = new ArrayList<CatManageData>();
				EntService.asList(EntData.info, EntData.manage);
			}else if (inputNum == 0){
				System.out.println("로그아웃");
				loop = false;
			}else { 
				System.out.println("유효한 번호를 선택해주세요.");
			}
		}

	}

}
