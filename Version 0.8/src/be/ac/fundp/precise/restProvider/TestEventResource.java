package be.ac.fundp.precise.restProvider;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

/**
 * The Class TestEventResource is used to test if the service is on.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dec 9, 2011
 */
public class TestEventResource extends ServerResource {

    /**
     * test Get HTTP.
     *
     * @return the string
     */
    @Get
    public String getTest() {
        return "works";
    }

}