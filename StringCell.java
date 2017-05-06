package TextExcel;

public class StringCell extends Cell {
	
    public StringCell(String value) {
    	this.setDisplayValue(value);
    }
    
    public String getString() {
    	return getDisplayValue();
    }
    
}