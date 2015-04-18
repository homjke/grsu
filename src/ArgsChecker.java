import java.io.File;
import java.io.IOException;

public class ArgsChecker {

	private int startPosition;
	private int countLines;
	private String inputFilePath;
	private String outputFilePath;
	private String outFilePath;
	private int reportNumber;
	private String Message = "";
	
	public int getStartPosition() {
		return startPosition;
	}
	
	public int getCountLines() {
		return countLines;
	}
	
	public String getInputFilePath() {
		return inputFilePath;
	}
	
	public String getOutputFilePath() {
		return outputFilePath;
	}
	
	public String getOutFilePath() {
		return outFilePath;
	}
	
	public int getReportNumber() {
		return reportNumber;
	}
	
	public String getErrorMessage() {
		return Message;
	}
	
	private void setStartPosition(String startPosition) {
		try {
			this.startPosition = Integer.parseInt(startPosition);
			if (this.startPosition < 0) {
				Message = "������������ ��������� �������\n";
				this.startPosition = 0;
			}
		} catch (NumberFormatException e) {
			Message += e.toString() + "\n";
			this.startPosition = 0;
		}
	}
	
	private void setCountLines(String countLines) {
		try {
			this.countLines = Integer.parseInt(countLines);
			if (this.countLines < 0) {
				Message = "������������ ����� ����������� �����\n";
				this.countLines = 0;
			}
		} catch (NumberFormatException e) {
			Message += e.toString() + "\n";
			this.countLines = 0;
		}
	}
	
	private void setInputFilePath(String inputFilePath) {
		this.inputFilePath = inputFilePath;
		File file = new File(inputFilePath);
		if (!file.canRead()) {
			Message += "������ ����� ����������\n";

			try {
				file.createNewFile();
			} catch (IOException e) {
			}

		}
	}
	
	private void setOutputFilePath(String outputFilePath) {
		this.outputFilePath = outputFilePath;
		File file = new File(outputFilePath);
		if (!file.canWrite()) {
			Message += "������ � ����  ����������\n";
			file.setWritable(true);
		}
	}
	
	private void setOutFilePath(String outFilePath) {
		this.outFilePath = outFilePath;
		File file = new File(outFilePath);
		if (!file.canWrite()) {
			Message += "������ � ����  ����������\n";
			file.setWritable(true);
		}
	}
	
	public void setReportNumber(String reportNumber) {
		try {
			this.reportNumber = Integer.parseInt(reportNumber);
			if (this.reportNumber < 0 || this.reportNumber > 2) {
				Message = "������������ ����� ������\n";
				this.reportNumber = 0;
			}
		} catch (NumberFormatException e) {
			Message += e.toString() + "\n";
			this.reportNumber = 0;
		}
	}

	public ArgsChecker(String[] args) {
		if (args.length < 6) {
			Message += "�� ������� ���������� ����������. ������ ���������\n";
		}
		setStartPosition(args[0]);
		setCountLines(args[1]);
		setInputFilePath(args[2]);
		setOutputFilePath(args[3]);
		setOutFilePath(args[4]);
		setReportNumber(args[5]);
		
	}
	
	public boolean isCorrect() {

		return Message.isEmpty();
	}
	
}
