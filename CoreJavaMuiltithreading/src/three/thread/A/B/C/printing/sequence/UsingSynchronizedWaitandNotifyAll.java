package three.thread.A.B.C.printing.sequence;

public class UsingSynchronizedWaitandNotifyAll {

	 public static class ThreadPrinter implements Runnable {
	        private String name;
	        private Object prev;
	        private Object self;

	        private ThreadPrinter(String name, Object prev, Object self) {
	            this.name = name;
	            this.prev = prev;
	            this.self = self;
	        }

	        @Override
	        public void run() {
	            int count = 10;
	            while (count > 0) {
	            	// Multithreaded concurrency, if not available, whil loop must be used
	                synchronized (prev) { // Get prev lock first
	                    synchronized (self) {// Get the self lock again
	                        System.out.print(name);// Print
	                        count--;

	                        self.notifyAll();// Wake up other threads to compete for a self lock, noting that the self lock is not immediately released at this time.
	                    }
	                    // The synchronization block of the self is executed, and the self lock is released.
	                    try {
	                        if (count == 0) {// If count==0, this is the last print operation to release the object lock through the notifyAll operation.
	                            prev.notifyAll();
	                        } else {
	                            prev.wait(); // Release the prev lock immediately, the current thread sleeps, waiting to wake up
	                        }
	                    } catch (InterruptedException e) {
	                        e.printStackTrace();
	                    }
	                }
	            }
	        }
	    }

	    public static void main(String[] args) throws Exception {
	        Object a = new Object();
	        Object b = new Object();
	        Object c = new Object();
	        ThreadPrinter pa = new ThreadPrinter("A", c, a);
	        ThreadPrinter pb = new ThreadPrinter("B", a, b);
	        ThreadPrinter pc = new ThreadPrinter("C", b, c);

	        new Thread(pa).start();
	        Thread.sleep(10);// Ensure the starting sequence of the initial ABC
	        new Thread(pb).start();
	        Thread.sleep(10);
	        new Thread(pc).start();
	        Thread.sleep(10);
	    }
	}
