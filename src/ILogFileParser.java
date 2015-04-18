import java.util.List;

public interface ILogFileParser {
	
	public LogRecord parse(String line);
	
	public List<LogRecord> parse(List<String> data);
	
}
