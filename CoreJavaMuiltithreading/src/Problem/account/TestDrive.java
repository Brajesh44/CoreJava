package Problem.account;

import java.util.concurrent.Semaphore;

 class Account {

	int amount;

	public Account(int amount) {

		this.amount = amount;
	}

	public int debitMin() {
         amount= amount-10;
         System.out.println("amount debitMin is debited="+amount);
		return amount;
	}

	public int debitMax() {
		 amount= amount-20;
         System.out.println("amount debitMax is debited="+amount);
		return amount;
	}

	public int creditMin() {
		 amount= amount+10;
         System.out.println("amount creditMin is credit="+amount);
		return amount+10;
	}

	public int creditMax() {
		 amount= amount+20;
         System.out.println("amount creditMax is credit="+amount);
		return amount;
	}

}

class DebitMaxThread extends Thread{
	Account ac;
	boolean t=true;
	Semaphore debitMax;
	Semaphore debitmin;
	public DebitMaxThread(Account ac, Semaphore debitMax, Semaphore debitmin) {
		this.ac = ac;
		this.debitMax = debitMax;
		this.debitmin = debitmin;
	}
	@Override
	public void run() {
		if(t) {
			try {
				debitMax.acquire();
				ac.debitMax();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			debitmin.release();
		}
		
	}
	
}
class DebitMinThread extends Thread{
	Account ac;
	
	Semaphore debitMax;
	Semaphore debitmin;
	public DebitMinThread(Account ac, Semaphore debitMax, Semaphore debitmin) {
		this.ac = ac;
		this.debitMax = debitMax;
		this.debitmin = debitmin;
	}
	@Override
	public void run() {
	
			
			try {
				debitmin.acquire();
				ac.debitMin();
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			debitMax.release();
		}
	}
class CreditMaxThread extends Thread{
	Account ac;
	boolean t=true;
	Semaphore creditMax;
	Semaphore creditMin;
	public CreditMaxThread(Account ac, Semaphore creditMax, Semaphore creditMin) {
		this.ac = ac;
		this.creditMax = creditMax;
		this.creditMin = creditMin;
	}
	@Override
	public void run() {
		if(t) {
			try {
				creditMax.acquire();
				ac.creditMax();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			creditMin.release();
		}
		
	}
	
}
class CreditMinThread extends Thread{
	Account ac;
	boolean t=true;
	Semaphore creditMax;
	Semaphore creditMin;
	public CreditMinThread(Account ac, Semaphore creditMax, Semaphore creditMin) {
		this.ac = ac;
		this.creditMax = creditMax;
		this.creditMin = creditMin;
	}
	@Override
	public void run() {
		if(t) {
			try {
				creditMin.acquire();
				ac.creditMin();
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			creditMax.release();
		}
		
	}
	
}

 public class TestDrive{
	
	public static void main(String[] args) {
		Semaphore debitMax=new Semaphore(0);
		Semaphore debitmin=new Semaphore(1);
		Account ac= new Account(100);
		DebitMaxThread t1= new DebitMaxThread(ac, debitMax, debitmin);
		DebitMinThread t2= new DebitMinThread(ac, debitMax, debitmin);
		CreditMaxThread t3= new CreditMaxThread(ac, debitMax, debitmin);
		CreditMinThread t4= new CreditMinThread(ac, debitMax, debitmin);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}