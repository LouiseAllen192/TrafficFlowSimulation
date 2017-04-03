package Threading;

import java.util.HashMap;

public class Lock {

	private static Lock lock = new Lock();
	private HashMap<String, Object> locks;
	
	private Lock() {
		locks = new HashMap<>();
	}
	
	public static Lock getInstance() {
		return lock;
	}
	
	public boolean hasLock(String key) {
		return (locks.containsKey(key));
	}
	
	public Object createLock(String key) throws DuplicateLockException {
		if (!hasLock(key)) {
			locks.put(key, new Object());
			return locks.get(key);
		} else {
			throw new DuplicateLockException(key);
		}
	}
	
	public void removeLock(String key) {
		locks.remove(key);
	}
	
	public Object getLock(String key) throws UnknownLockException {
		if (hasLock(key)) {
			return locks.get(key);
		} else {
			throw new UnknownLockException(key);
		}
	}
}
