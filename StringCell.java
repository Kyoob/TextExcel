
public class StringCell extends Cell {
	
    public StringCell(String value, String original) {
    	setOriginalValue(original);
    	displayValue = value;
    }
    
    public String getString() {
    	return displayValue;
    }
    
}