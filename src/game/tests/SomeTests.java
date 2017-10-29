package game.tests;

import java.util.Arrays;
import java.util.List;

public class SomeTests {

	public static void main(String[] args) {

		List<Boolean> neighbourCellStatusList = Arrays.asList(true, false, false, true, false, false);

		int numberOfAliveNeighbourCells = (int) neighbourCellStatusList.stream()
				.filter((x -> x.booleanValue() == false)).count();

		 System.out.println(numberOfAliveNeighbourCells);
		getUpdatedStatus(true, 2);

	}

	public static void getUpdatedStatus(boolean statusOfCurrentCell, int numberOfAliveNeighbourCells) {

		boolean cellFinalStatus = false;

		if (statusOfCurrentCell == true && (numberOfAliveNeighbourCells == 2 || numberOfAliveNeighbourCells == 3)) {
			cellFinalStatus = true;
		}

		if (statusOfCurrentCell == false && numberOfAliveNeighbourCells == 3) {
			cellFinalStatus = true;
		}
		System.out.println(cellFinalStatus);

	}

}
