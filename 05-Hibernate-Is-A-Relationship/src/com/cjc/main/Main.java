package com.cjc.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cjc.hbutil.HibernateUtil;
import com.cjc.model.Akurdi;
import com.cjc.model.CJC;
import com.cjc.model.KarveNagar;

public class Main {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();

		 CJC cjc = new CJC();
		 cjc.setBid(100);
		 cjc.setCourse("HTML");
		 cjc.setFees(12000);
		
		Akurdi akurdi = new Akurdi();
		akurdi.setBid(101);
		akurdi.setCourse("Java");
		akurdi.setFees(12000);
		akurdi.setAkurdi_batchType("Weekend");

		KarveNagar karveNagar = new KarveNagar();
		karveNagar.setBid(102);
		karveNagar.setCourse("Python");
		karveNagar.setFees(14000);
		karveNagar.setKarve_batchType("Regular");
		
		Session session = factory.openSession();

		session.save(karveNagar);
		session.save(akurdi);
		session.save(cjc);
		
		session.beginTransaction().commit();
		System.out.println("Saved...........");
	}
}
