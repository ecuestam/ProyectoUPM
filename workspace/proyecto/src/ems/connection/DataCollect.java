package ems.connection;

/*--------------------------------------------------------------------------------------------
 * En esta clase creamos tantas listas de objetos VO (value object) como elementos queremos
 * monitorizar (a excepción del servidor de datos, que se constituye de un solo elemento VO
 * debido a que a que este elemento no ve afectados sus datos en el tiempo) y las rellenamos
 * con los datos que nos parecen pertinentes de ser mostrados posteriormente.
 *-------------------------------------------------------------------------------------------*/

import java.util.ArrayList;
import com.tibco.tibjms.admin.ConnectionInfo;
import com.tibco.tibjms.admin.ConsumerInfo;
import com.tibco.tibjms.admin.ProducerInfo;
import com.tibco.tibjms.admin.QueueInfo;
import com.tibco.tibjms.admin.ServerInfo;
import com.tibco.tibjms.admin.TopicInfo;

import ems.vo.*;

public class DataCollect {
	
	public DataCollect(){}
	
	/*----------------------------------------------------------------------------------
	 * Creamos un objeto ServerConfVO y recogemos la configuración del servidor EMS
	 *---------------------------------------------------------------------------------*/
	public ServerConfVO getConfServer (ServerInfo confServer)
	{
		ServerConfVO objectConfServer = new ServerConfVO();
		objectConfServer.setMaxClientMsgSize(confServer.getMaxClientMsgSize());
		objectConfServer.setMaxConnections(confServer.getMaxConnections());
		objectConfServer.setMaxMsgMemory(confServer.getMaxMsgMemory());
		objectConfServer.setName(confServer.getServerName());
		objectConfServer.setStartTime(confServer.getStartTime());
		return objectConfServer;
	}
	
	/*----------------------------------------------------------------------------------
	 * Creamos un objeto ServerVO y recogemos todos los datos globales del
	 * propio servidor EMS
	 *---------------------------------------------------------------------------------*/
	public ServerVO getDataServer (ServerInfo infoServer) 
	{
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
	
	/*----------------------------------------------------------------------------------
	 * Creamos una Lista de objetos ConnectionVO y añadimos todos los datos 
	 * de cada conexión del servidor EMS
	 *---------------------------------------------------------------------------------*/
	public ArrayList<ConnectionVO> getDataConnections (ConnectionInfo[] connections) 
	{
		ArrayList<ConnectionVO> connectionsList = new ArrayList<ConnectionVO>();
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
	
	/*----------------------------------------------------------------------------------
	 * Creamos una Lista de objetos ConsumerVO y añadimos todos los datos de cada 
	 * consumidor del servidor EMS
	 *---------------------------------------------------------------------------------*/
	public ArrayList<ConsumerVO> getDataConsumers (ConsumerInfo[] consumers) 
	{
		ArrayList<ConsumerVO> consumersList = new ArrayList<ConsumerVO>();
		for (ConsumerInfo consumer : consumers) {
			ConsumerVO objectConsumer = new ConsumerVO();
			objectConsumer.setConnectionId(consumer.getConnectionID());
			objectConsumer.setCreateTime(consumer.getCreateTime());
			objectConsumer.setDestinationName(consumer.getDestinationName());
			objectConsumer.setDestinationType(consumer.getDestinationType());
			objectConsumer.setId(consumer.getID());
			objectConsumer.setSessionId(consumer.getSessionID());
//			objectConsumer.setMsgRate(consumer.getStatistics().getMessageRate());
//			objectConsumer.setTotalMsgs(consumer.getStatistics().getTotalMessages());
			consumersList.add(objectConsumer);
		}
		return consumersList;
	}
	
	/*----------------------------------------------------------------------------------
	 * Creamos una Lista de objetos ProducerVO y añadimos todos los datos de cada 
	 * productor del servidor EMS
	 *---------------------------------------------------------------------------------*/
	public ArrayList<ProducerVO> getDataProducers (ProducerInfo[] producers) 
	{
		ArrayList<ProducerVO> producersList = new ArrayList<ProducerVO>();
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
	
	/*----------------------------------------------------------------------------------
	 * Creamos una Lista de objetos QueueVO y añadimos todos los datos de cada cola
	 * del servidor EMS
	 *---------------------------------------------------------------------------------*/
	public ArrayList<QueueVO> getDataQueues (QueueInfo[] queues) 
	{
		ArrayList<QueueVO> queuesList = new ArrayList<QueueVO>();
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
	
	/*----------------------------------------------------------------------------------
	 * Creamos una Lista de objetos QueueVO y añadimos todos los datos de cada topic
	 * del servidor EMS
	 *---------------------------------------------------------------------------------*/
	public ArrayList<TopicVO> getDataTopics (TopicInfo[] topics) 
	{
		ArrayList<TopicVO> topicsList = new ArrayList<TopicVO>();
		for (TopicInfo topic : topics) {
			TopicVO objectTopic = new TopicVO();
			objectTopic.setInMsgRate(topic.getInboundStatistics().getMessageRate());
			objectTopic.setInTotalMsgs(topic.getInboundStatistics().getTotalMessages());
			objectTopic.setName(topic.getName());
			objectTopic.setOutMsgRate(topic.getOutboundStatistics().getMessageRate());
			objectTopic.setOutTotalMsgs(topic.getOutboundStatistics().getTotalMessages());
			objectTopic.setPendingMsgCount(topic.getPendingMessageCount());
			objectTopic.setPendingMsgSize(topic.getPendingMessageSize());
			objectTopic.setSubscriberCount(topic.getSubscriberCount());
			objectTopic.setConsumersCount(topic.getConsumerCount());
			topicsList.add(objectTopic);
		}
		return topicsList;	
	}

}
