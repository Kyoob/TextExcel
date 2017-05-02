import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateCell extends Cell {
	
	private String value;
	SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy");
	Date dateValue = DATE_FORMAT.parse(value);
	
	public DateCell (String value) throws ParseException {
		this.value = value;
    }
	
	public Date getDate() {
		return dateValue;
	}
	
}