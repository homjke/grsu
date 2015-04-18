import java.io.IOException;

public interface IReportWriter {
	public void writeFile(String path, String reportMessage)
			throws IOException;
}
