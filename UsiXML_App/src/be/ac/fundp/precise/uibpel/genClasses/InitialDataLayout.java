package be.ac.fundp.precise.uibpel.genClasses;

import java.util.LinkedList;
import java.util.List;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import be.ac.fundp.precise.uibpel.R;
import be.ac.fundp.precise.uibpel.common.SubmittedContent;
import be.ac.fundp.precise.uibpel.manager.UIManager;

public class InitialDataLayout implements UiActivity {

	UIManager uiManagerAndroid;
	
	public InitialDataLayout (UIManager uiManagerAndroid){
		this.uiManagerAndroid = uiManagerAndroid;
	}
	
	private final class InnerRunnable implements Runnable {
		
		String cuiId;
		
		public InnerRunnable (String cuiId){
			this.cuiId = cuiId;
		}
		public void run() {
			List<SubmittedContent> list = new LinkedList<SubmittedContent>();
			
			for (int i = 0; i < innerText.length; i++) {
				EditText innerEditView = innerText[i];
				SubmittedContent aData = new SubmittedContent();
				aData.setData(innerEditView.getText().toString());
				aData.setId(innerEditView.getTag().toString());
				// TODO Other types of data I can put it on the tag
				aData.setType("String");
				list.add(aData);
			}
			uiManagerAndroid.putDataProvidedByUser(cuiId,list);
		}
	}
	
	protected EditText[] innerText;

	/** Called when the activity is first created. */
	@Override
	public void perform (final Activity a, final String cuiId) {
		System.out.println("Initial interection Started");
		a.setContentView(R.layout.initial_data_layout);
		
		innerText = new EditText[4];
		innerText[0] = (EditText) a.findViewById(R.id.editText1);
		innerText[1] = (EditText) a.findViewById(R.id.editText2);
		innerText[2] = (EditText) a.findViewById(R.id.editText3);
		innerText[3] = (EditText) a.findViewById(R.id.editText4);

		Button btnBack = (Button) a.findViewById(R.id.button1);

		btnBack.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				new Thread(new InnerRunnable(cuiId)).start();
				a.finish();
			}
		});
	}

}
