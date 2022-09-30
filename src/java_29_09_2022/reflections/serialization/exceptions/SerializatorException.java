package java_29_09_2022.reflections.serialization.exceptions;

public class SerializatorException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9005737114562391206L;

	public SerializatorException() {}
	
	public SerializatorException(String message)
	{
		super(message);
	}
}
