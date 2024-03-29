package be.ac.fundp.uimanager.provider;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

// TODO: Auto-generated Javadoc
/**
 * This class was generated by Apache CXF 2.5.0
 * 2011-11-20T15:08:02.561+01:00
 * Generated source version: 2.5.0
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dec 9, 2011
 */
@WebService(targetNamespace = "http://fundp.ac.be/UiManager/", name = "UiManager")
@XmlSeeAlso({ObjectFactory.class})
public interface UiManager {

    /**
     * Input operation.
     *
     * @param userInteracId the user interac id
     * @param role the role
     * @param processId the process id
     * @return the java.util. list
     */
    @WebResult(name = "data", targetNamespace = "")
    @RequestWrapper(localName = "inputOperation", targetNamespace = "http://fundp.ac.be/UiManager/", className = "be.ac.fundp.uimanager.provider.InputOperation")
    @WebMethod(action = "http://fundp.ac.be/UiManager/inputOperation")
    @ResponseWrapper(localName = "inputOperationResponse", targetNamespace = "http://fundp.ac.be/UiManager/", className = "be.ac.fundp.uimanager.provider.InputOperationResponse")
    public java.util.List<be.ac.fundp.uimanager.provider.UiDataType> inputOperation(
        @WebParam(name = "userInteracId", targetNamespace = "")
        java.lang.String userInteracId,
        @WebParam(name = "role", targetNamespace = "")
        java.lang.String role,
        @WebParam(name = "processId", targetNamespace = "")
        java.lang.String processId
    );

    /**
     * Selection operation.
     *
     * @param userInteracId the user interac id
     * @param role the role
     * @param processId the process id
     * @param data the data
     * @return the java.util. list
     */
    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "selectionOperation", targetNamespace = "http://fundp.ac.be/UiManager/", className = "be.ac.fundp.uimanager.provider.SelectionOperation")
    @WebMethod(action = "http://fundp.ac.be/UiManager/selectionOperation")
    @ResponseWrapper(localName = "selectionOperationResponse", targetNamespace = "http://fundp.ac.be/UiManager/", className = "be.ac.fundp.uimanager.provider.SelectionOperationResponse")
    public java.util.List<be.ac.fundp.uimanager.provider.UiDataType> selectionOperation(
        @WebParam(name = "userInteracId", targetNamespace = "")
        java.lang.String userInteracId,
        @WebParam(name = "role", targetNamespace = "")
        java.lang.String role,
        @WebParam(name = "processId", targetNamespace = "")
        java.lang.String processId,
        @WebParam(name = "data", targetNamespace = "")
        java.util.List<be.ac.fundp.uimanager.provider.UiDataType> data
    );

    /**
     * Output operation.
     *
     * @param userInteracId the user interac id
     * @param role the role
     * @param processid the processid
     * @param data the data
     */
    @Oneway
    @RequestWrapper(localName = "outputOperation", targetNamespace = "http://fundp.ac.be/UiManager/", className = "be.ac.fundp.uimanager.provider.OutputOperation")
    @WebMethod(action = "http://fundp.ac.be/UiManager/outputOperation")
    public void outputOperation(
        @WebParam(name = "userInteracId", targetNamespace = "")
        java.lang.String userInteracId,
        @WebParam(name = "role", targetNamespace = "")
        java.lang.String role,
        @WebParam(name = "processid", targetNamespace = "")
        java.lang.String processid,
        @WebParam(name = "data", targetNamespace = "")
        java.util.List<be.ac.fundp.uimanager.provider.UiDataType> data
    );

    /**
     * Generate process id.
     *
     * @return the java.lang. string
     */
    @WebResult(name = "processId", targetNamespace = "")
    @RequestWrapper(localName = "generateProcessId", targetNamespace = "http://fundp.ac.be/UiManager/", className = "be.ac.fundp.uimanager.provider.GenerateProcessId")
    @WebMethod(action = "http://fundp.ac.be/UiManager/generateProcessId")
    @ResponseWrapper(localName = "generateProcessIdResponse", targetNamespace = "http://fundp.ac.be/UiManager/", className = "be.ac.fundp.uimanager.provider.GenerateProcessIdResponse")
    public java.lang.String generateProcessId();
}
