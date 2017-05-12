
public class CellParser {
	
	public static Cell parseCell(String input, String original) throws Exception {
		return (input.contains("\""))					   ? new StringCell(input.replace("\"", ""), original)
			 : (input.contains("(") && input.contains(")") ? new FormulaCell(input, original)
			 : (input.contains("/")						   ? new DateCell(input, original)
			 :												 new DoubleCell(Double.parseDouble(input), original)));
	}
	
}