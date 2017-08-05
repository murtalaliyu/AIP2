/*
 * 1. node.status should be regarded as node."terrainType"
 */

import java.util.Scanner;

public class Main {
	
	static int row = 0;
	static int col = 0;
	static Cell[][] map = null;
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
		String ans = "";
		do {
			System.out.println("\n \n");
			System.out.println("Which rule do you want to use to search? Type 'o' for our rule, '1' for rule 1, '2' for rule 2, or '4' for rule 4");
			ans = input.next();
			if ("o".equals(ans)) {
				Rules.ourRule(map);
			} else if ("1".equals(ans)) {
				Rules.ruleOne(map);
			} else if ("2".equals(ans)) {
				Rules.ruleTwo(map);
			} else if ("4".equals(ans)) {
				Rules.questionFour(map);
			} else {
				System.out.println("this program has terminated.");
			}
		} while (!"q".equals(ans));
	}
}
