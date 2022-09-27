package java_23_09_2022.collections.safeSet;

import java.util.Map;
import java.util.TreeMap;

public class SafeSet<E> {

	private Map<E, Boolean> safeSet = new TreeMap<E,Boolean>();
	
	public boolean add (E item)
	{
		if(safeSet.containsKey(item))
			return false;
		else
		{
			safeSet.put(item, false);
			return true;
		}
	}
	
	public boolean remove(E item)
	{
		if(safeSet.containsKey(item))
		{
			if (!safeSet.get(item).booleanValue())
			{
				safeSet.put(item, true);
				return true;
			}
			else
			{
				safeSet.remove(item);
				return true;
			}
		}
		else
			return false;
	}
	
	public boolean contains (E item)
	{
		return safeSet.containsKey(item) && !safeSet.get(item).booleanValue();
	}
}
