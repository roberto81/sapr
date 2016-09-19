
package org.sapr.webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.sapr.webservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _InsertDrone_QNAME = new QName("http://webservice.sapr.org/", "insertDrone");
    private final static QName _InsertDroneResponse_QNAME = new QName("http://webservice.sapr.org/", "insertDroneResponse");
    private final static QName _UpdateDroneResponse_QNAME = new QName("http://webservice.sapr.org/", "updateDroneResponse");
    private final static QName _GetAllDrone_QNAME = new QName("http://webservice.sapr.org/", "getAllDrone");
    private final static QName _UpdateDrone_QNAME = new QName("http://webservice.sapr.org/", "updateDrone");
    private final static QName _DeleteDrone_QNAME = new QName("http://webservice.sapr.org/", "deleteDrone");
    private final static QName _DeleteDroneResponse_QNAME = new QName("http://webservice.sapr.org/", "deleteDroneResponse");
    private final static QName _GetAllDroneResponse_QNAME = new QName("http://webservice.sapr.org/", "getAllDroneResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.sapr.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UpdateDroneResponse }
     * 
     */
    public UpdateDroneResponse createUpdateDroneResponse() {
        return new UpdateDroneResponse();
    }

    /**
     * Create an instance of {@link GetAllDrone }
     * 
     */
    public GetAllDrone createGetAllDrone() {
        return new GetAllDrone();
    }

    /**
     * Create an instance of {@link InsertDrone }
     * 
     */
    public InsertDrone createInsertDrone() {
        return new InsertDrone();
    }

    /**
     * Create an instance of {@link InsertDroneResponse }
     * 
     */
    public InsertDroneResponse createInsertDroneResponse() {
        return new InsertDroneResponse();
    }

    /**
     * Create an instance of {@link DeleteDrone }
     * 
     */
    public DeleteDrone createDeleteDrone() {
        return new DeleteDrone();
    }

    /**
     * Create an instance of {@link UpdateDrone }
     * 
     */
    public UpdateDrone createUpdateDrone() {
        return new UpdateDrone();
    }

    /**
     * Create an instance of {@link DeleteDroneResponse }
     * 
     */
    public DeleteDroneResponse createDeleteDroneResponse() {
        return new DeleteDroneResponse();
    }

    /**
     * Create an instance of {@link GetAllDroneResponse }
     * 
     */
    public GetAllDroneResponse createGetAllDroneResponse() {
        return new GetAllDroneResponse();
    }

    /**
     * Create an instance of {@link DroneReq }
     * 
     */
    public DroneReq createDroneReq() {
        return new DroneReq();
    }

    /**
     * Create an instance of {@link DroneResp }
     * 
     */
    public DroneResp createDroneResp() {
        return new DroneResp();
    }

    /**
     * Create an instance of {@link Drone }
     * 
     */
    public Drone createDrone() {
        return new Drone();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertDrone }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.sapr.org/", name = "insertDrone")
    public JAXBElement<InsertDrone> createInsertDrone(InsertDrone value) {
        return new JAXBElement<InsertDrone>(_InsertDrone_QNAME, InsertDrone.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertDroneResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.sapr.org/", name = "insertDroneResponse")
    public JAXBElement<InsertDroneResponse> createInsertDroneResponse(InsertDroneResponse value) {
        return new JAXBElement<InsertDroneResponse>(_InsertDroneResponse_QNAME, InsertDroneResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateDroneResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.sapr.org/", name = "updateDroneResponse")
    public JAXBElement<UpdateDroneResponse> createUpdateDroneResponse(UpdateDroneResponse value) {
        return new JAXBElement<UpdateDroneResponse>(_UpdateDroneResponse_QNAME, UpdateDroneResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllDrone }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.sapr.org/", name = "getAllDrone")
    public JAXBElement<GetAllDrone> createGetAllDrone(GetAllDrone value) {
        return new JAXBElement<GetAllDrone>(_GetAllDrone_QNAME, GetAllDrone.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateDrone }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.sapr.org/", name = "updateDrone")
    public JAXBElement<UpdateDrone> createUpdateDrone(UpdateDrone value) {
        return new JAXBElement<UpdateDrone>(_UpdateDrone_QNAME, UpdateDrone.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteDrone }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.sapr.org/", name = "deleteDrone")
    public JAXBElement<DeleteDrone> createDeleteDrone(DeleteDrone value) {
        return new JAXBElement<DeleteDrone>(_DeleteDrone_QNAME, DeleteDrone.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteDroneResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.sapr.org/", name = "deleteDroneResponse")
    public JAXBElement<DeleteDroneResponse> createDeleteDroneResponse(DeleteDroneResponse value) {
        return new JAXBElement<DeleteDroneResponse>(_DeleteDroneResponse_QNAME, DeleteDroneResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllDroneResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.sapr.org/", name = "getAllDroneResponse")
    public JAXBElement<GetAllDroneResponse> createGetAllDroneResponse(GetAllDroneResponse value) {
        return new JAXBElement<GetAllDroneResponse>(_GetAllDroneResponse_QNAME, GetAllDroneResponse.class, null, value);
    }

}
