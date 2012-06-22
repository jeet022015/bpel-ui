
/**
 * UiManagerMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1  Built on : Aug 31, 2011 (12:22:40 CEST)
 */
        package be.ac.fundp.uimanager.controller;

        /**
        *  UiManagerMessageReceiverInOut message receiver
        */

        public class UiManagerMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutMessageReceiver{


        public void invokeBusinessLogic(org.apache.axis2.context.MessageContext msgContext, org.apache.axis2.context.MessageContext newMsgContext)
        throws org.apache.axis2.AxisFault{

        try {

        // get the implementation class for the Web Service
        Object obj = getTheImplementationObject(msgContext);

        UiManagerSkeleton skel = (UiManagerSkeleton)obj;
        //Out Envelop
        org.apache.axiom.soap.SOAPEnvelope envelope = null;
        //Find the axisOperation that has been set by the Dispatch phase.
        org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext().getAxisOperation();
        if (op == null) {
        throw new org.apache.axis2.AxisFault("Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
        }

        java.lang.String methodName;
        if((op.getName() != null) && ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJavaIdentifier(op.getName().getLocalPart())) != null)){


        

            if("inputOperation".equals(methodName)){
                
                be.ac.fundp.uimanager.InputOperationResponse inputOperationResponse1 = null;
	                        be.ac.fundp.uimanager.InputOperation wrappedParam =
                                                             (be.ac.fundp.uimanager.InputOperation)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    be.ac.fundp.uimanager.InputOperation.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               inputOperationResponse1 =
                                                   
                                                   
                                                         skel.inputOperation(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), inputOperationResponse1, false, new javax.xml.namespace.QName("http://fundp.ac.be/UiManager/",
                                                    "inputOperation"));
                                    } else 

            if("selectionOperation".equals(methodName)){
                
                be.ac.fundp.uimanager.SelectionOperationResponse selectionOperationResponse3 = null;
	                        be.ac.fundp.uimanager.SelectionOperation wrappedParam =
                                                             (be.ac.fundp.uimanager.SelectionOperation)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    be.ac.fundp.uimanager.SelectionOperation.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               selectionOperationResponse3 =
                                                   
                                                   
                                                         skel.selectionOperation(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), selectionOperationResponse3, false, new javax.xml.namespace.QName("http://fundp.ac.be/UiManager/",
                                                    "selectionOperation"));
                                    } else 

            if("generateProcessId".equals(methodName)){
                
                be.ac.fundp.uimanager.GenerateProcessIdResponse generateProcessIdResponse5 = null;
	                        be.ac.fundp.uimanager.GenerateProcessId wrappedParam =
                                                             (be.ac.fundp.uimanager.GenerateProcessId)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    be.ac.fundp.uimanager.GenerateProcessId.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               generateProcessIdResponse5 =
                                                   
                                                   
                                                         skel.generateProcessId(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), generateProcessIdResponse5, false, new javax.xml.namespace.QName("http://fundp.ac.be/UiManager/",
                                                    "generateProcessId"));
                                    
            } else {
              throw new java.lang.RuntimeException("method not found");
            }
        

        newMsgContext.setEnvelope(envelope);
        }
        }
        catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
        }
        
        //
            private  org.apache.axiom.om.OMElement  toOM(be.ac.fundp.uimanager.InputOperation param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(be.ac.fundp.uimanager.InputOperation.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(be.ac.fundp.uimanager.InputOperationResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(be.ac.fundp.uimanager.InputOperationResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(be.ac.fundp.uimanager.SelectionOperation param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(be.ac.fundp.uimanager.SelectionOperation.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(be.ac.fundp.uimanager.SelectionOperationResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(be.ac.fundp.uimanager.SelectionOperationResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(be.ac.fundp.uimanager.OutputOperation param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(be.ac.fundp.uimanager.OutputOperation.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(be.ac.fundp.uimanager.GenerateProcessId param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(be.ac.fundp.uimanager.GenerateProcessId.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(be.ac.fundp.uimanager.GenerateProcessIdResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(be.ac.fundp.uimanager.GenerateProcessIdResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, be.ac.fundp.uimanager.InputOperationResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(be.ac.fundp.uimanager.InputOperationResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private be.ac.fundp.uimanager.InputOperationResponse wrapinputOperation(){
                                be.ac.fundp.uimanager.InputOperationResponse wrappedElement = new be.ac.fundp.uimanager.InputOperationResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, be.ac.fundp.uimanager.SelectionOperationResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(be.ac.fundp.uimanager.SelectionOperationResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private be.ac.fundp.uimanager.SelectionOperationResponse wrapselectionOperation(){
                                be.ac.fundp.uimanager.SelectionOperationResponse wrappedElement = new be.ac.fundp.uimanager.SelectionOperationResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, be.ac.fundp.uimanager.GenerateProcessIdResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(be.ac.fundp.uimanager.GenerateProcessIdResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private be.ac.fundp.uimanager.GenerateProcessIdResponse wrapgenerateProcessId(){
                                be.ac.fundp.uimanager.GenerateProcessIdResponse wrappedElement = new be.ac.fundp.uimanager.GenerateProcessIdResponse();
                                return wrappedElement;
                         }
                    


        /**
        *  get the default envelope
        */
        private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory){
        return factory.getDefaultEnvelope();
        }


        private  java.lang.Object fromOM(
        org.apache.axiom.om.OMElement param,
        java.lang.Class type,
        java.util.Map extraNamespaces) throws org.apache.axis2.AxisFault{

        try {
        
                if (be.ac.fundp.uimanager.InputOperation.class.equals(type)){
                
                           return be.ac.fundp.uimanager.InputOperation.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (be.ac.fundp.uimanager.InputOperationResponse.class.equals(type)){
                
                           return be.ac.fundp.uimanager.InputOperationResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (be.ac.fundp.uimanager.SelectionOperation.class.equals(type)){
                
                           return be.ac.fundp.uimanager.SelectionOperation.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (be.ac.fundp.uimanager.SelectionOperationResponse.class.equals(type)){
                
                           return be.ac.fundp.uimanager.SelectionOperationResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (be.ac.fundp.uimanager.OutputOperation.class.equals(type)){
                
                           return be.ac.fundp.uimanager.OutputOperation.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (be.ac.fundp.uimanager.GenerateProcessId.class.equals(type)){
                
                           return be.ac.fundp.uimanager.GenerateProcessId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (be.ac.fundp.uimanager.GenerateProcessIdResponse.class.equals(type)){
                
                           return be.ac.fundp.uimanager.GenerateProcessIdResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
        } catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
           return null;
        }



    

        /**
        *  A utility method that copies the namepaces from the SOAPEnvelope
        */
        private java.util.Map getEnvelopeNamespaces(org.apache.axiom.soap.SOAPEnvelope env){
        java.util.Map returnMap = new java.util.HashMap();
        java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
        while (namespaceIterator.hasNext()) {
        org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
        returnMap.put(ns.getPrefix(),ns.getNamespaceURI());
        }
        return returnMap;
        }

        private org.apache.axis2.AxisFault createAxisFault(java.lang.Exception e) {
        org.apache.axis2.AxisFault f;
        Throwable cause = e.getCause();
        if (cause != null) {
            f = new org.apache.axis2.AxisFault(e.getMessage(), cause);
        } else {
            f = new org.apache.axis2.AxisFault(e.getMessage());
        }

        return f;
    }

        }//end of class
    