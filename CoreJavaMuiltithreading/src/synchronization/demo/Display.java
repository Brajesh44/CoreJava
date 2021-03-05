package synchronization.demo;

public class Display {
/*	without synchronized keyword we are able to get irregular output 
 * Good Morning==:Good Morning==:Dhoni
Good Morning==:YuvRaj
Good Morning==:Dhoni
Good Morning==:YuvRaj
Good Morning==:Dhoni
Good Morning==:YuvRaj
Good Morning==:YuvRaj
Dhoni
Good Morning==:Good Morning==:YuvRaj
Good Morning==:Dhoni
Good Morning==:YuvRaj
Good Morning==:Dhoni
Good Morning==:Dhoni
Good Morning==:YuvRaj
Good Morning==:Dhoni
Good Morning==:YuvRaj
Good Morning==:YuvRaj
Good Morning==:Dhoni
Good Morning==:Dhoni
YuvRaj

but while using synchronized keyword we able to get regular out put
Good Morning==:YuvRaj
Good Morning==:YuvRaj
Good Morning==:YuvRaj
Good Morning==:YuvRaj
Good Morning==:YuvRaj
Good Morning==:YuvRaj
Good Morning==:YuvRaj
Good Morning==:YuvRaj
Good Morning==:YuvRaj
Good Morning==:YuvRaj
Good Morning==:Dhoni
Good Morning==:Dhoni
Good Morning==:Dhoni
Good Morning==:Dhoni
Good Morning==:Dhoni
Good Morning==:Dhoni
Good Morning==:Dhoni
Good Morning==:Dhoni
Good Morning==:Dhoni
Good Morning==:Dhoni
 */
public synchronized void wish( String name) {
	for (int i = 0; i < 10; i++) {
		System.out.print("Good Morning==:");
		
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
