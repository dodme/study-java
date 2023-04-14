package 풀이;

class AirConditioner
{
	
	public enum Power
	{
		On,
		Off
	}
	
	private int _temp;
	// private boolean isPower;
	private Power _power;
	
	public void SetPower(Power power)
	{
		_power = power;
		PrintPower();
	}
	
	//Public void PowerOnOff() { _power = !_power; }
	
	public void PrintPower()
	{
		/*
		 * if(_power == Power.On) { System.out.println("전원을 켭니다!"); }
		 */
		
		System.out.println((_power == Power.On) ? "전원을 켭니다." : "전원을 끕니다.");
	}
	
	public void UpTemp()
	{
		System.out.println("온도를 올립니다.");
		_temp++;
		PrintNowTemp();
	}
	
	public void DownTemp()
	{
		System.out.println("온도를 내립니다.");
		_temp--;
		PrintNowTemp();
	}
	
	public void PrintNowTemp()
	{
		System.out.println("현재온도는" + _temp + "입니다.");
	}
	
	public void SetTemp(int temp)
	{
		_temp = temp;
	}
	
}

public class 에어컨 {

	public static void main(String[] args) {
		
		AirConditioner air = new AirConditioner();
		
		air.SetTemp(18);
		
		air.SetPower(AirConditioner.Power.On);
		air.PrintNowTemp();
		air.DownTemp();
		air.UpTemp();
		air.SetPower(AirConditioner.Power.Off);
		
	}

}
