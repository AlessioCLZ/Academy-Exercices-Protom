package java_23_09_2022.collections.chemistry.danilo;

import java.util.Objects;

public class Elemento {
	
	private String sigla;
	
	public Elemento() {}
	
	public Elemento (String sigla) {
		this.sigla=sigla;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(sigla);
	}
	
	@Override
	public boolean equals(Object o) {
		boolean equal = false;
		if(o!=null && o instanceof Elemento)
		{
			Elemento other= (Elemento) o;
			equal= Objects.equals(sigla, other.sigla);
		}
		return equal;
	}
}
