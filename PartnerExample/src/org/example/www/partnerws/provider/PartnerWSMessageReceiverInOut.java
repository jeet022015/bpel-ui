
/**
 * PartnerWSMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1  Built on : Aug 31, 2011 (12:22:40 CEST)
 */
        package org.example.www.partnerws.provider;

        /**
        *  PartnerWSMessageReceiverInOut message receiver
        */

        public class PartnerWSMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutMessageReceiver{


        public void invokeBusinessLogic(org.apache.axis2.context.MessageContext msgContext, org.apache.axis2.context.MessageContext newMsgContext)
        throws org.apache.axis2.AxisFault{

        try {

        // get the implementation class for the Web Service
        Object obj = getTheImplementationObject(msgContext);

        PartnerWSSkeleton skel = (PartnerWSSkeleton)obj;
        //Out Envelop
        org.apache.axiom.soap.SOAPEnvelope envelope = null;
        //Find the axisOperation that has been set by the Dispatch phase.
        org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext().getAxisOperation();
        if (op == null) {
        throw new org.apache.axis2.AxisFault("Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
        }

        java.lang.String methodName;
        if((op.getName() != null) && ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJavaIdentifier(op.getName().getLocalPart())) != null)){


        

            if("calculateDiscount".equals(methodName)){
                
                org.example.www.partnerws.CalculateDiscountResponse calculateDiscountResponse1 = null;
	                        org.example.www.partnerws.CalculateDiscount wrappedParam =
                                                             (org.example.www.partnerws.CalculateDiscount)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    org.example.www.partnerws.CalculateDiscount.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               calculateDiscountResponse1 =
                                                   
                                                   
                                                         skel.calculateDiscount(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), calculateDiscountResponse1, false, new javax.xml.namespace.QName("http://www.example.org/partnerWS/",
                                                    "calculateDiscount"));
                                    } else 

            if("shipmentPrice".equals(methodName)){
                
                org.example.www.partnerws.ShipmentPriceResponse shipmentPriceResponse3 = null;
	                        org.example.www.partnerws.ShipmentPrice wrappedParam =
                                                             (org.example.www.partnerws.ShipmentPrice)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    org.example.www.partnerws.ShipmentPrice.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               shipmentPriceResponse3 =
                                                   
                                                   
                                                         skel.shipmentPrice(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), shipmentPriceResponse3, false, new javax.xml.namespace.QName("http://www.example.org/partnerWS/",
                                                    "shipmentPrice"));
                                    } else 

            if("calculateInitialPrice".equals(methodName)){
                
                org.example.www.partnerws.CalculateInitialPriceResponse calculateInitialPriceResponse5 = null;
	                        org.example.www.partnerws.CalculateInitialPrice wrappedParam =
                                                             (org.example.www.partnerws.CalculateInitialPrice)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    org.example.www.partnerws.CalculateInitialPrice.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               calculateInitialPriceResponse5 =
                                                   
                                                   
                                                         skel.calculateInitialPrice(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), calculateInitialPriceResponse5, false, new javax.xml.namespace.QName("http://www.example.org/partnerWS/",
                                                    "calculateInitialPrice"));
                                    } else 

            if("calculatePrice".equals(methodName)){
                
                org.example.www.partnerws.CalculatePriceResponse calculatePriceResponse7 = null;
	                        org.example.www.partnerws.CalculatePriceE wrappedParam =
                                                             (org.example.www.partnerws.CalculatePriceE)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    org.example.www.partnerws.CalculatePriceE.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               calculatePriceResponse7 =
                                                   
                                                   
                                                         skel.calculatePrice(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), calculatePriceResponse7, false, new javax.xml.namespace.QName("http://www.example.org/partnerWS/",
                                                    "calculatePrice"));
                                    
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
            private  org.apache.axiom.om.OMElement  toOM(org.example.www.partnerws.CalculateDiscount param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(org.example.www.partnerws.CalculateDiscount.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(org.example.www.partnerws.CalculateDiscountResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(org.example.www.partnerws.CalculateDiscountResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(org.example.www.partnerws.ShipmentPrice param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(org.example.www.partnerws.ShipmentPrice.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(org.example.www.partnerws.ShipmentPriceResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(org.example.www.partnerws.ShipmentPriceResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(org.example.www.partnerws.CalculateInitialPrice param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(org.example.www.partnerws.CalculateInitialPrice.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(org.example.www.partnerws.CalculateInitialPriceResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(org.example.www.partnerws.CalculateInitialPriceResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(org.example.www.partnerws.CalculatePriceE param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(org.example.www.partnerws.CalculatePriceE.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(org.example.www.partnerws.CalculatePriceResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(org.example.www.partnerws.CalculatePriceResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, org.example.www.partnerws.CalculateDiscountResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(org.example.www.partnerws.CalculateDiscountResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private org.example.www.partnerws.CalculateDiscountResponse wrapcalculateDiscount(){
                                org.example.www.partnerws.CalculateDiscountResponse wrappedElement = new org.example.www.partnerws.CalculateDiscountResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, org.example.www.partnerws.ShipmentPriceResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(org.example.www.partnerws.ShipmentPriceResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private org.example.www.partnerws.ShipmentPriceResponse wrapshipmentPrice(){
                                org.example.www.partnerws.ShipmentPriceResponse wrappedElement = new org.example.www.partnerws.ShipmentPriceResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, org.example.www.partnerws.CalculateInitialPriceResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(org.example.www.partnerws.CalculateInitialPriceResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private org.example.www.partnerws.CalculateInitialPriceResponse wrapcalculateInitialPrice(){
                                org.example.www.partnerws.CalculateInitialPriceResponse wrappedElement = new org.example.www.partnerws.CalculateInitialPriceResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, org.example.www.partnerws.CalculatePriceResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(org.example.www.partnerws.CalculatePriceResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private org.example.www.partnerws.CalculatePriceResponse wrapcalculatePrice(){
                                org.example.www.partnerws.CalculatePriceResponse wrappedElement = new org.example.www.partnerws.CalculatePriceResponse();
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
        
                if (org.example.www.partnerws.CalculateDiscount.class.equals(type)){
                
                           return org.example.www.partnerws.CalculateDiscount.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (org.example.www.partnerws.CalculateDiscountResponse.class.equals(type)){
                
                           return org.example.www.partnerws.CalculateDiscountResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (org.example.www.partnerws.ShipmentPrice.class.equals(type)){
                
                           return org.example.www.partnerws.ShipmentPrice.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (org.example.www.partnerws.ShipmentPriceResponse.class.equals(type)){
                
                           return org.example.www.partnerws.ShipmentPriceResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (org.example.www.partnerws.CalculateInitialPrice.class.equals(type)){
                
                           return org.example.www.partnerws.CalculateInitialPrice.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (org.example.www.partnerws.CalculateInitialPriceResponse.class.equals(type)){
                
                           return org.example.www.partnerws.CalculateInitialPriceResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (org.example.www.partnerws.CalculatePriceE.class.equals(type)){
                
                           return org.example.www.partnerws.CalculatePriceE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (org.example.www.partnerws.CalculatePriceResponse.class.equals(type)){
                
                           return org.example.www.partnerws.CalculatePriceResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

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
    