package child.main.thread.excution;

public class TestNamingThread {

	public static void main(String[] args) {
		Mythread mt= new Mythread();
		mt.start();
		System.out.println("Main method executed by thread=="+Thread.currentThread().getName());
	}

}
