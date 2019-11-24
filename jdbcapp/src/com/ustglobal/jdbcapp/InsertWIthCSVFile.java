package com.ustglobal.jdbcapp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertWIthCSVFile {
	
	public static void main(String[] args) {
		
		String Url = "jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";
		 String sql = "insert into employee_info values(?,?,?,?)";
		try(FileReader fr = new FileReader("csv.txt");
		BufferedReader br = new BufferedReader(fr);
				Connection conn = DriverManager.getConnection(Url);
				PreparedStatement pstmt = conn.prepareStatement(sql)){
		
			while(br.ready()) {
				String line = br.readLine();
				String[] datas = line.split(",");
				int id = Integer.parseInt(datas[0]);
				String name = datas[1];
				int sal= Integer.parseInt(datas[2]);
				String gender = datas[3];
				
				pstmt.setInt(1, id);
			    pstmt.setString(2,name);
			    pstmt.setInt(3,sal);
			    pstmt.setString(4,gender);
			    
			  pstmt.addBatch();
			    	
			}
			
			  int[] counts = pstmt.executeBatch();
			    System.out.println(counts.length +"rows inserted");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
