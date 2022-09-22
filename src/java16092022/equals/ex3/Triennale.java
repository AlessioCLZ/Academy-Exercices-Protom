package java16092022.equals.ex3;

public class Triennale extends Student {

	public Triennale (String name, String serial)
	{
		this.setName(name);
		this.setSerial(serial);
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Triennale))
			return false;
		else
		{
			Triennale t= (Triennale) obj;
			return ((this.getName()==t.getName()) && (t.getSerial()==t.getSerial()));
		}
	}
}
