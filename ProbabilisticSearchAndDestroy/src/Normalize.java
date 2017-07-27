public class Normalize {

	//NORMALIZE AFTER CHANGING A PARTICULAR CELL's CURRENT BELIEF
	public static Cell[][] normalizeMap(Cell[][] map, Cell cell, double whatItWas, double whatItIs) {
		
		double difference = Math.abs(whatItWas - whatItIs);	
		double numCells = (double) Main.row * Main.col;
		double distributor = difference/(numCells-1);
		
		for (int i = 0; i < Main.row; i++) {
			for (int j = 0; j < Main.col; j++) {
				if (!cell.equals(map[i][j])) {
					map[i][j].currentBelief *= distributor;
				}
			}
		}
		return map;
	}
}
