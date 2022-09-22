package java16092022.garage;

public class Vehicle {
	
	final static String[] ALLOWEDTYPES= {"auto","moto","furgoni"};
	private String plate, brand, model, color, type;
	private int displacement;
	
	

	public Vehicle(String plate, String brand, String model, String color, String type, int displacement) {
		super();
		this.plate = plate;
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.type = type;
		this.displacement = displacement;
	}
	public String getPlate() {
		return plate;
	}
	public void setPlate(String plate) {
		this.plate = plate;
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
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getDisplacement() {
		return displacement;
	}
	public void setDisplacement(int displacement) {
		this.displacement = displacement;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public static String[] getAllowedtypes() {
		return ALLOWEDTYPES;
	}
	
	
	
}
