
/**
 * ProcessDeployerServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1  Built on : Aug 31, 2011 (12:22:40 CEST)
 */

    package be.ac.fundp.precise.ui_bpel.ui.transformation.deployment.axisClient;

    /**
     *  ProcessDeployerServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class ProcessDeployerServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public ProcessDeployerServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public ProcessDeployerServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for deployAui method
            * override this method for handling normal response from deployAui operation
            */
           public void receiveResultdeployAui(
                    ProcessDeployerServiceStub.DeployAuiResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deployAui operation
           */
            public void receiveErrordeployAui(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deployProcess method
            * override this method for handling normal response from deployProcess operation
            */
           public void receiveResultdeployProcess(
                    ProcessDeployerServiceStub.DeployProcessResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deployProcess operation
           */
            public void receiveErrordeployProcess(java.lang.Exception e) {
            }
                


    }
    