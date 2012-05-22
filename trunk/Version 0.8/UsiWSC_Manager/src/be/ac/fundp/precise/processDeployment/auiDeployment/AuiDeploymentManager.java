package be.ac.fundp.precise.processDeployment.auiDeployment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.json.JSONException;

import com.google.common.io.Files;

public class AuiDeploymentManager {

	protected static AuiDeploymentManager self;
	
	protected Map<String, File> roleCode = new HashMap<String, File>();
	protected Map<String, Map<String, String>> roleConf = 
			new HashMap<String, Map<String, String>>();

	protected AuiDeploymentManager() {

	}

	public static AuiDeploymentManager getInstance() {
		if (self == null)
			self = new AuiDeploymentManager();
		return self;
	}

	public void deploy(String processName, Map<String, String> auiDescription,
			byte[] file, Map<String, Map<String, String>> roleConf2) 
					throws IOException, JSONException {
		AuiExtractor extractor = new AuiExtractor(file, auiDescription);
		List<AuiRole> roles = extractor.getAllRoles();

		CodeGenerator codeGenerator = CodeGeneratorFactory.codeGenUsiWSC();
		for (AuiRole auiRole : roles) {
			UserContext context = new HtmlContext();
			Map<String, String> codes = codeGenerator.genCode(auiRole, context);
			Map<String, String> ui2code = serializeCode(codes, processName, 
					auiRole.getRoleName(),
					context.toString());
			Map<String, String> ui2cui = roleConf2.get(auiRole.roleName);
			Map<String, String> put = new HashMap<String, String>();
			for (String ui : ui2cui.keySet()) {
				put.put(ui, ui2code.get(ui2cui.get(ui)));
			}
			System.out.println("put Keys= "+put.keySet());
			System.out.println("put => Keys= "+put.values());
			this.roleConf.put(processName+auiRole.roleName, put);
		}

	}

	private Map<String, String> serializeCode(Map<String, String> code, String processName,
			String roleName, String context) throws IOException {
		File finalCode2=Files.createTempDir();
		Map<String, String> map = new HashMap<String, String>();
		for (String ui : code.keySet()) {
			String fileName = processName + roleName
								+ context + ui + ".jsp";
			File finalCode = new File(finalCode2.getCanonicalPath() +
					File.separator + fileName);
			if (finalCode.exists())
				finalCode.delete();
			System.out.println("ui="+ui);
			PrintWriter out = new PrintWriter(new FileWriter(finalCode));
			out.print(code.get(ui));
			out.close();
			map.put(ui, fileName);
		}
		System.out.println("roleName="+roleName);
		System.out.println("codePath="+finalCode2);
		roleCode.put(processName+roleName, finalCode2);
		return map;
	}

	public String getCode(String process, String role) {
		System.out.println("roleCode="+roleCode.keySet());
		if (roleCode.keySet().contains(process+role))
			return createZipFile(roleCode.get(process+role));
		return null;
	}

	/**
	 * This method creates the zip file to be deployed.
	 *
	 * @throws CoreException the core exception
	 */
	protected String createZipFile(File folderPath){
		File r = new File (folderPath.getAbsolutePath()+File.separator+"target.zip");
		File parent = r.getParentFile();
	    byte[] buf = new byte[1024];
	    try {
			if (r.exists()) {
				r.delete();
			}
			r.createNewFile();
	        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(r));
	        for (File aResource : parent.listFiles()) {
	        	if (aResource.getName().equals("target.zip"))
	        		continue;
	            FileInputStream in = new FileInputStream(aResource);
	            out.putNextEntry(new ZipEntry(aResource.getName()));
	            int len;
	            while ((len = in.read(buf)) > 0) {
	                out.write(buf, 0, len);
	            }
	            out.closeEntry();
	            in.close();
	        }
	        FileInputStream in1 = new FileInputStream(
	        		new File ("/Users/test/Documents/" +
	        				"workspaceBPEL-travel-scenario/UsiWSC_Manager/" +
	        				"WebContent/codeContent/main.css"));
	        out.putNextEntry(new ZipEntry("main.css"));
	        int len;
            while ((len = in1.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            out.closeEntry();
            in1.close();
	        
	        
	        
            FileInputStream in2 = new FileInputStream(
	        		new File ("/Users/test/Documents/" +
	        				"workspaceBPEL-travel-scenario/UsiWSC_Manager/" +
	        				"WebContent/codeContent/logo.png"));
	        out.putNextEntry(new ZipEntry("logo.png"));
            while ((len = in2.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            out.closeEntry();
            in2.close();
	        
            FileInputStream in3 = new FileInputStream(
	        		new File ("/Users/test/Documents/" +
	        				"workspaceBPEL-travel-scenario/UsiWSC_Manager/" +
	        				"WebContent/codeContent/logo3.png"));
	        out.putNextEntry(new ZipEntry("logo3.png"));
            while ((len = in3.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            out.closeEntry();
            in3.close();
	        out.close();
	        return r.getAbsolutePath();
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
	    return null;
	}

	public Map<String, String> getConf(String process, String role) {
		return roleConf.get(process+role);
	}
}
