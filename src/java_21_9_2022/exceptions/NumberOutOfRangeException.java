package java_21_9_2022.exceptions;

import java.io.IOException;

public class NumberOutOfRangeException extends IOException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2658337483261341963L;
	
	private String message;
	
	public NumberOutOfRangeException ()
	{
		super();
	}
	
	public NumberOutOfRangeException(String message)
	{
		this();
		this.message=message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
