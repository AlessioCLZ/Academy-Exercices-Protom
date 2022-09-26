package java_23_09_2022.collections.sandwich;

import java.util.HashSet;
import java.util.Set;

public class Panino {

	//utilizzare un enum facilita il collegamento tra ingrediente e sua categoria, dato che ingrediente e categoria non sono classi, non posso utilizzare una mappa 
	public enum Ingrediente
	{
		PROSCIUTTO("Ripieni"),
		SALAME("Ripieni"),
		SOTTILETTA("Latticini"),
		MOZZARELLA("Latticini"),
		MAIONESE("Salse"),
		SENAPE("Salse");

		private String categoria;
		
		Ingrediente (String categoria)
		{
			this.categoria = categoria;
		}

		public String getCategoria() {
			return categoria;
		}
	}

	Set<Ingrediente> ingredienti = new HashSet<Ingrediente>();
	
	
	public void addIngrediente(Ingrediente ingrediente) throws Exception
	{
		for (Ingrediente ing:ingredienti)
		{
			if(ing.categoria == ingrediente.categoria)
				throw new Exception("Non è possibile inserire due ingredienti della stessa categoria");
			else
				ingredienti.add(ingrediente);
		}
	}
	
	public String toString()
	{
		String res= "Panino con ";
		
		for(Ingrediente i: ingredienti)
		{
			res+= i+" ";
		}
		return res;
	}
}
