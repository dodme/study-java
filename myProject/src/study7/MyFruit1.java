package study7;

public class MyFruit1 extends CherryInfo {

	public static void main(String[] args) {
		// System.out.println(CherryInfo.name + " : " + CherryInfo.price + "원");
		price = 3000;
		// name = "사과"; error - 상수는 재정의 불가
		System.out.println(name + " : " + price);
		discount();
		System.out.println(name + " : " + price);
	}

}
