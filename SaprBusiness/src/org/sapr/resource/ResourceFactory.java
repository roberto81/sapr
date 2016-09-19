package org.sapr.resource;

import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ResourceFactory implements IResourceFactory {
	
	Context ctx = null;
	Hashtable<String, String> ht;
	DataSource dataSource;
	
	public ResourceFactory() {
		// TODO Auto-generated constructor stub
		this.ht = new Hashtable<String, String>();
		
		ht.put(Context.INITIAL_CONTEXT_FACTORY,
				"weblogic.jndi.WLInitialContextFactory");
		ht.put(Context.PROVIDER_URL,
				"t3://localhost:7001");
		
	}

	@Override
	public DataSource getDatabaseResource() {
		
		try {
			this.ctx = new InitialContext(this.ht);
			this.dataSource = (DataSource) ctx.lookup("saprsystem");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return this.dataSource;
	}

}
