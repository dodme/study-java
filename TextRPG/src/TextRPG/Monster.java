package TextRPG;

class Monster
{
	enum MonJob
	{
		Goblin,
		Dragon
	}
	
	private MonJob _job;
	private int _hp;
	private int _atk;
	private int _def;
	
	public void SetMonsterInfo(MonJob job)
	{
		_job = job;
		
		if(job == MonJob.Goblin)
		{
			_hp = 150;
			_atk = 15;
			_def = 5;
		}
		else if(job == MonJob.Dragon)
		{
			_hp = 1000;
			_atk = 100;
			_def = 50;
		}
		
	}
	
	public void PrintMonsterInfo()
	{
		System.out.println("몬스터 이름 : " + _job);
		System.out.println("몬스터 체력 : " + _hp);
		System.out.println("몬스터 공격력 : " + _atk);
		System.out.println("몬스터 방어력 : " + _def);
	}
	
	public int GetHp() { return _hp;};
	public int GetAtk() { return _atk;};
	public int GetDef() { return _def;};


}
