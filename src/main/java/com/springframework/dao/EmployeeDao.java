package com.springframework.dao;

import java.util.List;

import com.springframework.vo.Country;
import com.springframework.vo.employeeInfo;
import com.springframework.vo.login;

public interface EmployeeDao {
	
	public  void addEmployee(Object employee);

	 public List<employeeInfo> listEmployeess();
	 	 
	 public void deleteEmployee(int id);
	 
	 public employeeInfo getEmployeeById(int id);
	 
	 public void updateEmployee(Object p);

	public List<login> loginProcess(login login);

	public List<login> listLogin();
	public Country addCountry(Country country);
}
