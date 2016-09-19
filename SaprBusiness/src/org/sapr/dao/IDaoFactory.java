package org.sapr.dao;

public interface IDaoFactory {
	IUserDao getUserDao();
	IDroneDao getDroneDao();
}
