package java_23_09_2022.collections.chemistry;

import java.util.ArrayList;
import java.util.List;

public class Molecule{

	List<Element> formula = new ArrayList<Element>();
	
	public void add(Element e, int atoms)
	{
		if(formula.contains(e))
		{
			for(Element el:formula)
			{
				if(e.equals(el))
					el.numAtoms+=atoms;
			}
		}
		else
			formula.add(e);
	}
	
	
	public String toString()
	{
		String res="";
		for(Element e:formula)
		{
			res+=e.toString()+" ";
		}
		
		return res;
	}
	
}


