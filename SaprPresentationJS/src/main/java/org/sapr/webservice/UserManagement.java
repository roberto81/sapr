
package org.sapr.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "UserManagement", targetNamespace = "http://webservice.sapr.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface UserManagement {


    /**
     * 
     * @param arg0
     * @return
     *     returns org.sapr.webservice.UserResp
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "readUser", targetNamespace = "http://webservice.sapr.org/", className = "org.sapr.webservice.ReadUser")
    @ResponseWrapper(localName = "readUserResponse", targetNamespace = "http://webservice.sapr.org/", className = "org.sapr.webservice.ReadUserResponse")
    @Action(input = "http://webservice.sapr.org/UserManagement/readUserRequest", output = "http://webservice.sapr.org/UserManagement/readUserResponse")
    public UserResp readUser(
        @WebParam(name = "arg0", targetNamespace = "")
        UserReq arg0);

    /**
     * 
     * @return
     *     returns org.sapr.webservice.UserResp
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAllUser", targetNamespace = "http://webservice.sapr.org/", className = "org.sapr.webservice.GetAllUser")
    @ResponseWrapper(localName = "getAllUserResponse", targetNamespace = "http://webservice.sapr.org/", className = "org.sapr.webservice.GetAllUserResponse")
    @Action(input = "http://webservice.sapr.org/UserManagement/getAllUserRequest", output = "http://webservice.sapr.org/UserManagement/getAllUserResponse")
    public UserResp getAllUser();

    /**
     * 
     * @param arg0
     * @return
     *     returns org.sapr.webservice.UserResp
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "deleteUser", targetNamespace = "http://webservice.sapr.org/", className = "org.sapr.webservice.DeleteUser")
    @ResponseWrapper(localName = "deleteUserResponse", targetNamespace = "http://webservice.sapr.org/", className = "org.sapr.webservice.DeleteUserResponse")
    @Action(input = "http://webservice.sapr.org/UserManagement/deleteUserRequest", output = "http://webservice.sapr.org/UserManagement/deleteUserResponse")
    public UserResp deleteUser(
        @WebParam(name = "arg0", targetNamespace = "")
        UserReq arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns org.sapr.webservice.UserResp
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "insertUser", targetNamespace = "http://webservice.sapr.org/", className = "org.sapr.webservice.InsertUser")
    @ResponseWrapper(localName = "insertUserResponse", targetNamespace = "http://webservice.sapr.org/", className = "org.sapr.webservice.InsertUserResponse")
    @Action(input = "http://webservice.sapr.org/UserManagement/insertUserRequest", output = "http://webservice.sapr.org/UserManagement/insertUserResponse")
    public UserResp insertUser(
        @WebParam(name = "arg0", targetNamespace = "")
        UserReq arg0);

}
