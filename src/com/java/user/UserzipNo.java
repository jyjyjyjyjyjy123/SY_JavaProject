package com.java.user;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.java.reader.UserReader;

public class UserzipNo {
	public static String adress(String adress){
			try {
				String serchSe = "road";
				String[] tempAdress = adress.split(" ");
				String makeAdress = "";
				for (int i = 2; i < tempAdress.length; i++) {
					makeAdress += tempAdress[i]+" ";
				}
				String[] serchSeTest = tempAdress[2].split("");
				if ((serchSeTest[serchSeTest.length-1].equals("동"))||(serchSeTest[serchSeTest.length-1].equals("읍"))||(serchSeTest[serchSeTest.length-1].equals("면"))) {
					serchSe="dong";
				}
		        StringBuilder urlBuilder = new StringBuilder("http://openapi.epost.go.kr/postal/retrieveNewAdressAreaCdService/retrieveNewAdressAreaCdService/getNewAddressListAreaCd"); /*URL*/
		        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=bRFjntaFCUbn717QTAiaInnJccOHUeMXX9ti%2BopwaI8p%2FCXHkjpaPMBfCwR0lmmF5ociuk7wZ%2BpezbpvXQE1Bg%3D%3D"); /*Service Key*/
		        urlBuilder.append("&" + URLEncoder.encode("searchSe","UTF-8") + "=" + URLEncoder.encode(serchSe)); /*dong : 동(읍/면)명road :도로명[default]post : 우편번호*/
		        urlBuilder.append("&" + URLEncoder.encode("srchwrd","UTF-8") + "=" + URLEncoder.encode(makeAdress)); /*검색어*/
		        urlBuilder.append("&" + URLEncoder.encode("countPerPage","UTF-8") + "=" + URLEncoder.encode("50", "UTF-8")); /*페이지당 출력될 개수를 지정*/
		        urlBuilder.append("&" + URLEncoder.encode("currentPage","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*출력될 페이지 번호*/
		        URL url = new URL(urlBuilder.toString());
		        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		        conn.setRequestMethod("GET");
		        conn.setRequestProperty("Content-type", "application/json");
		        BufferedReader rd;
		        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
		            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		        } else {
		            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		        }
		        StringBuilder sb = new StringBuilder();
		        String line;
		        while ((line = rd.readLine()) != null) {
		            sb.append(line);
		        }
		        rd.close();
		        String s1 = sb.toString();
		        String[] temp = s1.split("<newAddressListAreaCd>");
		        for (String s : temp) {
		        	String[] zipno = s.split("<[/a-zA-Z]+>");
		        	if (zipno[3].indexOf(tempAdress[2])>0 || zipno[5].indexOf(tempAdress[2])>0) {
		        		return zipno[1];
		        	}
		        }
		        conn.disconnect();
			} catch (Exception e) {
			}
			return "잘못된 주소입니다.";
	}
}























