import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ReportWriter implements IReportWriter{
	public void writeFile(String path, String reportMessage)
			throws IOException {

		PrintWriter write = new PrintWriter(new BufferedWriter(new FileWriter(
				path)));

			write.println(reportMessage);

		write.close();
	}

}
