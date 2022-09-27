package java_26_09_2022.collections.rotateList;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class RotatingList<E> {

	List<E> elements;
	
	public RotatingList()
	{
		elements = new ArrayList<E>();
	}
	
	public void add(E element)
	{
		elements.add(element);
	}
	
	public E getHead()
	{
		return elements.get(0);
	}
	
	public E getTail()
	{
		return elements.get(elements.size()-1);
	}
	
	public void rotateLeft()
	{
		if(elements.isEmpty() ||elements.size()==1)
			return;
		else
		{
			E temp = getHead();
			for(int i=0; i<elements.size()-1;i++)
			{
				elements.set(i, elements.get(i+1));
			}
			elements.set(elements.size()-1, temp);
		}
		//versione semplificata
		// Collections.rotate(elements, -1);
	}
	
	public void rotateRight()
	{
		if(elements.isEmpty() ||elements.size()==1)
			return;
		else
		{
			E temp = getTail();
		    for(int i=elements.size()-1; i>0;i--)
		    {
		    	elements.set(i, elements.get(i-1));
		    }
		    elements.set(0, temp);
		}
		//versione semplificata
		//	Collections.rotate(elements, 1);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj)
	{
		if(obj==null)
			return false;
		
		RotatingList<E> rotatingList = (RotatingList<E>) obj;		
		
		Set<E> thisSet = new TreeSet<>();		
		Set<E> otherSet = new TreeSet<>();		
		
		for (E t : elements) {
			thisSet.add(t);			
		}
		for (E t : rotatingList.elements) {
			otherSet.add(t);		
		}
		
		return thisSet.equals(otherSet);
	}
}
