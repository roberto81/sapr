
package org.sapr.webservice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per droneResp complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="droneResp">
 *   &lt;complexContent>
 *     &lt;extension base="{http://webservice.sapr.org/}abstResponse">
 *       &lt;sequence>
 *         &lt;element name="drone" type="{http://webservice.sapr.org/}drone" minOccurs="0"/>
 *         &lt;element name="droneList" type="{http://webservice.sapr.org/}drone" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "droneResp", propOrder = {
    "drone",
    "droneList"
})
public class DroneResp
    extends AbstResponse
{

    protected Drone drone;
    @XmlElement(nillable = true)
    protected List<Drone> droneList;

    /**
     * Recupera il valore della proprietà drone.
     * 
     * @return
     *     possible object is
     *     {@link Drone }
     *     
     */
    public Drone getDrone() {
        return drone;
    }

    /**
     * Imposta il valore della proprietà drone.
     * 
     * @param value
     *     allowed object is
     *     {@link Drone }
     *     
     */
    public void setDrone(Drone value) {
        this.drone = value;
    }

    /**
     * Gets the value of the droneList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the droneList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDroneList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Drone }
     * 
     * 
     */
    public List<Drone> getDroneList() {
        if (droneList == null) {
            droneList = new ArrayList<Drone>();
        }
        return this.droneList;
    }

}
