package org.sapr.service;

import java.util.List;

import org.sapr.dao.DaoFactory;
import org.sapr.dao.IDaoFactory;
import org.sapr.entity.Drone;
import org.sapr.request.DroneReq;
import org.sapr.response.DroneResp;

public class DroneService implements IDroneService{
	
	private IDaoFactory daoFactory = new DaoFactory();
	
	@Override
	public DroneResp getAllDrone() {
		
		List<Drone> droneList = this.daoFactory.getDroneDao().getAllDrone();
		
		DroneResp response = new DroneResp();
		response.setErrorCode("0");
		response.setMessage("sussifuly");
		response.setResult(true);
		response.setDroneList(droneList);
		
		return response;
	}

	@Override
	public DroneResp deleteDrone(Drone drone) {
		
		this.daoFactory.getDroneDao().deleteDrone(drone);
		
		DroneResp response = new DroneResp();
		response.setErrorCode("0");
		response.setMessage("sussifuly");
		response.setResult(true);
		
		return response;
	}

	@Override
	public DroneResp insertDrone(DroneReq request) {
		
		Integer outcome;
		outcome = this.daoFactory.getDroneDao().insertDrone(request.getDrone());
		
		DroneResp response = new DroneResp();
		if(outcome.equals(0)){
			response.setResult(true);
			response.setErrorCode("0");
			response.setMessage("sussifuly");
		}
		if(outcome.equals(1)){
			response.setErrorCode("1");
			response.setMessage("username gia esistente");
			response.setResult(false);
		}
		
		return response;
	}

	@Override
	public DroneResp updateDrone(DroneReq request) {
		this.daoFactory.getDroneDao().updateDrone(request.getDrone());
		
		DroneResp response = new DroneResp();
		response.setErrorCode("0");
		response.setMessage("sussifuly");
		response.setResult(true);
		
		return response;
	}

}
