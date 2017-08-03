import java.util.ArrayList;

public class Rules {
	
	//Our rule: BETWEEN CELLS WITH THE LOWEST FALSE NEGATIVE & HIGHEST CURRENT BELIEF, PICK THE LEAST SEARCHED AND SEARCH IT
	public static Cell[][] ourRule(Cell[][] map) {
		boolean result = false;
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
					if (map[i][j].currentBelief > highestCurrBel.currentBelief) {
						highestCurrBel = map[i][j];
						cbi_index = i;
						cbj_index = j;
					}
				}
			}
			if (lowestFalseNeg.timesSearched <= highestCurrBel.timesSearched) {
				nextCell = lowestFalseNeg;
				r = fni_index; c = fnj_index;
			} else {
				nextCell = highestCurrBel;
				r = cbi_index; c = cbj_index;
			}
			
			//search nextCell
			result = Search.searchTerrain(nextCell);
			numSearches++;
			
			//print statements one
			printStatementsOne(numSearches, r, c, result, nextCell);
			
			//update nextCell's current belief
			map = Probabilities.updateCurrentBelief(map, nextCell);
			//normalize all other cells
			map = Normalize.normalizeMap(map, nextCell);
			
			//print statements two
			printStatementsTwo(map, numSearches);
		} while (result == false);
		
		//for really large maps
		System.out.println("final analysis:");
		printStatementsOne(numSearches, r, c, result, nextCell);
		return map;
	}
	
	//Rule 1: AT ANY TIME, SEARCH THE CELL WITH THE HIGHEST PROBABILITY OF CONTAINING THE TARGET.
	public static Cell[][] ruleOne(Cell[][] map) {
		boolean result = false;
		Cell nextCell = map[0][0];
		int r = 0, c = 0;
		int numSearches = 0;
		
		do {
			//find the next cell to be searched (Rule 1: make nextCell the cell with highest current belief)
			for (int i = 0; i < Main.row; i++) {
				for (int j = 0; j < Main.col; j++) {
					if (map[i][j].currentBelief > nextCell.currentBelief) {
						nextCell = map[i][j];
						r = i; c = j;
					} 
				}
			}
			
			//search nextCell
			result = Search.searchTerrain(nextCell);
			numSearches++;
			
			//print statements one
			printStatementsOne(numSearches, r, c, result, nextCell);
			
			//update nextCell's current belief
			map = Probabilities.updateCurrentBelief(map, nextCell);
			//normalize all other cells
			map = Normalize.normalizeMap(map, nextCell);
			
			//print statements two
			printStatementsTwo(map, numSearches);
		} while (result == false);
		
		//for really large maps
		System.out.println("final analysis:");
		printStatementsOne(numSearches, r, c, result, nextCell);
		return map;
	}
			
	// incomplete --> Rule 2: AT ANY TIME, SEARCH THE CELL WITH THE HIGHEST PROBABILITY OF FINDING THE TARGET.   
	public static Cell[][] ruleTwo(Cell[][] map) {
		boolean result = false;
		Cell nextCell = map[0][0];
		int r = 0, c = 0;
		int numSearches = 0;
		ArrayList<Cell> list = new ArrayList<Cell>();
		
		do {
			//find the next cell to be searched (Rule 2: search from lowest to highest false negative rate. if you've searched all in a cycle, clear list and repeat)
			//ERROR
			for (int i = 0; i < Main.row; i++) {
				for (int j = 0; j < Main.col; j++) {
					if (map[i][j].falseNegative < nextCell.falseNegative && !list.contains(map[i][j])) {
						nextCell = map[i][j];
						r = i; c = j;
						list.add(map[i][j]);
					}
				}
			}
			list.clear();
			
			//search nextCell
			result = Search.searchTerrain(nextCell);
			numSearches++;
			
			//print statements one
			printStatementsOne(numSearches, r, c, result, nextCell);
			
			//update nextCell's current belief
			map = Probabilities.updateCurrentBelief(map, nextCell);
			//normalize all other cells
			map = Normalize.normalizeMap(map, nextCell);
			
			//print statements two
			printStatementsTwo(map, numSearches);
		} while (result == false);
		
		//for really large maps
		System.out.println("final analysis:");
		printStatementsOne(numSearches, r, c, result, nextCell);
		return map;
	}
	
	//incomplete --> Question 4: 
	public static Cell[][] questionFour(Cell[][] map) {
		return map;
	}

	/* ---------------------------------------------------------------
	 *                                                                |
	 * PRINT FUNCTIONS START HERE                                     |      
	 *                                                                |
	 *----------------------------------------------------------------
	 */
	
	//PRINT STATEMENTS ONE
	public static void printStatementsOne(int numSearches, int r, int c, boolean result, Cell nextCell) {
		//PRINT STATEMENTS/////////////////////////////////////////////////////////////////////////
		//print number of searches after each iteration
		System.out.println("number of cells searched: " + numSearches);
		//print cell index searched
		System.out.println("cell at row " + r + " and column " + c + " was searched. the terrain type in this cell is " + Main.map[r][c].status);
		//print result
		System.out.println("result: " + result);
		//print # of times this cell has been searched
		System.out.println("# of times this cell has been searched: " + nextCell.timesSearched);
		////////////////////////////////////////////////////////////////////////////////////////////
	}
	
	//PRINT STATEMENTS TWO
	public static void printStatementsTwo(Cell[][] map, int numSearches) {
		//PRINT STATEMENTS//////////////////////////////////////////////////////////////////////
		//print observation over time t
		System.out.println("probability of observations up to time t = " + numSearches + ": " 
				+ Probabilities.observation);
		//print prior belief after each iteration
		Probabilities.printPriorBelief(map);
		//print current belief after each iteration
		Probabilities.printCurrentBelief(map);
		System.out.println("---------------------------------------------------------------"
				+ "------------------------");
		////////////////////////////////////////////////////////////////////////////////////////
	}
}
