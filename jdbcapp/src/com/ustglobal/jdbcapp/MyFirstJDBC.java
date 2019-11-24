package com.ustglobal.jdbcapp;

import java.sql.*;

import com.mysql.jdbc.Driver;

public class MyFirstJDBC {
	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs =null;
		try {
			// step 1 : loading the driver
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			
			
			//step 2 : get connection
			String url = "jdbc:mysql://localhost:3306/ust_ty_db?"+"user=root&password=root";
			conn = DriverManager.getConnection(url);
			
			
			//step 3 : issue sql query
			stmt = conn.createStatement();
			String sql = "select * from employee_info";
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

		}catch (SQLException e) {
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

			}catch(SQLException e) {
				e.printStackTrace();

			}
		}

	}

}
