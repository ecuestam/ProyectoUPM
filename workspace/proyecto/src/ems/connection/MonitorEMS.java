package ems.connection;

/*--------------------------------------------------------------------------------------------
 * Clase principal donde recogemos y comprobamos los argumentos que el usuario introduce
 * al lanzar el MonitorEMS. Una vez comprobados los parámetros, si son correctos, esta
 * clase empieza a orquestar la recolección de datos del servidor EMS y su posterior
 * envío al servidor de BBDD
 *-------------------------------------------------------------------------------------------*/

import java.util.ArrayList;
import com.tibco.tibjms.admin.ConnectionInfo;
import com.tibco.tibjms.admin.ConsumerInfo;
import com.tibco.tibjms.admin.ProducerInfo;
import com.tibco.tibjms.admin.QueueInfo;
import com.tibco.tibjms.admin.ServerInfo;
import com.tibco.tibjms.admin.TibjmsAdmin;
import com.tibco.tibjms.admin.TibjmsAdminException;
import com.tibco.tibjms.admin.TopicInfo;
import ems.vo.*;
import db.dao.*;

public class MonitorEMS 
{
	
    /*-----------------------------------------------------------------------
     * Argumentos
     *----------------------------------------------------------------------*/
	String			serverUrl	= null;
	String			userName	= null;
	String			password	= null;
	int				time		= 0;
	
    /*-----------------------------------------------------------------------
     * Variables
     *----------------------------------------------------------------------*/
	TibjmsAdmin		connection	= null;
	
	public MonitorEMS(String[] args) throws InterruptedException 
	{
		
		if (args.length != 8) 
		{
			usage();
		} else
		{
			parseArgs(args);
		
		    /*-----------------------------------------------------------------------
		     * Sacar por pantalla los argumentos 
		     *----------------------------------------------------------------------*/
	        System.err.println("\n--------------------------------------------------------------------------");
	        System.err.println("Datos de conexion al EMS");
	        System.err.println("--------------------------------------------------------------------------");
	        System.err.println("Servidor........................... "+this.serverUrl);
	        System.err.println("Usuario............................ "+this.userName);
	        System.err.println("Tiempo entre recogidas de datos.... "+this.time/1000+" segundos");
	        System.err.println("--------------------------------------------------------------------------\n");
	        
	        try {
				run();
			} catch (TibjmsAdminException e) {
				e.printStackTrace();
			}
		}
	}
	
	/*-----------------------------------------------------------------------
     * Ayuda sobre los parámetros para lanzar el monitor
     *----------------------------------------------------------------------*/
    void usage()
    {
        System.err.println("\nUso: MonitorEMS [opciones]");
        System.err.println("");
        System.err.println("   donde las opciones son:");
        System.err.println("");
        System.err.println(" -server   <URL servidor> 	- URL del servidor EMS");
        System.err.println(" -user     <usuario>		- nombre de usuario");
        System.err.println(" -password <password>  		- password de usuario");
        System.err.println(" -time 	   <segundos>		- tiempo entre recogidas de datos >= 5");
        System.exit(0);
    }
	
    /*-----------------------------------------------------------------------
     * Parseo de los Argumentos introducidos
     *----------------------------------------------------------------------*/
	void parseArgs(String[] args) 
	{	
		int i=0;
		
		while (i < args.length) 
		{
			if (args[i].compareTo("-server")==0)
			{
				this.serverUrl = args[i+1];
				i += 2;
			}
			else
			if (args[i].compareTo("-user")==0)
			{
				this.userName = args[i+1];
				i += 2;
			}
			else
			if (args[i].compareTo("-password")==0)
			{
				this.password = args[i+1];
				i += 2;
			}
			else
			if (args[i].compareTo("-time")==0)
			{
				this.time = Integer.parseInt(args[i+1])*1000;
				if (this.time < 5000)
				{
					this.time = 5000;
				}
				i += 2;
			}
			else
			{
				System.err.println("Parametro desconocido: "+args[i]);
				usage();
			}
		}    
	}
	
    /*-----------------------------------------------------------------------
     * Función principal donde recogemos la información del EMS y la
     * enviamos a la tabla correspondiente en la BBDD
     *----------------------------------------------------------------------*/
	void run() throws TibjmsAdminException, InterruptedException	
	{
        
        TibjmsAdmin connection = new TibjmsAdmin(this.serverUrl, this.userName, this.password);
		
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
			
			ServerDAO serverDB = new ServerDAO();
			serverDB.addServerInfo(infoEMS);
			
			ConsumerDAO consumerDB = new ConsumerDAO();
			for (ConsumerVO consum : consumersList) 
			{
				consumerDB.addConsumerInfo(consum);
			}
			
			ProducerDAO producerDB = new ProducerDAO();
			for (ProducerVO produc : producersList) 
			{
				producerDB.addProducerInfo(produc);
			}
			
			ConnectionDAO connectionDB = new ConnectionDAO();
			for (ConnectionVO conn : connectionsList) 
			{
				connectionDB.addConnectionInfo(conn);
			}
			
			QueueDAO queueDB = new QueueDAO();
			for (QueueVO queue :  queuesList) 
			{
				queueDB.addQueueInfo(queue);
			}
			
			TopicDAO topicDB = new TopicDAO();
			for (TopicVO topic : topicsList) 
			{
				topicDB.addTopicInfo(topic);
			}
			
			Thread.sleep(this.time);
		}
	}
	
	public static void main(String[] args) throws InterruptedException
	{
		new MonitorEMS(args);
	}
}
