package java_03_10_2022.threads.shop;

import java.util.Random;

public class Buyer extends Thread {

	
	private final Shop<Object> shop;
	
	public Buyer(Shop<Object> shop)
	{
		this.shop=shop;
	}
	
	@Override
	public void run()
	{
		Random rand = new Random();
        int n = rand.nextInt();
        shop.buy(n);
	}
}
