package game.engine;

public class CellRenderer {

	private static String separatorLine;

	public static void rendCells(TheCell[][] allCellList, SpeedLevel speed) {

		drawTheSeparatorLine(allCellList);

		GameUtils.clearConsole();

		for (int i = 0; i < allCellList.length; i++) {

			System.out.println(separatorLine);

			for (int k = 0; k < allCellList.length; k++) {

				TheCell currentCell = allCellList[i][k];

				if (currentCell.getCellLifeStatus() == true) {
					System.out.print(" X |");
				} else {
					System.out.print(" O |");
				}
			}

		}

		System.out.println(separatorLine);

		try {
			Thread.sleep(4000 - Integer.toUnsignedLong(speed.ordinal() * 1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	private static void drawTheSeparatorLine(TheCell[][] allCellList) {

		separatorLine = "\n";

		for (int i = 0; i < allCellList.length; i++) {
			separatorLine += "--- ";
		}

	}

}
