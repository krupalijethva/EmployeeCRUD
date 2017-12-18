package com.springframework.vo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;


@Entity
@Table(name = "employeeInfo")

public class employeeInfo implements Serializable  {
	
	private static final long serialVersionUID = -4766243580657692576L;
	@Override
	public String toString() {
		return "employeeInfo [id=" + id + ", uname=" + uname + ", password=" + password + ", empname=" + empname
				+ ", empaddress=" + empaddress + ", salary=" + salary + ", birthdate=" + birthdate + ", designation="
				+ designation + "]";
	}

	public employeeInfo(int id, String uname, String password, String empname, String empaddress, long salary,
			long birthdate, String designation) {
		super();
		this.id = id;
		this.uname = uname;
		this.password = password;
		this.empname = empname;
		this.empaddress = empaddress;
		this.salary = salary;
		this.birthdate = birthdate;
		this.designation = designation;
	}
	public employeeInfo() {
		super();
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="uname")
	private String uname;
	@Column(name="password")
	private String password;
	@Column(name="empname")
	private String empname;
	@Column(name="empaddress")
	private String empaddress;
	@Column(name="salary")
	private long salary;
	@Column(name="birthdate")
	private long  birthdate;
	@Column(name="designation")
	private String designation;
		
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getEmpaddress() {
		return empaddress;
	}
	public void setEmpaddress(String empaddress) {
		this.empaddress = empaddress;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	public long getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(long birthdate) {
		this.birthdate = birthdate;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	
}
