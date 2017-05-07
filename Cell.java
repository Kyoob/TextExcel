package TextExcel;

public class Cell {
	
	private static final int WIDTH = TextExcel.WIDTH;
	protected String displayValue = null;
	private String originalValue = null;
	
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
		String displayValue = "";
		if (this.displayValue == null)									// Sets Cell to 12 spaces
			displayValue = "            ";
		else if (this.displayValue.length() > WIDTH)					// Truncates String
			displayValue = this.displayValue.substring(0, WIDTH);
		else {
			int leftPadding = (WIDTH - this.displayValue.length())/2;
			for (int i = 0; i < leftPadding; i++)
				displayValue += " ";
			displayValue += this.displayValue;
			int rightPadding = WIDTH - displayValue.length();
			for (int i=0; i < rightPadding; i++)
				displayValue += " ";
		}
		System.out.print(displayValue);
	}
	
}