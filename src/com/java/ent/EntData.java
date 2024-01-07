package com.java.ent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import com.java.data.AsData;
import com.java.data.CatInfoData;
import com.java.data.CatManageData;
import com.java.reader.CatInfoReader;

public class EntData {
	
	public static ArrayList<CatInfoData> info;
	public static ArrayList<CatManageData> manage;
	public static ArrayList<AsData> list;
	static {
		EntData.list = new ArrayList<AsData>();
	}
	
	static { EntData.info = new ArrayList<CatInfoData>();
	
	}

	static { EntData.manage = new ArrayList<CatManageData>();
	
	}

	
	public static Integer counter = 0;
	
	
	public static EntMeta loadDetail(String entname) {
		String folderPath = "C:\\git\\Project\\Data\\";
		String[] infoFileNames = null;
		String[] infoFileDescriptions = null;
		String[] manageFileNames = null;

		EntData.info.clear();
		EntData.manage.clear();
		EntData.counter = 0;

		// 회사별 카테고리 분류
		switch(entname){
			case "바이마트":
			case "가전의 모든것":
			case "헬로가전":
				infoFileNames = new String[]{"REFinfo.txt", "WASinfo.txt", "AICinfo.txt", "MSCinfo.txt", "TEVinfo.txt", "OVNinfo.txt"};
				infoFileDescriptions = new String[]{"냉장고", "세탁기", "에어컨", "안마의자", "TV", "오븐"};
				manageFileNames = new String[]{"REFmanage.txt", "WASmanage.txt", "AICmanage.txt", "MSCmanage.txt", "TEVmanage.txt", "OVNmanage.txt"};
				break;
			case "노크온":
			case "일렉트론":
			case "아인전자":
				infoFileNames = new String[]{"LAPinfo.txt", "TABinfo.txt", "MONinfo.txt", "BEPinfo.txt", "CAMinfo.txt"};
				infoFileDescriptions = new String[]{"노트북", "태블릿", "모니터", "빔프로젝트", "카메라"};
				manageFileNames = new String[]{"LAPmanage.txt", "TABmanage.txt", "MONmanage.txt", "BEPmanage.txt", "CAMmanage.txt"};
				break;
			case "간지레저":
			case "W렌트샵":
			case "Play렌탈":
				infoFileNames = new String[]{"TNTinfo.txt", "CACinfo.txt", "YACinfo.txt", "GOLinfo.txt"};
				infoFileDescriptions = new String[]{"텐트", "캠핑카", "요트", "골프"};
				manageFileNames = new String[]{"TNTmanage.txt", "CACmanage.txt", "YACmanage.txt", "GOLmanage.txt"};
				break;
			case "캐터필러":
			case "세창건설":
			case "성심중기":
				infoFileNames = new String[]{"DUMinfo.txt", "FOKinfo.txt", "REMinfo.txt", "LATinfo.txt", "FLTinfo.txt", "CRAinfo.txt"};
				infoFileDescriptions = new String[]{"덤프트럭", "포크레인", "레미콘", "사다리차", "지게차", "크레인"};
				manageFileNames = new String[]{"DUMmanage.txt", "FOKmanage.txt", "REMmanage.txt", "LATmanage.txt", "FLTmanage.txt", "CRAmanage.txt"};
				break;
			case "빌리고":
			case "드로잉홈":
			case "미래유통":
				infoFileNames = new String[]{"BACinfo.txt", "COUinfo.txt", "BEDinfo.txt", "TALinfo.txt", "BOWinfo.txt"};
				infoFileDescriptions = new String[]{"유모차", "쇼파", "침대", "식탁", "그릇"};
				manageFileNames = new String[]{"BACmanage.txt", "COUmanage.txt", "BEDmanage.txt", "TALmanage.txt", "BOWmanage.txt"};
				break;
			case "S휘트니스":
			case "아이언GYM":
			case "건강해GYM":
				infoFileNames = new String[]{"RUMinfo.txt", "SMMinfo.txt", "RWMinfo.txt", "CYCinfo.txt"};
				infoFileDescriptions = new String[]{"러닝머신", "스미스머신", "로잉머신", "사이클"};
				manageFileNames = new String[]{"RUMmanage.txt", "SMMmanage.txt", "RWMmanage.txt", "CYCmanage.txt"};
				break;
		}
		
		
		try {
			// 회사의 카테고리 출력
			System.out.println();
			System.out.println("          ┌───────────────────────────┐");
			System.out.println("          │         카테고리 선택     　　　│");
			System.out.println("          └───────────────────────────┘");
			
			int num = 0;
			
			for(String Description : infoFileDescriptions){
				num++;
				System.out.println("          "+Description + " " + num + " 번");
			}
			System.out.println("          이전 페이지 0 번");

			// 카테고리 선택 코드
			Boolean loop = true;
			int inputNum = 0;
			while(loop){
				Scanner scan = new Scanner(System.in);
				System.out.print("          번호입력 : ");
				inputNum = scan.nextInt();
				if (inputNum == 0) {
					return null;
				}
				if((1<= inputNum) && (inputNum <= infoFileNames.length)) {
					loop = false;
				}
			}
			// [infoFile] 선택한 카테고리를 경로로 지정, 해당 파일로 파일의 전체 크기 설정(counter)
			String infoFilePath = folderPath + infoFileNames[inputNum-1];
			BufferedReader reader1 = new BufferedReader(new FileReader(infoFilePath));
			String line = null;
			while ((line = reader1.readLine()) != null) {
					String status = "";
					String[] temp = line.split(",");
					for (int i = 6; i < temp.length; i++) {
						if (i == temp.length-1) {
							status += temp[i]; 
						}else {
							status += temp[i] + ", "; 
						}
					}
					counter++;

					if(temp[2].equals(entname)){
						CatInfoData cid = new CatInfoData(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], status);
						EntData.info.add(cid);
					}
			}
			reader1.close();
			
			// [manageFile] 선택한 카테고리를 경로로 지정
			String manageFilePath = folderPath + manageFileNames[inputNum-1];
			BufferedReader reader2 = new BufferedReader(new FileReader(manageFilePath));
			line = null;
			int choose = 0;
			while ((line = reader2.readLine()) != null) {
					String[] temp1 = line.split(",");
					if(temp1[0].equals(EntData.info.get(choose).getCode())){
						CatManageData p = new CatManageData(temp1[0], temp1[1], temp1[2], temp1[3]);
						EntData.manage.add(p);
						choose++;
					}
					if(EntData.info.size()==choose) {
						break;
					}
			}
			reader2.close();
			
			// info 파일명, 한글 카테고리, manage 파일명 -> Meta 자료형으로 반환
			return new EntMeta(infoFileNames[inputNum-1], infoFileDescriptions[inputNum-1], manageFileNames[inputNum-1]);
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
				
	public static void asLoad() {
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("C:\\git\\Project\\Data\\ASinfo.txt"));
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split(",");
				
				AsData a = new AsData(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5]);
				
				EntData.list.add(a);
			}
			
			reader.close();
		} catch (Exception e) {
			System.out.println("at Data.loadDetail");
			e.printStackTrace();
		}
	}
}
