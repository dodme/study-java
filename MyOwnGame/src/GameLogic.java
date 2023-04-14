
public class GameLogic 
{
	public static void Physics(MobileObject target)
	{
		switch(GameStatus.gravityDirection)
		{
		case down:
			target.spdY += 0.98f;
			break;
		case up:
			target.spdY -= 0.98f;
			break;
		case left:
			target.spdX -= 0.98f;
			break;
		case right:
			target.spdX += 0.98f;
			break;
		default:
		};
		
		int currentGridX = (int)(target.posX / GameStatus.gridSize);
		int currentGridY = (int)(target.posY / GameStatus.gridSize);
		
		float horizontalLine = 0;
		float verticalLine = 0;
		
		if(target.spdY < 0)
		{
			horizontalLine = (currentGridY * GameStatus.gridSize) + target.radius;
		}
		else
		{
			horizontalLine = ( (currentGridY + 1) * GameStatus.gridSize) - target.radius;
		};
		
		if(target.spdX < 0)
		{
			verticalLine = (currentGridX * GameStatus.gridSize) + target.radius;
		}
		else
		{
			verticalLine = ( (currentGridX + 1) * GameStatus.gridSize) - target.radius;
		};
		
		target.posX += target.spdX;
		target.posY += target.spdY;
		
		if(target.spdX > 0 && target.posX > verticalLine)
		{
			//								 공의 X + 1한 위치를 확인(오른쪽 블럭을 확인)
			CheckCollision(target, Direction.left, currentGridX + 1, currentGridY);
		}
		else if(target.spdX < 0 && target.posX < verticalLine)
		{
			CheckCollision(target, Direction.right, currentGridX - 1, currentGridY);
		};
		
		if(target.spdY > 0 && target.posY > horizontalLine)
		{
			CheckCollision(target, Direction.up, currentGridX - 1, currentGridY + 1);
			CheckCollision(target, Direction.up, currentGridX + 0, currentGridY + 1);
			CheckCollision(target, Direction.up, currentGridX + 1, currentGridY + 1);
		}
		else if(target.spdY < 0 && target.posY < horizontalLine)
		{
			CheckCollision(target, Direction.down, currentGridX - 1, currentGridY - 1);
			CheckCollision(target, Direction.down, currentGridX + 0, currentGridY - 1);
			CheckCollision(target, Direction.down, currentGridX + 1, currentGridY - 1);
		};
		
		CheckCollision(target, CheckDirection(GameStatus.ball), currentGridX, currentGridY);
	}
	
	public static Direction CheckDirection(MobileObject target)
	{
		//공과 블록 상대적인 위치를 표시하기 위해서 이걸 만들었어요.
		float altPosX = target.posX % GameStatus.gridSize;
		float altPosY = target.posY % GameStatus.gridSize;
		
		int diffX = (int)Math.abs(altPosX - (GameStatus.gridSize / 2));
		int diffY = (int)Math.abs(altPosY - (GameStatus.gridSize / 2));
		
		if(diffY >= diffX)
		{
			if(altPosY > GameStatus.gridSize / 2)
			{
				return Direction.down;
			}
			else
			{
				return Direction.up;
			}
		}
		else
		{
			if(altPosX > GameStatus.gridSize / 2)
			{
				return Direction.right;
			}
			else
			{
				return Direction.left;
			}
		}
	}
	
	//블럭에 닿잖아요! 그러면 다양한 행동을 보여줄 건데 그거를 여기다 쓸겁니다.
	public static void CheckCollision(MobileObject target, Direction from, int blockX, int blockY)
	{
		BT type = CheckBlockType(blockX, blockY);
		Rect blockRect = CheckBlockRect(blockX, blockY, type);
		
		if(blockRect == null ||
			target.posX + target.radius <= blockRect.startX ||
			blockRect.endX <= target.posX - target.radius ||
			target.posY + target.radius <= blockRect.startY ||
			blockRect.endY <= target.posY - target.radius)
		{
			return;
		};
		
		if(blockRect.startX >= target.posX && blockRect.startY >= target.posY)
		{
			if(!CheckCircleToPoint(target.posX, target.posY, target.radius, blockRect.startX, blockRect.startY))
			{
				return;
			};
		}
		else if(blockRect.endX <= target.posX && blockRect.startY >= target.posY)
		{
			if(!CheckCircleToPoint(target.posX, target.posY, target.radius, blockRect.endX, blockRect.startY))
			{
				return;
			};
		}
		else if(blockRect.startX >= target.posX && blockRect.endY <= target.posY)
		{
			if(!CheckCircleToPoint(target.posX, target.posY, target.radius, blockRect.startX, blockRect.endY))
			{
				return;
			};
		}
		else if(blockRect.endX <= target.posX && blockRect.endY <= target.posY)
		{
			if(!CheckCircleToPoint(target.posX, target.posY, target.radius, blockRect.endX, blockRect.endY))
			{
				return;
			};
		};
		
		switch(type)
		{
		case Wall:
			WallBounce(target, blockRect, from, blockX, blockY);
			break;
		case Bonc:
			WallBounce(target, blockRect, from, blockX, blockY);
			if(from != GameStatus.gravityDirection)
			{
				if(GameStatus.gravityDirection == Direction.down)
				{
					target.spdY -= 4.0f;
				};
			};
			break;
		case OBnc:
			WallBounce(target, blockRect, from, blockX, blockY);
			if(from != GameStatus.gravityDirection)
			{
				if(GameStatus.gravityDirection == Direction.down)
				{
					target.spdY -= 7.0f;
					GameStatus.currentMap[blockY][blockX] = BT.None;
				};
			};
			break;
		case Brek:
			WallBounce(target, blockRect, from, blockX, blockY);
			if(from != GameStatus.gravityDirection)
			{
				GameStatus.currentMap[blockY][blockX] = BT.None;
			};
			break;
		case Bln1:
			if(GameStatus.passedFrame % GameStatus.totalFrame < GameStatus.rapid)
			{
				WallBounce(target, blockRect, from, blockX, blockY);
			};
			break;
		case Bln2:
			if(GameStatus.passedFrame % GameStatus.totalFrame >= GameStatus.rapid && GameStatus.passedFrame % GameStatus.totalFrame < GameStatus.rapid * 2)
			{
				WallBounce(target, blockRect, from, blockX, blockY);
			};
			break;
		case Bln3:
			if(GameStatus.passedFrame % GameStatus.totalFrame >= GameStatus.rapid * 2)
			{
				WallBounce(target, blockRect, from, blockX, blockY);
			};
			break;
		case Dash:
			GameStatus.currentMap[blockY][blockX] = BT.None;
			GameStatus.isDash = true;
			break;
		case Grav:
			GameStatus.currentMap[blockY][blockX] = BT.None;
			GameStatus.isGravity = true;
			break;
		case Star:
			GameStatus.currentMap[blockY][blockX] = BT.None;
			--GameStatus.starNumber;
			break;
		}
	}
	
	public static void WallBounce(MobileObject target, Rect blockRect, Direction from, int blockX, int blockY)
	{
		if(Math.abs(target.spdX) > GameStatus.maxSpd + GameStatus.velSpd)
		{
			target.spdX /= 2.0f;
		};
		
		switch(from)
		{
		case up:
			if(CheckBlockType(blockX,blockY - 1) != BT.Wall)
			{
				target.posY = blockRect.startY - target.radius;
				if(GameStatus.gravityDirection == Direction.down)
				{
					target.spdY = -12.0f;
				}
				else
				{
					target.spdY = 0.0f;
				};
			};
			break;
		case down:
			if(CheckBlockType(blockX,blockY + 1) != BT.Wall)
			{
				target.posY = blockRect.endY + target.radius;
				if(GameStatus.gravityDirection == Direction.up)
				{
					target.spdY = 12.0f;
				}
				else
				{
					target.spdY = 0.0f;
				};
			};
			break;
		case left:
			target.posX = blockRect.startX - target.radius;
			target.spdX = 0.0f;
			break;
		case right:
			target.posX = blockRect.endX + target.radius;
			target.spdX = 0.0f;
			break;
		};
	}
	
	public static boolean CheckCircleToPoint(float circleX, float circleY, float circleRadius, float pointX, float pointY)
	{
		float verticalLength = pointY - circleY;
		float horizontalLength = pointX - circleX;
		double calculatedLength = Math.pow(verticalLength, 2) + Math.pow(horizontalLength, 2);
		calculatedLength = Math.sqrt(calculatedLength);
		
		return calculatedLength < circleRadius;
	}
	
	public static BT CheckBlockType(int blockX, int blockY)
	{
		if(blockY >= GameStatus.currentMap.length)
		{
			return BT.None;
		};
		
		if(blockX < 0 || blockY < 0 || blockX >= GameStatus.currentMap[blockY].length)
		{
			return BT.Wall;
		}
		else
		{
			return GameStatus.currentMap[blockY][blockX];
		}
	}
	
	public static Rect CheckBlockRect(int blockX, int blockY, BT type)
	{
		if(type == BT.None)
		{
			return null;
		};
		Rect result = new Rect();
		//시작 위치를 구하기 위해서 (현재 칸 * 칸 크기)를 곱합니다.
		result.startX = blockX * GameStatus.gridSize;
		result.startY = blockY * GameStatus.gridSize;
		
		result.endX = result.startX + GameStatus.gridSize;
		result.endY = result.startY + GameStatus.gridSize;
		
		switch(type)
		{
		case Star:
			result.startX += 5;
			result.startY += 5;
			result.endX -= 5;
			result.endY -= 5;
			break;
		default:
			break;
		}
		
		return result;
	}
}
