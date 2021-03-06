package synchronization.demo2;

public class Display {
	
	public   synchronized void display(String name) {
		for (int i = 0; i <=4; i++) {
			System.out.print("Good Morning=:");
		     try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(name);
		}
		
	}

}
