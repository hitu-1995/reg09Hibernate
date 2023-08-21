package com.cjc.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cjc.hbutil.HibernateUtil;
import com.cjc.model.Employee;

public class Test {

	public static void main(String[] args) {

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		
		Employee emp = new Employee();
		emp.setEid(5);
		emp.setEname("Jadeja");
		emp.setSalary(800000);
		emp.setDept("All Rounder");

		session.save(emp);
		session.beginTransaction().commit();
		System.out.println("Employee Saved");
	}
}
