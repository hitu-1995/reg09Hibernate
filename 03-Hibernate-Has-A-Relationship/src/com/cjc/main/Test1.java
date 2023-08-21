package com.cjc.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cjc.hbutil.HibernateUtil;
import com.cjc.model.Employee;
import com.cjc.model.Laptop;

public class Test1 {

	public static void main(String[] args) {

		SessionFactory factory = HibernateUtil.getSessionFactory();

		Session session = factory.openSession();

		Employee emp1 = new Employee();

		emp1.setEid(101);
		emp1.setEname("Hitesh");
		emp1.setDept("HR");
		emp1.setSalary(80000);

		Employee emp2 = new Employee();

		emp2.setEid(102);
		emp2.setEname("Saurabh");
		emp2.setDept("Testing");
		emp2.setSalary(50000);

		Employee emp3 = new Employee();

		emp3.setEid(103);
		emp3.setEname("Mahesh");
		emp3.setDept("Testing");
		emp3.setSalary(40000);

		Laptop lap1 = new Laptop();
		lap1.setLid(1);
		lap1.setLname("HP");
		lap1.setPrice(54000);

		Laptop lap2 = new Laptop();
		lap2.setLid(2);
		lap2.setLname("DELL");
		lap2.setPrice(34000);

		Laptop lap3 = new Laptop();
		lap3.setLid(3);
		lap3.setLname("Asus");
		lap3.setPrice(70000);

		List<Laptop> l1 = new ArrayList<Laptop>();
		l1.add(lap1);
		l1.add(lap2);
		emp1.setLaptops(l1);

		List<Laptop> l2 = new ArrayList<Laptop>();
		l2.add(lap3);

		emp2.setLaptops(l2);

		List<Laptop> l3 = new ArrayList<Laptop>();
		l3.add(lap2);
		l3.add(lap3);

		emp3.setLaptops(l3);

		List<Employee> e1 = new ArrayList<Employee>();
		e1.add(emp1);
		e1.add(emp2);

		lap1.setEmployees(e1);

		List<Employee> e2 = new ArrayList<Employee>();
		e2.add(emp2);

		lap2.setEmployees(e2);

		List<Employee> e3 = new ArrayList<Employee>();
		e3.add(emp2);
		e3.add(emp3);
		lap3.setEmployees(e3);

		session.saveOrUpdate(emp1);
		session.saveOrUpdate(emp2);
		session.saveOrUpdate(emp3);
		
		session.beginTransaction().commit();
		
		System.out.println("Employee Added");

	}
}
