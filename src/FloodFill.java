/**
 * 
 */

/**
 * @author Cody
 *
 */
public class FloodFill 
{
	// Holds blocks in the x and y (grid = blocks)
	private static int blockX;
	private static int blockY;
	
	// blockSize = pixel width of blocks
	public static int blockSize = 32;
	// screen width
	public static int roomWidth = 1280;
	// screen height
	public static int roomHeight = 869 + 96;
	
	// field for flooding
	private static int fieldWidth = roomWidth/blockSize;
	private static int fieldHeight = roomHeight/blockSize;
	
	// Holds the state of blocks
	// True = Flood-able
	// False = Wall
	private static boolean check[][] = new boolean[fieldWidth][fieldHeight];
	
	// GameLoop Stuff (Castles & Walls)
	GameLoop gl = new GameLoop();
	// Debug Messages
	// Can be turned on/off in Debug.java
	Debug db = new Debug();
	
	// Main method of FloodFill
	// Gets called from GameLoop
	public void floodFill()
	{
		map();
		blueFlood();
		orangeFlood();
		redFlood();
	}
	
	// Generates the true/false map
	private void map()
	{
		mapOpen();
		mapClose();
	}
	
	// sets map blocks to true
	private void mapOpen()
	{
		for(int i = 0; i < fieldWidth; i++)
		{
			for(int j = 0; j < fieldHeight; j++)
			{
				check[i][j] = true;
			}
		}

		db.debugString("Map Opened");
	}
	
	// sets wall blocks to false
	private void mapClose()
	{
		// sets blue walls as closed
		for(int i = 0; i < GameLoop.Wal_B.size(); i++)
		{
			blockX = GameLoop.Wal_B.get(i).x / blockSize;
			blockY = GameLoop.Wal_B.get(i).y / blockSize;
			
			check[blockX][blockY] = false;
		}
		
		// sets orange walls as closed
		for(int i = 0; i < GameLoop.Wal_O.size(); i++)
		{
			blockX = GameLoop.Wal_O.get(i).x / blockSize;
			blockY = GameLoop.Wal_O.get(i).y / blockSize;
			
			check[blockX][blockY] = false;
		}
		
		// sets red walls as closed
		for(int i = 0; i < GameLoop.Wal_R.size(); i++)
		{
			blockX = GameLoop.Wal_R.get(i).x / blockSize;
			blockY = GameLoop.Wal_R.get(i).y / blockSize;
			
			check[blockX][blockY] = false;
		}
		
		db.debugString("Map Closed");
	}
	
	// Blue Square Flooding
	private void blueFlood()
	{
		// Floods out from Blue Castle
		for(int i = 0; i < GameLoop.Cas_B.size(); i++)
		{
			flood(GameLoop.Cas_B.get(i).x, GameLoop.Cas_B.get(i).y, 1, 1, 0, 0);
		}
	}
	
	// Orange Square Flooding
	private void orangeFlood()
	{
		// Floods out from Orange Castle
		for(int i = 0; i < GameLoop.Cas_O.size(); i++)
		{
			flood(GameLoop.Cas_O.get(i).x, GameLoop.Cas_O.get(i).y, 2, 0, 1, 0);
		}
	}
	
	// Red Square Flooding
	private void redFlood()
	{
		// Floods out from Red Castle
		for(int i = 0; i < GameLoop.Cas_R.size(); i++)
		{
			flood(GameLoop.Cas_R.get(i).x, GameLoop.Cas_R.get(i).y, 3, 0, 0, 1);
		}
	}
	
	// FLOOD IT ALL !!! AHAHAHAHAHHAHAHA!!!!
	private void flood(int x, int y, int c, int b, int o, int r)
	{
		// gets block coords
		x /= blockSize;
		y /= blockSize;
		
		// makes sure block being drawn on is not out of bounds
		if(x < 0)
			return;
		if(y < 0)
			return;
		
		db.debugInt2(x, y);
		
		// checks to see if block has already been colored
		if(!check[x][y])
			return;
		
		// Clears drawing if its not contained in walls
		if(b > 60)
		{
			GameLoop.Blue.clear();
			return;
		}
		
		if(o > 60)
		{
			GameLoop.Orange.clear();
			return;
		}
		
		if(r > 60)
		{
			GameLoop.Red.clear();
			return;
		}
		
		// Draw depending on which castle is calling  the method
		// Recursion !!!
		switch(c)
		{
			case 1: GameLoop.Blue.add(new B(x * blockSize, y * blockSize, 0, 0));
						check[x][y] = false; 
						flood((x - 1) * blockSize, y * blockSize, c, ++b, o, r);
						flood((x + 1) * blockSize, y * blockSize, c, ++b, o, r);
						flood(x * blockSize, (y - 1) * blockSize, c, ++b, o, r);
						flood(x * blockSize, (y + 1) * blockSize, c, ++b, o, r);
						break;
			case 2: GameLoop.Orange.add(new O(x * blockSize, y * blockSize, 0, 0));
						check[x][y] = false; 
						flood((x - 1) * blockSize, y * blockSize, c, b, ++o, r);
						flood((x + 1) * blockSize, y * blockSize, c, b, ++o, r);
						flood(x * blockSize, (y - 1) * blockSize, c, b, ++o, r);
						flood(x * blockSize, (y + 1) * blockSize, c, b, ++o, r);
						break;
			case 3: GameLoop.Red.add(new R(x * blockSize, y * blockSize, 0, 0));
						check[x][y] = false; 
						flood((x - 1) * blockSize, y * blockSize, c, b, o, ++r);
						flood((x + 1) * blockSize, y * blockSize, c, b, o, ++r);
						flood(x * blockSize, (y - 1) * blockSize, c, b, o, ++r);
						flood(x * blockSize, (y + 1) * blockSize, c, b, o, ++r);
						break;
		}
	}
}