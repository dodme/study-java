package study7;

public class MyFruit2 {

	public static void main(String[] args) {

		// MyFruit2 f = new MyFruit2();
		AppleInfo f = new AppleInfo();
		System.out.println(f.name);
		System.out.println(f.price);
		f.discount();
		System.out.println(f.price);
	}

}
