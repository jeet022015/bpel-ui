package be.ac.precise.usixml.androidapp.activities;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import be.ac.precise.usixml.androidapp.ActivityManager;
import be.ac.precise.usixml.androidapp.R;
import be.ac.precise.usixml.androidapp.model.Process;
import be.ac.precise.usixml.androidapp.util.AndroidAppConstants;

public class AvailableProcessesActivity extends Activity {	
	
	protected ActivityManager manager = ActivityManager.getInstance();
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.processes);
    }
    
    /** Called when the activity is first created. */
    @Override
    public void onResume() {
        super.onResume();
        
        List<String> myProcess = manager.getProcessIds(manager.getRole());
        
        LinearLayout processLayout = (LinearLayout) findViewById(R.id.mainLayoutProcesses);
        
        processLayout.removeAllViews();
        
        for (String processId : myProcess) {
        	creatProcessField(processId, processLayout);
		}
    }

	private void creatProcessField(final String processId, LinearLayout processLayout) {
		LinearLayout innerLayout = new LinearLayout(this);
		LayoutParams parL = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT,
				LinearLayout.LayoutParams.WRAP_CONTENT,
				LinearLayout.HORIZONTAL);
		parL.setMargins(0, 10, 0, 10);
		innerLayout.setLayoutParams(parL);
		innerLayout.setGravity(Gravity.CENTER_VERTICAL);
		
		Process process = manager.getProcess(processId);
		ImageView i = createProcessImageView(process, parL);
		TextView textField = createProcessTextView(process, parL);
		
		innerLayout.addView(i);
		innerLayout.addView(textField);
		
		innerLayout.setOnClickListener(new View.OnClickListener() 
        {
            public void onClick(View v) {
            	Intent myIntent = new Intent(AvailableProcessesActivity.this,
            			ProcessDescriptionActivity.class);
				myIntent.putExtra(AndroidAppConstants.PARAM_PROCESS, processId);
				AvailableProcessesActivity.this.startActivity(myIntent);
				finish();
            }
        });
		
		processLayout.addView(innerLayout);
	}

	private TextView createProcessTextView(Process process, LayoutParams par) {
		TextView textField = new TextView(this);
		par.setMargins(20, 0, 0, 0); // llp.setMargins(left, top, right, bottom);
	    textField.setLayoutParams(par);
	    textField.setTextColor(Color.parseColor("#0B4C5F"));
	    textField.setText(process.getDisplayableName());
	    textField.setTextSize(20);
	    textField.setGravity(Gravity.CENTER_VERTICAL);
		return textField;
	}

	private ImageView createProcessImageView(Process process, LayoutParams par) {
		ImageView i = new ImageView(this);
		if (process.hasPendingAct()){
			i.setImageResource(R.drawable.processui);
		}else{
			if (process.isFinisehd())
				i.setImageResource(R.drawable.processfinish);
			else
				i.setImageResource(R.drawable.processwait);
		}
		i.setAdjustViewBounds(true); // set the ImageView bounds to match the
		par.setMargins(5, 0, 0, 0); // llp.setMargins(left, top, right, bottom);
		i.setLayoutParams(par);
		return i;
	}
}
