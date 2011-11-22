package be.ac.fundp.precise.uibpel.activities;

import java.util.List;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import be.ac.fundp.precise.uibpel.R;
import be.ac.fundp.precise.uibpel.genClasses.UiActivity;
import be.ac.fundp.precise.uibpel.manager.UIManager;
import be.ac.fundp.precise.uibpel.representation.Process;
import be.ac.fundp.precise.uibpel.representation.UserInteraction;

public class ProcessInteractionActivity extends Activity {

	public static Process p;
	
	private UIManager uiManagerAndroid = UIManager.getInstance();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.process_activities);
		LinearLayout l = (LinearLayout) findViewById(R.id.linearLayoutActivities2);
		l.setOrientation(LinearLayout.VERTICAL);

		TextView tv = (TextView) findViewById(R.id.textViewActivities1);
		//GET The current process, wit un resolved Interaction
		tv.setText(p.getName());
		tv.setTextSize(30);

		List<UserInteraction> aui= p.getUserInteractions();
	    //forgot_pswrd.setC
		
		for (final UserInteraction userInteraction : aui) {
			LinearLayout innerLayout = new LinearLayout(this);
			LayoutParams parL = new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.WRAP_CONTENT,
					LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.HORIZONTAL);
			parL.setMargins(0, 10, 0, 10);
			innerLayout.setLayoutParams(parL);
			//innerLayout.setOrientation(LinearLayout.HORIZONTAL);
			
			ImageView i = new ImageView(this);
			if (userInteraction.isDone()){
				//i.setImageResource(R.drawable.logoui);
				i.setImageResource(R.drawable.okicon);
			} else {
				//i.setImageResource(R.drawable.logook);
				i.setImageResource(R.drawable.touchicon);
			}
			i.setAdjustViewBounds(true); // set the ImageView bounds to match the
			LayoutParams par = new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.WRAP_CONTENT,
					LinearLayout.LayoutParams.WRAP_CONTENT, 1);
			par.setMargins(10, 0, 0, 0);
			i.setLayoutParams(par);
			
			TextView forgot_pswrd = new TextView(this);
		    //forgot_pswrd.setOnTouchListener(this);     
		    LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		    llp.setMargins(20, 5, 0, 0); // llp.setMargins(left, top, right, bottom);
		    forgot_pswrd.setLayoutParams(llp);
		    forgot_pswrd.setTextColor(Color.parseColor("#0B4C5F"));
		    forgot_pswrd.setText(userInteraction.getDisplayName());
		    forgot_pswrd.setTextSize(20);
			
			innerLayout.addView(i);
			innerLayout.addView(forgot_pswrd);
			
			final UiActivity actv = uiManagerAndroid.getMyUI(userInteraction.getId());
			final String cuiId = userInteraction.getId();
			final Activity self = this;
			
			if (!userInteraction.isDone()){
				innerLayout.setOnClickListener(new View.OnClickListener() 
		        {
		            public void onClick(View v) {
		            	actv.perform(self, cuiId);
		            	userInteraction.setDone();
		            	uiManagerAndroid.hideNotification();
		            }
		        });
			}
			
			l.addView(innerLayout);
		}

		// a.setContentView(R.layout.processes_page);
	}

}
