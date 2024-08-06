package study6;

class Sample1 {

	public static void test1() {

	}

	public void test2() {

	}

}

public class Sample2 {

	int eng = 100;
	int kor = 98;

	public static void test3() {
		System.out.println(" -- test3 --");
	}

	public static void sum1(int eng, int kor) { // 매개변수(외부데이터 값을 받는 변수)
		int result = eng + kor;
		System.out.println("합계 : " + result);
	}

	public static int sum2(int eng, int kor) {
		int result = eng + kor;
		return result;
	}

	public void test4() {
		System.out.println(" -- test4 == ");
	}

	public static void main(String[] args) {
		int eng = 98;
		int kor = 70;
		sum1(eng, kor);
		int avg = sum2(eng, kor) / 2;
		test3();
		// test4(); // error

		Sample2 sm2 = new Sample2();
		System.out.println(sm2.eng);
		System.out.println(sm2.kor);

		sm2.test4();
	}

}
