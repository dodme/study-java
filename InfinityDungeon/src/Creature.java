class Human extends Creature
{
	public Human()
	{
		super("용사",100,5,15);
		this.skillMaxCool = 1;
	}
	
	public int Skill(Creature target)
	{
		DoAttack(target);
		DoAttack(target);
		this.skillCooldown = this.skillMaxCool;
		return 0;
	}
	
	public void AI(Creature target)
	{
		
	}
}
	

public abstract class Creature 
{
	private String name;
	private int currentHealth = 100;
	private int maxHealth = 100;
	private int minDamage;
	private int maxDamage;
	protected int skillCooldown = 0;
	protected int skillMaxCool = 2;
	private boolean isAlive = true;
	
	protected Creature(String wantName, int wantMaxHealth, int wantMinDmg, int wantMaxDmg)
	{
		name = wantName;
		maxHealth = wantMaxHealth;
		currentHealth = maxHealth;
		minDamage = wantMinDmg;
		maxDamage = wantMaxDmg;
	}
	
	public String getName()
	{
		return name;
	}
	public int getCurHealth()
	{
		return currentHealth;
	}
	public int getMaxHealth()
	{
		return maxHealth;
	}
	public boolean getAlive()
	{
		return isAlive;
	}
	
	public int DoAttack(Creature target)
	{
		int damage = Random(minDamage, maxDamage);
		
		System.out.println(name + "의 공격! " + damage + "의 피해를 입혔다!");
		target.TakeDamage(damage);
		
		return damage;
	}
	
	protected int TakeDamage(int amount)
	{
		int totalDamage = amount;
		if(currentHealth <= amount)
		{
			totalDamage = currentHealth;
			currentHealth = 0;
			isAlive = false;
		}
		else if(currentHealth - amount > maxHealth)
		{
			totalDamage = maxHealth - currentHealth;
			currentHealth = maxHealth;
		}
		else
		{
			currentHealth -= amount;
		};
		
		return totalDamage;
	}
	
	public abstract int Skill(Creature target);
	
	public abstract void AI(Creature target);
	
	public void Death(Creature target)
	{
		
	}

	public static int Random(int min, int max)
	{
		return (int)( (Math.random() * (max - min) ) + min);
	}
}
