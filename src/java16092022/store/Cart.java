package java16092022.store;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	
	private final static int MAXVALUE=2500;

	private List<Good> list = new ArrayList<>();
	
	public void add(Good good)
	{
		if(list.size()<10)
			list.add(good);
		else
			System.out.println("Non è possibile aggiungere ulteriori prodotti");
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
