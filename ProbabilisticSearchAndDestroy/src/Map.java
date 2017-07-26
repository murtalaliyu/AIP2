import java.util.*;

public class Map {
	
	//GENERATE EMPTY MAP
	public static Cell[][] makeMap(Cell[][] map, int row, int col) {
		Cell cell = new Cell(false,false,false,false,false,"-",0,0);
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				map[i][j] = cell;
			}
		}
		return map;
	}
	
	//GENERATE TERRAIN RANDOMLY
	public static Cell[][] makeTerrain(Cell[][] map, int row, int col) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				Random r = new Random();
				int random = r.nextInt(4) + 1;
				if (random == 1) {
					Cell cell = new Cell(false,false,false,false,false,"0",0,0);
					cell.status = "FL";
					map[i][j] = cell;
				} else if (random == 2) {
					Cell cell = new Cell(false,false,false,false,false,"0",0,0);
					cell.status = "HI";
					map[i][j] = cell;
				} else if (random == 3) {
					Cell cell = new Cell(false,false,false,false,false,"0",0,0);
					cell.status = "FO";
					map[i][j] = cell;
				} else if (random == 4) {
					Cell cell = new Cell(false,false,false,false,false,"0",0,0);
					cell.status = "CM";
					map[i][j] = cell;
				}
			}
		}
		return map;
	}
	
	//PLACE TARGET IN A RANDOM CELL
	public static Cell[][] placeTarget(Cell[][] map, int row, int col) {
		Random r = new Random();
		int rand1 = r.nextInt(row) + 0;
		int rand2 = r.nextInt(col) + 0;
		map[rand1][rand2].target = true;
		return map;
	}
	
	//ASSIGN NEIGHBORS HERE
	public static Cell[][] assignNeighbors(Cell[][] map, int row, int col) {
		map = Neighbors.assignNeighbors(map, row, col);
		return map;
	}

	//PRINT TERRAIN
	public static void printTerrain(Cell[][] map, int row, int col) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(map[i][j].status + "   ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	//PRINT WHETHER TARGET IS IN CELL OR NOT (CAN'T USE THIS INFORMATION)
	public static void printTarget(Cell[][] map, int row, int col) {
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
	public static void printNeighborsValidity(Cell[][] map, int row, int col) {

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
