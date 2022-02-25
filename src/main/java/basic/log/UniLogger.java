package basic.log;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class UniLogger {
	Logger logger = Logger.getLogger("uni");
	private static UniLogger instance = new UniLogger();

	public static final String errorMsg = "log_err.txt";
	public static final String warningMsg = "log_warning.txt";
	public static final String fineMsg = "log_fine.txt";

	private FileHandler errFile = null;
	private FileHandler warningFile = null;
	private FileHandler fineFile = null;

	/* Singleton */
	private UniLogger() {

		try {
			errFile = new FileHandler(errorMsg, true);
			warningFile = new FileHandler(warningMsg, true);
			fineFile = new FileHandler(fineMsg, true);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		/* formatter setting */
		errFile.setFormatter(new SimpleFormatter());
		warningFile.setFormatter(new SimpleFormatter());
		fineFile.setFormatter(new SimpleFormatter());

		/* level setting */
		errFile.setLevel(Level.ALL);
		warningFile.setLevel(Level.WARNING);
		fineFile.setLevel(Level.FINE);

		logger.addHandler(errFile);
		logger.addHandler(warningFile);
		logger.addHandler(fineFile);
	}

	public static UniLogger getLogger() {
		return instance;
	}

	public void logError(String msg) {
		logger.finest(msg);
		logger.finer(msg);
		logger.fine(msg);
		logger.config(msg);
		logger.info(msg);
		logger.warning(msg);
		logger.severe(msg);
	}

	public void logFine(String msg) {
		logger.fine(msg);
	}

	public void logWarning(String msg) {
		logger.warning(msg);
	}
}
