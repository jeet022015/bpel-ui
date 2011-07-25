package be.ac.fundp.precise.ui_bpel.ui.transformation.executBPEL.stubs;

import javax.xml.namespace.QName;

import org.eclipse.wst.wsdl.internal.impl.MessageImpl;

@SuppressWarnings("restriction")
public class MessageStub extends MessageImpl{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1032050173018894592L;

	public MessageStub () {
		super();
	}
	
	@Override
	public QName getQName() {
		return new QName("http://www.example.org/UI_BPEL-Mediator/", "dataInputUIRequest");
	}

}
