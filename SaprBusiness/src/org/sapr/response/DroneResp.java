package org.sapr.response;

import java.util.List;

import org.sapr.entity.Drone;

public class DroneResp extends AbstResponse {
	private Drone drone;
	private List<Drone> droneList;
	
	public DroneResp(){
		
	}
	
	public DroneResp(Drone drone){
		super();
		this.drone = drone;
	}

	public Drone getDrone() {
		return drone;
	}

	public void setDrone(Drone drone) {
		this.drone = drone;
	}

	public List<Drone> getDroneList() {
		return droneList;
	}

	public void setDroneList(List<Drone> droneList) {
		this.droneList = droneList;
	}
	
	
}
