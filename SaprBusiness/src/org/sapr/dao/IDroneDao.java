package org.sapr.dao;

import java.util.List;

import org.sapr.entity.Drone;

public interface IDroneDao {
	List<Drone> getAllDrone();
	void deleteDrone(Drone drone);
	Integer insertDrone(Drone drone);
	Integer updateDrone(Drone drone);
}
