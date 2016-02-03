package ems.connection;

import java.io.File;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;

import com.tibco.tibjms.admin.ConnectionInfo;
import com.tibco.tibjms.admin.ConsumerInfo;
import com.tibco.tibjms.admin.ProducerInfo;
import com.tibco.tibjms.admin.QueueInfo;
import com.tibco.tibjms.admin.ServerInfo;
import com.tibco.tibjms.admin.StoreInfo;
import com.tibco.tibjms.admin.TibjmsAdmin;
import com.tibco.tibjms.admin.TibjmsAdminException;
import com.tibco.tibjms.admin.TopicInfo;
import ems.vo.*;
import db.dao.*;



public class conexionEMS 
{
	
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
	
	public conexionEMS(String[] args) throws InterruptedException 
	{
		
		parseArgs(args);
		
        /* print parameters */
        System.err.println("\n------------------------------------------------------------------------");
        System.err.println("conexionEMS SAMPLE");
        System.err.println("------------------------------------------------------------------------");
        System.err.println("Server....................... "+((serverUrl != null)?serverUrl:"localhost"));
        System.err.println("User......................... "+((userName != null)?userName:"(null)"));
        System.err.println("------------------------------------------------------------------------\n");
        
        try {
			run();
		} catch (TibjmsAdminException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*-----------------------------------------------------------------------
     * usage
     *----------------------------------------------------------------------*/
    void usage()
    {
        System.err.println("\nUsage: conexionEMS [options]");
        System.err.println("");
        System.err.println("   where options are:");
        System.err.println("");
        System.err.println(" -server   <server URL> - EMS server URL, default is local server");
        System.err.println(" -user     <user name>  - user name, default is null");
        System.err.println(" -password <password>   - password, default is null");
        System.exit(0);
    }
	
    /*-----------------------------------------------------------------------
     * parseArgs
     *----------------------------------------------------------------------*/
	void parseArgs(String[] args) 
	{	
		int i=0;
		
		while (i < args.length) 
		{
			if (args[i].compareTo("-server")==0)
			{
				if ((i+1) >= args.length) usage();
				serverUrl = args[i+1];
				i += 2;
			}
			else
			if (args[i].compareTo("-user")==0)
			{
				if ((i+1) >= args.length) usage();
				userName = args[i+1];
				i += 2;
			}
			else
			if (args[i].compareTo("-password")==0)
			{
				if ((i+1) >= args.length) usage();
				password = args[i+1];
				i += 2;
			}
			else
			if (args[i].compareTo("-help")==0)
			{
				usage();
			}
			else
			{
				System.err.println("Unrecognized parameter: "+args[i]);
				usage();
			}
		}    
	}
	
    /*-----------------------------------------------------------------------
     * run
     *----------------------------------------------------------------------*/
	void run() throws TibjmsAdminException, InterruptedException	
	{
        
        TibjmsAdmin connection = new TibjmsAdmin(serverUrl, userName, password);
		
		while (true) {
		
			ServerVO infoEMS = new ServerVO();
			ServerInfo infoServer = connection.getInfo();
			DataCollect collector = new DataCollect();
			infoEMS = collector.getDataServer(infoServer);
			
			ArrayList<ConnectionVO> connectionsList = new ArrayList<ConnectionVO>();
			ConnectionInfo[] connections = connection.getConnections();
			connectionsList = collector.getDataConnections(connections);
			
			ArrayList<ConsumerVO> consumersList = new ArrayList<ConsumerVO>();
			ConsumerInfo[] consumers = connection.getConsumers();
			consumersList = collector.getDataConsumers(consumers);
			
			ArrayList<ProducerVO> producersList = new ArrayList<ProducerVO>();
			ProducerInfo[] producers = connection.getProducersStatistics();
			producersList = collector.getDataProducers(producers);
			
			ArrayList<QueueVO> queuesList = new ArrayList<QueueVO>();
			QueueInfo[] queues = connection.getQueues();
			queuesList = collector.getDataQueues(queues);
			
			ArrayList<TopicVO> topicsList = new ArrayList<TopicVO>();
			TopicInfo[] topics = connection.getTopics();
			topicsList = collector.getDataTopics(topics);
			
			ArrayList<StoreVO> storesList = new ArrayList<StoreVO>();
			String[] storesName = connection.getStores();
			storesList = collector.getDataStores(storesName);
			
			ServerDAO serverDB = new ServerDAO();
			serverDB.addServerInfo(infoEMS);
			
			ConnectionDAO connectionDB = new ConnectionDAO();
			for (ConnectionVO conn : connectionsList) {
				connectionDB.addConnectionInfo(conn);
			}
			
			ConsumerDAO consumerDB = new ConsumerDAO();
			for (ConsumerVO consum : consumersList) {
				consumerDB.addConsumerInfo(consum);
			}
			
			ProducerDAO producerDB = new ProducerDAO();
			for (ProducerVO produc : producersList) {
				producerDB.addProducerInfo(produc);
			}
			
			QueueDAO queueDB = new QueueDAO();
			for (QueueVO queue :  queuesList) {
				queueDB.addQueueInfo(queue);
			}
			
			TopicDAO topicDB = new TopicDAO();
			for (TopicVO topic : topicsList) {
				topicDB.addTopicInfo(topic);
			}
			
			StoreDAO storeDB = new StoreDAO();
			for (StoreVO store : storesList) {
				storeDB.addStoreInfo(store);
			}
			
			Thread.sleep(5000);
			
		}
		
		
		
		
		//System.out.println(infoServer.);
		/*System.out.println(infoServer.toString());
		System.out.println ("Conexiones: " + String.valueOf(infoServer.getConnectionCount()));
		//System.out.println(info);
		String info = infoServer.toString();
		System.out.println ("Start time: " + infoServer.getStartTime());
		System.out.println("Uptime: " + infoServer.getUpTime());
		StringTokenizer token = new StringTokenizer(info, ";");
		while (token.hasMoreTokens())
		{
			System.out.println(token.nextToken());
		}
/*		int numQueues = infoServer.getQueueCount();
		int contador;
		for (contador=0; contador<numQueues; contador++)
		{
			QueueInfo infoQueue = connection.get
		}*/
		/*QueueInfo[] queues = connection.getQueues();
		for (QueueInfo queue : queues)
		{
			System.out.println("Mensajes pendientes de la cola " + queue.getName() + ": " + queue.getPendingMessageCount());
			System.out.println("Consumidores de la cola " + queue.getName() + ": " + queue.getConsumerCount());
		}
		TopicInfo[] topics = connection.getTopics();
		for (TopicInfo topic : topics)
		{
			//System.out.println(topic.toString());
			System.out.println("Mensajes pendientes del topic " + topic.getName() + ": " + topic.getPendingMessageCount());
		}
		ConnectionInfo[] connections = connection.getConnections();
		for (ConnectionInfo conn : connections)
		{
			System.out.println();
			System.out.println(conn.toString());
		}
		ConsumerInfo[] consumers = connection.getConsumers();
		for (ConsumerInfo consumer : consumers)
		{
			System.out.println();
			System.out.println(consumer.toString());
		}
		ProducerInfo[] producers = connection.getProducersStatistics();
		for (ProducerInfo producer : producers)
		{
			System.out.println();
			System.out.println(producer.toString());
		}
		String[] stores = connection.getStores();
		for (String store : stores)
		{
			System.out.println();
			System.out.println(store);
			StoreInfo infoStore = connection.getStoreInfo(store);
			System.out.println(infoStore.toString());
			//infoStore.ge
		}
		
		long diskSize = new File("/").getTotalSpace();
		System.out.println("Espacio FS: " + diskSize);
	
		long diskFree = new File("/").getFreeSpace();
		System.out.println("Espacio libre FS: " + diskFree);
		*/
		
	}
	
	public static void main(String[] args) throws InterruptedException
	{
		conexionEMS t = new conexionEMS(args);
	}
}
