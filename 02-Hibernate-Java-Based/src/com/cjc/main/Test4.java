package com.cjc.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.cjc.hbutil.HibernateUtil;
import com.cjc.model.Employee;

public class Test4 {

	public static void main(String[] args) {

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
        Employee employee = session.get(Employee.class, 6);
        session.delete(employee);
		tx.commit();
		System.out.println("Employee Saved");
	}
}
