import java.util.Date;


public class LogRecord {
	
	private String Host;
	private String request;
	private Date timeStamp;
	private int HTTPReplyCode;
	private int replyBytes;
	
	public String getHost() {
		return Host;
	}
	public void setHost(String host) {
		Host = host;
	}
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public int getHTTPReplyCode() {
		return HTTPReplyCode;
	}
	public void setHTTPReplyCode(int hTTPReplyCode) {
		HTTPReplyCode = hTTPReplyCode;
	}
	public int getReplyBytes() {
		return replyBytes;
	}
	public void setReplyBytes(int replyBytes) {
		this.replyBytes = replyBytes;
	}
	
	public LogRecord(){
		
		
	}
	@Override
	public String toString() {
		return "Host=" + Host + ", request=" + request
				+ ", timestamp=" + timeStamp + ", HTTPReplyCode="
				+ HTTPReplyCode + ", replyBytes=" + replyBytes;
	}
	
	
	

}
