
// Created by Cody Beaty
// Checks and creates the area around a castle
// throught the game


public class FloodFill 
{
	public boolean floodOnce = false;
	public boolean floodBlue = true;
	public boolean floodRed = true;
	public boolean floodOrange = true;
	// Holds blocks in the x and y (grid = blocks)
	private static int blockX;
	private static int blockY;
	
	// blockSize = pixel width of blocks
	public static int blockSize = 32;
	// screen width
	public static int roomWidth = 1280;
	// screen height
	public static int roomHeight = 869 + GameLoop.underBanner;
	
	// field for flooding
	//private static int fieldWidth = roomWidth/blockSize;
	//private static int fieldHeight = roomHeight/blockSize;
	
	// Holds the state of blocks
	// True = Flood-able
	// False = Wall
	private static boolean check[][] = new boolean[roomWidth][roomHeight];
	
	// GameLoop Stuff (Castles & Walls)
	GameLoop gl = new GameLoop();
	// Debug Messages
	// Can be turned on/off in Debug.java
	Debug db = new Debug();
	
	// Main method of FloodFill
	// Gets called from GameLoop
	public void floodFill()
	{

		db.debugString("flood_1");

		map();
		
		// Due to recursion, we have to clear the list if it gets to big
		if(GameLoop.Blue.size() > 200)
		{
			GameLoop.Blue.clear();
		}
		if(GameLoop.Orange.size() > 200)
		{
			GameLoop.Orange.clear();
		}
		if(GameLoop.Red.size() > 200)
		{
			GameLoop.Red.clear();
		}
		
		// Floods for each color
		blueFlood();
		orangeFlood();
		redFlood();
		floodOnce = true;
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
		for(int i = 0; i < roomWidth; i++)
		{
			for(int j = 0; j < roomHeight; j++)
			{
				check[i][j] = true;
			}
		}

		db.debugString("Map Opened");
	}
	
	// sets wall blocks to false
	private void mapClose()
	{
		// sets banner locations to closed
		for(int i = 0; i < (roomWidth / blockSize) ; i++)
		{ 
			for(int j = 0; j < (GameLoop.underBanner / blockSize); j++)
			{
				check[i][j] = false;
			}
		}
				
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
		
		db.debugString("flood_2");
		
		// gets block coords
		x /= blockSize;
		y /= blockSize;
		
		// makes sure block being drawn on is not out of bounds
		if(x < 0)
			return;
		if(y < 0)
			return;

		if(x > (roomWidth / 32))
			return;
		if(y > (roomHeight / 32))
			return;
		
		// checks to see if block has already been colored
		if(!check[x][y])
			return;
		
		db.debugInt2(x, y);
		
		db.debugInt2(x, y);
			
		// Clears drawing if its not contained in walls
		if(b > 70)
		{			
			GameLoop.Blue.clear();
			GameLoop.Blue.clear();
			GameLoop.Blue.clear();
			floodBlue = false;
			return;
		}
		
		if(o > 70)
		{
			GameLoop.Orange.clear();
			GameLoop.Orange.clear();
			GameLoop.Orange.clear();
			floodOrange = false;
			return;
		}
		
		if(r > 70)
		{
			GameLoop.Red.clear();
			GameLoop.Red.clear();
			GameLoop.Red.clear();
			floodRed = false;
			return;
		}
		
		// checks to see if block has already been colored
		if(!check[x][y])
			return;
		
		// Draw depending on which castle is calling  the method
		// Recursion !!!
		
		switch(c)
		{	
			case 1: 
				if ( floodBlue == true) {
				GameLoop.Blue.add(new B(x * blockSize, y * blockSize, 0, 0));
						check[x][y] = false; 
							flood((x - 1) * blockSize, y * blockSize, c, ++b, o, r);
							flood((x + 1) * blockSize, y * blockSize, c, ++b, o, r);
							flood(x * blockSize, (y - 1) * blockSize, c, ++b, o, r);
							flood(x * blockSize, (y + 1) * blockSize, c, ++b, o, r);
				}
						break;
			case 2:
				if ( floodOrange == true) {
					GameLoop.Orange.add(new O(x * blockSize, y * blockSize, 0, 0));
							check[x][y] = false; 
							flood((x - 1) * blockSize, y * blockSize, c, b, ++o, r);
							flood((x + 1) * blockSize, y * blockSize, c, b, ++o, r);
							flood(x * blockSize, (y - 1) * blockSize, c, b, ++o, r);
							flood(x * blockSize, (y + 1) * blockSize, c, b, ++o, r);
				}
						break;
			case 3: 
				if ( floodRed == true) {
					GameLoop.Red.add(new R(x * blockSize, y * blockSize, 0, 0));
							check[x][y] = false; 
							flood((x - 1) * blockSize, y * blockSize, c, b, o, ++r);
							flood((x + 1) * blockSize, y * blockSize, c, b, o, ++r);
							flood(x * blockSize, (y - 1) * blockSize, c, b, o, ++r);
							flood(x * blockSize, (y + 1) * blockSize, c, b, o, ++r);
				}
						break;
		}
	}
}
