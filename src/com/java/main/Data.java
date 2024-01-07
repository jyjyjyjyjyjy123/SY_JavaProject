package com.java.main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

import com.java.data.UserData;
import com.java.reader.UserReader;

public class Data {


	
	public static void load() {
		
		try {
			UserReader.list = new ArrayList<UserData>();
			UserReader.reader(null);
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
				
	}
	
	
	public static void save() {
		
		try {
			
			BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\git\\Project\\Data\\userData.txt"));
			
			for(UserData u : UserReader.list) {
								
				writer.write(String.format("%s,%s,%s,%s,%s,%s,%s,%s\n" //*****
						, u.getNum()
						, u.getID()
						, u.getPW()
						, u.getName()
						, u.getBirth()
						, u.getPhone()
						, u.getBank()
						, u.getAddress()));
				
			}
			writer.close();
			
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
}
