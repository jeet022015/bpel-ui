package be.ac.fundp.precise.processDeployment.auiDeployment.codeGenerator.defaultGenerator;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import be.ac.fundp.precise.FileManager;
import be.ac.fundp.precise.processDeployment.auiDeployment.AuiRoleMapper;
import be.ac.fundp.precise.processDeployment.auiDeployment.codeGenerator.CodeGenerator;
import be.ac.fundp.precise.processDeployment.auiDeployment.codeGenerator.context.ContextMapper;
import be.ac.fundp.precise.processDeployment.auiDeployment.codeGenerator.context.UserContext;
import be.ac.fundp.precise.processDeployment.auiDeployment.codeGenerator.xml.AbstractCompoundIU;
import be.ac.fundp.precise.processDeployment.auiDeployment.codeGenerator.xml.AbstractDataIU;
import be.ac.fundp.precise.processDeployment.auiDeployment.codeGenerator.xml.AbstractDataIUType;
import be.ac.fundp.precise.processDeployment.auiDeployment.codeGenerator.xml.AbstractInteractionUnit;
import be.ac.fundp.precise.processDeployment.auiDeployment.codeGenerator.xml.AbstractSelectionIU;
import be.ac.fundp.precise.processDeployment.auiDeployment.codeGenerator.xml.AbstractUIModel;
import be.ac.fundp.precise.processDeployment.auiDeployment.codeGenerator.xml.ObjectFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class CodeGeneratorUsiWSC.
 */
public class CodeGeneratorUsiWSC implements CodeGenerator {
	
	/** The file diff. */
	private static int fileDiff = 1;

	/**
	 * Gets the template folder path.
	 *
	 * @param context the context
	 * @return the template folder path
	 */
	public String getTemplateFolderPath(UserContext context) {
		return FileManager.getRootPath() + context.getPath();

	}

	/**
	 * Parses the.
	 *
	 * @param compound the compound
	 * @param templatePath the template path
	 * @param template the template
	 * @return the string
	 */
	private String parse(AbstractCompoundIU compound, String templatePath,
			String template) {
		VelocityEngine ve = new VelocityEngine();
		Properties p = new Properties();
		p.put(CodeGeneratorConstants.VELOCITY_FILE_PATH, templatePath);
		p.put(CodeGeneratorConstants.VELOCITY_FILE_CACHE, CodeGeneratorConstants.VELOCITY_FILE_CACHE_TRUE);
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
		context.put( CodeGeneratorConstants.VELOCITY_PARAMETER_OUTPUT, outputItems);
		context.put(CodeGeneratorConstants.VELOCITY_PARAMETER_INPUT, inputItems);
		context.put(CodeGeneratorConstants.VELOCITY_PARAMETER_ACTION, "/UsiWSC_WebClient/interactionManager");

		StringWriter writer = new StringWriter();
		t.merge(context, writer);

		return writer.toString();
	}

	/* (non-Javadoc)
	 * @see be.ac.fundp.precise.processDeployment.auiDeployment.codeGenerator.CodeGenerator#adapt(be.ac.fundp.precise.processDeployment.auiDeployment.AuiRoleMapper, java.lang.String)
	 */
	@Override
	public String adapt(AuiRoleMapper roleMapper, String contextId) throws IOException {
		UserContext userContext = ContextMapper.map(contextId);
		Map<String, String> codes = createCodes(roleMapper, userContext);
		File zipCodeFile = File.createTempFile("tempFile"+fileDiff++, "zip");
		zipCodeFile.deleteOnExit();

		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipCodeFile));
		for (String codeName : codes.keySet()) {
			String code = codes.get(codeName);
			InputStream in1 = new ByteArrayInputStream(code.getBytes( Charset.defaultCharset()));
			newEntry(out, in1, codeName);
		}
		Map<String, String> auxFiles = userContext.getAuxEntries();
		for (String newEntry : auxFiles.keySet()) {
			InputStream in1 = new FileInputStream(auxFiles.get(newEntry));
			newEntry(out, in1, newEntry);
		}
		out.close();
		return zipCodeFile.getCanonicalPath();
	}

	/**
	 * New entry.
	 *
	 * @param out the out
	 * @param in1 the in1
	 * @param codeName the code name
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws FileNotFoundException the file not found exception
	 */
	private void newEntry(ZipOutputStream out, InputStream in1,
			String codeName) throws IOException,
			FileNotFoundException {
		byte[] buf = new byte[2048];
		out.putNextEntry(new ZipEntry(codeName));
		
		int len;
		while ((len = in1.read(buf)) > 0) {
			out.write(buf, 0, len);
		}
		out.closeEntry();
		in1.close();
	}

	/**
	 * Creates the codes.
	 *
	 * @param roleMapper the role mapper
	 * @param userContext the user context
	 * @return the map
	 */
	private Map<String, String> createCodes(AuiRoleMapper roleMapper, UserContext userContext) {
		Map<String, String> codes = new HashMap<String, String>();
		try {
			ObjectFactory of = new ObjectFactory();
			AbstractUIModel model = of.createAbstractUIModel();
			JAXBContext jaxbContext = JAXBContext.newInstance(model.getClass());
			File f = new File(roleMapper.getAuiFile());
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			model = (AbstractUIModel) unmarshaller.unmarshal(f);
			for (AbstractCompoundIU compound : model.getAbstractCompoundIUs()) {
				String activityCode;
				if (compound instanceof AbstractSelectionIU)
					activityCode = parse(compound,
							getTemplateFolderPath(userContext),
							userContext.getDataSelectionTemplate());
				else
					activityCode = parse(compound,
							getTemplateFolderPath(userContext),
							userContext.getDataInteractionTemplate());
				System.out.println("activityCode="+activityCode);
				codes.put(compound.getId() + userContext.getTermination(), activityCode);
			}
			return codes;
		} catch (JAXBException e) {
			e.printStackTrace();
			return Collections.emptyMap();
		}
	}

	/* (non-Javadoc)
	 * @see be.ac.fundp.precise.processDeployment.auiDeployment.codeGenerator.CodeGenerator#codeAdaptation(be.ac.fundp.precise.processDeployment.auiDeployment.AuiRoleMapper, java.lang.String)
	 */
	@Override
	public Map<String, String> codeAdaptation(AuiRoleMapper roleMapper,
			String contextId) {
		Map<String, String> uiMapping = roleMapper.getUiMapper();
		UserContext userContext = ContextMapper.map(contextId);
		for (String uiId : uiMapping.keySet()) {
			uiMapping.put(uiId, uiMapping.get(uiId) + userContext.getTermination());
		}
		return uiMapping;
	}
}