package study4;

public class Test_Method1 {

	// 클래스 실행 시 기본메소드인 main 메소드만 실행

	public static void main(String[] args) {

		System.out.println(" = 중국집 메뉴 = ");
		chinaMenu();

		System.out.println(" = 분식집 메뉴 = ");
		bunsikMenu();

	}

	public static void chinaMenu() {
		System.out.println("1. 짜장면 - 4000원");
		System.out.println("2. 짬뽕 - 5000원");
	}

	public static void bunsikMenu() {
		System.out.println("1. 떡라면 - 3500원");
		System.out.println("2. 떡볶이 - 4000원");
	}

}
