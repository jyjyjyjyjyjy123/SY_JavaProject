package com.java.main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

import com.java.data.EntData;
import com.java.data.UserData;
import com.java.reader.EntReader;
import com.java.reader.UserReader;

public class Data_corp {

public static void load() {
		
		try {
			EntReader.list = new ArrayList<EntData>();
			EntReader.reader();
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
				
	}
	
	
	public static void save() {
		
		try {
			
			BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\git\\Project\\Data\\compantList.txt"));
			
			for(EntData u : EntReader.list) {
				
				
				writer.write(String.format("%s,%s,%s,%s,%s,%s,%s\n"
						, u.getNum()
						, u.getID()
						, u.getPW()
						, u.getName()
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

