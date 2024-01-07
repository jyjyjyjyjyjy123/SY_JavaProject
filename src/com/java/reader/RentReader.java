package com.java.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.java.data.RentData;

public class RentReader {
	public static ArrayList<RentData> list;
	static {
		list = new ArrayList<RentData>();
	}
	public static void reader() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("C:\\git\\Project\\Data\\RentManage.txt"));
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split(",");
				RentData data = new RentData(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5]);
				list.add(data);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
