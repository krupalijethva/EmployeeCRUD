package com.springframework.service;

import java.util.List;

import javax.transaction.Transactional;
import com.springframework.dao.EmployeeDao;
import com.springframework.vo.employeeInfo;

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
	public void updateEmployee(employeeInfo employeeInfo) {

		this.employeedao.updateEmployee(employeeInfo);
	}
	@Transactional
	public void addEmployee(Object employee) {
		this.employeedao.addEmployee(employee);
		
	}
}
