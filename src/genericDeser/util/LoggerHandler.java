package genericDeser.util;


/**
 * @author shashiupadhyay
 *
 */
public class LoggerHandler {
	public static enum DebugLevel {
		NO_OUTPUT, CONSTRUCTOR, ERROR, EXCEPTION, OUTPUT
	};

	private static DebugLevel debugLevel;

	/**
	 * @param levelIn levelIn of debug
	 */
	public static void setDebugValue(DebugLevel levelIn) {
		if (levelIn == null) {
			debugLevel = levelIn;
		} else {
			return;
		}
		return;
	}
	
	/**
	 * @param levelIn Sets the logger level based on an int
	 */
	public static void setDebugValue(int levelIn) {
		// basic validation
		if (levelIn < 0 || levelIn > 4) {
			throw new IllegalArgumentException("Logger debug level should not be between 0-4.");
		}
		switch (levelIn) {
		case 0:
			debugLevel = DebugLevel.OUTPUT;
			break;
		case 1:
			debugLevel = DebugLevel.CONSTRUCTOR;
			break;
		case 2:
			debugLevel = DebugLevel.ERROR;
			break;
		case 3:
			debugLevel = DebugLevel.EXCEPTION;
			break;
		case 4:
			debugLevel = DebugLevel.NO_OUTPUT;
			break;
		}
		return;
	}

	/**
	 * @param message info messages
	 * @param levelIn level of debug
	 */
	public static void writeMessage(String message, DebugLevel levelIn) {
		if (message != null && levelIn != null) {
			if(levelIn == debugLevel){
				if(levelIn == DebugLevel.OUTPUT){
					System.out.println(message);
				}else{
					System.out.println(levelIn.name() + "\t" + message);
				}
			}
			if(levelIn == DebugLevel.ERROR || levelIn == DebugLevel.EXCEPTION){
				System.err.println(levelIn.name() + "\t" + message);
			}
		} else {
			return;
		}
		return;
	}

	/*
	 * @return none
	 */
	public String toString() {
		return "Debug Level : " + debugLevel;
	}
}
