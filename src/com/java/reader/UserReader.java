package com.java.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.java.data.UserData;
import com.java.user.UserMain;

public class UserReader {
	public static ArrayList<UserData> list;
	static {
		list = new ArrayList<UserData>();
	}
	public static void reader(String login) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("C:\\git\\Project\\Data\\userData.txt"));
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split(",");
				if (temp[0].equals(login)) {
					UserMain.loginUser = line.split(",");
				}
				UserData data = new UserData(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7]);
				list.add(data);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
