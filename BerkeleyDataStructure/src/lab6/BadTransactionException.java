package lab6;

/* BadTransactionException.java */

/**
 * Implements an exception that should be thrown for nonexistent accounts.
 **/
public class BadTransactionException extends Exception {

	public int badTransactionNumber; // The invalid transaction number

	/**
	 * Creates an exception object for nonexistent account
	 * "badTransactionNumber".
	 **/
	public BadTransactionException(int badTransactionNumber) {
		super("Invalid number: " + badTransactionNumber);
		this.badTransactionNumber = badTransactionNumber;
	}
}
