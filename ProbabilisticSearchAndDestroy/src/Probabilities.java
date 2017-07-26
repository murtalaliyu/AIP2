public class Probabilities {

	static double priorBelief = 0;
	
	//ASSIGN PRIOR BELIEFS
	public static Cell[][] pOfTargetInCelli(Cell[][] map, int row, int col) {
		//in our prior belief, each cell has equal probability of containing our target
		priorBelief = (double) (1 / (double)(row*col));
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				map[i][j].priorBelief = priorBelief;
			}
		}
		return map;
	}
	
	//PRINT PRIOR BELIEF
	public static void printPriorBelief(Cell[][] map, int row, int col) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(map[i][j].priorBelief + "   ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
