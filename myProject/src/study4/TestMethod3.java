package study4;

import java.util.Calendar;

public class TestMethod3 {

	public static void main(String[] args) {
		System.out.println("회원이름 : " + memberName());
		System.out.println("회원나이 : " + memberAge());
		System.out.println("회원생일 : " + memberBirth());
		System.out.println("오늘날짜 : " + today());
	}

	public static String memberName() {
		return "홍길동";
	}

	public static int memberAge() {
		return 25;
	}

	public static String memberBirth() {
		return "1998-12-25";
	}

	public static String today() {
		// Calendar 클래스의 인스턴스화(객체화)
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		// 자바시스템에서는 Month 는 0부터 시작함
		int month = cal.get(Calendar.MONTH) + 1;
		int date = cal.get(Calendar.DATE);

		String mm = (month < 10) ? "0" + month : "" + month;
		String dd = (date < 10) ? "0" + date : "" + date;

		String today = year + "-" + mm + "-" + dd;

		return today;
	}

}
