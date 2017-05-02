
public class DoubleCell extends Cell {
	
	private double content;
	
	public DoubleCell(double value) {
		this.value = value + "";
		content = value;
	}
	
	public double getDouble() {
		return content;
	}
	
}