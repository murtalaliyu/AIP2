
public class Normalize {

	//POSSIBLE ERROR: do we just distribute equally?
	public static Cell[][] normalizeMap(Cell[][] map, Cell cell, double whatItWas, double whatItIs) {
		
		double remainder = 1-whatItIs;	//all other probabilities have to add up to the distributor
		double difference = Math.abs(whatItWas - whatItIs);	
		double numCells = (double) Main.row * Main.col;
		double distributor = difference/numCells-1;
		
		for (int i = 0; i < Main.row; i++) {
			for (int j = 0; j < Main.col; j++) {
				if (!cell.equals(map[i][j])) {
					cell.currentBelief += distributor;
				}
			}
		}
		return map;
	}
}
