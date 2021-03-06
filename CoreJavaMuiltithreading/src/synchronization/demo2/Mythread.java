package synchronization.demo2;

public class Mythread extends Thread{
	
	Display d;
	String name;
	public Mythread( Display d, String name) {
   this.d=d;
   this.name=name;

	}
	@Override
	public void run() {
    d.display(name);
	}

}
