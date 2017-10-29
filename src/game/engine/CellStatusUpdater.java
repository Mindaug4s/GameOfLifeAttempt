package game.engine;

import java.util.Arrays;
import java.util.List;

public class CellStatusUpdater {

	private TheCell[][] allCellList;
	private int currentCellRowNumber;
	private int currentCellColumnNumber;
	private int numberOfAliveNeighbourCells;

	public CellStatusUpdater(TheCell[][] allCellList, int currentCellrowNumber, int currentCellcolumnNumber) {

		this.allCellList = allCellList;
		this.currentCellRowNumber = currentCellrowNumber;
		this.currentCellColumnNumber = currentCellcolumnNumber;
	}

	public boolean getUpdatedStatus() {

		boolean cellFinalStatus = false;

		boolean statusOfCurrentCell = allCellList[currentCellRowNumber][currentCellColumnNumber].getCellLifeStatus();
		countAliveNeighbourCells();

		if (statusOfCurrentCell == true && (numberOfAliveNeighbourCells == 2 || numberOfAliveNeighbourCells == 3)) {
			cellFinalStatus = true;
		}

		if (statusOfCurrentCell == false && numberOfAliveNeighbourCells == 3) {
			cellFinalStatus = true;
		}

		return cellFinalStatus;
	}

	private void countAliveNeighbourCells() {
		List<Boolean> neighbourCellStatusList = Arrays.asList(getStatusOfWesternCell(), getStatusOfEasternCell(),
				getStatusOfNorthernCell(), getStatusOfSouthernCell(), getStatusOfNorthWesternCell(),
				getStatusOfNorthEasternCell(), getStatusOfSouthEasternCell(), getStatusOfSouthWesternCell());

		this.numberOfAliveNeighbourCells = (int) neighbourCellStatusList.stream()
				.filter((x -> x.booleanValue() == true)).count();

	}

	private boolean getStatusOfWesternCell() {
		boolean cellStatus = false;

		try {
			cellStatus = allCellList[currentCellRowNumber][currentCellColumnNumber - 1].getCellLifeStatus();
		} catch (IndexOutOfBoundsException e) {

		}

		return cellStatus;

	}

	private boolean getStatusOfEasternCell() {

		boolean cellStatus = false;

		try {
			cellStatus = allCellList[currentCellRowNumber][currentCellColumnNumber + 1].getCellLifeStatus();
		} catch (IndexOutOfBoundsException e) {

		}

		return cellStatus;

	}

	private boolean getStatusOfNorthernCell() {

		boolean cellStatus = false;

		try {
			cellStatus = allCellList[currentCellRowNumber - 1][currentCellColumnNumber].getCellLifeStatus();
		} catch (IndexOutOfBoundsException e) {

		}

		return cellStatus;

	}

	private boolean getStatusOfSouthernCell() {

		boolean cellStatus = false;

		try {
			cellStatus = allCellList[currentCellRowNumber + 1][currentCellColumnNumber].getCellLifeStatus();
		} catch (IndexOutOfBoundsException e) {

		}

		return cellStatus;

	}

	private boolean getStatusOfNorthWesternCell() {

		boolean cellStatus = false;

		try {
			cellStatus = allCellList[currentCellRowNumber - 1][currentCellColumnNumber - 1].getCellLifeStatus();
		} catch (IndexOutOfBoundsException e) {

		}

		return cellStatus;

	}

	private boolean getStatusOfNorthEasternCell() {

		boolean cellStatus = false;

		try {
			cellStatus = allCellList[currentCellRowNumber - 1][currentCellColumnNumber + 1].getCellLifeStatus();
		} catch (IndexOutOfBoundsException e) {

		}

		return cellStatus;

	}

	private boolean getStatusOfSouthEasternCell() {

		boolean cellStatus = false;

		try {
			cellStatus = allCellList[currentCellRowNumber + 1][currentCellColumnNumber + 1].getCellLifeStatus();
		} catch (IndexOutOfBoundsException e) {

		}

		return cellStatus;

	}

	private boolean getStatusOfSouthWesternCell() {

		boolean cellStatus = false;

		try {
			cellStatus = allCellList[currentCellRowNumber + 1][currentCellColumnNumber - 1].getCellLifeStatus();
		} catch (IndexOutOfBoundsException e) {

		}

		return cellStatus;

	}

}
