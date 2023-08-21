package com.cjc.main;

import java.util.Scanner;

import com.cjc.service.RBI;
import com.cjc.service.SBI;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		RBI rbi = new SBI();
		boolean flag = true;

		while (flag) {
			System.out.println("************* Welcome ****************d");
			System.out.println("1: Create Account");
			System.out.println("2: View Account Details");
			System.out.println("3: Withdraw  Money");
			System.out.println("4: Deposite Money");
			System.out.println("5: Update Account");
			System.out.println("6: Delete Account");
			System.out.println("7: Exit");

			int key = sc.nextInt();

			switch (key) {
			case 1:
				rbi.createAccount();
				break;
			case 2:
				rbi.viewAccountDetails();
				break;
			default:
				System.out.println("Wrong choice");
				break;
			}

		}
         System.out.println("******* TAHNK YOU *********");
  	}

}
