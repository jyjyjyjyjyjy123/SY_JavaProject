package com.java.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.java.data.EndRentData;

public class EndRentReader {
	public static ArrayList<EndRentData> list;
	static {
		list = new ArrayList<EndRentData>();
	}
	public static void reader() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("C:\\git\\Project\\Data\\endRent.txt"));
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split(",");
				EndRentData data = new EndRentData(temp[0], temp[1], temp[2], temp[3]);
				list.add(data);
			}
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
