package ems.vo;

public class Consumer {

	private int id;
	private long createTime;
	private String destinationName;
	private String destinationType;
	private int connectionId;
	private int sessionId;
	private int msgRate;
	private int totalMsgs;
	
	public Consumer(){}
	
	public int getId(){
		return this.id;
	}
	
	public void setId(int id){
		this.id = id;
	}

	public long getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(long createTime){
		this.createTime = createTime;
	}

	public String getDestinationName(){
		return this.destinationName;
	}
	
	public void setDestinationName(String destinationName){
		this.destinationName = destinationName;
	}

	public String getDestinationType(){
		return this.destinationType;
	}
	
	public void setDestinationType(String destinationType){
		this.destinationType = destinationType;
	}

	public int getConnectionId(){
		return this.connectionId;
	}
	
	public void setConnectionId(int connectionId){
		this.connectionId = connectionId;
	}

	public int getSessionId(){
		return this.sessionId;
	}
	
	public void setSessionId(int sessionId){
		this.sessionId = sessionId;
	}

	public int getMsgRate(){
		return this.msgRate;
	}
	
	public void setMsgRate(int msgRate){
		this.msgRate = msgRate;
	}

	public int getTotalMsgs(){
		return this.totalMsgs;
	}
	
	public void setTotalMsgs(int totalMsgs){
		this.totalMsgs = totalMsgs;
	}

}
