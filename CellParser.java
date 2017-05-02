
public class CellParser {
	
	public static Cell parseCell(String input) throws Exception {
		if (input.contains("\"")) {
			return new StringCell(input.replace("\"", ""));
		} else if(input.contains("(") && input.contains(")")) {
			return new FormulaCell(input);
		} else if (input.contains("/")) {
			return new DateCell(input);
		} else {
			return new DoubleCell(Double.parseDouble(input));
		}
	}
	
}