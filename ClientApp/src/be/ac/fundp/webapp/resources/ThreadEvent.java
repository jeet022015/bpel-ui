package be.ac.fundp.webapp.resources;

public class ThreadEvent {

	private static ThreadEvent self;
    private final Object lock = new Object();

    public void signal() {
        synchronized (lock) {
            lock.notify();
        }
    }

    public void await() throws InterruptedException {
        synchronized (lock) {
            lock.wait();
        }
    }

	public static ThreadEvent getInstance() {
		if (self == null){
			self = new ThreadEvent();
		}
		return self;
	}
}