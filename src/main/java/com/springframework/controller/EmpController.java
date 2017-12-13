package com.springframework.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springframework.dao.employeeDaoImpl;
import com.springframework.vo.employeetbl;

@Controller
public class EmpController {
	@Autowired
	employeeDaoImpl dao;// will inject dao from xml file

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

	@RequestMapping(value = "/empform", method = RequestMethod.GET)
	public ModelAndView showform() {
		return new ModelAndView("empform", "empform", new employeetbl());
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("empform") employeetbl emp) {
		dao.addEmployee(emp);
		return new ModelAndView("redirect:/viewemp");// will redirect to viewemp request mapping
	}

	@RequestMapping("/viewemp")
	public ModelAndView viewemp() {
		List<Object> list = dao.listEmployeess();
		return new ModelAndView("viewemp", "list", list);
	}

	// pending..
	@RequestMapping(value = "/deleteemp", method = RequestMethod.GET)
	public ModelAndView delete(@ModelAttribute("empform") employeetbl emp) {
		dao.deleteEmployee(emp);
		return new ModelAndView("redirect:/viewemp");
	}
	// login
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public ModelAndView login() {
		
		
		return null;
	}
}
