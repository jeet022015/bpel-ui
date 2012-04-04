package be.ac.precise.usixml.androidapp.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import be.ac.precise.usixml.androidapp.ActivityManager;
import be.ac.precise.usixml.androidapp.R;
import be.ac.precise.usixml.androidapp.model.UserInteraction;
import be.ac.precise.usixml.androidapp.util.AndroidAppConstants;
import be.ac.precise.usixml.androidapp.util.EventTrigger;
import be.ac.precise.usixml.androidapp.util.R_Util;

public class UserInteractionActivity extends Activity {
	final protected ActivityManager manager = ActivityManager.getInstance();

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final String uiId = getIntent().getStringExtra(
				AndroidAppConstants.PARAM_INTERACTION);
		final String processId = getIntent().getStringExtra(
				AndroidAppConstants.PARAM_PROCESS);

		final UserInteraction myUserInteraction = manager.getProcess(processId)
				.getUserInteraction(uiId);
		int layoutId = R_Util.getStaticValue(R.layout.class,
				AndroidAppConstants.FILE_INTERACTION + uiId);
		setContentView(layoutId);

		for (String itemId : myUserInteraction.getAvailableItemIds()) {
			int id = R_Util.getStaticValue(R.id.class, itemId);
			if (id != R_Util.VALUE_UNDEFINED) {
				View v = findViewById(id);
				// see setContentView
				setContent(v, myUserInteraction.getAvailableItemContent(itemId));
			}
		}

		int arrayInput = R_Util.getStaticValue(R.array.class,
				AndroidAppConstants.FILE_INTERACTION + uiId);
		final String[] inputIds = getInputFields(arrayInput);

		Button btnBack = (Button) findViewById(R.id.submit);
		btnBack.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				new Thread(new InnerRunnable(UserInteractionActivity.this,
						myUserInteraction, inputIds)).start();
				
				finish();
			}
		});

		int arrayEvent = R_Util.getStaticValue(R.array.class,
				AndroidAppConstants.FILE_EVENT + uiId);
		final String[] eventIds = getInputFields(arrayEvent);
		for (String aEventId : eventIds) {
			int id = R_Util.getStaticValue(R.id.class, aEventId);
			if (id != R_Util.VALUE_UNDEFINED) {
				final Button v1 = (Button) findViewById(id);
				// see setContentView
				v1.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
			        	 new Thread(new CancelRunnable(UserInteractionActivity.this,
									myUserInteraction, processId)).start();
			        	 myUserInteraction.wasDone();
			 			 manager.getProcess(processId).deletePendingInt();
			        	 finish();
					}
				});
			}
		}
	}

	private void setContent(View v, Object availableItemContent) {
		if (v instanceof RadioButton) {
			RadioButton g = (RadioButton) v;
			g.setText(availableItemContent.toString());
		} else if (v instanceof TextView) {
			TextView g = (TextView) v;
			g.setText(availableItemContent.toString());
		}
		return;
	}

	protected String[] getInputFields(int valueId) {
		if (valueId == R_Util.VALUE_UNDEFINED)
			return new String[0];
		return getResources().getStringArray(valueId);
	}

	protected final class InnerRunnable implements Runnable {

		Activity a;
		String[] inputIds;
		UserInteraction innerInteraction;

		public InnerRunnable(Activity a, UserInteraction innerInteraction,
				String[] inputIds) {
			this.a = a;
			this.inputIds = inputIds;
			this.innerInteraction = innerInteraction;
		}

		public void run() {
			for (String inputId : inputIds) {
				int inputViewId = R_Util.getStaticValue(R.id.class, inputId);
				Object content = getContent(inputViewId);
				innerInteraction.addProvidedData(inputId, "string", content);
			}
			innerInteraction.wasDone();
			manager.disableNotification();
		}

		protected Object getContent(int inputViewId) {
			View v = a.findViewById(inputViewId);
			if (v instanceof RadioGroup) {
				RadioGroup g = (RadioGroup) v;
				RadioButton r = (RadioButton) a.findViewById(g
						.getCheckedRadioButtonId());
				return r.getText();
			} else if (v instanceof TextView) {
				return ((TextView) v).getText();
			}
			return null;
		}
	}
	
	protected final class CancelRunnable implements Runnable {

		Activity a;
		String processId;
		UserInteraction innerInteraction;

		public CancelRunnable(Activity a, UserInteraction innerInteraction,
				String processId) {
			this.a = a;
			this.processId = processId;
			this.innerInteraction = innerInteraction;
		}

		public void run() {
			EventTrigger.fireEvent(manager.getRole(), processId,
					innerInteraction.getId());
			manager.disableNotification();
		}
	}
}