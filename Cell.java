
public class Cell {
	
	public static final int ROWS = 11;
	public static final int COLUMNS = 7;
	public static final int WIDTH = 12;
	protected String value = null;
	public String originalValue = null;
	
	public Cell() {
		
	}
	
	public Cell(String value) {
		this.value = value;
	}
	
	public void print() {
		String displayValue = "";
		if (this.value == null) {									// Sets Cell to 12 spaces
			displayValue = "            ";
		}
		else if (this.value.length() > WIDTH) {						// Truncates String
			displayValue = this.value.substring(0, WIDTH);
		}
		else {
			int leftPadding = (WIDTH - this.value.length())/2;
			for (int i = 0; i < leftPadding; i++) {
				displayValue += " ";
			}
			displayValue += this.value;
			int rightPadding = WIDTH - displayValue.length();
			for (int i=0; i < rightPadding; i++) {
				displayValue += " ";
			}
		}
		System.out.print(displayValue);
	}
	
}