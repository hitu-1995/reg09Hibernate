package com.cjc.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cjc.hbutil.HibernateUtil;
import com.cjc.model.Employee;

public class Main {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();

		Employee emp = new  Employee();
		emp.setEid(101);
		emp.setMobile(9876543);
		emp.setEname("Hitesh");
		emp.setSalary(900000);
	
		 Session session = factory.openSession();
		 session.save(emp);
		 session.beginTransaction().commit();
		 System.out.println("Saved");
		 
	}
}
