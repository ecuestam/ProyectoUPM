package ems.vo;

/*-----------------------------------------------------------------
 * Clase donde definimos tanto la estructura como los métodos
 * get y set de los objetos que van a contener toda la
 * información sobre las colas del servidor EMS
 *-----------------------------------------------------------------*/

public class QueueVO {

	/*--------------------------------------------------------------
	 * Atributos de los objetos QueueVO
	 *-------------------------------------------------------------*/
	private String name;
	private int consumersCount;
	private long pendingMsgCount;
	private long pendingMsgSize;
	private long inTotalMsgs;
	private long outTotalMsgs;
	private long inMsgRate;
	private long outMsgRate;
	
	public QueueVO(){}
	
	/*--------------------------------------------------------------
	 * Definición de los métodos get y set que nos permiten
	 * acceder a los atributos de los objetos QueueVO
	 *-------------------------------------------------------------*/
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public int getConsumersCount(){
		return this.consumersCount;
	}
	
	public void setConsumersCount(int consumersCount){
		this.consumersCount = consumersCount;
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

	public long getInTotalMsgs(){
		return this.inTotalMsgs;
	}
	
	public void setInTotalMsgs(long InTotalMsgs){
		this.inTotalMsgs = InTotalMsgs;
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
