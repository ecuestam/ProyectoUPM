package ems.connection;

import java.util.ArrayList;

import com.tibco.tibjms.admin.ConnectionInfo;
import com.tibco.tibjms.admin.ConsumerInfo;
import com.tibco.tibjms.admin.FileStoreInfo;
import com.tibco.tibjms.admin.ProducerInfo;
import com.tibco.tibjms.admin.QueueInfo;
import com.tibco.tibjms.admin.ServerInfo;
import com.tibco.tibjms.admin.StoreInfo;
import com.tibco.tibjms.admin.TibjmsAdmin;
import com.tibco.tibjms.admin.TibjmsAdminException;
import com.tibco.tibjms.admin.TopicInfo;

import ems.vo.*;

public class DataCollect {
	
	/*-----------------------------------------------------------------------
     * Parameters
     *----------------------------------------------------------------------*/
	String			serverUrl	= null;
	String			userName	= null;
	String			password	= null;
	
    /*-----------------------------------------------------------------------
     * Variables
     *----------------------------------------------------------------------*/
	TibjmsAdmin		connection	= null;
	
	
	public DataCollect() {}
	
	public ServerVO getDataServer (ServerInfo infoServer) {
		// ServerInfo infoServer = connection.getInfo();
		// Creamos un objeto ServerVO y recogemos todos los datos
		ServerVO objectServer = new ServerVO();
		objectServer.setConnectionCount(infoServer.getConnectionCount());
		objectServer.setConsumerCount(infoServer.getConsumerCount());
		objectServer.setDiskReadRate(infoServer.getDiskReadRate());
		objectServer.setDiskWriteRate(infoServer.getDiskReadRate());
		objectServer.setInboundBytesRate(infoServer.getInboundBytesRate());
		objectServer.setInboundMsgCount(infoServer.getInboundMessageCount());
		objectServer.setInboundMsgRate(infoServer.getInboundMessageRate());
		objectServer.setMsgMem(infoServer.getMsgMem());
		objectServer.setOutboundMsgCount(infoServer.getOutboundMessageCount());
		objectServer.setOutboundMsgRate(infoServer.getOutboundMessageRate());
		objectServer.setPendingMsgCount(infoServer.getPendingMessageCount());
		objectServer.setPendingMsgSize(infoServer.getPendingMessageSize());
		objectServer.setProducerCount(infoServer.getProducerCount());
		objectServer.setQueueCount(infoServer.getQueueCount());
		objectServer.setSessionCount(infoServer.getSessionCount());
		objectServer.setTopicCount(infoServer.getTopicCount());
		objectServer.setUpTime(infoServer.getUpTime());
		objectServer.setUrl(infoServer.getURL());
		return objectServer;	
	}
	
	public ArrayList<ConnectionVO> getDataConnections (ConnectionInfo[] connections) {
		// Creamos una Lista de objetos ConnectionVO y añadimos todos los datos de cada conexión
		ArrayList<ConnectionVO> connectionsList = new ArrayList<ConnectionVO>();
		//ConnectionInfo[] connections = connection.getConnections();
		for (ConnectionInfo conn : connections) {
			ConnectionVO objectConnection = new ConnectionVO();
			objectConnection.setAddress(conn.getAddress());
			objectConnection.setConsumerCount(conn.getConsumerCount());
			objectConnection.setHost(conn.getHost());
			objectConnection.setId(conn.getID());
			objectConnection.setProducerCount(conn.getProducerCount());
			objectConnection.setSessionCount(conn.getSessionCount());
			objectConnection.setStartTime(conn.getStartTime());
			objectConnection.setType(conn.getType());
			objectConnection.setUpTime(conn.getUpTime());
			objectConnection.setUsername(conn.getUserName());
			connectionsList.add(objectConnection);
		}
		return connectionsList;
	}
	
	public ArrayList<ConsumerVO> getDataConsumers (ConsumerInfo[] consumers) {
		// Creamos una Lista de objetos ConsumerVO y añadimos todos los datos de cada consumidor
		ArrayList<ConsumerVO> consumersList = new ArrayList<ConsumerVO>();
		//ConsumerInfo[] consumers = connection.getConsumers();
		for (ConsumerInfo consumer : consumers) {
			ConsumerVO objectConsumer = new ConsumerVO();
			objectConsumer.setConnectionId(consumer.getConnectionID());
			objectConsumer.setCreateTime(consumer.getCreateTime());
			objectConsumer.setDestinationName(consumer.getDestinationName());
			objectConsumer.setDestinationType(consumer.getDestinationType());
			objectConsumer.setId(consumer.getID());
			objectConsumer.setSessionId(consumer.getSessionID());
			objectConsumer.setMsgRate(consumer.getStatistics().getMessageRate());
			objectConsumer.setTotalMsgs(consumer.getStatistics().getTotalMessages());
			consumersList.add(objectConsumer);
		}
		return consumersList;
	}
	
	public ArrayList<ProducerVO> getDataProducers (ProducerInfo[] producers) {
		// Creamos una Lista de objetos ProducerVO y añadimos todos los datos de cada productor
		ArrayList<ProducerVO> producersList = new ArrayList<ProducerVO>();
		//ProducerInfo[] producers = connection.getProducersStatistics();
		for (ProducerInfo producer : producers) {
			ProducerVO objectProducer = new ProducerVO();
			objectProducer.setConnectionId(producer.getConnectionID());
			objectProducer.setCreateTime(producer.getCreateTime());
			objectProducer.setDestinationName(producer.getDestinationName());
			objectProducer.setDestinationType(producer.getDestinationType());
			objectProducer.setId(producer.getID());
			objectProducer.setMsgRate(producer.getStatistics().getMessageRate());
			objectProducer.setSessionId(producer.getSessionID());
			objectProducer.setTotalMsgs(producer.getStatistics().getTotalMessages());
			producersList.add(objectProducer);
		}
		return producersList;
	}
	
	public ArrayList<QueueVO> getDataQueues (QueueInfo[] queues) {
		// Creamos una Lista de objetos QueueVO y añadimos todos los datos de cada cola
		ArrayList<QueueVO> queuesList = new ArrayList<QueueVO>();
		//QueueInfo[] queues = connection.getQueues();
		for (QueueInfo queue : queues) {
			QueueVO objectQueue = new QueueVO();
			objectQueue.setInMsgRate(queue.getInboundStatistics().getMessageRate());
			objectQueue.setInTotalMsgs(queue.getInboundStatistics().getTotalMessages());
			objectQueue.setName(queue.getName());
			objectQueue.setOutMsgRate(queue.getOutboundStatistics().getMessageRate());
			objectQueue.setOutTotalMsgs(queue.getOutboundStatistics().getTotalMessages());
			objectQueue.setPendingMsgCount(queue.getPendingMessageCount());
			objectQueue.setPendingMsgSize(queue.getPendingMessageSize());
			objectQueue.setConsumersCount(queue.getConsumerCount());
			queuesList.add(objectQueue);
		}
		return queuesList;
	}
	
	public ArrayList<TopicVO> getDataTopics (TopicInfo[] topics) {
		// Creamos una Lista de objetos QueueVO y añadimos todos los datos de cada cola
		ArrayList<TopicVO> topicsList = new ArrayList<TopicVO>();
		//TopicInfo[] topics = connection.getTopics();
		for (TopicInfo topic : topics) {
			TopicVO objectTopic = new TopicVO();
			objectTopic.setInMsgRate(topic.getInboundStatistics().getMessageRate());
			objectTopic.setInTotalMsgs(topic.getInboundStatistics().getTotalMessages());
			objectTopic.setName(topic.getName());
			objectTopic.setOutMsgRate(topic.getOutboundStatistics().getMessageRate());
			objectTopic.setOutTotalMsgs(topic.getOutboundStatistics().getTotalMessages());
			objectTopic.setPendingMsgCount(topic.getPendingMessageCount());
			objectTopic.setPendingMsgSize(topic.getPendingMessageSize());
			objectTopic.setSuscribersCount(topic.getSubscriberCount());
			objectTopic.setConsumersCount(topic.getConsumerCount());
			topicsList.add(objectTopic);
		}
		return topicsList;
		
	}

	public ArrayList<StoreVO> getDataStores (String[] storesName) throws TibjmsAdminException {
		// Creamos una Lista de objetos StoreVO y añadimos todos los datos de cada store
		ArrayList<StoreVO> storesList = new ArrayList<StoreVO>();
		TibjmsAdmin	connection	= null;
		FileStoreInfo infoFile = null;
		//String[] storesName = connection.getStores();
		for (String storeName : storesName) {
			StoreInfo store = connection.getStoreInfo(storeName);
			StoreVO objectStore = new StoreVO();
			// Revisar Fragmentation y FileName (FileStoreInfo)
			objectStore.setFileSize(store.getFileSize());
			objectStore.setFreeSpace(store.getFreeSpace());
			objectStore.setMsgCount(store.getMsgCount());
			objectStore.setMsgSize(store.getMsgBytes());
			objectStore.setName(storeName);
			objectStore.setUsedSpace(store.getUsedSpace());
			storesList.add(objectStore);
		}
		return storesList;
	}
}
