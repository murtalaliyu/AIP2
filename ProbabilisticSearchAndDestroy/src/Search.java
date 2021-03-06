import java.util.Random;

public class Search {
	
	public static boolean searchTerrain(Cell cell) {
		if ("FL".equals(cell.status)) {
			Random r = new Random();
			int random = r.nextInt(10) + 1;
			if (random == 1 || random == 2) {
				Main.map[cell.row][cell.col].timesSearched++;
				Probabilities.updateObservation(cell);
				return false;
			} else if (random > 2 && cell.target == false) {
				Main.map[cell.row][cell.col].timesSearched++;
				Probabilities.updateObservation(cell);
				return false;
			} else if (random > 2 && cell.target == true) {
				Main.map[cell.row][cell.col].timesSearched++;
				Probabilities.updateObservation(cell);
				return true;
			}
		} else if ("HI".equals(cell.status)) {
			Random r = new Random();
			int random = r.nextInt(10) + 1;
			if (random <= 4) {
				Main.map[cell.row][cell.col].timesSearched++;
				Probabilities.updateObservation(cell);
				return false;
			} else if (random > 4 && cell.target == false) {
				Main.map[cell.row][cell.col].timesSearched++;
				Probabilities.updateObservation(cell);
				return false;
			} else if (random > 4 && cell.target == true) {
				Main.map[cell.row][cell.col].timesSearched++;
				Probabilities.updateObservation(cell);
				return true;
			}
		} else if ("FO".equals(cell.status)) {
			Random r = new Random();
			int random = r.nextInt(10) + 1;
			if (random <= 6) {
				Main.map[cell.row][cell.col].timesSearched++;
				Probabilities.updateObservation(cell);
				return false;
			} else if (random > 6 && cell.target == false) {
				Main.map[cell.row][cell.col].timesSearched++;
				Probabilities.updateObservation(cell);
				return false;
			} else if (random > 6 && cell.target == true) {
				Main.map[cell.row][cell.col].timesSearched++;
				Probabilities.updateObservation(cell);
				return true;
			}
		} else if ("CM".equals(cell.status)) {
			Random r = new Random();
			int random = r.nextInt(10) + 1;
			if (random != 10) {
				Main.map[cell.row][cell.col].timesSearched++;
				Probabilities.updateObservation(cell);
				return false;
			} else if (random == 10 && cell.target == false) {
				Main.map[cell.row][cell.col].timesSearched++;
				Probabilities.updateObservation(cell);
				return false;
			} else if (random == 10 && cell.target == true) {
				Main.map[cell.row][cell.col].timesSearched++;
				Probabilities.updateObservation(cell);
				return true;
			}
		} 
		return false;
	}
}
