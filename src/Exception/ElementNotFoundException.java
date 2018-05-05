package Exception;

public class ElementNotFoundException extends Exception {

	/**
     * Constructs an <code>ElementNotFoundException</code> with no
     * detail message.
     */
	public ElementNotFoundException() {
		super();

	}


    /**
     * Constructs an <code>ElementNotFoundException</code> with the
     * specified detail message.
     *
     * @param   message   the detail message.
     */
	public ElementNotFoundException(String message) {
		super("MyException: " + message);

	}

}
