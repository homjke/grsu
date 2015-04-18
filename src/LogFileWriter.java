import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class LogFileWriter implements ILogFileWriter{

	public void writeFile(String path, List<LogRecord> logRecords)
			throws IOException {

		PrintWriter write = new PrintWriter(new BufferedWriter(new FileWriter(
				path)));

		for (LogRecord logRecord : logRecords) {
			write.println(logRecord);
		}

		write.close();
	}
}
