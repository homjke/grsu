public class ReportGeneratorRequests implements
	IReportGenerator<ReportParameters, ReportRequests>{
	
	public ReportRequests generateReport(ReportParameters params) {

		int requestSize = 0;
		for (LogRecord log : params.getLogs()) {
			requestSize += log.getReplyBytes();
		}
		return new ReportRequests(requestSize);
	}

}
