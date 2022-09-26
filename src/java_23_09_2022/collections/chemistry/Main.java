package java_23_09_2022.collections.chemistry;

public class Main {

	public static void main(String[] args) {
		
		Element ossigeno = new Element("O");
		Element idrogeno = new Element("H");
		Molecule acqua = new Molecule();
		
		acqua.add(idrogeno, 1);
		acqua.add(ossigeno, 1);
		acqua.add(idrogeno, 1);
		
		System.out.println(acqua);
	}

}
