package com.cjc.service;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cjc.hbutil.HibernateUtil;
import com.cjc.model.Account;

public class SBI implements RBI {

	Scanner sc = new Scanner(System.in);
	SessionFactory factory = HibernateUtil.getSessionFactory();

	@Override
	public void createAccount() {
		Account ac = new Account();
		System.out.println("Enter Your Name..");
		ac.setName(sc.next());
		System.out.println("Enter Your Pan Number..");
		ac.setPan(sc.next());
		System.out.println("Enter Your Mobile..");
		ac.setMob(sc.nextLong());
		System.out.println("Enter Your Opening Balance");
		ac.setBalance(sc.nextDouble());
		System.out.println("Enter Your Addresss..");
		ac.setAddress(sc.next());

		Session session = factory.openSession();
		session.save(ac);
		session.beginTransaction().commit();
		System.out.println("Account Created Succesfull!!");
	}

	@Override
	public void viewAccountDetails() {
		
		System.out.println("Enter Your Account Number ");
		int acno = sc.nextInt();
		Session session = factory.openSession();
		
		Account account = session.get(Account.class, acno);
		
		if(account!=null) {
			System.out.println(account);
		}
		else
		System.out.println("Account Not Found");	
		
	}

}
