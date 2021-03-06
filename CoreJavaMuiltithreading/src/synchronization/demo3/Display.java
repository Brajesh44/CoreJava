package synchronization.demo3;

public class Display {
	
	public synchronized void displaynumber() {
		
		for (int i = 0; i <=10; i++) {
			
			System.out.print(i);
			try {
			Thread.sleep(2000);
			}
			catch (InterruptedException e) {
				// TODO: handle exception
			}
			
		}
		
	}
public synchronized void displayChar() {
		
		for (int i = 65; i <=77; i++) {
			
			System.out.print((char)i);
			try {
			Thread.sleep(2000);
			}
			catch (InterruptedException e) {
				// TODO: handle exception
			}
			
		}
		
	}

}
