
public class Main {

	public static void main(String[] args) {
		
		int length = 4;
		Node[][] map = new Node[length][length];
		
		map = Map.makeMap(map);
		Map.printMap(map);
		map = Map.makeTerrain(map);
		Map.printMap(map);
		map = Map.placeTarget(map);
		Map.printMap(map);
	}
}
