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
	
	private final static int EXTRACTEDARRAYSIZE= 4;
	private final static int INSERTEDARRAYMAXSIZE= 4;
	
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
	
	public static void main(String[] args) {
		
		
		System.out.println("Benvenuto nel programma della Lotteria");
		//sezione di inserimento dei dati da tastiera

		try {
			_insertNumbers();
		} catch (BadInputException e) {
			e.printStackTrace();
		}

		//creazione array con 5 numeri random
		
		_createRandomNumbers();
		
		//controllo se l'utente ha beccato i numeri
		
		_countGoodNumbers();
		
		//metodo per assegnare il premio
		_assignPrize();

	}

	private static void _assignPrize() {
		
		int res= _countGoodNumbers();
		
		switch(res)
		{
			case(1):
				System.out.println("Congratulazioni, hai indovinato 1 numero, hai vinto il premio: " +Premi.PREMIO1.getTipoPremio());
			break;
			case(2):
				System.out.println("Congratulazioni, hai indovinato 2 numeri, hai vinto il premio: " +Premi.PREMIO2.getTipoPremio());
			break;
			case(3):
				System.out.println("Congratulazioni, hai indovinato 3 numeri, hai vinto il premio: " +Premi.PREMIO3.getTipoPremio());
			break;
			case(4):
				System.out.println("Congratulazioni, hai indovinato 4 numeri, hai vinto il premio: " +Premi.PREMIO4.getTipoPremio());
			break;
			case(5):
				System.out.println("Congratulazioni, hai indovinato 5 numeri, hai vinto il premio: " +Premi.PREMIO5.getTipoPremio());
			break;
			default:
			{
				System.out.println("Che peccato, non hai indovinato alcun numero. Ritenta, sarai più fortunato. Arrivederci!");

			}
		}
	}

	private static int _countGoodNumbers() {
		
		Set<Integer> input = null;
		try {
			input = _insertNumbers();
		} catch (BadInputException e) {
			e.printStackTrace();
		}
		Set<Integer> random = _createRandomNumbers();
		int count=0;
		
		for(Integer i: random)
		{
			for(Integer n:input)
			{
				if(i.equals(n))
					{
						count++;
						break;
					}
			}
		}
		return count;
		
	}

	private static Set<Integer> _createRandomNumbers() {
		
		Set<Integer> randomSet = new HashSet<Integer>();
		
		do
		{
			randomSet.add(r.nextInt(90)+1);
		}while(randomSet.size()<EXTRACTEDARRAYSIZE);
		
		return randomSet;
	}

	private static Set<Integer> _insertNumbers() throws BadInputException {
		try (Scanner keyboard = new Scanner(System.in)) {
			Set<Integer> inputSet = new HashSet<Integer>();
			
			do
			{
				System.out.println("Inserire numero scelto");
				Integer inputNum= Integer.parseInt(keyboard.nextLine());
				
				if(inputNum<1 && inputNum>90)
				{
					throw new BadInputException("Il valore da inserire può essere compreso tra 1 e 90");
				}
				else
				{
					if(inputSet.contains(inputNum))
						System.out.println("Numero già scelto, riprovare");
						inputSet.add(inputNum);
				}
				
						
			}while(inputSet.size()<INSERTEDARRAYMAXSIZE);
			
			System.out.println("I numeri scelti sono:" + inputSet);
			keyboard.close();
			return inputSet;
		} catch (BadInputException e) {
			e.printStackTrace();
		}
		return null;
		
	}

}
