
public class Cell {
	
	private static final int WIDTH = TextExcel.WIDTH;
	protected String displayValue = null;	// What gets shown for that cell when calling CellMatrix.print()
	private String originalValue = null;	// What was typed in by the user for that cell
	
	public Cell() {
		
	}
	
	public Cell(String value) {
		this.displayValue = value;
	}
	
	public void setOriginalValue(String value) {
		originalValue = value;
	}
	
	public String getOriginalValue() {
		return originalValue;
	}
	
	public void setDisplayValue(String value) {
		displayValue = value;
	}
	
	public String getDisplayValue() {
		return displayValue;
	}
	
	public void print() {
		String toDisplay = "";
		if (displayValue == null)								// Sets Cell to 12 spaces
			toDisplay = "            ";
		else if (displayValue.length() > WIDTH)					// Truncates String
			toDisplay = displayValue.substring(0, WIDTH);
		else {
			int leftPadding = (WIDTH - displayValue.length())/2;
			for (int i = 0; i < leftPadding; i++)
				toDisplay += " ";
			toDisplay += displayValue;
			int rightPadding = WIDTH - toDisplay.length();
			for (int i = 0; i < rightPadding; i++)
				toDisplay += " ";
		}
		System.out.print(toDisplay);
	}
	
}