package be.ac.precise.usixml.androidapp;

import java.util.LinkedList;
import java.util.List;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import be.ac.precise.usixml.androidapp.activities.AvailableProcessesActivity;
import be.ac.precise.usixml.androidapp.model.Process;
import be.ac.precise.usixml.androidapp.model.UserInteraction;
import be.ac.precise.usixml.androidapp.util.AndroidAppConstants;

public class ActivityManager {

	private static final int NOTIFICATION_ID = 0;
	
	public static ActivityManager self;
	
	protected List<Process> myProcesses = new LinkedList<Process>();
	
	protected Activity notificationAct;
	
	protected Notification n;
	
	protected Intent notificationIntent;
	
	protected CharSequence role = "employee";
	
	protected ActivityManager(){
		
		n = new Notification();
	}
	
	public static ActivityManager getInstance(){
		if (self == null)
			self = new ActivityManager();
		return self;
	}
	
	public List<String> getProcessIds(CharSequence role){
		//TODO change it to deal with many roles
		List<String> processIds = new LinkedList<String>();
		for (Process aProcesss : myProcesses) {
			processIds.add(aProcesss.getId());
		}
		return processIds;
	}
	
	public synchronized Process getProcess(String id){
		for (Process existingProcess : myProcesses) {
			if (existingProcess.getId().equals(id))
				return existingProcess;
		}
		Process p = new Process(id);
		myProcesses.add(p);
		return p;
	}
	
	public UserInteraction addUserInteraction(String role, String processId, 
			String cuiId) {
		//TODO change it to deal with many roles
		Process myProcess = getProcess(processId);
		UserInteraction ui = myProcess.addUserInteraction(cuiId);
		createNotification(ui.getDisplayableName());
		return ui;
	}

	private void createNotification(CharSequence charSequence) {
		NotificationManager nNM = (NotificationManager) 
				notificationAct.getSystemService(Activity.NOTIFICATION_SERVICE);
		try{
			n.icon =  R.drawable.intentlogo;
		}catch (Exception e) {
			e.printStackTrace();
		}
		n.tickerText = "You have a new User Interaction";
		
		notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		notificationIntent.putExtra(AndroidAppConstants.PARAM_ROLE, "myRole");
		
		PendingIntent contentIntent = PendingIntent.getActivity(notificationAct,
				0, notificationIntent, 0);
		CharSequence contentTitle = "New User Interaction";
		CharSequence contentText = charSequence;
		
		n.setLatestEventInfo(notificationAct, contentTitle, contentText, contentIntent);
		
		n.flags |= Notification.FLAG_AUTO_CANCEL;
		
		nNM.notify(NOTIFICATION_ID, n);
	}

	public void setNotificationAct(Activity thisAct) {
		notificationAct = thisAct;
		notificationIntent = new Intent (thisAct, AvailableProcessesActivity.class);
	}

	public UserInteraction getDataProvidedByUser(String role, String processId,
			String cuiId) {
		Process p = getProcess(processId);
		return p.getUserInteraction(cuiId);
	}

	public void disableNotification() {
		if (!hasPedingInteractions()) {
			NotificationManager nNM = (NotificationManager) 
					notificationAct.getSystemService(Activity.NOTIFICATION_SERVICE);
			if (nNM != null)
				nNM.cancel(NOTIFICATION_ID);
		}
	}

	private boolean hasPedingInteractions() {
		for (Process innerProcess : myProcesses) {
			if (innerProcess.hasPendingAct()){
				System.out.println("has pending activities");
				return true;
			}
		}
		return false;
	}

	public CharSequence getRole() {
		return role;
	}

	public void setRole(String result) {
		role = result;
	}
	
	public void setRole(CharSequence result) {
		role = result;
	}
	
}
