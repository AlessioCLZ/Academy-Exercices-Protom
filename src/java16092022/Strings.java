package java16092022;

import java.util.Arrays;
import java.util.Scanner;

public class Strings {

	public static void main(String[] args) {
		
		Scanner keyboard= new Scanner(System.in);
		
		//esercizio a
		String input;
		System.out.println("Immettere stringa");
		
		input= keyboard.nextLine();
		
		System.out.println("Le vocali presenti nella stringa immessa sono:");
		_printVocals(input);
		
		//esercizio b
		_reverseString(input);
		
		//esercizio c
		_countCs(input);
		
		//esercizio d
		System.out.println("Inserire una seconda stringa:");
		String input2=keyboard.nextLine();
		_checkAnagram(input,input2);
		
		//esercizio e
		_checkPalindrome(input);
		
		keyboard.close();
	}

	

	private static void _checkPalindrome(String input) {
		
		//è identico a quella del contrario, ma cambiano le stampe a schermo e si aggiungono altri comandi
		String reverseString="";
		
		for(int i= input.length()-1;i>=0;i--)
		{
			reverseString= reverseString+input.charAt(i);
		}
		
		if(input.equals(reverseString))
			System.out.println("La stringa è palindroma");
		else
			System.out.println("La stringa NON è palindroma");
		
	}



	private static void _checkAnagram(String input, String input2) {
		
		if(input.length()==input2.length())
		{
			char[] inputChar= input.toCharArray();
			char[] input2Char= input2.toCharArray();
			Arrays.sort(inputChar);
			Arrays.sort(input2Char);
			if(Arrays.equals(inputChar, input2Char))
			{
				System.out.println("Le due stringhe sono anagrammi");
			}
			else
			{
				System.out.println("Le due stringhe non sono anagrammi");
			}
		}
		else
		{
			System.out.println("Le due stringhe hanno lunghezze diverse, non possono essere anagrammi");
		}
	}



	private static void _countCs(String input) {
		
		char[] inputChar= input.toCharArray();
		int count=0;
		
		for(int i=0; i<inputChar.length;i++)
		{
			if(inputChar[i]=='c')
				count++;
		}
		
		System.out.println("Il numero di 'c' presenti nella stringa è: "+count);
		
	}

	private static void _reverseString(String input) {
		
		String reverseString="";
		
		for(int i= input.length()-1;i>=0;i--)
		{
			reverseString= reverseString+input.charAt(i);
		}
		
		System.out.println("La stringa originale: "+input);
		System.out.println("La stessa stringa scritta al contrario: "+reverseString);
		
	}

	private static void _printVocals(String input) {
				
		char[] inputChar= input.toCharArray();
		
		for(int j=0;j<inputChar.length;j++)
		{			
			if(inputChar[j]=='a' || inputChar[j]=='e' || inputChar[j]=='i' || inputChar[j]=='o' || inputChar[j]=='u')
			{
				System.out.println(inputChar[j]);
			}
		}
	}

}
