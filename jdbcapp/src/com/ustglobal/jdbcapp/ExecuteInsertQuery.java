package com.ustglobal.jdbcapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;


public class ExecuteInsertQuery {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;

		try {

			Driver d = new Driver();
			DriverManager.registerDriver(d);

			String Url ="jdbc:mysql://localhost:3306/ust_ty_db?"+"user=root&password=root";
			conn = DriverManager.getConnection(Url);

			String sql = " insert into employee_info "+" values(6,'sundhar',10000,'m')";
			stmt = conn.createStatement();

			int count = stmt.executeUpdate(sql);


			System.out.println(count + "Row(s) inserted");
		}catch(SQLException e) {

			e.printStackTrace();
		}finally {

			try {
				if(conn!=null) {
					conn.close();
				}
				if(stmt!=null) {
					conn.close();
				}

			}catch(SQLException e) {
				e.printStackTrace();
			}
		}


	}

}
