package study5;

// public 붙이면 오류;; public 키워드는 메인클래스에게만 적용함
class StudentInfo {
	int eng = 0; // 인스턴스(객체)변수 ,멤버변수
	int kor = 0;
	String name = "";
}

public class MyBook2 {

	public static void main(String[] args) {

		// 인스턴스(객체)화 == 메모리에 올림 == 사용가능상태 == 독립적인 공간 확보
		StudentInfo s1 = new StudentInfo();
		StudentInfo s2 = new StudentInfo();

		s1.name = "홍길동";
		s2.name = "이순신";

		System.out.println(s1.name);
		System.out.println(s2.name);

		s1.eng = 88;
		s1.kor = 100;
		s2.eng = 78;
		s2.kor = 98;

		System.out.println(s1.eng);
		System.out.println(s1.kor);
		System.out.println(s2.eng);
		System.out.println(s2.kor);
	}

}
