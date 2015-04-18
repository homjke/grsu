import java.util.Collections;
import java.util.Comparator;

public class ReportGeneratorMaxRequests implements
IReportGenerator<ReportParameters, ReportMaxRequests> {
	
	public ReportMaxRequests generateReport(ReportParameters param) {
		LogRecord logRecord = Collections.max(param.getLogs(),
				new Comparator<LogRecord>() {
					public int compare(LogRecord log1, LogRecord log2) {
						return Integer.compare(log1.getReplyBytes(),
								log2.getReplyBytes());
					}
				});
		return new ReportMaxRequests(logRecord);
	}

}
