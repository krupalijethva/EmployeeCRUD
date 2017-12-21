package com.springframework.service;

import java.util.List;

import com.springframework.vo.Country;
import com.springframework.vo.employeeInfo;
import com.springframework.vo.login;

public interface empService {
	
	public  void addEmployee(Object employee);

	 public List<employeeInfo> listEmployeess();
	 	 
	 public void deleteEmployee(int id);
	 
	 public employeeInfo getEmployeeById(int id);
	 
	 public void updateEmployee(Object p);

	public List loginProcess(login login);
	
	public List<login> listLogin();
	
public Country addCountry(Country country);

public List getAllCountries();
}
