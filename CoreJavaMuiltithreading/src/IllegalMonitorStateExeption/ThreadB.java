package IllegalMonitorStateExeption;

public class ThreadB extends Thread {
	 int tottal=0;
	@Override
	public void run() {
	 synchronized (this) {
		 System.out.println("2Statement calling child thread using  ");
		 System.out.println("3Statement child thread responsilbe to perform updation ");
		 System.out.println("4Statement child thread going to calcululate");
		 for (int i = 1; i <=100; i++)
		 {
			 tottal= tottal+i; 
			 notify();
		}
		 System.out.println("5Statement child thread calulation is completed");
		 System.out.println("6Statement wating thread which is responsile to accept updation through notify()");
		
	}
	}

	

}
