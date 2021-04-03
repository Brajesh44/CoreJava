package Executor.Framework;

import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

class MyPrintJob implements Runnable{

	String name;
	public MyPrintJob(String name) {
		this.name=name;
	}
	public void run() {
		 System.out.println(name+"print job started by Thread"+Thread.currentThread().getName());
		
		 try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println(name+"Job completed by Thread"+Thread.currentThread().getName());
	}
	
}

public class ExecutorByUsingRunnableTask  {

	public static void main(String[] args) {
		MyPrintJob[] jobs= {new MyPrintJob("Durga====="),
				            new MyPrintJob("Brajesh==="),
				            new MyPrintJob("VardhRaj=="),
				            new MyPrintJob("Lala======"),
				            new MyPrintJob("Ragh======"),
				            new MyPrintJob("Ra========")
				       }; 
		
		ExecutorService service= Executors.newFixedThreadPool(3);
		for(MyPrintJob job :jobs) {
		
			Future<?> f=service.submit(job);
			try {
				System.out.println(f.get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//service.execute(job);


		}
		   service.shutdown();
	
		
	}
	
}
