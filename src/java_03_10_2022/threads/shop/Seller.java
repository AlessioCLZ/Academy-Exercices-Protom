package java_03_10_2022.threads.shop;

import java.util.Random;

public class Seller extends Thread {
	
	private final Shop<Object> shop;
	
	public Seller(Shop<Object> shop)
	{
		this.shop=shop;
	}
	
	@Override
	public void run()
	{
		Random rand = new Random();
		Object obj= new Object();
        int n = rand.nextInt();
        shop.sell(obj, n);
	}
	
}
