
public class CannonPlace {
	// checks for wall
		public static boolean placeCannon_B_1 = true;
		public static boolean placeCannon_B_2 = true;
		public static boolean placeCannon_B_3 = true;
		public static boolean placeCannon_B_4 = true;
		public static boolean placeCannon_R_1 = true;
		public static boolean placeCannon_R_2 = true; 
		public static boolean placeCannon_R_3 = true; 
		public static boolean placeCannon_R_4 = true; 
		public static boolean placeCannon_O_1 = true; 
		public static boolean placeCannon_O_2 = true; 
		public static boolean placeCannon_O_3 = true; 
		public static boolean placeCannon_O_4 = true; 
		// checks for cannon
		public static boolean placeCannon_B_C = true;  
		public static boolean placeCannon_R_C = true;   
		public static boolean placeCannon_O_C = true;   
		// checks for castle
		public static boolean placeCannon_B_Ca = true;   
		public static boolean placeCannon_R_Ca = true;   
		public static boolean placeCannon_O_Ca = true;  
		// check for color tiles
		public static boolean placeCannon_B_Co = true;   
		public static boolean placeCannon_R_Co = true;   
		public static boolean placeCannon_O_Co = true;  
		public static int canSize = 63;
		// player blue
		public static void placeCannon_B() {

				if (placeCannon_B_1 && placeCannon_B_2 && placeCannon_B_3 && placeCannon_B_4 && placeCannon_B_C && placeCannon_B_Ca && placeCannon_B_Co ) {
					GameLoop.Can_B.add(new Cannon_B(GameLoop.Cur_B.get(0).getX(), GameLoop.Cur_B.get(0).getY(), 0, 0));
				}
		//	if (placeCannon_B && placeCannon_B_C && placeCannon_B_Ca) { // if place is placed create new random Bil
				//RmdBuild.rmd_wall_B();
			//}
		}
		
		public static void checkForWall_B() {
			int test = 0;
			if (GameLoop.Wal_B.size() == 0) {
				placeCannon_B_1 = true;
				placeCannon_B_2 = true;
				placeCannon_B_3 = true;
				placeCannon_B_4 = true;
			}
			for (int j = 0; j < 4; j++) {
				if(j == 0) {
					for (int i =0; i < GameLoop.Wal_B.size(); i++) {
						if (GameLoop.Cur_B.get(0).getX() != GameLoop.Wal_B.get(i).getX() && GameLoop.Cur_B.get(0).getY() != GameLoop.Wal_B.get(i).getY() ) {
							placeCannon_B_1 = true;
						}
						if (GameLoop.Cur_B.get(0).getX() == GameLoop.Wal_B.get(i).getX() && GameLoop.Cur_B.get(0).getY() == GameLoop.Wal_B.get(i).getY() ) {
							placeCannon_B_1 = false;
							i = GameLoop.Wal_B.size();
						}
					}
				}
				if(j == 1) {
					for (int i =0; i < GameLoop.Wal_B.size(); i++) {
						if (GameLoop.Cur_B.get(0).getX()+32 != GameLoop.Wal_B.get(i).getX() && GameLoop.Cur_B.get(0).getY() != GameLoop.Wal_B.get(i).getY() ) {
							placeCannon_B_2 = true;
						}
						if (GameLoop.Cur_B.get(0).getX()+32 == GameLoop.Wal_B.get(i).getX() && GameLoop.Cur_B.get(0).getY() == GameLoop.Wal_B.get(i).getY() ) {
							placeCannon_B_2 = false;
							i = GameLoop.Wal_B.size();
						}
					}
				}
				if(j == 2) {
					for (int i =0; i < GameLoop.Wal_B.size(); i++) {
						if (GameLoop.Cur_B.get(0).getX() != GameLoop.Wal_B.get(i).getX() && GameLoop.Cur_B.get(0).getY()+32 != GameLoop.Wal_B.get(i).getY() ) {
							placeCannon_B_3 = true;
						}
						if (GameLoop.Cur_B.get(0).getX() == GameLoop.Wal_B.get(i).getX() && GameLoop.Cur_B.get(0).getY()+32 == GameLoop.Wal_B.get(i).getY() ) {
							placeCannon_B_3 = false;
							i = GameLoop.Wal_B.size();
						}
					}
				}
				if(j == 3) {
					for (int i =0; i < GameLoop.Wal_B.size(); i++) {
						if (GameLoop.Cur_B.get(0).getX()+32 != GameLoop.Wal_B.get(i).getX() && GameLoop.Cur_B.get(0).getY()+32 != GameLoop.Wal_B.get(i).getY() ) {
							placeCannon_B_4 = true;
						}
						if (GameLoop.Cur_B.get(0).getX()+32 == GameLoop.Wal_B.get(i).getX() && GameLoop.Cur_B.get(0).getY()+32 == GameLoop.Wal_B.get(i).getY() ) {
							placeCannon_B_4 = false;
							i = GameLoop.Wal_B.size();
						}
					}
				}
			}
		}
		
		// check for cannon
		public static void checkForCannon_B() {
			int test = 0;
			if (GameLoop.Can_B.size() == 0) {
				placeCannon_B_C = true;

			}
				for (int j = 0; j < GameLoop.Can_B.size(); j++)
				{
				if (test == 0) {
					
				
					if( (GameLoop.Cur_B.get(0).getX()+ canSize <= GameLoop.Can_B.get(j).getX() || GameLoop.Cur_B.get(0).getX() >= GameLoop.Can_B.get(j).getX() + canSize) ||
							(GameLoop.Cur_B.get(0).getY() + canSize <= GameLoop.Can_B.get(j).getY() || GameLoop.Cur_B.get(0).getY() >= GameLoop.Can_B.get(j).getY() + canSize	)) 
					{
						placeCannon_B_C = true;

					}
					else 
					{
						placeCannon_B_C = false;

						test = 1;
						//i = Bil_B.size();
					}
				}
				}		
		}
		public static void checkForCastle_B() {
			int test = 0;
			if (GameLoop.Can_B.size() == 0) {
				placeCannon_B_Ca = true;

			}
				for (int j = 0; j < GameLoop.Cas_B.size(); j++)
				{
				if (test == 0) {
					
				
					if( (GameLoop.Cur_B.get(0).getX()+ canSize <= GameLoop.Cas_B.get(j).getX() || GameLoop.Cur_B.get(0).getX() >= GameLoop.Cas_B.get(j).getX() + canSize) ||
							(GameLoop.Cur_B.get(0).getY() + canSize <= GameLoop.Cas_B.get(j).getY() || GameLoop.Cur_B.get(0).getY() >= GameLoop.Cas_B.get(j).getY() + canSize	)) 
					{
						placeCannon_B_Ca = true;

					}
					else 
					{
						placeCannon_B_Ca = false;

						test = 1;
						//i = Bil_B.size();
					}
				}
				}		
		}
		//Check if blue tile exists 
				public static void checkBlue() {
					int test = 0;
					if (GameLoop.Blue.size() == 0) {
						placeCannon_B_Co = false;

					}
						for (int j = 0; j < GameLoop.Blue.size(); j++)
						{
						if (test == 0) {
							
						
							if( (GameLoop.Cur_B.get(0).getX() == GameLoop.Blue.get(j).getX() && GameLoop.Cur_B.get(0).getY() == GameLoop.Blue.get(j).getY())) 
							{
								placeCannon_B_Co = true;
								test =1;

							}
							else 
							{
								placeCannon_B_Co = false;

								//test = 1;
								//i = Bil_B.size();
							}
						}
						}		
				}
		
		// player red
		public static void placeCannon_R() {

			if (placeCannon_R_1 && placeCannon_R_2 && placeCannon_R_3 && placeCannon_R_4 && placeCannon_R_C && placeCannon_R_Ca && placeCannon_R_Co) {
				GameLoop.Can_R.add(new Cannon_R(GameLoop.Cur_R.get(0).getX(), GameLoop.Cur_R.get(0).getY(), 0, 0));
			}
	//	if (placeCannon_B && placeCannon_B_C && placeCannon_B_Ca) { // if place is placed create new random Bil
			//RmdBuild.rmd_wall_B();
		//}
		}
		// check for red wall
		public static void checkForWall_R() {
			int test = 0;
			if (GameLoop.Wal_R.size() == 0) {
				placeCannon_R_1 = true;
				placeCannon_R_2 = true;
				placeCannon_R_3 = true;
				placeCannon_R_4 = true;
			}
			for (int j = 0; j < 4; j++) {
				if(j == 0) {
					for (int i =0; i < GameLoop.Wal_R.size(); i++) {
						if (GameLoop.Cur_R.get(0).getX() != GameLoop.Wal_R.get(i).getX() && GameLoop.Cur_R.get(0).getY() != GameLoop.Wal_R.get(i).getY() ) {
							placeCannon_R_1 = true;
						}
						if (GameLoop.Cur_R.get(0).getX() == GameLoop.Wal_R.get(i).getX() && GameLoop.Cur_R.get(0).getY() == GameLoop.Wal_R.get(i).getY() ) {
							placeCannon_R_1 = false;
							i = GameLoop.Wal_R.size();
						}
					}
				}
				if(j == 1) {
					for (int i =0; i < GameLoop.Wal_R.size(); i++) {
						if (GameLoop.Cur_R.get(0).getX()+32 != GameLoop.Wal_R.get(i).getX() && GameLoop.Cur_R.get(0).getY() != GameLoop.Wal_R.get(i).getY() ) {
							placeCannon_R_2 = true;
						}
						if (GameLoop.Cur_R.get(0).getX()+32 == GameLoop.Wal_R.get(i).getX() && GameLoop.Cur_R.get(0).getY() == GameLoop.Wal_R.get(i).getY() ) {
							placeCannon_R_2 = false;
							i = GameLoop.Wal_R.size();
						}
					}
				}
				if(j == 2) {
					for (int i =0; i < GameLoop.Wal_R.size(); i++) {
						if (GameLoop.Cur_R.get(0).getX() != GameLoop.Wal_R.get(i).getX() && GameLoop.Cur_R.get(0).getY()+32 != GameLoop.Wal_R.get(i).getY() ) {
							placeCannon_R_3 = true;
						}
						if (GameLoop.Cur_R.get(0).getX() == GameLoop.Wal_R.get(i).getX() && GameLoop.Cur_R.get(0).getY()+32 == GameLoop.Wal_R.get(i).getY() ) {
							placeCannon_R_3 = false;
							i = GameLoop.Wal_R.size();
						}
					}
				}
				if(j == 3) {
					for (int i =0; i < GameLoop.Wal_R.size(); i++) {
						if (GameLoop.Cur_R.get(0).getX()+32 != GameLoop.Wal_R.get(i).getX() && GameLoop.Cur_R.get(0).getY()+32 != GameLoop.Wal_R.get(i).getY() ) {
							placeCannon_R_4 = true;
						}
						if (GameLoop.Cur_R.get(0).getX()+32 == GameLoop.Wal_R.get(i).getX() && GameLoop.Cur_R.get(0).getY()+32 == GameLoop.Wal_R.get(i).getY() ) {
							placeCannon_R_4 = false;
							i = GameLoop.Wal_R.size();
						}
					}
				}
			}
		}
		//check for red cannon
		public static void checkForCannon_R() {
			int test = 0;
			if (GameLoop.Can_R.size() == 0) {
				placeCannon_R_C = true;

			}
				for (int j = 0; j < GameLoop.Can_R.size(); j++)
				{
				if (test == 0) {
					
				
					if( (GameLoop.Cur_R.get(0).getX()+ canSize <= GameLoop.Can_R.get(j).getX() || GameLoop.Cur_R.get(0).getX() >= GameLoop.Can_R.get(j).getX() + canSize) ||
							(GameLoop.Cur_R.get(0).getY() + canSize <= GameLoop.Can_R.get(j).getY() || GameLoop.Cur_R.get(0).getY() >= GameLoop.Can_R.get(j).getY() + canSize	)) 
					{
						placeCannon_R_C = true;

					}
					else 
					{
						placeCannon_R_C = false;

						test = 1;
						//i = Bil_B.size();
					}
				}
				}		
		}
		// check for red castle
		public static void checkForCastle_R() {
			int test = 0;
			if (GameLoop.Can_R.size() == 0) {
				placeCannon_R_Ca = true;

			}
				for (int j = 0; j < GameLoop.Cas_R.size(); j++)
				{
				if (test == 0) {
					
				
					if( (GameLoop.Cur_R.get(0).getX()+ canSize <= GameLoop.Cas_R.get(j).getX() || GameLoop.Cur_R.get(0).getX() >= GameLoop.Cas_R.get(j).getX() + canSize) ||
							(GameLoop.Cur_R.get(0).getY() + canSize <= GameLoop.Cas_R.get(j).getY() || GameLoop.Cur_R.get(0).getY() >= GameLoop.Cas_R.get(j).getY() + canSize	)) 
					{
						placeCannon_R_Ca = true;

					}
					else 
					{
						placeCannon_R_Ca = false;

						test = 1;
						//i = Bil_B.size();
					}
				}
				}		
		}
		//Check if red tile exists 
		public static void checkRed() {
			int test = 0;
			if (GameLoop.Red.size() == 0) {
				placeCannon_R_Co = false;

			}
				for (int j = 0; j < GameLoop.Red.size(); j++)
				{
				if (test == 0) {
					
				
					if( (GameLoop.Cur_R.get(0).getX() == GameLoop.Red.get(j).getX() && GameLoop.Cur_R.get(0).getY() == GameLoop.Red.get(j).getY())) 
					{
						placeCannon_R_Co = true;
						test =1;

					}
					else 
					{
						placeCannon_R_Co = false;

						//test = 1;
						//i = Bil_B.size();
					}
				}
				}		
		}
		// orange player
		public static void placeCannon_O() {

			if (placeCannon_O_1 && placeCannon_O_2 && placeCannon_O_3 && placeCannon_O_4 && placeCannon_O_C && placeCannon_O_Ca && placeCannon_O_Co) {
				GameLoop.Can_O.add(new Cannon_O(GameLoop.Cur_O.get(0).getX(), GameLoop.Cur_O.get(0).getY(), 0, 0));
			}
	//	if (placeCannon_B && placeCannon_B_C && placeCannon_B_Ca) { // if place is placed create new random Bil
			//RmdBuild.rmd_wall_B();
		//}
		}
		public static void checkForWall_O() {
			int test = 0;
			if (GameLoop.Wal_O.size() == 0) {
				placeCannon_O_1 = true;
				placeCannon_O_2 = true;
				placeCannon_O_3 = true;
				placeCannon_O_4 = true;
			}
			for (int j = 0; j < 4; j++) {
				if(j == 0) {
					for (int i =0; i < GameLoop.Wal_O.size(); i++) {
						if (GameLoop.Cur_O.get(0).getX() != GameLoop.Wal_O.get(i).getX() && GameLoop.Cur_O.get(0).getY() != GameLoop.Wal_O.get(i).getY() ) {
							placeCannon_O_1 = true;
						}
						if (GameLoop.Cur_O.get(0).getX() == GameLoop.Wal_O.get(i).getX() && GameLoop.Cur_O.get(0).getY() == GameLoop.Wal_O.get(i).getY() ) {
							placeCannon_O_1 = false;
							i = GameLoop.Wal_O.size();
						}
					}
				}
				if(j == 1) {
					for (int i =0; i < GameLoop.Wal_O.size(); i++) {
						if (GameLoop.Cur_O.get(0).getX()+32 != GameLoop.Wal_O.get(i).getX() && GameLoop.Cur_O.get(0).getY() != GameLoop.Wal_O.get(i).getY() ) {
							placeCannon_O_2 = true;
						}
						if (GameLoop.Cur_O.get(0).getX()+32 == GameLoop.Wal_O.get(i).getX() && GameLoop.Cur_O.get(0).getY() == GameLoop.Wal_O.get(i).getY() ) {
							placeCannon_O_2 = false;
							i = GameLoop.Wal_O.size();
						}
					}
				}
				if(j == 2) {
					for (int i =0; i < GameLoop.Wal_O.size(); i++) {
						if (GameLoop.Cur_O.get(0).getX() != GameLoop.Wal_O.get(i).getX() && GameLoop.Cur_O.get(0).getY()+32 != GameLoop.Wal_O.get(i).getY() ) {
							placeCannon_R_3 = true;
						}
						if (GameLoop.Cur_O.get(0).getX() == GameLoop.Wal_O.get(i).getX() && GameLoop.Cur_R.get(0).getY()+32 == GameLoop.Wal_O.get(i).getY() ) {
							placeCannon_O_3 = false;
							i = GameLoop.Wal_O.size();
						}
					}
				}
				if(j == 3) {
					for (int i =0; i < GameLoop.Wal_O.size(); i++) {
						if (GameLoop.Cur_O.get(0).getX()+32 != GameLoop.Wal_O.get(i).getX() && GameLoop.Cur_O.get(0).getY()+32 != GameLoop.Wal_O.get(i).getY() ) {
							placeCannon_O_4 = true;
						}
						if (GameLoop.Cur_O.get(0).getX()+32 == GameLoop.Wal_O.get(i).getX() && GameLoop.Cur_O.get(0).getY()+32 == GameLoop.Wal_O.get(i).getY() ) {
							placeCannon_O_4 = false;
							i = GameLoop.Wal_O.size();
						}
					}
				}
			}
		}
		//check for red cannon
		public static void checkForCannon_O() {
			int test = 0;
			if (GameLoop.Can_O.size() == 0) {
				placeCannon_O_C = true;

			}
				for (int j = 0; j < GameLoop.Can_O.size(); j++)
				{
				if (test == 0) {
					
				
					if( (GameLoop.Cur_O.get(0).getX()+ canSize <= GameLoop.Can_O.get(j).getX() || GameLoop.Cur_O.get(0).getX() >= GameLoop.Can_O.get(j).getX() + canSize) ||
							(GameLoop.Cur_O.get(0).getY() + canSize <= GameLoop.Can_O.get(j).getY() || GameLoop.Cur_O.get(0).getY() >= GameLoop.Can_O.get(j).getY() + canSize	)) 
					{
						placeCannon_O_C = true;

					}
					else 
					{
						placeCannon_O_C = false;

						test = 1;
						//i = Bil_B.size();
					}
				}
				}		
		}
		// check for red castle
		public static void checkForCastle_O() {
			int test = 0;
			if (GameLoop.Can_O.size() == 0) {
				placeCannon_O_Ca = true;

			}
				for (int j = 0; j < GameLoop.Cas_O.size(); j++)
				{
				if (test == 0) {
					
				
					if( (GameLoop.Cur_O.get(0).getX()+ canSize <= GameLoop.Cas_O.get(j).getX() || GameLoop.Cur_O.get(0).getX() >= GameLoop.Cas_O.get(j).getX() + canSize) ||
							(GameLoop.Cur_O.get(0).getY() + canSize <= GameLoop.Cas_O.get(j).getY() || GameLoop.Cur_O.get(0).getY() >= GameLoop.Cas_O.get(j).getY() + canSize	)) 
					{
						placeCannon_O_Ca = true;

					}
					else 
					{
						placeCannon_O_Ca = false;

						test = 1;
						//i = Bil_B.size();
					}
				}
				}		
		}
		//Check if orange tile exists 
		public static void checkOrange() {
			int test = 0;
			if (GameLoop.Orange.size() == 0) {
				placeCannon_O_Co = false;

			}
				for (int j = 0; j < GameLoop.Orange.size(); j++)
				{
				if (test == 0) {
					
				
					if( (GameLoop.Cur_O.get(0).getX() == GameLoop.Orange.get(j).getX() && GameLoop.Cur_O.get(0).getY() == GameLoop.Orange.get(j).getY())) 
					{
						placeCannon_O_Co = true;
						test =1;

					}
					else 
					{
						placeCannon_O_Co = false;

						//test = 1;
						//i = Bil_B.size();
					}
				}
				}		
		}
		
		
		//checking collision for all players.
		public static void checkCannon_collision() {
			//player blue
			checkForWall_B();
			checkForCannon_B();
			checkForCastle_B();
			checkBlue();
			//player red
			checkForWall_R();
			checkForCannon_R();
			checkForCastle_R();
			checkRed();
			//orange player
			checkForWall_O();
			checkForCannon_O();
			checkForCastle_O();
			checkOrange();
		}
		
}
