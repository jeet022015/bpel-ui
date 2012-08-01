/**
 * ProcessDeployerServiceStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1  Built on : Aug 31, 2011 (12:22:40 CEST)
 */
package be.ac.fundp.precise.ui_bpel.webclient.deployment.axisClient;

/*
 *  ProcessDeployerServiceStub java implementation
 */

public class ProcessDeployerServiceStub extends org.apache.axis2.client.Stub {
	protected org.apache.axis2.description.AxisOperation[] _operations;

	// hashmaps to keep the fault mapping
	private java.util.HashMap faultExceptionNameMap = new java.util.HashMap();
	private java.util.HashMap faultExceptionClassNameMap = new java.util.HashMap();
	private java.util.HashMap faultMessageMap = new java.util.HashMap();

	private static int counter = 0;

	private static synchronized java.lang.String getUniqueSuffix() {
		// reset the counter if it is greater than 99999
		if (counter > 99999) {
			counter = 0;
		}
		counter = counter + 1;
		return java.lang.Long.toString(java.lang.System.currentTimeMillis())
				+ "_" + counter;
	}

	private void populateAxisService() throws org.apache.axis2.AxisFault {

		// creating the Service with a unique name
		_service = new org.apache.axis2.description.AxisService(
				"ProcessDeployerService" + getUniqueSuffix());
		addAnonymousOperations();

		// creating the operations
		org.apache.axis2.description.AxisOperation __operation;

		_operations = new org.apache.axis2.description.AxisOperation[2];

		__operation = new org.apache.axis2.description.OutInAxisOperation();

		__operation.setName(new javax.xml.namespace.QName(
				"http://precise.funpd.ac.be/AuiDeployer", "deployAui"));
		_service.addOperation(__operation);

		_operations[0] = __operation;

		__operation = new org.apache.axis2.description.OutInAxisOperation();

		__operation.setName(new javax.xml.namespace.QName(
				"http://precise.funpd.ac.be/AuiDeployer", "deployProcess"));
		_service.addOperation(__operation);

		_operations[1] = __operation;

	}

	// populates the faults
	private void populateFaults() {

	}

	/**
	 * Constructor that takes in a configContext
	 */

	public ProcessDeployerServiceStub(
			org.apache.axis2.context.ConfigurationContext configurationContext,
			java.lang.String targetEndpoint) throws org.apache.axis2.AxisFault {
		this(configurationContext, targetEndpoint, false);
	}

	/**
	 * Constructor that takes in a configContext and useseperate listner
	 */
	public ProcessDeployerServiceStub(
			org.apache.axis2.context.ConfigurationContext configurationContext,
			java.lang.String targetEndpoint, boolean useSeparateListener)
			throws org.apache.axis2.AxisFault {
		// To populate AxisService
		populateAxisService();
		populateFaults();

		_serviceClient = new org.apache.axis2.client.ServiceClient(
				configurationContext, _service);

		_serviceClient.getOptions().setTo(
				new org.apache.axis2.addressing.EndpointReference(
						targetEndpoint));
		_serviceClient.getOptions().setUseSeparateListener(useSeparateListener);

	}

	/**
	 * Default Constructor
	 */
	public ProcessDeployerServiceStub(
			org.apache.axis2.context.ConfigurationContext configurationContext)
			throws org.apache.axis2.AxisFault {

//		this(configurationContext,
//				"http://138.48.32.93:8050/UsiWSC_Manager/services/ProcessDeployer");
		
		this(configurationContext,
				"http://localhost:8050/UsiWSC_Manager/services/ProcessDeployer");

	}

	/**
	 * Default Constructor
	 */
	public ProcessDeployerServiceStub() throws org.apache.axis2.AxisFault {

		//this("http://138.48.32.93:8050/UsiWSC_Manager/services/ProcessDeployer");
		this("http://localhost:8050/UsiWSC_Manager/services/ProcessDeployer");

	}

	/**
	 * Constructor taking the target endpoint
	 */
	public ProcessDeployerServiceStub(java.lang.String targetEndpoint)
			throws org.apache.axis2.AxisFault {
		this(null, targetEndpoint);
	}

	/**
	 * Auto generated method signature
	 * 
	 * @see test2.axis.ProcessDeployerService#deployAui
	 * @param deployAui0
	 */

	public ProcessDeployerServiceStub.DeployAuiResponse deployAui(

	ProcessDeployerServiceStub.DeployAui deployAui0)

	throws java.rmi.RemoteException

	{
		org.apache.axis2.context.MessageContext _messageContext = null;
		try {
			org.apache.axis2.client.OperationClient _operationClient = _serviceClient
					.createClient(_operations[0].getName());
			_operationClient.getOptions().setAction(
					"http://precise.funpd.ac.be/AuiDeployer/deployAui");
			_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(
					true);

			addPropertyToOperationClient(
					_operationClient,
					org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
					"&");

			// create a message context
			_messageContext = new org.apache.axis2.context.MessageContext();

			// create SOAP envelope with that payload
			org.apache.axiom.soap.SOAPEnvelope env = null;

			env = toEnvelope(getFactory(_operationClient.getOptions()
					.getSoapVersionURI()), deployAui0,
					optimizeContent(new javax.xml.namespace.QName(
							"http://precise.funpd.ac.be/AuiDeployer",
							"deployAui")), new javax.xml.namespace.QName(
							"http://precise.funpd.ac.be/AuiDeployer",
							"deployAui"));

			// adding SOAP soap_headers
			_serviceClient.addHeadersToEnvelope(env);
			// set the message context with that soap envelope
			_messageContext.setEnvelope(env);

			// add the message contxt to the operation client
			_operationClient.addMessageContext(_messageContext);

			// execute the operation client
			_operationClient.execute(true);

			org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient
					.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
			org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext
					.getEnvelope();

			java.lang.Object object = fromOM(_returnEnv.getBody()
					.getFirstElement(),
					ProcessDeployerServiceStub.DeployAuiResponse.class,
					getEnvelopeNamespaces(_returnEnv));

			return (ProcessDeployerServiceStub.DeployAuiResponse) object;

		} catch (org.apache.axis2.AxisFault f) {

			org.apache.axiom.om.OMElement faultElt = f.getDetail();
			if (faultElt != null) {
				if (faultExceptionNameMap
						.containsKey(new org.apache.axis2.client.FaultMapKey(
								faultElt.getQName(), "deployAui"))) {
					// make the fault by reflection
					try {
						java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap
								.get(new org.apache.axis2.client.FaultMapKey(
										faultElt.getQName(), "deployAui"));
						java.lang.Class exceptionClass = java.lang.Class
								.forName(exceptionClassName);
						java.lang.Exception ex = (java.lang.Exception) exceptionClass
								.newInstance();
						// message class
						java.lang.String messageClassName = (java.lang.String) faultMessageMap
								.get(new org.apache.axis2.client.FaultMapKey(
										faultElt.getQName(), "deployAui"));
						java.lang.Class messageClass = java.lang.Class
								.forName(messageClassName);
						java.lang.Object messageObject = fromOM(faultElt,
								messageClass, null);
						java.lang.reflect.Method m = exceptionClass.getMethod(
								"setFaultMessage",
								new java.lang.Class[] { messageClass });
						m.invoke(ex, new java.lang.Object[] { messageObject });

						throw new java.rmi.RemoteException(ex.getMessage(), ex);
					} catch (java.lang.ClassCastException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.ClassNotFoundException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.NoSuchMethodException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.reflect.InvocationTargetException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.IllegalAccessException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.InstantiationException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					}
				} else {
					throw f;
				}
			} else {
				throw f;
			}
		} finally {
			if (_messageContext.getTransportOut() != null) {
				_messageContext.getTransportOut().getSender()
						.cleanup(_messageContext);
			}
		}
	}

	/**
	 * Auto generated method signature for Asynchronous Invocations
	 * 
	 * @see test2.axis.ProcessDeployerService#startdeployAui
	 * @param deployAui0
	 */
	public void startdeployAui(

	ProcessDeployerServiceStub.DeployAui deployAui0,

	final ProcessDeployerServiceCallbackHandler callback)

	throws java.rmi.RemoteException {

		org.apache.axis2.client.OperationClient _operationClient = _serviceClient
				.createClient(_operations[0].getName());
		_operationClient.getOptions().setAction(
				"http://precise.funpd.ac.be/AuiDeployer/deployAui");
		_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

		addPropertyToOperationClient(
				_operationClient,
				org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
				"&");

		// create SOAP envelope with that payload
		org.apache.axiom.soap.SOAPEnvelope env = null;
		final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

		// Style is Doc.

		env = toEnvelope(
				getFactory(_operationClient.getOptions().getSoapVersionURI()),
				deployAui0,
				optimizeContent(new javax.xml.namespace.QName(
						"http://precise.funpd.ac.be/AuiDeployer", "deployAui")),
				new javax.xml.namespace.QName(
						"http://precise.funpd.ac.be/AuiDeployer", "deployAui"));

		// adding SOAP soap_headers
		_serviceClient.addHeadersToEnvelope(env);
		// create message context with that soap envelope
		_messageContext.setEnvelope(env);

		// add the message context to the operation client
		_operationClient.addMessageContext(_messageContext);

		_operationClient
				.setCallback(new org.apache.axis2.client.async.AxisCallback() {
					public void onMessage(
							org.apache.axis2.context.MessageContext resultContext) {
						try {
							org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext
									.getEnvelope();

							java.lang.Object object = fromOM(
									resultEnv.getBody().getFirstElement(),
									ProcessDeployerServiceStub.DeployAuiResponse.class,
									getEnvelopeNamespaces(resultEnv));
							callback.receiveResultdeployAui((ProcessDeployerServiceStub.DeployAuiResponse) object);

						} catch (org.apache.axis2.AxisFault e) {
							callback.receiveErrordeployAui(e);
						}
					}

					public void onError(java.lang.Exception error) {
						if (error instanceof org.apache.axis2.AxisFault) {
							org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
							org.apache.axiom.om.OMElement faultElt = f
									.getDetail();
							if (faultElt != null) {
								if (faultExceptionNameMap
										.containsKey(new org.apache.axis2.client.FaultMapKey(
												faultElt.getQName(),
												"deployAui"))) {
									// make the fault by reflection
									try {
										java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap
												.get(new org.apache.axis2.client.FaultMapKey(
														faultElt.getQName(),
														"deployAui"));
										java.lang.Class exceptionClass = java.lang.Class
												.forName(exceptionClassName);
										java.lang.Exception ex = (java.lang.Exception) exceptionClass
												.newInstance();
										// message class
										java.lang.String messageClassName = (java.lang.String) faultMessageMap
												.get(new org.apache.axis2.client.FaultMapKey(
														faultElt.getQName(),
														"deployAui"));
										java.lang.Class messageClass = java.lang.Class
												.forName(messageClassName);
										java.lang.Object messageObject = fromOM(
												faultElt, messageClass, null);
										java.lang.reflect.Method m = exceptionClass
												.getMethod(
														"setFaultMessage",
														new java.lang.Class[] { messageClass });
										m.invoke(
												ex,
												new java.lang.Object[] { messageObject });

										callback.receiveErrordeployAui(new java.rmi.RemoteException(
												ex.getMessage(), ex));
									} catch (java.lang.ClassCastException e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrordeployAui(f);
									} catch (java.lang.ClassNotFoundException e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrordeployAui(f);
									} catch (java.lang.NoSuchMethodException e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrordeployAui(f);
									} catch (java.lang.reflect.InvocationTargetException e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrordeployAui(f);
									} catch (java.lang.IllegalAccessException e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrordeployAui(f);
									} catch (java.lang.InstantiationException e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrordeployAui(f);
									} catch (org.apache.axis2.AxisFault e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrordeployAui(f);
									}
								} else {
									callback.receiveErrordeployAui(f);
								}
							} else {
								callback.receiveErrordeployAui(f);
							}
						} else {
							callback.receiveErrordeployAui(error);
						}
					}

					public void onFault(
							org.apache.axis2.context.MessageContext faultContext) {
						org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils
								.getInboundFaultFromMessageContext(faultContext);
						onError(fault);
					}

					public void onComplete() {
						try {
							_messageContext.getTransportOut().getSender()
									.cleanup(_messageContext);
						} catch (org.apache.axis2.AxisFault axisFault) {
							callback.receiveErrordeployAui(axisFault);
						}
					}
				});

		org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
		if (_operations[0].getMessageReceiver() == null
				&& _operationClient.getOptions().isUseSeparateListener()) {
			_callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
			_operations[0].setMessageReceiver(_callbackReceiver);
		}

		// execute the operation client
		_operationClient.execute(false);

	}

	/**
	 * Auto generated method signature
	 * 
	 * @see test2.axis.ProcessDeployerService#deployProcess
	 * @param deployProcess2
	 */

	public ProcessDeployerServiceStub.DeployProcessResponse deployProcess(

	ProcessDeployerServiceStub.DeployProcess deployProcess2)

	throws java.rmi.RemoteException

	{
		org.apache.axis2.context.MessageContext _messageContext = null;
		try {
			org.apache.axis2.client.OperationClient _operationClient = _serviceClient
					.createClient(_operations[1].getName());
			_operationClient.getOptions().setAction(
					"http://precise.funpd.ac.be/AuiDeployer/deployProcess");
			_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(
					true);

			addPropertyToOperationClient(
					_operationClient,
					org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
					"&");

			// create a message context
			_messageContext = new org.apache.axis2.context.MessageContext();

			// create SOAP envelope with that payload
			org.apache.axiom.soap.SOAPEnvelope env = null;

			env = toEnvelope(getFactory(_operationClient.getOptions()
					.getSoapVersionURI()), deployProcess2,
					optimizeContent(new javax.xml.namespace.QName(
							"http://precise.funpd.ac.be/AuiDeployer",
							"deployProcess")), new javax.xml.namespace.QName(
							"http://precise.funpd.ac.be/AuiDeployer",
							"deployProcess"));

			// adding SOAP soap_headers
			_serviceClient.addHeadersToEnvelope(env);
			// set the message context with that soap envelope
			_messageContext.setEnvelope(env);

			// add the message contxt to the operation client
			_operationClient.addMessageContext(_messageContext);

			// execute the operation client
			_operationClient.execute(true);

			org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient
					.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
			org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext
					.getEnvelope();

			java.lang.Object object = fromOM(_returnEnv.getBody()
					.getFirstElement(),
					ProcessDeployerServiceStub.DeployProcessResponse.class,
					getEnvelopeNamespaces(_returnEnv));

			return (ProcessDeployerServiceStub.DeployProcessResponse) object;

		} catch (org.apache.axis2.AxisFault f) {

			org.apache.axiom.om.OMElement faultElt = f.getDetail();
			if (faultElt != null) {
				if (faultExceptionNameMap
						.containsKey(new org.apache.axis2.client.FaultMapKey(
								faultElt.getQName(), "deployProcess"))) {
					// make the fault by reflection
					try {
						java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap
								.get(new org.apache.axis2.client.FaultMapKey(
										faultElt.getQName(), "deployProcess"));
						java.lang.Class exceptionClass = java.lang.Class
								.forName(exceptionClassName);
						java.lang.Exception ex = (java.lang.Exception) exceptionClass
								.newInstance();
						// message class
						java.lang.String messageClassName = (java.lang.String) faultMessageMap
								.get(new org.apache.axis2.client.FaultMapKey(
										faultElt.getQName(), "deployProcess"));
						java.lang.Class messageClass = java.lang.Class
								.forName(messageClassName);
						java.lang.Object messageObject = fromOM(faultElt,
								messageClass, null);
						java.lang.reflect.Method m = exceptionClass.getMethod(
								"setFaultMessage",
								new java.lang.Class[] { messageClass });
						m.invoke(ex, new java.lang.Object[] { messageObject });

						throw new java.rmi.RemoteException(ex.getMessage(), ex);
					} catch (java.lang.ClassCastException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.ClassNotFoundException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.NoSuchMethodException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.reflect.InvocationTargetException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.IllegalAccessException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.InstantiationException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					}
				} else {
					throw f;
				}
			} else {
				throw f;
			}
		} finally {
			if (_messageContext.getTransportOut() != null) {
				_messageContext.getTransportOut().getSender()
						.cleanup(_messageContext);
			}
		}
	}

	/**
	 * Auto generated method signature for Asynchronous Invocations
	 * 
	 * @see test2.axis.ProcessDeployerService#startdeployProcess
	 * @param deployProcess2
	 */
	public void startdeployProcess(

	ProcessDeployerServiceStub.DeployProcess deployProcess2,

	final ProcessDeployerServiceCallbackHandler callback)

	throws java.rmi.RemoteException {

		org.apache.axis2.client.OperationClient _operationClient = _serviceClient
				.createClient(_operations[1].getName());
		_operationClient.getOptions().setAction(
				"http://precise.funpd.ac.be/AuiDeployer/deployProcess");
		_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

		addPropertyToOperationClient(
				_operationClient,
				org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
				"&");

		// create SOAP envelope with that payload
		org.apache.axiom.soap.SOAPEnvelope env = null;
		final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

		// Style is Doc.

		env = toEnvelope(getFactory(_operationClient.getOptions()
				.getSoapVersionURI()), deployProcess2,
				optimizeContent(new javax.xml.namespace.QName(
						"http://precise.funpd.ac.be/AuiDeployer",
						"deployProcess")), new javax.xml.namespace.QName(
						"http://precise.funpd.ac.be/AuiDeployer",
						"deployProcess"));

		// adding SOAP soap_headers
		_serviceClient.addHeadersToEnvelope(env);
		// create message context with that soap envelope
		_messageContext.setEnvelope(env);

		// add the message context to the operation client
		_operationClient.addMessageContext(_messageContext);

		_operationClient
				.setCallback(new org.apache.axis2.client.async.AxisCallback() {
					public void onMessage(
							org.apache.axis2.context.MessageContext resultContext) {
						try {
							org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext
									.getEnvelope();

							java.lang.Object object = fromOM(
									resultEnv.getBody().getFirstElement(),
									ProcessDeployerServiceStub.DeployProcessResponse.class,
									getEnvelopeNamespaces(resultEnv));
							callback.receiveResultdeployProcess((ProcessDeployerServiceStub.DeployProcessResponse) object);

						} catch (org.apache.axis2.AxisFault e) {
							callback.receiveErrordeployProcess(e);
						}
					}

					public void onError(java.lang.Exception error) {
						if (error instanceof org.apache.axis2.AxisFault) {
							org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
							org.apache.axiom.om.OMElement faultElt = f
									.getDetail();
							if (faultElt != null) {
								if (faultExceptionNameMap
										.containsKey(new org.apache.axis2.client.FaultMapKey(
												faultElt.getQName(),
												"deployProcess"))) {
									// make the fault by reflection
									try {
										java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap
												.get(new org.apache.axis2.client.FaultMapKey(
														faultElt.getQName(),
														"deployProcess"));
										java.lang.Class exceptionClass = java.lang.Class
												.forName(exceptionClassName);
										java.lang.Exception ex = (java.lang.Exception) exceptionClass
												.newInstance();
										// message class
										java.lang.String messageClassName = (java.lang.String) faultMessageMap
												.get(new org.apache.axis2.client.FaultMapKey(
														faultElt.getQName(),
														"deployProcess"));
										java.lang.Class messageClass = java.lang.Class
												.forName(messageClassName);
										java.lang.Object messageObject = fromOM(
												faultElt, messageClass, null);
										java.lang.reflect.Method m = exceptionClass
												.getMethod(
														"setFaultMessage",
														new java.lang.Class[] { messageClass });
										m.invoke(
												ex,
												new java.lang.Object[] { messageObject });

										callback.receiveErrordeployProcess(new java.rmi.RemoteException(
												ex.getMessage(), ex));
									} catch (java.lang.ClassCastException e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrordeployProcess(f);
									} catch (java.lang.ClassNotFoundException e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrordeployProcess(f);
									} catch (java.lang.NoSuchMethodException e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrordeployProcess(f);
									} catch (java.lang.reflect.InvocationTargetException e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrordeployProcess(f);
									} catch (java.lang.IllegalAccessException e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrordeployProcess(f);
									} catch (java.lang.InstantiationException e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrordeployProcess(f);
									} catch (org.apache.axis2.AxisFault e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrordeployProcess(f);
									}
								} else {
									callback.receiveErrordeployProcess(f);
								}
							} else {
								callback.receiveErrordeployProcess(f);
							}
						} else {
							callback.receiveErrordeployProcess(error);
						}
					}

					public void onFault(
							org.apache.axis2.context.MessageContext faultContext) {
						org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils
								.getInboundFaultFromMessageContext(faultContext);
						onError(fault);
					}

					public void onComplete() {
						try {
							_messageContext.getTransportOut().getSender()
									.cleanup(_messageContext);
						} catch (org.apache.axis2.AxisFault axisFault) {
							callback.receiveErrordeployProcess(axisFault);
						}
					}
				});

		org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
		if (_operations[1].getMessageReceiver() == null
				&& _operationClient.getOptions().isUseSeparateListener()) {
			_callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
			_operations[1].setMessageReceiver(_callbackReceiver);
		}

		// execute the operation client
		_operationClient.execute(false);

	}

	/**
	 * A utility method that copies the namepaces from the SOAPEnvelope
	 */
	private java.util.Map getEnvelopeNamespaces(
			org.apache.axiom.soap.SOAPEnvelope env) {
		java.util.Map returnMap = new java.util.HashMap();
		java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
		while (namespaceIterator.hasNext()) {
			org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator
					.next();
			returnMap.put(ns.getPrefix(), ns.getNamespaceURI());
		}
		return returnMap;
	}

	private javax.xml.namespace.QName[] opNameArray = null;

	private boolean optimizeContent(javax.xml.namespace.QName opName) {

		if (opNameArray == null) {
			return false;
		}
		for (int i = 0; i < opNameArray.length; i++) {
			if (opName.equals(opNameArray[i])) {
				return true;
			}
		}
		return false;
	}

	// http://138.48.32.93:8050/UsiWSC_Manager/services/ProcessDeployer
	public static class UiMappingType implements
			org.apache.axis2.databinding.ADBBean {
		/*
		 * This type was generated from the piece of schema that had name =
		 * uiMappingType Namespace URI = http://precise.funpd.ac.be/AuiDeployer
		 * Namespace Prefix = ns1
		 */

		/**
		 * field for ActivityId
		 */

		protected java.lang.String localActivityId;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getActivityId() {
			return localActivityId;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            ActivityId
		 */
		public void setActivityId(java.lang.String param) {

			this.localActivityId = param;

		}

		/**
		 * field for IuId
		 */

		protected java.lang.String localIuId;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getIuId() {
			return localIuId;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            IuId
		 */
		public void setIuId(java.lang.String param) {

			this.localIuId = param;

		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory)
				throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(
					this, parentQName);
			return factory.createOMElement(dataSource, parentQName);

		}

		public void serialize(final javax.xml.namespace.QName parentQName,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		public void serialize(final javax.xml.namespace.QName parentQName,
				javax.xml.stream.XMLStreamWriter xmlWriter,
				boolean serializeType)
				throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {

			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();
			writeStartElement(prefix, namespace, parentQName.getLocalPart(),
					xmlWriter);

			if (serializeType) {

				java.lang.String namespacePrefix = registerPrefix(xmlWriter,
						"http://precise.funpd.ac.be/AuiDeployer");
				if ((namespacePrefix != null)
						&& (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi",
							"http://www.w3.org/2001/XMLSchema-instance",
							"type", namespacePrefix + ":uiMappingType",
							xmlWriter);
				} else {
					writeAttribute("xsi",
							"http://www.w3.org/2001/XMLSchema-instance",
							"type", "uiMappingType", xmlWriter);
				}

			}

			namespace = "http://precise.funpd.ac.be/AuiDeployer";
			writeStartElement(null, namespace, "activityId", xmlWriter);

			if (localActivityId == null) {
				// write the nil attribute

				throw new org.apache.axis2.databinding.ADBException(
						"activityId cannot be null!!");

			} else {

				xmlWriter.writeCharacters(localActivityId);

			}

			xmlWriter.writeEndElement();

			namespace = "http://precise.funpd.ac.be/AuiDeployer";
			writeStartElement(null, namespace, "iuId", xmlWriter);

			if (localIuId == null) {
				// write the nil attribute

				throw new org.apache.axis2.databinding.ADBException(
						"iuId cannot be null!!");

			} else {

				xmlWriter.writeCharacters(localIuId);

			}

			xmlWriter.writeEndElement();

			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(
				java.lang.String namespace) {
			if (namespace.equals("http://precise.funpd.ac.be/AuiDeployer")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil
					.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix,
				java.lang.String namespace, java.lang.String localPart,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix,
				java.lang.String namespace, java.lang.String attName,
				java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace,
				java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace,
				java.lang.String attName, javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter
					.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix
							+ ":"
							+ org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter
							.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qname));
				}

			} else {
				xmlWriter
						.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite
									.append(prefix)
									.append(":")
									.append(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToString(qnames[i]));
						} else {
							stringToWrite
									.append(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToString(qnames[i]));
						}
					} else {
						stringToWrite
								.append(org.apache.axis2.databinding.utils.ConverterUtil
										.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(
				javax.xml.stream.XMLStreamWriter xmlWriter,
				java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				javax.xml.namespace.NamespaceContext nsContext = xmlWriter
						.getNamespaceContext();
				while (true) {
					java.lang.String uri = nsContext.getNamespaceURI(prefix);
					if (uri == null || uri.length() == 0) {
						break;
					}
					prefix = org.apache.axis2.databinding.utils.BeanUtil
							.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(
				javax.xml.namespace.QName qName)
				throws org.apache.axis2.databinding.ADBException {

			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			elementList.add(new javax.xml.namespace.QName(
					"http://precise.funpd.ac.be/AuiDeployer", "activityId"));

			if (localActivityId != null) {
				elementList
						.add(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localActivityId));
			} else {
				throw new org.apache.axis2.databinding.ADBException(
						"activityId cannot be null!!");
			}

			elementList.add(new javax.xml.namespace.QName(
					"http://precise.funpd.ac.be/AuiDeployer", "iuId"));

			if (localIuId != null) {
				elementList
						.add(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localIuId));
			} else {
				throw new org.apache.axis2.databinding.ADBException(
						"iuId cannot be null!!");
			}

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(
					qName, elementList.toArray(), attribList.toArray());

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static UiMappingType parse(
					javax.xml.stream.XMLStreamReader reader)
					throws java.lang.Exception {
				UiMappingType object = new UiMappingType();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader
							.getAttributeValue(
									"http://www.w3.org/2001/XMLSchema-instance",
									"type") != null) {
						java.lang.String fullTypeName = reader
								.getAttributeValue(
										"http://www.w3.org/2001/XMLSchema-instance",
										"type");
						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;
							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0,
										fullTypeName.indexOf(":"));
							}
							nsPrefix = nsPrefix == null ? "" : nsPrefix;

							java.lang.String type = fullTypeName
									.substring(fullTypeName.indexOf(":") + 1);

							if (!"uiMappingType".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader
										.getNamespaceContext().getNamespaceURI(
												nsPrefix);
								return (UiMappingType) ExtensionMapper
										.getTypeObject(nsUri, type, reader);
							}

						}

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName(
									"http://precise.funpd.ac.be/AuiDeployer",
									"activityId").equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setActivityId(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement " + reader.getName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName(
									"http://precise.funpd.ac.be/AuiDeployer",
									"iuId").equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setIuId(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement " + reader.getName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement())
						// A start element we are not expecting indicates a
						// trailing invalid property
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement " + reader.getName());

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class DeployAui implements
			org.apache.axis2.databinding.ADBBean {

		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
				"http://precise.funpd.ac.be/AuiDeployer", "deployAui", "ns1");

		/**
		 * field for File
		 */

		protected javax.activation.DataHandler localFile;

		/**
		 * Auto generated getter method
		 * 
		 * @return javax.activation.DataHandler
		 */
		public javax.activation.DataHandler getFile() {
			return localFile;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            File
		 */
		public void setFile(javax.activation.DataHandler param) {

			this.localFile = param;

		}

		/**
		 * field for Description This was an Array!
		 */

		protected AUI_Descripton[] localDescription;

		/**
		 * Auto generated getter method
		 * 
		 * @return AUI_Descripton[]
		 */
		public AUI_Descripton[] getDescription() {
			return localDescription;
		}

		/**
		 * validate the array for Description
		 */
		protected void validateDescription(AUI_Descripton[] param) {

			if ((param != null) && (param.length < 1)) {
				throw new java.lang.RuntimeException();
			}

		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Description
		 */
		public void setDescription(AUI_Descripton[] param) {

			validateDescription(param);

			this.localDescription = param;
		}

		/**
		 * Auto generated add method for the array for convenience
		 * 
		 * @param param
		 *            AUI_Descripton
		 */
		public void addDescription(AUI_Descripton param) {
			if (localDescription == null) {
				localDescription = new AUI_Descripton[] {};
			}

			java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil
					.toList(localDescription);
			list.add(param);
			this.localDescription = (AUI_Descripton[]) list
					.toArray(new AUI_Descripton[list.size()]);

		}

		/**
		 * field for ProcessName
		 */

		protected java.lang.String localProcessName;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getProcessName() {
			return localProcessName;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            ProcessName
		 */
		public void setProcessName(java.lang.String param) {

			this.localProcessName = param;

		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory)
				throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(
					this, MY_QNAME);
			return factory.createOMElement(dataSource, MY_QNAME);

		}

		public void serialize(final javax.xml.namespace.QName parentQName,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		public void serialize(final javax.xml.namespace.QName parentQName,
				javax.xml.stream.XMLStreamWriter xmlWriter,
				boolean serializeType)
				throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {

			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();
			writeStartElement(prefix, namespace, parentQName.getLocalPart(),
					xmlWriter);

			if (serializeType) {

				java.lang.String namespacePrefix = registerPrefix(xmlWriter,
						"http://precise.funpd.ac.be/AuiDeployer");
				if ((namespacePrefix != null)
						&& (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi",
							"http://www.w3.org/2001/XMLSchema-instance",
							"type", namespacePrefix + ":deployAui", xmlWriter);
				} else {
					writeAttribute("xsi",
							"http://www.w3.org/2001/XMLSchema-instance",
							"type", "deployAui", xmlWriter);
				}

			}

			namespace = "http://precise.funpd.ac.be/AuiDeployer";
			writeStartElement(null, namespace, "file", xmlWriter);

			if (localFile != null) {
				try {
					org.apache.axiom.util.stax.XMLStreamWriterUtils
							.writeDataHandler(xmlWriter, localFile, null, true);
				} catch (java.io.IOException ex) {
					throw new javax.xml.stream.XMLStreamException(
							"Unable to read data handler for file", ex);
				}
			} else {

			}

			xmlWriter.writeEndElement();

			if (localDescription != null) {
				for (int i = 0; i < localDescription.length; i++) {
					if (localDescription[i] != null) {
						localDescription[i]
								.serialize(
										new javax.xml.namespace.QName(
												"http://precise.funpd.ac.be/AuiDeployer",
												"description"), xmlWriter);
					} else {

						throw new org.apache.axis2.databinding.ADBException(
								"description cannot be null!!");

					}

				}
			} else {

				throw new org.apache.axis2.databinding.ADBException(
						"description cannot be null!!");

			}

			namespace = "http://precise.funpd.ac.be/AuiDeployer";
			writeStartElement(null, namespace, "processName", xmlWriter);

			if (localProcessName == null) {
				// write the nil attribute

				throw new org.apache.axis2.databinding.ADBException(
						"processName cannot be null!!");

			} else {

				xmlWriter.writeCharacters(localProcessName);

			}

			xmlWriter.writeEndElement();

			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(
				java.lang.String namespace) {
			if (namespace.equals("http://precise.funpd.ac.be/AuiDeployer")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil
					.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix,
				java.lang.String namespace, java.lang.String localPart,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix,
				java.lang.String namespace, java.lang.String attName,
				java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace,
				java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace,
				java.lang.String attName, javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter
					.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix
							+ ":"
							+ org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter
							.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qname));
				}

			} else {
				xmlWriter
						.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite
									.append(prefix)
									.append(":")
									.append(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToString(qnames[i]));
						} else {
							stringToWrite
									.append(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToString(qnames[i]));
						}
					} else {
						stringToWrite
								.append(org.apache.axis2.databinding.utils.ConverterUtil
										.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(
				javax.xml.stream.XMLStreamWriter xmlWriter,
				java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				javax.xml.namespace.NamespaceContext nsContext = xmlWriter
						.getNamespaceContext();
				while (true) {
					java.lang.String uri = nsContext.getNamespaceURI(prefix);
					if (uri == null || uri.length() == 0) {
						break;
					}
					prefix = org.apache.axis2.databinding.utils.BeanUtil
							.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(
				javax.xml.namespace.QName qName)
				throws org.apache.axis2.databinding.ADBException {

			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			elementList.add(new javax.xml.namespace.QName(
					"http://precise.funpd.ac.be/AuiDeployer", "file"));

			elementList.add(localFile);

			if (localDescription != null) {
				for (int i = 0; i < localDescription.length; i++) {

					if (localDescription[i] != null) {
						elementList.add(new javax.xml.namespace.QName(
								"http://precise.funpd.ac.be/AuiDeployer",
								"description"));
						elementList.add(localDescription[i]);
					} else {

						throw new org.apache.axis2.databinding.ADBException(
								"description cannot be null !!");

					}

				}
			} else {

				throw new org.apache.axis2.databinding.ADBException(
						"description cannot be null!!");

			}

			elementList.add(new javax.xml.namespace.QName(
					"http://precise.funpd.ac.be/AuiDeployer", "processName"));

			if (localProcessName != null) {
				elementList
						.add(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localProcessName));
			} else {
				throw new org.apache.axis2.databinding.ADBException(
						"processName cannot be null!!");
			}

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(
					qName, elementList.toArray(), attribList.toArray());

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static DeployAui parse(
					javax.xml.stream.XMLStreamReader reader)
					throws java.lang.Exception {
				DeployAui object = new DeployAui();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader
							.getAttributeValue(
									"http://www.w3.org/2001/XMLSchema-instance",
									"type") != null) {
						java.lang.String fullTypeName = reader
								.getAttributeValue(
										"http://www.w3.org/2001/XMLSchema-instance",
										"type");
						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;
							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0,
										fullTypeName.indexOf(":"));
							}
							nsPrefix = nsPrefix == null ? "" : nsPrefix;

							java.lang.String type = fullTypeName
									.substring(fullTypeName.indexOf(":") + 1);

							if (!"deployAui".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader
										.getNamespaceContext().getNamespaceURI(
												nsPrefix);
								return (DeployAui) ExtensionMapper
										.getTypeObject(nsUri, type, reader);
							}

						}

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					java.util.ArrayList list2 = new java.util.ArrayList();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName(
									"http://precise.funpd.ac.be/AuiDeployer",
									"file").equals(reader.getName())) {

						object.setFile(org.apache.axiom.util.stax.XMLStreamReaderUtils
								.getDataHandlerFromElement(reader));

						reader.next();

					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement " + reader.getName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName(
									"http://precise.funpd.ac.be/AuiDeployer",
									"description").equals(reader.getName())) {

						// Process the array and step past its final element's
						// end.
						list2.add(AUI_Descripton.Factory.parse(reader));

						// loop until we find a start element that is not part
						// of this array
						boolean loopDone2 = false;
						while (!loopDone2) {
							// We should be at the end element, but make sure
							while (!reader.isEndElement())
								reader.next();
							// Step out of this element
							reader.next();
							// Step to next element event.
							while (!reader.isStartElement()
									&& !reader.isEndElement())
								reader.next();
							if (reader.isEndElement()) {
								// two continuous end elements means we are
								// exiting the xml structure
								loopDone2 = true;
							} else {
								if (new javax.xml.namespace.QName(
										"http://precise.funpd.ac.be/AuiDeployer",
										"description").equals(reader.getName())) {
									list2.add(AUI_Descripton.Factory
											.parse(reader));

								} else {
									loopDone2 = true;
								}
							}
						}
						// call the converter utility to convert and set the
						// array

						object.setDescription((AUI_Descripton[]) org.apache.axis2.databinding.utils.ConverterUtil
								.convertToArray(AUI_Descripton.class, list2));

					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement " + reader.getName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName(
									"http://precise.funpd.ac.be/AuiDeployer",
									"processName").equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setProcessName(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement " + reader.getName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement())
						// A start element we are not expecting indicates a
						// trailing invalid property
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement " + reader.getName());

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class ExtensionMapper {

		public static java.lang.Object getTypeObject(
				java.lang.String namespaceURI, java.lang.String typeName,
				javax.xml.stream.XMLStreamReader reader)
				throws java.lang.Exception {

			if ("http://precise.funpd.ac.be/AuiDeployer".equals(namespaceURI)
					&& "uiMappingType".equals(typeName)) {

				return UiMappingType.Factory.parse(reader);

			}

			if ("http://precise.funpd.ac.be/AuiDeployer".equals(namespaceURI)
					&& "AUI_Descripton".equals(typeName)) {

				return AUI_Descripton.Factory.parse(reader);

			}

			throw new org.apache.axis2.databinding.ADBException(
					"Unsupported type " + namespaceURI + " " + typeName);
		}

	}

	public static class DeployAuiResponse implements
			org.apache.axis2.databinding.ADBBean {

		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
				"http://precise.funpd.ac.be/AuiDeployer", "deployAuiResponse",
				"ns1");

		/**
		 * field for DeploymentVersion
		 */

		protected java.lang.String localDeploymentVersion;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getDeploymentVersion() {
			return localDeploymentVersion;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            DeploymentVersion
		 */
		public void setDeploymentVersion(java.lang.String param) {

			this.localDeploymentVersion = param;

		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory)
				throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(
					this, MY_QNAME);
			return factory.createOMElement(dataSource, MY_QNAME);

		}

		public void serialize(final javax.xml.namespace.QName parentQName,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		public void serialize(final javax.xml.namespace.QName parentQName,
				javax.xml.stream.XMLStreamWriter xmlWriter,
				boolean serializeType)
				throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {

			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();
			writeStartElement(prefix, namespace, parentQName.getLocalPart(),
					xmlWriter);

			if (serializeType) {

				java.lang.String namespacePrefix = registerPrefix(xmlWriter,
						"http://precise.funpd.ac.be/AuiDeployer");
				if ((namespacePrefix != null)
						&& (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi",
							"http://www.w3.org/2001/XMLSchema-instance",
							"type", namespacePrefix + ":deployAuiResponse",
							xmlWriter);
				} else {
					writeAttribute("xsi",
							"http://www.w3.org/2001/XMLSchema-instance",
							"type", "deployAuiResponse", xmlWriter);
				}

			}

			namespace = "http://precise.funpd.ac.be/AuiDeployer";
			writeStartElement(null, namespace, "deploymentVersion", xmlWriter);

			if (localDeploymentVersion == null) {
				// write the nil attribute

				throw new org.apache.axis2.databinding.ADBException(
						"deploymentVersion cannot be null!!");

			} else {

				xmlWriter.writeCharacters(localDeploymentVersion);

			}

			xmlWriter.writeEndElement();

			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(
				java.lang.String namespace) {
			if (namespace.equals("http://precise.funpd.ac.be/AuiDeployer")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil
					.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix,
				java.lang.String namespace, java.lang.String localPart,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix,
				java.lang.String namespace, java.lang.String attName,
				java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace,
				java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace,
				java.lang.String attName, javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter
					.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix
							+ ":"
							+ org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter
							.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qname));
				}

			} else {
				xmlWriter
						.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite
									.append(prefix)
									.append(":")
									.append(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToString(qnames[i]));
						} else {
							stringToWrite
									.append(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToString(qnames[i]));
						}
					} else {
						stringToWrite
								.append(org.apache.axis2.databinding.utils.ConverterUtil
										.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(
				javax.xml.stream.XMLStreamWriter xmlWriter,
				java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				javax.xml.namespace.NamespaceContext nsContext = xmlWriter
						.getNamespaceContext();
				while (true) {
					java.lang.String uri = nsContext.getNamespaceURI(prefix);
					if (uri == null || uri.length() == 0) {
						break;
					}
					prefix = org.apache.axis2.databinding.utils.BeanUtil
							.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(
				javax.xml.namespace.QName qName)
				throws org.apache.axis2.databinding.ADBException {

			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			elementList.add(new javax.xml.namespace.QName(
					"http://precise.funpd.ac.be/AuiDeployer",
					"deploymentVersion"));

			if (localDeploymentVersion != null) {
				elementList
						.add(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localDeploymentVersion));
			} else {
				throw new org.apache.axis2.databinding.ADBException(
						"deploymentVersion cannot be null!!");
			}

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(
					qName, elementList.toArray(), attribList.toArray());

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static DeployAuiResponse parse(
					javax.xml.stream.XMLStreamReader reader)
					throws java.lang.Exception {
				DeployAuiResponse object = new DeployAuiResponse();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader
							.getAttributeValue(
									"http://www.w3.org/2001/XMLSchema-instance",
									"type") != null) {
						java.lang.String fullTypeName = reader
								.getAttributeValue(
										"http://www.w3.org/2001/XMLSchema-instance",
										"type");
						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;
							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0,
										fullTypeName.indexOf(":"));
							}
							nsPrefix = nsPrefix == null ? "" : nsPrefix;

							java.lang.String type = fullTypeName
									.substring(fullTypeName.indexOf(":") + 1);

							if (!"deployAuiResponse".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader
										.getNamespaceContext().getNamespaceURI(
												nsPrefix);
								return (DeployAuiResponse) ExtensionMapper
										.getTypeObject(nsUri, type, reader);
							}

						}

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName(
									"http://precise.funpd.ac.be/AuiDeployer",
									"deploymentVersion").equals(reader
									.getName())) {

						java.lang.String content = reader.getElementText();

						object.setDeploymentVersion(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement " + reader.getName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement())
						// A start element we are not expecting indicates a
						// trailing invalid property
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement " + reader.getName());

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class AUI_Descripton implements
			org.apache.axis2.databinding.ADBBean {
		/*
		 * This type was generated from the piece of schema that had name =
		 * AUI_Descripton Namespace URI = http://precise.funpd.ac.be/AuiDeployer
		 * Namespace Prefix = ns1
		 */

		/**
		 * field for Role
		 */

		protected java.lang.String localRole;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getRole() {
			return localRole;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Role
		 */
		public void setRole(java.lang.String param) {

			this.localRole = param;

		}

		/**
		 * field for Aui_entry
		 */

		protected java.lang.String localAui_entry;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getAui_entry() {
			return localAui_entry;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Aui_entry
		 */
		public void setAui_entry(java.lang.String param) {

			this.localAui_entry = param;

		}

		/**
		 * field for UiMapping This was an Array!
		 */

		protected UiMappingType[] localUiMapping;

		/**
		 * Auto generated getter method
		 * 
		 * @return UiMappingType[]
		 */
		public UiMappingType[] getUiMapping() {
			return localUiMapping;
		}

		/**
		 * validate the array for UiMapping
		 */
		protected void validateUiMapping(UiMappingType[] param) {

			if ((param != null) && (param.length < 1)) {
				throw new java.lang.RuntimeException();
			}

		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            UiMapping
		 */
		public void setUiMapping(UiMappingType[] param) {

			validateUiMapping(param);

			this.localUiMapping = param;
		}

		/**
		 * Auto generated add method for the array for convenience
		 * 
		 * @param param
		 *            UiMappingType
		 */
		public void addUiMapping(UiMappingType param) {
			if (localUiMapping == null) {
				localUiMapping = new UiMappingType[] {};
			}

			java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil
					.toList(localUiMapping);
			list.add(param);
			this.localUiMapping = (UiMappingType[]) list
					.toArray(new UiMappingType[list.size()]);

		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory)
				throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(
					this, parentQName);
			return factory.createOMElement(dataSource, parentQName);

		}

		public void serialize(final javax.xml.namespace.QName parentQName,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		public void serialize(final javax.xml.namespace.QName parentQName,
				javax.xml.stream.XMLStreamWriter xmlWriter,
				boolean serializeType)
				throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {

			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();
			writeStartElement(prefix, namespace, parentQName.getLocalPart(),
					xmlWriter);

			if (serializeType) {

				java.lang.String namespacePrefix = registerPrefix(xmlWriter,
						"http://precise.funpd.ac.be/AuiDeployer");
				if ((namespacePrefix != null)
						&& (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi",
							"http://www.w3.org/2001/XMLSchema-instance",
							"type", namespacePrefix + ":AUI_Descripton",
							xmlWriter);
				} else {
					writeAttribute("xsi",
							"http://www.w3.org/2001/XMLSchema-instance",
							"type", "AUI_Descripton", xmlWriter);
				}

			}

			namespace = "http://precise.funpd.ac.be/AuiDeployer";
			writeStartElement(null, namespace, "role", xmlWriter);

			if (localRole == null) {
				// write the nil attribute

				throw new org.apache.axis2.databinding.ADBException(
						"role cannot be null!!");

			} else {

				xmlWriter.writeCharacters(localRole);

			}

			xmlWriter.writeEndElement();

			namespace = "http://precise.funpd.ac.be/AuiDeployer";
			writeStartElement(null, namespace, "aui_entry", xmlWriter);

			if (localAui_entry == null) {
				// write the nil attribute

				throw new org.apache.axis2.databinding.ADBException(
						"aui_entry cannot be null!!");

			} else {

				xmlWriter.writeCharacters(localAui_entry);

			}

			xmlWriter.writeEndElement();

			if (localUiMapping != null) {
				for (int i = 0; i < localUiMapping.length; i++) {
					if (localUiMapping[i] != null) {
						localUiMapping[i]
								.serialize(
										new javax.xml.namespace.QName(
												"http://precise.funpd.ac.be/AuiDeployer",
												"uiMapping"), xmlWriter);
					} else {

						throw new org.apache.axis2.databinding.ADBException(
								"uiMapping cannot be null!!");

					}

				}
			} else {

				throw new org.apache.axis2.databinding.ADBException(
						"uiMapping cannot be null!!");

			}

			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(
				java.lang.String namespace) {
			if (namespace.equals("http://precise.funpd.ac.be/AuiDeployer")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil
					.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix,
				java.lang.String namespace, java.lang.String localPart,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix,
				java.lang.String namespace, java.lang.String attName,
				java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace,
				java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace,
				java.lang.String attName, javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter
					.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix
							+ ":"
							+ org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter
							.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qname));
				}

			} else {
				xmlWriter
						.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite
									.append(prefix)
									.append(":")
									.append(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToString(qnames[i]));
						} else {
							stringToWrite
									.append(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToString(qnames[i]));
						}
					} else {
						stringToWrite
								.append(org.apache.axis2.databinding.utils.ConverterUtil
										.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(
				javax.xml.stream.XMLStreamWriter xmlWriter,
				java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				javax.xml.namespace.NamespaceContext nsContext = xmlWriter
						.getNamespaceContext();
				while (true) {
					java.lang.String uri = nsContext.getNamespaceURI(prefix);
					if (uri == null || uri.length() == 0) {
						break;
					}
					prefix = org.apache.axis2.databinding.utils.BeanUtil
							.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(
				javax.xml.namespace.QName qName)
				throws org.apache.axis2.databinding.ADBException {

			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			elementList.add(new javax.xml.namespace.QName(
					"http://precise.funpd.ac.be/AuiDeployer", "role"));

			if (localRole != null) {
				elementList
						.add(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localRole));
			} else {
				throw new org.apache.axis2.databinding.ADBException(
						"role cannot be null!!");
			}

			elementList.add(new javax.xml.namespace.QName(
					"http://precise.funpd.ac.be/AuiDeployer", "aui_entry"));

			if (localAui_entry != null) {
				elementList
						.add(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localAui_entry));
			} else {
				throw new org.apache.axis2.databinding.ADBException(
						"aui_entry cannot be null!!");
			}

			if (localUiMapping != null) {
				for (int i = 0; i < localUiMapping.length; i++) {

					if (localUiMapping[i] != null) {
						elementList.add(new javax.xml.namespace.QName(
								"http://precise.funpd.ac.be/AuiDeployer",
								"uiMapping"));
						elementList.add(localUiMapping[i]);
					} else {

						throw new org.apache.axis2.databinding.ADBException(
								"uiMapping cannot be null !!");

					}

				}
			} else {

				throw new org.apache.axis2.databinding.ADBException(
						"uiMapping cannot be null!!");

			}

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(
					qName, elementList.toArray(), attribList.toArray());

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static AUI_Descripton parse(
					javax.xml.stream.XMLStreamReader reader)
					throws java.lang.Exception {
				AUI_Descripton object = new AUI_Descripton();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader
							.getAttributeValue(
									"http://www.w3.org/2001/XMLSchema-instance",
									"type") != null) {
						java.lang.String fullTypeName = reader
								.getAttributeValue(
										"http://www.w3.org/2001/XMLSchema-instance",
										"type");
						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;
							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0,
										fullTypeName.indexOf(":"));
							}
							nsPrefix = nsPrefix == null ? "" : nsPrefix;

							java.lang.String type = fullTypeName
									.substring(fullTypeName.indexOf(":") + 1);

							if (!"AUI_Descripton".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader
										.getNamespaceContext().getNamespaceURI(
												nsPrefix);
								return (AUI_Descripton) ExtensionMapper
										.getTypeObject(nsUri, type, reader);
							}

						}

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					java.util.ArrayList list3 = new java.util.ArrayList();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName(
									"http://precise.funpd.ac.be/AuiDeployer",
									"role").equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setRole(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement " + reader.getName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName(
									"http://precise.funpd.ac.be/AuiDeployer",
									"aui_entry").equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setAui_entry(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement " + reader.getName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName(
									"http://precise.funpd.ac.be/AuiDeployer",
									"uiMapping").equals(reader.getName())) {

						// Process the array and step past its final element's
						// end.
						list3.add(UiMappingType.Factory.parse(reader));

						// loop until we find a start element that is not part
						// of this array
						boolean loopDone3 = false;
						while (!loopDone3) {
							// We should be at the end element, but make sure
							while (!reader.isEndElement())
								reader.next();
							// Step out of this element
							reader.next();
							// Step to next element event.
							while (!reader.isStartElement()
									&& !reader.isEndElement())
								reader.next();
							if (reader.isEndElement()) {
								// two continuous end elements means we are
								// exiting the xml structure
								loopDone3 = true;
							} else {
								if (new javax.xml.namespace.QName(
										"http://precise.funpd.ac.be/AuiDeployer",
										"uiMapping").equals(reader.getName())) {
									list3.add(UiMappingType.Factory
											.parse(reader));

								} else {
									loopDone3 = true;
								}
							}
						}
						// call the converter utility to convert and set the
						// array

						object.setUiMapping((UiMappingType[]) org.apache.axis2.databinding.utils.ConverterUtil
								.convertToArray(UiMappingType.class, list3));

					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement " + reader.getName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement())
						// A start element we are not expecting indicates a
						// trailing invalid property
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement " + reader.getName());

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class DeployProcess implements
			org.apache.axis2.databinding.ADBBean {

		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
				"http://precise.funpd.ac.be/AuiDeployer", "deployProcess",
				"ns1");

		/**
		 * field for AuiZip
		 */

		protected javax.activation.DataHandler localAuiZip;

		/**
		 * Auto generated getter method
		 * 
		 * @return javax.activation.DataHandler
		 */
		public javax.activation.DataHandler getAuiZip() {
			return localAuiZip;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            AuiZip
		 */
		public void setAuiZip(javax.activation.DataHandler param) {

			this.localAuiZip = param;

		}

		/**
		 * field for ProcessZip
		 */

		protected javax.activation.DataHandler localProcessZip;

		/**
		 * Auto generated getter method
		 * 
		 * @return javax.activation.DataHandler
		 */
		public javax.activation.DataHandler getProcessZip() {
			return localProcessZip;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            ProcessZip
		 */
		public void setProcessZip(javax.activation.DataHandler param) {

			this.localProcessZip = param;

		}

		/**
		 * field for ProcessId
		 */

		protected java.lang.String localProcessId;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getProcessId() {
			return localProcessId;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            ProcessId
		 */
		public void setProcessId(java.lang.String param) {

			this.localProcessId = param;

		}

		/**
		 * field for UiDescription This was an Array!
		 */

		protected AUI_Descripton[] localUiDescription;

		/**
		 * Auto generated getter method
		 * 
		 * @return AUI_Descripton[]
		 */
		public AUI_Descripton[] getUiDescription() {
			return localUiDescription;
		}

		/**
		 * validate the array for UiDescription
		 */
		protected void validateUiDescription(AUI_Descripton[] param) {

			if ((param != null) && (param.length < 1)) {
				throw new java.lang.RuntimeException();
			}

		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            UiDescription
		 */
		public void setUiDescription(AUI_Descripton[] param) {

			validateUiDescription(param);

			this.localUiDescription = param;
		}

		/**
		 * Auto generated add method for the array for convenience
		 * 
		 * @param param
		 *            AUI_Descripton
		 */
		public void addUiDescription(AUI_Descripton param) {
			if (localUiDescription == null) {
				localUiDescription = new AUI_Descripton[] {};
			}

			java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil
					.toList(localUiDescription);
			list.add(param);
			this.localUiDescription = (AUI_Descripton[]) list
					.toArray(new AUI_Descripton[list.size()]);

		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory)
				throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(
					this, MY_QNAME);
			return factory.createOMElement(dataSource, MY_QNAME);

		}

		public void serialize(final javax.xml.namespace.QName parentQName,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		public void serialize(final javax.xml.namespace.QName parentQName,
				javax.xml.stream.XMLStreamWriter xmlWriter,
				boolean serializeType)
				throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {

			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();
			writeStartElement(prefix, namespace, parentQName.getLocalPart(),
					xmlWriter);

			if (serializeType) {

				java.lang.String namespacePrefix = registerPrefix(xmlWriter,
						"http://precise.funpd.ac.be/AuiDeployer");
				if ((namespacePrefix != null)
						&& (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi",
							"http://www.w3.org/2001/XMLSchema-instance",
							"type", namespacePrefix + ":deployProcess",
							xmlWriter);
				} else {
					writeAttribute("xsi",
							"http://www.w3.org/2001/XMLSchema-instance",
							"type", "deployProcess", xmlWriter);
				}

			}

			namespace = "http://precise.funpd.ac.be/AuiDeployer";
			writeStartElement(null, namespace, "auiZip", xmlWriter);

			if (localAuiZip != null) {
				try {
					org.apache.axiom.util.stax.XMLStreamWriterUtils
							.writeDataHandler(xmlWriter, localAuiZip, null,
									true);
				} catch (java.io.IOException ex) {
					throw new javax.xml.stream.XMLStreamException(
							"Unable to read data handler for auiZip", ex);
				}
			} else {

			}

			xmlWriter.writeEndElement();

			namespace = "http://precise.funpd.ac.be/AuiDeployer";
			writeStartElement(null, namespace, "processZip", xmlWriter);

			if (localProcessZip != null) {
				try {
					org.apache.axiom.util.stax.XMLStreamWriterUtils
							.writeDataHandler(xmlWriter, localProcessZip, null,
									true);
				} catch (java.io.IOException ex) {
					throw new javax.xml.stream.XMLStreamException(
							"Unable to read data handler for processZip", ex);
				}
			} else {

			}

			xmlWriter.writeEndElement();

			namespace = "http://precise.funpd.ac.be/AuiDeployer";
			writeStartElement(null, namespace, "processId", xmlWriter);

			if (localProcessId == null) {
				// write the nil attribute

				throw new org.apache.axis2.databinding.ADBException(
						"processId cannot be null!!");

			} else {

				xmlWriter.writeCharacters(localProcessId);

			}

			xmlWriter.writeEndElement();

			if (localUiDescription != null) {
				for (int i = 0; i < localUiDescription.length; i++) {
					if (localUiDescription[i] != null) {
						localUiDescription[i]
								.serialize(
										new javax.xml.namespace.QName(
												"http://precise.funpd.ac.be/AuiDeployer",
												"uiDescription"), xmlWriter);
					} else {

						throw new org.apache.axis2.databinding.ADBException(
								"uiDescription cannot be null!!");

					}

				}
			} else {

				throw new org.apache.axis2.databinding.ADBException(
						"uiDescription cannot be null!!");

			}

			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(
				java.lang.String namespace) {
			if (namespace.equals("http://precise.funpd.ac.be/AuiDeployer")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil
					.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix,
				java.lang.String namespace, java.lang.String localPart,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix,
				java.lang.String namespace, java.lang.String attName,
				java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace,
				java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace,
				java.lang.String attName, javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter
					.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix
							+ ":"
							+ org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter
							.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qname));
				}

			} else {
				xmlWriter
						.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite
									.append(prefix)
									.append(":")
									.append(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToString(qnames[i]));
						} else {
							stringToWrite
									.append(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToString(qnames[i]));
						}
					} else {
						stringToWrite
								.append(org.apache.axis2.databinding.utils.ConverterUtil
										.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(
				javax.xml.stream.XMLStreamWriter xmlWriter,
				java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				javax.xml.namespace.NamespaceContext nsContext = xmlWriter
						.getNamespaceContext();
				while (true) {
					java.lang.String uri = nsContext.getNamespaceURI(prefix);
					if (uri == null || uri.length() == 0) {
						break;
					}
					prefix = org.apache.axis2.databinding.utils.BeanUtil
							.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(
				javax.xml.namespace.QName qName)
				throws org.apache.axis2.databinding.ADBException {

			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			elementList.add(new javax.xml.namespace.QName(
					"http://precise.funpd.ac.be/AuiDeployer", "auiZip"));

			elementList.add(localAuiZip);

			elementList.add(new javax.xml.namespace.QName(
					"http://precise.funpd.ac.be/AuiDeployer", "processZip"));

			elementList.add(localProcessZip);

			elementList.add(new javax.xml.namespace.QName(
					"http://precise.funpd.ac.be/AuiDeployer", "processId"));

			if (localProcessId != null) {
				elementList
						.add(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localProcessId));
			} else {
				throw new org.apache.axis2.databinding.ADBException(
						"processId cannot be null!!");
			}

			if (localUiDescription != null) {
				for (int i = 0; i < localUiDescription.length; i++) {

					if (localUiDescription[i] != null) {
						elementList.add(new javax.xml.namespace.QName(
								"http://precise.funpd.ac.be/AuiDeployer",
								"uiDescription"));
						elementList.add(localUiDescription[i]);
					} else {

						throw new org.apache.axis2.databinding.ADBException(
								"uiDescription cannot be null !!");

					}

				}
			} else {

				throw new org.apache.axis2.databinding.ADBException(
						"uiDescription cannot be null!!");

			}

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(
					qName, elementList.toArray(), attribList.toArray());

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static DeployProcess parse(
					javax.xml.stream.XMLStreamReader reader)
					throws java.lang.Exception {
				DeployProcess object = new DeployProcess();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader
							.getAttributeValue(
									"http://www.w3.org/2001/XMLSchema-instance",
									"type") != null) {
						java.lang.String fullTypeName = reader
								.getAttributeValue(
										"http://www.w3.org/2001/XMLSchema-instance",
										"type");
						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;
							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0,
										fullTypeName.indexOf(":"));
							}
							nsPrefix = nsPrefix == null ? "" : nsPrefix;

							java.lang.String type = fullTypeName
									.substring(fullTypeName.indexOf(":") + 1);

							if (!"deployProcess".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader
										.getNamespaceContext().getNamespaceURI(
												nsPrefix);
								return (DeployProcess) ExtensionMapper
										.getTypeObject(nsUri, type, reader);
							}

						}

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					java.util.ArrayList list4 = new java.util.ArrayList();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName(
									"http://precise.funpd.ac.be/AuiDeployer",
									"auiZip").equals(reader.getName())) {

						object.setAuiZip(org.apache.axiom.util.stax.XMLStreamReaderUtils
								.getDataHandlerFromElement(reader));

						reader.next();

					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement " + reader.getName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName(
									"http://precise.funpd.ac.be/AuiDeployer",
									"processZip").equals(reader.getName())) {

						object.setProcessZip(org.apache.axiom.util.stax.XMLStreamReaderUtils
								.getDataHandlerFromElement(reader));

						reader.next();

					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement " + reader.getName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName(
									"http://precise.funpd.ac.be/AuiDeployer",
									"processId").equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setProcessId(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement " + reader.getName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName(
									"http://precise.funpd.ac.be/AuiDeployer",
									"uiDescription").equals(reader.getName())) {

						// Process the array and step past its final element's
						// end.
						list4.add(AUI_Descripton.Factory.parse(reader));

						// loop until we find a start element that is not part
						// of this array
						boolean loopDone4 = false;
						while (!loopDone4) {
							// We should be at the end element, but make sure
							while (!reader.isEndElement())
								reader.next();
							// Step out of this element
							reader.next();
							// Step to next element event.
							while (!reader.isStartElement()
									&& !reader.isEndElement())
								reader.next();
							if (reader.isEndElement()) {
								// two continuous end elements means we are
								// exiting the xml structure
								loopDone4 = true;
							} else {
								if (new javax.xml.namespace.QName(
										"http://precise.funpd.ac.be/AuiDeployer",
										"uiDescription").equals(reader
										.getName())) {
									list4.add(AUI_Descripton.Factory
											.parse(reader));

								} else {
									loopDone4 = true;
								}
							}
						}
						// call the converter utility to convert and set the
						// array

						object.setUiDescription((AUI_Descripton[]) org.apache.axis2.databinding.utils.ConverterUtil
								.convertToArray(AUI_Descripton.class, list4));

					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement " + reader.getName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement())
						// A start element we are not expecting indicates a
						// trailing invalid property
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement " + reader.getName());

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class DeployProcessResponse implements
			org.apache.axis2.databinding.ADBBean {

		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
				"http://precise.funpd.ac.be/AuiDeployer",
				"deployProcessResponse", "ns1");

		/**
		 * field for DeploymentVersion
		 */

		protected java.lang.String localDeploymentVersion;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getDeploymentVersion() {
			return localDeploymentVersion;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            DeploymentVersion
		 */
		public void setDeploymentVersion(java.lang.String param) {

			this.localDeploymentVersion = param;

		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory)
				throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(
					this, MY_QNAME);
			return factory.createOMElement(dataSource, MY_QNAME);

		}

		public void serialize(final javax.xml.namespace.QName parentQName,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		public void serialize(final javax.xml.namespace.QName parentQName,
				javax.xml.stream.XMLStreamWriter xmlWriter,
				boolean serializeType)
				throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {

			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();
			writeStartElement(prefix, namespace, parentQName.getLocalPart(),
					xmlWriter);

			if (serializeType) {

				java.lang.String namespacePrefix = registerPrefix(xmlWriter,
						"http://precise.funpd.ac.be/AuiDeployer");
				if ((namespacePrefix != null)
						&& (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi",
							"http://www.w3.org/2001/XMLSchema-instance",
							"type", namespacePrefix + ":deployProcessResponse",
							xmlWriter);
				} else {
					writeAttribute("xsi",
							"http://www.w3.org/2001/XMLSchema-instance",
							"type", "deployProcessResponse", xmlWriter);
				}

			}

			namespace = "http://precise.funpd.ac.be/AuiDeployer";
			writeStartElement(null, namespace, "deploymentVersion", xmlWriter);

			if (localDeploymentVersion == null) {
				// write the nil attribute

				throw new org.apache.axis2.databinding.ADBException(
						"deploymentVersion cannot be null!!");

			} else {

				xmlWriter.writeCharacters(localDeploymentVersion);

			}

			xmlWriter.writeEndElement();

			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(
				java.lang.String namespace) {
			if (namespace.equals("http://precise.funpd.ac.be/AuiDeployer")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil
					.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix,
				java.lang.String namespace, java.lang.String localPart,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix,
				java.lang.String namespace, java.lang.String attName,
				java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace,
				java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace,
				java.lang.String attName, javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter
					.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix
							+ ":"
							+ org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter
							.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qname));
				}

			} else {
				xmlWriter
						.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite
									.append(prefix)
									.append(":")
									.append(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToString(qnames[i]));
						} else {
							stringToWrite
									.append(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToString(qnames[i]));
						}
					} else {
						stringToWrite
								.append(org.apache.axis2.databinding.utils.ConverterUtil
										.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(
				javax.xml.stream.XMLStreamWriter xmlWriter,
				java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				javax.xml.namespace.NamespaceContext nsContext = xmlWriter
						.getNamespaceContext();
				while (true) {
					java.lang.String uri = nsContext.getNamespaceURI(prefix);
					if (uri == null || uri.length() == 0) {
						break;
					}
					prefix = org.apache.axis2.databinding.utils.BeanUtil
							.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(
				javax.xml.namespace.QName qName)
				throws org.apache.axis2.databinding.ADBException {

			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			elementList.add(new javax.xml.namespace.QName(
					"http://precise.funpd.ac.be/AuiDeployer",
					"deploymentVersion"));

			if (localDeploymentVersion != null) {
				elementList
						.add(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localDeploymentVersion));
			} else {
				throw new org.apache.axis2.databinding.ADBException(
						"deploymentVersion cannot be null!!");
			}

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(
					qName, elementList.toArray(), attribList.toArray());

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static DeployProcessResponse parse(
					javax.xml.stream.XMLStreamReader reader)
					throws java.lang.Exception {
				DeployProcessResponse object = new DeployProcessResponse();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader
							.getAttributeValue(
									"http://www.w3.org/2001/XMLSchema-instance",
									"type") != null) {
						java.lang.String fullTypeName = reader
								.getAttributeValue(
										"http://www.w3.org/2001/XMLSchema-instance",
										"type");
						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;
							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0,
										fullTypeName.indexOf(":"));
							}
							nsPrefix = nsPrefix == null ? "" : nsPrefix;

							java.lang.String type = fullTypeName
									.substring(fullTypeName.indexOf(":") + 1);

							if (!"deployProcessResponse".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader
										.getNamespaceContext().getNamespaceURI(
												nsPrefix);
								return (DeployProcessResponse) ExtensionMapper
										.getTypeObject(nsUri, type, reader);
							}

						}

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName(
									"http://precise.funpd.ac.be/AuiDeployer",
									"deploymentVersion").equals(reader
									.getName())) {

						java.lang.String content = reader.getElementText();

						object.setDeploymentVersion(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement " + reader.getName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement())
						// A start element we are not expecting indicates a
						// trailing invalid property
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement " + reader.getName());

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	private org.apache.axiom.om.OMElement toOM(
			ProcessDeployerServiceStub.DeployAui param, boolean optimizeContent)
			throws org.apache.axis2.AxisFault {

		try {
			return param.getOMElement(
					ProcessDeployerServiceStub.DeployAui.MY_QNAME,
					org.apache.axiom.om.OMAbstractFactory.getOMFactory());
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}

	}

	private org.apache.axiom.om.OMElement toOM(
			ProcessDeployerServiceStub.DeployAuiResponse param,
			boolean optimizeContent) throws org.apache.axis2.AxisFault {

		try {
			return param.getOMElement(
					ProcessDeployerServiceStub.DeployAuiResponse.MY_QNAME,
					org.apache.axiom.om.OMAbstractFactory.getOMFactory());
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}

	}

	private org.apache.axiom.om.OMElement toOM(
			ProcessDeployerServiceStub.DeployProcess param,
			boolean optimizeContent) throws org.apache.axis2.AxisFault {

		try {
			return param.getOMElement(
					ProcessDeployerServiceStub.DeployProcess.MY_QNAME,
					org.apache.axiom.om.OMAbstractFactory.getOMFactory());
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}

	}

	private org.apache.axiom.om.OMElement toOM(
			ProcessDeployerServiceStub.DeployProcessResponse param,
			boolean optimizeContent) throws org.apache.axis2.AxisFault {

		try {
			return param.getOMElement(
					ProcessDeployerServiceStub.DeployProcessResponse.MY_QNAME,
					org.apache.axiom.om.OMAbstractFactory.getOMFactory());
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}

	}

	private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
			org.apache.axiom.soap.SOAPFactory factory,
			ProcessDeployerServiceStub.DeployAui param,
			boolean optimizeContent, javax.xml.namespace.QName methodQName)
			throws org.apache.axis2.AxisFault {

		try {

			org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory
					.getDefaultEnvelope();
			emptyEnvelope.getBody().addChild(
					param.getOMElement(
							ProcessDeployerServiceStub.DeployAui.MY_QNAME,
							factory));
			return emptyEnvelope;
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}

	}

	/* methods to provide back word compatibility */

	private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
			org.apache.axiom.soap.SOAPFactory factory,
			ProcessDeployerServiceStub.DeployProcess param,
			boolean optimizeContent, javax.xml.namespace.QName methodQName)
			throws org.apache.axis2.AxisFault {

		try {

			org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory
					.getDefaultEnvelope();
			emptyEnvelope.getBody().addChild(
					param.getOMElement(
							ProcessDeployerServiceStub.DeployProcess.MY_QNAME,
							factory));
			return emptyEnvelope;
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}

	}

	/* methods to provide back word compatibility */

	/**
	 * get the default envelope
	 */
	private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
			org.apache.axiom.soap.SOAPFactory factory) {
		return factory.getDefaultEnvelope();
	}

	private java.lang.Object fromOM(org.apache.axiom.om.OMElement param,
			java.lang.Class type, java.util.Map extraNamespaces)
			throws org.apache.axis2.AxisFault {

		try {

			if (ProcessDeployerServiceStub.DeployAui.class.equals(type)) {

				return ProcessDeployerServiceStub.DeployAui.Factory.parse(param
						.getXMLStreamReaderWithoutCaching());

			}

			if (ProcessDeployerServiceStub.DeployAuiResponse.class.equals(type)) {

				return ProcessDeployerServiceStub.DeployAuiResponse.Factory
						.parse(param.getXMLStreamReaderWithoutCaching());

			}

			if (ProcessDeployerServiceStub.DeployProcess.class.equals(type)) {

				return ProcessDeployerServiceStub.DeployProcess.Factory
						.parse(param.getXMLStreamReaderWithoutCaching());

			}

			if (ProcessDeployerServiceStub.DeployProcessResponse.class
					.equals(type)) {

				return ProcessDeployerServiceStub.DeployProcessResponse.Factory
						.parse(param.getXMLStreamReaderWithoutCaching());

			}

		} catch (java.lang.Exception e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}
		return null;
	}

}
