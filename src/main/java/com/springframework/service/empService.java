package com.springframework.service;

import java.util.List;
import com.springframework.vo.employeeInfo;

public interface empService {
	
	public  void addEmployee(Object employee);

	 public List<employeeInfo> listEmployeess();
	 	 
	 public void deleteEmployee(int id);
	 
	 public employeeInfo getEmployeeById(int id);
	 
	 public void updateEmployee(employeeInfo p);
	
}
