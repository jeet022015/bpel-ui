package be.ac.fundp.precise.dataManagment;

import java.util.UUID;

public class IdGenerator {

	/** The process counter. */
	private int counter = 1;

	/** The common head for any process. */
	private String HEAD_PROCESS = "Trip";

	public String genId(){
		String uuid = UUID.randomUUID().toString();
		uuid = HEAD_PROCESS + counter + uuid;
		counter++;
		return uuid;
	}
}
