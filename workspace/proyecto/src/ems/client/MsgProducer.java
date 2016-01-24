package ems.client;

/*
 * Esta clase publica mensajes en un destino determinado
 *
 * Uso:  java MsgProducer  [opciones]
 *                       <mensaje-text1>
 *                       ...
 *                       <mensaje-textN>
 *
 * las opciones son:
 *
 *   -server    <url-servidor>
 *   -user      <nombre-usuario>
 *   -password  <password>
 *   -topic     <nombre-topic>
 *   -queue     <nombre-cola>
 *   -numRepeat	<numero-repeticiones-mensajes>
 *   -timeSleep <tiempo-entre-repetiones-en-segundos>
 *
 */

import java.util.*;

import javax.jms.*;

public class MsgProducer
{
    /*-----------------------------------------------------------------------
     * Parametros
     *----------------------------------------------------------------------*/
    String          serverUrl    = null;
    String          userName     = null;
    String          password     = null;
    String          name         = null;
    int				timeSleep	 = 0;
    int				numRepeat	 = 0;
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
        parseArgs(args);

        /* print parameters */
        System.err.println("\n------------------------------------------------------------------------");
        System.err.println("Servidor........................ "+((serverUrl != null)?serverUrl:"localhost"));
        System.err.println("Usuario......................... "+((userName != null)?userName:"(null)"));
        System.err.println("Destino.................. "+name);
        System.err.println("Mensaje.................. ");
        for(int i=0;i<data.size();i++)
        {
            System.err.println(data.elementAt(i));
        }
        System.err.println("------------------------------------------------------------------------\n");

        try 
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

            connection = factory.createConnection(userName,password);

            /* create the session */
            session = connection.createSession(false,javax.jms.Session.AUTO_ACKNOWLEDGE);

            /* create the destination */
            if(useTopic)
                destination = session.createTopic(name);
            else
                destination = session.createQueue(name);

            /* create the producer */
            msgProducer = session.createProducer(null);

            /* publish messages */
            for (cont = 0; cont<numRepeat; cont++){
            	for (i = 0; i<data.size(); i++){
	                /* create text message */
	                msg = session.createTextMessage();
	
	                /* set message text */
	                msg.setText((String)data.elementAt(i));
	
	                /* publish message */
	                msgProducer.send(destination, msg);
	
	                System.err.println("Published message: "+data.elementAt(i));
	            }
            	if ((cont < numRepeat) && (timeSleep > 0)){
            		try{
            			Thread.sleep(timeSleep * 1000);
            		} catch (InterruptedException ie) {
            			System.exit(-1);
            		}
            	}
            }

            /* close the connection */
            connection.close();
        } 
        catch (JMSException e) 
        {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    /*-----------------------------------------------------------------------
    * usage
    *----------------------------------------------------------------------*/
    private void usage()
    {
        System.err.println("\nUso: java MsgProducer [options]");
        System.err.println("                        <message-text-1>");
        System.err.println("                        [<message-text-2>] ...");
        System.err.println("\n");
        System.err.println("   las opciones son:");
        System.err.println("");
        System.err.println("   -server     <url-servidor>");
        System.err.println("   -user       <nombre-usuario>");
        System.err.println("   -password   <password>");
        System.err.println("   -topic      <nombre-topic>");
        System.err.println("   -queue      <nombre-cola>");
        System.err.println("   -numRepeat  [<numero-repeticiones-mensajes>]");
        System.err.println("   -timeSleep  [<tiempo-entre-repetiones-en-segundos>]");
        System.exit(0);
    }

    /*-----------------------------------------------------------------------
     * parseo de Argumentos
     *----------------------------------------------------------------------*/
    void parseArgs(String[] args)
    {
        int i=0;

        while(i < args.length)
        {
            if (args[i].compareTo("-server")==0)
            {
                if ((i+1) >= args.length) usage();
                serverUrl = args[i+1];
                i += 2;
            }
            else
            if (args[i].compareTo("-topic")==0)
            {
                if ((i+1) >= args.length) usage();
                name = args[i+1];
                i += 2;
            }
            else
            if (args[i].compareTo("-queue")==0)
            {
                if ((i+1) >= args.length) usage();
                name = args[i+1];
                i += 2;
                useTopic = false;
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
            if (args[i].compareTo("-timeSleep")==0)
            {
                if ((i+1) >= args.length) usage();
                timeSleep = Integer.parseInt(args[i+1]);
                i += 2;
            }
            else
            if (args[i].compareTo("-numRepeat")==0)
            {
                if ((i+1) >= args.length) usage();
                numRepeat = Integer.parseInt(args[i+1]);
                i += 2;
            }
            else
            if (args[i].compareTo("-help")==0)
            {
                usage();
            }
            else
            {
                data.addElement(args[i]);
                i++;
            }
        }
    }

    /*-----------------------------------------------------------------------
     * Metodo principal
     *----------------------------------------------------------------------*/
    public static void main(String[] args)
    {
        new MsgProducer(args);
    }
}
