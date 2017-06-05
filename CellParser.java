
public class CellParser {
	
	public static Cell parseCell(String input, String original) throws Exception {
		return (original.contains("\""))															? new StringCell(input.replace("\"", ""), original)
			 : (original.contains("(") && original.substring(original.indexOf('(')).contains(")")	? new FormulaCell(input, original, true)
			 : (original.contains("/")																? new DateCell(input, original)
			 :																						  new DoubleCell(Double.parseDouble(input), original)));
	}
	
}