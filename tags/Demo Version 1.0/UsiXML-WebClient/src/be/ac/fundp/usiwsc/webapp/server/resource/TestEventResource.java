package be.ac.fundp.usiwsc.webapp.server.resource;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

// TODO: Auto-generated Javadoc
/**
 * The Class TestEventResource.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dec 9, 2011
 */
public class TestEventResource extends ServerResource {

    /**
     * Represent.
     *
     * @return the string
     */
    @Get
    public String represent() {
        return "works";
    }

}