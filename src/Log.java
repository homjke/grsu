import java.io.IOException;
import java.util.List;

public class Log implements ILog {
	
	private ILogFileParser logFileParser;
	private ILogFileWriter logFileWriter;
	private IReportWriter reportWriter;

	public Log(ILogFileParser logFileParser, ILogFileWriter logFileWriter,
			IReportWriter reportWriter) {
		this.logFileParser = logFileParser;
		this.logFileWriter = logFileWriter;
		this.reportWriter = reportWriter;
	}
	
	public void process(ArgsChecker argsChecker) throws IOException {

		ILogFileReader logFileReader = new LogFileReader();

		List<LogRecord> logRecords = logFileParser.parse(logFileReader.readFile
				(argsChecker.getInputFilePath(), argsChecker.getStartPosition(),
						argsChecker.getCountLines()));

		logFileWriter.writeFile(argsChecker.getOutputFilePath(), logRecords);
		
		ReportParameters reportParameters = new ReportParameters(logRecords);

		switch (argsChecker.getReportNumber()) {
		case 1: {
			IReportGenerator<ReportParameters, ReportRequests> reportRequests = new ReportGeneratorRequests();
			reportWriter.writeFile(argsChecker.getOutFilePath(),reportRequests.generateReport(reportParameters).toString());
			break;
		}

		case 2: {
			IReportGenerator<ReportParameters, ReportMaxRequests> reportMaxRequests = new ReportGeneratorMaxRequests();
			reportWriter.writeFile(argsChecker.getOutFilePath(),reportMaxRequests.generateReport(reportParameters).toString());
			break;
		}

		default:
			break;
		}
	}
}