
public class DoubleCell extends Cell {
	
	private double doubleValue;
	
	public DoubleCell(double value) {
		doubleValue = value;
		displayValue = doubleValue + "";
	}
	
	public double getDouble() {
		return doubleValue;
	}
	
}