package ems.connection;

import com.tibco.tibjms.admin.ServerInfo;
import com.tibco.tibjms.admin.TibjmsAdmin;
import com.tibco.tibjms.admin.TibjmsAdminException;

import ems.vo.Server;

public class DataCollect {
	
	/*-----------------------------------------------------------------------
     * Parameters
     *----------------------------------------------------------------------*/
	String			serverUrl	= null;
	String			userName	= null;
	String			password	= null;
	
    /*-----------------------------------------------------------------------
     * Variables
     *----------------------------------------------------------------------*/
	TibjmsAdmin		connection	= null;
	
	
	public DataCollect() {
		
		try {
			ServerInfo infoServer = connection.getInfo();
			
			Server objectServer = new Server();
			objectServer.setConnectionCount(infoServer.getConnectionCount());
			objectServer.setConsumerCount(infoServer.getConsumerCount());
			objectServer.setDiskReadRate(infoServer.getDiskReadRate());
			
		} catch (TibjmsAdminException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
