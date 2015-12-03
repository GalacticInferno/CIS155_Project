import java.util.Random;

// Created by Cody Beaty
// Randomly Selects Wall(s) to be deleted
// Adds a gameplay element and a way to clear items on the screen
public class cleaning 
{
	Random rdm = new Random();
	
	public void clean()
	{
		int size;
		int blue = 0;
		int red = 0;
		int orange = 0;
		
		// Clear Destroyed Walls
		GameLoop.Wal_D.clear();
		GameLoop.Wal_D.clear();
		GameLoop.Wal_D.clear();
		
		Random rdm = new Random();
		
		// Randomly selects a wall for deletion as long as list has elements
		// Blue
		if(!GameLoop.Wal_B.isEmpty())
		{
			size = GameLoop.Wal_B.size();
			blue = rdm.nextInt(size);
			GameLoop.Wal_B.remove(blue);
		}
		// Red
		if(!GameLoop.Wal_R.isEmpty())
		{
			size = GameLoop.Wal_R.size();
			red = rdm.nextInt(GameLoop.Wal_R.size());
			GameLoop.Wal_R.remove(red);
		}
		// Orange
		if(!GameLoop.Wal_O.isEmpty())
		{
			size = GameLoop.Wal_O.size();
			orange = rdm.nextInt(GameLoop.Wal_O.size());
			GameLoop.Wal_O.remove(orange);
		}
	}
}
