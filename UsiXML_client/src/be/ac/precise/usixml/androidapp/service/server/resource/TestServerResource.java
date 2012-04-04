package be.ac.precise.usixml.androidapp.service.server.resource;

import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.Put;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

public class TestServerResource  extends ServerResource {
	
	@Get
	public Representation retrieve() {
		return new StringRepresentation("Web service on");
	}

	@Put
	public void assyncPut(Representation entity) throws ResourceException {
		System.out.println("test.");
	}
}