package java16092022.equals.ex3;

public class Magistrale extends Student {
	
	public Magistrale (String name, String serial) {
		this.setName(name);
		this.setSerial(serial);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Magistrale)) 
			return false;
		else {
		Magistrale m = (Magistrale) obj;
		return (this.getName() == m.getName() && 
				this.getSerial() == m.getSerial());
		}
	}

}
