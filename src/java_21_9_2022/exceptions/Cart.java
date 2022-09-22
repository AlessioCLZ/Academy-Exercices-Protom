package java_21_9_2022.exceptions;

import java.util.ArrayList;
import java.util.List;

import java16092022.store.Good;

public class Cart {
	
	private final static int MAXVALUE=2500;

	private List<Good> list = new ArrayList<>();
	
	public void add(Good good) throws NumberOutOfRangeException
	{
		if(list.size()<10)
			list.add(good);
		else
			{
			System.out.println("Non è possibile aggiungere ulteriori prodotti");
			throw new NumberOutOfRangeException();
			}
	}
	
	public boolean discount()
	{
		int total=0;
		for(Good g: list)
		{
			total+=g.getPrezzo();
		}
		if(total>MAXVALUE)
			return true;
		else
			return false;
	}
	
	public int totalPrice()
	{
		int res =0;
		for(Good g:list)
		{
			res+=g.getPrezzo();
		}
		if(discount())
			res= res-((res*5)/100);
		
		return res;
	}
}
