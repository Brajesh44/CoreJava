package Even.Odd.Number.Printing;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Odd extends Thread {
	OddEvenImpl pc;

	public Odd(OddEvenImpl pc) {
		this.pc = pc;
	}

	@Override
	public void run() {
		try {
			pc.printOdd();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
class Even extends Thread {
	 OddEvenImpl pc;
	 public Even(OddEvenImpl pc) {
	  this.pc = pc;
	 }
	 @Override
	    public void run() {
	        try {
	            pc.printEven();
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	}

class OddEvenImpl {
//Reentrant Lock
	private final Lock aLock = new ReentrantLock();

// Condition for ODD block
	private final Condition oddCondition = aLock.newCondition();

// Condition for EVEN block
	private final Condition evenCondition = aLock.newCondition();

// Variable to print ODD/ EVEN numbers
	private int counter = 1;

	/*
	 * ODD Block
	 */
	public void printOdd() throws InterruptedException {
		while (counter <= 10) {
			try {
				// Getting lock for ODD block
				aLock.lock();
				System.out.println("ODD : " + counter++);
				// signaling to EVEN condition
				evenCondition.signal();
				/*
				 * Just stopping await once reach counter to 10. Not to odd thread to await
				 * indefinitely
				 */
				if (counter < 10) {
					oddCondition.await();
				}
			} finally {
				aLock.unlock();
			}
		}
	}

	/*
	 * EVEN Block
	 */
	public void printEven() throws InterruptedException {
		while (counter <= 10) {
			try {
				// Getting lock for EVEN block
				aLock.lock();
				System.out.println("EVEN : " + counter++);
				// signaling to ODD condition
				oddCondition.signal();
				/*
				 * Just stopping await once reach counter to 10. Not to even thread to await
				 * indefinitely
				 */
				if (counter < 10) {
					evenCondition.await();
				}
			} finally {
				aLock.unlock();
			}
		}
	}
}
public class EvenOddByUsingReentrantAndConditon {
	public static void main(String[] args) {
		  
		  OddEvenImpl obj = new OddEvenImpl();
		  
		  Odd odd = new Odd(obj);
		  Even even = new Even(obj);
		  odd.start();

		  /* *
		   * Just starting 2nd thread after
		   * a half second
		   */
		  try {
		   Thread.sleep(500);
		  } catch (InterruptedException e) {
		   e.printStackTrace();
		  }
		  even.start();
		 }
}
