package org.sapr.request;

import org.sapr.entity.Drone;

public class DroneReq extends AbstRequest{
	private Drone drone;

	public Drone getDrone() {
		return drone;
	}

	public void setDrone(Drone drone) {
		this.drone = drone;
	}

}
