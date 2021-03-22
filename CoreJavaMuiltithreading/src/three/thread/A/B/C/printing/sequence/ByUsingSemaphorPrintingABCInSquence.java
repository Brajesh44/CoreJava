package three.thread.A.B.C.printing.sequence;

import java.util.concurrent.Semaphore;

public class ByUsingSemaphorPrintingABCInSquence {

	private static Semaphore a= new Semaphore(1);
	private static Semaphore b= new Semaphore(0);
	private static Semaphore c= new Semaphore(0);
	
static class MythreadA extends Thread{
		
	
		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				
				try {
					a.acquire();
					System.out.print("A");
					b.release();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} 
			
		}
}
		static class MythreadB extends Thread{
			
		
			
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					
					try {
						b.acquire();
						System.out.print("B");
						c.release();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				} 
				
			}
		}
			static class MythreadC extends Thread{
				
				
				
				@Override
				public void run() {
					for (int i = 0; i < 10; i++) {
						
						try {
							c.acquire();
							System.out.print("C");
							a.release();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					} 
					
				}
			}
		
	
	public static void main(String[] args) {
		
		new MythreadA().start();
		new MythreadB().start();
		new MythreadC().start();
		
	}
	
	
}
