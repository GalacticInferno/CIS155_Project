// by Markus Tamm
import java.util.Random;

public class Cannonball_create {
	static long startTime_P1_ball;
	static long endTime_P1_ball = System.currentTimeMillis();
	static long startTime_P2_ball;
	static long endTime_P2_ball = System.currentTimeMillis();
	static long startTime_P3_ball;
	static long endTime_P3_ball = System.currentTimeMillis();
	// Count cannon - > needed to prevent updating the destination of the cannon ball
	static int countBall_B = 0;
	static int countBall_R = 0;
	static int countBall_O = 0;
	static int getBallCount = 0;
	static int ballCreation = 2500;
	static Random rmd = new Random();
	static int shot;
	
	
	Cannonball_create() {
	}
	// create cannonball blue
	public static void cannonball_B(int cannonCount) {
		int destination_x;
		int destination_y;
		int original_x;
		int original_y;
		if (ballCreation+endTime_P1_ball < startTime_P1_ball) {
			for(int i = 0; i < cannonCount; i++){
			//shot = rmd.nextInt(2)+1;
				//if ( shot > 1) {
					destination_x = GameLoop.Cur_B.get(0).getX();
					destination_y = GameLoop.Cur_B.get(0).getY();
					original_x = GameLoop.Can_B.get(i).getX();
					original_y = GameLoop.Can_B.get(i).getY();
					for (int j = 0; j < GameLoop.Blue.size(); j++) {
						if ( original_x == GameLoop.Blue.get(j).getX() && original_y == GameLoop.Blue.get(j).getY()){
							GameLoop.Cannonball_B.add(new Cannonball_B(original_x, original_y, 1, 1));
							System.out.println("---------- HELLO:" + original_x + " " + GameLoop.Blue.get(j).getX());
							GameLoop.Cannonball_B.get(countBall_B).setDestinationX(destination_x);
							GameLoop.Cannonball_B.get(countBall_B).setDestinationY(destination_y);
							countBall_B++;
							j = GameLoop.Blue.size();
						}
					//}
				}
			}
			endTime_P1_ball = System.currentTimeMillis();
		}
	}
	// create cannonball orange
	public static void cannonball_O(int cannonCount) {
		int destination_x;
		int destination_y;
		int original_x;
		int original_y;
		
		if (ballCreation+endTime_P2_ball < startTime_P2_ball) {
			for(int i = 0; i < cannonCount; i++){
				destination_x = GameLoop.Cur_O.get(0).getX();
				destination_y = GameLoop.Cur_O.get(0).getY();
				original_x = GameLoop.Can_O.get(i).getX();
				original_y = GameLoop.Can_O.get(i).getY();
				for (int j = 0; j < GameLoop.Orange.size(); j++) {
					if ( original_x == GameLoop.Orange.get(j).getX() && original_y == GameLoop.Orange.get(j).getY()){
						GameLoop.Cannonball_O.add(new Cannonball_O(original_x, original_y, 1, 1));
						GameLoop.Cannonball_O.get(countBall_O).setDestinationX(destination_x);
						GameLoop.Cannonball_O.get(countBall_O).setDestinationY(destination_y);
						GameLoop.Cannonball_O.get(countBall_O).calcMov();
						countBall_O++;
						j = GameLoop.Orange.size();
					}
				}
			}
			endTime_P2_ball = System.currentTimeMillis();
		}
	}
	// create red balls
	public static void cannonball_R(int cannonCount) {
		int destination_x;
		int destination_y;
		int original_x;
		int original_y;
		
		if (ballCreation+endTime_P3_ball < startTime_P3_ball) {
			for(int i = 0; i < cannonCount; i++){
				destination_x = GameLoop.Cur_R.get(0).getX();
				destination_y = GameLoop.Cur_R.get(0).getY();
				original_x = GameLoop.Can_R.get(i).getX();
				original_y = GameLoop.Can_R.get(i).getY();
				for (int j = 0; j < GameLoop.Red.size(); j++) {
					if ( original_x == GameLoop.Red.get(j).getX() && original_y == GameLoop.Red.get(j).getY()){
						GameLoop.Cannonball_R.add(new Cannonball_R(original_x, original_y, 1, 1));
						GameLoop.Cannonball_R.get(countBall_R).setDestinationX(destination_x);
						GameLoop.Cannonball_R.get(countBall_R).setDestinationY(destination_y);
						GameLoop.Cannonball_R.get(countBall_R).calcMov();
						countBall_R++;
						j = GameLoop.Red.size();
					}
				}
			}
			endTime_P3_ball = System.currentTimeMillis();
		}
	}


	//---------------------------------- CANNON BALL REMOVING ------------------------

	// delete blue balls
	public static void cannonball_B_remove(int cannonCount)  {
		int destination_x;
		int destination_y;
		int current_x;
		int current_y;
		int ballExist = 0;
		
		if (GameLoop.Cannonball_B.size() > ballExist) { // doo only if ball is in array
			for(int i = 0; i < cannonCount; i++){
					destination_x = GameLoop.Cannonball_B.get(i).getDestiX();
					destination_y = GameLoop.Cannonball_B.get(i).getDestiY();
					current_x = GameLoop.Cannonball_B.get(i).getX();
					current_y = GameLoop.Cannonball_B.get(i).getY();
					if( destination_x < current_x+16 && destination_x > current_x-16 && current_y < destination_y+ 16 && current_y > destination_y- 16) {
						GameLoop.Cannonball_B.remove(i);
						countBall_B--;
						for (int j = 0; j < GameLoop.Wal_R.size(); j++)
						{
							int wallX = GameLoop.Wal_R.get(j).getX();
							int wallY = GameLoop.Wal_R.get(j).getY();
							if( destination_x < wallX+16 && destination_x > wallX-16 && current_y < wallY+ 16 && current_y > wallY- 16)
							{
								GameLoop.Wal_R.remove(j);
								GameLoop.Wal_D.add(new Wall_D(destination_x, destination_y, 0, 0));
								j = GameLoop.Wal_R.size();
							}
						}
						for (int j = 0; j < GameLoop.Wal_O.size(); j++)
						{
							int wallX = GameLoop.Wal_O.get(j).getX();
							int wallY = GameLoop.Wal_O.get(j).getY();
							if( destination_x < wallX+16 && destination_x > wallX-16 && current_y < wallY+ 16 && current_y > wallY- 16)
							{
								GameLoop.Wal_O.remove(j);
								GameLoop.Wal_D.add(new Wall_D(destination_x, destination_y, 0, 0));
								j = GameLoop.Wal_O.size();
							}
						}
						i = cannonCount;  // jump out of the for loop if ball is deleted to prevent array error.
					}
			}
		} 
	} 
	 // remove orange ball
	public static void cannonball_O_remove(int cannonCount)  {
			int destination_x;
			int destination_y;
			int current_x;
			int current_y;
			int ballExist = 0;
		
			if (GameLoop.Cannonball_O.size() > ballExist) { // do only if ball is in array
				for(int i = 0; i < cannonCount; i++){
						destination_x = GameLoop.Cannonball_O.get(i).getDestiX();
						destination_y = GameLoop.Cannonball_O.get(i).getDestiY();
						current_x = GameLoop.Cannonball_O.get(i).getX();
						current_y = GameLoop.Cannonball_O.get(i).getY();
						if( destination_x < current_x+16 && destination_x > current_x-16 && current_y < destination_y+ 16 && current_y > destination_y- 16) {
							GameLoop.Cannonball_O.remove(i);
							countBall_O--;
							for (int j = 0; j < GameLoop.Wal_R.size(); j++)
							{
								int wallX = GameLoop.Wal_R.get(j).getX();
								int wallY = GameLoop.Wal_R.get(j).getY();
								if( destination_x < wallX+16 && destination_x > wallX-16 && current_y < wallY+ 16 && current_y > wallY- 16)
								{
									GameLoop.Wal_R.remove(j);
									GameLoop.Wal_D.add(new Wall_D(destination_x, destination_y, 0, 0));
									j = GameLoop.Wal_R.size();
								}
							}
							for (int j = 0; j < GameLoop.Wal_B.size(); j++)
							{
								int wallX = GameLoop.Wal_B.get(j).getX();
								int wallY = GameLoop.Wal_B.get(j).getY();
								if( destination_x < wallX+16 && destination_x > wallX-16 && current_y < wallY+ 16 && current_y > wallY- 16)
								{
									GameLoop.Wal_B.remove(j);
									GameLoop.Wal_D.add(new Wall_D(destination_x, destination_y, 0, 0));
									j = GameLoop.Wal_B.size();
								}
							}
							i = cannonCount;  // jump out of the for loop if ball is deleted to prevent array error.
						}
				}
			} 
		}
	//remove red ball
	public static void cannonball_R_remove(int cannonCount)  {
		int destination_x;
		int destination_y;
		int current_x;
		int current_y;
		int ballExist = 0;

		
		if (GameLoop.Cannonball_R.size() > ballExist) { // do only if a ball is in array
			for(int i = 0; i < cannonCount; i++){
					destination_x = GameLoop.Cannonball_R.get(i).getDestiX();
					destination_y = GameLoop.Cannonball_R.get(i).getDestiY();
					current_x = GameLoop.Cannonball_R.get(i).getX();
					current_y = GameLoop.Cannonball_R.get(i).getY();
					if( destination_x < current_x+16 && destination_x > current_x-16 && current_y < destination_y+ 16 && current_y > destination_y- 16) {
						GameLoop.Cannonball_R.remove(i);
						countBall_R--;
						for (int j = 0; j < GameLoop.Wal_B.size(); j++)
						{
							int wallX = GameLoop.Wal_B.get(j).getX();
							int wallY = GameLoop.Wal_B.get(j).getY();
							if( destination_x < wallX+16 && destination_x > wallX-16 && current_y < wallY+ 16 && current_y > wallY- 16)
							{
								GameLoop.Wal_B.remove(j);
								GameLoop.Wal_D.add(new Wall_D(destination_x, destination_y, 0, 0));
								j = GameLoop.Wal_B.size();
							}
						}
						for (int j = 0; j < GameLoop.Wal_O.size(); j++)
						{
							int wallX = GameLoop.Wal_O.get(j).getX();
							int wallY = GameLoop.Wal_O.get(j).getY();
							if( destination_x < wallX+16 && destination_x > wallX-16 && current_y < wallY+ 16 && current_y > wallY- 16)
							{
								GameLoop.Wal_O.remove(j);
								GameLoop.Wal_D.add(new Wall_D(destination_x, destination_y, 0, 0));
								j = GameLoop.Wal_O.size();
							}
						}
						i = cannonCount;  // jump out of the for loop if ball is deleted to prevent array error.
					}
			}
		} 
	}

}
