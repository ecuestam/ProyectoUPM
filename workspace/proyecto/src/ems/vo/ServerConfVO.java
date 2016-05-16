package ems.vo;

/*-----------------------------------------------------------------
 * Clase donde definimos tanto la estructura como los métodos
 * get y set de los objetos que van a contener toda la
 * información sobre la configuración del servidor EMS
 *-----------------------------------------------------------------*/

public class ServerConfVO {
	
	/*--------------------------------------------------------------
	 * Atributos de los objetos ServerConfVO
	 *-------------------------------------------------------------*/
	private String name;
	private long startTime;
	private String versionInfo;
	private int maxClientMsgSize;
	private int maxConnections;
	private int maxMsgMemory;
	
	
	public ServerConfVO(){}
	
	/*--------------------------------------------------------------
	 * Definición de los métodos get y set que nos permiten
	 * acceder a los atributos de los objetos ServerConfVO
	 *-------------------------------------------------------------*/
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public long getStartTime(){
		return this.startTime;
	}
	
	public void setStartTime(long startTime){
		this.startTime = startTime;
	}

	public String getVersionInfo(){
		return this.versionInfo;
	}
	
	public void setVersionInfo(String versionInfo){
		this.versionInfo = versionInfo;
	}
	
	public int getMaxClientMsgSize(){
		return this.maxClientMsgSize;
	}
	
	public void setMaxClientMsgSize(int maxClientMsgSize){
		this.maxClientMsgSize = maxClientMsgSize;
	}

	public int getMaxConnections(){
		return this.maxConnections;
	}
	
	public void setMaxConnections(int maxConnections){
		this.maxConnections = maxConnections;
	}

	public int getMaxMsgMemory(){
		return this.maxMsgMemory;
	}
	
	public void setMaxMsgMemory(int maxMsgMemory){
		this.maxMsgMemory = maxMsgMemory;
	}

}
