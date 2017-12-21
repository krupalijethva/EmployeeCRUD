package com.springframework.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.springframework.vo.Country;
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

	public List<login> listLogin() {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		List<login> login = session.createQuery("from login").list();
		for (login e : login) {
			logger.info("Person List::" + e);
		}
		tr.commit();
		return login;
	}

	// delete panding with foreign key
	@Transactional
	public void deleteEmployee(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		// Object o = session.get(login.class, new Integer(id));
		login e = (login) session.load(login.class, new Integer(id));
		e.getClass();
		Query query = session.createQuery(
				"delete employeeinfo , login from employeeinfo inner join login on login.lid=employeeinfo.id where employeeinfo.id=42");
		// Object o = session.get(login.class, new Integer(id));
		// login c = (login)o;
		// session.delete(c);
		// login l = (login) session.load(login.class, new Integer(id));
		int rowsAffected = query.executeUpdate();
		if (rowsAffected > 0) {
			System.out.println("Deleted " + rowsAffected + " rows.");
		}
		// int lid=l.getLid();
		if (null != e) {
			session.delete(e);
			// session.delete(lid);
			// session.delete(e);
			// session.delete(id1);
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
	public void updateEmployee(Object employeeInfo) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		session.update(employeeInfo);
		logger.info("Person updated successfully, Person Details=" + employeeInfo);
		tr.commit();
	}

	@Transactional
	public List loginProcess(login login) {

		List<login> list = new ArrayList();
		try {
			Session session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			list = session.createQuery(
					"from login where uname='" + login.getUname() + "' and password='" + login.getPassword() + "'")
					.list();
			// Query q = session.createQuery("from login where uname='"+login.getUname()+"'
			// and password='"+login.getPassword()+"'");
			// System.out.println(q.toString());
			// session.save(rv);
			// ls.add(q);
			tr.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

//	public HashMap<Integer, Country> countryIdMap = getCountryIdMap();
	@Transactional
	public Country addCountry(Country country) {

	//	country.setId(getMaxId() + 1);
		//countryIdMap.put(country.getId(), country);
		System.out.println("in ADD Country");
		return country;
	}
/*
	// Utility method to get max id
	public public int getMaxId() {
		int max = 0;
		for (int id : countryIdMap.keySet()) {
			if (max <= id)
				max = id;

		}
		return max;
	}

	public public HashMap<Integer, Country> getCountryIdMap() {
		return countryIdMap;
	}*/
}
