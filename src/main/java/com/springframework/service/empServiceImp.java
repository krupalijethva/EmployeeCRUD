package com.springframework.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import com.springframework.dao.EmployeeDao;
import com.springframework.vo.Country;
import com.springframework.vo.employeeInfo;
import com.springframework.vo.login;

public class empServiceImp implements empService {

	private EmployeeDao employeedao;

	public void setEmployeedao(EmployeeDao employeedao) {
		this.employeedao = employeedao;
	}

	@Transactional
	public List<employeeInfo> listEmployeess() {
		return this.employeedao.listEmployeess();
	}

	@Transactional
	public void deleteEmployee(int id) {
		this.employeedao.deleteEmployee(id);
	}

	@Transactional
	public employeeInfo getEmployeeById(int id) {
		return employeedao.getEmployeeById(id);
	}

	@Transactional
	public void updateEmployee(Object employeeInfo) {
		this.employeedao.updateEmployee(employeeInfo);
	}

	@Transactional
	public void addEmployee(Object employee) {
		this.employeedao.addEmployee(employee);
	}

	@Transactional
	public List loginProcess(login login) {
		return this.employeedao.loginProcess(login);
	}

	public List<login> listLogin() {
		return this.employeedao.listLogin();
	}

	public  Country addCountry(Country country) {
			return this.employeedao.addCountry(country);
	}
	public List getAllCountries()
	 {
	  List countries = new ArrayList(countryIdMap.values());
	  return countries;
	 }

}
