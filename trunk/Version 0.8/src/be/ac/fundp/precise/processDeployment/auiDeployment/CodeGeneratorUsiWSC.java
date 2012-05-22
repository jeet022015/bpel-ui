package be.ac.fundp.precise.processDeployment.auiDeployment;

import java.io.File;
import java.io.StringWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import be.ac.fundp.precise.processDeployment.auiDeployment.xml.AbstractCompoundIU;
import be.ac.fundp.precise.processDeployment.auiDeployment.xml.AbstractDataIU;
import be.ac.fundp.precise.processDeployment.auiDeployment.xml.AbstractDataIUType;
import be.ac.fundp.precise.processDeployment.auiDeployment.xml.AbstractInteractionUnit;
import be.ac.fundp.precise.processDeployment.auiDeployment.xml.AbstractSelectionIU;
import be.ac.fundp.precise.processDeployment.auiDeployment.xml.AbstractUIModel;
import be.ac.fundp.precise.processDeployment.auiDeployment.xml.ObjectFactory;

public class CodeGeneratorUsiWSC implements CodeGenerator {

	@Override
	public Map<String, String> genCode(AuiRole auiRole, UserContext context) {
		try {
			ObjectFactory of = new ObjectFactory();
			Map<String, String> returnMap = new HashMap<String, String>();
			AbstractUIModel model = of.createAbstractUIModel();
			JAXBContext jaxbContext = JAXBContext.newInstance(model.getClass());
			File f = new File(auiRole.getFileName().getAbsolutePath());
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			model = (AbstractUIModel) unmarshaller.unmarshal(f);
			for (AbstractCompoundIU compound : model.getAbstractCompoundIUs()) {
				String code;
				System.out.println("codePath: " + getWebInfPath());
				if (compound instanceof AbstractSelectionIU)
					code = parse(compound,
					// "/Users/test/Documents/workspaceBPEL-travel-scenario/UsiWSC_Manager/WebContent/vm-templates/",
							getWebInfPath(), "template-abstractSelection.vm");
				else
					code = parse(compound,
					// "/Users/test/Documents/workspaceBPEL-travel-scenario/UsiWSC_Manager/WebContent/vm-templates/",
							getWebInfPath(), "template-abstractData.vm");
				System.out.println("fullCode: " + code);
				returnMap.put(compound.getId(), code);
			}
			return returnMap;
		} catch (JAXBException e) {
			// TODO trant it
			e.printStackTrace();
			return new HashMap<String, String>();
		}
	}

	private static final String WEBINF = "WEB-INF";

	public String getWebInfPath() {
		String filePath = "";
		URL url = CodeGeneratorUsiWSC.class
				.getResource("CodeGeneratorUsiWSC.class");
		String className = url.getFile();
		filePath = className.substring(0,
				className.indexOf(WEBINF) + WEBINF.length());
		filePath = filePath.replaceFirst(WEBINF, "vm-templates");
		return filePath;

	}

	private String parse(AbstractCompoundIU compound, String templatePath,
			String template) {
		VelocityEngine ve = new VelocityEngine();
		Properties p = new Properties();
		p.put("file.resource.loader.path", templatePath);
		p.put("file.resource.loader.cache ", "true");
		ve.init(p);

		ArrayList<String> outputItems = new ArrayList<String>();
		ArrayList<String> inputItems = new ArrayList<String>();

		Template t = ve.getTemplate(template);
		List<AbstractInteractionUnit> inner = compound
				.getAbstractInteractionUnit();
		for (AbstractInteractionUnit innerCompound : inner) {
			if (innerCompound instanceof AbstractDataIU) {
				AbstractDataIU dataUI = (AbstractDataIU) innerCompound;
				if (dataUI.getDataIUType().equals(AbstractDataIUType.OUTPUT)) {
					outputItems.add(dataUI.getId());
				} else {
					inputItems.add(dataUI.getId());
				}
			}
		}
		VelocityContext context = new VelocityContext();
		context.put("outputElements", outputItems);
		context.put("inputElements", inputItems);

		StringWriter writer = new StringWriter();
		t.merge(context, writer);

		return writer.toString();
	}

}
