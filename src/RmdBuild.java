import java.util.Random;
public class RmdBuild {
	public static int curX_B;
	public static int curY_B;
	public static int movWallX_B = 32;
	public static int movWallY_B = 32;
	public static int rmdLocation1_B;
	public static int rmdLocation2_B;
	public static int rmdLocation3_B;
	
	public static int curX_R;
	public static int curY_R;
	public static int movWallX_R = 32;
	public static int movWallY_R = 32;
	public static int rmdLocation1_R;
	public static int rmdLocation2_R;
	public static int rmdLocation3_R;
	
	public static int curX_O;
	public static int curY_O;
	public static int movWallX_O = 32;
	public static int movWallY_O = 32;
	public static int rmdLocation1_O;
	public static int rmdLocation2_O;
	public static int rmdLocation3_O;
	public static Random rmdGen = new Random();
	
	RmdBuild()
	{
		//rmdGen = new Random();
	}
	
	public static void rmd_wall_B() {
		curX_B = GameLoop.Cur_B.get(0).getX();
		curY_B = GameLoop.Cur_B.get(0).getY();
		movWallX_B = 32;
		movWallY_B = 32;
		rmdLocation1_B = rmdGen.nextInt(6)+1;
		rmdLocation2_B = rmdGen.nextInt(3)+1;;
		rmdLocation3_B = rmdGen.nextInt(2)+1;
		
		
		  
		//Bil_B.add(new Build_B(curX, curY, 0, 0));
		//if (Bil_B.size() > 0) {
			for (int i = 0; i < GameLoop.Bil_B.size(); i++) 
			{
				GameLoop.Bil_B.remove(0);
				}
			for (int i = 0; i < GameLoop.Bil_B.size(); i++) 
			{
				GameLoop.Bil_B.remove(0);
				}
		//}
		 switch(rmdLocation1_B)
		{
		case 1:
			for (int i = 0; i < GameLoop.Bil_B.size(); i++) 
			{
				GameLoop.Bil_B.remove(i);
			}
			GameLoop.Bil_B.add(new Build_B(curX_B, curY_B-movWallY_B, 0, 0));  // 2piece straight
			break;
		case 2:
			for (int i = 0; i < GameLoop.Bil_B.size(); i++) 
			{
				GameLoop.Bil_B.remove(i);
			}
			GameLoop.Bil_B.add(new Build_B(curX_B, curY_B-movWallY_B, 0, 0));   //3 piece straight
			GameLoop.Bil_B.add(new Build_B(curX_B, curY_B-movWallY_B-movWallY_B, 0, 0));
			break;
		case 3:
			for (int i = 0; i < GameLoop.Bil_B.size(); i++) 
			{
				GameLoop.Bil_B.remove(i);
			}
			GameLoop.Bil_B.add(new Build_B(curX_B, curY_B-movWallY_B, 0, 0));    //4 piece straight
			GameLoop.Bil_B.add(new Build_B(curX_B, curY_B-movWallY_B-movWallY_B, 0, 0));
			GameLoop.Bil_B.add(new Build_B(curX_B, curY_B-movWallY_B-movWallY_B-movWallY_B, 0, 0));
			break;
		case 4:
			for (int i = 0; i < GameLoop.Bil_B.size(); i++) 
			{
				GameLoop.Bil_B.remove(i);
			}
			GameLoop.Bil_B.add(new Build_B(curX_B, curY_B-movWallY_B, 0, 0));  // 2 piece 
			GameLoop.Bil_B.add(new Build_B(curX_B-movWallX_B, curY_B-movWallY_B, 0, 0));  // 2piece 
			break;
		case 5:
			for (int i = 0; i < GameLoop.Bil_B.size(); i++) 
			{
				GameLoop.Bil_B.remove(i);
			}
			GameLoop.Bil_B.add(new Build_B(curX_B, curY_B-movWallY_B, 0, 0));   // 4 piece straight
			GameLoop.Bil_B.add(new Build_B(curX_B, curY_B-movWallY_B-movWallY_B, 0, 0));
			GameLoop.Bil_B.add(new Build_B(curX_B-movWallX_B, curY_B-movWallY_B-movWallY_B, 0, 0));
			break;
		case 6:
			for (int i = 0; i < GameLoop.Bil_B.size(); i++) 
			{
				GameLoop.Bil_B.remove(i);
			}
			GameLoop.Bil_B.add(new Build_B(curX_B, curY_B-movWallY_B, 0, 0));
			GameLoop.Bil_B.add(new Build_B(curX_B-movWallX_B, curY_B-movWallY_B, 0, 0));
			GameLoop.Bil_B.add(new Build_B(curX_B-movWallX_B, curY_B-movWallY_B-movWallY_B, 0, 0));
			break;
			
		}
		 GameLoop.Bil_B.add(new Build_B(curX_B, curY_B, 0, 0));

		
		//System.out.println(rmdLocation1);
		//System.out.println(rmdLocation2);
		//System.out.println(rmdLocation3);
		
	}
	public static int getBil_B() {
		return rmdLocation1_B;
	}
	public static void rmd_wall_R() {
		curX_R = GameLoop.Cur_R.get(0).getX();
		curY_R = GameLoop.Cur_R.get(0).getY();
		movWallX_R = 32;
		movWallY_R = 32;
		rmdLocation1_R = rmdGen.nextInt(6)+1;
		rmdLocation2_R = rmdGen.nextInt(3)+1;;
		rmdLocation3_R = rmdGen.nextInt(2)+1;
		
		
		  
		//Bil_B.add(new Build_B(curX, curY, 0, 0));
		//if (Bil_B.size() > 0) {
			for (int i = 0; i < GameLoop.Bil_R.size(); i++) 
			{
				GameLoop.Bil_R.remove(0);
				}
		//}
		 switch(rmdLocation1_R)
		{
		case 1:
			for (int i = 0; i < GameLoop.Bil_R.size(); i++) 
			{
				GameLoop.Bil_R.remove(i);
			}
			GameLoop.Bil_R.add(new Build_R(curX_R, curY_R-movWallY_R, 0, 0));  // 2piece straight
			break;
		case 2:
			for (int i = 0; i < GameLoop.Bil_R.size(); i++) 
			{
				GameLoop.Bil_R.remove(i);
			}
			GameLoop.Bil_R.add(new Build_R(curX_R, curY_R-movWallY_R, 0, 0));   //3 piece straight
			GameLoop.Bil_R.add(new Build_R(curX_R, curY_R-movWallY_R-movWallY_R, 0, 0));
			break;
		case 3:
			for (int i = 0; i < GameLoop.Bil_R.size(); i++) 
			{
				GameLoop.Bil_R.remove(i);
			}
			GameLoop.Bil_R.add(new Build_R(curX_R, curY_R-movWallY_R, 0, 0));    //4 piece straight
			GameLoop.Bil_R.add(new Build_R(curX_R, curY_R-movWallY_R-movWallY_R, 0, 0));
			GameLoop.Bil_R.add(new Build_R(curX_R, curY_R-movWallY_R-movWallY_R-movWallY_R, 0, 0));
			break;
		case 4:
			for (int i = 0; i < GameLoop.Bil_R.size(); i++) 
			{
				GameLoop.Bil_R.remove(i);
			}
			GameLoop.Bil_R.add(new Build_R(curX_R, curY_R-movWallY_R, 0, 0));  // 2 piece 
			GameLoop.Bil_R.add(new Build_R(curX_R-movWallX_R, curY_R-movWallY_R, 0, 0));  // 2piece 
			break;
		case 5:
			for (int i = 0; i < GameLoop.Bil_R.size(); i++) 
			{
				GameLoop.Bil_R.remove(i);
			}
			GameLoop.Bil_R.add(new Build_R(curX_R, curY_R-movWallY_R, 0, 0));   // 4 piece straight
			GameLoop.Bil_R.add(new Build_R(curX_R, curY_R-movWallY_R-movWallY_R, 0, 0));
			GameLoop.Bil_R.add(new Build_R(curX_R-movWallX_R, curY_R-movWallY_R-movWallY_R, 0, 0));
			break;
		case 6:
			for (int i = 0; i < GameLoop.Bil_R.size(); i++) 
			{
				GameLoop.Bil_R.remove(i);
			}
			GameLoop.Bil_R.add(new Build_R(curX_R, curY_R-movWallY_R, 0, 0));
			GameLoop.Bil_R.add(new Build_R(curX_R-movWallX_R, curY_R-movWallY_R, 0, 0));
			GameLoop.Bil_R.add(new Build_R(curX_R-movWallX_R, curY_R-movWallY_R-movWallY_R, 0, 0));
			break;
			
		}
		 GameLoop.Bil_R.add(new Build_R(curX_R, curY_R, 0, 0));

		
		//System.out.println(rmdLocation1);
		//System.out.println(rmdLocation2);
		//System.out.println(rmdLocation3);
		
	}
	public static void rmd_wall_O() {
		curX_O = GameLoop.Cur_O.get(0).getX();
		curY_O = GameLoop.Cur_O.get(0).getY();
		movWallX_O = 32;
		movWallY_O = 32;
		rmdLocation1_O = rmdGen.nextInt(6)+1;
		rmdLocation2_O = rmdGen.nextInt(3)+1;;
		rmdLocation3_O = rmdGen.nextInt(2)+1;
		
		
		  
		//Bil_B.add(new Build_B(curX, curY, 0, 0));
		//if (Bil_B.size() > 0) {
			for (int i = 0; i < GameLoop.Bil_O.size(); i++) 
			{
				GameLoop.Bil_O.remove(0);
				}
		//}
		 switch(rmdLocation1_O)
		{
		case 1:
			for (int i = 0; i < GameLoop.Bil_O.size(); i++) 
			{
				GameLoop.Bil_O.remove(i);
			}
			GameLoop.Bil_O.add(new Build_O(curX_O, curY_O-movWallY_O, 0, 0));  // 2piece straight
			break;
		case 2:
			for (int i = 0; i < GameLoop.Bil_O.size(); i++) 
			{
				GameLoop.Bil_O.remove(i);
			}
			GameLoop.Bil_O.add(new Build_O(curX_O, curY_O-movWallY_O, 0, 0));   //3 piece straight
			GameLoop.Bil_O.add(new Build_O(curX_O, curY_O-movWallY_O-movWallY_O, 0, 0));
			break;
		case 3:
			for (int i = 0; i < GameLoop.Bil_O.size(); i++) 
			{
				GameLoop.Bil_O.remove(i);
			}
			GameLoop.Bil_O.add(new Build_O(curX_O, curY_O-movWallY_O, 0, 0));    //4 piece straight
			GameLoop.Bil_O.add(new Build_O(curX_O, curY_O-movWallY_O-movWallY_O, 0, 0));
			GameLoop.Bil_O.add(new Build_O(curX_O, curY_O-movWallY_O-movWallY_O-movWallY_O, 0, 0));
			break;
		case 4:
			for (int i = 0; i < GameLoop.Bil_O.size(); i++) 
			{
				GameLoop.Bil_O.remove(i);
			}
			GameLoop.Bil_O.add(new Build_O(curX_O, curY_O-movWallY_O, 0, 0));  // 2 piece 
			GameLoop.Bil_O.add(new Build_O(curX_O-movWallX_O, curY_O-movWallY_O, 0, 0));  // 2piece 
			break;
		case 5:
			for (int i = 0; i < GameLoop.Bil_O.size(); i++) 
			{
				GameLoop.Bil_O.remove(i);
			}
			GameLoop.Bil_O.add(new Build_O(curX_O, curY_O-movWallY_O, 0, 0));   // 4 piece straight
			GameLoop.Bil_O.add(new Build_O(curX_O, curY_O-movWallY_O-movWallY_O, 0, 0));
			GameLoop.Bil_O.add(new Build_O(curX_O-movWallX_O, curY_O-movWallY_O-movWallY_O, 0, 0));
			break;
		case 6:
			for (int i = 0; i < GameLoop.Bil_O.size(); i++) 
			{
				GameLoop.Bil_O.remove(i);
			}
			GameLoop.Bil_O.add(new Build_O(curX_O, curY_O-movWallY_O, 0, 0));
			GameLoop.Bil_O.add(new Build_O(curX_O-movWallX_O, curY_O-movWallY_O, 0, 0));
			GameLoop.Bil_O.add(new Build_O(curX_O-movWallX_O, curY_O-movWallY_O-movWallY_O, 0, 0));
			break;
			
		}
		 GameLoop.Bil_O.add(new Build_O(curX_O, curY_O, 0, 0));

		
		//System.out.println(rmdLocation1);
		//System.out.println(rmdLocation2);
		//System.out.println(rmdLocation3);
		
	}
	public static void remove_Build() {
		// remove blue build
		for (int i = 0; i < GameLoop.Bil_B.size(); i++) 
		{
			GameLoop.Bil_B.remove(i);
		}
		for (int i = 0; i < GameLoop.Bil_B.size(); i++) 
		{
			GameLoop.Bil_B.remove(i);
		}
		for (int i = 0; i < GameLoop.Bil_B.size(); i++) 
		{
			GameLoop.Bil_B.remove(i);
		}
		// remove red build
		for (int i = 0; i < GameLoop.Bil_R.size(); i++) 
		{
			GameLoop.Bil_R.remove(i);
		}
		for (int i = 0; i < GameLoop.Bil_R.size(); i++) 
		{
			GameLoop.Bil_R.remove(i);
		}
		for (int i = 0; i < GameLoop.Bil_R.size(); i++) 
		{
			GameLoop.Bil_R.remove(i);
		}
		// remove orange build
		for (int i = 0; i < GameLoop.Bil_O.size(); i++) 
		{
			GameLoop.Bil_O.remove(i);
		}
		for (int i = 0; i < GameLoop.Bil_O.size(); i++) 
		{
			GameLoop.Bil_O.remove(i);
		}
		for (int i = 0; i < GameLoop.Bil_O.size(); i++) 
		{
			GameLoop.Bil_O.remove(i);
		}
		
	
	}
}
