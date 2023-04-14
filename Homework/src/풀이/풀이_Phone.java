package 풀이;

class ApplePhone
{
	enum User 
	{ 철수, 영희 }

	private User Sender;  // 보내는 이
	private User Receiver;  // 받는 인
	
	public ApplePhone(User sender, User receiver)
	{
		Sender = sender;
		Receiver = receiver;
	}
	
	public void SendMessage(String msg)
	{
		System.out.println("From." + Sender);
		System.out.println("문자 내용 : " + msg);
		System.out.println("To." + Receiver);
	}
	
	public void GetMessage(String msg)
	{
		System.out.println("From." + Receiver);
		System.out.println("문자 내용 : " + msg);
		System.out.println("To." + Sender);
	}

}
public class 풀이_Phone {

	public static void main(String[] args) {
		ApplePhone cs = new ApplePhone(ApplePhone.User.철수, ApplePhone.User.영희);
		
		cs.SendMessage("잘지내..?");
		cs.GetMessage("나 남친 생겼어");
		cs.GetMessage("나 말고 좋은 여자 만나");

	}

}
