package org.sapr.resource;

import javax.sql.DataSource;

public interface IResourceFactory {
	public DataSource getDatabaseResource();
}
