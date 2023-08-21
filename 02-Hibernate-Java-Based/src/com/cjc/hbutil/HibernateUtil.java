package com.cjc.hbutil;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.cjc.model.Employee;

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
		        setting.put(Environment.HBM2DDL_AUTO,"update");
		        setting.put(Environment.SHOW_SQL,"true");
		        setting.put(Environment.FORMAT_SQL,"true");
		        
//		         registry = new StandardServiceRegistryBuilder().applySettings(setting).build();
//		        MetadataSources mds = new MetadataSources(registry);
//		        mds.addAnnotatedClass(Employee.class);
//		        Metadata md = mds.getMetadataBuilder().build();
//		        factory = md.getSessionFactoryBuilder().build();

		        factory = new Configuration()
		        		.addProperties(setting)
		        		.addAnnotatedClass(Employee.class)
		        		.buildSessionFactory();
		        
		        return factory;
		   }
		   return factory;
	}
}
