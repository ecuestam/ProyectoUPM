package ems.vo;

public class Queue {

	private String name;
	private int producerId;
	private int consumerId;
	private int pendingMsgCount;
	private int pendingMsgSize;
	private int inTotalMsgs;
	private int outTotalMsgs;
	private int inMsgRate;
	private int outMsgRate;
	
	public Queue(){}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}

	public int getProducerId(){
		return this.producerId;
	}
	
	public void setProducerId(int producerId){
		this.producerId = producerId;
	}

	public int getConsumerId(){
		return this.consumerId;
	}
	
	public void setConsumerId(int consumerId){
		this.consumerId = consumerId;
	}

	public int getPendingMsgCount(){
		return this.pendingMsgCount;
	}
	
	public void setPendingMsgCount(int pendingMsgCount){
		this.pendingMsgCount = pendingMsgCount;
	}

	public int getPendingMsgSize(){
		return this.pendingMsgSize;
	}
	
	public void setPendingMsgSize(int pendingMsgSize){
		this.pendingMsgSize = pendingMsgSize;
	}

	public int getInTotalMsgs(){
		return this.inTotalMsgs;
	}
	
	public void setInTotalMsgs(int inTotalMsgs){
		this.inTotalMsgs = inTotalMsgs;
	}

	public int getOutTotalMsgs(){
		return this.outTotalMsgs;
	}
	
	public void setOutTotalMsgs(int outTotalMsgs){
		this.outTotalMsgs = outTotalMsgs;
	}

	public int getInMsgRate(){
		return this.inMsgRate;
	}
	
	public void setInMsgRate(int inMsgRate){
		this.inMsgRate = inMsgRate;
	}

	public int getOutMsgRate(){
		return this.outMsgRate;
	}
	
	public void setOutMsgRate(int outMsgRate){
		this.outMsgRate = outMsgRate;
	}
	
}
