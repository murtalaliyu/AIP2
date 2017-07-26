public class Neighbors {

	public static Node[][] assignNeighbors(Node[][] map, int row, int col) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (i == 0 && j == 0) {					//top left cell
					map[i][j].right = true;
					map[i][j].bottom = true;
				} else if (i == 0 && j == col-1) {		//top right cell
					map[i][j].bottom = true;
					map[i][j].left = true;
				} else if (i == row-1 && j == 0) {		//bottom left cell
					map[i][j].top = true;
					map[i][j].right = true;
				} else if (i == row-1 && j == col-1) {	//bottom right cell
					map[i][j].top = true;
					map[i][j].left = true;
				} else if (i == 0 & j < col-1) {		//top side
					map[i][j].bottom = true;
					map[i][j].right = true;
					map[i][j].left = true;
				} else if (i < row-1 && j == col-1) {	//right side
					map[i][j].bottom = true;
					map[i][j].top = true;
					map[i][j].left = true;
				} else if (i == row-1 && j < col-1) {	//bottom side
					map[i][j].top = true;
					map[i][j].right = true;
					map[i][j].left = true;
				} else if (i < row-1 && j == 0) {		//left side
					map[i][j].right = true;
					map[i][j].top = true;
					map[i][j].bottom = true;
				} else {								//middle cell
					map[i][j].right = true;
					map[i][j].bottom = true;
					map[i][j].top = true;
					map[i][j].left = true;
				}
			}
		}
		return map;
	}
	
	public static boolean isValidRightNeighbor(Node node) {
		if (node.right) {
			return true;
		}
		return false;
	}
	
	public static boolean isValidBottomNeighbor(Node node) {
		if (node.bottom) {
			return true;
		}
		return false;
	}
	
	public static boolean isValidTopNeighbor(Node node) {
		if (node.top) {
			return true;
		}
		return false;
	}
	
	public static boolean isValidLeftNeighbor(Node node) {
		if (node.left) {
			return true;
		}
		return false;
	}
}
