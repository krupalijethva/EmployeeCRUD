package com.springframework.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "login")
public class login implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int lid;
	@Column(name="uname")
	private String uname;
	@Column(name="password")
	private String password;
	
	@ManyToOne @JoinColumn(name="ULid")
	private employeeInfo employeeInfo;

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public employeeInfo getEmployeeInfo() {
		return employeeInfo;
	}

	public void setEmployeeInfo(employeeInfo employeeInfo) {
		this.employeeInfo = employeeInfo;
	}
	
	
	
	

}
