package Exception;

public class CalorieException extends Exception {

	/**
     * Constructs an <code>CalorieException</code> with no
     * detail message.
     */
	public CalorieException(){
		super();
	}
	
	/**
     * Constructs an <code>CalorieException</code> with the
     * specified detail message.
     *
     * @param   message   the detail message.
     */
	public CalorieException(String message){
		super("MyException " + message);
	}

}
