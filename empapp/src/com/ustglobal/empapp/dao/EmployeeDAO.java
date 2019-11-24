package com.ustglobal.empapp.dao;

import java.util.ArrayList;

import com.ustglobal.empapp.dto.EmployeeBean;

public interface EmployeeDAO {
	
	public ArrayList<EmployeeBean> getAllEmployeeData();
	public EmployeeBean searchEmployeeData(int id);
	
	
	

}
