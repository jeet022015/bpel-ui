
/**
 * DataUIType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.4  Built on : Dec 19, 2010 (08:19:26 CET)
 */
            
                package org.example.www.ui_bpel_mediator;
            

            /**
            *  DataUIType bean class
            */
        
        public  class DataUIType
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = DataUIType
                Namespace URI = http://www.example.org/UI_BPEL-Mediator/
                Namespace Prefix = ns1
                */
            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://www.example.org/UI_BPEL-Mediator/")){
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for StringUIData
                        * This was an Array!
                        */

                        
                                    protected org.example.www.ui_bpel_mediator.StringUIDataType[] localStringUIData ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localStringUIDataTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return org.example.www.ui_bpel_mediator.StringUIDataType[]
                           */
                           public  org.example.www.ui_bpel_mediator.StringUIDataType[] getStringUIData(){
                               return localStringUIData;
                           }

                           
                        


                               
                              /**
                               * validate the array for StringUIData
                               */
                              protected void validateStringUIData(org.example.www.ui_bpel_mediator.StringUIDataType[] param){
                             
                              }


                             /**
                              * Auto generated setter method
                              * @param param StringUIData
                              */
                              public void setStringUIData(org.example.www.ui_bpel_mediator.StringUIDataType[] param){
                              
                                   validateStringUIData(param);

                               
                                          if (param != null){
                                             //update the setting tracker
                                             localStringUIDataTracker = true;
                                          } else {
                                             localStringUIDataTracker = false;
                                                 
                                          }
                                      
                                      this.localStringUIData=param;
                              }

                               
                             
                             /**
                             * Auto generated add method for the array for convenience
                             * @param param org.example.www.ui_bpel_mediator.StringUIDataType
                             */
                             public void addStringUIData(org.example.www.ui_bpel_mediator.StringUIDataType param){
                                   if (localStringUIData == null){
                                   localStringUIData = new org.example.www.ui_bpel_mediator.StringUIDataType[]{};
                                   }

                            
                                 //update the setting tracker
                                localStringUIDataTracker = true;
                            

                               java.util.List list =
                            org.apache.axis2.databinding.utils.ConverterUtil.toList(localStringUIData);
                               list.add(param);
                               this.localStringUIData =
                             (org.example.www.ui_bpel_mediator.StringUIDataType[])list.toArray(
                            new org.example.www.ui_bpel_mediator.StringUIDataType[list.size()]);

                             }
                             

                        /**
                        * field for IntUIData
                        * This was an Array!
                        */

                        
                                    protected org.example.www.ui_bpel_mediator.IntUIDataType[] localIntUIData ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIntUIDataTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return org.example.www.ui_bpel_mediator.IntUIDataType[]
                           */
                           public  org.example.www.ui_bpel_mediator.IntUIDataType[] getIntUIData(){
                               return localIntUIData;
                           }

                           
                        


                               
                              /**
                               * validate the array for IntUIData
                               */
                              protected void validateIntUIData(org.example.www.ui_bpel_mediator.IntUIDataType[] param){
                             
                              }


                             /**
                              * Auto generated setter method
                              * @param param IntUIData
                              */
                              public void setIntUIData(org.example.www.ui_bpel_mediator.IntUIDataType[] param){
                              
                                   validateIntUIData(param);

                               
                                          if (param != null){
                                             //update the setting tracker
                                             localIntUIDataTracker = true;
                                          } else {
                                             localIntUIDataTracker = false;
                                                 
                                          }
                                      
                                      this.localIntUIData=param;
                              }

                               
                             
                             /**
                             * Auto generated add method for the array for convenience
                             * @param param org.example.www.ui_bpel_mediator.IntUIDataType
                             */
                             public void addIntUIData(org.example.www.ui_bpel_mediator.IntUIDataType param){
                                   if (localIntUIData == null){
                                   localIntUIData = new org.example.www.ui_bpel_mediator.IntUIDataType[]{};
                                   }

                            
                                 //update the setting tracker
                                localIntUIDataTracker = true;
                            

                               java.util.List list =
                            org.apache.axis2.databinding.utils.ConverterUtil.toList(localIntUIData);
                               list.add(param);
                               this.localIntUIData =
                             (org.example.www.ui_bpel_mediator.IntUIDataType[])list.toArray(
                            new org.example.www.ui_bpel_mediator.IntUIDataType[list.size()]);

                             }
                             

                        /**
                        * field for DateUIData
                        * This was an Array!
                        */

                        
                                    protected org.example.www.ui_bpel_mediator.DateUIDataType[] localDateUIData ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDateUIDataTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return org.example.www.ui_bpel_mediator.DateUIDataType[]
                           */
                           public  org.example.www.ui_bpel_mediator.DateUIDataType[] getDateUIData(){
                               return localDateUIData;
                           }

                           
                        


                               
                              /**
                               * validate the array for DateUIData
                               */
                              protected void validateDateUIData(org.example.www.ui_bpel_mediator.DateUIDataType[] param){
                             
                              }


                             /**
                              * Auto generated setter method
                              * @param param DateUIData
                              */
                              public void setDateUIData(org.example.www.ui_bpel_mediator.DateUIDataType[] param){
                              
                                   validateDateUIData(param);

                               
                                          if (param != null){
                                             //update the setting tracker
                                             localDateUIDataTracker = true;
                                          } else {
                                             localDateUIDataTracker = false;
                                                 
                                          }
                                      
                                      this.localDateUIData=param;
                              }

                               
                             
                             /**
                             * Auto generated add method for the array for convenience
                             * @param param org.example.www.ui_bpel_mediator.DateUIDataType
                             */
                             public void addDateUIData(org.example.www.ui_bpel_mediator.DateUIDataType param){
                                   if (localDateUIData == null){
                                   localDateUIData = new org.example.www.ui_bpel_mediator.DateUIDataType[]{};
                                   }

                            
                                 //update the setting tracker
                                localDateUIDataTracker = true;
                            

                               java.util.List list =
                            org.apache.axis2.databinding.utils.ConverterUtil.toList(localDateUIData);
                               list.add(param);
                               this.localDateUIData =
                             (org.example.www.ui_bpel_mediator.DateUIDataType[])list.toArray(
                            new org.example.www.ui_bpel_mediator.DateUIDataType[list.size()]);

                             }
                             

                        /**
                        * field for BooleanUIData
                        * This was an Array!
                        */

                        
                                    protected org.example.www.ui_bpel_mediator.BooleanUIDataType[] localBooleanUIData ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localBooleanUIDataTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return org.example.www.ui_bpel_mediator.BooleanUIDataType[]
                           */
                           public  org.example.www.ui_bpel_mediator.BooleanUIDataType[] getBooleanUIData(){
                               return localBooleanUIData;
                           }

                           
                        


                               
                              /**
                               * validate the array for BooleanUIData
                               */
                              protected void validateBooleanUIData(org.example.www.ui_bpel_mediator.BooleanUIDataType[] param){
                             
                              }


                             /**
                              * Auto generated setter method
                              * @param param BooleanUIData
                              */
                              public void setBooleanUIData(org.example.www.ui_bpel_mediator.BooleanUIDataType[] param){
                              
                                   validateBooleanUIData(param);

                               
                                          if (param != null){
                                             //update the setting tracker
                                             localBooleanUIDataTracker = true;
                                          } else {
                                             localBooleanUIDataTracker = false;
                                                 
                                          }
                                      
                                      this.localBooleanUIData=param;
                              }

                               
                             
                             /**
                             * Auto generated add method for the array for convenience
                             * @param param org.example.www.ui_bpel_mediator.BooleanUIDataType
                             */
                             public void addBooleanUIData(org.example.www.ui_bpel_mediator.BooleanUIDataType param){
                                   if (localBooleanUIData == null){
                                   localBooleanUIData = new org.example.www.ui_bpel_mediator.BooleanUIDataType[]{};
                                   }

                            
                                 //update the setting tracker
                                localBooleanUIDataTracker = true;
                            

                               java.util.List list =
                            org.apache.axis2.databinding.utils.ConverterUtil.toList(localBooleanUIData);
                               list.add(param);
                               this.localBooleanUIData =
                             (org.example.www.ui_bpel_mediator.BooleanUIDataType[])list.toArray(
                            new org.example.www.ui_bpel_mediator.BooleanUIDataType[list.size()]);

                             }
                             

     /**
     * isReaderMTOMAware
     * @return true if the reader supports MTOM
     */
   public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;
        
        try{
          isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        }catch(java.lang.IllegalArgumentException e){
          isReaderMTOMAware = false;
        }
        return isReaderMTOMAware;
   }
     
     
        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{


        
               org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,parentQName){

                 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                       DataUIType.this.serialize(parentQName,factory,xmlWriter);
                 }
               };
               return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
               parentQName,factory,dataSource);
            
       }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       final org.apache.axiom.om.OMFactory factory,
                                       org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,factory,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               final org.apache.axiom.om.OMFactory factory,
                               org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
            
                


                java.lang.String prefix = null;
                java.lang.String namespace = null;
                

                    prefix = parentQName.getPrefix();
                    namespace = parentQName.getNamespaceURI();

                    if ((namespace != null) && (namespace.trim().length() > 0)) {
                        java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                        if (writerPrefix != null) {
                            xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                        } else {
                            if (prefix == null) {
                                prefix = generatePrefix(namespace);
                            }

                            xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                            xmlWriter.writeNamespace(prefix, namespace);
                            xmlWriter.setPrefix(prefix, namespace);
                        }
                    } else {
                        xmlWriter.writeStartElement(parentQName.getLocalPart());
                    }
                
                  if (serializeType){
               

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://www.example.org/UI_BPEL-Mediator/");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":DataUIType",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "DataUIType",
                           xmlWriter);
                   }

               
                   }
                if (localStringUIDataTracker){
                                       if (localStringUIData!=null){
                                            for (int i = 0;i < localStringUIData.length;i++){
                                                if (localStringUIData[i] != null){
                                                 localStringUIData[i].serialize(new javax.xml.namespace.QName("","StringUIData"),
                                                           factory,xmlWriter);
                                                } else {
                                                   
                                                        // we don't have to do any thing since minOccures is zero
                                                    
                                                }

                                            }
                                     } else {
                                        
                                               throw new org.apache.axis2.databinding.ADBException("StringUIData cannot be null!!");
                                        
                                    }
                                 } if (localIntUIDataTracker){
                                       if (localIntUIData!=null){
                                            for (int i = 0;i < localIntUIData.length;i++){
                                                if (localIntUIData[i] != null){
                                                 localIntUIData[i].serialize(new javax.xml.namespace.QName("","IntUIData"),
                                                           factory,xmlWriter);
                                                } else {
                                                   
                                                        // we don't have to do any thing since minOccures is zero
                                                    
                                                }

                                            }
                                     } else {
                                        
                                               throw new org.apache.axis2.databinding.ADBException("IntUIData cannot be null!!");
                                        
                                    }
                                 } if (localDateUIDataTracker){
                                       if (localDateUIData!=null){
                                            for (int i = 0;i < localDateUIData.length;i++){
                                                if (localDateUIData[i] != null){
                                                 localDateUIData[i].serialize(new javax.xml.namespace.QName("","DateUIData"),
                                                           factory,xmlWriter);
                                                } else {
                                                   
                                                        // we don't have to do any thing since minOccures is zero
                                                    
                                                }

                                            }
                                     } else {
                                        
                                               throw new org.apache.axis2.databinding.ADBException("DateUIData cannot be null!!");
                                        
                                    }
                                 } if (localBooleanUIDataTracker){
                                       if (localBooleanUIData!=null){
                                            for (int i = 0;i < localBooleanUIData.length;i++){
                                                if (localBooleanUIData[i] != null){
                                                 localBooleanUIData[i].serialize(new javax.xml.namespace.QName("","BooleanUIData"),
                                                           factory,xmlWriter);
                                                } else {
                                                   
                                                        // we don't have to do any thing since minOccures is zero
                                                    
                                                }

                                            }
                                     } else {
                                        
                                               throw new org.apache.axis2.databinding.ADBException("BooleanUIData cannot be null!!");
                                        
                                    }
                                 }
                    xmlWriter.writeEndElement();
               

        }

         /**
          * Util method to write an attribute with the ns prefix
          */
          private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
              if (xmlWriter.getPrefix(namespace) == null) {
                       xmlWriter.writeNamespace(prefix, namespace);
                       xmlWriter.setPrefix(prefix, namespace);

              }

              xmlWriter.writeAttribute(namespace,attName,attValue);

         }

        /**
          * Util method to write an attribute without the ns prefix
          */
          private void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
                if (namespace.equals(""))
              {
                  xmlWriter.writeAttribute(attName,attValue);
              }
              else
              {
                  registerPrefix(xmlWriter, namespace);
                  xmlWriter.writeAttribute(namespace,attName,attValue);
              }
          }


           /**
             * Util method to write an attribute without the ns prefix
             */
            private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
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
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
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
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


         /**
         * Register a namespace prefix
         */
         private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
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
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{


        
                 java.util.ArrayList elementList = new java.util.ArrayList();
                 java.util.ArrayList attribList = new java.util.ArrayList();

                 if (localStringUIDataTracker){
                             if (localStringUIData!=null) {
                                 for (int i = 0;i < localStringUIData.length;i++){

                                    if (localStringUIData[i] != null){
                                         elementList.add(new javax.xml.namespace.QName("",
                                                                          "StringUIData"));
                                         elementList.add(localStringUIData[i]);
                                    } else {
                                        
                                                // nothing to do
                                            
                                    }

                                 }
                             } else {
                                 
                                        throw new org.apache.axis2.databinding.ADBException("StringUIData cannot be null!!");
                                    
                             }

                        } if (localIntUIDataTracker){
                             if (localIntUIData!=null) {
                                 for (int i = 0;i < localIntUIData.length;i++){

                                    if (localIntUIData[i] != null){
                                         elementList.add(new javax.xml.namespace.QName("",
                                                                          "IntUIData"));
                                         elementList.add(localIntUIData[i]);
                                    } else {
                                        
                                                // nothing to do
                                            
                                    }

                                 }
                             } else {
                                 
                                        throw new org.apache.axis2.databinding.ADBException("IntUIData cannot be null!!");
                                    
                             }

                        } if (localDateUIDataTracker){
                             if (localDateUIData!=null) {
                                 for (int i = 0;i < localDateUIData.length;i++){

                                    if (localDateUIData[i] != null){
                                         elementList.add(new javax.xml.namespace.QName("",
                                                                          "DateUIData"));
                                         elementList.add(localDateUIData[i]);
                                    } else {
                                        
                                                // nothing to do
                                            
                                    }

                                 }
                             } else {
                                 
                                        throw new org.apache.axis2.databinding.ADBException("DateUIData cannot be null!!");
                                    
                             }

                        } if (localBooleanUIDataTracker){
                             if (localBooleanUIData!=null) {
                                 for (int i = 0;i < localBooleanUIData.length;i++){

                                    if (localBooleanUIData[i] != null){
                                         elementList.add(new javax.xml.namespace.QName("",
                                                                          "BooleanUIData"));
                                         elementList.add(localBooleanUIData[i]);
                                    } else {
                                        
                                                // nothing to do
                                            
                                    }

                                 }
                             } else {
                                 
                                        throw new org.apache.axis2.databinding.ADBException("BooleanUIData cannot be null!!");
                                    
                             }

                        }

                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());
            
            

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static DataUIType parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            DataUIType object =
                new DataUIType();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {
                
                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                
                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                  java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                  if (fullTypeName!=null){
                    java.lang.String nsPrefix = null;
                    if (fullTypeName.indexOf(":") > -1){
                        nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                    }
                    nsPrefix = nsPrefix==null?"":nsPrefix;

                    java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);
                    
                            if (!"DataUIType".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (DataUIType)org.example.www.ui_bpel_mediator.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                 
                    
                    reader.next();
                
                        java.util.ArrayList list1 = new java.util.ArrayList();
                    
                        java.util.ArrayList list2 = new java.util.ArrayList();
                    
                        java.util.ArrayList list3 = new java.util.ArrayList();
                    
                        java.util.ArrayList list4 = new java.util.ArrayList();
                    
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","StringUIData").equals(reader.getName())){
                                
                                    
                                    
                                    // Process the array and step past its final element's end.
                                    list1.add(org.example.www.ui_bpel_mediator.StringUIDataType.Factory.parse(reader));
                                                                
                                                        //loop until we find a start element that is not part of this array
                                                        boolean loopDone1 = false;
                                                        while(!loopDone1){
                                                            // We should be at the end element, but make sure
                                                            while (!reader.isEndElement())
                                                                reader.next();
                                                            // Step out of this element
                                                            reader.next();
                                                            // Step to next element event.
                                                            while (!reader.isStartElement() && !reader.isEndElement())
                                                                reader.next();
                                                            if (reader.isEndElement()){
                                                                //two continuous end elements means we are exiting the xml structure
                                                                loopDone1 = true;
                                                            } else {
                                                                if (new javax.xml.namespace.QName("","StringUIData").equals(reader.getName())){
                                                                    list1.add(org.example.www.ui_bpel_mediator.StringUIDataType.Factory.parse(reader));
                                                                        
                                                                }else{
                                                                    loopDone1 = true;
                                                                }
                                                            }
                                                        }
                                                        // call the converter utility  to convert and set the array
                                                        
                                                        object.setStringUIData((org.example.www.ui_bpel_mediator.StringUIDataType[])
                                                            org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                                                org.example.www.ui_bpel_mediator.StringUIDataType.class,
                                                                list1));
                                                            
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","IntUIData").equals(reader.getName())){
                                
                                    
                                    
                                    // Process the array and step past its final element's end.
                                    list2.add(org.example.www.ui_bpel_mediator.IntUIDataType.Factory.parse(reader));
                                                                
                                                        //loop until we find a start element that is not part of this array
                                                        boolean loopDone2 = false;
                                                        while(!loopDone2){
                                                            // We should be at the end element, but make sure
                                                            while (!reader.isEndElement())
                                                                reader.next();
                                                            // Step out of this element
                                                            reader.next();
                                                            // Step to next element event.
                                                            while (!reader.isStartElement() && !reader.isEndElement())
                                                                reader.next();
                                                            if (reader.isEndElement()){
                                                                //two continuous end elements means we are exiting the xml structure
                                                                loopDone2 = true;
                                                            } else {
                                                                if (new javax.xml.namespace.QName("","IntUIData").equals(reader.getName())){
                                                                    list2.add(org.example.www.ui_bpel_mediator.IntUIDataType.Factory.parse(reader));
                                                                        
                                                                }else{
                                                                    loopDone2 = true;
                                                                }
                                                            }
                                                        }
                                                        // call the converter utility  to convert and set the array
                                                        
                                                        object.setIntUIData((org.example.www.ui_bpel_mediator.IntUIDataType[])
                                                            org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                                                org.example.www.ui_bpel_mediator.IntUIDataType.class,
                                                                list2));
                                                            
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","DateUIData").equals(reader.getName())){
                                
                                    
                                    
                                    // Process the array and step past its final element's end.
                                    list3.add(org.example.www.ui_bpel_mediator.DateUIDataType.Factory.parse(reader));
                                                                
                                                        //loop until we find a start element that is not part of this array
                                                        boolean loopDone3 = false;
                                                        while(!loopDone3){
                                                            // We should be at the end element, but make sure
                                                            while (!reader.isEndElement())
                                                                reader.next();
                                                            // Step out of this element
                                                            reader.next();
                                                            // Step to next element event.
                                                            while (!reader.isStartElement() && !reader.isEndElement())
                                                                reader.next();
                                                            if (reader.isEndElement()){
                                                                //two continuous end elements means we are exiting the xml structure
                                                                loopDone3 = true;
                                                            } else {
                                                                if (new javax.xml.namespace.QName("","DateUIData").equals(reader.getName())){
                                                                    list3.add(org.example.www.ui_bpel_mediator.DateUIDataType.Factory.parse(reader));
                                                                        
                                                                }else{
                                                                    loopDone3 = true;
                                                                }
                                                            }
                                                        }
                                                        // call the converter utility  to convert and set the array
                                                        
                                                        object.setDateUIData((org.example.www.ui_bpel_mediator.DateUIDataType[])
                                                            org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                                                org.example.www.ui_bpel_mediator.DateUIDataType.class,
                                                                list3));
                                                            
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","BooleanUIData").equals(reader.getName())){
                                
                                    
                                    
                                    // Process the array and step past its final element's end.
                                    list4.add(org.example.www.ui_bpel_mediator.BooleanUIDataType.Factory.parse(reader));
                                                                
                                                        //loop until we find a start element that is not part of this array
                                                        boolean loopDone4 = false;
                                                        while(!loopDone4){
                                                            // We should be at the end element, but make sure
                                                            while (!reader.isEndElement())
                                                                reader.next();
                                                            // Step out of this element
                                                            reader.next();
                                                            // Step to next element event.
                                                            while (!reader.isStartElement() && !reader.isEndElement())
                                                                reader.next();
                                                            if (reader.isEndElement()){
                                                                //two continuous end elements means we are exiting the xml structure
                                                                loopDone4 = true;
                                                            } else {
                                                                if (new javax.xml.namespace.QName("","BooleanUIData").equals(reader.getName())){
                                                                    list4.add(org.example.www.ui_bpel_mediator.BooleanUIDataType.Factory.parse(reader));
                                                                        
                                                                }else{
                                                                    loopDone4 = true;
                                                                }
                                                            }
                                                        }
                                                        // call the converter utility  to convert and set the array
                                                        
                                                        object.setBooleanUIData((org.example.www.ui_bpel_mediator.BooleanUIDataType[])
                                                            org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                                                org.example.www.ui_bpel_mediator.BooleanUIDataType.class,
                                                                list4));
                                                            
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                  
                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();
                            
                                if (reader.isStartElement())
                                // A start element we are not expecting indicates a trailing invalid property
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                            



            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class

        

        }
           
          