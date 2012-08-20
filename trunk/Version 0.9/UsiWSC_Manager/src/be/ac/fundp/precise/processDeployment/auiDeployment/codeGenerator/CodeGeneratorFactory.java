package be.ac.fundp.precise.processDeployment.auiDeployment.codeGenerator;

import be.ac.fundp.precise.processDeployment.auiDeployment.codeGenerator.defaultGenerator.CodeGeneratorUsiWSC;

/**
 * A factory for creating CodeGenerator objects.
 */
public class CodeGeneratorFactory {
	
	/**
	 * Create a code generator for the UsiXML Code Generator.
	 *
	 * @return the code generator
	 */
	public static CodeGenerator codeGenUsiWSC() {
		return new CodeGeneratorUsiWSC();
	}

}
