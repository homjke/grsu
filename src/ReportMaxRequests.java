public class ReportMaxRequests {
	private LogRecord maxReplyBytes;

	public ReportMaxRequests(LogRecord maxReplyBytes) {
		super();
		this.maxReplyBytes = maxReplyBytes;
	}

	public LogRecord getMaxReplyBytes() {
		return maxReplyBytes;
	}

	public void setMaxReplyBytes(LogRecord maxReplyBytes) {
		this.maxReplyBytes = maxReplyBytes;
	}

	@Override
	public String toString() {
		return "maxReplyBytes = " + maxReplyBytes.getReplyBytes();
	}
}