package ems.vo;

public class Producer {
	
	private int id;
	private int msgRate;
	private int totalMsg;
	private int connectionId;
	private long createTime;
	private String destinationName;
	private String destinationType;
	
	public Producer(){}
	
	public int getId(){
		return this.id;
	}
	
	public void setId(int id){
		this.id = id;
	}

	public int getMsgRate(){
		return this.msgRate;
	}
	
	public void setMsgRate(int msgRate){
		this.msgRate = msgRate;
	}

	public int getTotalMsg(){
		return this.totalMsg;
	}
	
	public void setTotalMsg(int totalMsg){
		this.totalMsg = totalMsg;
	}

	public int getConnectionId(){
		return this.connectionId;
	}
	
	public void setConnectionId(int connectionId){
		this.connectionId = connectionId;
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

}
