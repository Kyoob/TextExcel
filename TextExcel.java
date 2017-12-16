
import java.util.Scanner;

// A simple spreadsheet program.

public class TextExcel {
	
	public static final int ROWS = 11;
	public static final int COLUMNS = 7;
	public static final int WIDTH = 12;
	
	public static void main(String[] args) throws Exception {
		CellMatrix instance = CellMatrix.getInstance();
		Scanner console = new Scanner(System.in);
		String rawInput;
		System.out.println("Welcome to TextExcel!");
		do {
			System.out.print("\nEnter a command: ");
			rawInput = console.nextLine();
			if (rawInput.contains("clear"))
				instance.clear(rawInput);
			else if (rawInput.equalsIgnoreCase("print") || rawInput.equalsIgnoreCase("p"))
				instance.print();
			else if (rawInput.contains("=")) {
				int[] cell = CellParser.findCoords(rawInput.substring(0, rawInput.replace(" ", "").indexOf('=')));
				if (cell != null)
					instance.setValue(cell[0], cell[1], rawInput.substring(rawInput.indexOf("=") + 1), rawInput);
			} else
				try {
					Cell c = instance.getCell(rawInput);
					String inputValue = instance.getValue(c);
					if (inputValue == null)
						System.out.println(rawInput + " = <empty>");
					else
						System.out.println(c.getOriginalValue());
				} catch (Exception e) {
					System.err.println("Invalid input.");
				}
		} while (!(rawInput.equalsIgnoreCase("exit") || rawInput.equalsIgnoreCase("quit") || rawInput.equalsIgnoreCase("q")));
		console.close();
		System.out.println("\nFarewell!\n");
	}
	
}
