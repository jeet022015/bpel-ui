package be.ac.precise.usixml.androidapp.service;

import org.restlet.Component;
import org.restlet.Server;
import org.restlet.data.Protocol;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import be.ac.precise.usixml.androidapp.service.server.AndroidServerApplication;

public class RestService extends Service {

	protected Component component;
	
	public static boolean isrunning = false;
	
	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}
	
	@Override
	public void onCreate() {
		if (isrunning)
			return;
		
		System.setProperty("java.net.preferIPv6Addresses", "false");

		// Create a new Component.  
		Component component = new Component();  
	  
	    Server server = new Server(Protocol.HTTP, 8182);
	    component.getServers().add(server);
	    
	    // Attach the sample application.  
	    component.getDefaultHost().attach("",  
	            new AndroidServerApplication());  
	  
	    // Start the component.  
	    try {
			component.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	    isrunning = true;
	}
	
	@Override
	public void onDestroy(){
		isrunning = false;
		try {
			component.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
