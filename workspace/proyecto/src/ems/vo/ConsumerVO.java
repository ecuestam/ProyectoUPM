package ems.vo;

public class ConsumerVO {

	private long id;
	private long createTime;
	private String destinationName;
	private int destinationType;
	private long connectionId;
	private long sessionId;
	private long msgRate;
	private long totalMsgs;
	
	public ConsumerVO(){}
	
	public long getId(){
		return this.id;
	}
	
	public void setId(long id){
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

	public int getDestinationType(){
		return this.destinationType;
	}
	
	public void setDestinationType(int destinationType){
		this.destinationType = destinationType;
	}

	public long getConnectionId(){
		return this.connectionId;
	}
	
	public void setConnectionId(long connectionId){
		this.connectionId = connectionId;
	}

	public long getSessionId(){
		return this.sessionId;
	}
	
	public void setSessionId(long sessionId){
		this.sessionId = sessionId;
	}

	public long getMsgRate(){
		return this.msgRate;
	}
	
	public void setMsgRate(long msgRate){
		this.msgRate = msgRate;
	}

	public long getTotalMsgs(){
		return this.totalMsgs;
	}
	
	public void setTotalMsgs(long totalMsgs){
		this.totalMsgs = totalMsgs;
	}
}
