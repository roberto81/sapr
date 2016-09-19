package org.sapr.restcontroller;

import org.sapr.webservice.Drone;
import org.sapr.webservice.DroneManagement;
import org.sapr.webservice.DroneManagementService;
import org.sapr.webservice.DroneReq;
import org.sapr.webservice.DroneResp;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DroneRestController {
	
	@RequestMapping(value ="/getAllDrone", produces = MediaType.APPLICATION_JSON_VALUE )
	public @ResponseBody DroneResp getAllUser(){
		
		DroneManagementService droMngService = new DroneManagementService();
		DroneManagement droMng = droMngService.getDroneManagementPort();
		
		DroneResp droneResp = droMng.getAllDrone();
		
		return droneResp;
	}
	
	@RequestMapping(value="/deleteDrone", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody DroneResp deleteDrone(Drone drone){
		
		
		DroneManagementService droMngService = new DroneManagementService();
		DroneManagement droMng = droMngService.getDroneManagementPort();
		
		DroneResp droneResp = droMng.deleteDrone(drone);
		return droneResp;
	}
	
	@RequestMapping(value="/insertDrone", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody DroneResp insertDrone(Drone drone){
		
		DroneManagementService droMngService = new DroneManagementService();
		DroneManagement droMng = droMngService.getDroneManagementPort();
		
		DroneReq request = new DroneReq();
		request.setDrone(drone);
		DroneResp droneResp = droMng.insertDrone(request);
		
		return droneResp;
	}
	
	@RequestMapping(value="/updateDrone", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody DroneResp updateDrone(Drone drone){
		
		DroneManagementService droMngService = new DroneManagementService();
		DroneManagement droMng = droMngService.getDroneManagementPort();
		
		DroneReq request = new DroneReq();
		request.setDrone(drone);
		
		DroneResp droneResp = droMng.updateDrone(request);
		
		return droneResp;
	}

}
