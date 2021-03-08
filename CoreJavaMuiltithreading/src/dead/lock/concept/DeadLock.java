package dead.lock.concept;

public class DeadLock extends Thread {
	
	A a= new A();
	B b= new B();
	public void m1() {
		
		this.start();
		a.b1(b);
	}
	@Override
	public void run() {
		b.b2(a);
	}

	public static void main(String[] args) {
    DeadLock d=new DeadLock();
    d.m1();
	}

}
