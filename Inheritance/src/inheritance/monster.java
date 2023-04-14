package inheritance;

public class monster 
{
	private int hp = 100;
	
	public int GetHp()
	{
		return hp;
	}
	
	public void Hit(int damage)
	{
		hp -= damage;
		
		if(hp <= 0)
		{
			Die();
		}
	}
	
	private void Die()
	{
		
	}
	
}

class attacker extends monster
{
	
}