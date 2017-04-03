package Threading;

public class Timer {

	private int wait_time_ms;
	private long start_time, end_time, duration;
	private String message;
	
	private static final int framerate = 30;
	public static final int DEFAULT_FRAMERATE = (int)(1000 / framerate);
	
	public Timer () {
		this.wait_time_ms = 0;
	}
	
	public Timer(int milliseconds) {
		this.wait_time_ms = milliseconds;
	}
	
	public void start() {
		this.start_time = System.nanoTime();
	}
	
	public void end() {
		this.end_time = System.nanoTime();
		this.duration = (this.end_time - this.start_time) / 1000000;
		// this.print_message();
		this.sleep();
	}
	
	public void setMessage(String _message) {
		this.message = _message;
	}
	
	private boolean message_empty() {
		return (this.message == null || this.message.isEmpty());
	}
	
	private void sleep() {
		try {
			Thread.sleep(Math.max(this.wait_time_ms - this.duration, 0));
		} catch (InterruptedException ex) {
			if (!this.message_empty()) {
				System.out.printf("%s - Thread Interrupted\n");
			}
		}
	}
	
	private void print_message() {
		if (!this.message_empty()) {
			System.out.printf("%s - %d\n", this.message, this.duration);
		}
	}
}
