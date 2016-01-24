package ems.vo;

public class Store {

	private int fileSize;
	private int freeSpace;
	private int usedSpace;
	private int fragmentation;
	private int msgSize;
	private int msgCount;
	private String name;
	private String fileName;
	
	public Store(){}
	

	public int getFileSize(){
		return this.fileSize;
	}
	
	public void setFileSize(int fileSize){
		this.fileSize = fileSize;
	}

	public int getFreeSpace(){
		return this.freeSpace;
	}
	
	public void setFreeSpace(int freeSpace){
		this.freeSpace = freeSpace;
	}

	public int getUsedSpace(){
		return this.usedSpace;
	}
	
	public void setUsedSpace(int usedSpace){
		this.usedSpace = usedSpace;
	}

	public int getFragmentation(){
		return this.fragmentation;
	}
	
	public void setFragmentation(int fragmentation){
		this.fragmentation = fragmentation;
	}

	public int getMsgSize(){
		return this.msgSize;
	}
	
	public void setMsgSize(int msgSize){
		this.msgSize = msgSize;
	}

	public int getMsgCount(){
		return this.msgCount;
	}
	
	public void setMsgCount(int msgCount){
		this.msgCount = msgCount;
	}

	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}

	public String getFileName(){
		return this.fileName;
	}
	
	public void setFileName(String fileName){
		this.fileName = fileName;
	}
	
}
