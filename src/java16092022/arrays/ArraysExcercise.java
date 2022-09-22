package java16092022.arrays;

import java.util.Random;
import java.util.*;

public class ArraysExcercise {

	public static void main(String[] args) {

		
		//esercizio a
		int[] array= new int[10];
		
		Random r= new Random();
		
		for(int i=0; i<array.length;i++)
		{
			array[i]=r.nextInt(100);
			System.out.println("Valore dell'array alla posizione "+(i+1)+": "+array[i]);
		}
		//esercizio b
		_getMaxValue(array);
		
		//esercizio c
		int e= r.nextInt(100);
		_containsARandom(e,array);
		
		//esercizio d
		System.out.println(_getAverage(array));
		
		//esercizio e
		System.out.println("Il valore che si ripete più volte è: "+ _mostRecurrent(array));
		
		//esercizio f
		System.out.println(_getAverageOnlyMultiple3(array));
	}

	
	
	private static String _getAverageOnlyMultiple3(int[] array) {
		
		int res=0, count=0;
		
		for(int e: array)
		{
			if(e%3==0)
			{
				res+=e;
				count++;
			}
		}
		
		res/=count;
		
		return "La media degli interi multipli di 3 presenti nell'array é:" +res;
	}



	private static int _mostRecurrent(int[] array) {
		int recurrentArray[] = new int [array.length];
		
		Arrays.fill(recurrentArray, -1);
		
		int count;
		
		for (int i=0; i<array.length;i++)
		{
			count=1; //ogni elemento è presente almeno 1 volta
			for(int j=i+1; j<array.length;j++)
			{
				if(array[i]==array[j])
				{
					count ++;
					recurrentArray[j]=0;
				}
			}
			if(recurrentArray[i]!=0)
				recurrentArray[i]=count;
		}
		int mostRecurring= recurrentArray[0], mostRecurringIndex=0;
		for(int i=0;i<recurrentArray.length;i++)
		{
			if(mostRecurring<recurrentArray[i])
			{
				mostRecurring=recurrentArray[i];
				mostRecurringIndex=i;
			}
		}
		
		return  array[mostRecurringIndex];
		
	}



	private static String _getAverage(int[] array) {
		
		int res=0;
		for(int e: array)
		{
			res+=e;
		}
		
		res/=array.length;
		
		return "La media degli interi dell'array è: " +res;
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
