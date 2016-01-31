package ems.vo;

public class StoreVO {
	
	private String name;
	private String fileName;
	private long fileSize;
	private long freeSpace;
	private long usedSpace;
	private int fragmentation;
	private long msgSize;
	private long msgCount;
	
	public StoreVO(){}

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
	
	public long getFileSize(){
		return this.fileSize;
	}
	
	public void setFileSize(long fileSize){
		this.fileSize = fileSize;
	}

	public long getFreeSpace(){
		return this.freeSpace;
	}
	
	public void setFreeSpace(long freeSpace){
		this.freeSpace = freeSpace;
	}

	public long getUsedSpace(){
		return this.usedSpace;
	}
	
	public void setUsedSpace(long usedSpace){
		this.usedSpace = usedSpace;
	}

	public int getFragmentation(){
		return this.fragmentation;
	}
	
	public void setFragmentation(int fragmentation){
		this.fragmentation = fragmentation;
	}

	public long getMsgSize(){
		return this.msgSize;
	}
	
	public void setMsgSize(long msgSize){
		this.msgSize = msgSize;
	}

	public long getMsgCount(){
		return this.msgCount;
	}
	
	public void setMsgCount(long msgCount){
		this.msgCount = msgCount;
	}
	
}
