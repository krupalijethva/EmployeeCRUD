package com.springframework.dao;

import java.util.List;

import com.springframework.vo.employeetbl;

public interface EmployeeDao {

	 public  void addEmployee(employeetbl employee);

	 public List<Object> listEmployeess();
	 
	 public employeetbl getEmployee(int empid);
	 
	 public void deleteEmployee(employeetbl employee);

}
