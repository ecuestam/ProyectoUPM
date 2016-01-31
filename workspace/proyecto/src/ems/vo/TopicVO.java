package ems.vo;

public class TopicVO {
	
	private String name;
	private long pendingMsgCount;
	private long pendingMsgSize;
	private int suscribersCount;
	private int consumersCount;
	private long inTotalMsgs;
	private long outTotalMsgs;
	private long inMsgRate;
	private long outMsgRate;
	
	public TopicVO(){}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}

	public long getPendingMsgCount(){
		return this.pendingMsgCount;
	}
	
	public void setPendingMsgCount(long pendingMsgCount){
		this.pendingMsgCount = pendingMsgCount;
	}

	public long getPendingMsgSize(){
		return this.pendingMsgSize;
	}
	
	public void setPendingMsgSize(long pendingMsgSize){
		this.pendingMsgSize = pendingMsgSize;
	}

	public int getSuscribersCount(){
		return this.suscribersCount;
	}
	
	public void setSuscribersCount(int suscribersCount){
		this.suscribersCount = suscribersCount;
	}
		
	public int getConsumersCount(){
		return this.consumersCount;
	}
	
	public void setConsumersCount(int consumersCount){
		this.consumersCount = consumersCount;
	}

	public long getInTotalMsgs(){
		return this.inTotalMsgs;
	}
	
	public void setInTotalMsgs(long inTotalMsgs){
		this.inTotalMsgs = inTotalMsgs;
	}

	public long getOutTotalMsgs(){
		return this.outTotalMsgs;
	}
	
	public void setOutTotalMsgs(long outTotalMsgs){
		this.outTotalMsgs = outTotalMsgs;
	}

	public long getInMsgRate(){
		return this.inMsgRate;
	}
	
	public void setInMsgRate(long inMsgRate){
		this.inMsgRate = inMsgRate;
	}

	public long getOutMsgRate(){
		return this.outMsgRate;
	}
	
	public void setOutMsgRate(long outMsgRate){
		this.outMsgRate = outMsgRate;
	}

}
