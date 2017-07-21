import java.util.*;

public class Map {
	
	public static Node[][] makeMap(Node[][] map) {
		Node temp = null;
		Node node = new Node(temp,temp,temp,temp,false,"0");
		//ASSIGN NEIGHBORS HERE
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				map[i][j] = node;
			}
		}
		return map;
	}
	
	//ERROR: makes terrain all the same for some reason
	public static Node[][] makeTerrain(Node[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				Random r = new Random();
				int random = r.nextInt(4) + 1;
				System.out.println("random: " + random + ", map[i][j] = " + i+j);
				if (random == 1) {
					map[i][j].status = "FL";
				} else if (random == 2) {
					map[i][j].status = "HI";
				} else if (random == 3) {
					map[i][j].status = "FO";
				} else if (random == 4) {
					map[i][j].status = "CM";
				}
			}
		}
		return map;
	}
	
	public static Node[][] placeTarget(Node[][] map) {
		Random r = new Random();
		int rand1 = r.nextInt(map.length) + 0;
		int rand2 = r.nextInt(map.length) + 0;
		map[rand1][rand2].target = true;
		return map;
	}

	public static void printMap(Node[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j].target + "   ");
			}
			System.out.println();
		}
	}
}
