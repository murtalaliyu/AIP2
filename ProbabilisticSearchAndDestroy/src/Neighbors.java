public class Neighbors {

	//ASSIGN NEIGHBORS
	public static Cell[][] assignNeighbors(Cell[][] map) {
		for (int i = 0; i < Main.row; i++) {
			for (int j = 0; j < Main.col; j++) {
				if (j+1 < Main.col) {
					map[i][j].right = true;
				} 
				if (i+1 < Main.row) {
					map[i][j].bottom = true;
				}
				if (i-1 >= 0) {
					map[i][j].top = true;
				}
				if (j-1 >= 0) {
					map[i][j].left = true;
				}
			}
		}
		return map;
	}
	
	public static boolean isValidRightNeighbor(Cell cell) {
		if (cell.right) {
			return true;
		}
		return false;
	}
	
	public static boolean isValidBottomNeighbor(Cell cell) {
		if (cell.bottom) {
			return true;
		}
		return false;
	}
	
	public static boolean isValidTopNeighbor(Cell cell) {
		if (cell.top) {
			return true;
		}
		return false;
	}
	
	public static boolean isValidLeftNeighbor(Cell cell) {
		if (cell.left) {
			return true;
		}
		return false;
	}
}
