package com.cjc.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cjc.hbutil.HibernateUtil;
import com.cjc.model.Student;

public class Main {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();

		Session session1 = factory.openSession();
		System.out.println("------------------Session1-------------------");
		Student student = session1.get(Student.class, 101);
		System.out.println(student);
		System.out.println("-------------------------------------------");
		Student student1 = session1.get(Student.class, 102);
		System.out.println(student1);
		System.out.println("------------------Session2-------------------");
		Session session2 = factory.openSession();
		Student student2 = session2.get(Student.class, 101);
		System.out.println(student2);
		System.out.println("-------------------------------------------");
		Student student3 = session2.get(Student.class, 101);
		System.out.println(student3);
		System.out.println("-------------------------------------------");
		Student student4 = session2.get(Student.class, 102);
		System.out.println(student4);
	
	}

	public static void insertStudent() {
		SessionFactory factory = HibernateUtil.getSessionFactory();

		Session session = factory.openSession();
		Student stu = new Student();
		stu.setRollno(102);
		stu.setName("Saurabh");
		stu.setMarks(98);
		stu.setAddress("Nigadi");
		session.save(stu);

		session.beginTransaction().commit();
		System.out.println("Saved...........");
	}
}
