package be.ac.fundp.precise.dataManagment;

import java.util.UUID;

/**
 * This class generates unique Ids for each process instance.
 * 
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date May 22, 2012
 */
public class IdProcessGenerator {

	/** The process counter. */
	private int counter = 1;

	/** The common head for any process. */
	private String HEAD_PROCESS = "Trip";

	/**
	 * Generate a unique id.
	 * 
	 * @return the id
	 */
	public String genId() {
		String uuid = UUID.randomUUID().toString();
		uuid = HEAD_PROCESS + counter + uuid;
		counter++;
		return uuid;
	}
}
