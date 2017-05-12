
public class DoubleCell extends Cell {
	
	private double doubleValue;
	
	public DoubleCell(double value, String original) {
		setOriginalValue(original);
		doubleValue = value;
		displayValue = doubleValue + "";
	}
	
	public double getDouble() {
		return doubleValue;
	}
	
}