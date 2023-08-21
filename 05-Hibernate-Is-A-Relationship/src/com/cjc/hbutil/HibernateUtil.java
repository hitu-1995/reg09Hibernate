package com.cjc.hbutil;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.cjc.model.Akurdi;
import com.cjc.model.CJC;
import com.cjc.model.KarveNagar;

public class HibernateUtil {

	
	private static SessionFactory factory;
	
	public static SessionFactory getSessionFactory() {
		
		   if(factory==null) {
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
		        	    .addAnnotatedClass(CJC.class)
		                .addAnnotatedClass(Akurdi.class) 
		                .addAnnotatedClass(KarveNagar.class)
		        		.buildSessionFactory();
		        
		        return factory;
		   }
		   return factory;
	}
}