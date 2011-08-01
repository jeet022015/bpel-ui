
/**
 * UI_BPELMediatorMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.4  Built on : Dec 19, 2010 (08:18:42 CET)
 */
        package org.example.www.ui_bpel_mediator;

        /**
        *  UI_BPELMediatorMessageReceiverInOut message receiver
        */

        public class UI_BPELMediatorMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutMessageReceiver{


        public void invokeBusinessLogic(org.apache.axis2.context.MessageContext msgContext, org.apache.axis2.context.MessageContext newMsgContext)
        throws org.apache.axis2.AxisFault{

        try {

        // get the implementation class for the Web Service
        Object obj = getTheImplementationObject(msgContext);

        UI_BPELMediatorSkeleton skel = (UI_BPELMediatorSkeleton)obj;
        //Out Envelop
        org.apache.axiom.soap.SOAPEnvelope envelope = null;
        //Find the axisOperation that has been set by the Dispatch phase.
        org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext().getAxisOperation();
        if (op == null) {
        throw new org.apache.axis2.AxisFault("Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
        }

        java.lang.String methodName;
        if((op.getName() != null) && ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJavaIdentifier(op.getName().getLocalPart())) != null)){

        

            if("dataSelectionUI".equals(methodName)){
                
                org.example.www.ui_bpel_mediator.DataSelectionUIResponse dataSelectionUIResponse1 = null;
	                        org.example.www.ui_bpel_mediator.DataSelectionUI wrappedParam =
                                                             (org.example.www.ui_bpel_mediator.DataSelectionUI)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    org.example.www.ui_bpel_mediator.DataSelectionUI.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               dataSelectionUIResponse1 =
                                                   
                                                   
                                                         skel.dataSelectionUI(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), dataSelectionUIResponse1, false);
                                    } else 

            if("dataInputUI".equals(methodName)){
                
                org.example.www.ui_bpel_mediator.DataInputUIResponse dataInputUIResponse3 = null;
	                        org.example.www.ui_bpel_mediator.DataInputUI wrappedParam =
                                                             (org.example.www.ui_bpel_mediator.DataInputUI)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    org.example.www.ui_bpel_mediator.DataInputUI.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               dataInputUIResponse3 =
                                                   
                                                   
                                                         skel.dataInputUI(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), dataInputUIResponse3, false);
                                    
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
            private  org.apache.axiom.om.OMElement  toOM(org.example.www.ui_bpel_mediator.EventDataUI param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(org.example.www.ui_bpel_mediator.EventDataUI.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(org.example.www.ui_bpel_mediator.DataOutputUI param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(org.example.www.ui_bpel_mediator.DataOutputUI.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(org.example.www.ui_bpel_mediator.DataSelectionUI param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(org.example.www.ui_bpel_mediator.DataSelectionUI.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(org.example.www.ui_bpel_mediator.DataSelectionUIResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(org.example.www.ui_bpel_mediator.DataSelectionUIResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(org.example.www.ui_bpel_mediator.DataInputUI param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(org.example.www.ui_bpel_mediator.DataInputUI.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(org.example.www.ui_bpel_mediator.DataInputUIResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(org.example.www.ui_bpel_mediator.DataInputUIResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, org.example.www.ui_bpel_mediator.DataSelectionUIResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(org.example.www.ui_bpel_mediator.DataSelectionUIResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private org.example.www.ui_bpel_mediator.DataSelectionUIResponse wrapdataSelectionUI(){
                                org.example.www.ui_bpel_mediator.DataSelectionUIResponse wrappedElement = new org.example.www.ui_bpel_mediator.DataSelectionUIResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, org.example.www.ui_bpel_mediator.DataInputUIResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(org.example.www.ui_bpel_mediator.DataInputUIResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private org.example.www.ui_bpel_mediator.DataInputUIResponse wrapdataInputUI(){
                                org.example.www.ui_bpel_mediator.DataInputUIResponse wrappedElement = new org.example.www.ui_bpel_mediator.DataInputUIResponse();
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
        
                if (org.example.www.ui_bpel_mediator.EventDataUI.class.equals(type)){
                
                           return org.example.www.ui_bpel_mediator.EventDataUI.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (org.example.www.ui_bpel_mediator.DataOutputUI.class.equals(type)){
                
                           return org.example.www.ui_bpel_mediator.DataOutputUI.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (org.example.www.ui_bpel_mediator.DataSelectionUI.class.equals(type)){
                
                           return org.example.www.ui_bpel_mediator.DataSelectionUI.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (org.example.www.ui_bpel_mediator.DataSelectionUIResponse.class.equals(type)){
                
                           return org.example.www.ui_bpel_mediator.DataSelectionUIResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (org.example.www.ui_bpel_mediator.DataInputUI.class.equals(type)){
                
                           return org.example.www.ui_bpel_mediator.DataInputUI.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (org.example.www.ui_bpel_mediator.DataInputUIResponse.class.equals(type)){
                
                           return org.example.www.ui_bpel_mediator.DataInputUIResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

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
    