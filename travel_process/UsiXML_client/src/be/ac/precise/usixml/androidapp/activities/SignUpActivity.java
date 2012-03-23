package be.ac.precise.usixml.androidapp.activities;

import android.app.Activity;
import android.app.Dialog;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import be.ac.precise.usixml.androidapp.ActivityManager;
import be.ac.precise.usixml.androidapp.R;
import be.ac.precise.usixml.androidapp.util.EventTrigger;

public class SignUpActivity extends Activity {

	protected ActivityManager actManager = ActivityManager.getInstance();
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		actManager.setNotificationAct(SignUpActivity.this);
        
		WifiManager wifiManager = (WifiManager) getSystemService(WIFI_SERVICE);
		WifiInfo wifiInfo = wifiManager.getConnectionInfo();
		int ipAddress = wifiInfo.getIpAddress();

		final String ip = String.format("%d.%d.%d.%d", (ipAddress & 0xff),
				(ipAddress >> 8 & 0xff),
				(ipAddress >> 16 & 0xff),
				(ipAddress >> 24 & 0xff));
		System.out.println("ipAddress="+ip);
		
		setContentView(R.layout.sing_up_page);
		Button btnBack = (Button) findViewById(R.id.singup);
		btnBack.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				TextView elementView = (TextView) findViewById(R.id.signUpLogin);
				CharSequence login = elementView.getText();
				elementView = (TextView) findViewById(R.id.signUpPw);
				CharSequence password = elementView.getText();
				elementView = (TextView) findViewById(R.id.signUpLogin);
				RadioGroup g = (RadioGroup) findViewById(R.id.radioRoles);
				RadioButton r = (RadioButton) findViewById(g
						.getCheckedRadioButtonId());
				CharSequence role = r.getText();
				new Thread(new SubstribeUsixml(login, password, role, ip)).start();
	        	initiatePopupWindow();
	        	LoginActivity.isloged = true;
			}
		});
	}
	
	private void initiatePopupWindow() {
		//set up dialog
        final Dialog dialog = new Dialog(SignUpActivity.this);
        dialog.setContentView(R.layout.sucess_signup_dialog);
        dialog.setTitle("UsiXML Login");
        dialog.setCancelable(true);

        //set up button
        Button button = (Button) dialog.findViewById(R.id.sucessSignupButton);
        button.setOnClickListener(new OnClickListener() {
        	@Override
            public void onClick(View v) {
        		dialog.dismiss();
        		SignUpActivity.this.finish();
            }
        });
        
        //now that the dialog is set up, it's time to show it    
        dialog.show();
	}
	
	class SubstribeUsixml implements Runnable{

		private CharSequence login;
		private CharSequence password;
		private CharSequence role;
		private String ipAddress;

		public SubstribeUsixml(CharSequence login, CharSequence password, CharSequence role, String ipAddress){
			this.login = login;
			this.password = password;
			this.role = role;
			this.ipAddress = ipAddress;
		}
		
		@Override
		public void run() {
			EventTrigger.subscribe(login, password, role, ipAddress);
		}
	}
}