import java.util.Random;

public class Search {

	public static boolean searchFlat(Cell cell) {
		Random r = new Random();
		int random = r.nextInt(10) + 1;
		if (random == 1 || random == 2) {
			return false;
		} else if (random > 2 && cell.target == false) {
			return false;
		} else if (random > 2 && cell.target == true) {
			return true;
		}
		return false;
	}
	
	public static boolean searchHilly(Cell cell) {
		Random r = new Random();
		int random = r.nextInt(10) + 1;
		if (random >= 1 && random <= 4) {
			return false;
		} else if (random > 4 && cell.target == false) {
			return false;
		} else if (random > 4 && cell.target == true) {
			return true;
		}
		return false;
	}
	
	public static boolean searchForested(Cell cell) {
		Random r = new Random();
		int random = r.nextInt(10) + 1;
		if (random >= 1 && random <= 6) {
			return false;
		} else if (random > 6 && cell.target == false) {
			return false;
		} else if (random > 6 && cell.target == true) {
			return true;
		}
		return false;
	}
	
	public static boolean searchMaze(Cell cell) {
		Random r = new Random();
		int random = r.nextInt(10) + 1;
		if (random != 10) {
			return false;
		} else if (random > 9 && cell.target == false) {
			return false;
		} else if (random > 9 && cell.target == true) {
			return true;
		}
		return false;
	}
}
