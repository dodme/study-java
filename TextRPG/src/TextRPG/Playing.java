package TextRPG;

import TextRPG.Character.Job;
import TextRPG.Monster.MonJob;

public class Playing {

	public static void main(String[] args) throws InterruptedException {

		Character Player1 = new Character();
		Player1.SetCharacterInfo("숙제 너무 어렵다", Job.Archor);
		Player1.PrintCharacterInfo();

		Monster Monster1 = new Monster();
		Monster1.SetMonsterInfo(MonJob.Dragon);
		Monster1.PrintMonsterInfo();

		int p1Hp = Player1.GetHp();
		int m1Hp = Monster1.GetHp();

		Thread.sleep(1000);
		System.out.println("전투를 시작합니다.");
		Thread.sleep(1000);


		while(p1Hp > 0 && m1Hp > 0)
		{
			Thread.sleep(1000);
			if (p1Hp > 0)
			{
				System.out.println("플레이어의 공격!");
				if((Player1.GetAtk() - Monster1.GetDef()) > 0)
				{
					System.out.println((Player1.GetAtk() - Monster1.GetDef()) + "의 데미지를 입혔습니다.");
					m1Hp -= (Player1.GetAtk() - Monster1.GetDef());
				}
				else
				{
					System.out.println("0의 데미지를 입혔습니다.");
				}
			}
			Thread.sleep(1000);
			if(m1Hp > 0)
			{
				System.out.println("몬스터의 공격!");
				if((Monster1.GetAtk() - Player1.GetDef()) > 0)
				{
					System.out.println((Monster1.GetAtk() - Player1.GetDef()) + "의 데미지를 입었습니다.");
					p1Hp -= (Monster1.GetAtk() - Player1.GetDef());
				}
				else
				{
					System.out.println("0의 데미지를 입었습니다.");
				}
			}
			Thread.sleep(1000);
			
			
			System.out.println("플레이어 현재 HP : " + p1Hp);
			System.out.println("몬스터 현재 HP : " + m1Hp);
			
			
			if(p1Hp <= 0)
				System.out.println("플레이어가 패배했습니다.");
			else if(m1Hp <= 0) 
				System.out.println("플레이어가 승리했습니다.");
			
		}

		System.out.println("전투가 종료되었습니다.");

	}

}
