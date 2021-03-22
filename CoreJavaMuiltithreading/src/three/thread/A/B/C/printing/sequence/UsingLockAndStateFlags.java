package three.thread.A.B.C.printing.sequence;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UsingLockAndStateFlags {

	 private static Lock lock=new ReentrantLock();
	    private static int state=0;//Determine which thread is printing by the value of the state

	   static class ThreadA extends Thread{
	        @Override
	        public void run(){
	            for (int i = 0; i <10 ; ) {
	                try{
	                    lock.lock();
	                    while(state%3==0){// Multithreaded concurrency, if not available, 
	                    	//wait conditions must be tested with a loop to avoid false wakeup
	                        System.out.print("A");
	                        state++;
	                        i++;
	                    }
	                }finally{
	                    lock.unlock();
	                }
	            }
	        }
	    }

	    static class ThreadB extends Thread{
	        @Override
	        public void run(){
	            for (int i = 0; i <10 ; ) {
	                try{
	                    lock.lock();
	                    while(state%3==1){
	                        System.out.print("B");
	                        state++;
	                        i++;
	                    }
	                }finally{
	                    lock.unlock();
	                }
	            }
	        }
	    }


	    static class ThreadC extends Thread{
	        @Override
	        public void run(){
	            for (int i = 0; i <10 ; ) {
	                try{
	                    lock.lock();
	                    while(state%3==2){
	                        System.out.print("C");
	                        state++;
	                        i++;
	                    }
	                }finally{
	                    lock.unlock();
	                }
	            }
	        }
	    }

	    public static void main(String[] args) {
	        new ThreadA().start();
	        new ThreadB().start();
	        new ThreadC().start();
	    }
	}