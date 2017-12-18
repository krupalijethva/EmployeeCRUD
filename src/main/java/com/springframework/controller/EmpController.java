package com.springframework.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springframework.service.empService;
import com.springframework.vo.employeeInfo;
import com.springframework.vo.login;

@Controller
public class EmpController {

	private static final Logger logger = LoggerFactory.getLogger(EmpController.class);

	private empService empservice;

	@Autowired(required = true)
	@Qualifier(value = "empservice")
	public void setEmpservice(empService empservice) {
		this.empservice = empservice;
	}

	@RequestMapping("/hello")
	public ModelAndView helloWorld(HttpServletRequest request, HttpServletResponse res) {
		String name = request.getParameter("name");
		String password = request.getParameter("password");

		if (password.equals("admin")) {
			String message = "HELLO " + name;
			return new ModelAndView("hellopage", "message", message);
		} else {
			return new ModelAndView("errorpage", "message", "Sorry, username or password error");
		}
	}
	// load empform
	@RequestMapping(value = "/empform", method = RequestMethod.GET)
	public ModelAndView showform() {
		return new ModelAndView("empform", "empform", new employeeInfo());
	}

	// insert or add employee
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("empform") employeeInfo emp,@ModelAttribute("login") login login, HttpServletRequest request) {
		
		String uname = request.getParameter("uname");
		String password = request.getParameter("password");
		String empname = request.getParameter("empname");
		String empaddress = request.getParameter("empaddress");
		int salary = Integer.parseInt(request.getParameter("salary"));
		int birthdate = Integer.parseInt(request.getParameter("birthdate"));
		String designation = request.getParameter("designation");
		emp.setUname(uname);
		emp.setPassword(password);
		emp.setEmpname(empname);
		emp.setEmpaddress(empaddress);
		emp.setSalary(salary);
		emp.setBirthdate(birthdate);
		emp.setDesignation(designation);
			
		login.setUname(uname);
		login.setPassword(password);
		login.setEmployeeInfo(emp);
		
		System.out.println(emp);
		
		if (emp.getId() == 0) {
			this.empservice.addEmployee(emp);
			this.empservice.addEmployee(login);
		}
		// dao.addEmployee(emp);
		return new ModelAndView("redirect:/viewemp");// will redirect to viewemp request mapping
	}

	// show employee data
	@RequestMapping("/viewemp")
	public ModelAndView viewemp() {
		employeeInfo employeeInfo = new employeeInfo();
		List<employeeInfo> list = this.empservice.listEmployeess();
		// List<Object> list = dao.listEmployeess();
		return new ModelAndView("viewemp", "list", list);
	}

	// delete from DB
	@RequestMapping(value = "/deleteemp", method = RequestMethod.GET)
	public String deleteEmployee(int id) {
		this.empservice.deleteEmployee(id);
		return "redirect:/viewemp";
	}

	// edit form load
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editEmployee(int id, Model model) {
		employeeInfo employeeInfo = this.empservice.getEmployeeById(id);
		model.addAttribute("employeeInfo", employeeInfo);
		// System.out.println(employeeInfo);
		return "edit";
	}

	// update //temp15
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("employeeInfo") employeeInfo emp, HttpServletRequest request,
			HttpServletResponse response) {

		System.out.println("in update the controller");
		// int id =Integer.parseInt(request.getParameter("id"));
		int id = Integer.parseInt(request.getParameter("id"));
		String uname = request.getParameter("uname");
		String password = request.getParameter("password");
		String empname = request.getParameter("empname");
		String empaddress = request.getParameter("empaddress");
		int salary = Integer.parseInt(request.getParameter("salary"));
		int birthdate = Integer.parseInt(request.getParameter("birthdate"));
		String designation = request.getParameter("designation");

		emp.setId(id);
		emp.setUname(uname);
		emp.setPassword(password);
		emp.setEmpname(empname);
		emp.setEmpaddress(empaddress);
		emp.setSalary(salary);
		emp.setBirthdate(birthdate);
		emp.setDesignation(designation);

		// System.out.println(id);
		System.out.println(emp);
		// existing person, call update
		this.empservice.updateEmployee(emp);
		return "redirect:/viewemp";
	}

	// login
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request) {
		return new ModelAndView("login", "login", new login());
	}
	
}
