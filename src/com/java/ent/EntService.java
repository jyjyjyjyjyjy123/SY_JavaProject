package com.java.ent;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.DrbgParameters.NextBytes;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

import com.java.data.AsData;
import com.java.data.CatInfoData;
import com.java.data.CatManageData;
import com.java.data.RentData;
import com.java.reader.AsReader;
import com.java.reader.CatInfoReader;
import com.java.reader.CatManageReader;
import com.java.reader.RentReader;

public class EntService {
	
	public static void print(ArrayList<CatInfoData> info, ArrayList<CatManageData> manage) {
		
		System.out.println();
		System.out.println("[번호]\t[제품 고유번호]\t[렌탈여부]\t[카테고리]\t\t[제품명]\t\t\t[색상]\t[방문주기]\t[다음 방문시간]");
		RentReader.reader();
		ArrayList<String> rentStatus = new ArrayList<String>();
		ArrayList<String> nextTime = new ArrayList<String>();
		ArrayList<String> testCode = new ArrayList<String>();
		for (RentData rd : RentReader.list) {
			for (int i = 0; i < info.size(); i++) {
				if(rd.getCode().equals(info.get(i).getCode())) {
					rentStatus.add(rd.getStatus());
					nextTime.add(rd.getNextVisit());
					testCode.add(rd.getCode());
				}
			}
			
		}
		if(info.size() == manage.size()){
			case1 : for(int i=0; i<=info.size()-1; i++){
				for (int j=0; j<testCode.size(); j++) {
					if (info.get(i).getCode().equals(testCode.get(j))) {
						System.out.printf("%4d\t%5s\t%3s\t%-7s  %-20s\t%-3s\t%5s\t%6s\r\n"
								, i+1
								, info.get(i).getCode()
								, rentStatus.get(j) //렌탈여부
								, info.get(i).getCategoryName()
								, info.get(i).getItemName()
								, info.get(i).getColor()
								, manage.get(i).getMinday() + "개월"
								, nextTime.get(j)); //계약일자를 세팅해서 연산하기
						continue case1;
					}
				}
				System.out.printf("%4d\t%5s\t%3s\t%-7s   %-20s\t%-3s\t%5s\t%6s\r\n"
						, i+1
						, info.get(i).getCode()
						, "-" //렌탈여부
						, info.get(i).getCategoryName()
						, info.get(i).getItemName()
						, info.get(i).getColor()
						, manage.get(i).getMinday() + "개월"
						, "-" ); //계약일자를 세팅해서 연산하기
			}
		} else {
			System.out.println("데이터 불러오기 실패");
		}

	}

	public static void add(EntMeta meta,String entname) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println();
		System.out.println("                제품 등록하기");
		System.out.println("          ---------------------");
		System.out.print("          제품명: ");
		String addname = scan.nextLine();
		System.out.print("          색상: ");
		String addcolor = scan.nextLine();
		System.out.print("          세부사항 1: ");
		String addoption1 = scan.nextLine();
		System.out.print("          세부사항 2: ");
		String addoption2 = scan.nextLine();
		System.out.print("          의무사용기간(개월): ");
		String addMinday = scan.nextLine();
		System.out.print("          방문주기(개월): ");
		String addcycle = scan.nextLine();
		System.out.print("          월 요금(원): ");
		String addmoney = scan.nextLine();
		System.out.println("          ---------------------");
		
		int no = EntData.counter+1;

		String engModel = null;
		
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR); 
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		String monthString = (month < 10) ? "0" + month : String.valueOf(month);
		
		String[] temp = meta.getInfoFile().split("");
		String categoryModel = temp[0]+temp[1]+temp[2];
		
		Random rnd = new Random();
		
		//제품 코드 숫자
		int modelnum = rnd.nextInt(90000) + 10000;
		
		//제품 코드 알파벳
		int asciiValue = rnd.nextInt(26) + 65;
		char alphabet = (char) asciiValue;
		String modelCode = engModel + modelnum + alphabet;
		
		engModel = categoryModel + "_" + year + monthString + day + "_" + no;
	
		CatInfoData pi = new CatInfoData(engModel, meta.getCategory(), Entmain.entLogin, Entmain.entLogin + " "+addname, modelCode, addcolor, addoption1+addoption2);
		CatManageData pm = new CatManageData(engModel, addMinday, addcycle, addmoney);
		
		//System.out.println(pi.toString());
		
		// meta에 저장된 파일명에 pi, pm 저장
		meta.getInfoFile();
		meta.getManageFile();
		
		try {
			BufferedWriter writer1 = new BufferedWriter(new FileWriter("C:\\git\\Project\\Data\\" + meta.getInfoFile(), true));
			writer1.write(String.format("%s,%s,%s,%s,%s,%s,%s\r\n", pi.getCode(), pi.getCategoryName(), pi.getEntName(), pi.getItemName(), pi.getItemCode(), pi.getColor(), pi.getStatus()));
			
			writer1.close();
			
			BufferedWriter writer2 = new BufferedWriter(new FileWriter("C:\\git\\Project\\Data\\" + meta.getManageFile(), true));
			writer2.write(String.format("%s,%s,%s,%s\r\n", pm.getCode(), pm.getMinday(), pm.getCycle(), pm.getMoney()));
			
			writer2.close();
			
			System.out.println("          제품 등록이 완료되었습니다.");
			scan.nextLine();
			
		} catch (Exception e) {
			System.out.println("at Service.add");
			e.printStackTrace();
		}
		
	}

    public static void fix(ArrayList<CatInfoData> info, ArrayList<CatManageData> manage) {
    	
        Scanner scan = new Scanner(System.in);
        
        System.out.println("이전 페이지는 0번을 입력하세요.");
        System.out.print("수정할 제품의 번호를 입력하시오: ");
        int inputIndex = scan.nextInt();
        scan.nextLine();  // Consume the newline character
        if (inputIndex == 0) {
        	return;
        }
        if (inputIndex < 1 || inputIndex > info.size()) {
            System.out.println("유효하지 않은 제품 번호입니다.");
            return;
        }

        CatInfoData modifiedInfo = info.get(inputIndex - 1);
        String category = modifiedInfo.getCode().split("_")[0];
        String modifyCode = modifiedInfo.getCode();

        System.out.print("수정 항목 선택: 1. 색상, 2. 방문주기: ");
        int num = scan.nextInt();
        scan.nextLine();  // Consume the newline character

        String color= null;
        if (num == 1) {
            System.out.print("새로운 색상을 입력하세요: ");
            color = scan.nextLine();

            modifiedInfo.setColor(color);
        } else if (num == 2) {
            System.out.print("새로운 방문주기를 입력하세요: ");
            String visit = scan.nextLine();

            for (CatManageData productManage : manage) {
                if (productManage.getCode().equals(modifyCode)) {
                    productManage.setCycle(visit);
                    break;
                }
            }
        } else {
            System.out.println("유효하지 않은 선택입니다.");
            return;
        }

        try {
        	int count = 0;
        	String temp = null;
        	for (CatInfoData cid : info) {
        		count++;
        		if (inputIndex == count) {
        			temp = cid.getCode();
        		}
        	}
        	CatInfoReader.list = new ArrayList<CatInfoData>();
        	CatInfoReader.reader(category);
            BufferedWriter writer1 = new BufferedWriter(new FileWriter("C:\\git\\Project\\Data\\" + category + "info.txt"));
            for (CatInfoData productInfo : CatInfoReader.list) {
            	if (productInfo.getCode().equals(temp)) {
            		writer1.write(String.format("%s,%s,%s,%s,%s,%s,%s\r\n",
                            productInfo.getCode(), productInfo.getCategoryName(),
                            productInfo.getEntName(), productInfo.getItemName(),
                            productInfo.getItemCode(), color,
                            productInfo.getStatus()));
            		continue;
            	}
                writer1.write(String.format("%s,%s,%s,%s,%s,%s,%s\r\n",
                        productInfo.getCode(), productInfo.getCategoryName(),
                        productInfo.getEntName(), productInfo.getItemName(),
                        productInfo.getItemCode(), productInfo.getColor(),
                        productInfo.getStatus()));
            }
            writer1.close();

        	CatManageReader.list = new ArrayList<CatManageData>();
        	CatManageReader.reader(category);
            BufferedWriter writer2 = new BufferedWriter(new FileWriter("C:\\git\\Project\\Data\\" + category + "manage.txt"));
            for (CatManageData productManage : CatManageReader.list) {
                writer2.write(String.format("%s,%s,%s,%s\r\n",
                        productManage.getCode(), productManage.getMinday(),
                        productManage.getCycle(), productManage.getMoney()));
            }
            writer2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("선택하신 제품이 수정되었습니다.");
    }

	public static void delete(ArrayList<CatInfoData> info, ArrayList<CatManageData> manage){
		
		Scanner scan = new Scanner(System.in);
		System.out.println("삭제할 제품의 번호를 입력하시오. (이전 페이지는 0번을 입력하세요.)");
		System.out.print("번호입력 : ");
		String inputCode = scan.nextLine();
		String[] category = null;
		String removeCode = null;
		if (inputCode.equals("0")) {
			return;
		}
		for(int i=0; i<=info.size()-1; i++){
			if (i+1 == Integer.parseInt(inputCode)) {
				removeCode = info.get(i).getCode();
				category = removeCode.split("_");
			}
		}
		CatInfoReader.list = new ArrayList<CatInfoData>();
		CatInfoReader.reader(category[0]);
		RentReader.list = new ArrayList<RentData>();
		RentReader.reader();
		int count = 0;
		for (CatInfoData cid : CatInfoReader.list) {
			if (cid.getEntName().equals(Entmain.entLogin)) {
				count++;
				if (count == Integer.parseInt(inputCode)) {
					for (RentData rd : RentReader.list) {
						if (cid.getCode().equals(rd.getCode())) {
							if (rd.getStatus().equals("렌탈중")) {
								System.out.println("렌탈중인 제품은 삭제할 수 없습니다.");
								return;
							}
						}
					}
				}
			}
		}
		try {
			CatInfoReader.list = new ArrayList<CatInfoData>();
			CatManageReader.list = new ArrayList<CatManageData>();
			CatInfoReader.reader(category[0]);
			CatManageReader.reader(category[0]);
			BufferedWriter writer1 = new BufferedWriter(new FileWriter("C:\\git\\Project\\Data\\"+category[0]+"info.txt"));
			for (CatInfoData cid : CatInfoReader.list) {
				if (cid.getCode().equals(removeCode)) {
					continue;
				}
				writer1.write(String.format("%s,%s,%s,%s,%s,%s,%s\r\n", cid.getCode(), cid.getCategoryName(), cid.getEntName(), cid.getItemName(), cid.getItemCode(), cid.getColor(), cid.getStatus()));
			}
			writer1.close();
			BufferedWriter writer2 = new BufferedWriter(new FileWriter("C:\\git\\Project\\Data\\" + category[0]+"manage.txt"));
			
			for (CatManageData cmd : CatManageReader.list) {
				if (cmd.getCode().equals(removeCode)) {
					continue;
				}
				writer2.write(String.format("%s,%s,%s,%s\r\n", cmd.getCode(), cmd.getMinday(), cmd.getCycle(), cmd.getMoney()));
			}
			
			writer2.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("선택하신 제품이 삭제 됐습니다.");
		
			}
	
	 public static void asList(ArrayList<CatInfoData> info, ArrayList<CatManageData> manage) {
		 Scanner scan = new Scanner(System.in);
	        System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
	        System.out.println("                                                              <A/S 현황보기>");
	        System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
	        System.out.println("\t[고유번호]\t\t[카테고리]\t\t[제품명]\t\t\t[색  상]\t\t[고장원인]\t\t\t[진행상황]");
	        System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");

	        EntData.asLoad();

	        int num = 1;
	        for (AsData a : EntData.list) {
	            String engModel = a.getCode(); // AS 정보의 code 가져오기
	            String category = engModel.split("_")[0]; // 카테고리 정보 가져오기
	            try {
	            	
	                BufferedReader reader = new BufferedReader(new FileReader("C:\\git\\Project\\Data\\" + category + "info.txt"));
	                String line;
	                while ((line = reader.readLine()) != null) {
	                    String[] data = line.split(",");
	                    if (data.length >= 8 && data[0].equals(engModel)) {
	                        String categoryName = data[1];
	                        String productName = data[3];
	                        
	                        String[] productNameParts = productName.split(" "); // 공백을 기준으로 분할
	                        if (productNameParts.length > 1) {
	                            productName = productNameParts[1]; // 두 번째 부분(엑시언트)을 가져옴
	                        }

	                        String color = data[5];
	                        String symptom = a.getReason();
	                        String progress = a.getSituation();
	                        String company = data[2];  // Adding this line to extract the data[2] value

	                        if (company.equals(Entmain.entLogin)) {
		                        System.out.printf("\t%5d\t\t%-10s\t%-20s\t%-3s\t\t%-20s\t%-3s\n"
		                                , num
		                                , categoryName
		                                , productName
		                                , color
		                                , symptom
		                                , progress);
	                        num++;
	                        }
	                        break; // 해당 AS에 매칭되는 제품 정보를 찾았으면 반복문 종료
	                    }
	                }
	                reader.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	        String choice = null;
	        String situationChoice = null;
        	String situationChange = null;
	        boolean loop = true;
	        while(loop) {
	        	System.out.println("이번 페이지로 가고싶으시면 0번을 입력하세요.");
	        	System.out.print("- 진행상황을 수정할 제품을 선택하시오: ");
	        	choice = scan.nextLine();
	        	if (choice.equals("0")) {
	        		return;
	        	}
	        	System.out.println("1. 기사 연결중");
	        	System.out.println("2. 방문 대기중");
	        	System.out.println("3. 수리 완료");
	        	System.out.print("- 진행상황 선택: ");
	        	situationChoice = scan.nextLine();
	        	switch (situationChoice){
	        	case "1": {
	        		situationChange = "기사 연결중";
	        		loop = false;
	        		break;
	        	}
	        	case "2": {
	        		situationChange = "방문 대기중";
	        		loop = false;
	        		break;
	        	}
	        	case "3": {
	        		situationChange = "수리 완료";
	        		loop = false;
	        		break;
	        	}
	        	default:
	        		System.out.println("잘못된 선택 입니다.");
	        		continue;
	        	}
	        }
	        num=0;
	        AsReader.list = new ArrayList<AsData>();
	        AsReader.reader();
	        for (AsData ad : AsReader.list) {
	        	String engModel = ad.getCode(); // AS 정보의 code 가져오기
	            String category = engModel.split("_")[0]; // 카테고리 정보 가져오기
	            CatInfoReader.list = new ArrayList<CatInfoData>();
	            CatInfoReader.reader(category);
	            for (CatInfoData cid : CatInfoReader.list) {
	            	if (ad.getCode().equals(cid.getCode())) {
	            		if (cid.getEntName().equals(Entmain.entLogin)) {
	            			num++;
	            			if (num == Integer.parseInt(choice)) {
                        		ad.setSituation(situationChange);
                        	}
	            		}
	            	}
	            }
	        }
	        try {
		        BufferedWriter wirter = new BufferedWriter(new FileWriter("C:\\git\\Project\\Data\\ASinfo.txt"));
		        for (AsData ad : AsReader.list) {
						wirter.write(String.format("%s,%s,%s,%s,%s,%s\n",ad.getCode(),ad.getReason(),ad.getSituation(),ad.getApplicationDay(),ad.getCompleteDay(),ad.getUserNum()));
		        	
		        }
		        wirter.close();
		        System.out.println("수정 완료 되었습니다.");
		        scan.nextLine();
	        } catch (IOException e) {
	        	e.printStackTrace();
	        }

	    }
	 
		public static void pause() {
			Scanner scan = new Scanner(System.in);
			System.out.println();
			System.out.println("- 뒤로 가려면 엔터를 입력해주세요 -");
			scan.nextLine();
		}
}


















