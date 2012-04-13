package be.edu.fundp.precise.uibpel.model.util;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.Catch;
import org.eclipse.bpel.model.ElseIf;
import org.eclipse.bpel.model.ExtensionActivity;
import org.eclipse.bpel.model.Flow;
import org.eclipse.bpel.model.ForEach;
import org.eclipse.bpel.model.If;
import org.eclipse.bpel.model.OnAlarm;
import org.eclipse.bpel.model.OnEvent;
import org.eclipse.bpel.model.OnMessage;
import org.eclipse.bpel.model.Pick;
import org.eclipse.bpel.model.RepeatUntil;
import org.eclipse.bpel.model.Scope;
import org.eclipse.bpel.model.Sequence;
import org.eclipse.bpel.model.While;

import be.edu.fundp.precise.uibpel.model.EventHandlerUI;
import be.edu.fundp.precise.uibpel.model.OnUserEvent;
import be.edu.fundp.precise.uibpel.model.PickUI;
import be.edu.fundp.precise.uibpel.model.ScopeUI;

public class UiBpelModelHelper {

	static public Activity findMe(ExtensionActivity me, Activity activity) {
		Activity aux = null;
		System.out.println("AAAAAAAAAAA="+activity);
		if (activity instanceof ExtensionActivity) {
			System.out.println("test="+activity.getName());
			return verifyMe(me, (ExtensionActivity)activity);
		}
		
		if (activity instanceof ScopeUI) {
			ScopeUI scope = (ScopeUI)activity;
			EventHandlerUI handler = (EventHandlerUI) scope.getEventHandlers();
			if (handler.getUserInteraction() != null) {
				for (OnUserEvent inAct : handler.getUserInteraction()){
					aux = findMe(me, inAct.getActivity()); 
					if (aux != null)
						return aux;
				}
			}
		} else if (activity instanceof PickUI){
			PickUI scope = (PickUI)activity;
			if (scope.getUserInteraction() != null) {
				for (OnUserEvent inAct : scope.getUserInteraction()){
					aux = findMe(me, inAct.getActivity()); 
					if (aux != null)
						return aux;
				}
			}
		}
		
		if (activity instanceof Flow)
			for (Activity inAct : ((Flow) activity).getActivities()){
				aux = findMe(me, inAct); 
				if (aux != null)
					return aux;
			}	 
		else if (activity instanceof If) {
			If f = (If) activity;
			aux = findMe(me, f.getActivity());
			if (aux != null)
				return aux;
			if (f.getElse() != null) {
				aux = findMe(me, f.getElse().getActivity());
				if (aux != null)
					return aux;
			}
			for (ElseIf anElseIf : f.getElseIf()) {
				aux = findMe(me, anElseIf.getActivity());
				if (aux != null)
					return aux;
			}
		} else if (activity instanceof While) {
			aux = findMe(me, ((While) activity).getActivity()); 
			if (aux != null)
				return aux;
		}
		else if (activity instanceof Sequence)
			for (Activity intAct : ((Sequence) activity).getActivities()) {
				aux = findMe(me, intAct); 
				if (aux != null)
					return aux;
			}
		else if (activity instanceof Pick) {
			Pick f = (Pick) activity;
			for (OnAlarm intAct : f.getAlarm()){
				aux = findMe(me, intAct.getActivity()); 
				if (aux != null)
					return aux;
			}
			for (OnMessage intAct : f.getMessages()) {
				aux = findMe(me, intAct.getActivity()); 
				if (aux != null)
					return aux;
			}
		} else if (activity instanceof Scope) {
			Scope scope = (Scope) activity;
			if (scope.getFaultHandlers() != null) {
				for (Catch c : scope.getFaultHandlers().getCatch()){
					aux = findMe(me, c.getActivity()); 
					if (aux != null)
						return aux;
				}
				if (scope.getFaultHandlers().getCatchAll() != null) {
					aux = findMe(me, scope.getFaultHandlers().getCatchAll()
							.getActivity()); 
					if (aux != null)
						return aux;
				}
			}
			if (scope.getTerminationHandler() != null) {
				aux = findMe(me, scope.getTerminationHandler().getActivity()); 
				if (aux != null)
					return aux;
			}
			if (scope.getEventHandlers() != null) {
				for (OnAlarm alarm : scope.getEventHandlers().getAlarm()) {
					aux = findMe(me, alarm.getActivity()); 
					if (aux != null)
						return aux;
				}
				for (OnEvent alarm : scope.getEventHandlers().getEvents()) {
					aux = findMe(me, alarm.getActivity()); 
					if (aux != null)
						return aux;
				}
			}
			if (scope.getActivity() != null){
				aux = findMe(me, scope.getActivity()); 
				if (aux != null)
					return aux;
			}
		}
		else if (activity instanceof ForEach) {
			aux = findMe(me, ((ForEach) activity).getActivity()); 
			if (aux != null)
				return aux;
		}
		else if (activity instanceof RepeatUntil) {
			aux = findMe(me, ((RepeatUntil) activity).getActivity()); 
			if (aux != null)
				return aux;
		}
		return null;
	}

	static private Activity verifyMe(ExtensionActivity me, ExtensionActivity activity) {
		System.out.println("test="+activity.getName());
		System.out.println("me="+me.getName());
		if (activity.getName().equals(me.getName()))
			return activity;
		return null;
	}
}
