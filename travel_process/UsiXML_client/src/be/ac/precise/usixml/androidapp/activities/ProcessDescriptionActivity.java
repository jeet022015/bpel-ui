package be.ac.precise.usixml.androidapp.activities;

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
import be.ac.precise.usixml.androidapp.model.UserInteraction;
import be.ac.precise.usixml.androidapp.util.AndroidAppConstants;

public class ProcessDescriptionActivity  extends Activity {
	
	protected String processId;
	
	protected ActivityManager manager = ActivityManager.getInstance();
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.process_description);
        
        processId = getIntent().getStringExtra(AndroidAppConstants.PARAM_PROCESS);
    }
	
	/** Called when the activity is first created. */
    @Override
    public void onResume() {
        super.onResume();
        
        TextView processText = (TextView) findViewById(R.id.textViewActivities1);
        processText.setText(processId);
        
       
        Process myProcess = manager.getProcess(processId);
        LinearLayout processLayout = (LinearLayout) findViewById(R.id.mainLayoutProcess);
        processLayout.removeAllViews();
        
        for (UserInteraction aUserInteraction : myProcess.getUserInteractions()) {
        	createInteractionField(aUserInteraction, processLayout);
		}
    }

	private void createInteractionField(final UserInteraction aUserInteraction,
			LinearLayout processLayout) {
		LinearLayout innerLayout = new LinearLayout(this);
		LayoutParams parL = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT,
				LinearLayout.LayoutParams.WRAP_CONTENT,
				LinearLayout.HORIZONTAL);
		parL.setMargins(0, 10, 0, 10);
		innerLayout.setLayoutParams(parL);
		innerLayout.setGravity(Gravity.CENTER_VERTICAL);
		
		ImageView i = createInteractionImageView(aUserInteraction, parL);
		TextView textField = createProcessTextView(aUserInteraction, parL);
		
		innerLayout.addView(i);
		innerLayout.addView(textField);
		
		if (!aUserInteraction.isDone())
			innerLayout.setOnClickListener(new View.OnClickListener() 
	        {
	            public void onClick(View v) {
	            	Intent myIntent = new Intent(ProcessDescriptionActivity.this,
	            			UserInteractionActivity.class);
					myIntent.putExtra(AndroidAppConstants.PARAM_INTERACTION, aUserInteraction.getId());
					myIntent.putExtra(AndroidAppConstants.PARAM_PROCESS, processId);
					ProcessDescriptionActivity.this.startActivity(myIntent);
	            }
	        });
		
		processLayout.addView(innerLayout);
	}

	private TextView createProcessTextView(UserInteraction aUserInteraction,
			LayoutParams par) {
		TextView textField = new TextView(this);
		par.setMargins(20, 5, 0, 0); // llp.setMargins(left, top, right, bottom);
	    textField.setLayoutParams(par);
	    textField.setTextColor(Color.parseColor("#0B4C5F"));
	    textField.setText(aUserInteraction.getDisplayableName());
	    textField.setTextSize(20);
		return textField;
	}

	private ImageView createInteractionImageView(
			UserInteraction aUserInteraction, LayoutParams par) {
		ImageView i = new ImageView(this);
		if (aUserInteraction.isDone()){
			i.setImageResource(R.drawable.okicon);
		} else {
			i.setImageResource(R.drawable.touchicon);
		}
		i.setAdjustViewBounds(true); // set the ImageView bounds to match the
		par.setMargins(10, 0, 0, 0); // llp.setMargins(left, top, right, bottom);
		i.setLayoutParams(par);
		return i;
	}

}