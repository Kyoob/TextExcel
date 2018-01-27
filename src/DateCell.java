
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateCell extends Cell {
	
	private Date dateValue;
	
	public DateCell (String value, String original) throws ParseException {
		setOriginalValue(original);
		dateValue = new SimpleDateFormat("mm/dd/yyyy").parse(value);
		displayValue = value;
    }
	
	public Date getDate() {
		return dateValue;
	}
	
}