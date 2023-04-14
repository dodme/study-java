public class monster {
	//몬스터 생명력
	private int life = 100;
	//몬스터 마릿수
	public static int currentNumber = 0;
	
	monster(int wantLife)
	{
		life = wantLife;
		++currentNumber;
	}
	//인수를 입력하지 않았을때 몬스터 기본생성
	monster()
	{
		life = 100;
		++currentNumber;
	}
	
	//몬스터에 해당된 메모리 해제
	protected void finalize() throws Throwable
	{
		--currentNumber;
	}
	
	public void Hit(int amount)
	{
		life -= amount;
	}
	
	public int ShowLife()
	{
		return life;
	}
}