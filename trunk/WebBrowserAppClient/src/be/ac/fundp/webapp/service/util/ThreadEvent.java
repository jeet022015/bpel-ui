package be.ac.fundp.webapp.service.util;

// TODO: Auto-generated Javadoc
/**
 * The Class ThreadEvent.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dec 9, 2011
 */
public class ThreadEvent {
	
	/** The lock. */
	private final Object lock = new Object();

    /**
     * Signal.
     */
    public void signal() {
        synchronized (lock) {
            lock.notify();
        }
    }

    /**
     * Await.
     *
     * @throws InterruptedException the interrupted exception
     */
    public void await() throws InterruptedException {
        synchronized (lock) {
            lock.wait();
        }
    }
}
