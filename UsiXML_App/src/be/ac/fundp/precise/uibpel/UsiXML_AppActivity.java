package be.ac.fundp.precise.uibpel;

import org.restlet.Component;
import org.restlet.Server;
import org.restlet.data.Protocol;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import be.ac.fundp.precise.uibpel.activities.ProcessInteractionActivity;
import be.ac.fundp.precise.uibpel.manager.UIManager;
import be.ac.fundp.precise.uibpel.representation.Process;
import be.ac.fundp.precise.uibpel.server.AndroidServerApplication;
import be.ac.fundp.precise.uibpel.ui.ProcessesUI;

public class UsiXML_AppActivity extends Activity {
    private static final int NOTIFICATION_ID = 0;
	private NotificationManager nNM;
	private Notification n;
	private static boolean isLoged = false;
	private static Component component;
	private UIManager uiManagerAndroid = UIManager.getInstance();
	protected ProcessesUI p;

	@Override
	protected void onStart() {
		super.onStart();
		
		//final ProcessesUI finalP = this.p;
		
		final Activity a = this;
		
		if(!isLoged){
			setContentView(R.layout.login_page);
			isLoged = true;
			Button btnBack = (Button) findViewById(R.id.buttonLogin);

			btnBack.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					finish();
				}
			});
		} else {
			if (p == null)
				p = new ProcessesUI (a);
			p.createProcessList();
			//setContentView(R.layout.processes_page);
		}
        
        //createServer();
	}
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(!isLoged){
            n = new Notification();
            nNM = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            createServer();
        }
        
        if (p == null)
        	p = new ProcessesUI (this);
    }
    
    public void showNotification(Process myProcess) {
		
		try{
			n.icon =  R.drawable.intentlogo;
		}catch (Exception e) {
			e.printStackTrace();
		}
		n.tickerText = "You have a new User Interaction";
		n.when = SystemClock.currentThreadTimeMillis();
		
		//System.out.println("show Notification = "+cuiId);
		ProcessInteractionActivity.p = myProcess;
		Intent notificationIntent = new Intent(this, ProcessInteractionActivity.class);
		notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

		p.createProcessList();
		
		PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
		
		CharSequence contentTitle = "UsiWSC";
		CharSequence contentText = "Order: "+myProcess.getName();
		
		n.setLatestEventInfo(this, contentTitle, contentText, contentIntent);
		
		n.flags |= Notification.FLAG_AUTO_CANCEL;
		
		nNM.notify(NOTIFICATION_ID, n);
		
		//System.gc();
	}
    
    @Override
    protected void onResume() {
    	super.onResume();
    	createServer();
    }

	public void hideNotification() {
		if (nNM != null)
			nNM.cancel(NOTIFICATION_ID);
		//nNM = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
	}

	private void createServer() {
		if (component == null){
			
			System.setProperty("java.net.preferIPv6Addresses", "false");
			uiManagerAndroid.registerActivity(this);
			// Create a new Component.  
		    component = new Component();  
		  
		    Server server = new Server(Protocol.HTTP, 8182);
		    component.getServers().add(server);
		    //MEGA HACK
		    server.getContext().getParameters().add("maxTotalConnections", "512");
		    
		    // Add a new HTTP server listening on port 8182.  
		    //component.getServers().add(Protocol.HTTP, 8182);  
		  
		    // Attach the sample application.  
		    component.getDefaultHost().attach("/uibpel",  
		            new AndroidServerApplication());  
		  
		    // Start the component.  
		    try {
				component.start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}