import java.util.List;


public class ReportParameters {
	
	private List<LogRecord> logRecord;

	public ReportParameters(List<LogRecord> logRecord) {
		super();
		this.logRecord = logRecord;
	}

	public List<LogRecord> getLogs() {
		return logRecord;
	}
}

