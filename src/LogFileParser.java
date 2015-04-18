import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.ArrayList;
import java.util.List;

public class LogFileParser implements ILogFileParser {

	public LogRecord parse(String str){
	
	LogRecord logRecord = new LogRecord();
	
	char ch = '\"';
	int startCh = str.indexOf(ch);
	int lastCh = str.lastIndexOf(ch);
	int lastVoid = str.lastIndexOf(" ");
	
	logRecord.setHost(str.substring(0, str.indexOf(" - - ")));
	logRecord.setRequest(str.substring(startCh, lastCh) + ch);
	logRecord.setHTTPReplyCode(Integer.parseInt(str.substring(lastCh+2, lastVoid)));
	
	try	{
			logRecord.setReplyBytes(Integer.parseInt(str.substring(lastVoid+1)));
			
	} catch (NumberFormatException e) {
		logRecord.setReplyBytes(0);
	}
	
	
	String timestampPattern = "[dd/MMM/yyyy:HH:mm:ss Z]";
	logRecord.setTimeStamp(new SimpleDateFormat(timestampPattern, Locale.US)
			.parse(str, new ParsePosition(str.indexOf("["))));
	
	return logRecord;
	
	}
	
	public List<LogRecord> parse(List<String> data){
		
		List<LogRecord> logRecord = new ArrayList<LogRecord>();
		
		for (String str : data) {
			logRecord.add(parse(str));
		}

		return logRecord;
	
	}
}
