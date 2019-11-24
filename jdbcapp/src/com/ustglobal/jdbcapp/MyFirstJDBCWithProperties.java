package com.ustglobal.jdbcapp;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement; 
import java.util.Properties;

public class MyFirstJDBCWithProperties {
	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs =null;
		FileReader reader = null;
		try {
			// step 1 : loading the driver
			reader = new FileReader("db.properties");
			Properties prop =new Properties();
			prop.load(reader);
			
			Class.forName(prop.getProperty("driver-class-name"));
			
			
			//step 2 : get connection
			String url = prop.getProperty("url");
			conn = DriverManager.getConnection(url,prop);
			
			
			//step 3 : issue sql query
			stmt = conn.createStatement();
			String sql = prop.getProperty("select-query");
			rs = stmt.executeQuery(sql);
			
			
			// step 4: read the result
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int sal = rs.getInt("sal");
				String gender = rs.getString("gender");
				System.out.println("id is "+id);
				System.out.println("name is "+name);
				System.out.println("salary is "+sal);
				System.out.println("gender is "+gender);
				System.out.println("===================");
			}

		}catch (Exception e) {
			e.printStackTrace();

		}finally {
			
			//step5 : close all jdbc objects
			
			try {
				if(conn!=null) {
					conn.close();
				}
				if(stmt!=null) {
					stmt.close();
				}
				if(rs!=null) {
					rs.close();
					
				}
				if(reader!=null) {
					reader.close();
					
				}

			}catch(Exception e) {
				e.printStackTrace();

			}
		}

	}


}
