package com.cjc.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.cjc.hbutil.HibernateUtil;
import com.cjc.model.Student;

public class Main {

	public static void main(String[] args) {
	
	}

	public static void deleteStudent() {
		SessionFactory factory = HibernateUtil.getSessionFactory();

		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
	
		String delete = "delete from Student where rollno = :rn"; // delete
		Query query = session.createQuery(delete);
		query.setParameter("rn", 102);
		query.executeUpdate();
		tx.commit();
		System.out.println("Student Deleted");
	}

	public static void updateStudent() {
		SessionFactory factory = HibernateUtil.getSessionFactory();

		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		 String update = "update Student set name = :nm where rollno = :rn";
         Query query = session.createQuery(update);
         query.setParameter("nm", "Yogesh");
         query.setParameter("rn", 102);
         
         query.executeUpdate();
          tx.commit();
          System.out.println("Name updated");
	}

	public static void getSingleRcord() {
		SessionFactory factory = HibernateUtil.getSessionFactory();

		Session session = factory.openSession();
		
		 String select = "from Student where rollno = :rn";
		                 // select * from student where rollno = ?
		 Query query = session.createQuery(select);
	
            query.setParameter("rn", 102);
            Student student = (Student)query.getSingleResult();
		    System.out.println(student);
	}

	public static void getAllRecords() {
		SessionFactory factory = HibernateUtil.getSessionFactory();

		Session session = factory.openSession();
		
		 String select = "from Student";
		 Query query = session.createQuery(select);
	      List<Student> list = query.getResultList();	 
	
	        for(Student student:list) {
	        	System.out.println("--------------------------------------------");
	        	System.out.println(student);
	        }
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
