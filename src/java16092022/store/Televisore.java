package java16092022.store;

public class Televisore extends Good {

	private double inches;
	private boolean isSmart;
	
	public Televisore(String brand, String model, int price, double inches, boolean isSmart) {
		super(brand, model, price);
		this.inches = inches;
		this.isSmart = isSmart;
	}
	
	@Override
	public void applicaSconto()
	{
		setPrice(getPrezzo()- ((getPrezzo()*20)/100));
	}
	
	
}
