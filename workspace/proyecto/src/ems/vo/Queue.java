package ems.vo;

public class Queue {
	
	private int pendingMsgCount;
	private int pendingMsgSize;
	private int inTotalMsg;
	private int outTotalMsg;
	private int inMsgRate;
	private int outMsgRate;
	private int consumerId;
	private int producerId;
	private String name;
	
	public Queue(){}

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

	public int getInTotalMsg(){
		return this.inTotalMsg;
	}
	
	public void setInTotalMsg(int inTotalMsg){
		this.inTotalMsg = inTotalMsg;
	}

	public int getOutTotalMsg(){
		return this.outTotalMsg;
	}
	
	public void setOutTotalMsg(int outTotalMsg){
		this.outTotalMsg = outTotalMsg;
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

	public int getConsumerId(){
		return this.consumerId;
	}
	
	public void setConsumerId(int consumerId){
		this.consumerId = consumerId;
	}

	public int getProducerId(){
		return this.producerId;
	}
	
	public void setProducerId(int producerId){
		this.producerId = producerId;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void set(String name){
		this.name = name;
	}
	
}
