public class Node {

	boolean right;
	boolean bottom;
	boolean top;
	boolean left;
	boolean target;
	String status;
	
	public Node(boolean right, boolean bottom, boolean top, boolean left, boolean target, String status) {
		this.right = right;
		this.bottom = bottom;
		this.top = top;
		this.left = left;
		this.target = target;
		this.status = status;
	}
}
