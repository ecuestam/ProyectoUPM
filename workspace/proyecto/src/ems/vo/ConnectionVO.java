package ems.vo;

public class ConnectionVO {
	
	private long id;
	private String type;
	private String host;
	private String address;
	private int consumerCount;
	private int producerCount;
	private int sessionCount;
	private long startTime;
	private long upTime;
	private String username;

	public ConnectionVO(){}
	

	public long getId(){
		return this.id;
	}
	
	public void setId(long id){
		this.id = id;
	}

	public String getType(){
		return this.type;
	}
	
	public void setType(String type){
		this.type = type;
	}


	public String getHost(){
		return this.host;
	}
	
	public void setHost(String host){
		this.host = host;
	}


	public String getAddress(){
		return this.address;
	}
	
	public void setAddress(String address){
		this.address = address;
	}

	public int getConsumerCount(){
		return this.consumerCount;
	}
	
	public void setConsumerCount(int consumerCount){
		this.consumerCount = consumerCount;
	}


	public int getProducerCount(){
		return this.producerCount;
	}
	
	public void setProducerCount(int producerCount){
		this.producerCount = producerCount;
	}


	public int getSessionCount(){
		return this.sessionCount;
	}
	
	public void setSessionCount(int sessionCount){
		this.sessionCount = sessionCount;
	}


	public long getStartTime(){
		return this.startTime;
	}
	
	public void setStartTime(long startTime){
		this.startTime = startTime;
	}
	
	public long getUpTime(){
		return this.upTime;
	}
	
	public void setUpTime(long upTime){
		this.upTime = upTime;
	}

	public String getUsername(){
		return this.username;
	}
	
	public void setUsername(String username){
		this.username = username;
	}
	
}
