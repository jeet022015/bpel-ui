package be.ac.fundp.precise.ui_bpel.ui.transformation.executBPEL;

public class InitializationContants {

	private static final String NL = System.getProperty("line.separator");
		
	public static final String COMMON_BODY = "xmlns:ns=\"http://fundp.ac.be\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"> " +NL+
			 								 "   <ns:id>ns:id</ns:id> " + NL +
			 								 "   <ns:role>ns:role</ns:role> " + NL;
	
	//FIXME put a counter here
	public static final String DATA_HEAD =   		    "   <ns:data> " + NL;
	public static final String DATA_ITEM_HEAD_STRING =  "<ns:data xmlns:s1=\"http://www.w3.org/2001/XMLSchema-instance\" " +
			 								 		    "xmlns:s2=\"http://www.w3.org/2001/XMLSchema\" " +
			 								 		    "s1:type=\"s2:string\">";
	public static final String DATA_TAIL = 			    "</ns:data>";
	public static final String DATA_ITEM  =   			"        "+DATA_ITEM_HEAD_STRING + "data" + DATA_TAIL + " " + NL +
			 								  			"        <ns:type>ns:type</ns:type> " + NL +
			 								  			"        <ns:id>ns:id</ns:id> " + NL;
	
	public static final String OUTPUT_HEAD = "<ns:outputOperation ";
	public static final String OUTPUT_TAIL = "</ns:outputOperation>";

	public static final String INPUT_HEAD = "<ns:inputOperation ";
	public static final String INPUT_TAIL = "</ns:inputOperation>";

	public static final String SELECTION_HEAD = "<ns:selectionOperation ";
	public static final String SELECTION_TAIL = "</ns:selectionOperation>";

}
