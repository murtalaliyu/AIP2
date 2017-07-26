/*
 * 1. node.status should be regarded basically as node."terrainType"
 */

import java.util.*;

public class Main {
	
	static int row = 0;
	static int col = 0;
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {

		System.out.println("Size of map: (enter row size, the column size)");

		row = input.nextInt();
		col = input.nextInt();
		System.out.println();
		
		Cell[][] map = new Cell[row][col];
		
		//MAP LOGISTICS
		map = Map.makeMap(map, row, col);
		Map.printTerrain(map, row, col);
		map = Map.makeTerrain(map, row, col);
		Map.printTerrain(map, row, col);
		map = Map.placeTarget(map, row, col);
		Map.printTarget(map, row, col);
		map = Map.assignNeighbors(map, row, col);
		Map.printNeighborsValidity(map, row, col);
		
		//PROBABILITIES
		map = Probabilities.priorBelief(map, row, col);
		System.out.println("P(Target in Celli) = " + Probabilities.priorBelief 
		+ "  <--- This represents our prior belief about where the target is" + "\n");
		Probabilities.printPriorBelief(map, row, col);
		map = Probabilities.falseNegative(map, row, col);
		Probabilities.printFalseNegative(map, row, col);
		map = Probabilities.falsePositive(map, row, col);
		Probabilities.printFalsePositive(map, row, col);
		
	}
}
