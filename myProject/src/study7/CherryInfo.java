package study7;

public class CherryInfo {
	final static String name = "체리"; // 맴버변수, 클래스(전역)변수, 상수 처리된 변수
	static int price = 5000; // 맴버변수, 클래스(전역)변수

	static void discount() {
		price = price - (price / 10);
	}
}
