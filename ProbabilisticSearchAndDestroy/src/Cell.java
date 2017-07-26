public class Cell {

	boolean right;
	boolean bottom;
	boolean top;
	boolean left;
	boolean target;
	String status;
	double priorBelief;
	double falsePositive;
	
	public Cell(boolean right, boolean bottom, boolean top, boolean left, boolean target, String status, double priorBelief, double falsePositive) {
		this.right = right;
		this.bottom = bottom;
		this.top = top;
		this.left = left;
		this.target = target;
		this.status = status;
		this.priorBelief = priorBelief;
		this.falsePositive = falsePositive;
	}
}
