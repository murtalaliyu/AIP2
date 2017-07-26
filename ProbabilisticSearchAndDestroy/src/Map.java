import java.util.*;

public class Map {
	
	//GENERATE EMPTY MAP
	public static Node[][] makeMap(Node[][] map, int row, int col) {
		Node node = new Node(false,false,false,false,false,"-");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				map[i][j] = node;
			}
		}
		return map;
	}
	
	//GENERATE TERRAIN RANDOMLY
	public static Node[][] makeTerrain(Node[][] map, int row, int col) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				Random r = new Random();
				int random = r.nextInt(4) + 1;
				if (random == 1) {
					Node node = new Node(false,false,false,false,false,"0");
					node.status = "FL";
					map[i][j] = node;
				} else if (random == 2) {
					Node node = new Node(false,false,false,false,false,"0");
					node.status = "HI";
					map[i][j] = node;
				} else if (random == 3) {
					Node node = new Node(false,false,false,false,false,"0");
					node.status = "FO";
					map[i][j] = node;
				} else if (random == 4) {
					Node node = new Node(false,false,false,false,false,"0");
					node.status = "CM";
					map[i][j] = node;
				}
			}
		}
		return map;
	}
	
	//PLACE TARGET IN A RANDOM CELL
	public static Node[][] placeTarget(Node[][] map, int row, int col) {
		Random r = new Random();
		int rand1 = r.nextInt(row) + 0;
		int rand2 = r.nextInt(col) + 0;
		map[rand1][rand2].target = true;
		return map;
	}
	
	//ASSIGN NEIGHBORS HERE
	public static Node[][] assignNeighbors(Node[][] map, int row, int col) {
		map = Neighbors.assignNeighbors(map, row, col);
		return map;
	}

	//PRINT TERRAIN
	public static void printTerrain(Node[][] map, int row, int col) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(map[i][j].status + "   ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	//PRINT WHETHER TARGET IS IN CELL OR NOT (CAN'T USE THIS INFORMATION)
	public static void printTarget(Node[][] map, int row, int col) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (map[i][j].target == true) {
					System.out.print("TR" + "   ");
				} else {
					System.out.print("FA" + "   ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
	//PRINT EACH CELL'S NEIGHBOR VALIDITY
	public static void printNeighborsValidity(Node[][] map, int row, int col) {

		//print map with each node's neighbors
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(map[i][j].right + "," + map[i][j].bottom + "," + map[i][j].top + "," + map[i][j].left + "   ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
