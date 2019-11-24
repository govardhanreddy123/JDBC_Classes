package com.ustglobal.jdbcapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class DynamicSelectQuery {
	
	public static void main(String[] args) {
		 
		String Url = "jdbc:mysql://localhost:3306/ust_ty_db?"+"user=root&password=root";
		String sql = "select * from employee_info where id =?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			Driver d = new Driver();
			DriverManager.registerDriver(d);
			
			conn = DriverManager.getConnection(Url);
			pstmt = conn.prepareStatement(sql);
			
			String empid = args[0];
			int id = Integer.parseInt(empid);
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int id1 = rs.getInt("id");
				String name = rs.getString("name");
				int sal = rs.getInt("sal");
				String gender = rs.getString("gender");
				
				System.out.println("id : "+id);
				System.out.println("name :"+ name);
				System.out.println("sal : "+sal);
				System.out.println("gender "+gender);
				
				System.out.println("=======================");
				
				
				
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				 
				if(conn!= null) {
					conn.close();
				}
				if(pstmt!= null) {
					pstmt.close();
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
