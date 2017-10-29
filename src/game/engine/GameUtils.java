package game.engine;

import java.util.Arrays;

public class GameUtils {

	public static boolean checkIfAnyCellAlive(TheCell[][] currentCells) {

		return Arrays.stream(currentCells).flatMap(Arrays::stream).anyMatch(x -> x.getCellLifeStatus() == true);
	}

	public static void clearConsole() {

		//System.out.print(String.format("\033[2J"));

		// Runtime.getRuntime().exec(command)

		// System.out.print("\033[H\033[2J");
		// System.out.flush();
	}

}
