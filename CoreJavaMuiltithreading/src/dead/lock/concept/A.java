package dead.lock.concept;

public class A {
	
	public synchronized void b1(B b) {
		System.out.println("thread t1 start excution of d1 method");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		b.last();
		System.out.println("Thread t1 trying to call B's last method");
		 
	}
	
	public synchronized void last() {
		
		System.out.println("inside A last() method");
	}

}
