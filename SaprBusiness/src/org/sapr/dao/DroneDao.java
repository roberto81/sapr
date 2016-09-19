package org.sapr.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.sapr.entity.Drone;
import org.sapr.resource.IResourceFactory;
import org.sapr.resource.ResourceFactory;

public class DroneDao implements IDroneDao{
	
	private DataSource dbsource;
	private IResourceFactory resourceFactory;
	private Connection conn;
	private Statement stm;
	private ResultSet rst;
	
	@Override
	public List<Drone> getAllDrone() {
		List<Drone> droneList = new ArrayList<Drone>();
		
		this.resourceFactory = new ResourceFactory();
		this.dbsource = resourceFactory.getDatabaseResource();
		
		String QUERY = "SELECT code,brand,model,number_rotors,engine_power,weight FROM drone;";
		
			try {
			
			this.conn = dbsource.getConnection();
			this.stm = conn.createStatement();
			this.rst = this.stm.executeQuery(QUERY);
			
			while (rst.next()) {
				droneList.add(new Drone(rst.getString("code"),rst.getString("brand"),rst.getString("model"), Integer.parseInt(rst.getString("number_rotors")), rst.getString("engine_power"),Float.parseFloat(rst.getString("weight"))));
			}
			
			this.rst.close();
			this.stm.close();
			this.conn.close();
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return droneList;
	}

	@Override
	public void deleteDrone(Drone drone) {
		this.resourceFactory = new ResourceFactory();
		this.dbsource = resourceFactory.getDatabaseResource();
		String QUERY = "DELETE FROM drone WHERE code='" + drone.getCode() +"';";
		
		Statement deleteDrone;
		
		try {
			this.conn = dbsource.getConnection();
			deleteDrone = this.conn.createStatement();
			deleteDrone.executeUpdate(QUERY);
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				this.conn.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}

	@Override
	public Integer insertDrone(Drone drone) {
		this.resourceFactory = new ResourceFactory();
		this.dbsource = resourceFactory.getDatabaseResource();
		
		String QUERY="INSERT INTO drone(code,brand,model,number_rotors,engine_power,weight)VALUES ('"+ drone.getCode() +"','"+ drone.getBrand() +"','"+ drone.getModel() +"',"+ drone.getNumberRotors() +",'"+ drone.getEnginePower() +"',"+ drone.getWeight() +");";
		Statement insertDrone;
			
		try {
			this.conn = dbsource.getConnection();
			insertDrone = this.conn.createStatement();
			insertDrone.executeUpdate(QUERY);
		} catch (Exception e) {
			if(e instanceof SQLIntegrityConstraintViolationException){
				e.printStackTrace();
				return 1;
			}
		}finally {
			try {
				this.conn.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public Integer updateDrone(Drone drone) {
		this.resourceFactory = new ResourceFactory();
		this.dbsource = resourceFactory.getDatabaseResource();
		
		Statement updateDrone;
		
		String QUERY = "UPDATE drone SET code='" + drone.getCode() + "',brand='" + drone.getBrand() + "',model='" + drone.getModel() + "',number_rotors="+ drone.getNumberRotors() + " ,engine_power='" + drone.getEnginePower() + "',weight="+ drone.getWeight() + " WHERE code='" + drone.getCode() + "';";
		
		try {
			
			this.conn = dbsource.getConnection();
			updateDrone = this.conn.createStatement();
			updateDrone.executeUpdate(QUERY);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return 0;
	}

}
