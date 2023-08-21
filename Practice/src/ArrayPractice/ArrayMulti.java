package ArrayPractice;

import java.util.Scanner;

public class ArrayMulti {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of outer and inner array");
		int [][] a = new int [sc.nextInt()][sc.nextInt()];
		
		for(int i = 0; i < a.length; i++)
		{
			for(int j=0; j< a[i].length; j++)
			{
				System.out.println("Enter any number");
				a[i][j] = sc.nextInt();
			}
		}
		for(int i = 0; i < a.length; i++)
		{
			for(int j=0; j< a[i].length; j++)
			{
				System.out.println(a[i][j]);
				
			}
		}
		
	}

}
