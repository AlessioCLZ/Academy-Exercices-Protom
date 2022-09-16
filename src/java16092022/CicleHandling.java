package java16092022;

import java.util.Scanner;

public class CicleHandling {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		//esercizio a
		
		
		for(int i=50; i>=0; i--)
		{
			if(i%2==0)
				System.out.println("Valore pari: "+i);
		}
		
		
		//esercizio b
		
		System.out.println("Inserire numero di cui si vuole in uscita la tabellina:");
		int number = Integer.parseInt(keyboard.nextLine());
		
		_calculateTimesTable(number);
		
		
		//esercizio c
		int base=1;
		
		for(int i=0; i<15; i++)
		{
			if(i<1)
			base=1;
			else {
				base= i + (base-1);
			}
			System.out.println("Valore "+i+"esimo della serie di Fibonacci: " +base);
			
		}
		
		keyboard.close();

	}

	private static void _calculateTimesTable(int number) {
		
		for(int i=0; i<11;i++)
		{
			int res= number * i;
			System.out.println(number + " times " + i+ " equals " + res);
		}
		
		
	}

}
