// Created by Cody Beaty
// Creates the first walls to be placed around the castles
// at the start of the game
public class initWall 
{
	GameLoop gl = new GameLoop();
	
	// Recieves the Castle location and its color
	public void wallCas(int x, int y, int color)
	{
		// get the start coord for the first wall
		int startCoordX = (x - 64);
		int startCoordY = (y - 96);
		int newCoordX = 0;
		int newCoordY =0;
		
		int blockSize = 32;
		
		// Based on the color, place the walls in their locations
		// Left --> Right
		for(int i = 0; i < 7; i++)
		{
			switch(color)
			{
				case 1: GameLoop.Wal_B.add(new Wall_B((startCoordX + (blockSize * i)), startCoordY, 0, 0));
							break;
				case 2: GameLoop.Wal_R.add(new Wall_R((startCoordX + (blockSize * i)), startCoordY, 0, 0));
							break;
				case 3: GameLoop.Wal_O.add(new Wall_O((startCoordX + (blockSize * i)), startCoordY, 0, 0));
							break;
			}
			
			// Just as the loop ends set the new Coords
			if(i == 6)
			{
				newCoordX = startCoordX + (blockSize * i);
			}
		}
		
		// Based on the color, place the walls in their locations
		// Up --> Down
		for(int i = 0; i < 8; i++)
		{
			switch(color)
			{
				case 1: GameLoop.Wal_B.add(new Wall_B(newCoordX, (startCoordY + (blockSize * i)), 0, 0));
							break;
				case 2: GameLoop.Wal_R.add(new Wall_R(newCoordX, (startCoordY + (blockSize * i)), 0, 0));
							break;
				case 3: GameLoop.Wal_O.add(new Wall_O(newCoordX, (startCoordY + (blockSize * i)), 0, 0));
							break;
			}
			
			// Just as the loop ends set the new Coords
			if(i == 7)
			{
				newCoordY = startCoordY + (blockSize * i);
			}
		}
		
		// Based on the color, place the walls in their locations
		// Left --> Right
		for(int i = 0; i < 8; i++)
		{
			switch(color)
			{
				case 1: GameLoop.Wal_B.add(new Wall_B((newCoordX - (blockSize * i)), newCoordY, 0, 0));
							break;
				case 2: GameLoop.Wal_R.add(new Wall_R((newCoordX - (blockSize * i)), newCoordY, 0, 0));
							break;
				case 3: GameLoop.Wal_O.add(new Wall_O((newCoordX - (blockSize * i)), newCoordY, 0, 0));
							break;
			}
			
			// Just as the loop ends set the new Coords
			if(i == 7)
			{
				newCoordX = newCoordX - (blockSize * i);
			}
		}
		
		// Based on the color, place the walls in their locations
		// Down --> Up
		for(int i = 0; i < 8; i++)
		{
			switch(color)
			{
				case 1: GameLoop.Wal_B.add(new Wall_B(newCoordX, (newCoordY - (blockSize * i)), 0, 0));
							break;
				case 2: GameLoop.Wal_R.add(new Wall_R(newCoordX, (newCoordY - (blockSize * i)), 0, 0));
							break;
				case 3: GameLoop.Wal_O.add(new Wall_O(newCoordX, (newCoordY - (blockSize * i)), 0, 0));
							break;
			}
			
			// Just as the loop ends set the new Coords
			if(i == 7)
			{
				newCoordX = newCoordX - (blockSize * i);
			}
		}
	}
}
