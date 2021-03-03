package thread.priorities;

/*Every thread in java have some priority by dafult provided by JVM or
explicitly  by Set by programmer . if a two thread having same priorities then witch thread getting chance frist
it's decided by JVM it may be flow round robin algo, FCFS alo and so on that's why we can pridict exact excution order of thread  
defult prority of main thread is 5.  
*/

class MythreadPriorities extends Thread {
	
	
}

public class ThreadPrioritiesDemo {
	public static void main(String[] args) {
		System.out.println(Thread.MAX_PRIORITY);
		System.out.println(Thread.MIN_PRIORITY);
		System.out.println(Thread.NORM_PRIORITY);
		/*defult thread prority of main thread */
		System.out.println(Thread.currentThread().getPriority());
		/*Exception in thread "main" java.lang.IllegalArgumentException 
		 * if thread setting priority more than 10 then we will get IllegalArgumentExeption */
		/*Thread.currentThread().setPriority(17);*/
		Thread.currentThread().setPriority(9);
		System.out.println(Thread.currentThread().getPriority());
		MythreadPriorities t= new MythreadPriorities();
		t.start();
		/*what ever priorty have parrent same priorty have child */
		System.out.println(t.getPriority());
		
	}

}
