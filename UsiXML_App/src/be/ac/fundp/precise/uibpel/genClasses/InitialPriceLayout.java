package be.ac.fundp.precise.uibpel.genClasses;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import be.ac.fundp.precise.uibpel.R;
import be.ac.fundp.precise.uibpel.common.SubmittedContent;
import be.ac.fundp.precise.uibpel.manager.UIManager;

public class InitialPriceLayout implements UiActivity {


	protected UIManager uiManagerAndroid;

	protected TextView[] innerText;
	
	public InitialPriceLayout(UIManager uiManager) {
		uiManagerAndroid = uiManager;
	}

	/** Called when the activity is first created. */
	@Override
	public void perform (final Activity a, String cuiId){
		a.setContentView(R.layout.initial_price_layout);
		
		innerText = new TextView[1];
		innerText[0] = (TextView) a.findViewById(R.id.textView1);
		
		SubmittedContent[] inputInformation = uiManagerAndroid.getDataSentByServer(cuiId);
		
		for (int i = 0; i < innerText.length; i++) {
			TextView aTextView = innerText[i];
			String tag = aTextView.getTag().toString();
			SubmittedContent subCon = getCorrect(tag,inputInformation);
			if (subCon != null){
				aTextView.setText((String)subCon.getData());
			}
			
		}
		Button btnBack = (Button) a.findViewById(R.id.button2);

		btnBack.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//uiManagerAndroid.nextInteraction(getClass());
				System.out.println("finished");
				a.finish();
			}
		});
		System.out.println("loaded");
	}

	private SubmittedContent getCorrect(String tag,
			SubmittedContent[] inputInformation) {
		System.out.println("tag: "+tag);
		System.out.println("inputInformation: "+inputInformation);
		if (inputInformation == null)
			return null;
		for (SubmittedContent submittedContent : inputInformation) {
			if (submittedContent.getId().startsWith(tag)){
				return submittedContent;
			}
		}
		return null;
	}

}