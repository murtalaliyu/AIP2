public class Probabilities {
	
	static double priorBelief = 0;
	static double observations = 1;
	
	//ASSIGN FALSE POSITIVE P(Target Found In Celli | Target Not In Celli) <-- this is always 0 for all cells
	public static Cell[][] falsePositive(Cell[][] map) {
		for (int i = 0; i < Main.row; i++) {
			for (int j = 0; j < Main.col; j++) {
				map[i][j].falsePositive = 0;
			}
		}
		return map;
	}
	
	//ASSIGN FALSE NEGATIVE P(Target Not Found In Celli | Target Is In Celli)
	public static Cell[][] falseNegative(Cell[][] map) {
		for (int i = 0; i < Main.row; i++) {
			for (int j = 0; j < Main.col; j++) {
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
	
	//ASSIGN PRIOR BELIEF P(Target In Celli)
	public static Cell[][] priorBelief(Cell[][] map) {
		//in our prior belief, each cell has equal probability of containing our target
		priorBelief = (double) (1 / (double)(Main.row*Main.col));
		for (int i = 0; i < Main.row; i++) {
			for (int j = 0; j < Main.col; j++) {
				map[i][j].priorBelief = priorBelief;
				map[i][j].currentBelief = priorBelief;
			}
		}
		return map;
	}
	
	//UPDATE OBSERVATIONS 
	public static double updateObservation(Cell cell) {
		observations = observations * cell.falseNegative;
		return observations;
	}
	
	//P(fail j | obs_t)
	public static double failureGivenObs(Cell[][] map, Cell previousCell) {
		double prob = 0;
		for (int i = 0; i < Main.row; i++) {
			for (int j = 0; j < Main.col; j++) {
				prob += (previousCell.falseNegative * map[i][j].currentBelief) / observations;
			}
		}
		return prob;
	}
	
	//P(target in cell i | obs_t ^ fail j)
	public static double targetInIGivenObsAndFailJ(Cell nextCell, Cell previousCell) {
		double prob = 0;
		if (nextCell.equals(previousCell)) {
			prob = nextCell.falseNegative;
			return prob;
		} else {
			prob = 1;
			return prob;
		}
	}
	
	//ASSIGN CURRENT BELIEF Belief[Celli] = P(Target In Celli | Observations Through Time t)
	public static Cell[][] updateCurrentBelief(Cell[][] map, Cell nextCell, Cell previousCell) {
		nextCell.priorBelief = nextCell.currentBelief;
		nextCell.currentBelief = (nextCell.currentBelief * targetInIGivenObsAndFailJ(nextCell, previousCell)) / failureGivenObs(map, previousCell);
		return map;
	}
	
	//PRINT PRIOR BELIEF
	public static void printPriorBelief(Cell[][] map) {
		System.out.println("Prior belief: ");
		for (int i = 0; i < Main.row; i++) {
			for (int j = 0; j < Main.col; j++) {
				System.out.print(map[i][j].priorBelief + "   ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	//PRINT FALSE NEGATIVE
	public static void printFalseNegative(Cell[][] map) {
		System.out.println("False negative: ");
		for (int i = 0; i < Main.row; i++) {
			for (int j = 0; j < Main.col; j++) {
				System.out.print(map[i][j].falseNegative + "   ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	//PRINT FALSE POSITIVE
	public static void printFalsePositive(Cell[][] map) {
		System.out.println("False positive: ");
		for (int i = 0; i < Main.row; i++) {
			for (int j = 0; j < Main.col; j++) {
				System.out.print(map[i][j].falsePositive + "   ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	//PRINT CURRENT BELIEF
	public static void printCurrentBelief(Cell[][] map) {
		System.out.println("Current belief: ");
		for (int i = 0; i < Main.row; i++) {
			for (int j = 0; j < Main.col; j++) {
				System.out.print(map[i][j].currentBelief + "   ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
