import java.io.IOException;
import java.util.List;

public interface ILogFileWriter {
	
	public void writeFile(String path, List<LogRecord> logRecord) throws IOException;
	}