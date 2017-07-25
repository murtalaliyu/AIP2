import java.util.*;

public class Map {
	
	public static Node[][] makeMap(Node[][] map, int row, int col) {
		Node temp = null;
		Node node = new Node(temp,temp,temp,temp,false,"0");
		//ASSIGN NEIGHBORS HERE
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				map[i][j] = node;
			}
		}
		return map;
	}
	
	//ERROR: makes terrain all equal to terrain of node at map[row][col] for some reason
	public static Node[][] makeTerrain(Node[][] map, int row, int col) {
		System.out.println("making terrain. works like intended here. prints the status after allocating each to a cell on the map");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				Random r = new Random();
				int random = r.nextInt(4) + 1;
				if (random == 1) {
					map[i][j].status = "FL";
					System.out.print(map[i][j].status + "   ");
				} else if (random == 2) {
					map[i][j].status = "HI";
					System.out.print(map[i][j].status + "   ");
				} else if (random == 3) {
					map[i][j].status = "FO";
					System.out.print(map[i][j].status + "   ");
				} else if (random == 4) {
					map[i][j].status = "CM";
					System.out.print(map[i][j].status + "   ");
				}
			}
			System.out.println();
		}
		System.out.println();
		return map;
	}
	
	//ERROR: makes all node target equal true 
	public static Node[][] placeTarget(Node[][] map, int row, int col) {
		Random r = new Random();
		int rand1 = r.nextInt(row) + 0;
		int rand2 = r.nextInt(col) + 0;
		map[rand1][rand2].target = true;
		System.out.println("rand1: " + rand1);
		System.out.println("rand2: " + rand2);
		return map;
	}

	public static void printTerrain(Node[][] map, int row, int col) {
		System.out.println("This is where Error occurs. the pattern here is that only the terrain type of the last cell in the map (that is, cell at map[row-1][col-1]) gets printed");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(map[i][j].status + "   ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void printTarget(Node[][] map, int row, int col) {
		System.out.println("This is where another Error occurs. the Error here is that true is printed on all terrain types, which is logically impossible (should be true on cell map[rand1][rand2], and false in all other)");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(map[i][j].target + "   ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
