package java_29_09_2022.collections.lottery.exception;



public class BadInputException extends Exception {


	/**
	 * 
	 */
	private static final long serialVersionUID = 3495337778764735368L;

	public BadInputException()
	{
		super();
	}
	
	public BadInputException(String message) {
		super(message);
	}

}
