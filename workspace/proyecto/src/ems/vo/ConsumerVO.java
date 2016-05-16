package ems.vo;

/*-----------------------------------------------------------------
 * Clase donde definimos tanto la estructura como los métodos
 * get y set de los objetos que van a contener toda la
 * información sobre los consumidores del servidor EMS
 *-----------------------------------------------------------------*/

public class ConsumerVO {

	/*--------------------------------------------------------------
	 * Atributos de los objetos ConsumerVO
	 *-------------------------------------------------------------*/
	private long id;
	private long createTime;
	private String destinationName;
	private int destinationType;
	private long connectionId;
	private long sessionId;
	private long msgRate;
	private long totalMsgs;
	
	public ConsumerVO(){}
	
	/*--------------------------------------------------------------
	 * Definición de los métodos get y set que nos permiten
	 * acceder a los atributos de los objetos ConsumerVO
	 *-------------------------------------------------------------*/
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
