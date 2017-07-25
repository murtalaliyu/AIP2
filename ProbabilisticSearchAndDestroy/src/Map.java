import java.util.*;

public class Map {
	
	public static Node[][] makeMap(Node[][] map, int row, int col) {
		Node temp = null;
		Node node = new Node(temp,temp,temp,temp,false,"-");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				map[i][j] = node;
			}
		}
		return map;
	}
	
	public static Node[][] makeTerrain(Node[][] map, int row, int col) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				Random r = new Random();
				int random = r.nextInt(4) + 1;
				if (random == 1) {
					Node temp = null;
					Node node = new Node(temp,temp,temp,temp,false,"0");
					node.status = "FL";
					map[i][j] = node;
				} else if (random == 2) {
					Node temp = null;
					Node node = new Node(temp,temp,temp,temp,false,"0");
					node.status = "HI";
					map[i][j] = node;
				} else if (random == 3) {
					Node temp = null;
					Node node = new Node(temp,temp,temp,temp,false,"0");
					node.status = "FO";
					map[i][j] = node;
				} else if (random == 4) {
					Node temp = null;
					Node node = new Node(temp,temp,temp,temp,false,"0");
					node.status = "CM";
					map[i][j] = node;
				}
			}
		}
		return map;
	}
	
	public static Node[][] placeTarget(Node[][] map, int row, int col) {
		Random r = new Random();
		int rand1 = r.nextInt(row) + 0;
		int rand2 = r.nextInt(col) + 0;
		map[rand1][rand2].target = true;
		return map;
	}
	
	//ASSIGN NEIGHBORS HERE
	public static Node[][] assignNeighbors(Node[][] map, int row, int col) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if () {
					
				}
			}
		}
		return map;
	}

	public static void printTerrain(Node[][] map, int row, int col) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(map[i][j].status + "   ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
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
}
