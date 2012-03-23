package be.ac.precise.usixml.androidapp.activities;

import java.io.IOException;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import be.ac.precise.usixml.androidapp.ActivityManager;
import be.ac.precise.usixml.androidapp.R;
import be.ac.precise.usixml.androidapp.service.RestService;
import be.ac.precise.usixml.androidapp.util.AndroidAppConstants;
import be.ac.precise.usixml.androidapp.util.EventTrigger;

public class LoginActivity extends Activity {

	protected ActivityManager actManager = ActivityManager.getInstance();

	protected static boolean isloged = false;
	
	private CharSequence role = "";

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		actManager.setNotificationAct(LoginActivity.this);

		if (isloged) {
			Intent myIntent = new Intent(LoginActivity.this,
					AvailableProcessesActivity.class);
			myIntent.putExtra(AndroidAppConstants.PARAM_ROLE, getRole());
			startActivity(myIntent);
			finish();
			return;
		}
		
		setContentView(R.layout.login_page);
		Button btnBack = (Button) findViewById(R.id.buttonLogin1);
		btnBack.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				TextView elementView = (TextView) findViewById(R.id.login);
				CharSequence login = elementView.getText();
				elementView = (TextView) findViewById(R.id.password);
				CharSequence pw = elementView.getText();
	        	initiatePopupWindow(login, pw);
				isloged = true;
			}
		});
		
		TextView mBox = (TextView) findViewById(R.id.singup);
		mBox.setText(Html.fromHtml("<b><font color=\"#A69430\">Sign up </font><font color=\"#438699\"> to subscribe in UsiWSC</font></b>"));
		mBox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent myIntent = new Intent(LoginActivity.this,
						SignUpActivity.class);
				startActivity(myIntent);
				finish();
			}
		});

		if (!RestService.isrunning)
			startService(new Intent(this, RestService.class));
	}
	
	private void initiatePopupWindow(CharSequence login, CharSequence pw) {
		//set up dialog
        final Dialog dialog = new Dialog(LoginActivity.this);
        dialog.setContentView(R.layout.loading_dialog);
        dialog.setTitle("UsiXML Login");
        dialog.setCancelable(true);
        //now that the dialog is set up, it's time to show it    
        dialog.show();
        String result = "fail";
		try {
			result = EventTrigger.verifyUser(login, pw);
		} catch (IOException e) {
			result = "fail";
			e.printStackTrace();
		}
        if (result.equalsIgnoreCase("fail")){
			//set up button
//			final Dialog dialog2 = new Dialog(LoginActivity.this);
			dialog.setContentView(R.layout.fail_dialog);
	        Button button = (Button) dialog.findViewById(R.id.failButton);
	        button.setOnClickListener(new OnClickListener() {
	        	@Override
	            public void onClick(View v) {
	        		dialog.dismiss();
	        		LoginActivity.isloged = false;
	        		LoginActivity.this.finish();
	            }
	        });
	        return;
		} else {
			//set up button
//			final Dialog dialog = new Dialog(LoginActivity.this);
			LoginActivity.isloged = true;
    		LoginActivity.this.setRole(result);
			dialog.setContentView(R.layout.sucess_dialog);
	        Button button = (Button) dialog.findViewById(R.id.sucessButton);
	        button.setOnClickListener(new OnClickListener() {
	        	@Override
	            public void onClick(View v) {
	        		dialog.dismiss();
	        		LoginActivity.this.finish();
	            }
	        });
	        return;
		}
        //new Thread(new VerifyUser(dialog, role, pw)).start();
	}
	
	public  CharSequence getRole() {
		return role;
	}

	public void setRole(CharSequence role) {
		this.role = role;
	}

//	class VerifyUser implements Runnable{
//
//		private Dialog dialog;
//		private CharSequence login;
//		private CharSequence password;
//
//		public VerifyUser(Dialog dialog, CharSequence login, CharSequence password){
//			this.dialog = dialog;
//			this.login = login;
//			this.password = password;
//			
//		}
//		
//		@Override
//		public void run() {
//			final String result = EventTrigger.verifyUser(login, password);
//			dialog.dismiss();
//			if (result.equalsIgnoreCase("fail")){
//				//set up button
////				final Dialog dialog2 = new Dialog(LoginActivity.this);
////				dialog2.setContentView(R.layout.fail_dialog);
////		        Button button = (Button) dialog2.findViewById(R.id.failButton);
////		        button.setOnClickListener(new OnClickListener() {
////		        	@Override
////		            public void onClick(View v) {
////		        		dialog2.dismiss();
//		        		LoginActivity.isloged = false;
//		        		LoginActivity.this.finish();
////		            }
////		        });
//		        return;
//			} else {
//				//set up button
////				final Dialog dialog = new Dialog(LoginActivity.this);
////				dialog.setContentView(R.layout.sucess_dialog);
////		        Button button = (Button) dialog.findViewById(R.id.sucessButton);
////		        button.setOnClickListener(new OnClickListener() {
////		        	@Override
////		            public void onClick(View v) {
////		        		dialog.dismiss();
//		        		LoginActivity.isloged = true;
//		        		LoginActivity.this.setRole(result);
//		        		LoginActivity.this.finish();
////		            }
////		        });
//		        return;
//			}
//		}
//		
//	}
}