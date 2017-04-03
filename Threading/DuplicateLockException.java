package Threading;

public class DuplicateLockException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public DuplicateLockException(String message) {
		super("Tried to create a lock that already exists. Please use lock.hasLock() to check if lock exists first. - " + message);
	}
	
}