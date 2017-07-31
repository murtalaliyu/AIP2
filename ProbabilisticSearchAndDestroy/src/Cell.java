public class Cell {
	int row;
	int col;
	boolean right;
	boolean bottom;
	boolean top;
	boolean left;
	boolean target;
	String status;
	double priorBelief;
	double falseNegative;
	double falsePositive;
	double currentBelief;
	int timesSearched;
	
	public Cell(int row, int col, boolean right, boolean bottom, boolean top, boolean left,
		boolean target, String status, double priorBelief, double falseNegative,
		double falsePositive, double currentBelief, int timesSearched) {
		this.row = row;
		this.col = col;
		this.right = right;
		this.bottom = bottom;
		this.top = top;
		this.left = left;
		this.target = target;
		this.status = status;
		this.priorBelief = priorBelief;
		this.falseNegative = falseNegative;
		this.falsePositive = falsePositive;
		this.currentBelief = currentBelief;
		this.timesSearched = timesSearched;
	}
}
