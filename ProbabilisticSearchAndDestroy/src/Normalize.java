public class Normalize {

	static double normFactor = 0;
	
	//NORMALIZE AFTER CHANGING A PARTICULAR CELL's CURRENT BELIEF
	public static Cell[][] normalizeMap(Cell[][] map, Cell cell) {
		//double b = 1 - cell.currentBelief;	<-- (thought... why doesn't this work?)
		//get B
		double b = 0;
		for (int i = 0; i < Main.row; i++) {
			for (int j = 0; j < Main.col; j++) {
				b += map[i][j].currentBelief;
			}
		}
		for (int i = 0; i < Main.row; i++) {
			for (int j = 0; j < Main.col; j++) {
				if (!cell.equals(map[i][j])) {
					map[i][j].priorBelief = map[i][j].currentBelief;
					map[i][j].currentBelief /= b;
				}
			}
		}
		return map;
	}
}
