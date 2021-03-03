package join.method.case2.Demo;

public class JoinMethodDemo {

	public static void main(String[] args) throws InterruptedException {
		VenueFixingActivity t1= new VenueFixingActivity();
		WeddingCardPrinting t2=new WeddingCardPrinting();
		WeddingCardDistrubution t3= new WeddingCardDistrubution();
		t1.start();
		t1.join();
		t2.start();
		t2.join();
		t3.start();
	}

}
