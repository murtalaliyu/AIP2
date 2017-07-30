public class Cell {

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
	int numSearched;
	
	public Cell(boolean right, boolean bottom, boolean top, boolean left,
		boolean target, String status, double priorBelief, double falseNegative,
		double falsePositive, double currentBelief, int numSearched) {
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
		this.numSearched = numSearched;
	}
}
