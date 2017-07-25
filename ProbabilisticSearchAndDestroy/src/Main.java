/*
 * 1. node.status should be regarded basically as node."terrainType"
 */

import java.util.*;

public class Main {
	
	/*
	 * Main
	 */
	static int row = 0;
	static int col = 0;
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {

		System.out.println("Size of map: (enter row size, the column size)");

		row = input.nextInt();
		col = input.nextInt();
		System.out.println();
		
		Node[][] map = new Node[row][col];
		
		map = Map.makeMap(map, row, col);
		map = Map.makeTerrain(map, row, col);
		Map.printTerrain(map, row, col);
		map = Map.placeTarget(map, row, col);
		Map.printTarget(map, row, col);
	}
}
