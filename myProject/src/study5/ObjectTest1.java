package study5;

public class ObjectTest1 {

	int a = 10; // 인스턴스(객체)변수, 멤버변수
	int b = 20;
	// System.out.println(a); // error

	public static void main(String[] args) {
		int c = 10; // 지역변수
		System.out.println(c);
		// System.out.println(a); // error

		// ObjectTest1의 인스턴스(객체)화
		// 참조클래스 참조변수 = new(연산자) 생성자;
		ObjectTest1 t1 = new ObjectTest1();
		System.out.println(t1.a);
		System.out.println(t1.b);
	}

}
