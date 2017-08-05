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
			
	//Rule 2: AT ANY TIME, SEARCH THE CELL WITH THE HIGHEST PROBABILITY OF FINDING THE TARGET.   
	public static Cell[][] ruleTwo(Cell[][] map) {
		boolean result = false;
		Cell nextCell = map[0][0];
		int r = 0, c = 0;
		int numSearches = 0;
		int search = 0;
		ArrayList<Cell> list = new ArrayList<Cell>();
		
		do {
			//find the next cell to be searched (Rule 2: search from lowest to highest false negative rate. if you've searched all in a cycle, clear list and repeat)
			if (list.isEmpty()) {
				System.out.println("list has been refilled");
				list = refillList(map);
			} 
			//print list details
			printList(list);
			System.out.println("size of list: " + list.size());
			
			//always get the first cell in the list (it has the lowest false negative)
			nextCell = list.get(search);
			list.remove(search);
			r = nextCell.row; c = nextCell.col;
			
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
	
	//RULE 2 HELPER FUNCTION: REFILLS LIST
	public static ArrayList<Cell> refillList(Cell[][] map) {
		ArrayList<Cell> list = new ArrayList<Cell>();
		for (int i = 0; i < Main.row; i++) {
			for (int j = 0; j < Main.col; j++) {
				if (map[i][j].falseNegative == 0.2) {
					list.add(map[i][j]);
					map[i][j].timesSearched++;
				}
			}
		}
		for (int i = 0; i < Main.row; i++) {
			for (int j = 0; j < Main.col; j++) {
				if (map[i][j].falseNegative == 0.4) {
					list.add(map[i][j]);
					map[i][j].timesSearched++;
				}
			}
		}
		for (int i = 0; i < Main.row; i++) {
			for (int j = 0; j < Main.col; j++) {
				if (map[i][j].falseNegative == 0.6) {
					list.add(map[i][j]);
					map[i][j].timesSearched++;
				}
			}
		}
		for (int i = 0; i < Main.row; i++) {
			for (int j = 0; j < Main.col; j++) {
				if (map[i][j].falseNegative == 0.9) {
					list.add(map[i][j]);
					map[i][j].timesSearched++;
				}
			}
		}
		return list;
	}
	
	//incomplete --> Question 4: 
	public static Cell[][] questionFour(Cell[][] map) {
		boolean result = false;
		Cell nextCell = map[0][0];
		int r = 0, c = 0;
		int numSearches = 0;
		int max = (Main.row-1) + (Main.col-1);
		
		do {
			//find the next cell to be searched 
			//ERROR HERE
 			for (int i = 0; i < Main.row; i++) {
 				for (int j = 0; j < Main.col; j++) {
 					Cell adj = highestCurrBel(map[i][j]);
 					if ((map[i][j].currentBelief - adj.currentBelief) > (max/(Main.row*Main.col))) {
 						nextCell = map[i][j];
 						r = map[i][j].row; c = map[i][j].col;
 					} else {
 						nextCell = adj;
 						r = adj.row; c = adj.col;
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
	
	//QUESTION 4 HELPER FUNCTION: FINDS THE NEIGHBOR WITH THE HIGHEST CURRENT BELIEF
	public static Cell highestCurrBel(Cell cell) {
		Cell highestNeighCell = new Cell(0,0,false,false,false,false,false,"-",0,0,0,0,0);
		//System.out.println("cell at row " + cell.row + " and column " + cell.col + " was pushed");
		//System.out.println("cell.right: " + cell.right);
		if (cell.right) {
			if (Main.map[cell.row][cell.col+1].currentBelief > highestNeighCell.currentBelief) {
				highestNeighCell = Main.map[cell.row][cell.col+1];
			}
		}
		//System.out.println("cell.bottom: " + cell.bottom);
		if (cell.bottom) {
			if (Main.map[cell.row+1][cell.col].currentBelief > highestNeighCell.currentBelief) {
				highestNeighCell = Main.map[cell.row+1][cell.col];
			}
		}
		//System.out.println("cell.top: " + cell.top);
		if (cell.top) {
			if (Main.map[cell.row-1][cell.col].currentBelief > highestNeighCell.currentBelief) {
				highestNeighCell = Main.map[cell.row-1][cell.col];
			}
		}
		//System.out.println("cell.left: " + cell.left);
		if (cell.left) {
			if (Main.map[cell.row][cell.col-1].currentBelief > highestNeighCell.currentBelief) {
				highestNeighCell = Main.map[cell.row][cell.col-1];
			}
		}
		return highestNeighCell;
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
	
	//PRINT LIST
	public static void printList(ArrayList<Cell> list) {
		System.out.print("list: ");
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).status + ", ");
		}
		System.out.println("\n");
	}
}
