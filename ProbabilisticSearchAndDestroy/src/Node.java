public class Node {

	Node right;
	Node bottom;
	Node top;
	Node left;
	boolean target;
	String status;
	
	public Node(Node right, Node bottom, Node top, Node left, boolean target, String status) {
		
		this.right = right;
		this.bottom = bottom;
		this.top = top;
		this.left = left;
		this.target = target;
		this.status = status;
	}
}
