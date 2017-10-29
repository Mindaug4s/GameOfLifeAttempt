package game.engine;

public class CellManipulator {

	private TheCell[][] allCellList;
	private TheCell[][] temporaryCellCloneList;

	CellManipulator(TheCell[][] allCellList) {

		this.allCellList = allCellList;
		initializeAllCellsAsDead();

	}

	private void initializeAllCellsAsDead() {

		for (int i = 0; i < this.allCellList.length; i++) {

			for (int k = 0; k < this.allCellList.length; k++) {

				this.allCellList[i][k] = new TheCell();
			}

		}

	}

	TheCell[][] getCurrentCells() {
		return this.allCellList;

	}

	void getAllCellsStatus() {

		for (int i = 0; i < this.allCellList.length; i++) {

			for (int k = 0; k < this.allCellList.length; k++) {

				TheCell currentCell = this.allCellList[i][k];

				System.out.println("Cell's at row " + Integer.sum(i, 1) + " and index " + Integer.sum(k, 1)
						+ " life status is " + currentCell.getCellLifeStatus());
			}

		}

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
	void makeSpecificCellAlive(int rowNumber, int comlumnNumber) throws Exception {

		if (rowNumber < 1 || comlumnNumber < 1) {
			throw new Exception("Minimum value for row and column is 1");
		}

		if (rowNumber > this.allCellList.length || comlumnNumber > this.allCellList.length) {
			throw new Exception("Cell is out of bounds");
		}

		this.allCellList[rowNumber - 1][comlumnNumber - 1].makeCellAlive();

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
	void makeSpecificCellDead(int rowNumber, int comlumnNumber) throws Exception {

		if (rowNumber < 1 || comlumnNumber < 1) {
			throw new Exception("Minimum value for row and column is 1");
		}

		if (rowNumber > this.allCellList.length || comlumnNumber > this.allCellList.length) {
			throw new Exception("Cell is out of bounds");
		}

		this.allCellList[rowNumber - 1][comlumnNumber - 1].makeCellDead();

	}

	void breedCells() {

		TheCell[][] temporaryCellCloneList = new TheCell[this.allCellList.length][this.allCellList.length];

		for (int i = 0; i < this.allCellList.length; i++) {

			for (int k = 0; k < this.allCellList.length; k++) {
				 temporaryCellCloneList[i][k] = new TheCell();

				temporaryCellCloneList[i][k]
						.setCellLiveStatus(new CellStatusUpdater(this.allCellList, i, k).getUpdatedStatus());

			}

		}

		this.allCellList = temporaryCellCloneList;
	}

	void breedCellsAnotherVariation() {

		for (int i = 0; i < this.allCellList.length; i++) {

			for (int k = 0; k < this.allCellList.length; k++) {

				TheCell currentCell = this.allCellList[i][k];

				currentCell.setCellLiveStatus(new CellStatusUpdater(this.allCellList, i, k).getUpdatedStatus());

			}

		}
	}

	void makeTemporaryCopyOfCells() {

		this.temporaryCellCloneList = this.allCellList;

	}

}
