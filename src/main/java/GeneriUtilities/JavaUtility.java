package GeneriUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JavaUtility {
	
	public String getDate() {
		Date d = new Date();
		SimpleDateFormat f = new SimpleDateFormat("dd-mm-yyyy hh-mm-ss");
		String date = f.format(d);
		return date;
	}
}
