public class Normalize {

	static double normFactor = 0;
	
	//NORMALIZE AFTER CHANGING A PARTICULAR CELL's CURRENT BELIEF
	//PROBABLE ERROR
	public static Cell[][] normalizeMap(Cell[][] map, Cell cell, double whatItWas, double whatItIs) {
		//System.out.println("we entered Normalize.normalizeMap");
		double difference = Math.abs(whatItWas - whatItIs);
		System.out.println("difference: " + difference);
		double numCells = (double) (Main.row * Main.col)-1;
		//System.out.println("number of cells to update: " + numCells);
		normFactor = difference/numCells;
		//System.out.println("normalization factor: " + normFactor);
		
		for (int i = 0; i < Main.row; i++) {
			for (int j = 0; j < Main.col; j++) {
				if (!cell.equals(map[i][j])) {
					map[i][j].currentBelief += map[i][j].currentBelief*normFactor;	//ERROR?: just multiply? or multiply, then add?
				}
			}
		}
		//System.out.println("we left Normalize.normalizeMap");
		return map;
	}
}
