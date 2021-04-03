package Executor.Framework;

import java.util.concurrent.Executor;

public class ThreadExcutorExample {
     public static void main(String[] args) {
    	 DumpExecutor dume= new DumpExecutor();
         Mytask mytask= new Mytask();
         dume.execute(mytask);
	}
	static class DumpExecutor implements Executor{

		@Override
		public void execute(Runnable runnable) {
			Thread newThread= new Thread(runnable);
			    newThread.start();
			
		}}
    static class Mytask implements Runnable{

		@Override
		public void run() {
			System.out.println("I am running my task");
			
		}}

}
