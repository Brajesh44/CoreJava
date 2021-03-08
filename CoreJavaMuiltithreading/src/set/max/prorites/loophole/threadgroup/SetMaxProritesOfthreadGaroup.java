package set.max.prorites.loophole.threadgroup;

/* thread in the thread group that have already having high priorities would not be 
 * affected but newly added thread this Max priority will be applicable.
 * below out put the program 
5
5
3

 *  */

public class SetMaxProritesOfthreadGaroup {

	public static void main(String[] args) {
		ThreadGroup g1=new ThreadGroup("tg");
		Thread t1= new Thread(g1,"Thread1");
		Thread t2= new Thread(g1,"Thread2");
		g1.setMaxPriority(3);
		Thread t3= new Thread(g1,"Thread3");
		System.out.println(t1.getPriority());
		System.out.println(t2.getPriority());
		System.out.println(t3.getPriority());
		

	}

}
