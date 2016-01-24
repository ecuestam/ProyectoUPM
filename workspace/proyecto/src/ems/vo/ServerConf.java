package ems.vo;

public class ServerConf {
	
	private int maxClientMsgSize;
	private int maxConnections;
	private int maxMsgMemory;
	private long startTime;
	private String name;
	private String versionInfo;
	
	public ServerConf(){}
	
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

	public long getStartTime(){
		return this.startTime;
	}
	
	public void setStartTime(long startTime){
		this.startTime = startTime;
	}

	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}

	public String getVersionInfo(){
		return this.versionInfo;
	}
	
	public void setVersionInfo(String versionInfo){
		this.versionInfo = versionInfo;
	}

}
