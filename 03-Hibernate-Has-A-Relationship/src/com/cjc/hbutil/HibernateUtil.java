package com.cjc.hbutil;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.cjc.model.Employee;
import com.cjc.model.Laptop;

public class HibernateUtil {

	private static StandardServiceRegistry registry;
	
	private static SessionFactory factory;
	
	public static SessionFactory getSessionFactory() {
		
		   if(factory==null) {
				//Map<String, String> setting = new HashMap<String, String>();
				Properties setting = new Properties();
				setting.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
				setting.put(Environment.URL, "jdbc:mysql://localhost:3306/reg09");
				setting.put(Environment.USER, "root");
				setting.put(Environment.PASS, "root");
				setting.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
		        setting.put(Environment.HBM2DDL_AUTO,"create");
		        setting.put(Environment.SHOW_SQL,"true");
		        setting.put(Environment.FORMAT_SQL,"true");
		        
		        factory = new Configuration()
		        		.addProperties(setting)
		        		.addAnnotatedClass(Employee.class)
		        		.addAnnotatedClass(Laptop.class)
		        		.buildSessionFactory();
		        
		        return factory;
		   }
		   return factory;
	}
}
