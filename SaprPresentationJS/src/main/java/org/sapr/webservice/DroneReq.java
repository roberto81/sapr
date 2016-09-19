
package org.sapr.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per droneReq complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="droneReq">
 *   &lt;complexContent>
 *     &lt;extension base="{http://webservice.sapr.org/}abstRequest">
 *       &lt;sequence>
 *         &lt;element name="drone" type="{http://webservice.sapr.org/}drone" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "droneReq", propOrder = {
    "drone"
})
public class DroneReq
    extends AbstRequest
{

    protected Drone drone;

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

}
