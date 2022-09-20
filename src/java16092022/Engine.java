package java16092022;

public class Engine {
	
	private int displacement, power;

	public Engine(int displacement, int power) {
		this.displacement = displacement;
		this.power = power;
	}

	public int getDisplacement() {
		return displacement;
	}

	public void setDisplacement(int displacement) {
		this.displacement = displacement;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}
	
	public String toString()
	{
		return "("+displacement+" cm3, "+power+".0 CV)";
	}

	public Engine byVolume() {
		Engine e= new Engine(this.displacement,0);
		return e;
	}

	public Engine byPower() {
		
		Engine e= new Engine(0, this.power);
		return e;
	}

}
