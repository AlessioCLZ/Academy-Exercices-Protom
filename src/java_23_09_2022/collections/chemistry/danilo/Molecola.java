package java_23_09_2022.collections.chemistry.danilo;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.util.TreeSet;

public class Molecola {

	//le mappe non derivano da Iterable, non sono direttamente iterabili
	//non si può fare un ciclo al pari di liste
	//si recupera prima il set di chiavi/valori e poi si usa il ciclo
	private Map<Elemento, Integer> elementi = new HashMap<>(); //chiave della mappa identifica univocamente un valore
	
	
	public void add(Elemento elemento, int occorrenze) {
		if(elementi.containsKey(elemento))//se non facciamo override di equals da problemi
		{
			Integer occOld = elementi.get(elemento); //restituisce il valore collegato alla chiave "elemento"
			elementi.put(elemento, occorrenze + occOld);
		}
		else 
		{
			elementi.put(elemento, occorrenze);
		}
	}
	
	//ordinare per chiave è semplice, basta usare un altro tipo di collezione ordinata, ordinare per valore è più difficile
	
	@Override
	public String toString() {
		
		//Set<Elemento> chiavi = elementi.keySet();
		//for (Elemento e: chiavi)
		//{
			//elementi.get(e); //chiave e valore per ogni iterazione e posso lavorarci sopra
			
		//}
		
		SortedSet<Map.Entry<Elemento, Integer>> entries = new TreeSet<>(
				new Comparator<Map.Entry<Elemento, Integer>>()
				 
		{
			@Override
			public int compare(Entry<Elemento,Integer> o1, Entry<Elemento,Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		}); 
		//insieme di elementi che sono chiave/valore. Li ho tutti quanti e mi sta restituendo un insieme iterati associati alla molecola
		//mi serve un insieme ordinato di entries. Non basta fare banalmente un TreeSet
		//potrei usare un Comparator o implementare Comparable. La classe non è mia quindi devo implementare un Comparator
		
		entries.addAll(elementi.entrySet());
		
		String s = "";
		for(Entry<Elemento,Integer> entry: entries)
		{
			if(s.length()>0)
				s+= " ";
			s+= entry.getKey().getSigla();
			if(entry.getValue()>1)
				s+= "" + entry.getValue();
			
		}
		return s;
	}
	
	public static void main (String...strings) {
		Elemento ossigeno = new Elemento("O");
		Elemento idrogeno = new Elemento("H");
		Molecola acqua = new Molecola();
		
		acqua.add(idrogeno, 1);
		acqua.add(ossigeno, 1);
		acqua.add(idrogeno, 1);
		
		System.out.println(acqua);
	}
	
}
