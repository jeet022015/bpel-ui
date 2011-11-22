package be.ac.fundp.precise.uibpel.ui;

import java.util.Collection;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import be.ac.fundp.precise.uibpel.R;
import be.ac.fundp.precise.uibpel.manager.UIManager;
import be.ac.fundp.precise.uibpel.representation.Process;

public class ProcessesUI {

	Activity a;

	public ProcessesUI(Activity a) {
		this.a = a;
	}

	private UIManager uiManagerAndroid = UIManager.getInstance();

	public void createProcessList() {
		a.setContentView(R.layout.processes_page);
		LinearLayout l = (LinearLayout) a
				.findViewById(R.id.linearLayoutProcesses2);
		l.setOrientation(LinearLayout.VERTICAL);

	    Collection<Process> listProcesses = uiManagerAndroid.getProcesses();
	    
	    for (Process process : listProcesses) {
	    	LinearLayout innerLayout = new LinearLayout(a);
			LayoutParams parL = new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.WRAP_CONTENT,
					LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.HORIZONTAL);
			parL.setMargins(0, 10, 0, 10);
			innerLayout.setLayoutParams(parL);
			//innerLayout.setOrientation(LinearLayout.HORIZONTAL);
			
			ImageView i = new ImageView(a);
			if (process.hasUndoneAct()){
				i.setImageResource(R.drawable.processui);
			}else{
				if (process.isFinisehd())
					i.setImageResource(R.drawable.processfinish);
				else
					i.setImageResource(R.drawable.processwait);
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
		    final Process aProcess = process;
		    forgot_pswrd.setText(aProcess.getName());
		    forgot_pswrd.setTextSize(20);
			
			innerLayout.addView(i);
			innerLayout.addView(forgot_pswrd);
			
			innerLayout.setOnClickListener(new View.OnClickListener() 
	        {
	            public void onClick(View v) {
	            	ActivitiesUI activityUI = new ActivitiesUI (a, aProcess);
	            	activityUI.createActivityList();
	            }
	        });
			
			l.addView(innerLayout);;
		}
//
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
//			i.setImageResource(R.drawable.processlogo);
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
//		    final int j2 = j;
//		    forgot_pswrd.setText("Process "+j);
//		    forgot_pswrd.setTextSize(30);
//			
//			innerLayout.addView(i);
//			innerLayout.addView(forgot_pswrd);
//			
//			innerLayout.setOnClickListener(new View.OnClickListener() 
//	        {
//	            public void onClick(View v) {
//	            	ActivitiesUI activityUI = new ActivitiesUI (a, "Process "+j2);
//	            	activityUI.createActivityList();
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