package be.ac.fundp.precise.ui_bpel.ui.transformation.executBPEL;

public class InitializationContants {

	private static final String NL = System.getProperty("line.separator");
		
	public static final String COMMON_BODY = "xmlns:ns=\"http://fundp.ac.be\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"> " +NL+
			 								 "   <id>id</id> " + NL +
			 								 "   <role>role</role> " + NL + 
	 								  		 "   <processId>processId</processId>" + NL;
	
	//FIXME put a counter here
	public static final String DATA_HEAD =   		    "   <data> " + NL;
	public static final String DATA_ITEM_HEAD_STRING =  "<data xmlns:s1=\"http://www.w3.org/2001/XMLSchema-instance\" " +
			 								 		    "xmlns:s2=\"http://www.w3.org/2001/XMLSchema\" " +
			 								 		    "s1:type=\"s2:string\">";
	public static final String DATA_TAIL = 			    "</data>";
	public static final String DATA_ITEM  =   			"        "+DATA_ITEM_HEAD_STRING + "data" + DATA_TAIL + " " + NL +
			 								  			"        <type>type</type> " + NL +
			 								  			"        <id>id</id> " + NL;
	
	public static final String OUTPUT_HEAD = "<tns:outputOperation ";
	public static final String OUTPUT_TAIL = "</tns:outputOperation>";

	public static final String INPUT_HEAD = "<tns:inputOperation ";
	public static final String INPUT_TAIL = "</tns:inputOperation>";

	public static final String SELECTION_HEAD = "<tns:selectionOperation ";
	public static final String SELECTION_TAIL = "</tns:selectionOperation>";

}
