import java.lang.Math;

public class RotateBil {
	static double angle = Math.toRadians(90);
	static double sin = Math.sin(angle);
	static double cos = Math.cos(angle);
	// BLUE
	static double x0_B;
	static double y0_B;
	// RED
	static double x0_R;
	static double y0_R;
	// ORANGE
	static double x0_O;
	static double y0_O;
	static public int yTop = 0;
	static public int yBottom = 864;
	static public int xLeft = 0;
	static public int xRight = 1248;
	static public int testRot_B = 0;
	RotateBil() {
	}
	// rotate Bil_B for BLUE.
	public static void rotate_B() {
		if (GameLoop.Bil_B.size() > 0) {
			x0_B = GameLoop.Bil_B.get(GameLoop.Bil_B.size()-1).getX();   // sets the point of rotation x
			y0_B = GameLoop.Bil_B.get(GameLoop.Bil_B.size()-1).getY();    // sets the point of rotatio y
		}
		for (int i = 0; i < GameLoop.Bil_B.size()-1; i++) {   // rotates every Bil_B except the Bil_B at cursor for 90 degrees 
			double a = GameLoop.Bil_B.get(i).getX() - x0_B;
			double b =  GameLoop.Bil_B.get(i).getY() - y0_B;
			int xx = (int) (+a * cos -b * sin + x0_B);
			int yy = (int) ( +a * sin + b * cos + y0_B);
			
			double atest = GameLoop.Bil_B.get(GameLoop.Bil_B.size()-2).getX() - x0_B;   // looks if Bil_ would go over window size and prevent if so.
			double btest =  GameLoop.Bil_B.get(GameLoop.Bil_B.size()-2).getY() - y0_B;
			int xxtest = (int) (+atest * cos -btest * sin + x0_B);
			int yytest = (int) ( +atest * sin + btest * cos + y0_B);
			
			if ( xxtest >= xLeft && xxtest <= xRight && yytest >= yTop && yytest <= yBottom) {
				GameLoop.Bil_B.get(i).setX(xx);
				GameLoop.Bil_B.get(i).setY(yy);
				 if (xx % 2 > 0 ) { // adjust accuracy of bil placement after rotation
					if (xx < GameLoop.Bil_B.get(GameLoop.Bil_B.size()-1).getX()-16) 
					{
						GameLoop.Bil_B.get(i).setX(GameLoop.Bil_B.get(GameLoop.Bil_B.size()-1).getX()-32);
					}
					else {
						GameLoop.Bil_B.get(i).setX(GameLoop.Bil_B.get(GameLoop.Bil_B.size()-1).getX());
					}
				} 
			}
		}
	}
	
	// rotate Bil_R for RED
	public static void rotate_R() {
		if (GameLoop.Bil_R.size() > 0) {
			x0_R = GameLoop.Bil_R.get(GameLoop.Bil_R.size()-1).getX();   // sets the point of rotation x
			y0_R = GameLoop.Bil_R.get(GameLoop.Bil_R.size()-1).getY();    // sets the point of rotatio y
		}
		for (int i = 0; i < GameLoop.Bil_R.size()-1; i++) {   // rotates every Bil_B except the Bil_B at cursor for 90 degrees 
			double a = GameLoop.Bil_R.get(i).getX() - x0_R;
			double b =  GameLoop.Bil_R.get(i).getY() - y0_R;
			
			int xx = (int) (+a * cos -b * sin + x0_R);
			int yy = (int) ( +a * sin + b * cos + y0_R);
			
			double atest = GameLoop.Bil_R.get(GameLoop.Bil_R.size()-2).getX() - x0_R;  //looks if Bil_ would go over window size and prevent if so.
			double btest =  GameLoop.Bil_R.get(GameLoop.Bil_R.size()-2).getY() - y0_R;
			int xxtest = (int) (+atest * cos -btest * sin + x0_R);
			int yytest = (int) ( +atest * sin + btest * cos + y0_R);
			System.out.println("xx: " + xx);
			System.out.println("yy: " + yy);
			if ( xxtest >= xLeft && xxtest <= xRight && yytest >= yTop && yytest <= yBottom) { 
				GameLoop.Bil_R.get(i).setX(xx);
				GameLoop.Bil_R.get(i).setY(yy);
				if (xx % 2 > 0 ) { // adjust accuracy of bil placement after rotation
					if (xx < GameLoop.Bil_R.get(GameLoop.Bil_R.size()-1).getX()-16) 
					{
						GameLoop.Bil_R.get(i).setX(GameLoop.Bil_R.get(GameLoop.Bil_R.size()-1).getX()-32);
					}
					else {
						GameLoop.Bil_R.get(i).setX(GameLoop.Bil_R.get(GameLoop.Bil_R.size()-1).getX());
					}
				}
			}
		}
	}
	
	// rotate Bil_O for ORANGE
	public static void rotate_O() {
		if (GameLoop.Bil_O.size() > 0) {
			x0_O = GameLoop.Bil_O.get(GameLoop.Bil_O.size()-1).getX();   // sets the point of rotation x
			y0_O = GameLoop.Bil_O.get(GameLoop.Bil_O.size()-1).getY();    // sets the point of rotatio y
		}
		for (int i = 0; i < GameLoop.Bil_O.size()-1; i++) {   // rotates every Bil_B except the Bil_B at cursor for 90 degrees 
			double a = GameLoop.Bil_O.get(i).getX() - x0_O;
			double b =  GameLoop.Bil_O.get(i).getY() - y0_O;
			
			int xx = (int) (+a * cos -b * sin + x0_O);
			int yy = (int) ( +a * sin + b * cos + y0_O);
			
			double atest = GameLoop.Bil_O.get(GameLoop.Bil_O.size()-2).getX() - x0_O;  //  looks if Bil_ would go over window size and prevent if so.
			double btest =  GameLoop.Bil_O.get(GameLoop.Bil_O.size()-2).getY() - y0_O;
			int xxtest = (int) (+atest * cos -btest * sin + x0_O);
			int yytest = (int) ( +atest * sin + btest * cos + y0_O);
			
			if ( xxtest >= xLeft && xxtest <= xRight && yytest >= yTop && yytest <= yBottom) {
				GameLoop.Bil_O.get(i).setX(xx);
				GameLoop.Bil_O.get(i).setY(yy);
				if (xx % 2 > 0 ) { // adjust accuracy of bil placement after rotation
					if (xx < GameLoop.Bil_O.get(GameLoop.Bil_O.size()-1).getX()-16) 
					{
						GameLoop.Bil_O.get(i).setX(GameLoop.Bil_O.get(GameLoop.Bil_O.size()-1).getX()-32);
					}
					else {
						GameLoop.Bil_O.get(i).setX(GameLoop.Bil_O.get(GameLoop.Bil_O.size()-1).getX());
					}
				}
			}
		}
	}
	
} // end class