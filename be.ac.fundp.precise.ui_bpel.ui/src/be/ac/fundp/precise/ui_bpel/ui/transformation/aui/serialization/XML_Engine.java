package be.ac.fundp.precise.ui_bpel.ui.transformation.aui.serialization;

import java.io.IOException;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import be.ac.fundp.precise.ui_bpel.ui.transformation.aui.model.core.AbstractComponentIU;
import be.ac.fundp.precise.ui_bpel.ui.transformation.aui.model.core.DataIU;
import be.ac.fundp.precise.ui_bpel.ui.transformation.aui.model.core.InteractionUnitIF;
import be.ac.fundp.precise.ui_bpel.ui.transformation.aui.model.core.SelectionUI;
import be.ac.fundp.precise.ui_bpel.ui.transformation.aui.model.core.TriggerUI;
import be.ac.fundp.precise.ui_bpel.ui.transformation.aui.serialization.xml.AbstractCompoundIU;
import be.ac.fundp.precise.ui_bpel.ui.transformation.aui.serialization.xml.AbstractDataIU;
import be.ac.fundp.precise.ui_bpel.ui.transformation.aui.serialization.xml.AbstractDataIUType;
import be.ac.fundp.precise.ui_bpel.ui.transformation.aui.serialization.xml.AbstractInteractionUnit;
import be.ac.fundp.precise.ui_bpel.ui.transformation.aui.serialization.xml.AbstractLocalization;
import be.ac.fundp.precise.ui_bpel.ui.transformation.aui.serialization.xml.AbstractSelectionIU;
import be.ac.fundp.precise.ui_bpel.ui.transformation.aui.serialization.xml.AbstractTriggerIU;
import be.ac.fundp.precise.ui_bpel.ui.transformation.aui.serialization.xml.AbstractTriggerIUType;
import be.ac.fundp.precise.ui_bpel.ui.transformation.aui.serialization.xml.AbstractUIModel;
import be.ac.fundp.precise.ui_bpel.ui.transformation.aui.serialization.xml.DataTypeType;
import be.ac.fundp.precise.ui_bpel.ui.transformation.aui.serialization.xml.ObjectFactory;
import be.ac.fundp.precise.ui_bpel.ui.transformation.aui.serialization.xml.SelectionType;

/**
 * This class represent an engine that allow the serialization of a AUI in XML.
 * The serialization is based on the XSD, proposed by the UsiXML project.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date Dez 9, 2011
 */
public class XML_Engine {

	/** The of. */
	protected ObjectFactory of = new ObjectFactory();
	
	/**
	 * Serialize the core model in XML.
	 *
	 * @param roleModel the AbstractUIModel
	 * @param out the OutputStream where the XML must be saved 
	 */
	public void serialize(be.ac.fundp.precise.ui_bpel.ui.transformation.aui.model.core.AbstractUIModel roleModel, OutputStream out3) {
		AbstractUIModel model = of.createAbstractUIModel();
		JAXBContext jaxbContext;
		try {
			for (AbstractComponentIU aComponent : roleModel.getInnerAbstractCompoundIU()) {
				AbstractInteractionUnit comp = parseComponentUI(aComponent);
				model.getAbstractCompoundIUs().add((AbstractCompoundIU) comp);
			}
			jaxbContext = JAXBContext.newInstance("be.ac.fundp.precise.ui_bpel.ui.transformation.aui.serialization.xml");
			Marshaller marshaller =jaxbContext.createMarshaller();
			marshaller.marshal(model, out3) ;
			out3.close();
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Parses the component ui.
	 *
	 * @param aComponent the a component
	 * @return the abstract interaction unit
	 */
	private AbstractInteractionUnit parseComponentUI(
			InteractionUnitIF aComponent) {
		if (aComponent instanceof SelectionUI){
			SelectionUI anotherData = (SelectionUI)aComponent;
			AbstractSelectionIU comp = of.createAbstractSelectionIU();
			comp.setId(anotherData.getId());
			comp.setSelectionType(SelectionType.UNDEFINED);
			for (InteractionUnitIF inner : anotherData.getInnerInteractionUnits()) {
				AbstractInteractionUnit aUnit = parseComponentUI(inner);
				comp.getAbstractInteractionUnit().add(aUnit);
			}
			return comp;
		} else if (aComponent instanceof AbstractComponentIU){
			AbstractComponentIU anotherComp = (AbstractComponentIU)aComponent;
			AbstractCompoundIU comp = of.createAbstractCompoundIU();
			comp.setId(anotherComp.getId());
			for (InteractionUnitIF inner : anotherComp.getInnerInteractionUnits()) {
				AbstractInteractionUnit aUnit = parseComponentUI(inner);
				comp.getAbstractInteractionUnit().add(aUnit);
			}
			return comp;
		} else if (aComponent instanceof DataIU){
			DataIU anotherData = (DataIU)aComponent;
			AbstractDataIU comp = of.createAbstractDataIU();
			comp.setId(anotherData.getLabel());
			comp.setDataType(DataTypeType.TEXT);
			if (anotherData.getUiType() == DataIU.INPUT){
				comp.setDataIUType(AbstractDataIUType.INPUT);
			}else {
				comp.setDataIUType(AbstractDataIUType.OUTPUT);
			}
			AbstractLocalization loc = of.createAbstractLocalization();
			loc.setLabel(anotherData.getLabel());
			loc.setLang("ENG");
			comp.getName().add(loc);
			return comp;
		} else if (aComponent instanceof TriggerUI){
			TriggerUI anotherData = (TriggerUI)aComponent;
			AbstractTriggerIU comp = of.createAbstractTriggerIU();
			comp.setId(anotherData.getId());
			comp.setTriggerIUType(AbstractTriggerIUType.OPERATION_NAVIGATION);
			return comp;
		}
		return null;
	}

}
