package be.ac.fundp.precise.ui_bpel.ui.transformation.executableBPEL;

// TODO: Auto-generated Javadoc
/**
 * The Class InitializationContants.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 */
public class InitializationContants {

	/** The Constant NL. */
	private static final String NL = System.getProperty("line.separator");
		
	/** The Constant COMMON_BODY. */
	public static final String COMMON_BODY = "xmlns:ns=\"http://fundp.ac.be\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"> " +NL+
			 								 "   <id>id</id> " + NL +
			 								 "   <role>role</role> " + NL + 
	 								  		 "   <processId>processId</processId>" + NL;
	
	//FIXME put a counter here
	/** The Constant DATA_HEAD. */
	public static final String DATA_HEAD =   		    "   <data> " + NL;
	
	/** The Constant DATA_ITEM_HEAD_STRING. */
	public static final String DATA_ITEM_HEAD_STRING =  "<data xmlns:s1=\"http://www.w3.org/2001/XMLSchema-instance\" " +
			 								 		    "xmlns:s2=\"http://www.w3.org/2001/XMLSchema\" " +
			 								 		    "s1:type=\"s2:string\">";
	
	/** The Constant DATA_TAIL. */
	public static final String DATA_TAIL = 			    "</data>";
	
	/** The Constant DATA_ITEM. */
	public static final String DATA_ITEM  =   			"        "+DATA_ITEM_HEAD_STRING + "data" + DATA_TAIL + " " + NL +
			 								  			"        <type>type</type> " + NL +
			 								  			"        <id>id</id> " + NL;
	
	/** The Constant OUTPUT_HEAD. */
	public static final String OUTPUT_HEAD = "<tns:outputOperation ";
	
	/** The Constant OUTPUT_TAIL. */
	public static final String OUTPUT_TAIL = "</tns:outputOperation>";

	/** The Constant INPUT_HEAD. */
	public static final String INPUT_HEAD = "<tns:inputOperation ";
	
	/** The Constant INPUT_TAIL. */
	public static final String INPUT_TAIL = "</tns:inputOperation>";

	/** The Constant SELECTION_HEAD. */
	public static final String SELECTION_HEAD = "<tns:selectionOperation ";
	
	/** The Constant SELECTION_TAIL. */
	public static final String SELECTION_TAIL = "</tns:selectionOperation>";

}
