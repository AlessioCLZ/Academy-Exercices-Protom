package java_21_9_2022.exceptions;

import java.util.Scanner;

public class FlowControl {

	public static void main(String[] args) throws NumberOutOfRangeException {
		
		
		
		try (Scanner keyboard = new Scanner(System.in)) {
			int theory, practice, minTheory=-8, maxTheory=8, minPractice=0, maxPractice=24, grade=0;
			boolean fail= false;
			do
			{
				
				System.out.println("Inserire voto della prova teorica:");
				theory= Integer.parseInt(keyboard.nextLine());
				if(theory<minTheory && theory>maxTheory)
				{
					System.out.println("Valore errato, riprovare: è possibile inserire un valore tra -8 e +8.");
					throw new NumberOutOfRangeException();
				}
					
			}while(theory<minTheory && theory>maxTheory);
			
			do
			{
				System.out.println("Inserire voto della prova pratica:");
				practice= Integer.parseInt(keyboard.nextLine());
				if(practice<minPractice && practice>maxPractice)
				{
					System.out.println("Valore errato, riprovare: è possibile inserire un valore tra 0 e 24.");
					throw new NumberOutOfRangeException();
				}
			}while(practice<minPractice && practice>maxPractice);
			
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
		} catch (NumberFormatException e) {
			e.getMessage();
		}
	}

}
