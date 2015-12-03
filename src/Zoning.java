
public class Zoning {
 /*
  * start at castle
  * move up check for wall
  * no wall no zone to make
  * if hit wall is there any other wall to the right/left and top?
  * 
  */
	static public int starty = GameLoop.Cas_B.get(0).getY();
	static public int startx1 = GameLoop.Cas_B.get(0).getX();
	static public int startx2 = GameLoop.Cas_B.get(0).getX() + 64;
	static public int walbsize = GameLoop.Wal_B.size();
	static public int[] wal_b = new int[walbsize];
	
	static public int startWallx;
	static public int startWally;
	static public int mov = 32;
	
	Zoning() {
		
	}
	// go straight up and look for wall if no wall to bad for you ! if wall keep looking !
	static public void checkZone() {
		for (int i = 0; i < GameLoop.Wal_B.size(); i++) {
			for (int j = starty; j > 0; j -= 32) {
				GameLoop.Wal_B.get(i).getY();
				GameLoop.Wal_B.get(i).getX();
				if ( j == GameLoop.Wal_B.get(i).getY() && GameLoop.Wal_B.get(i).getX() == startx1 ) { // finds first wall
					System.out.println("Found Wall");
					startWallx = GameLoop.Wal_B.get(i).getX();
					startWally = GameLoop.Wal_B.get(i).getY();
					checkWallLeft(startWallx, startWally);
					checkWallTop();
					checkWallRight();
					
				}
				//else 
					//System.out.println("no walls no zoning to bad for!");
			}
		}
	}
	/*
	 * check for left and right and top.
	 */


	static public void checkWallLeft(int x, int y) {
		for (int i = 0; i < GameLoop.Wal_B.size(); i++ ) {
			for (int j = startWallx - mov; j > 0; j -= 32) {
				if (j == GameLoop.Wal_B.get(i).getX() && startWally == GameLoop.Wal_B.get(i).getY() ) {
					System.out.println("Found Wall to the left");
				}
				//else 
					//System.out.println("no walls to the left keep looking to the right");
			}
		}
		
	}
	static public void checkWallTop() {
		for (int i = 0; i < GameLoop.Wal_B.size(); i++ ) {
			for (int j = startWally - mov; j > 0; j -= 32) {
				if (j == GameLoop.Wal_B.get(i).getY() && startWallx == GameLoop.Wal_B.get(i).getX() ) {
					System.out.println("Found Wall to the top");
				}
				//else 
					//System.out.println("no walls to the left keep looking to the right");
			}
		}
	}
	static public void checkWallRight() {
		for (int i = 0; i < GameLoop.Wal_B.size(); i++ ) {
			for (int j = startWallx + mov; j < 1300; j += 32) {
				if (j == GameLoop.Wal_B.get(i).getX() && startWally == GameLoop.Wal_B.get(i).getY() ) {
					System.out.println("Found Wall to the Right");
				}
				//else 
					//System.out.println("no walls to the left keep looking to the right");
			}
		}
	}
}