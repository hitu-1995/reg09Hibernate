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


		  getSingleRcord();
	}

	public static void deleteStudent() {
		SessionFactory factory = HibernateUtil.getSessionFactory();

		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
	
		String delete = "deleteStudent"; // delete
		Query query = session.createNamedQuery(delete);
		query.setParameter("rn", 102);
		query.executeUpdate();
		tx.commit();
		System.out.println("Student Deleted");
	}

	public static void updateStudent() {
		SessionFactory factory = HibernateUtil.getSessionFactory();

		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		 String update = "updateName";
         Query query = session.createNamedQuery(update);
         query.setParameter("nm", "Yogesh");
         query.setParameter("rn", 102);
         
         query.executeUpdate();
          tx.commit();
          System.out.println("Name updated");
	}

	public static void getSingleRcord() {
		SessionFactory factory = HibernateUtil.getSessionFactory();

		Session session = factory.openSession();
		
		 String select = "getSingle";
		                 // select * from student where rollno = ?
		 Query query = session.createNamedQuery(select);
	
            query.setParameter("rn", 102);
            Student student = (Student)query.getSingleResult();
		    System.out.println(student);
	}

	public static void getAllRecords() {
		SessionFactory factory = HibernateUtil.getSessionFactory();

		Session session = factory.openSession();
		
		 String selectAll = "getAll";
		 Query query = session.createNamedQuery(selectAll);
				 
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
		stu.setRollno(103);
		stu.setName("Bharat");
		stu.setMarks(88);
		stu.setAddress("Akurdi");
		session.save(stu);

		session.beginTransaction().commit();
		System.out.println("Saved...........");
	}
}
