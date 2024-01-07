package com.java.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.java.data.CatInfoData;
import com.java.data.RentData;

public class CatInfoReader {
	public static ArrayList<CatInfoData> list;
	static {
		list = new ArrayList<CatInfoData>();
	}
	public static void reader(String category) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("C:\\git\\Project\\Data\\"+category+"info.txt"));
			String line = null;
			while ((line = reader.readLine()) != null) {
				String status = "";
				String[] temp = line.split(",");
				for (int i = 6; i < temp.length; i++) {
					if (i == temp.length-1) {
						status += temp[i]; 
					}else {
						status += temp[i] + ", "; 
					}
				}
				CatInfoData data = new CatInfoData(temp[0], temp[1],temp[2],temp[3],temp[4],temp[5],status);
				list.add(data);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
