
/**
 * ExtensionMapper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.4  Built on : Dec 19, 2010 (08:19:26 CET)
 */

        
            package org.example.www.ui_bpel_mediator;
        
            /**
            *  ExtensionMapper class
            */
        
        public  class ExtensionMapper{

          public static java.lang.Object getTypeObject(java.lang.String namespaceURI,
                                                       java.lang.String typeName,
                                                       javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{

              
                  if (
                  "http://www.example.org/UI_BPEL-Mediator/".equals(namespaceURI) &&
                  "DataUIType".equals(typeName)){
                   
                            return  org.example.www.ui_bpel_mediator.DataUIType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://www.example.org/UI_BPEL-Mediator/".equals(namespaceURI) &&
                  "DateUIDataType".equals(typeName)){
                   
                            return  org.example.www.ui_bpel_mediator.DateUIDataType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://www.example.org/UI_BPEL-Mediator/".equals(namespaceURI) &&
                  "BooleanUIDataType".equals(typeName)){
                   
                            return  org.example.www.ui_bpel_mediator.BooleanUIDataType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://www.example.org/UI_BPEL-Mediator/".equals(namespaceURI) &&
                  "StringUIDataType".equals(typeName)){
                   
                            return  org.example.www.ui_bpel_mediator.StringUIDataType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://www.example.org/UI_BPEL-Mediator/".equals(namespaceURI) &&
                  "IntUIDataType".equals(typeName)){
                   
                            return  org.example.www.ui_bpel_mediator.IntUIDataType.Factory.parse(reader);
                        

                  }

              
             throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
          }

        }
    