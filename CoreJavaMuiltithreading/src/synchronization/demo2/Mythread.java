package synchronization.demo2;

public class Mythread extends Thread{
	
	Display d;
	String name;
	public Mythread( Display d, String name) {
         this.name=name;
         this.d=d;
    }
	@Override
	public void run() {
		d.display(name);
	}

}
