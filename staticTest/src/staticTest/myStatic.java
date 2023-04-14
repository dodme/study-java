package staticTest;

public class myStatic {

	public static void main(String[] args) {

		
	}

}

class 몬스터
{
	int 생명력;
	static int 죽은횟수;
	
	public 몬스터(int 원하는생명력)
	{
		생명력 = 원하는생명력;
	}
	
	public static int 둘의생명력합(몬스터 첫번째, 몬스터 두번째)
	{
		return 첫번째.생명력 + 두번째.생명력;
	}
}