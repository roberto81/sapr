package org.sapr.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.sapr.entity.Drone;
import org.sapr.request.DroneReq;
import org.sapr.response.DroneResp;
import org.sapr.service.IDroneService;
import org.sapr.service.IServiceFactory;
import org.sapr.service.ServiceFactory;

@WebService
public class DroneManagement {
	
	private IServiceFactory serviceFactory = new ServiceFactory();
	private DroneResp response = new DroneResp();
	
	@WebMethod
	public DroneResp getAllDrone(){
		
		IDroneService droneservice = serviceFactory.getDroneService();
		this.response = droneservice.getAllDrone();
		return this.response;
	}
	
	@WebMethod
	public DroneResp deleteDrone(Drone drone){
		IDroneService droneservice = serviceFactory.getDroneService();
		this.response = droneservice.deleteDrone(drone);
		return this.response;
	}
	
	@WebMethod
	public DroneResp insertDrone(DroneReq request){
		IDroneService droneservice = serviceFactory.getDroneService();
		this.response = droneservice.insertDrone(request);
		return response;
	}
	
	@WebMethod
	public DroneResp updateDrone(DroneReq request){
		IDroneService droneservice = serviceFactory.getDroneService();
		this.response = droneservice.updateDrone(request);
		return response;
	}
}
