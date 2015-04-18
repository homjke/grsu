import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;


public class LogFileReader implements ILogFileReader {
	
	public List<String> readFile(String path, int startPosition,
			int countLines) throws IOException {

		LineNumberReader lineReader = new LineNumberReader(new FileReader(path));

		String line;
		List<String> lines = new ArrayList<String>();
		while ((countLines != 0) && ((line = lineReader.readLine()) != null)) {

			if (lineReader.getLineNumber() >= startPosition) {
				lines.add(line);
				countLines --;
			}
		}
		lineReader.close();
		return lines;
	}
}
