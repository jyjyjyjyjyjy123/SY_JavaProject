package com.java.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.java.data.EntData;
import com.java.user.UserMain;

public class EntReader {
	public static ArrayList<EntData> list;
	static {
		list = new ArrayList<EntData>();
	}
	public static void reader() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("C:\\git\\Project\\Data\\companyList.txt"));
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split(",");
				EntData data = new EntData(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6]);
				list.add(data);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
