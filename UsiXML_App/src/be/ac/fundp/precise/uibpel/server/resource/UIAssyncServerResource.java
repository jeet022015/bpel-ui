package be.ac.fundp.precise.uibpel.server.resource;

import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.Put;
import org.restlet.resource.ResourceException;

public class UIAssyncServerResource  extends UI_BPEL_Resource {
	
	@Get
	public Representation retrieve() {
		return new StringRepresentation("test2");
	}

	@Put
	public void assyncPut(Representation entity) throws ResourceException {
		store(entity);
	}
}