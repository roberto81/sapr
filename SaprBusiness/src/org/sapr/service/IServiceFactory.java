package org.sapr.service;

public interface IServiceFactory {
	IUserService getUserService();
	IDroneService getDroneService();
}
