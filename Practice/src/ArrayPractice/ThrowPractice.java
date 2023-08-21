package ArrayPractice;

import java.util.Scanner;

public class ThrowPractice {
	public static void main(String[] args) throws InvalidAgeException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your age");
		int age = sc.nextInt();
		
		if (age>=18)
		{
			System.out.println("You are eligible for voting");
		}
		else {
			
			throw new InvalidAgeException("Your age is too small to vote");
			
		}
		
	}

}
