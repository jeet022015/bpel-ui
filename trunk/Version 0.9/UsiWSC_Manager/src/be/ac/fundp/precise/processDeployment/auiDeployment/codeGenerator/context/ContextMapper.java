package be.ac.fundp.precise.processDeployment.auiDeployment.codeGenerator.context;

import java.util.HashMap;
import java.util.Map;

/**
 * The Class ContextMapper is responsible to provide the relevant information
 * to generate the code for a specific context.
 */
public class ContextMapper {

	/** The context map. */
	private static Map<String, UserContext> contextMap = new HashMap<String, UserContext>();
	
	static {
		contextMap.put("html", new HtmlContext());
	}
	
	/**
	 * Map a context id for a specific UserContext.
	 *
	 * @param contextId the context id
	 * @return the user context
	 */
	public static UserContext map(String contextId){
		if (contextMap.keySet().contains(contextId))
			return contextMap.get(contextId);
		return new HtmlContext();
	}
}
