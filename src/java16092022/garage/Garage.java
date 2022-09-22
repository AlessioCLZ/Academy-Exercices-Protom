package java16092022.garage;

public class Garage {
	
	private static final int AVAILABLESPOTS =15;
	
	private Spot[] spots= new Spot[AVAILABLESPOTS];
	
	public Garage() {
		
	}
	
	public boolean isValidVehicle(Vehicle v)
	{
		for (String type : Vehicle.ALLOWEDTYPES) {
			if(type.equalsIgnoreCase(v.getType()))
				return true;
			else
				return false;
		}
		return false;
	}
	
	
	
	public void accessVehicle(Vehicle v)
	{
		
		if(isValidVehicle(v))
		{
			for(int i=0; i<spots.length;i++)
			{
				if(spots[i].isAvailable())
				{
					spots[i].setVehicle(v);
					spots[i].setAvailable(false);
				}
				else
				{
					System.out.println("Non sono disponibili posti, riprovare più tardi, grazie!");
				}
			}
		}
		else
			System.out.println("Veicolo non valido, si prega di uscire");

	}
	
	
	public void insertVehicleInSpot(Vehicle v, int spotId)
	{
		if(isValidVehicle(v))
		{
			if(spots[spotId].isAvailable())
			{
				spots[spotId].setVehicle(v);
				spots[spotId].setAvailable(false);
			}
			else
			{
				System.out.println("Posto non disponibile, riprovare");
			}
			
		}
		else
			System.out.println("Veicolo non valido, si prega di uscire");
	}
	
	public Vehicle extract(int spotId)
	{
		Vehicle v = spots[spotId].getVehicle();
		spots[spotId].setVehicle(null);
		spots[spotId].setAvailable(true);
		return v;
	}
	
	public void display()
	
	{
		for(Spot s: spots)
		{
			System.out.println(s);
		}
	}
	

}
