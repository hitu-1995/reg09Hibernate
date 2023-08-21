package com.cjc.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.cjc.hbutil.HibernateUtil;
import com.cjc.model.Employee;

public class Test2 {

	public static void main(String[] args) {

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		  Transaction tx = session.beginTransaction();
		Employee emp = new Employee();
		emp.setEid(6);
		emp.setEname("Hardik");
		emp.setSalary(600000);
		emp.setDept("All Rounder");

		session.saveOrUpdate(emp);
		tx.commit();
		System.out.println("Employee Saved");
	}
}
