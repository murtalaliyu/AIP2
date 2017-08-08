/*
 * 1. node.status should be regarded as node."terrainType"
 */

import java.util.Scanner;

public class Main {
	
	static int row = 0;
	static int col = 0;
	static Cell[][] map = null;
	static String ans = "";
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Size of map: (enter row size, the column size)");
		row = input.nextInt();
		col = input.nextInt();
		
		System.out.println();
		
		//MAP
		map = new Cell[row][col];
		map = Map.makeMap(map);
		Map.printTerrain(map);
		map = Map.makeTerrain(map);
		Map.printTerrain(map);
		map = Map.placeTarget(map);
		Map.printTarget(map);
		map = Map.assignNeighbors(map);
		Map.printNeighborsValidity(map);
		
		//PROBABILITIES
		map = Probabilities.falsePositive(map);
		Probabilities.printFalsePositive(map);
		map = Probabilities.falseNegative(map);
		Probabilities.printFalseNegative(map);
		map = Probabilities.priorBelief(map);
		System.out.println("P(Target in Celli) = " + Probabilities.priorBelief 
		+ "  <--- This represents our prior belief about where the target is" + "\n");
		Probabilities.printPriorBelief(map);
		Probabilities.printCurrentBelief(map);
		
		//RULES
		//ERROR: does not re-instantiate node values after each rule is called
		ans = "";
		do {
			System.out.println("\n \n");
			System.out.println("Which rule do you want to use to search? Type 'o' for our rule, '1' for rule 1, '2' for rule 2, or '4' for rule 4");
			ans = input.next();
			Rules.findCellToSearch(map);
		} while (!"q".equals(ans));
	}
	
	//returns a new map
	/*public static Cell[][] makeNewMap() {
		Cell cell = new Cell(0,0,false,false,false,false,false,"-",0,0,0,0,0);
		Cell[][] newMap = new Cell[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				newMap[i][j] = cell;
				newMap[i][j].row = i;
				newMap[i][j].col = j;
				newMap[i][j].target = map[i][j].target;
				newMap[i][j].status = map[i][j].status;
				newMap[i][j].priorBelief = (double)1 / (double)(row*col);
				newMap[i][j].currentBelief = newMap[i][j].priorBelief;
				newMap[i][j].timesSearched = 0;
				newMap[i][j].falsePositive = 0;
				newMap[i][j].falseNegative = map[i][j].falseNegative;
			}
		}
		//assign neighbors
		newMap = Neighbors.assignNeighbors(newMap);
		return newMap;
	}*/
}
