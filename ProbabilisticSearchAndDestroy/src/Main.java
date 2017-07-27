/*
 * 1. node.status should be regarded as node."terrainType"
 */

import java.util.Scanner;

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
		map = Map.makeMap(map);
		Map.printTerrain(map);
		map = Map.makeTerrain(map);
		Map.printTerrain(map);
		map = Map.placeTarget(map);
		Map.printTarget(map);
		map = Map.assignNeighbors(map);
		Map.printNeighborsValidity(map);
		
		//PROBABILITIES
		map = Probabilities.priorBelief(map);
		System.out.println("P(Target in Celli) = " + Probabilities.priorBelief 
		+ "  <--- This represents our prior belief about where the target is" + "\n");
		Probabilities.printPriorBelief(map);
		map = Probabilities.falseNegative(map);
		Probabilities.printFalseNegative(map);
		map = Probabilities.falsePositive(map);
		Probabilities.printFalsePositive(map);
		
		//TEST AFTER THIS LINE.............................
		map = Probabilities.currentBelief(map);
		double prior = map[0][1].currentBelief;
		double current = 0.2;
		map[0][1].currentBelief = current;
		
		map = Normalize.normalizeMap(map, map[0][1], prior, current);
		Probabilities.printCurrentBelief(map);
	}
}
