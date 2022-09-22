package java16092022.equals.ex2;

public class Engine {
	
	private int displacement, power;

	public Engine(int displacement, int power) {
		this.displacement = displacement;
		this.power = power;
	}

	public Engine() {}

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
		
		//creo una classe anonima
		return new Engine() {
			//sovrascrivo il metodo equals di Object
			@Override
			public boolean equals(Object obj) //do in entrata il parametro Object perché devo sovrascrivere in tutto il metodo della classe Object
			{
				Engine e = (Engine) obj; //casting dell'oggetto in entrata
				return (this.getDisplacement()==e.getDisplacement()); //return di ciò che mi serve effettivamente, cioè l'equals di un solo parametro
			}
		};
	}

	public Engine byPower() {
		
		return new Engine() {
			@Override
			public boolean equals(Object obj)
			{
				Engine e = (Engine) obj;
				return (this.getPower()==e.getPower());
			}
		};
	}

}
