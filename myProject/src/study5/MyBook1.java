package study5;

public class MyBook1 {

	public static void main(String[] args) {
		System.out.println("== 책 정보 ==");
		// 참조클래스 참조변수 = new(연산자) 생성자();
		BookInfo info = new BookInfo();
		System.out.println("책 제목 : " + info.title);
		System.out.println("책 가격 : " + info.price);
	}

}
