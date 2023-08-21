package com.cjc.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.cjc.hbutil.HibernateUtil;
import com.cjc.model.Employee;

public class Test3 {
	public static void main(String[] args) {

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		  Transaction tx = session.beginTransaction();
		Employee emp = session.get(Employee.class, 1);
		emp.setEid(6);
		emp.setEname("Umesh");
		emp.setSalary(600000);
		emp.setDept("Baller");

		session.update(emp);
		tx.commit();
		System.out.println("Employee Saved");
	}
}
