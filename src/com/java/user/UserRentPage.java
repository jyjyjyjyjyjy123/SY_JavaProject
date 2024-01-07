package com.java.user;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import com.java.data.EntData;
import com.java.data.RentData;
import com.java.reader.EntReader;
import com.java.reader.RentReader;

public class UserRentPage {
	public static void rentPage(String day, String money, String entName, String itemName, String code, String cycle){
		Scanner scan = new Scanner(System.in);
		String plusAdress = "";
		System.out.println("");
		System.out.println("                                       약관 동의");
		System.out.println("──────────────────────────────────────────────────────────────────────────────────────────");
		System.out.println("1. 해당 제품의 렌탈 의무 사용 기간은 " + day + "개월 이며, 약정기간 동안 렌탈료를 완납후 소유권은 고객에게 자동 이전됩니다.");
		System.out.println("2. 렌탈 계약금 최초 납입금으로 의무사용 기간 내 반환 시 환불되지 않습니다. (중도 반환 시 위약금 별도 청구)\n"
						 + "   단, 14일 이내에 청약 철회시 렌탈 계약금은 환불되나, 반환 회수 비용 3만원을 재하고 환불됩니다.(현금결제 고객의 경우)\n"
						 + "   렌탈 계약금 카드 결제 고객은 렌탈 계약금 전액 취소 후, 최초 카드번호로 반환 회수 비용을 재결제 합니다.\n"
						 + "1) 상기 모든 계약 사항 및 후면 계약 조항에 대해 "+ entName +"및 "+ entName +"의 위탁판매인을 통하여 충분한 설명을 듣고 이해하였습니다\n"
						 + "2) 계약은 고객의 청약에 대하여 회사가 본인확인(해피콜) 후 고객이 요청한 주소에 상품을 배송함으로써 성립하며, \n"
						 + "   청약자는 방문판매법에 따라 상품 인수 후 14일 이내 청약 철회를 할 수 있습니다.\n"
						 + "3) 의무사용 기간(약정기간)내에 해약을 할 경우, 렌탈약관 제11조에 의한 위약금을 납부하여야 합니다.\n"
						 + "4) 상품 렌탈 시 최초 상품의 설치 비용은 회사가 부담하며, 상품의 문제로 인해 발생하는 A/S는 무상 진행합니다.\n"
						 + "   단, 고객의 과실에 의한 A/S발생 시 별도의 엔지니어 방문 및 부품 등 비용이 청구됩니다.");
		System.out.println("──────────────────────────────────────────────────────────────────────────────────────────");
		System.out.print("약관에 동의 하시겠습니까?(Y/N): ");
		System.out.println("");
		String choice = scan.nextLine();
		boolean loop =true;
		if (choice.equals("Y") || choice.equals("y")) {
			while (loop) {
				Calendar today = Calendar.getInstance();
				today.add(Calendar.DAY_OF_MONTH, 3);
				EntReader.list = new ArrayList<EntData>();
				EntReader.reader();
					for (EntData ed :EntReader.list) {
						if (ed.getName().equals(entName)){
							System.out.println("성명: "+ UserMain.loginUser[3]);
							System.out.println("주소: "+ UserzipNo.adress(UserMain.loginUser[7]) +" - "+ UserMain.loginUser[7]+" "+plusAdress);
							System.out.println("계약 업체: " + entName);
							System.out.println("상품명: " + itemName);
							System.out.println("계약 기간: " + day+"개월");
							System.out.println("월 납입료: " + money+"원");
							System.out.println("납입 계좌: "+ ed.getBank());
							System.out.printf("배송예정일자: %tF\n",today);
						}
					}
				
				System.out.println("");
				System.out.println("주소 변경은 1번, 이전페이지는 0번을 입력하세요.");
				System.out.print("렌탈을 최종 신청 하시겠습니까?(Y/N): ");
				choice = scan.nextLine();
				if (choice.equals("1")) {
					System.out.print("주소 입력:");
					UserMain.loginUser[7] = scan.nextLine();
					System.out.print("상세 주소: ");
					plusAdress = scan.nextLine();
					System.out.println("변경되었습니다.");
					UserInfoCorrection.update();
					scan.nextLine();
					continue;
				}else if(choice.equals("0")) {
					return;
				}
				if (choice.equals("Y") || choice.equals("y")) {
					try {
						today = Calendar.getInstance();
						Calendar endDay = Calendar.getInstance();
						endDay.add(Calendar.MONTH, Integer.parseInt(day));
						RentReader.list = new ArrayList<RentData>();
						RentReader.reader();
						String Dday = (endDay.getTimeInMillis() - today.getTimeInMillis())/1000/60/60/24 +"";
						String period = String.format("%tF~%tF", today, endDay);
						today.add(Calendar.MONTH, Integer.parseInt(cycle));
						String writerCycle = String.format("%tF", today);
						RentData data = new RentData(code, period, "렌탈중", Dday, writerCycle, UserMain.loginUser[0]);
						RentReader.list.add(data);
						BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\git\\Project\\Data\\RentManage.txt"));
						for (RentData rm :RentReader.list) {
							writer.write(String.format("%s,%s,%s,%s,%s,%s\n"
									,rm.getCode(),rm.getPeriod(),rm.getStatus(),rm.getDays(),rm.getNextVisit(),rm.getUserNum()));
						}
						writer.close();
						System.out.println("");
						System.out.println("신청 완료 되었습니다.");
						scan.nextLine();
						return;
					} catch (IOException e) {
						e.printStackTrace();
					}
				}else {
					System.out.println("취소되었습니다.");
					scan.nextLine();
					return;
				}
			}
		}else {
			System.out.println("취소되었습니다.");
			scan.nextLine();
			return;
		}
	}
		
}
