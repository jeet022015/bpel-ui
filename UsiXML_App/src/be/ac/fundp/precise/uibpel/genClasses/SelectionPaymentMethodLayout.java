package be.ac.fundp.precise.uibpel.genClasses;

import java.util.LinkedList;
import java.util.List;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import be.ac.fundp.precise.uibpel.R;
import be.ac.fundp.precise.uibpel.common.SubmittedContent;
import be.ac.fundp.precise.uibpel.manager.UIManager;

public class SelectionPaymentMethodLayout implements UiActivity{

	private final class InnerRunnable implements Runnable {
		
		Activity a;
		String cuiId;
		
		public InnerRunnable(Activity a, String cuiId){
			this.a = a;
			this.cuiId = cuiId;
		}
		
		public void run() {
			List<SubmittedContent> list = new LinkedList<SubmittedContent>();
			
			RadioButton r = (RadioButton) a.findViewById(g.getCheckedRadioButtonId());
			
			SubmittedContent aData = new SubmittedContent();
			aData.setData(r.getText().toString());
			aData.setId(g.getTag().toString());
			// TODO Other types of data I can put it on the tag
			aData.setType("String");
			list.add(aData);
			uiManagerAndroid.putDataProvidedByUser(cuiId,list);
			System.out.println("selecion put");
		}
	}

	protected UIManager uiManagerAndroid ;

	protected RadioButton[] innerText;
	protected RadioGroup g;
	
	public SelectionPaymentMethodLayout(UIManager uiManager) {
		uiManagerAndroid = uiManager;
	}

	/** Called when the activity is first created. */
	@Override
	public void perform (final Activity a, final String cuiId) {
		a.setContentView(R.layout.select_payment_method_layout);
		
		innerText = new RadioButton[2];
		innerText[0] = (RadioButton) a.findViewById(R.id.radio0);
		innerText[1] = (RadioButton) a.findViewById(R.id.radio1);
		
		g = (RadioGroup) a.findViewById(R.id.radioGroup1);
		
		SubmittedContent[] inputInformation = uiManagerAndroid.getDataSentByServer(cuiId);
		
		for (int i = 0; i < innerText.length; i++) {
			TextView aTextView = innerText[i];
			String tag = aTextView.getTag().toString();
			SubmittedContent subCon = getCorrect(tag,inputInformation);
			if (subCon != null){
				aTextView.setText((String)subCon.getData());
			}
			
		}
		Button btnBack = (Button) a.findViewById(R.id.button3);

		btnBack.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				new Thread(new InnerRunnable(a, cuiId)).start();
				a.finish();
			}
		});
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
