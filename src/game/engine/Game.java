package game.engine;

public class Game {

	private CellManipulator manipulator;
	private int sizeOfCellMap;
	private SpeedLevel speed;
	private boolean isAtLeastOneCellAlive = true;

	public Game(int sizeOfCellMap, SpeedLevel level) {
		this.sizeOfCellMap = sizeOfCellMap;
		this.speed = level;
	}

	public void loadTheGame() {

		this.manipulator = new CellManipulator(new TheCell[this.sizeOfCellMap][this.sizeOfCellMap]);

	}

	public void getAllCellsStatus() {
		this.manipulator.getAllCellsStatus();
	}

	public int getSpeedLevel() {
		return Integer.sum(this.speed.ordinal(), 1);

	}

	/**
	 * 
	 * @param rowNumber
	 *            Minimum value is 1; Expected human number (starts with 1);
	 * @param comlumnNumber
	 *            Minimum value is 1; Expected human number (starts with 1);
	 * @throws Exception
	 *             Is thrown when the Cell's index is out of boundaries - < 1 or
	 *             > row/column length;
	 */

	public void makeCellAlive(int rowNumber, int comlumnNumber) {

		try {
			this.manipulator.makeSpecificCellAlive(rowNumber, comlumnNumber);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Cell index was out of bounds. Please try again");
		}

	}

	public void startTheCycle() {

		CellRenderer.rendCells(manipulator.getCurrentCells(), this.speed);

		while (this.isAtLeastOneCellAlive) {

			//this.manipulator.makeTemporaryCopyOfCells();
			this.manipulator.breedCells();

			// manipulator.getAllCellsStatus();

			CellRenderer.rendCells(manipulator.getCurrentCells(), this.speed);

			this.isAtLeastOneCellAlive = GameUtils.checkIfAnyCellAlive(manipulator.getCurrentCells());

		}

	}

}
