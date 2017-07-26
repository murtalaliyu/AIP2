public class Probabilities {

	static double priorBelief = 0;
	
	//ASSIGN PRIOR BELIEF P(Target In Celli)
	public static Cell[][] priorBelief(Cell[][] map, int row, int col) {
		//in our prior belief, each cell has equal probability of containing our target
		priorBelief = (double) (1 / (double)(row*col));
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				map[i][j].priorBelief = priorBelief;
			}
		}
		return map;
	}
	
	//ASSIGN FALSE NEGATIVE P(Target Not Found In Celli | Target Is In Celli)
	public static Cell[][] falseNegative(Cell[][] map, int row, int col) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if ("FL".equals(map[i][j].status)) {
					map[i][j].falseNegative = 0.2;
				} else if ("HI".equals(map[i][j].status)) {
					map[i][j].falseNegative = 0.4;
				} else if ("FO".equals(map[i][j].status)) {
					map[i][j].falseNegative = 0.6;
				} else if ("CM".equals(map[i][j].status)) {
					map[i][j].falseNegative = 0.9;
				}
			}
		}
		return map;
	}
	
	//ASSIGN FALSE POSITIVE P(Target Found In Celli | Target Not In Celli) <-- this is always 0 for all cells
	public static Cell[][] falsePositive(Cell[][] map, int row, int col) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				map[i][j].falsePositive = 0;
			}
		}
		return map;
	}
	
	//ASSIGN CURRENT BELIEF <-- incomplete
	public static Cell[][] currentBelief(Cell[][] map, int row, int col) {
		return map;
	}
	
	//PRINT PRIOR BELIEF
	public static void printPriorBelief(Cell[][] map, int row, int col) {
		System.out.println("Prior belief: ");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(map[i][j].priorBelief + "   ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	//PRINT FALSE NEGATIVE
	public static void printFalseNegative(Cell[][] map, int row, int col) {
		System.out.println("False negative: ");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(map[i][j].falseNegative + "   ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	//PRINT FALSE POSITIVE
	public static void printFalsePositive(Cell[][] map, int row, int col) {
		System.out.println("False positive: ");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(map[i][j].falsePositive + "   ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	//PRINT CURRENT BELIEF <-- incomplete
	public static void printCurrentBelief(Cell[][] map, int row, int col) {
		System.out.println("Current belief: ");
		
	}
}
