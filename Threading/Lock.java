package Threading;

import java.util.HashMap;

public class Lock {

	private HashMap<String, Object> locks;
	private static Lock lock = new Lock();
	
	private Lock() {
		this.locks = new HashMap<>();
	}
	
	public Object createLock(String key) throws DuplicateLockException {
		if (!hasLock(key)) {
			this.locks.put(key, new Object());
			return this.locks.get(key);
		} else {
			throw new DuplicateLockException(key);
		}
	}
	
	public static Lock getInstance() {
		return lock;
	}
	
	public Object getLock(String key) throws UnknownLockException {
		if (hasLock(key)) {
			return this.locks.get(key);
		} else {
			throw new UnknownLockException(key);
		}
	}
	
	public boolean hasLock(String key) {
		return (this.locks.containsKey(key));
	}
	
	public void removeLock(String key) {
		this.locks.remove(key);
	}
	
}
