package com.springframework.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springframework.vo.employeetbl;

@Repository("employeeDao")
@Transactional
public class employeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setsessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addEmployee(employeetbl employee) {
		try {
			Session session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			session.save(employee);// insert data in db
			tr.commit();
			session.close();
		} catch (Exception e1) {
			System.out.println(e1);
		}
	}
	public List<Object> listEmployeess() {
		List<Object> ls = new ArrayList<Object>();
		try {
			Session session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			tr.commit();
			Query q = session.createQuery("from employeetbl");
			q.list();
			ls = q.list();
			System.out.println(ls.size());
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}
	public employeetbl getEmployee(int empid) {
		// TODO Auto-generated method stub
		return null;
	}
	public void deleteEmployee(employeetbl employee) {
		
		/*
		 * sessionFactory.getCurrentSession().
		 * createQuery("DELETE FROM employeetbl WHERE empid = " + employee.getEmpid())
		 * .executeUpdate();
		 */
	}

}
