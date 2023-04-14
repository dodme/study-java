class MobileObject
{
	float posX;
	float posY;
	float spdX;
	float spdY;
	int radius;
}

class Rect
{
	float startX;
	float startY;
	float endX;
	float endY;
}

enum Direction
{
	up,
	down,
	left,
	right
}

enum BT
{
	None,
	Wall,
	Star,
	Spon,
	Bonc,
	OBnc,
	Brek,
	Bln1,
	Bln2,
	Bln3,
	Dash,
	Lsft,
	Rsft,
	Olsf,
	Orsf,
	Isft,
	Grav
}

public class GameStatus {
	public static BT[][] initialMap =
	{
			{BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None},
			{BT.Spon,BT.Wall,BT.Bln1,BT.Bln2,BT.Bln3,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None},
			{BT.Star,BT.None,BT.Dash,BT.None,BT.None,BT.None,BT.None,BT.Star,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None},
			{BT.Wall,BT.Wall,BT.Wall,BT.Brek,BT.None,BT.None,BT.Wall,BT.Wall,BT.Wall,BT.Wall,BT.Wall,BT.Wall,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None},
			{BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.Grav,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None},
			{BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None},
			{BT.None,BT.None,BT.None,BT.Bonc,BT.OBnc,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None},
			{BT.None,BT.Lsft,BT.Wall,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None},
			{BT.None,BT.None,BT.None,BT.Isft,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None},
			{BT.Rsft,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.Grav,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None},
			{BT.None,BT.None,BT.Olsf,BT.None,BT.None,BT.Wall,BT.Wall,BT.Wall,BT.Wall,BT.Wall,BT.Wall,BT.Wall,BT.Wall,BT.Wall,BT.Wall,BT.Wall,BT.Wall,BT.Wall,BT.None,BT.None},
			{BT.Orsf,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None},
			{BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None},
			{BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None,BT.None}
	};
	
	public static BT[][] currentMap;
	
	public static MobileObject ball = new MobileObject();
	
	public static Direction gravityDirection = Direction.down;
	
	public static boolean isGravity = false;
	public static boolean isDash = false;
	
	public static int passedFrame = 0;
	public static int totalFrame = 60;
	public static int rapid = 20;
	
	public static int gridSize = 32;
	public static int ballRadius = 8;
	
	public static float maxSpd = 5.0f;
	public static float velSpd = 1.0f;
	
	public static int starNumber = 0;
}
