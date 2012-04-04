package be.ac.fundp;

public class UiManagerUtil {
	
	private static final String PROCESS_HEAD = "process-";
	private static int processCount = 0;

	protected static int newTailProcess() {
		return processCount++;
	}
	
	public static String generateId() {
		return PROCESS_HEAD+newTailProcess();
	}

}
