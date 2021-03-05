package join.method.case1.demo;

public  class DeadLock {

	public  static void main(String[] args) throws InterruptedException {
		Thread.currentThread().join();
		System.out.println("main");

	}

}
