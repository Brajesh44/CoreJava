package join.method.case1.demo;

class MyThread extends Thread{
	@Override
	public void run() {
		for(int i=0; i<=10; i++) {
			System.out.println("Child Thread");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	}
}

public class JoinMethodDemoCase1 {

	public static void main(String[] args) throws InterruptedException {
		MyThread mt = new MyThread();
		mt.start();
		mt.join();
		for (int i = 0; i <10; i++) {
			System.out.println("main thread");
			
		}

	}

}
