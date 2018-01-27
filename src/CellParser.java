
public class CellParser {
	
	public static Cell parseCell(String input, String original) throws Exception {
		return (original.contains("\""))															? new StringCell(input.replace("\"", ""), original)
			 : (original.contains("(") && original.substring(original.indexOf('(')).contains(")")	? new FormulaCell(input, original, true)
			 : (original.contains("/")																? new DateCell(input, original)
			 :																						  new DoubleCell(Double.parseDouble(input), original)));
	}

	public static int[] findCoords(String cellString) {
		int col = cellString.charAt(0) - 'A';
		int row = Integer.parseInt(cellString.substring(1)) - 1;
		if (col >= 0 && col < TextExcel.COLUMNS)
			if (row >= 0 && row < TextExcel.ROWS - 1)
				return new int[] {row + 1, col + 1};
			else
				System.err.println("Error: Row out of bounds.");
		else
			System.err.println("Error: Column out of bounds.");
		return null;
	}
	
}