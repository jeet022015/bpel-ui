package be.ac.fundp.precise.uibpel.ui;

import java.util.List;

import android.app.Activity;
import android.graphics.Color;
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

public class ActivitiesUI {

	protected Activity a;
	protected Process myProcess;

	public ActivitiesUI(Activity a, Process aProcess) {
		this.a = a;
		this.myProcess = aProcess;
	}

	private UIManager uiManagerAndroid = UIManager.getInstance();

	public void createActivityList() {
		a.setContentView(R.layout.process_activities);
		LinearLayout l = (LinearLayout) a
				.findViewById(R.id.linearLayoutActivities2);
		l.setOrientation(LinearLayout.VERTICAL);
		
		TextView tv = (TextView) a
				.findViewById(R.id.textViewActivities1);
		tv.setText(myProcess.getName());
		tv.setTextSize(30);

		
		List<UserInteraction> aui= myProcess.getUserInteractions();
	    //forgot_pswrd.setC
		
		for (final UserInteraction userInteraction : aui) {
			LinearLayout innerLayout = new LinearLayout(a);
			LayoutParams parL = new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.WRAP_CONTENT,
					LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.HORIZONTAL);
			parL.setMargins(0, 10, 0, 10);
			innerLayout.setLayoutParams(parL);
			//innerLayout.setOrientation(LinearLayout.HORIZONTAL);
			
			ImageView i = new ImageView(a);
			//i.setImageResource(R.drawable.intentlogo);
			if (userInteraction.isDone()){
				//i.setImageResource(R.drawable.logoui);
				i.setImageResource(R.drawable.okicon);
			} else{
				i.setImageResource(R.drawable.touchicon);
				//i.setImageResource(R.drawable.logoui);
			}
			i.setAdjustViewBounds(true); // set the ImageView bounds to match the
			LayoutParams par = new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.WRAP_CONTENT,
					LinearLayout.LayoutParams.WRAP_CONTENT, 1);
			par.setMargins(10, 0, 0, 0);
			i.setLayoutParams(par);
			
			TextView forgot_pswrd = new TextView(a);
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
			final String cuiId =userInteraction.getId();
			
			if (!userInteraction.isDone()){
				innerLayout.setOnClickListener(new View.OnClickListener() 
		        {
		            public void onClick(View v) {
		            	actv.perform(a, cuiId);
		            	userInteraction.setDone();
		            	uiManagerAndroid.hideNotification();
		            }
		        });
			}
			
			l.addView(innerLayout);
		}

//		for (int j = 0; j < 10; j++) {
//			LinearLayout innerLayout = new LinearLayout(a);
//			LayoutParams parL = new LinearLayout.LayoutParams(
//					LinearLayout.LayoutParams.WRAP_CONTENT,
//					LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.HORIZONTAL);
//			parL.setMargins(0, 10, 0, 10);
//			innerLayout.setLayoutParams(parL);
//			//innerLayout.setOrientation(LinearLayout.HORIZONTAL);
//			
//			ImageView i = new ImageView(a);
//			i.setImageResource(R.drawable.intentlogo);
//			i.setAdjustViewBounds(true); // set the ImageView bounds to match the
//			LayoutParams par = new LinearLayout.LayoutParams(
//					LinearLayout.LayoutParams.WRAP_CONTENT,
//					LinearLayout.LayoutParams.WRAP_CONTENT, 1);
//			par.setMargins(10, 0, 0, 0);
//			i.setLayoutParams(par);
//			
//			TextView forgot_pswrd = new TextView(a);
//		    //forgot_pswrd.setOnTouchListener(this);     
//		    LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
//		    llp.setMargins(20, 5, 0, 0); // llp.setMargins(left, top, right, bottom);
//		    forgot_pswrd.setLayoutParams(llp);
//		    forgot_pswrd.setTextColor(Color.parseColor("#0B4C5F"));
//		    forgot_pswrd.setText("Activity "+j);
//		    forgot_pswrd.setTextSize(30);
//			
//			innerLayout.addView(i);
//			innerLayout.addView(forgot_pswrd);
//			
//			innerLayout.setOnClickListener(new View.OnClickListener() 
//	        {
//	            public void onClick(View v) {
//	            	a.setContentView(R.layout.initial_data_layout);
//	            }
//	        });
//			
//			l.addView(innerLayout);
//			
//			System.out.println("cont:"+j);
//		}
		
		//a.setContentView(R.layout.processes_page);
	}

}