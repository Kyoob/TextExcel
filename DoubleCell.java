package TextExcel;

public class DoubleCell extends Cell {
	
	private double doubleValue;
	
	public DoubleCell(double value) {
		doubleValue = value;
		this.setDisplayValue(doubleValue + "");
	}
	
	public double getDouble() {
		return doubleValue;
	}
	
}