package producer.consumer.solution.using.semaphore;

public class PC {

	public static void main(String[] args) {
		Q q= new Q();
		
		new Consumer(q);
		new Producer(q);


	}

}
