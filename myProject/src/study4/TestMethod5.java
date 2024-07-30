package study4;

public class TestMethod5 {

	public static void main(String[] args) {
		int year = 1995;
		TestMethod4.myAge1(year);

		int age = TestMethod4.myAge2(year) + 1;
		System.out.println(year + "의 나이는 " + age + "입니다.");
	}

}
