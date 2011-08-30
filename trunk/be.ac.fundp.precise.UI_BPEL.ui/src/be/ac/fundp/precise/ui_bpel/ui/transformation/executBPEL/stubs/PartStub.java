package be.ac.fundp.precise.ui_bpel.ui.transformation.executBPEL.stubs;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.wst.wsdl.Message;
import org.eclipse.wst.wsdl.internal.impl.PartImpl;

@SuppressWarnings("restriction")
public class PartStub extends PartImpl{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1613642582739568520L;

	public PartStub(Resource resource, Message message, String name){
		super();
		this.name = name;
	}
	
	 @Override
		public boolean eIsProxy()
	    {
	        return false;
	    }
	    
	    @Override
		public String getName()
	    {
	        return name;
	    }

}
