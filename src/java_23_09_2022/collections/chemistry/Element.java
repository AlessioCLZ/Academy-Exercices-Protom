package java_23_09_2022.collections.chemistry;

public class Element {

	private String symbol;
	int numAtoms=0;
	
	public Element() {}
	
	public Element(String symbol)
	{
		this.symbol=symbol;
	}

	public String getSymbol() {
		return symbol;
	}
	
	public String toString()
	{
		return symbol.toUpperCase()+ ( numAtoms>1 ? numAtoms: "");
	}
}
