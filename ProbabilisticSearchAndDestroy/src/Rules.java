public class Rules {
	
	//FIND THE CELL WITH THE LOWEST FALSE NEGATIVE & HIGHEST CURRENT BELIEF AND SEARCH IT
	public static void ourRule(Cell[][] map) {

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
			if (lowestFalseNeg.numSearched < highestCurrBel.numSearched) {
				previousCell = nextCell;
				nextCell = lowestFalseNeg;
				r = fni_index; c = fnj_index;
			} else {
				previousCell = nextCell;
				nextCell = highestCurrBel;
				r = cbi_index; c = cbj_index;
			}
			if (previousCell.numSearched == 0 && nextCell.numSearched == 0) {
				previousCell = nextCell;
			}
			
			//search nextCell
			result = Search.searchTerrain(nextCell);
			numSearches++;
			//update nextCell's current belief
			map = Probabilities.updateCurrentBelief(map, nextCell, previousCell);
			//normalize all other cells
			map = Normalize.normalizeMap(map, nextCell, nextCell.priorBelief, nextCell.currentBelief);
			
			//print number of searches after each iteration
			System.out.println("number of searches: " + numSearches);
			//print cell index searched
			System.out.println("cell at row " + r + " and column " + c + " was searched." + "\n");
			//print result
			System.out.println(result);
			//print current belief after each iteration
			Probabilities.printCurrentBelief(map);
			
		} while (result == false);
		
		//print map with the location of the target
		Map.printTarget(map);
	}
}
