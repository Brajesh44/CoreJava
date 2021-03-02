package child.main.thread.excution;

public class Mythread extends Thread {
	@Override
	public void run() {
		System.out.println("run method excuted by thread=="+Thread.currentThread().getName());
	}

}
