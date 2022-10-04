package java_03_10_2022.threads.shop;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

public class Shop<T> {

	Map<T, Integer> goods;

	
	public Shop(){
		goods= new HashMap<T,Integer>();
		
	}
	
	public synchronized void sell(T object, Integer price)
	{
		if(goods.containsKey(object))
		{
			goods.replace(object, price);
			System.out.println("Il prezzo dell'oggetto "+ object+ " è stato modificato in "+ price+"€");
		}
		else
		{
			goods.put(object, price);
			System.out.println("L'oggetto " +object+ " è stato messo in vendita alla cifra di "+price+"€");

		}
	}
	
	
	public synchronized T buy(int offer)
	{
		
		Optional<Entry<T, Integer>> opt=goods.entrySet().stream().filter(good -> good.getValue()<=offer).findFirst();
		if(opt.isPresent())
		{
			T obj=opt.get().getKey();
			System.out.println("L'oggetto "+ obj+" è stato venduto");
			this.notify(); 
			return obj;
		}
		else
		{
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return null;
		}
	}
	
}
