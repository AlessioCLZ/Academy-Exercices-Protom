package java16092022.store;

public abstract class Good {

	private String brand, model;
	private int price;
	
	public Good() {}

	public Good(String brand, String model, int price) {
		this.brand = brand;
		this.model = model;
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrezzo() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public abstract void applicaSconto();
	
}
