
import java.util.Scanner;

// A simple spreadsheet program.

public class TextExcel {
	
	public static final int ROWS = 11;
	public static final int COLUMNS = 7;
	public static final int WIDTH = 12;
	
	public static void main(String[] args) throws Exception {
		
		CellMatrix instance = CellMatrix.getInstance();
		System.out.print("Welcome to TextExcel!\n\nEnter a command: ");
		Scanner console = new Scanner(System.in);
		String rawInput = console.nextLine();
		while (!(rawInput.equalsIgnoreCase("exit") || rawInput.equalsIgnoreCase("quit"))) {
			if (rawInput.contains("clear"))
				instance.clear(rawInput);
			else if (rawInput.equalsIgnoreCase("print"))
				instance.print();
			else if (rawInput.contains("=")) {
				int[] cell = findCoords(rawInput.substring(0, 2));
				String inputValue = rawInput.substring(rawInput.indexOf("=") + 2);
				instance.setValue(cell[0], cell[1], inputValue, rawInput);
			} else {
				Cell c = instance.getCell(rawInput);
				String inputValue = instance.getValue(c);
				if (inputValue == null)
					System.out.println(rawInput + " = <empty>");
				else
					System.out.println(c.getOriginalValue());
			}
			System.out.print("\nEnter a command: ");
			rawInput = console.nextLine();
		}
		console.close();
		System.out.print("\nFarewell!");
		
	}
	
	public static int[] findCoords(String s) {
		int col = s.charAt(0) - 'A';
		int row = Integer.parseInt(s.charAt(1) + "") - 1;
		if (col >= 0 && col < COLUMNS)
			if (!(row < 0 || row > ROWS))
				return new int[] {row + 1, col + 1};
			else
				System.err.println("Error: Row out of bounds or invalid input.");
		else
			System.err.println("Error: Column out of bounds or invalid input.");
		return null;
	}
	
}