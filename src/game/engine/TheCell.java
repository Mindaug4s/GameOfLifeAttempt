package game.engine;

public class TheCell {

	private boolean isCellAlive = false;

	public TheCell() {

	}

	public TheCell(boolean isCellAlive) {

		this.isCellAlive = isCellAlive;

	}

	public void makeCellAlive() {
		this.isCellAlive = true;

	}

	public void makeCellDead() {
		this.isCellAlive = false;

	}

	public boolean getCellLifeStatus() {
		return this.isCellAlive;
	}

	public void setCellLiveStatus(boolean isCellAlive) {
		this.isCellAlive = isCellAlive;
	}

}
