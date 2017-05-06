package TextExcel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateCell extends Cell {
	
	private Date dateValue;
	
	public DateCell (String value) throws ParseException {
		dateValue = new SimpleDateFormat("mm/dd/yyyy").parse(value);
		this.setDisplayValue(value);
    }
	
	public Date getDate() {
		return dateValue;
	}
	
}