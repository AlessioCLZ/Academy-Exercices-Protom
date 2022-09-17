package java16092022;

import java.util.Random;

public class Arrays {

	public static void main(String[] args) {

		
		//esercizio a
		int[] array= new int[10];
		
		Random r= new Random();
		
		for(int i=0; i<array.length;i++)
		{
			array[i]=r.nextInt(100);
			System.out.println("Valore dell'array alla posizione "+(i+1)+": "+array[i]);
		}
		
		_getMaxValue(array);
		
		
		int e= r.nextInt(100);
		_containsARandom(e,array);
	}

	private static boolean _containsARandom(int e, int[] array) {
		
		
		for (int element : array) 
		{
			if(element==e)
			{
				return true;
				
			}
			else
				return false;
		}
		return false;
		
		
	}

	private static void _getMaxValue(int[] array) {
		
		int res=0;
		for(int i=0; i<array.length;i++)
		{
			if(array[i]>res)
				res=array[i];
		}
		
		System.out.println("Il valore massimo presente nell'array è: " +res);
	}
	
	

}
