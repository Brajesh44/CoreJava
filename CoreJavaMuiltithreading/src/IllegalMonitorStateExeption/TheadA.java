package IllegalMonitorStateExeption;

/*excution of statement are below
1Statement calling wait () which is expecting updation  
2Statement calling child thread using  
3Statement child thread responsilbe to perform updation 
4Statement child thread going to calcululate
5Statement child thread calulation is completed
6Statement wating thread which is responsile to accept updation through notify()
7Statement waiting thread got notify
5050*/

public class TheadA {
	
	public static void main(String[] args) throws InterruptedException {
		ThreadB b= new ThreadB();
		b.start(); 
		
		synchronized (b) {
			System.out.println("1Statement calling wait () which is expecting updation  ");
			b.wait();
			System.out.println("7Statement waiting thread got notify");
			System.out.println(b.tottal);
			
			
		}
	}
	

}
