package dead.lock.concept;

public class B {
	public synchronized void b2(A a) {
		System.out.println("thread t2 start excution of d2 method");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Thread t2 trying to call A's last method");
		a.last();
	}
	
	public synchronized void last() {
		System.out.println("inside B last() method");
	}
}
