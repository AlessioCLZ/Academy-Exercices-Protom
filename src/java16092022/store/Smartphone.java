package java16092022.store;

public class Smartphone extends Good {

	@SuppressWarnings("unused")
	private String os, year;
	@SuppressWarnings("unused")
	private int ram;
	
	
	
	public Smartphone(String brand, String model, int price,String os, String year, int ram) {
		super(brand, model, price);
		this.os = os;
		this.year = year;
		this.ram = ram;
	}



	@Override
	public void applicaSconto() {
		setPrice(getPrezzo()- ((getPrezzo()*30)/100));
		
	}

}
