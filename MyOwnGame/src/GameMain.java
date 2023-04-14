
import java.time.*;
import java.util.Timer;
import java.util.TimerTask;

public class GameMain 
{
	static WindowMain myWindow = new WindowMain();
	static KeyInput checkKey = new KeyInput();
	public static void main(String[] args) 
	{
		myWindow.addKeyListener(checkKey);
		
		Update currentUpdate = new Update();
		Timer jobScheduler = new Timer();
		jobScheduler.scheduleAtFixedRate(currentUpdate, 0, 33);
	}
}

class Update extends TimerTask
{
	int lastSecond = 0;
	int runnedTime = 0;
	
	public void run()
	{
		int currentSecond = LocalTime.now().getSecond();
		
		//지금 보고 있는 화면이 입력을 모두 처리
		GameMain.myWindow.currentScreen.InputCheck();
		//입력을 초기화
		GameMain.checkKey.keyInitialize();
		
		//이 애한테 포커스를 준다
		GameMain.myWindow.requestFocus();
		
		++runnedTime;
		if(lastSecond != currentSecond)
		{
			GameMain.myWindow.setTitle("바운스 볼 FPS : " + runnedTime);
			runnedTime = 0;
			lastSecond = currentSecond;
		};
	}
}