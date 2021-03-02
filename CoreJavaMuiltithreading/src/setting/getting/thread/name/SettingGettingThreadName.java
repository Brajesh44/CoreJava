package setting.getting.thread.name;

public class SettingGettingThreadName {

	public static void main(String[] args) {
		
		System.out.println(Thread.currentThread().getName());
		MyThread mt = new MyThread();
		System.out.println(mt.getName());
		Thread.currentThread().setName("Brajesh");
		System.out.println(Thread.currentThread().getName());
		

	}

}
