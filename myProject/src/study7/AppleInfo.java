package study7;

public class AppleInfo {
	final String name = "사과"; // 맴버변수, 클래스(전역)변수, 상수 처리된 변수
	int price = 3000; // 맴버변수, 클래스(전역)변수

	void discount() {
		price = price - (price / 10);
	}
}
