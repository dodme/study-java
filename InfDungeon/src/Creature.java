class Human extends Creature
{
	boolean doubleAttack = false;
	
	public Human()
	{
		super("용사", 100, 5, 15);  // super 생성자를 불러온다
		this.skillMaxCool = 2; // this: 상속을 받다보니까, 다른 것이랑 헷갈릴 수 있으므로, this로 구분해줌
	}
	
	/*
	 * public int Skill(Creature target) { doubleAttack = true;
	 * System.out.println("용사의 더블 어택!"); super.DoAttack(target);
	 * super.DoAttack(target); this.skillCooldown = this.skillMaxCool; return 0; }
	 */

	public int Skill(Creature target)
    {
		int totalDamage = target.TakeDamage(this, this.maxDamage);
        System.out.println("데마시아!");
        System.out.println(name + "의 공격! " + totalDamage + "의 피해를 입혔다!");
        this.skillCooldown = this.skillMaxCool;
        
        return totalDamage;
    }
	
	public void AI(Creature target)
	{
		DoAttack(target);
	}
}

class Gambler extends Creature
{	
	enum CardType
	{
		None,
		Clover,
		Heart,
		Diamond,
		Spade,
	}
	
	CardType currentCard = CardType.None;
	int leaf = 0;
	
	public Gambler()
	{
		super("도박사", 100, 0, 20);  // super 생성자를 불러온다
	}

	public int DoAttack(Creature target)
	{
		int totalDamage = super.DoAttack(target);
		switch(currentCard)
		{
		case Clover:
			if(leaf < 2)
			{
				System.out.println("클로버 카드로 클로버 잎을 하나 모았다.");
				++leaf;
				System.out.println("현재 잎의 개수 : " + leaf);
			}
			else
			{
				System.out.println("클로버 잎을 세 개를 모두 모았다.");
				System.out.println("모든 잎을 사용한 공격!");
				while(leaf > 0)
				{
					game.Sleep(0.1f);
					totalDamage += super.DoAttack(target);
					--leaf;
				}
				game.Sleep(0.5f);
				System.out.println("잎이 모두 소모되었다.");
			}
			break;
			
		case Heart:
			System.out.println("하트 카드로 상대방의 생명력을 빼앗았다.");
			this.TakeHeal(totalDamage);
			break;
			
		case Diamond:
			System.out.println("다이아몬드 카드로 생대방의 스킬을 강요한다!");
			target.Skill(this);
			break;
			
		case Spade:
			System.out.println("스페이드 카드로 다시 공격!");
			totalDamage += super.DoAttack(target);
			break;
			
		default:
			currentCard = CardType.None;
			break;
		}
		
		currentCard = CardType.None;
		return totalDamage;
	}
	
	public CardType DrawCard()
	{
		int currentNumber = super.Random(0,  10);
		if(currentNumber < 4)
		{
			System.out.println("도박사는 클로버를 뽑았다.");
			return CardType.Clover;
		}
		else if(currentNumber < 7)
		{
			System.out.println("도박사는 하트를 뽑았다.");
			return CardType.Heart;
		}
		else if(currentNumber < 9)
		{
			System.out.println("도박사는 다이아몬드를 뽑았다.");
			return CardType.Diamond;
		}
		else
		{
			System.out.println("도박사는 스페이드를 뽑았다.");
			return CardType.Spade;
		}
	}
	
	public int Skill(Creature target)
    {
		int totalDamage = 0;
        
		if(currentCard == CardType.None)
		{
			currentCard = DrawCard();
		}
		else
		{
			if(currentCard == DrawCard())
			{
				switch(currentCard)
				{
				case Clover:
					currentCard = CardType.None;
					leaf += 4;
					System.out.println("클로버 페어로 잎 4개가 생성되었다.");
					System.out.println("모든 잎을 사용한 공격!");
					while(leaf > 0)
					{
						game.Sleep(0.1f);
						totalDamage += super.DoAttack(target);
						--leaf;
					}
					game.Sleep(0.5f);
					System.out.println("잎을 모두 소모하였다.");
					break;
					
				case Heart:
					currentCard = CardType.None;
					totalDamage += target.FixedDamage(this, target.maxHealth / 2);
					System.out.println("하트 페어로 상대의 생명력 절반을 가져온다!");
					this.TakeHeal(totalDamage);
					break;
					
				case Diamond:
					currentCard = CardType.None;
					System.out.println("다이아몬드 페어로 상대의 스킬을 본인에게 시전하게 한다");
					totalDamage = target.Skill(target);
					break;
					
				case Spade:
					currentCard = CardType.None;
					System.out.println("스페이드 페어로 상대를 즉사시킨다.");
					target.Death(this);
					break;
					
				default:
					currentCard = CardType.None;
					break;
				}
				
				System.out.println("스킬을 통해 카드를 모두 소모하였습니다.");
			}
			else
			{
				currentCard = CardType.None;
				System.out.println("페어에 실패했습니다! 효과 없는 카드를 던집니다.");
				totalDamage = super.DoAttack(target);
			}
		}
		
        return totalDamage;
    }
	
	public void AI(Creature target)
	{
		this.Skill(target);
	}
}

class Goblin extends Creature
{
	public Goblin()
	{
		super("고블린", 30, 5, 10);  // super 생성자를 불러온다
		this.skillMaxCool = 3; // this: 상속을 받다보니까, 다른 것이랑 헷갈릴 수 있으므로, this로 구분해줌
	}
	
	public int Skill(Creature target)
	{
		System.out.println("고블린이 너무 아파서 동료를 불러왔다!");
		this.name = "고블린떼";
		this.maxHealth = 80;
		this.TakeHeal(50);
		this.minDamage = 10;
		this.maxDamage = 30;
		this.skillCooldown = this.skillMaxCool;
		return 0;
	}
	
	public void AI(Creature target)
	{
		if(this.skillCooldown <= 0 && this.currentHealth < 5)
		{
			Skill(target);
		}
		else
		{
			DoAttack(target);
		};
	}
}

class Orc extends Creature
{
	int defendLeft = 0;
	
	public Orc()
	{
		super("오크", 60, 2, 20);  // super 부모 << 그래서 부모의 생성자
		this.skillMaxCool = 3; // this: 상속을 받다보니까, 다른 것이랑 헷갈릴 수 있으므로, this로 구분해줌
	}
	
	@Override
	public int TakeDamage(Creature from, int damage)
	{
		if(defendLeft > 0)
		{
			System.out.println("오크는 상대의 공격을 막아냈다!");
			from.TakeDamage(this, damage / 2);
			System.out.println((damage / 2) + "의 피해를 돌려주었다.");
			--defendLeft;
			return 0;
		}
		else
		{
			return super.TakeDamage(from, damage);
		}
	}
	
	public int Skill(Creature target)
	{
		System.out.println("오크는 버티기를 시작했다!");
		defendLeft = 2;
		this.skillCooldown = this.skillMaxCool;
		return 0;
	}
	
	public void AI(Creature target)
	{
		if(this.skillCooldown <= 0 && this.currentHealth < 20)
		{
			Skill(target);
		}
		else
		{
			DoAttack(target);
		};
	}
}

class Dragon extends Creature
{
int breathCharge = 0;

    public Dragon()
    {
        super("드래곤", 150, 20, 40);  // super 부모 << 그래서 부모의 생성자
        this.skillMaxCool = 4; // this: 상속을 받다보니까, 다른 것이랑 헷갈릴 수 있으므로, this로 구분해줌
    }

    @Override
    public int TakeDamage(Creature from, int damage)
    {
        if(breathCharge > 0)
        {
            //브레스 충전동안엔 받는데미지 2배
            System.out.println("드래곤이 정신을 집중하고있다.");
            return super.TakeDamage(from, damage * 2);
        }
        else
        {
            // 아무 행동도 하지 않을때는 받는데미지 절반
            return super.TakeDamage(from, damage / 2);
        }
    }

    public int Skill(Creature target)
    {
        System.out.println("드래곤은 브레스를 모으고있다...");
        breathCharge = 2;
        this.skillCooldown = this.skillMaxCool;
        return 0;
    }

    public void AI(Creature target)
    {
        // 브레스를 충전해서 공격할때 외에는 공격하지 않음
        if(this.skillCooldown <= 0)
        {
            Skill(target);
        }
        else if(breathCharge == 0)
        {
            DoAttack(target);
        }
        else if(breathCharge < 0)
        {
            System.out.println("드래곤은 아무 행동도 하지 않고있다.");
        };
        --breathCharge;
        --this.skillCooldown;
    };
}
class Vampire extends Creature
{
    int evasion = 2;
    boolean isEvasion = false;

    public Vampire()
    {
        super("뱀파이어", 50, 5, 30); 
        this.skillMaxCool = 4; 
    }

    @Override       // 부모에 있었던  TakeDamage를 실행시키지 않고, 나의 TakeDamage를 실행시켜주겠다는 의미
    public int TakeDamage(Creature from, int damage)  // 원래 얻어 맏는 함수였음
    {
        if(evasion > 0 && this.currentHealth < 40)   // 따라서 0데미지를 받는 다
        {
            System.out.println("뱀파이어는 박쥐로 변신해서 공격을 회피하였다.");
            --evasion;
            isEvasion = true;
            return 0;
        }
        else
        {
            return super.TakeDamage(from, damage);   //super는 부모를 부르는 것이므로, defendLeft가 없었다면 원래대로 맞는 것임
        }
    }

    @Override
    public int DoAttack(Creature target)
    {
        if(isEvasion)
        {
            System.out.println("뱀파이어는 회피하느라 공격을 할 수 없었다.");
            isEvasion = false;
            return 0;
        }
        else
        {
            return super.DoAttack(target);
        }
    }

    public int Skill(Creature target)
    {
        if(isEvasion)
        {
            System.out.println("뱀파이어는 회피하느라 공격을 할 수 없었다.");
            isEvasion = false;
            return 0;
        };

        int bloodSucking = this.DoAttack(target);
        System.out.println("피 맛있졍");
        this.TakeHeal(bloodSucking);
        System.out.println(bloodSucking + "가 회복되었습니다.");
        this.skillCooldown = this.skillMaxCool;

        return 0;
    }

    public void AI(Creature target)
    {
        if(isEvasion)
        {
            System.out.println("뱀파이어는 회피하느라 공격을 할 수 없었다.");
            isEvasion = false;
            /*
            evasion = 3;
            this.skillCooldown = this.skillMaxCool;
            */
        }
        else if(this.skillCooldown <= 0 && this.currentHealth < 20)
        {
            Skill(target);
        }
        else
        {
            DoAttack(target);
        }
    }
}

public abstract class Creature 
{
	protected String name;
	protected int currentHealth = 100;
	protected int maxHealth = 100;
	protected int minDamage;
	protected int maxDamage;
	protected int skillCooldown = 0;
	protected int skillMaxCool = 2;
	private boolean isAlive = true;  //살아있는지
	
	//protected는 상속 받은 애들만 사용할 수 있게 해줌. 즉, 자식들만 사용할 수 있는 것
	protected Creature(String wantName, int wantMaxHealth, int wantMinDmg, int wantMaxDmg)
	{
		name = wantName;
		maxHealth = wantMaxHealth;
		currentHealth = maxHealth;  //시작할 때는 최대 체력일 수 있도록 해줌
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
	public int DoAttack(Creature target)  //맞는 대상을 설정해줌(인자로 받는다)
	{
		int damage = Random(minDamage, maxDamage);
		damage = target.TakeDamage(this, damage);
		
		System.out.println(name + "의 공격! " + damage + "의 피해를 입혔다!");
		
		return damage;
	}
	
	public int TakeHeal(int heal)
	{
		int totalHeal = heal;
		if(currentHealth + heal <= 0)
		{
			totalHeal = currentHealth;
			currentHealth = 0;
			isAlive = false;
		}
		else if(currentHealth + heal > maxHealth)
		{
			totalHeal = maxHealth - currentHealth; //어차피 최대 체력까지만 피가 회복될 것이므로
			currentHealth = maxHealth;
		}
		else
		{
			currentHealth += heal;
		};
		
		return totalHeal;
	}
	
	protected int TakeDamage(Creature from, int damage)
	{
		int totalDamage = damage;
		if(currentHealth <= damage)
		{
			totalDamage = currentHealth;
			currentHealth = 0;
			isAlive = false;
		}
		else if(currentHealth - damage > maxHealth)  //체력 회복을 -데미지를 이용해서 함
		{
			//지금 체력(50) - 들어온 데미지(-60) > 최대 체력(100)
			//110 > 100
			totalDamage = maxHealth - currentHealth; //어차피 최대 체력까지만 피가 회복될 것이므로
			currentHealth = maxHealth;
		}
		else
		{
			currentHealth -= damage;
		};
		
		return totalDamage;
	}
	
	protected int FixedDamage(Creature from, int damage)
	{
		int totalDamage = damage;
		if(currentHealth <= damage)
		{
			totalDamage = currentHealth;
			currentHealth = 0;
			isAlive = false;
		}
		else if(currentHealth - damage > maxHealth)  //체력 회복을 -데미지를 이용해서 함
		{
			//지금 체력(50) - 들어온 데미지(-60) > 최대 체력(100)
			//110 > 100
			totalDamage = maxHealth - currentHealth; //어차피 최대 체력까지만 피가 회복될 것이므로
			currentHealth = maxHealth;
		}
		else
		{
			currentHealth -= damage;
		};
		
		return totalDamage;
	}
	
	public abstract int Skill(Creature target);
	
	public abstract void AI(Creature target);
	
	public void Death(Creature target)
	{
		isAlive = false;
	}
	
	public static int Random(int min, int max)
	{
		return (int)( (Math.random() * (max - min)) + min );  //(max - min): 범위를 정해주고, + min으로 최솟값으로 설정
	}
}
