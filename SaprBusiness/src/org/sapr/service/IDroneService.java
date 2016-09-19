package org.sapr.service;

import org.sapr.entity.Drone;
import org.sapr.request.DroneReq;
import org.sapr.response.DroneResp;

public interface IDroneService {
	DroneResp getAllDrone();
	DroneResp deleteDrone(Drone drone);
	DroneResp insertDrone(DroneReq request);
	DroneResp updateDrone(DroneReq request);
}
