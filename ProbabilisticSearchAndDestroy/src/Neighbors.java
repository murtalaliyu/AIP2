public class Neighbors {

	public static Cell[][] assignNeighbors(Cell[][] map) {
		for (int i = 0; i < Main.row; i++) {
			for (int j = 0; j < Main.col; j++) {
				if (i == 0 && j == 0) {								//top left cell
					map[i][j].right = true;
					map[i][j].bottom = true;
				} else if (i == 0 && j == Main.col-1) {				//top right cell
					map[i][j].bottom = true;
					map[i][j].left = true;
				} else if (i == Main.row-1 && j == 0) {				//bottom left cell
					map[i][j].top = true;
					map[i][j].right = true;
				} else if (i == Main.row-1 && j == Main.col-1) {	//bottom right cell
					map[i][j].top = true;
					map[i][j].left = true;
				} else if (i == 0 & j < Main.col-1) {				//top cell
					map[i][j].bottom = true;
					map[i][j].right = true;
					map[i][j].left = true;
				} else if (i < Main.row-1 && j == Main.col-1) {		//right cell
					map[i][j].bottom = true;
					map[i][j].top = true;
					map[i][j].left = true;
				} else if (i == Main.row-1 && j < Main.col-1) {		//bottom cell
					map[i][j].top = true;
					map[i][j].right = true;
					map[i][j].left = true;
				} else if (i < Main.row-1 && j == 0) {				//left cell
					map[i][j].right = true;
					map[i][j].top = true;
					map[i][j].bottom = true;
				} else {											//middle cell
					map[i][j].right = true;
					map[i][j].bottom = true;
					map[i][j].top = true;
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
