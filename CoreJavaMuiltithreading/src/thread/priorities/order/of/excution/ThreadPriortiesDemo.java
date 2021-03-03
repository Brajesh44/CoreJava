package thread.priorities.order.of.excution;

class Mythread implements Runnable{
	@Override
	public void run() {
		System.out.println("Thread Name="+Thread.currentThread().getName()+"="+
				"Priority="+Thread.currentThread().getPriority());
		for(int i=0;i<=10;i++){
			System.out.println("Child Thread");
		}
	}
	
}

public class ThreadPriortiesDemo {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Thread Name="+Thread.currentThread().getName()+"="+
				"Priority="+Thread.currentThread().getPriority());
		
		Mythread mt= new Mythread();
		String threadname= "golu";
		Thread t= new Thread(mt, threadname);
		t.setPriority(10);
		t.start();
		/*t.setPriority(10);*/
		for(int i=0;i<=10;i++){
			System.out.println("Main Thread");
		}
		

	}

}
