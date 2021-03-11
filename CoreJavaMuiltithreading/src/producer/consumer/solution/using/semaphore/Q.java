package producer.consumer.solution.using.semaphore;

import java.util.concurrent.Semaphore;

public class Q {
	
	int item;
	
	static Semaphore semCon= new Semaphore(0);
	static Semaphore semProd= new Semaphore(1);
	
	public void get() {
		
		try{
			
			semCon.acquire();
			
		}catch(InterruptedException e){
			System.out.println("InterruptedException Caught");
		}
		 System.out.println("Consumer consumed item : " + item); 
		semProd.release();
	}
	
	public void put(int item) {
		try {
			semProd.acquire();
		} catch (InterruptedException e) {
			System.out.println("InterruptedException Caught");
		}
		
		this.item=item;
		System.out.println("Producer produced item : " + item); 
		semCon.release();
	}

}
