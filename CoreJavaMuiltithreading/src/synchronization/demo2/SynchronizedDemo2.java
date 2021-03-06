package synchronization.demo2;

/*if we create only one diplay object then we will get regular output
means t1 and t2 thread trying to acesss display object d and 
it's allowed to access sychronized display methoad one by one at a time 
that's why we will got regualr out put below
Good Morning=:Dhoni
Good Morning=:Dhoni
Good Morning=:Dhoni
Good Morning=:Dhoni
Good Morning=:Dhoni
Good Morning=:YuvRaj
Good Morning=:YuvRaj
Good Morning=:YuvRaj
Good Morning=:YuvRaj
Good Morning=:YuvRaj
code snipet is below
Display d1= new Display();
Display d2= new Display();
Mythread t1= new Mythread(d1, "Dhoni");
Mythread t2= new Mythread(d1, "YuvRaj");
         t1.start();
         t2.start();
*/

/*if we create two display object then we will get irregular out put
 * then myhthread t1 and t2 are trying to access simultaneously 
 * then we will get irrregular out put
 * code snipet is below
 * 	Display d1= new Display();
		
		Mythread t1= new Mythread(d1, "Dhoni");
		Mythread t2= new Mythread(d1, "YuvRaj");
	             t1.start();
	             t2.start();
 * 
 * Good Morning=:Good Morning=:YuvRaj
Good Morning=:Dhoni
Good Morning=:Dhoni
Good Morning=:YuvRaj
Good Morning=:Dhoni
Good Morning=:YuvRaj
Good Morning=:Dhoni
Good Morning=:YuvRaj
Good Morning=:Dhoni
YuvRaj

 *  to over come this problem we will use class level lock
 * 
 * 
 * 
 * */


public class SynchronizedDemo2 {

	
	public static void main(String[] args) {
		Display d1= new Display();
		Display d2= new Display();
		
		Mythread t1= new Mythread(d1,"Dhoni");
		Mythread t2= new Mythread(d2,"YuvRaj");
	             t1.start();
	             t2.start();
	
	}
}
