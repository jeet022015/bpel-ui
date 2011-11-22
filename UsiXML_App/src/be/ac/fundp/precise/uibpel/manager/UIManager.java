package be.ac.fundp.precise.uibpel.manager;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import be.ac.fundp.precise.uibpel.UsiXML_AppActivity;
import be.ac.fundp.precise.uibpel.common.SubmittedContent;
import be.ac.fundp.precise.uibpel.genClasses.FinalLayout;
import be.ac.fundp.precise.uibpel.genClasses.InitialDataLayout;
import be.ac.fundp.precise.uibpel.genClasses.InitialPriceLayout;
import be.ac.fundp.precise.uibpel.genClasses.SelectionPaymentMethodLayout;
import be.ac.fundp.precise.uibpel.genClasses.UiActivity;
import be.ac.fundp.precise.uibpel.representation.Process;
import be.ac.fundp.precise.uibpel.util.ThreadEvent;

public class UIManager {

	protected static UIManager self;
	protected UsiXML_AppActivity mainApp;
	protected Map<String, UiActivity> uiMapper = new HashMap<String, UiActivity>();
	protected Map<String, SubmittedContent[]> serverToUiData = new HashMap<String, SubmittedContent[]>();
	protected Map<String, SubmittedContent[]> uiToServerData = new HashMap<String, SubmittedContent[]>();
	protected Map<String, ThreadEvent> dataWaiter = new HashMap<String, ThreadEvent>();
	protected List<String> uiStack = new LinkedList<String>();
	
	protected Map<String, Process> processMap = new HashMap<String, Process>();
	
	protected String process = "Order ";
	protected int processCounter = 1;
	protected Process currentP;
	
	protected UIManager(){
		//uiMapper.put("input", InitialDataLayout.class);
		//uiMapper.put("output", InitialPriceLayout.class);
		//uiMapper.put("selection", SelectionPaymentMethodLayout.class);
		uiMapper.put("4", new InitialDataLayout(this));
		uiMapper.put("7", new InitialPriceLayout(this));
		uiMapper.put("6", new SelectionPaymentMethodLayout(this));
		uiMapper.put("8", new FinalLayout(this));
	}
	
	public static UIManager getInstance(){
		if (self == null)
			self = new UIManager();
		return self;
	}
	
	public void registerActivity(UsiXML_AppActivity usiXML_AppActivity) {
		mainApp = usiXML_AppActivity;
	}

	public void addUserInteraction(String cuiId, SubmittedContent[] content) {
		if (content != null && content.length > 0){
			System.out.println("the cui has data = "+cuiId);
			serverToUiData.put(cuiId, content);
		} else {
			System.out.println("the cui has not data = "+cuiId);
		}
		
		if (uiToServerData.containsKey(cuiId)){
			uiToServerData.remove(cuiId);
		}
		
		
		uiStack.add(cuiId);
		UiActivity uiToPresent = uiMapper.get(cuiId);
		System.out.println("the current cui = "+cuiId);
		System.out.println("uiToPresent = "+uiToPresent);
		
		Process myProcess = getProcess(cuiId);
		processMap.put(myProcess.getName(), myProcess);
		
		
		myProcess.addUserInteraction(cuiId);
		System.out.println("mainApp = "+mainApp);
		mainApp.showNotification(myProcess);
	}
	
	private Process getProcess(String cuiId) {
		if (cuiId.startsWith("4")){
			System.out.println("new process");
			currentP = new Process(process+processCounter++);
		}
		return currentP;
	}

	public void putDataProvidedByUser(String myKey , List<SubmittedContent> l) {
		//String myKey = getCuiId(c);
		System.out.println("myKey = "+myKey);
		if (myKey != null){
			uiToServerData.put(myKey, l.toArray(new SubmittedContent[0]));
			ThreadEvent threadLocker = dataWaiter.get(myKey);
			if (threadLocker != null){
				System.out.println("signed");
				threadLocker.signal();
			}
			//nextInteraction(c);
		}
	}

//	private String getCuiId(Class<?> c) {
//		String myKey = null;
//		Set<String> keys = uiMapper.keySet();
//		for (String key : keys) {
//			UiActivity uiClass =  uiMapper.get(key);
//			if (c.getName().startsWith(uiClass.getName())){
//				myKey = key;
//				break;
//			}
//		}
//		return myKey;
//	}

	public SubmittedContent[] getDataProvidedByUser(String cuiId) throws InterruptedException {
		if (cuiId == null || !uiMapper.containsKey(cuiId))
			return null;
		ThreadEvent threadLocker = new ThreadEvent();
		synchronized (this) {
			if (!uiToServerData.containsKey(cuiId)){
				ThreadEvent innerLocker = dataWaiter.get(cuiId);
				if (innerLocker == null){
					dataWaiter.put(cuiId, threadLocker);
				} else {
					threadLocker = innerLocker;
				}
				System.out.println("locked");
				threadLocker.await();
			}
		}
		SubmittedContent[] data = uiToServerData.get(cuiId);
		return data;
		
	}

	public void nextInteraction(String myKey) {
		//String myKey = getCuiId(c);
		System.out.println("finished id is = " + myKey);
		uiStack.remove(myKey);
		if (uiStack.size() > 0){
			System.out.println("new UI");
			//String currentUI = uiStack.get(0);
			//Class<?> uiToPresent = uiMapper.get(currentUI);
			mainApp.showNotification(currentP);
		} else {
			System.out.println("no more UI");
			mainApp.hideNotification();
		}
	}

	public SubmittedContent[] getDataSentByServer(String myKey) {
		//String myKey = getCuiId(c);
		System.out.println("getDataSentByServer> mykey is ="+myKey);
		return serverToUiData.get(myKey);
	}

	public Collection<Process> getProcesses() {
		return processMap.values();
	}

	public UiActivity getMyUI(String cuiId) {
		return uiMapper.get(cuiId);
	}

	public void hideNotification() {
		if (mainApp != null)
			mainApp.hideNotification();
	}

}
