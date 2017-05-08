
public class CellParser {
	
	public static Cell parseCell(String input) throws Exception {
		return (input.contains("\""))					   ? new StringCell(input.replace("\"", ""))
			 : (input.contains("(") && input.contains(")") ? new FormulaCell(input)
			 : (input.contains("/")						   ? new DateCell(input)
			 :												 new DoubleCell(Double.parseDouble(input))));
	}
	
}