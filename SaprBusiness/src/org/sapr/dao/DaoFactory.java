package org.sapr.dao;

public class DaoFactory implements IDaoFactory {

	private IUserDao userDao = new UserDao();
	private IDroneDao droneDao = new DroneDao();
	
	@Override
	public IUserDao getUserDao() {
		return this.userDao;
	}

	@Override
	public IDroneDao getDroneDao() {
		return this.droneDao;
	}

}
