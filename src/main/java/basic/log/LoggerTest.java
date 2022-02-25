package basic.log;

public class LoggerTest {
	public static void main(String[] args) {
		UniLogger logger = UniLogger.getLogger();
		logger.logError("log test");
	}
}
