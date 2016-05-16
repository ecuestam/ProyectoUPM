package ems.vo;

/*-----------------------------------------------------------------
 * Clase donde definimos tanto la estructura como los métodos
 * get y set de los objetos que van a contener toda la
 * información general del servidor EMS
 *-----------------------------------------------------------------*/

public class ServerVO {
	
	/*--------------------------------------------------------------
	 * Atributos de los objetos ServerVO
	 *-------------------------------------------------------------*/
	private int connectionCount;
	private int consumerCount;
	private long diskReadRate;
	private long diskWriteRate;
	private long inboundBytesRate;
	private long inboundMsgCount;
	private long inboundMsgRate;
	private long outboundMsgCount;
	private long outboundMsgRate;
	private long pendingMsgCount;
	private long pendingMsgSize;
	private int producerCount;
	private int queueCount;
	private int sessionCount;
	private int topicCount;
	private long upTime;
	private float msgMem;
	private String url;
	
	public ServerVO(){}
	
	/*--------------------------------------------------------------
	 * Definición de los métodos get y set que nos permiten
	 * acceder a los atributos de los objetos ServerVO
	 *-------------------------------------------------------------*/
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
	
	public long getDiskReadRate(){
		return this.diskReadRate;
	}
	
	public void setDiskReadRate(long diskReadRate){
		this.diskReadRate = diskReadRate;
	}
	
	public long getDiskWriteRate(){
		return this.diskWriteRate;
	}
	
	public void setDiskWriteRate(long diskWriteRate){
		this.diskWriteRate = diskWriteRate;
	}
	
	public long getInboundBytesRate(){
		return this.inboundBytesRate;
	}
	
	public void setInboundBytesRate(long inboundBytesRate){
		this.inboundBytesRate = inboundBytesRate;
	}
	
	public long getInboundMsgCount(){
		return this.inboundMsgCount;
	}
	
	public void setInboundMsgCount(long inboundMsgCount){
		this.inboundMsgCount = inboundMsgCount;
	}
	
	public long getInboundMsgRate(){
		return this.inboundMsgRate;
	}
	
	public void setInboundMsgRate(long inboundMsgRate){
		this.inboundMsgRate = inboundMsgRate;
	}
	
	public long getOutboundMsgCount(){
		return this.outboundMsgCount;
	}
	
	public void setOutboundMsgCount(long outboundMsgCount){
		this.outboundMsgCount = outboundMsgCount;
	}
	
	public long getOutboundMsgRate(){
		return this.outboundMsgRate;
	}
	
	public void setOutboundMsgRate(long outboundMsgRate){
		this.outboundMsgRate = outboundMsgRate;
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
	
	public long getUpTime(){
		return this.upTime;
	}
	
	public void setUpTime(long upTime){
		this.upTime = upTime;
	}
	
	public float getMsgMem(){
		return this.msgMem;
	}
	
	public void setMsgMem(float msgMem){
		this.msgMem = msgMem;
	}
	
	public String getUrl(){
		return this.url;
	}
	
	public void setUrl(String url){
		this.url = url;
	}

}
