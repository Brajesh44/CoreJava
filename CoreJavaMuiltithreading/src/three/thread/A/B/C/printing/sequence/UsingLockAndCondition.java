package three.thread.A.B.C.printing.sequence;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UsingLockAndCondition {
	
	    private static Lock lock = new ReentrantLock();
	    private static Condition A = lock.newCondition();
	    private static Condition B = lock.newCondition();
	    private static Condition C = lock.newCondition();

	    private static int count = 0;

	    static class ThreadA extends Thread {
	        @Override
	        public void run() {
	            try {
	                lock.lock();

	                for (int i = 0; i < 10; i++) {
	                    while (count % 3 != 0){
	                    	//Note that this is not equal to 0,
	                    	//that is, it is not the thread's turn to 
	                    	//execute and it has been waiting for the state
	                        A.await(); 
	                        //Thread A releases the lock lock, 
	                        //constructs the node to join the waiting
	                        //queue and enter the waiting state
	                    }
	                    System.out.print("A");
	                    count++;
	                    B.signal(); // A Wake Up B Thread After Execution
	                }

	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            } finally {
	                lock.unlock();
	            }
	        }
	    }

	    static class ThreadB extends Thread {
	        @Override
	        public void run() {
	            try {
	                lock.lock();
	                for (int i = 0; i < 10; i++) {
	                    while (count % 3 != 1)
	                        B.await();// B releases the lock, and the current thread A wakes up after execution through B.signal()
	                    System.out.print("B");
	                    count++;
	                    C.signal();// B Wake up C thread after execution
	                }
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            } finally {
	                lock.unlock();
	            }
	        }
	    }

	    static class ThreadC extends Thread {
	        @Override
	        public void run() {
	            try {
	                lock.lock();
	                for (int i = 0; i < 10; i++) {
	                    while (count % 3 != 2)
	                        C.await();// C Release lock
	                    System.out.print("C");
	                    count++;
	                    A.signal();// Wake Up A Thread After C Execution
	                }
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            } finally {
	                lock.unlock();
	            }
	        }
	    }

	    public static void main(String[] args) throws InterruptedException {
	        new ThreadA().start();
	        new ThreadB().start();
	        new ThreadC().start();
	    }
	}

