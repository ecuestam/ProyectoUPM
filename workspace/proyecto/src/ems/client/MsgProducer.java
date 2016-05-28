package ems.client;

/*----------------------------------------------------------------------------------
 * Esta clase publica mensajes en un destino determinado, ya sea una cola o un
 * topic
 *
 * Uso:  java MsgProducer [opciones]
 *
 *    donde las opciones son:
 *
 *   -server    <URL servidor>
 *   -user      <usuario>
 *   -password  <password>
 *   -topic     <nombre topic>
 *   -queue     <nombre cola>
 *   [-repeat   <num envios>]
 *   [-time     <segundos>]
 *
 *---------------------------------------------------------------------------------*/

import java.util.*;
import javax.jms.*;

public class MsgProducer
{
    /*-----------------------------------------------------------------------
     * Argumentos
     *----------------------------------------------------------------------*/
    String          serverUrl    = null;
    String          userName     = null;
    String          password     = null;
    String          name         = null;
    int				time         = 0;
    int				repeat       = 1;
    Vector<String>  data         = new Vector<String>();
    boolean         useTopic     = true;

    /*-----------------------------------------------------------------------
     * Variables
     *----------------------------------------------------------------------*/
    Connection      connection   = null;
    Session         session      = null;
    MessageProducer msgProducer  = null;
    Destination     destination  = null;

    public MsgProducer(String[] args)
    {
    	
		if (args.length < 9) 
		{
			usage();
		} else
		{
	        parseArgs(args);
	
		    /*-----------------------------------------------------------------------
		     * Sacar por pantalla los argumentos 
		     *----------------------------------------------------------------------*/
	        System.err.println("\n--------------------------------------------------------------------------");
	        System.err.println("Cliente de EMS consumidor de mensajes");
	        System.err.println("--------------------------------------------------------------------------");
	        System.err.println("Servidor........................... "+this.serverUrl);
	        System.err.println("Usuario............................ "+this.userName);
	        System.err.println("Destino............................ "+this.name);
	        System.err.println("Numero de envios................... "+this.repeat);
	        System.err.println("Tiempo entre envios................ "+this.time+" segundos");
	        System.err.println("Mensajes........................... ");
	        for(int i=0;i<data.size();i++)
	        {
	            System.err.println(data.elementAt(i));
	        }
	        System.err.println("--------------------------------------------------------------------------\n");
	
	        try {
	            run();
	        } catch (JMSException e) {
	            e.printStackTrace();
	        }
		}
    }

    /*-----------------------------------------------------------------------
     * Ayuda sobre los parámetros para lanzar el productor que conecta al
     * servidor EMS para enviar los mensajes a una cola/topic
     *----------------------------------------------------------------------*/
    private void usage()
    {
        System.err.println("\nUso: java -jar MsgProducer [opciones]");
        System.err.println("                        <mensaje de texto 1>");
        System.err.println("                       [<mensaje de texto 2>] ...");
        System.err.println("");
        System.err.println(" las opciones son:");
        System.err.println("");
        System.err.println("   -server     <URL servidor>        - URL del servidor EMS");
        System.err.println("   -user       <usuario>             - nombre de usuario");
        System.err.println("   -password   <password>            - password de usuario");
        System.err.println("   -topic      <nombre topic>        - nombre del topic");
        System.err.println("   -queue      <nombre cola>         - nombre de la cola");
        System.err.println("   [-repeat    <num envios>]         - numero de veces que se envian los mensajes");
        System.err.println("   [-time      <segundos>]           - tiempo entre envios de mensajes");
        System.err.println("");
        System.exit(0);
    }

    /*-----------------------------------------------------------------------
     * Parseo de los Argumentos introducidos
     *----------------------------------------------------------------------*/
    void parseArgs(String[] args)
    {
        int i=0;

        while(i < args.length)
        {
            if (args[i].compareTo("-server")==0)
            {
                serverUrl = args[i+1];
                i += 2;
            }
            else
            if (args[i].compareTo("-topic")==0)
            {
                name = args[i+1];
                i += 2;
            }
            else
            if (args[i].compareTo("-queue")==0)
            {
                name = args[i+1];
                i += 2;
                useTopic = false;
            }
            else
            if (args[i].compareTo("-user")==0)
            {
                userName = args[i+1];
                i += 2;
            }
            else
            if (args[i].compareTo("-password")==0)
            {
                password = args[i+1];
                i += 2;
            }
            else
            if (args[i].compareTo("-time")==0)
            {
                time = Integer.parseInt(args[i+1]);
                i += 2;
            }
            else
            if (args[i].compareTo("-repeat")==0)
            {
                repeat = Integer.parseInt(args[i+1]);
                i += 2;
            }
            else
            {
                data.addElement(args[i]);
                i++;
            }
        }
    }
    
    /*-----------------------------------------------------------------------
     * Método donde se crea la conexión con el servidor EMS y se
     * conecta un productor a un destino, ya sea una cola o un topic,
     * para publicar mensajes
     *----------------------------------------------------------------------*/
    void run()
    	throws JMSException
    {

        TextMessage msg;
        int         i;
        int			cont;

        if (data.size() == 0)
        {
            System.err.println("***Error: debe especificar al menos un mensaje de texto\n");
            usage();
        }

        System.err.println("Publicando al destino '"+name+"'\n");

        ConnectionFactory factory = new com.tibco.tibjms.TibjmsConnectionFactory(serverUrl);
        
        /* crear la conexión */
        connection = factory.createConnection(userName,password);

        /* crear la sesión */
        session = connection.createSession(false,javax.jms.Session.AUTO_ACKNOWLEDGE);

        /* crear el destino (cola o topic) */
        if(useTopic)
            destination = session.createTopic(name);
        else
            destination = session.createQueue(name);

        /* crear el productor */
        msgProducer = session.createProducer(null);

        /* publicar mensajes */
        for (cont = 0; cont<repeat; cont++)
        {
        	for (i = 0; i<data.size(); i++)
        	{
                /* generar mensaje de texto */
                msg = session.createTextMessage();

                /* añadir mensaje de texto */
                msg.setText((String)data.elementAt(i));

                /* publicar mensaje */
                msgProducer.send(destination, msg);

                System.err.println("Published message: "+data.elementAt(i));
            }
        	/* esperar tiempo establecido entre el envío de mensajes */
        	if ((cont < repeat) && (time > 0)){
        		try
        		{
        			Thread.sleep(time * 1000);
        		} catch (InterruptedException ie) 
        		{
        			System.exit(-1);
        		}
        	}
        }

        /* cerrar la conexión */
        connection.close();
    }

    /*-----------------------------------------------------------------------
     * Método principal
     *----------------------------------------------------------------------*/
    public static void main(String[] args)
    {
        new MsgProducer(args);
    }
}
