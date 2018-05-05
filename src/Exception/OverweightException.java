package Exception;

public class OverweightException extends Exception {

	/**
	 * Constructs an <code>OverweightException</code> with no detail message.
	 */
	public OverweightException() {
		super();
	}

	/**
	 * Constructs an <code>OverweightException</code> with the specified detail
	 * message.
	 *
	 * @param overalCalorie
	 *            the detail message.
	 */
	public OverweightException(double overalCalorie) {
		super("You will get overweight. Overal calorie is:" + overalCalorie);

	}

}
