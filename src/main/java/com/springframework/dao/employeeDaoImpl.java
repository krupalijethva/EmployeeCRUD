package com.springframework.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.springframework.vo.employeeInfo;
import com.springframework.vo.login;

public class employeeDaoImpl implements EmployeeDao {

	private static final Logger logger = LoggerFactory.getLogger(employeeDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void addEmployee(Object employee) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		session.saveOrUpdate(employee);
		tr.commit();
		// session.persist(employee);
		logger.info("Person saved successfully, Person Details=" + employee);
		/*
		 * try { Session session = sessionFactory.openSession(); Transaction tr =
		 * session.beginTransaction(); session.saveOrUpdate(employee);// insert data in
		 * db tr.commit(); session.close(); } catch (Exception e1) {
		 * System.out.println(e1); }
		 */
	}

	@Transactional
	public List<employeeInfo> listEmployeess() {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		List<employeeInfo> employeeInfos = session.createQuery("from employeeInfo").list();

		for (employeeInfo e : employeeInfos) {
			logger.info("Person List::" + e);
		}
		tr.commit();
		return employeeInfos;

	}

	@Transactional
	public void deleteEmployee(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		// employeeInfo e = (employeeInfo) session.load(employeeInfo.class, new
		// Integer(id));
		login l = (login) session.load(login.class, new Integer(id));
		int id1 = l.getLid();
		if (null != l) {
			// session.delete(e);
			session.delete(id1);
		}
		tr.commit();
		// logger.info("Person deleted successfully, person details=" + e);
	}

	@Transactional
	public employeeInfo getEmployeeById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		employeeInfo e = (employeeInfo) session.load(employeeInfo.class, new Integer(id));
		return e;
	}

	@Transactional
	public void updateEmployee(employeeInfo employeeInfo) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		session.update(employeeInfo);
		logger.info("Person updated successfully, Person Details=" + employeeInfo);
		tr.commit();
	}
	/*
	 * @Transactional public void validateUser(employeeInfo employeeInfo,String
	 * uname,String password) { Session session =
	 * this.sessionFactory.getCurrentSession(); Transaction tr =
	 * session.beginTransaction();
	 * 
	 * List<employeeInfo> employeeInfos =
	 * session.createQuery("from employeeInfo").list();
	 * 
	 * for (Iterator<?> iterator =employeeInfos.iterator(); iterator.hasNext();) {
	 * 
	 * employeeInfo lpojo = (employeeInfo) iterator.next();
	 * 
	 * if(lpojo.getUname().equals(uname)&& lpojo.getPassword().equals(password)) {
	 * System.out.println("Correct username and password"); } else {
	 * System.out.println("Incorrect username and password"); }
	 * 
	 * }
	 * 
	 * }
	 */

}
