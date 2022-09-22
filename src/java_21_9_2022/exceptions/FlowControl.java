package java_21_9_2022.exceptions;

import java.util.Scanner;

public class FlowControl {

	public static void main(String[] args) throws NumberOutOfRangeException {
		
		
		
		Scanner keyboard = new Scanner(System.in);
		
		
		
		
		int theory = 0, practice = 0, minTheory=-8, maxTheory=8, minPractice=0, maxPractice=24, grade=0;
		boolean fail= false;
					
			System.out.println("Inserire voto della prova teorica:");
			
			try {
				theory= Integer.parseInt(keyboard.nextLine());
			}catch(NumberOutOfRangeException noe)
			{
				
			};
			System.out.println("Inserire voto della prova pratica:");
			
			try {
				practice= Integer.parseInt(keyboard.nextLine());	
			}catch(NumberOutOfRangeException noe)
			{
				throw new NumberOutOfRangeException("Il voto di pratica non può essere minore di 0 o maggiore di 24");
			};
			
			
		if(theory<=0 || (theory>0 && practice<18))
			fail= true;
		
		if(!fail)
		{
			grade= theory+practice;
			if(grade>30)
			{
				System.out.println("Congratulazioni: 30 e lode!");
			}
			else
			{
				System.out.println("Il suo voto è: " +grade+"/30");
			}
		}
			
		
		
		
		
		keyboard.close();
	}

}
