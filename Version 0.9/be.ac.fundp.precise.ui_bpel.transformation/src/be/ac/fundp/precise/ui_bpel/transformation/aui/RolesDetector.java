package be.ac.fundp.precise.ui_bpel.transformation.aui;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.Catch;
import org.eclipse.bpel.model.ElseIf;
import org.eclipse.bpel.model.EventHandler;
import org.eclipse.bpel.model.ExtensionActivity;
import org.eclipse.bpel.model.FaultHandler;
import org.eclipse.bpel.model.Flow;
import org.eclipse.bpel.model.If;
import org.eclipse.bpel.model.Invoke;
import org.eclipse.bpel.model.OnAlarm;
import org.eclipse.bpel.model.OnEvent;
import org.eclipse.bpel.model.OnMessage;
import org.eclipse.bpel.model.Pick;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.Scope;
import org.eclipse.bpel.model.Sequence;
import org.eclipse.bpel.ui.util.ModelHelper;

import be.edu.fundp.precise.uibpel.model.DataInteraction;
import be.edu.fundp.precise.uibpel.model.EventHandlerUI;
import be.edu.fundp.precise.uibpel.model.OnUserEvent;
import be.edu.fundp.precise.uibpel.model.PickUI;
import be.edu.fundp.precise.uibpel.model.ScopeUI;
import be.edu.fundp.precise.uibpel.model.UserRole;

// TODO: Auto-generated Javadoc
/**
 * The Class RolesDetector.
 *
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 */
public class RolesDetector {
	
	/**
	 * Gets the roles.
	 *
	 * @param context the context
	 * @return the roles
	 */
	public static List<String> getRoles(Object context) {
		List<String> roles = new LinkedList<String>();
		getRoleModels(context, roles);
		return roles;
	}
	
	
	/**
	 * Gets the role models.
	 *
	 * @param context the context
	 * @param roles the roles
	 * @return the role models
	 */
	protected static void getRoleModels(Object context, List<String> roles) {
		
		if (context == null)
			return;
		
		if (context instanceof Process){
			Process process = (Process)context;
			EventHandler eventHandler = process.getEventHandlers();
			if (eventHandler !=null) {
				for (OnAlarm aAlarm : eventHandler.getAlarm()) {
					getRoleModels(aAlarm, roles);
				}
				for (OnEvent aMessage : eventHandler.getEvents()) {
					getRoleModels(aMessage, roles);
				}
			}
			
			FaultHandler faultHandler = process.getFaultHandlers();
			if (faultHandler != null) {
				for (Catch aCatch : faultHandler.getCatch()) {
					getRoleModels(aCatch, roles);
				}
				getRoleModels(faultHandler.getCatchAll(), roles);
			}
		}
		
		if (context instanceof Scope){
			Scope scope = (Scope)context;
			EventHandler eventHandler = scope.getEventHandlers();
			if (eventHandler !=null) {
				for (OnAlarm aAlarm : eventHandler.getAlarm()) {
					getRoleModels(aAlarm, roles);
				}
				for (OnEvent aMessage : eventHandler.getEvents()) {
					getRoleModels(aMessage, roles);
				}
			}
			
			FaultHandler faultHandler = scope.getFaultHandlers();
			if (faultHandler != null) {
				for (Catch aCatch : faultHandler.getCatch()) {
					getRoleModels(aCatch, roles);
				}
				getRoleModels(faultHandler.getCatchAll(), roles);
			}
			
			getRoleModels(scope.getCompensationHandler(), roles);
			
			getRoleModels(scope.getTerminationHandler(), roles);
		}
		
		if (context instanceof Invoke){
			Invoke invokeAct = (Invoke)context;
			getRoleModels(invokeAct.getCompensationHandler(), roles);
		}
		
		if (context instanceof If){
			If ifAct = (If)context;
			for (ElseIf aElseIf : ifAct.getElseIf()) {
				getRoleModels(aElseIf, roles);
			}
			getRoleModels(ifAct.getElse(), roles);
		}
		
		if (context instanceof Pick){
			Pick pickAct = (Pick)context;
			for (OnAlarm aAlarm : pickAct.getAlarm()) {
				getRoleModels(aAlarm, roles);
			}
			for (OnMessage aMessage : pickAct.getMessages()) {
				getRoleModels(aMessage, roles);
			}
		}
		
		if (context instanceof Sequence){
			Sequence sequence = (Sequence)context;
			for (Activity act : sequence.getActivities()) {
				getRoleModels(act, roles);
			}
		}
		
		if (context instanceof Flow){
			Flow flow = (Flow)context;
			for (Activity act : flow.getActivities()) {
				getRoleModels(act, roles);
			}
		}
		
		if (context instanceof ExtensionActivity){
			ExtensionActivity extensionActivity = (ExtensionActivity)context;
			createRoleModels(extensionActivity, roles);
		}
		
		try {
			getRoleModels(ModelHelper.getActivity(context), roles);
		}catch (IllegalArgumentException e) {
			//this exception is expected  
		}
	}

	/**
	 * Creates the role models.
	 *
	 * @param extensionActivity the extension activity
	 * @param roles the roles
	 */
	protected static void createRoleModels(
			ExtensionActivity extensionActivity, List<String> roles) {
		if (extensionActivity instanceof DataInteraction){
			DataInteraction aDataInt = (DataInteraction)extensionActivity;
			for (UserRole aRole : aDataInt.getUserRoles()) {
				roles.add(aRole.getRoleId());
			}
		}
		if (extensionActivity instanceof ScopeUI){
			ScopeUI scopeUIAct = (ScopeUI)extensionActivity;
			if (scopeUIAct.getEventHandlers() instanceof EventHandlerUI){
				EventHandlerUI eventHandler = (EventHandlerUI) scopeUIAct.getEventHandlers();
				for (OnUserEvent aUserEvent : eventHandler.getUserInteraction()) {
					getRoleModels(aUserEvent.getActivity(), roles);
				}
			}
		}
		if (extensionActivity instanceof PickUI){
			PickUI pickUIAct = (PickUI)extensionActivity;
			for (OnUserEvent aUserEvent : pickUIAct.getUserInteraction()) {
				getRoleModels(aUserEvent.getActivity(), roles);
			}
		}
	}
}