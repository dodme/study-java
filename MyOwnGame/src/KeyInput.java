import java.awt.event.*;

enum KeyType
{
	up,
	down,
	left,
	right,
	jump
}

public class KeyInput implements KeyListener 
{
	static public int keyCurrent[] = {38, 40, 37, 39, 32};
	//눌려있는지
	static private boolean keyInput[] = {false, false, false, false, false};
	//손 뗐을 때
	static private boolean keyUp[] = {false, false, false, false, false};
	//손 눌렀을 때
	static private boolean keyDown[] = {false, false, false, false, false};
	//마지막으로 누른 키
	static private int keyLast = 0;
	//지금 바꾸려고 시도한 키
	static private int keyChange = -4;
	
	public void SetKeyChange(KeyType wantType)
	{
		keyChange = KeyType2Int(wantType);
	}
	
	public void keyInitialize()
	{
		for(int i = 0; i < keyUp.length; i++)
		{
			keyUp[i] = false;
		};
		for(int i = 0; i < keyDown.length; i++)
		{
			keyDown[i] = false;
		};
		keyLast = 0;
	}
	
	//지금 눌렀을 때 발동
	public void keyPressed(KeyEvent e)
	{		
		//키가 있었는지 확인
		boolean isFindKey = false;
		for(int i = 0; i < keyCurrent.length; i++)
		{
			if(e.getKeyCode() == keyCurrent[i])
			{
				isFindKey = true;
				
				if(keyInput[i])
				{
					return;
				}
				else
				{
					keyInput[i] = true;
					keyDown[i] = true;
					return;
				}
			};
		};
		
		if(!isFindKey)
		{
			if(keyChange != -4)
			{
				keyCurrent[keyChange] = e.getKeyCode();
				keyChange = -4;
			};
			keyLast = e.getKeyCode();
		};
	}
	
	public void keyReleased(KeyEvent e)
	{
		for(int i = 0; i < keyCurrent.length; i++)
		{
			if(e.getKeyCode() == keyCurrent[i])
			{
				if(!keyInput[i])
				{
					return;
				}
				else
				{
					keyInput[i] = false;
					keyUp[i] = true;
					return;
				}
			};
		};
	}
	
	public void keyTyped(KeyEvent e){}
	
	public boolean GetKey(KeyType wantType)
	{
		try
		{
			return keyInput[KeyType2Int(wantType)];
		}
		catch (Exception e)
		{
			return false;
		}
	}
	
	public boolean GetKeyDown(KeyType wantType)
	{
		try
		{
			return keyDown[KeyType2Int(wantType)];
		}
		catch (Exception e)
		{
			return false;
		}
	}
	
	public boolean GetKeyUp(KeyType wantType)
	{
		try
		{
			return keyUp[KeyType2Int(wantType)];
		}
		catch (Exception e)
		{
			return false;
		}
	}
	
	public int KeyType2Int(KeyType wantType)
	{
		switch(wantType)
		{
		case up:
			return 0;
		case down:
			return 1;
		case left:
			return 2;
		case right:
			return 3;
		case jump:
			return 4;
		default:
			return -4;
		}
	}
	
	public static String KeyCode2String(int wantKeycode)
	{
		if(wantKeycode >= 65 && wantKeycode <= 90)
		{
			return "" + (char)wantKeycode;
		};
		switch(wantKeycode)
		{
		case 38:
			return "upArrow";
		case 40:
			return "downArrow";
		case 37:
			return "leftArrow";
		case 39:
			return "rightArrow";
		case 32:
			return "space bar";
		default:
			return Integer.toString(wantKeycode);
		}
	}
	
}
