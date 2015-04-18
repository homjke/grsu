public class ReportRequests {
	private int requestSize;

	public ReportRequests(int requestSize) {
		super();
		this.requestSize = requestSize;
	}

	public int getRequestSize() {
		return requestSize;
	}

	public void setRequestSize(int requestSize) {
		this.requestSize = requestSize;
	}

	@Override
	public String toString() {
		return "RequestSize = " + requestSize;
	}

}
