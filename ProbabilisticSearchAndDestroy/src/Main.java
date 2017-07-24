import java.util.*;

public class Main {

	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {

		System.out.println("Size of map: (enter row size, the column size)");

		int row = input.nextInt();
		int col = input.nextInt();
		System.out.println();
		
		Node[][] map = new Node[row][col];
		
		map = Map.makeMap(map, row, col);
		Map.printTerrain(map, row, col);
		map = Map.makeTerrain(map, row, col);
		Map.printTerrain(map, row, col);
		map = Map.placeTarget(map, row, col);
		Map.printTarget(map, row, col);
	}
}
