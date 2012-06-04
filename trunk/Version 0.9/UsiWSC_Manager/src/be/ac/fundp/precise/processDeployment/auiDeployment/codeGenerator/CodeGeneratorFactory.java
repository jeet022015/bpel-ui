package be.ac.fundp.precise.processDeployment.auiDeployment.codeGenerator;

import be.ac.fundp.precise.processDeployment.auiDeployment.codeGenerator.defaultGenerator.CodeGeneratorUsiWSC;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating CodeGenerator objects.
 */
public class CodeGeneratorFactory {
	
	/**
	 * Code gen usi wsc.
	 *
	 * @return the code generator
	 */
	public static CodeGenerator codeGenUsiWSC() {
		return new CodeGeneratorUsiWSC();
	}

}
