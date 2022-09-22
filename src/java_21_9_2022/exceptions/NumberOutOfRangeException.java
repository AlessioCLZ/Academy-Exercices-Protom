package java_21_9_2022.exceptions;

import java.io.IOException;

public class NumberOutOfRangeException extends IOException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2658337483261341963L;
	
	private static String message;
	
	public NumberOutOfRangeException ()
	{
		super(message);
	}
	
	public NumberOutOfRangeException(String message)
	{
		this();
		NumberOutOfRangeException.message=message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
