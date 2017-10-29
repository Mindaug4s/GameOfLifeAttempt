package game.tests;

import game.engine.Game;
import game.engine.SpeedLevel;

public class GameTester {

	public static void main(String[] args) {

		Game game = new Game(6, SpeedLevel.THREE);

		game.loadTheGame();
		
		game.makeCellAlive(1,3);
		game.makeCellAlive(2,2);
		game.makeCellAlive(2,1);
		
		
//		game.makeCellAlive(2,4);
//		game.makeCellAlive(2,2);
//		game.makeCellAlive(2,3);
		
		//game.makeCellAlive(1,2);

		//game.getAllCellsStatus();
		
		game.startTheCycle();

		//System.out.println(game.getSpeedLevel());

	}

}
