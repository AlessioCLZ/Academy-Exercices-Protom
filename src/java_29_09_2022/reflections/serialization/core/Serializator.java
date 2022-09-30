package java_29_09_2022.reflections.serialization.core;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java_29_09_2022.reflections.serialization.annotations.DateFormat;
import java_29_09_2022.reflections.serialization.annotations.Skip;
import java_29_09_2022.reflections.serialization.annotations.SkipNull;
import java_29_09_2022.reflections.serialization.exceptions.SerializatorException;

public class Serializator {

	private static enum FileFormat
	{
		XML,
		JSON;
	}
	
	private static final String GET_PREFIX = "get";
	
	
	/**
	 * Metodo per serializzare un oggetto con in entrata anche il formato di formattazione
	 * @param o
	 * @param ff
	 * @throws SerializatorException
	 */
	public static void serialize(Object o, FileFormat ff) throws SerializatorException 
	{
		Class<?> classe = o.getClass();
		
		Field[] fields = classe.getDeclaredFields();
		
		String formattedDate = "";
		
		for (Field field: fields)
		{
			
			// Skip skip = field.getAnnotation(Skip.class);
			// SkipNull skipNull = field.getAnnotation(SkipNull.class);
			DateFormat dateFormat = field.getAnnotation(DateFormat.class);
			
			
			//blocco per la formattazione della data, se il campo in entrata è un LocalDate o LocalDateTime
			if(dateFormat != null)
			{
				Method[] methods = classe.getMethods();
				Method method=null;
				//controllo per localdate
				if(field.getType().equals(LocalDate.class)) //controllo che il field abbia lo stesso tipo di ciò che ho messo all'interno dell'equals
				{
					DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					for (Method m: methods)
					{
						if(m.getName().equals(GET_PREFIX + field.getName()))
						{
							method =m;
							break;
						}
					}
					if(method!=null)
					{
						LocalDate unformattedDate = null;
						try {
							unformattedDate = (LocalDate) method.invoke(o);
						} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
							
							e.printStackTrace();
						}
						formattedDate = unformattedDate.format(df); 
					}
				}
				else
				{
					throw new SerializatorException("Il campo annotato non è una data");
				}
				//controllo per locadatetime
				if(field.getType().equals(LocalDateTime.class)) //controllo che il field abbia lo stesso tipo di ciò che ho messo all'interno dell'equals
				{
					DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
					for (Method m: methods)
					{
						if(m.getName().equals(GET_PREFIX + field.getName()))
						{
							method =m;
							break;
						}
					}
					if(method!=null)
					{
						LocalDateTime unformattedDate = null;
						try {
							unformattedDate = (LocalDateTime) method.invoke(o);
						} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
							
							e.printStackTrace();
						}
						formattedDate = unformattedDate.format(df); 
					}
				}
				else
				{
					throw new SerializatorException("Il campo annotato non è una data con orario");
				}
			}
			
			
		}
		
		//switch con cui cambio il tipo di formattazione a seconda del formato in entrata
		switch(ff)
		{
			case XML :
				{
					String begin= "<" + o.getClass()+ ">", end = "</" + o.getClass()+ ">";
					StringBuilder output = new StringBuilder();
					output.append(begin);
					for(Field field:fields)
					{
						Skip skip = field.getAnnotation(Skip.class);
						SkipNull skipNull = field.getAnnotation(SkipNull.class);
						DateFormat dateFormat = field.getAnnotation(DateFormat.class);
						Method[] methods = classe.getMethods();
						Method method=null;
						String methodValue = "";
						
						for (Method m: methods)
						{
							if(m.getName().equals(GET_PREFIX + field.getName()))
							{
								method =m;
								break;
							}
						}
						
						//se il campo non ha annotazioni
						if(skip==null && skipNull==null && dateFormat==null)
						{
							if(method!=null)
							{
								try {
									methodValue = (String) method.invoke(o);
								} catch (IllegalAccessException | IllegalArgumentException
										| InvocationTargetException e) {
									
									e.printStackTrace();
								}
							}
														
							String unannotedString = "<"+field.getName()+">"+methodValue+"</"+ field.getName()+">";
							output.append(unannotedString);
						}
						//se il campo ha solo DateFormat come annotazione
						if(skip==null && skipNull==null && dateFormat!=null)
						{
							String dateformatString = "<"+field.getName()+">"+formattedDate+"</"+ field.getName()+">";
							output.append(dateformatString);
						}
						//se il campo ha solo skipNull come annotazione
						if(skip==null && skipNull!=null && dateFormat==null)
						{
							if(method!=null)
							{
								try {
									methodValue = (String) method.invoke(o);
								} catch (IllegalAccessException | IllegalArgumentException
										| InvocationTargetException e) {
									
									e.printStackTrace();
								}
							}
							if(methodValue!=null)
							{
								String unskippedString = "<"+field.getName()+">"+methodValue+"</"+ field.getName()+">";
								output.append(unskippedString);
							}
						}
						//se il campo ha skipnull e dateformat come annotazioni
						if(skip==null && skipNull!=null && dateFormat!=null)
						{
							if(method!=null)
							{
								try {
									methodValue = (String) method.invoke(o);
								} catch (IllegalAccessException | IllegalArgumentException
										| InvocationTargetException e) {
									
									e.printStackTrace();
								}
							}
							if(methodValue!=null)
							{
								String unskippedString = "<"+field.getName()+">"+formattedDate+"</"+ field.getName()+">";
								output.append(unskippedString);
							}
						}

					}
					output.append(end);
					
					System.out.println(output);
					
				};
			break;
			case JSON :
				{
					String begin= "{", end = "}";
					StringBuilder output = new StringBuilder();
					output.append(begin);
					for(Field field:fields)
					{
						Skip skip = field.getAnnotation(Skip.class);
						SkipNull skipNull = field.getAnnotation(SkipNull.class);
						DateFormat dateFormat = field.getAnnotation(DateFormat.class);
						Method[] methods = classe.getMethods();
						Method method=null;
						String methodValue = "";
						
						for (Method m: methods)
						{
							if(m.getName().equals(GET_PREFIX + field.getName()))
							{
								method =m;
								break;
							}
						}
						
						//se il campo non ha annotazioni
						if(skip==null && skipNull==null && dateFormat==null)
						{
							if(method!=null)
							{
								try {
									methodValue = (String) method.invoke(o);
								} catch (IllegalAccessException | IllegalArgumentException
										| InvocationTargetException e) {
									
									e.printStackTrace();
								}
							}
														
							String unannotedString = '"'+field.getName()+'"'+':'+" "+'"'+methodValue+'"'+',';
							output.append(unannotedString);
						}
						//se il campo ha solo DateFormat come annotazione
						if(skip==null && skipNull==null && dateFormat!=null)
						{
							String dateformatString ='"'+field.getName()+'"'+':'+" "+'"'+formattedDate+'"'+',';
							output.append(dateformatString);
						}
						//se il campo ha solo skipNull come annotazione
						if(skip==null && skipNull!=null && dateFormat==null)
						{
							if(method!=null)
							{
								try {
									methodValue = (String) method.invoke(o);
								} catch (IllegalAccessException | IllegalArgumentException
										| InvocationTargetException e) {
									
									e.printStackTrace();
								}
							}
							if(methodValue!=null)
							{
								String unskippedString = '"'+field.getName()+'"'+':'+" "+'"'+methodValue+'"'+',';
								output.append(unskippedString);
							}
						}
						//se il campo ha skipnull e dateformat come annotazioni
						if(skip==null && skipNull!=null && dateFormat!=null)
						{
							if(method!=null)
							{
								try {
									methodValue = (String) method.invoke(o);
								} catch (IllegalAccessException | IllegalArgumentException
										| InvocationTargetException e) {
									
									e.printStackTrace();
								}
							}
							if(methodValue!=null)
							{
								String unskippedString = '"'+field.getName()+'"'+':'+" "+'"'+formattedDate+'"'+',';
								output.append(unskippedString);
							}
						}

					}
					output.append(end);
					
					System.out.println(output);
				};
			break;
		}
		
		
		
	}
}



