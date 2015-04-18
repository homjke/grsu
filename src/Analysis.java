import java.io.IOException;

public class Analysis 
{

	public static void main(String[] args) throws IOException{
		
		ArgsChecker argsChecker = new ArgsChecker(args);
		
		if(argsChecker.isCorrect()){
			ILogFileParser logFileParser = new LogFileParser();
			ILogFileWriter logFileWriter = new LogFileWriter();
			IReportWriter reportWriter = new ReportWriter();
			ILog log = new Log(logFileParser, logFileWriter,reportWriter);
			log.process(argsChecker);
		} else {
			System.out.print(argsChecker.getErrorMessage());
		}
		}
        
}