package Threading;

public class UnknownLockException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public UnknownLockException(String message) {
		super("Tried to access a lock that doesn't exist. Please use lock.hasLock() to check if lock exists first. - " + message);
	}
	
}