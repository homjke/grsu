import java.util.List;
import java.io.IOException;

public interface ILogFileReader {
	
	List<String> readFile(String path, int startPosition, int countLines)
			throws IOException;

}
