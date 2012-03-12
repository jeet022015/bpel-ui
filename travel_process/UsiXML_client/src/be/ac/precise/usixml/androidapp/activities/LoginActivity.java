package be.ac.precise.usixml.androidapp.activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.PopupWindow;
import be.ac.precise.usixml.androidapp.ActivityManager;
import be.ac.precise.usixml.androidapp.R;
import be.ac.precise.usixml.androidapp.service.RestService;
import be.ac.precise.usixml.androidapp.util.AndroidAppConstants;

public class LoginActivity extends Activity {

	protected ActivityManager actManager = ActivityManager.getInstance();
	
	protected PopupWindow pw;

	protected static boolean isloged = false;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		actManager.setNotificationAct(LoginActivity.this);
		final Intent myIntent = new Intent(LoginActivity.this,
				AvailableProcessesActivity.class);

		if (isloged) {
			myIntent.putExtra(AndroidAppConstants.PARAM_ROLE, "myRole");
			startActivity(myIntent);
			finish();
			return;
		}
		
		setContentView(R.layout.login_page);
		Button btnBack = (Button) findViewById(R.id.buttonLogin1);
		btnBack.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
	        	initiatePopupWindow();
				isloged = true;
			}
		});
		

		if (!RestService.isrunning)
			startService(new Intent(this, RestService.class));
	}
	
	private void initiatePopupWindow() {
		//set up dialog
        final Dialog dialog = new Dialog(LoginActivity.this);
        dialog.setContentView(R.layout.maindialog);
        dialog.setTitle("UsiXML Login");
        dialog.setCancelable(true);

        //set up button
        Button button = (Button) dialog.findViewById(R.id.Button01);
        button.setOnClickListener(new OnClickListener() {
        @Override
            public void onClick(View v) {
        		dialog.dismiss();
        		LoginActivity.this.finish();
            }
        });
        //now that the dialog is set up, it's time to show it    
        dialog.show();
	}
}