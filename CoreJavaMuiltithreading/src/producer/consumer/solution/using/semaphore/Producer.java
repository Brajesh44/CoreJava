package producer.consumer.solution.using.semaphore;

public class Producer implements Runnable {
	Q q;
	
	

	public Producer(Q q) {
		
		this.q = q;
		new Thread(this, "Produce").start();
	}



	 public void run() 
	    { 
	        for (int i = 0; i < 5; i++) 
	            // producer put items 
	            q.put(i); 
	    } 

}
