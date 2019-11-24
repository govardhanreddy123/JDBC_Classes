package com.ustglobal.jdbcapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class Delete {
	public static void main(String[] args) {
		 
		Connection conn = null;
//		Statement stmt = null;
		PreparedStatement  pstmt= null ;
		
		try {
			
//			Driver d = new Driver();
//			DriverManager.registerDriver(d);
//			Class.forName("com.mysql.jdbc.Driver");
			
			String Url = "jdbc:mysql://localhost:3306/ust_ty_db?"+"user=root&password=root";
			
			conn = DriverManager.getConnection(Url);
			
			String sql = " delete from employee_info where id =? ";
			
//			stmt = conn.createStatement();
			
			pstmt = conn.prepareStatement(sql);
			
			String empid = args[0];
			int id = Integer.parseInt(empid);
			pstmt.setInt(1, id);
			
			
			
			int count = pstmt.executeUpdate();
			
			
			
//			int count = stmt.executeUpdate(sql);
			
			System.out.println(count + " rows affected");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null) {
					conn.close();
				}
//				if(stmt!=null) {
//					stmt.close();
//				}
				if(pstmt!=null) {
					pstmt.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static int executeUpdate(PreparedStatement pstmt) {
		// TODO Auto-generated method stub
		return 0;
	}

}
