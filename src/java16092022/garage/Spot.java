package java16092022.garage;

public class Spot {
	
	private int id;
	private Vehicle vehicle;
	private boolean available;
	
	

	public Spot(int id, Vehicle vehicle, boolean available) {
		super();
		this.id = id;
		this.vehicle = vehicle;
		this.available = available;
	}
	
	



	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}





	public Vehicle getVehicle() {
		return vehicle;
	}





	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}





	public void setAvailable(boolean available) {
		this.available = available;
	}





	public boolean isAvailable() {
		return available;
	}
	
	@Override
	public String toString()
	{
		if(isAvailable())
			return "Il posto numero "+id+"è libero";
		else
			return
							"Il posto numero "+
							id+
							"è occupato dal veicolo: "+
							vehicle.getBrand()+ 
							" "+
							vehicle.getModel()+
							" targato " +
							vehicle.getPlate()+
							".";
	}

}
