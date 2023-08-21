package com.cjc.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cjc.hbutil.HibernateUtil;
import com.cjc.model.Employee;

public class Test1 {

	public static void main(String[] args) {

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();

		Employee employee = session.get(Employee.class, 1);
		System.out.println("-----------------------------------------");

		System.out.println(employee);
		if (employee != null) {
			System.out.println(employee.getEid());
			System.out.println(employee.getEname());
			System.out.println(employee.getSalary());
			System.out.println(employee.getDept());
		} else
			System.out.println("Record Not Found");

	}
}
