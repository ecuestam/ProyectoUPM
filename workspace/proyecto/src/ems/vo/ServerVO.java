package ems.vo;

public class ServerVO {
	
	// Attributes
	private int connectionCount;
	private int consumerCount;
	private int diskReadRate;
	private int diskWriteRate;
	private int inboundBytesRate;
	private int inboundMsgCount;
	private int inboundMsgRate;
	private float msgMem;
	private int outboundMsgCount;
	private int outboundMsgRate;
	private int pendingMsgCount;
	private int pendingMsgSize;
	private int producerCount;
	private int queueCount;
	private int sessionCount;
	private int topicCount;
	private int upTime;
	private String url;
	
	public ServerVO(){}
	
	public int getConnectionCount(){
		return this.connectionCount;
	}
	
	public void setConnectionCount(int connectionCount){
		this.connectionCount = connectionCount;
	}
	
	public int getConsumerCount(){
		return this.consumerCount;
	}
	
	public void setConsumerCount(int consumerCount){
		this.consumerCount = consumerCount;
	}
	
	public int getDiskReadRate(){
		return this.diskReadRate;
	}
	
	public void setDiskReadRate(int diskReadRate){
		this.diskReadRate = diskReadRate;
	}
	
	public int getDiskWriteRate(){
		return this.diskWriteRate;
	}
	
	public void setDiskWriteRate(int diskWriteRate){
		this.diskWriteRate = diskWriteRate;
	}
	
	public int getInboundBytesRate(){
		return this.inboundBytesRate;
	}
	
	public void setInboundBytesRate(int inboundBytesRate){
		this.inboundBytesRate = inboundBytesRate;
	}
	
	public int getInboundMsgCount(){
		return this.inboundMsgCount;
	}
	
	public void setInboundMsgCount(int inboundMsgCount){
		this.inboundMsgCount = inboundMsgCount;
	}
	
	public int getInboundMsgRate(){
		return this.inboundMsgRate;
	}
	
	public void setInboundMsgRate(int inboundMsgRate){
		this.inboundMsgRate = inboundMsgRate;
	}
	
	public float getMsgMem(){
		return this.msgMem;
	}
	
	public void setMsgMem(float msgMem){
		this.msgMem = msgMem;
	}
	
	public int getOutboundMsgCount(){
		return this.outboundMsgCount;
	}
	
	public void setOutboundMsgCount(int outboundMsgCount){
		this.outboundMsgCount = outboundMsgCount;
	}
	
	public int getOutboundMsgRate(){
		return this.outboundMsgRate;
	}
	
	public void setOutboundMsgRate(int outboundMsgRate){
		this.outboundMsgRate = outboundMsgRate;
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
	
	public int getProducerCount(){
		return this.producerCount;
	}
	
	public void setProducerCount(int producerCount){
		this.producerCount = producerCount;
	}
	
	public int getQueueCount(){
		return this.queueCount;
	}
	
	public void setQueueCount(int queueCount){
		this.queueCount = queueCount;
	}
	
	public int getSessionCount(){
		return this.sessionCount;
	}
	
	public void setSessionCount(int sessionCount){
		this.sessionCount = sessionCount;
	}
	
	public int getTopicCount(){
		return this.topicCount;
	}
	
	public void setTopicCount(int topicCount){
		this.topicCount = topicCount;
	}
	
	public int getUpTime(){
		return this.upTime;
	}
	
	public void setUpTime(int upTime){
		this.upTime = upTime;
	}
	
	public String getUrl(){
		return this.url;
	}
	
	public void setUUrl(String url){
		this.url = url;
	}

}
