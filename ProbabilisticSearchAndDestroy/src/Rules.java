public class Rules {
	
	//Our rule: BETWEEN CELLS WITH THE LOWEST FALSE NEGATIVE & HIGHEST CURRENT BELIEF, PICK THE LEAST SEARCHED AND SEARCH IT
	public static Cell[][] ourRule(Cell[][] map) {
		boolean result = false;
		Cell previousCell = map[0][0];
		Cell nextCell = map[0][0];
		int fni_index = 0, fnj_index = 0;
		int cbi_index = 0, cbj_index = 0;
		int r = 0, c = 0;
		int numSearches = 0;
		do {
			//find the next cell to be searched
			Cell lowestFalseNeg = map[0][0];
			Cell highestCurrBel = map[0][0];
			for (int i = 0; i < Main.row; i++) {
				for (int j = 0; j < Main.col; j++) {
					if (map[i][j].falseNegative < lowestFalseNeg.falseNegative) {
						lowestFalseNeg = map[i][j];
						fni_index = i;
						fnj_index = j;
					} 
					if (map[i][j].currentBelief > lowestFalseNeg.currentBelief) {
						highestCurrBel = map[i][j];
						cbi_index = i;
						cbj_index = j;
					}
				}
			}
			if (lowestFalseNeg.timesSearched <= highestCurrBel.timesSearched) {
				previousCell = nextCell;
				nextCell = lowestFalseNeg;
				r = fni_index; c = fnj_index;
			} else {
				previousCell = nextCell;
				nextCell = highestCurrBel;
				r = cbi_index; c = cbj_index;
			}
			
			//search nextCell
			result = Search.searchTerrain(nextCell);
			numSearches++;
			//print number of searches after each iteration
			System.out.println("number of cells searched: " + numSearches);
			//print cell index searched
			System.out.println("cell at row " + r + " and column " + c + " was searched.");
			//print result
			System.out.println("result: " + result);
			//print # of times this cell has been searched
			System.out.println("# of times this cell has been searched: " + nextCell.timesSearched);
			//update nextCell's current belief
			map = Probabilities.updateCurrentBelief(map, nextCell, previousCell);
			//normalize all other cells
			map = Normalize.normalizeMap(map, nextCell);
			
			System.out.println("probability of observations up to time t = " + numSearches + ": " + Probabilities.observation);
			//print prior belief after each iteration
			Probabilities.printPriorBelief(map);
			//print current belief after each iteration
			Probabilities.printCurrentBelief(map);
			
			System.out.println("---------------------------------------------------------------------------------------");
		} while (result == false);
		return map;
	}
	
	// incomplete --> Rule 1: AT ANY TIME, SEARCH THE CELL WITH THE HIGHEST PROBABILITY OF CONTAINING THE TARGET.
	public static Cell[][] ruleOne(Cell[][] map) {
		boolean result = false;
		Cell previousCell = map[0][0];
		Cell nextCell = map[0][0];
		int r = 0, c = 0;
		int numSearches = 0;
		do {
			//find the next cell to be searched (Rule 1: make nextCell the cell with highest current belief)
			for (int i = 0; i < Main.row; i++) {
				for (int j = 0; j < Main.col; j++) {
					if (map[i][j].currentBelief > nextCell.currentBelief) {
						previousCell = nextCell;
						nextCell = map[i][j];
						r = i; c = j;
					} 
				}
			}
			
			//search nextCell
			result = Search.searchTerrain(nextCell);
			numSearches++;
			//print number of searches after each iteration
			System.out.println("number of cells searched: " + numSearches);
			//print cell index searched
			System.out.println("cell at row " + r + " and column " + c + " was searched.");
			//print result
			System.out.println("result: " + result);
			//print # of times this cell has been searched
			System.out.println("# of times this cell has been searched: " + nextCell.timesSearched);
			//update nextCell's current belief
			map = Probabilities.updateCurrentBelief(map, nextCell, previousCell);
			//normalize all other cells
			map = Normalize.normalizeMap(map, nextCell);
			
			System.out.println("probability of observations up to time t = " + numSearches + ": " + Probabilities.observation);
			//print prior belief after each iteration
			Probabilities.printPriorBelief(map);
			//print current belief after each iteration
			Probabilities.printCurrentBelief(map);
			
			System.out.println("---------------------------------------------------------------------------------------");
		} while (result == false);
		return map;
	}
			
	// incomplete --> Rule 2: AT ANY TIME, SEARCH THE CELL WITH THE HIGHEST PROBABILITY OF FINDING THE TARGET.   
	public static Cell[][] ruleTwo(Cell[][] map) {
		boolean result = false;
		Cell previousCell = map[0][0];
		Cell nextCell = map[0][0];
		int r = 0, c = 0;
		int numSearches = 0;
		do {
			//find the next cell to be searched (Rule 2: ...)
			/* CODE GOES HERE*/
			
			//search nextCell
			result = Search.searchTerrain(nextCell);
			numSearches++;
			//print number of searches after each iteration
			System.out.println("number of cells searched: " + numSearches);
			//print cell index searched
			System.out.println("cell at row " + r + " and column " + c + " was searched.");
			//print result
			System.out.println("result: " + result);
			//print # of times this cell has been searched
			System.out.println("# of times this cell has been searched: " + nextCell.timesSearched);
			//update nextCell's current belief
			map = Probabilities.updateCurrentBelief(map, nextCell, previousCell);
			//normalize all other cells
			map = Normalize.normalizeMap(map, nextCell);
			
			System.out.println("probability of observations up to time t = " + numSearches + ": " + Probabilities.observation);
			//print prior belief after each iteration
			Probabilities.printPriorBelief(map);
			//print current belief after each iteration
			Probabilities.printCurrentBelief(map);
			
			System.out.println("---------------------------------------------------------------------------------------");
		} while (result == false);
		return map;
	}
	
	//incomplete --> Question 4: 
	public static Cell[][] questionFour(Cell[][] map) {
		return map;
	}
}
