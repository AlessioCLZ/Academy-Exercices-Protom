package java_29_09_2022.collections.lottery;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import java_29_09_2022.collections.lottery.exception.BadInputException;

public class Superenalotto {
	
	/*
	 * Realizzare un mini programma per giocare al Superenalotto. L’utente dovrà poter inserire da 
tastiera i numeri che intende giocare, si vince premi diversi (crescenti) in base a quanti numeri si 
indovinano. 
Regole:
● l’estrazione è di 5 numeri
● non si può giocare due volte lo stesso numero per la stessa estrazione
● il range dei numeri possibili è da 1 a 90
● effettuare tutti i controlli necessari per l’input, se una scimmia impazzita preme a caso sulla 
tastiera il programma non deve andare in eccezione
● gestire i casi di errore con exception custom
● premi e quantità di numeri a estrazione devono essere configurabili e 
facilmente sostituibili senza compromettere la logica
● utilizzare correttamente incapsulamento e riutilizzo del codice
● commentare dove serve e documentare i metodi

	 */
	
	private final static int EXTRACTEDARRAYSIZE= 5;
	private final static int INSERTEDARRAYMAXSIZE= 5;
	
	private final static Random r= new Random();
	
	private static enum Premi{
		PREMIO1("Premio1"),
		PREMIO2("Premio2"),
		PREMIO3("Premio3"),
		PREMIO4("Premio4"),
		PREMIO5("Premio5");
		
		String tipoPremio;
		Premi(String tipoPremio)
		{
			this.tipoPremio=tipoPremio;
		}
		public String getTipoPremio() {
			return tipoPremio;
		}
		@SuppressWarnings("unused")
		public void setTipoPremio(String tipoPremio) {
			this.tipoPremio = tipoPremio;
		}
		
	}
	
	public static void main(String[] args) throws BadInputException {
		
		Set<Integer> inputSet= new HashSet<Integer>(), randomSet=new HashSet<Integer>();
		
		int inputNum = 0, count = 0;
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Benvenuto nel programma della Lotteria!");
		
		
		
		
			//sezione di inserimento dei dati da tastiera
			do
			{
				System.out.println("Inserire un valore");
				boolean validValue=false;
				
				do {
					try 
					{
						inputNum=Integer.parseInt(keyboard.nextLine());
						validValue=true;
					
					} 
					catch (BadInputException e) 
					{
						System.out.println("Inserire un valore numerico");
						validValue=false;
					} 
					catch (NumberFormatException e) 
					{
						System.out.println("Inserire un valore numerico");
						validValue=false;
					}
					if(inputNum>0 && inputNum<=90)
					{
						inputSet.add(inputNum);
						validValue=true;
					}
					else
					{
						System.out.println("Valore non compreso tra 1 e 90");
						validValue=false;
					}
					
				}while(!validValue);
				
					if(inputNum>0 && inputNum<=90)
					{
						inputSet.add(inputNum);
					}
					else
					{
						throw new BadInputException("Valore non compreso tra 1 e 90");
					}
			}while(inputSet.size()<INSERTEDARRAYMAXSIZE);
			
			System.out.println("I numeri inseriti sono: " +inputSet);
			
			//creazione del set con numeri random
			for(int i=0; i<EXTRACTEDARRAYSIZE; i++)
			{
				int randomNum = r.nextInt(90)+1;
				randomSet.add(randomNum);
			}
			
			System.out.println("I numeri estratti sono: " + randomSet);
			
			//conta dei valori simili tra i due set
			for(Integer i:randomSet)
			{
				for(Integer n: inputSet)
				{
					if(n.equals(i))
						count++;		
				}
			}
			
			System.out.println("I numeri indovinati sono:" +count);
			
			switch(count)
			{
				case 1:
				{
					System.out.println("Congratulazioni! Ha indovinato " +count+ " numeri. Il suo premio è: "+ Premi.PREMIO1.getTipoPremio());
				}
				break;
				case 2:
				{
					System.out.println("Congratulazioni! Ha indovinato " +count+ " numeri. Il suo premio è: "+ Premi.PREMIO2.getTipoPremio());
				}
				break;
				case 3:
				{
					System.out.println("Congratulazioni! Ha indovinato " +count+ " numeri. Il suo premio è: "+ Premi.PREMIO3.getTipoPremio());
				}
				break;
				case 4:
				{
					System.out.println("Congratulazioni! Ha indovinato " +count+ " numeri. Il suo premio è: "+ Premi.PREMIO4.getTipoPremio());
				}
				break;
				case 5:
				{
					System.out.println("Congratulazioni! Ha indovinato " +count+ " numeri. Il suo premio è: "+ Premi.PREMIO5.getTipoPremio());
				}
				break;
				default:
					System.out.println("Peccato, ha perso. Sarà più fortunato la prossima volta!");
			}
			
		keyboard.close();
	}

}
	
	
		
		
		