// by Markus Tamm
public class PlaceWall {
	// checks for wall
	public static boolean placeWall_B = true;   
	public static boolean placeWall_R = true;   
	public static boolean placeWall_O = true;   
	// checks for cannon
	public static boolean placeWall_B_C = true;   
	public static boolean placeWall_R_C = true;   
	public static boolean placeWall_O_C = true;   
	// checks for castle
	public static boolean placeWall_B_Ca = true;   
	public static boolean placeWall_R_Ca = true;   
	public static boolean placeWall_O_Ca = true;   

	PlaceWall() 
	{
	}
	
// places wall if nothing is in the way	
public static void placewall_B() {
	for(int i = 0; i < GameLoop.Bil_B.size(); i++)
	{
		if (placeWall_B && placeWall_B_C && placeWall_B_Ca)
			GameLoop.Wal_B.add(new Wall_B(GameLoop.Bil_B.get(i).getX(), GameLoop.Bil_B.get(i).getY(), 0, 0));
	}
	if (placeWall_B && placeWall_B_C && placeWall_B_Ca) // if place is placed create new random Bil
		RmdBuild.rmd_wall_B();
}
	// chekcs for wall
	public static void checkForWall_B() {
		int test = 0;
		if (GameLoop.Wal_B.size() == 0)
			placeWall_B = true;
		for (int i = 0; i < GameLoop.Bil_B.size(); i++)
		{
			for (int j = 0; j < GameLoop.Wal_B.size(); j++)
			{
			if (test == 0) {
				
			
				if( GameLoop.Bil_B.get(i).getX() != GameLoop.Wal_B.get(j).getX() && GameLoop.Bil_B.get(i).getY() != GameLoop.Wal_B.get(j).getY() ) 
				{
					placeWall_B = true;
				}
				if( GameLoop.Bil_B.get(i).getX() == GameLoop.Wal_B.get(j).getX() && GameLoop.Bil_B.get(i).getY() == GameLoop.Wal_B.get(j).getY() ) 
				{
					placeWall_B = false;
					test = 1;
					//i = Bil_B.size();
				}
			}
			}
		}		
	}
	
	// check for cannons
	public static void checkForCannon_B() {
		int test = 0;
		if (GameLoop.Can_B.size() == 0)
			placeWall_B_C = true;
		for (int i = 0; i < GameLoop.Bil_B.size(); i++)
		{
			for (int j = 0; j < GameLoop.Can_B.size(); j++)
			{
			if (test == 0) {
				
			
				if( (GameLoop.Bil_B.get(i).getX() < GameLoop.Can_B.get(j).getX() || GameLoop.Bil_B.get(i).getX() > GameLoop.Can_B.get(j).getX() + 63) &&
						(GameLoop.Bil_B.get(i).getY() < GameLoop.Can_B.get(j).getY() || GameLoop.Bil_B.get(i).getY() > GameLoop.Can_B.get(j).getY() + 63	)) 
				{
					placeWall_B_C = true;
				}
				else if( (GameLoop.Bil_B.get(i).getX() >= GameLoop.Can_B.get(j).getX() && GameLoop.Bil_B.get(i).getX() <= GameLoop.Can_B.get(j).getX() +63)
						&& (GameLoop.Bil_B.get(i).getY() >= GameLoop.Can_B.get(j).getY() && GameLoop.Bil_B.get(i).getY() <= GameLoop.Can_B.get(j).getY() + 63 )) 
				{
					placeWall_B_C = false;
					test = 1;
					//i = Bil_B.size();
				}
			}
			}
		}		
	}
	
	// check for castle
	public static void checkForCastle_B() {
		int test = 0;
		if (GameLoop.Cas_B.size() == 0)
			placeWall_B_Ca = true;
		for (int i = 0; i < GameLoop.Bil_B.size(); i++)
		{
			for (int j = 0; j < GameLoop.Cas_B.size(); j++)
			{
			if (test == 0) {
				
			
				if( (GameLoop.Bil_B.get(i).getX() < GameLoop.Cas_B.get(j).getX() || GameLoop.Bil_B.get(i).getX() > GameLoop.Cas_B.get(j).getX() + 63) &&
						(GameLoop.Bil_B.get(i).getY() < GameLoop.Cas_B.get(j).getY() || GameLoop.Bil_B.get(i).getY() > GameLoop.Cas_B.get(j).getY() + 63	)) 
				{
					placeWall_B_Ca = true;
				}
				else if( (GameLoop.Bil_B.get(i).getX() >= GameLoop.Cas_B.get(j).getX() && GameLoop.Bil_B.get(i).getX() <= GameLoop.Cas_B.get(j).getX() +63)
						&& (GameLoop.Bil_B.get(i).getY() >= GameLoop.Cas_B.get(j).getY() && GameLoop.Bil_B.get(i).getY() <= GameLoop.Cas_B.get(j).getY() + 63 )) 
				{
					placeWall_B_Ca = false;
					test = 1;
					//i = Bil_B.size();
				}
			}
			}
		}		
	}
	
	
	
	
	
	// place red wall
	public static void placewall_R() {
		for(int i = 0; i < GameLoop.Bil_R.size(); i++)
		{
			System.out.println(placeWall_R);
			if (placeWall_R && placeWall_R_C && placeWall_R_Ca)
				GameLoop.Wal_R.add(new Wall_R(GameLoop.Bil_R.get(i).getX(), GameLoop.Bil_R.get(i).getY(), 0, 0));
		}
		if (placeWall_R && placeWall_R_C && placeWall_R_Ca)
			RmdBuild.rmd_wall_R();
	}
	//------------
	// check for red wall
	public static void checkForWall_R() {
		int test = 0;
		if (GameLoop.Wal_R.size() == 0)
			placeWall_R = true;
		for (int i = 0; i < GameLoop.Bil_R.size(); i++)
		{
			for (int j = 0; j < GameLoop.Wal_R.size(); j++)
			{
			if (test == 0) {
				
			
				if( GameLoop.Bil_R.get(i).getX() != GameLoop.Wal_R.get(j).getX() && GameLoop.Bil_R.get(i).getY() != GameLoop.Wal_R.get(j).getY() ) 
				{
					placeWall_R = true;
				}
				if( GameLoop.Bil_R.get(i).getX() == GameLoop.Wal_R.get(j).getX() && GameLoop.Bil_R.get(i).getY() == GameLoop.Wal_R.get(j).getY() ) 
				{
					placeWall_R = false;
					test = 1;
					//i = Bil_B.size();
				}
			}
			}
		}		
	}
	// check  red for cannons
		public static void checkForCannon_R() {
			int test = 0;
			if (GameLoop.Can_R.size() == 0)
				placeWall_R_C = true;
			for (int i = 0; i < GameLoop.Bil_R.size(); i++)
			{
				for (int j = 0; j < GameLoop.Can_R.size(); j++)
				{
				if (test == 0) {
					
				
					if( (GameLoop.Bil_R.get(i).getX() < GameLoop.Can_R.get(j).getX() || GameLoop.Bil_R.get(i).getX() > GameLoop.Can_R.get(j).getX() + 63) &&
							(GameLoop.Bil_R.get(i).getY() < GameLoop.Can_R.get(j).getY() || GameLoop.Bil_R.get(i).getY() > GameLoop.Can_R.get(j).getY() + 63	)) 
					{
						placeWall_R_C = true;
					}
					else if( (GameLoop.Bil_R.get(i).getX() >= GameLoop.Can_R.get(j).getX() && GameLoop.Bil_R.get(i).getX() <= GameLoop.Can_R.get(j).getX() +63)
							&& (GameLoop.Bil_R.get(i).getY() >= GameLoop.Can_R.get(j).getY() && GameLoop.Bil_R.get(i).getY() <= GameLoop.Can_R.get(j).getY() + 63 )) 
					{
						placeWall_R_C = false;
						test = 1;
					}
				}
				}
			}		
		}
		
		// check for castle
		public static void checkForCastle_R() {
			int test = 0;
			if (GameLoop.Cas_R.size() == 0)
				placeWall_R_Ca = true;
			for (int i = 0; i < GameLoop.Bil_R.size(); i++)
			{
				for (int j = 0; j < GameLoop.Cas_R.size(); j++)
				{
				if (test == 0) {
					
				
					if( (GameLoop.Bil_R.get(i).getX() < GameLoop.Cas_R.get(j).getX() || GameLoop.Bil_R.get(i).getX() > GameLoop.Cas_R.get(j).getX() + 63) &&
							(GameLoop.Bil_R.get(i).getY() < GameLoop.Cas_R.get(j).getY() || GameLoop.Bil_R.get(i).getY() > GameLoop.Cas_R.get(j).getY() + 63	)) 
					{
						placeWall_R_Ca = true;
					}
					else if( (GameLoop.Bil_R.get(i).getX() >= GameLoop.Cas_R.get(j).getX() && GameLoop.Bil_R.get(i).getX() <= GameLoop.Cas_R.get(j).getX() +63)
							&& (GameLoop.Bil_R.get(i).getY() >= GameLoop.Cas_R.get(j).getY() && GameLoop.Bil_R.get(i).getY() <= GameLoop.Cas_R.get(j).getY() + 63 )) 
					{
						placeWall_R_Ca = false;
						test = 1;
						//i = Bil_B.size();
					}
				}
				}
			}		
		}
	
public static void placewall_O() {
	for(int i = 0; i < GameLoop.Bil_O.size(); i++)
	{
		if (placeWall_O && placeWall_O_C && placeWall_O_Ca)
			GameLoop.Wal_O.add(new Wall_O(GameLoop.Bil_O.get(i).getX(), GameLoop.Bil_O.get(i).getY(), 0, 0));
	}
	if (placeWall_O && placeWall_O_C && placeWall_O_Ca)
		RmdBuild.rmd_wall_O();
}
	public static void checkForWall_O() {
		int test = 0;
		if (GameLoop.Wal_O.size() == 0)
			placeWall_O = true;
		for (int i = 0; i < GameLoop.Bil_O.size(); i++)
		{
			for (int j = 0; j < GameLoop.Wal_O.size(); j++)
			{
			if (test == 0) {
				
			
				if( GameLoop.Bil_O.get(i).getX() != GameLoop.Wal_O.get(j).getX() && GameLoop.Bil_O.get(i).getY() != GameLoop.Wal_O.get(j).getY() ) 
				{
					placeWall_O = true;
				}
				if( GameLoop.Bil_O.get(i).getX() == GameLoop.Wal_O.get(j).getX() && GameLoop.Bil_O.get(i).getY() == GameLoop.Wal_O.get(j).getY() ) 
				{
					placeWall_O = false;
					test = 1;
					//i = Bil_B.size();
				}
			}
			}
		}		
	}
	// check  orange for cannons
			public static void checkForCannon_O() {
				int test = 0;
				if (GameLoop.Can_O.size() == 0)
					placeWall_O_C = true;
				for (int i = 0; i < GameLoop.Bil_O.size(); i++)
				{
					for (int j = 0; j < GameLoop.Can_O.size(); j++)
					{
					if (test == 0) {
						
					
						if( (GameLoop.Bil_O.get(i).getX() < GameLoop.Can_O.get(j).getX() || GameLoop.Bil_O.get(i).getX() > GameLoop.Can_O.get(j).getX() + 63) &&
								(GameLoop.Bil_O.get(i).getY() < GameLoop.Can_O.get(j).getY() || GameLoop.Bil_O.get(i).getY() > GameLoop.Can_O.get(j).getY() + 63	)) 
						{
							placeWall_O_C = true;
						}
						else if( (GameLoop.Bil_O.get(i).getX() >= GameLoop.Can_O.get(j).getX() && GameLoop.Bil_O.get(i).getX() <= GameLoop.Can_O.get(j).getX() +63)
								&& (GameLoop.Bil_O.get(i).getY() >= GameLoop.Can_O.get(j).getY() && GameLoop.Bil_O.get(i).getY() <= GameLoop.Can_O.get(j).getY() + 63 )) 
						{
							placeWall_O_C = false;
							test = 1;
						}
					}
					}
				}		
			}
			// check for orange castle
			public static void checkForCastle_O() {
				int test = 0;
				if (GameLoop.Cas_O.size() == 0)
					placeWall_O_Ca = true;
				for (int i = 0; i < GameLoop.Bil_O.size(); i++)
				{
					for (int j = 0; j < GameLoop.Cas_O.size(); j++)
					{
					if (test == 0) {
						
					
						if( (GameLoop.Bil_O.get(i).getX() < GameLoop.Cas_O.get(j).getX() || GameLoop.Bil_O.get(i).getX() > GameLoop.Cas_O.get(j).getX() + 63) &&
								(GameLoop.Bil_O.get(i).getY() < GameLoop.Cas_O.get(j).getY() || GameLoop.Bil_O.get(i).getY() > GameLoop.Cas_O.get(j).getY() + 63	)) 
						{
							placeWall_O_Ca = true;
						}
						else if( (GameLoop.Bil_O.get(i).getX() >= GameLoop.Cas_O.get(j).getX() && GameLoop.Bil_O.get(i).getX() <= GameLoop.Cas_O.get(j).getX() +63)
								&& (GameLoop.Bil_O.get(i).getY() >= GameLoop.Cas_O.get(j).getY() && GameLoop.Bil_O.get(i).getY() <= GameLoop.Cas_O.get(j).getY() + 63 )) 
						{
							placeWall_O_Ca = false;
							test = 1;
							//i = Bil_B.size();
						}
					}
					}
				}		
			}
} // end of class
