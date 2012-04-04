/**
 * UIClientStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1  Built on : Aug 31, 2011 (12:22:40 CEST)
 */
package be.ac.fundp.uimanager.client.soap;

/*
 *  UIClientStub java implementation
 */

public class UIClientStub extends org.apache.axis2.client.Stub {
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
		_service = new org.apache.axis2.description.AxisService("UIClient"
				+ getUniqueSuffix());
		addAnonymousOperations();

		// creating the operations
		org.apache.axis2.description.AxisOperation __operation;

		_operations = new org.apache.axis2.description.AxisOperation[2];

		__operation = new org.apache.axis2.description.OutOnlyAxisOperation();

		__operation.setName(new javax.xml.namespace.QName(
				"http://webApp.fundp.ac.be", "requireAssyncInteraction"));
		_service.addOperation(__operation);

		_operations[0] = __operation;

		__operation = new org.apache.axis2.description.OutInAxisOperation();

		__operation.setName(new javax.xml.namespace.QName(
				"http://webApp.fundp.ac.be", "requireSyncInteraction"));
		_service.addOperation(__operation);

		_operations[1] = __operation;

	}

	// populates the faults
	private void populateFaults() {

	}

	/**
	 * Constructor that takes in a configContext
	 */

	public UIClientStub(
			org.apache.axis2.context.ConfigurationContext configurationContext,
			java.lang.String targetEndpoint) throws org.apache.axis2.AxisFault {
		this(configurationContext, targetEndpoint, false);
	}

	/**
	 * Constructor that takes in a configContext and useseperate listner
	 */
	public UIClientStub(
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
	public UIClientStub(
			org.apache.axis2.context.ConfigurationContext configurationContext)
			throws org.apache.axis2.AxisFault {

		this(configurationContext,
				"http://localhost:8090/BrowserAppClient/services/UI-Client/");

	}

	/**
	 * Default Constructor
	 */
	public UIClientStub() throws org.apache.axis2.AxisFault {

		this("http://localhost:8090/BrowserAppClient/services/UI-Client/");

	}

	/**
	 * Constructor taking the target endpoint
	 */
	public UIClientStub(java.lang.String targetEndpoint)
			throws org.apache.axis2.AxisFault {
		this(null, targetEndpoint);
	}

	/**
	 * Auto generated method signature
	 * 
	 */
	public void requireAssyncInteraction(
			be.ac.fundp.uimanager.client.soap.UIClientStub.RequireAssyncInteraction requireAssyncInteraction0

	) throws java.rmi.RemoteException

	{
		org.apache.axis2.context.MessageContext _messageContext = null;

		org.apache.axis2.client.OperationClient _operationClient = _serviceClient
				.createClient(_operations[0].getName());
		_operationClient.getOptions().setAction(
				"http://webApp.fundp.ac.be/requireAssyncInteraction");
		_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

		addPropertyToOperationClient(
				_operationClient,
				org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
				"&");

		org.apache.axiom.soap.SOAPEnvelope env = null;
		_messageContext = new org.apache.axis2.context.MessageContext();

		// Style is Doc.

		env = toEnvelope(
				getFactory(_operationClient.getOptions().getSoapVersionURI()),
				requireAssyncInteraction0,
				optimizeContent(new javax.xml.namespace.QName(
						"http://webApp.fundp.ac.be", "requireAssyncInteraction")),
				new javax.xml.namespace.QName("http://webApp.fundp.ac.be",
						"requireAssyncInteraction"));

		// adding SOAP soap_headers
		_serviceClient.addHeadersToEnvelope(env);
		// create message context with that soap envelope

		_messageContext.setEnvelope(env);

		// add the message contxt to the operation client
		_operationClient.addMessageContext(_messageContext);

		_operationClient.execute(true);

		if (_messageContext.getTransportOut() != null) {
			_messageContext.getTransportOut().getSender()
					.cleanup(_messageContext);
		}

		return;
	}

	/**
	 * Auto generated method signature
	 * 
	 * @see be.ac.fundp.uimanager.client.soap.UIClient#requireSyncInteraction
	 * @param requireSyncInteraction1
	 */

	public be.ac.fundp.uimanager.client.soap.UIClientStub.RequireSyncInteractionResponse requireSyncInteraction(

			be.ac.fundp.uimanager.client.soap.UIClientStub.RequireSyncInteraction requireSyncInteraction1)

	throws java.rmi.RemoteException

	{
		org.apache.axis2.context.MessageContext _messageContext = null;
		try {
			org.apache.axis2.client.OperationClient _operationClient = _serviceClient
					.createClient(_operations[1].getName());
			_operationClient.getOptions().setAction(
					"http://webApp.fundp.ac.be/NewOperation");
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
					.getSoapVersionURI()), requireSyncInteraction1,
					optimizeContent(new javax.xml.namespace.QName(
							"http://webApp.fundp.ac.be",
							"requireSyncInteraction")),
					new javax.xml.namespace.QName("http://webApp.fundp.ac.be",
							"requireSyncInteraction"));

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

			java.lang.Object object = fromOM(
					_returnEnv.getBody().getFirstElement(),
					be.ac.fundp.uimanager.client.soap.UIClientStub.RequireSyncInteractionResponse.class,
					getEnvelopeNamespaces(_returnEnv));

			return (be.ac.fundp.uimanager.client.soap.UIClientStub.RequireSyncInteractionResponse) object;

		} catch (org.apache.axis2.AxisFault f) {

			org.apache.axiom.om.OMElement faultElt = f.getDetail();
			if (faultElt != null) {
				if (faultExceptionNameMap
						.containsKey(new org.apache.axis2.client.FaultMapKey(
								faultElt.getQName(), "requireSyncInteraction"))) {
					// make the fault by reflection
					try {
						java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap
								.get(new org.apache.axis2.client.FaultMapKey(
										faultElt.getQName(),
										"requireSyncInteraction"));
						java.lang.Class exceptionClass = java.lang.Class
								.forName(exceptionClassName);
						java.lang.Exception ex = (java.lang.Exception) exceptionClass
								.newInstance();
						// message class
						java.lang.String messageClassName = (java.lang.String) faultMessageMap
								.get(new org.apache.axis2.client.FaultMapKey(
										faultElt.getQName(),
										"requireSyncInteraction"));
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
	 * @see be.ac.fundp.uimanager.client.soap.UIClient#startrequireSyncInteraction
	 * @param requireSyncInteraction1
	 */
	public void startrequireSyncInteraction(

			be.ac.fundp.uimanager.client.soap.UIClientStub.RequireSyncInteraction requireSyncInteraction1,

			final be.ac.fundp.uimanager.client.soap.UIClientCallbackHandler callback)

	throws java.rmi.RemoteException {

		org.apache.axis2.client.OperationClient _operationClient = _serviceClient
				.createClient(_operations[1].getName());
		_operationClient.getOptions().setAction(
				"http://webApp.fundp.ac.be/NewOperation");
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
				requireSyncInteraction1,
				optimizeContent(new javax.xml.namespace.QName(
						"http://webApp.fundp.ac.be", "requireSyncInteraction")),
				new javax.xml.namespace.QName("http://webApp.fundp.ac.be",
						"requireSyncInteraction"));

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
									be.ac.fundp.uimanager.client.soap.UIClientStub.RequireSyncInteractionResponse.class,
									getEnvelopeNamespaces(resultEnv));
							callback.receiveResultrequireSyncInteraction((be.ac.fundp.uimanager.client.soap.UIClientStub.RequireSyncInteractionResponse) object);

						} catch (org.apache.axis2.AxisFault e) {
							callback.receiveErrorrequireSyncInteraction(e);
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
												"requireSyncInteraction"))) {
									// make the fault by reflection
									try {
										java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap
												.get(new org.apache.axis2.client.FaultMapKey(
														faultElt.getQName(),
														"requireSyncInteraction"));
										java.lang.Class exceptionClass = java.lang.Class
												.forName(exceptionClassName);
										java.lang.Exception ex = (java.lang.Exception) exceptionClass
												.newInstance();
										// message class
										java.lang.String messageClassName = (java.lang.String) faultMessageMap
												.get(new org.apache.axis2.client.FaultMapKey(
														faultElt.getQName(),
														"requireSyncInteraction"));
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

										callback.receiveErrorrequireSyncInteraction(new java.rmi.RemoteException(
												ex.getMessage(), ex));
									} catch (java.lang.ClassCastException e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrorrequireSyncInteraction(f);
									} catch (java.lang.ClassNotFoundException e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrorrequireSyncInteraction(f);
									} catch (java.lang.NoSuchMethodException e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrorrequireSyncInteraction(f);
									} catch (java.lang.reflect.InvocationTargetException e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrorrequireSyncInteraction(f);
									} catch (java.lang.IllegalAccessException e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrorrequireSyncInteraction(f);
									} catch (java.lang.InstantiationException e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrorrequireSyncInteraction(f);
									} catch (org.apache.axis2.AxisFault e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrorrequireSyncInteraction(f);
									}
								} else {
									callback.receiveErrorrequireSyncInteraction(f);
								}
							} else {
								callback.receiveErrorrequireSyncInteraction(f);
							}
						} else {
							callback.receiveErrorrequireSyncInteraction(error);
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
							callback.receiveErrorrequireSyncInteraction(axisFault);
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

	// http://localhost:8090/BrowserAppClient/services/UI-Client/
	public static class RequireAssyncInteractionResponse implements
			org.apache.axis2.databinding.ADBBean {

		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
				"http://webApp.fundp.ac.be",
				"requireAssyncInteractionResponse", "ns1");

		/**
		 * field for Out
		 */

		protected java.lang.String localOut;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getOut() {
			return localOut;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Out
		 */
		public void setOut(java.lang.String param) {

			this.localOut = param;

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
						"http://webApp.fundp.ac.be");
				if ((namespacePrefix != null)
						&& (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi",
							"http://www.w3.org/2001/XMLSchema-instance",
							"type", namespacePrefix
									+ ":requireAssyncInteractionResponse",
							xmlWriter);
				} else {
					writeAttribute("xsi",
							"http://www.w3.org/2001/XMLSchema-instance",
							"type", "requireAssyncInteractionResponse",
							xmlWriter);
				}

			}

			namespace = "";
			writeStartElement(null, namespace, "out", xmlWriter);

			if (localOut == null) {
				// write the nil attribute

				throw new org.apache.axis2.databinding.ADBException(
						"out cannot be null!!");

			} else {

				xmlWriter.writeCharacters(localOut);

			}

			xmlWriter.writeEndElement();

			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(
				java.lang.String namespace) {
			if (namespace.equals("http://webApp.fundp.ac.be")) {
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

			elementList.add(new javax.xml.namespace.QName("", "out"));

			if (localOut != null) {
				elementList
						.add(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localOut));
			} else {
				throw new org.apache.axis2.databinding.ADBException(
						"out cannot be null!!");
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
			public static RequireAssyncInteractionResponse parse(
					javax.xml.stream.XMLStreamReader reader)
					throws java.lang.Exception {
				RequireAssyncInteractionResponse object = new RequireAssyncInteractionResponse();

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

							if (!"requireAssyncInteractionResponse"
									.equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader
										.getNamespaceContext().getNamespaceURI(
												nsPrefix);
								return (RequireAssyncInteractionResponse) ExtensionMapper
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
							&& new javax.xml.namespace.QName("", "out")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setOut(org.apache.axis2.databinding.utils.ConverterUtil
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

			if ("http://webApp.fundp.ac.be".equals(namespaceURI)
					&& "DataItemType".equals(typeName)) {

				return DataItemType.Factory.parse(reader);

			}

			throw new org.apache.axis2.databinding.ADBException(
					"Unsupported type " + namespaceURI + " " + typeName);
		}

	}

	public static class DataItemType implements
			org.apache.axis2.databinding.ADBBean {
		/*
		 * This type was generated from the piece of schema that had name =
		 * DataItemType Namespace URI = http://webApp.fundp.ac.be Namespace
		 * Prefix = ns1
		 */

		/**
		 * field for DataItemId
		 */

		protected java.lang.String localDataItemId;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getDataItemId() {
			return localDataItemId;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            DataItemId
		 */
		public void setDataItemId(java.lang.String param) {

			this.localDataItemId = param;

		}

		/**
		 * field for TypeName
		 */

		protected java.lang.String localTypeName;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getTypeName() {
			return localTypeName;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            TypeName
		 */
		public void setTypeName(java.lang.String param) {

			this.localTypeName = param;

		}

		/**
		 * field for Data
		 */

		protected java.lang.Object localData;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.Object
		 */
		public java.lang.Object getData() {
			return localData;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Data
		 */
		public void setData(java.lang.Object param) {

			this.localData = param;

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
						"http://webApp.fundp.ac.be");
				if ((namespacePrefix != null)
						&& (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi",
							"http://www.w3.org/2001/XMLSchema-instance",
							"type", namespacePrefix + ":DataItemType",
							xmlWriter);
				} else {
					writeAttribute("xsi",
							"http://www.w3.org/2001/XMLSchema-instance",
							"type", "DataItemType", xmlWriter);
				}

			}

			namespace = "";
			writeStartElement(null, namespace, "dataItemId", xmlWriter);

			if (localDataItemId == null) {
				// write the nil attribute

				throw new org.apache.axis2.databinding.ADBException(
						"dataItemId cannot be null!!");

			} else {

				xmlWriter.writeCharacters(localDataItemId);

			}

			xmlWriter.writeEndElement();

			namespace = "";
			writeStartElement(null, namespace, "typeName", xmlWriter);

			if (localTypeName == null) {
				// write the nil attribute

				throw new org.apache.axis2.databinding.ADBException(
						"typeName cannot be null!!");

			} else {

				xmlWriter.writeCharacters(localTypeName);

			}

			xmlWriter.writeEndElement();

			if (localData != null) {
				if (localData instanceof org.apache.axis2.databinding.ADBBean) {
					((org.apache.axis2.databinding.ADBBean) localData)
							.serialize(
									new javax.xml.namespace.QName("", "data"),
									xmlWriter, true);
				} else {
					writeStartElement(null, "", "data", xmlWriter);
					org.apache.axis2.databinding.utils.ConverterUtil
							.serializeAnyType(localData, xmlWriter);
					xmlWriter.writeEndElement();
				}
			} else {

				throw new org.apache.axis2.databinding.ADBException(
						"data cannot be null!!");

			}

			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(
				java.lang.String namespace) {
			if (namespace.equals("http://webApp.fundp.ac.be")) {
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

			elementList.add(new javax.xml.namespace.QName("", "dataItemId"));

			if (localDataItemId != null) {
				elementList
						.add(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localDataItemId));
			} else {
				throw new org.apache.axis2.databinding.ADBException(
						"dataItemId cannot be null!!");
			}

			elementList.add(new javax.xml.namespace.QName("", "typeName"));

			if (localTypeName != null) {
				elementList
						.add(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localTypeName));
			} else {
				throw new org.apache.axis2.databinding.ADBException(
						"typeName cannot be null!!");
			}

			elementList.add(new javax.xml.namespace.QName("", "data"));

			if (localData == null) {
				throw new org.apache.axis2.databinding.ADBException(
						"data cannot be null!!");
			}
			elementList.add(localData);

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
			public static DataItemType parse(
					javax.xml.stream.XMLStreamReader reader)
					throws java.lang.Exception {
				DataItemType object = new DataItemType();

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

							if (!"DataItemType".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader
										.getNamespaceContext().getNamespaceURI(
												nsPrefix);
								return (DataItemType) ExtensionMapper
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
							&& new javax.xml.namespace.QName("", "dataItemId")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setDataItemId(org.apache.axis2.databinding.utils.ConverterUtil
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
							&& new javax.xml.namespace.QName("", "typeName")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setTypeName(org.apache.axis2.databinding.utils.ConverterUtil
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
							&& new javax.xml.namespace.QName("", "data")
									.equals(reader.getName())) {

						object.setData(org.apache.axis2.databinding.utils.ConverterUtil
								.getAnyTypeObject(reader, ExtensionMapper.class));

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

	public static class RequireAssyncInteraction implements
			org.apache.axis2.databinding.ADBBean {

		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
				"http://webApp.fundp.ac.be", "requireAssyncInteraction", "ns1");

		/**
		 * field for CuiId
		 */

		protected java.lang.String localCuiId;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getCuiId() {
			return localCuiId;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            CuiId
		 */
		public void setCuiId(java.lang.String param) {

			this.localCuiId = param;

		}

		/**
		 * field for InputData This was an Array!
		 */

		protected DataItemType[] localInputData;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localInputDataTracker = false;

		public boolean isInputDataSpecified() {
			return localInputDataTracker;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return DataItemType[]
		 */
		public DataItemType[] getInputData() {
			return localInputData;
		}

		/**
		 * validate the array for InputData
		 */
		protected void validateInputData(DataItemType[] param) {

		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            InputData
		 */
		public void setInputData(DataItemType[] param) {

			validateInputData(param);

			localInputDataTracker = param != null;

			this.localInputData = param;
		}

		/**
		 * Auto generated add method for the array for convenience
		 * 
		 * @param param
		 *            DataItemType
		 */
		public void addInputData(DataItemType param) {
			if (localInputData == null) {
				localInputData = new DataItemType[] {};
			}

			// update the setting tracker
			localInputDataTracker = true;

			java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil
					.toList(localInputData);
			list.add(param);
			this.localInputData = (DataItemType[]) list
					.toArray(new DataItemType[list.size()]);

		}

		/**
		 * field for Role
		 */

		protected java.lang.String localRole;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localRoleTracker = false;

		public boolean isRoleSpecified() {
			return localRoleTracker;
		}

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
			localRoleTracker = param != null;

			this.localRole = param;

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
						"http://webApp.fundp.ac.be");
				if ((namespacePrefix != null)
						&& (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi",
							"http://www.w3.org/2001/XMLSchema-instance",
							"type", namespacePrefix
									+ ":requireAssyncInteraction", xmlWriter);
				} else {
					writeAttribute("xsi",
							"http://www.w3.org/2001/XMLSchema-instance",
							"type", "requireAssyncInteraction", xmlWriter);
				}

			}

			namespace = "";
			writeStartElement(null, namespace, "cuiId", xmlWriter);

			if (localCuiId == null) {
				// write the nil attribute

				throw new org.apache.axis2.databinding.ADBException(
						"cuiId cannot be null!!");

			} else {

				xmlWriter.writeCharacters(localCuiId);

			}

			xmlWriter.writeEndElement();
			if (localInputDataTracker) {
				if (localInputData != null) {
					for (int i = 0; i < localInputData.length; i++) {
						if (localInputData[i] != null) {
							localInputData[i].serialize(
									new javax.xml.namespace.QName("",
											"inputData"), xmlWriter);
						} else {

							// we don't have to do any thing since minOccures is
							// zero

						}

					}
				} else {

					throw new org.apache.axis2.databinding.ADBException(
							"inputData cannot be null!!");

				}
			}
			if (localRoleTracker) {
				namespace = "";
				writeStartElement(null, namespace, "role", xmlWriter);

				if (localRole == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"role cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localRole);

				}

				xmlWriter.writeEndElement();
			}
			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(
				java.lang.String namespace) {
			if (namespace.equals("http://webApp.fundp.ac.be")) {
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

			elementList.add(new javax.xml.namespace.QName("", "cuiId"));

			if (localCuiId != null) {
				elementList
						.add(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localCuiId));
			} else {
				throw new org.apache.axis2.databinding.ADBException(
						"cuiId cannot be null!!");
			}
			if (localInputDataTracker) {
				if (localInputData != null) {
					for (int i = 0; i < localInputData.length; i++) {

						if (localInputData[i] != null) {
							elementList.add(new javax.xml.namespace.QName("",
									"inputData"));
							elementList.add(localInputData[i]);
						} else {

							// nothing to do

						}

					}
				} else {

					throw new org.apache.axis2.databinding.ADBException(
							"inputData cannot be null!!");

				}

			}
			if (localRoleTracker) {
				elementList.add(new javax.xml.namespace.QName("", "role"));

				if (localRole != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localRole));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"role cannot be null!!");
				}
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
			public static RequireAssyncInteraction parse(
					javax.xml.stream.XMLStreamReader reader)
					throws java.lang.Exception {
				RequireAssyncInteraction object = new RequireAssyncInteraction();

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

							if (!"requireAssyncInteraction".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader
										.getNamespaceContext().getNamespaceURI(
												nsPrefix);
								return (RequireAssyncInteraction) ExtensionMapper
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
							&& new javax.xml.namespace.QName("", "cuiId")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setCuiId(org.apache.axis2.databinding.utils.ConverterUtil
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
							&& new javax.xml.namespace.QName("", "inputData")
									.equals(reader.getName())) {

						// Process the array and step past its final element's
						// end.
						list2.add(DataItemType.Factory.parse(reader));

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
								if (new javax.xml.namespace.QName("",
										"inputData").equals(reader.getName())) {
									list2.add(DataItemType.Factory
											.parse(reader));

								} else {
									loopDone2 = true;
								}
							}
						}
						// call the converter utility to convert and set the
						// array

						object.setInputData((DataItemType[]) org.apache.axis2.databinding.utils.ConverterUtil
								.convertToArray(DataItemType.class, list2));

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "role")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setRole(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

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

	public static class RequireSyncInteractionResponse implements
			org.apache.axis2.databinding.ADBBean {

		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
				"http://webApp.fundp.ac.be", "requireSyncInteractionResponse",
				"ns1");

		/**
		 * field for OutData This was an Array!
		 */

		protected DataItemType[] localOutData;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localOutDataTracker = false;

		public boolean isOutDataSpecified() {
			return localOutDataTracker;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return DataItemType[]
		 */
		public DataItemType[] getOutData() {
			return localOutData;
		}

		/**
		 * validate the array for OutData
		 */
		protected void validateOutData(DataItemType[] param) {

		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            OutData
		 */
		public void setOutData(DataItemType[] param) {

			validateOutData(param);

			localOutDataTracker = param != null;

			this.localOutData = param;
		}

		/**
		 * Auto generated add method for the array for convenience
		 * 
		 * @param param
		 *            DataItemType
		 */
		public void addOutData(DataItemType param) {
			if (localOutData == null) {
				localOutData = new DataItemType[] {};
			}

			// update the setting tracker
			localOutDataTracker = true;

			java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil
					.toList(localOutData);
			list.add(param);
			this.localOutData = (DataItemType[]) list
					.toArray(new DataItemType[list.size()]);

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
						"http://webApp.fundp.ac.be");
				if ((namespacePrefix != null)
						&& (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi",
							"http://www.w3.org/2001/XMLSchema-instance",
							"type", namespacePrefix
									+ ":requireSyncInteractionResponse",
							xmlWriter);
				} else {
					writeAttribute("xsi",
							"http://www.w3.org/2001/XMLSchema-instance",
							"type", "requireSyncInteractionResponse", xmlWriter);
				}

			}
			if (localOutDataTracker) {
				if (localOutData != null) {
					for (int i = 0; i < localOutData.length; i++) {
						if (localOutData[i] != null) {
							localOutData[i]
									.serialize(new javax.xml.namespace.QName(
											"", "outData"), xmlWriter);
						} else {

							// we don't have to do any thing since minOccures is
							// zero

						}

					}
				} else {

					throw new org.apache.axis2.databinding.ADBException(
							"outData cannot be null!!");

				}
			}
			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(
				java.lang.String namespace) {
			if (namespace.equals("http://webApp.fundp.ac.be")) {
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

			if (localOutDataTracker) {
				if (localOutData != null) {
					for (int i = 0; i < localOutData.length; i++) {

						if (localOutData[i] != null) {
							elementList.add(new javax.xml.namespace.QName("",
									"outData"));
							elementList.add(localOutData[i]);
						} else {

							// nothing to do

						}

					}
				} else {

					throw new org.apache.axis2.databinding.ADBException(
							"outData cannot be null!!");

				}

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
			public static RequireSyncInteractionResponse parse(
					javax.xml.stream.XMLStreamReader reader)
					throws java.lang.Exception {
				RequireSyncInteractionResponse object = new RequireSyncInteractionResponse();

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

							if (!"requireSyncInteractionResponse".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader
										.getNamespaceContext().getNamespaceURI(
												nsPrefix);
								return (RequireSyncInteractionResponse) ExtensionMapper
										.getTypeObject(nsUri, type, reader);
							}

						}

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					java.util.ArrayList list1 = new java.util.ArrayList();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "outData")
									.equals(reader.getName())) {

						// Process the array and step past its final element's
						// end.
						list1.add(DataItemType.Factory.parse(reader));

						// loop until we find a start element that is not part
						// of this array
						boolean loopDone1 = false;
						while (!loopDone1) {
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
								loopDone1 = true;
							} else {
								if (new javax.xml.namespace.QName("", "outData")
										.equals(reader.getName())) {
									list1.add(DataItemType.Factory
											.parse(reader));

								} else {
									loopDone1 = true;
								}
							}
						}
						// call the converter utility to convert and set the
						// array

						object.setOutData((DataItemType[]) org.apache.axis2.databinding.utils.ConverterUtil
								.convertToArray(DataItemType.class, list1));

					} // End of if for expected property start element

					else {

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

	public static class RequireSyncInteraction implements
			org.apache.axis2.databinding.ADBBean {

		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
				"http://webApp.fundp.ac.be", "requireSyncInteraction", "ns1");

		/**
		 * field for CuiId
		 */

		protected java.lang.String localCuiId;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getCuiId() {
			return localCuiId;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            CuiId
		 */
		public void setCuiId(java.lang.String param) {

			this.localCuiId = param;

		}

		/**
		 * field for InputData This was an Array!
		 */

		protected DataItemType[] localInputData;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localInputDataTracker = false;

		public boolean isInputDataSpecified() {
			return localInputDataTracker;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return DataItemType[]
		 */
		public DataItemType[] getInputData() {
			return localInputData;
		}

		/**
		 * validate the array for InputData
		 */
		protected void validateInputData(DataItemType[] param) {

		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            InputData
		 */
		public void setInputData(DataItemType[] param) {

			validateInputData(param);

			localInputDataTracker = param != null;

			this.localInputData = param;
		}

		/**
		 * Auto generated add method for the array for convenience
		 * 
		 * @param param
		 *            DataItemType
		 */
		public void addInputData(DataItemType param) {
			if (localInputData == null) {
				localInputData = new DataItemType[] {};
			}

			// update the setting tracker
			localInputDataTracker = true;

			java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil
					.toList(localInputData);
			list.add(param);
			this.localInputData = (DataItemType[]) list
					.toArray(new DataItemType[list.size()]);

		}

		/**
		 * field for Role
		 */

		protected java.lang.String localRole;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localRoleTracker = false;

		public boolean isRoleSpecified() {
			return localRoleTracker;
		}

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
			localRoleTracker = param != null;

			this.localRole = param;

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
						"http://webApp.fundp.ac.be");
				if ((namespacePrefix != null)
						&& (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi",
							"http://www.w3.org/2001/XMLSchema-instance",
							"type",
							namespacePrefix + ":requireSyncInteraction",
							xmlWriter);
				} else {
					writeAttribute("xsi",
							"http://www.w3.org/2001/XMLSchema-instance",
							"type", "requireSyncInteraction", xmlWriter);
				}

			}

			namespace = "";
			writeStartElement(null, namespace, "cuiId", xmlWriter);

			if (localCuiId == null) {
				// write the nil attribute

				throw new org.apache.axis2.databinding.ADBException(
						"cuiId cannot be null!!");

			} else {

				xmlWriter.writeCharacters(localCuiId);

			}

			xmlWriter.writeEndElement();
			if (localInputDataTracker) {
				if (localInputData != null) {
					for (int i = 0; i < localInputData.length; i++) {
						if (localInputData[i] != null) {
							localInputData[i].serialize(
									new javax.xml.namespace.QName("",
											"inputData"), xmlWriter);
						} else {

							// we don't have to do any thing since minOccures is
							// zero

						}

					}
				} else {

					throw new org.apache.axis2.databinding.ADBException(
							"inputData cannot be null!!");

				}
			}
			if (localRoleTracker) {
				namespace = "";
				writeStartElement(null, namespace, "role", xmlWriter);

				if (localRole == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"role cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localRole);

				}

				xmlWriter.writeEndElement();
			}
			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(
				java.lang.String namespace) {
			if (namespace.equals("http://webApp.fundp.ac.be")) {
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

			elementList.add(new javax.xml.namespace.QName("", "cuiId"));

			if (localCuiId != null) {
				elementList
						.add(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localCuiId));
			} else {
				throw new org.apache.axis2.databinding.ADBException(
						"cuiId cannot be null!!");
			}
			if (localInputDataTracker) {
				if (localInputData != null) {
					for (int i = 0; i < localInputData.length; i++) {

						if (localInputData[i] != null) {
							elementList.add(new javax.xml.namespace.QName("",
									"inputData"));
							elementList.add(localInputData[i]);
						} else {

							// nothing to do

						}

					}
				} else {

					throw new org.apache.axis2.databinding.ADBException(
							"inputData cannot be null!!");

				}

			}
			if (localRoleTracker) {
				elementList.add(new javax.xml.namespace.QName("", "role"));

				if (localRole != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localRole));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"role cannot be null!!");
				}
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
			public static RequireSyncInteraction parse(
					javax.xml.stream.XMLStreamReader reader)
					throws java.lang.Exception {
				RequireSyncInteraction object = new RequireSyncInteraction();

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

							if (!"requireSyncInteraction".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader
										.getNamespaceContext().getNamespaceURI(
												nsPrefix);
								return (RequireSyncInteraction) ExtensionMapper
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
							&& new javax.xml.namespace.QName("", "cuiId")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setCuiId(org.apache.axis2.databinding.utils.ConverterUtil
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
							&& new javax.xml.namespace.QName("", "inputData")
									.equals(reader.getName())) {

						// Process the array and step past its final element's
						// end.
						list2.add(DataItemType.Factory.parse(reader));

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
								if (new javax.xml.namespace.QName("",
										"inputData").equals(reader.getName())) {
									list2.add(DataItemType.Factory
											.parse(reader));

								} else {
									loopDone2 = true;
								}
							}
						}
						// call the converter utility to convert and set the
						// array

						object.setInputData((DataItemType[]) org.apache.axis2.databinding.utils.ConverterUtil
								.convertToArray(DataItemType.class, list2));

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "role")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setRole(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

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
			be.ac.fundp.uimanager.client.soap.UIClientStub.RequireAssyncInteraction param,
			boolean optimizeContent) throws org.apache.axis2.AxisFault {

		try {
			return param
					.getOMElement(
							be.ac.fundp.uimanager.client.soap.UIClientStub.RequireAssyncInteraction.MY_QNAME,
							org.apache.axiom.om.OMAbstractFactory
									.getOMFactory());
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}

	}

	private org.apache.axiom.om.OMElement toOM(
			be.ac.fundp.uimanager.client.soap.UIClientStub.RequireSyncInteraction param,
			boolean optimizeContent) throws org.apache.axis2.AxisFault {

		try {
			return param
					.getOMElement(
							be.ac.fundp.uimanager.client.soap.UIClientStub.RequireSyncInteraction.MY_QNAME,
							org.apache.axiom.om.OMAbstractFactory
									.getOMFactory());
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}

	}

	private org.apache.axiom.om.OMElement toOM(
			be.ac.fundp.uimanager.client.soap.UIClientStub.RequireSyncInteractionResponse param,
			boolean optimizeContent) throws org.apache.axis2.AxisFault {

		try {
			return param
					.getOMElement(
							be.ac.fundp.uimanager.client.soap.UIClientStub.RequireSyncInteractionResponse.MY_QNAME,
							org.apache.axiom.om.OMAbstractFactory
									.getOMFactory());
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}

	}

	private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
			org.apache.axiom.soap.SOAPFactory factory,
			be.ac.fundp.uimanager.client.soap.UIClientStub.RequireAssyncInteraction param,
			boolean optimizeContent, javax.xml.namespace.QName methodQName)
			throws org.apache.axis2.AxisFault {

		try {

			org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory
					.getDefaultEnvelope();
			emptyEnvelope
					.getBody()
					.addChild(
							param.getOMElement(
									be.ac.fundp.uimanager.client.soap.UIClientStub.RequireAssyncInteraction.MY_QNAME,
									factory));
			return emptyEnvelope;
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}

	}

	/* methods to provide back word compatibility */

	private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
			org.apache.axiom.soap.SOAPFactory factory,
			be.ac.fundp.uimanager.client.soap.UIClientStub.RequireSyncInteraction param,
			boolean optimizeContent, javax.xml.namespace.QName methodQName)
			throws org.apache.axis2.AxisFault {

		try {

			org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory
					.getDefaultEnvelope();
			emptyEnvelope
					.getBody()
					.addChild(
							param.getOMElement(
									be.ac.fundp.uimanager.client.soap.UIClientStub.RequireSyncInteraction.MY_QNAME,
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

			if (be.ac.fundp.uimanager.client.soap.UIClientStub.RequireAssyncInteraction.class
					.equals(type)) {

				return be.ac.fundp.uimanager.client.soap.UIClientStub.RequireAssyncInteraction.Factory
						.parse(param.getXMLStreamReaderWithoutCaching());

			}

			if (be.ac.fundp.uimanager.client.soap.UIClientStub.RequireSyncInteraction.class
					.equals(type)) {

				return be.ac.fundp.uimanager.client.soap.UIClientStub.RequireSyncInteraction.Factory
						.parse(param.getXMLStreamReaderWithoutCaching());

			}

			if (be.ac.fundp.uimanager.client.soap.UIClientStub.RequireSyncInteractionResponse.class
					.equals(type)) {

				return be.ac.fundp.uimanager.client.soap.UIClientStub.RequireSyncInteractionResponse.Factory
						.parse(param.getXMLStreamReaderWithoutCaching());

			}

		} catch (java.lang.Exception e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}
		return null;
	}

}
