
package be.ac.fundp.webapp.service.provider;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


// TODO: Auto-generated Javadoc
/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 * &lt;complexContent>
 * &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 * &lt;sequence>
 * &lt;element name="outData" type="{http://webApp.fundp.ac.be}DataItemType" maxOccurs="unbounded" minOccurs="0"/>
 * &lt;/sequence>
 * &lt;/restriction>
 * &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dec 9, 2011
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "outData"
})
@XmlRootElement(name = "requireSyncInteractionResponse")
public class RequireSyncInteractionResponse {

    /** The out data. */
    protected List<DataItemType> outData;

    /**
     * Gets the value of the outData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the outData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     * getOutData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     *
     * @return the out data
     * {@link DataItemType }
     */
    public List<DataItemType> getOutData() {
        if (outData == null) {
            outData = new ArrayList<DataItemType>();
        }
        return this.outData;
    }

}
