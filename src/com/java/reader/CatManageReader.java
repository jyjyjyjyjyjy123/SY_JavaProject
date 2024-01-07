package com.java.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.java.data.CatManageData;
import com.java.data.CatManageData;
import com.java.data.RentData;

public class CatManageReader {
	public static ArrayList<CatManageData> list;
	static {
		list = new ArrayList<CatManageData>();
	}
	public static void reader(String category) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("C:\\git\\Project\\Data\\"+category+"manage.txt"));
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split(",");
				CatManageData data = new CatManageData(temp[0], temp[1],temp[2],temp[3]);
				list.add(data);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
