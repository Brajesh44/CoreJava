package yield.method.demo;



class Mythread extends Thread{
	
	@Override
	public void run() {
		System.out.println("Thread Name="+Thread.currentThread().getName()+"="+
				"Priority="+Thread.currentThread().getPriority());
		for(int i=0;i<=10;i++){
			System.out.println("Child Thread");
			Thread.yield();
		}
	}
}

public class YieldMethodDemo {

	public static void main(String[] args) {
		Thread.currentThread().setPriority(9);
	 Mythread t= new Mythread();
	 t.start();
	System.out.println("Thread Name="+Thread.currentThread().getName()+"="+
				"Priority="+Thread.currentThread().getPriority());
	 for(int i=0;i<=10;i++){
			System.out.println("Main Thread");
			
		}
	 

	}

}
