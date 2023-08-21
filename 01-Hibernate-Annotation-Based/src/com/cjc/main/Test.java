package com.cjc.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.cjc.model.Student;

public class Test {

	public static void main(String[] args) {

		// logic to save student into database
//        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
//        
//        MetadataSources mds = new MetadataSources(registry);
//        
//        Metadata md = mds.getMetadataBuilder().build();
//        
//        SessionFactory factory = md.getSessionFactoryBuilder().build();

		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session session = factory.openSession();

		// create student
		Student stu = new Student();
		stu.setRollno(105);
		stu.setName("Akshay");
		stu.setMarks(76);
		stu.setAddress("Pune");
		session.save(stu);

		session.beginTransaction().commit();
		System.out.println("Student Saved");
	}
}
