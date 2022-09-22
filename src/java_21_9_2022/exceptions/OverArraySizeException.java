package java_21_9_2022.exceptions;

public class OverArraySizeException extends ArrayIndexOutOfBoundsException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5223553952291927889L;

    private static String message;
	
	public OverArraySizeException ()
	{
		super(message);
	}
	
	public OverArraySizeException(String message)
	{
		this();
		OverArraySizeException.message=message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
