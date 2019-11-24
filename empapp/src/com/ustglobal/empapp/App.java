package com.ustglobal.empapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import com.ustglobal.empapp.dao.EmployeeDAO;
import com.ustglobal.empapp.dao.EmployeeDAOImpl;
import com.ustglobal.empapp.dto.EmployeeBean;
import com.ustglobal.empapp.util.EmployeeManager;



public class App {

	public static void main(String[] args) {

		System.out.println("press 1 to get all employee data");
		System.out.println("press 2  to insert employee data");
		System.out.println("press 3 to update employee data");
		System.out.println("press 4 to delete employee data");
		System.out.println("press 5 to search single employee");

		Scanner scn = new Scanner(System.in);
		int ch = scn.nextInt();

		switch(ch) {
		case 1 :
			EmployeeDAO dao =  EmployeeManager.getEmployeeDAO();
			List<EmployeeBean> result=dao.getAllEmployeeData();

			for(EmployeeBean bean : result) {
				System.out.println("id: "+bean.getId());
				System.out.println("name:  "+bean.getName());
				System.out.println("gender: "+bean.getGender());
				System.out.println("salary: "+bean.getSal());
			
			}

			break;

		case 2:

			break;
		case 3:


			break;
		case 4:


			break;

		case 5:
			EmployeeDAOImpl impl5 = new EmployeeDAOImpl();
			int id = scn.nextInt();
			EmployeeBean bean = impl5.searchEmployeeData(id);
			if(bean!=null) {
				System.out.println("id: "+bean.getId());
				System.out.println("name:  "+bean.getName());
				System.out.println("gender: "+bean.getGender());
				System.out.println("salary: "+bean.getSal());
				
			}
			else {
				System.out.println("no data found");
			}
			break;

		}


	}

}
