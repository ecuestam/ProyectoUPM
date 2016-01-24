package ems.client;

/* 
 * Esta clase se suscribe a un destino y recibe sus mensajes
 *
 * Uso:  java MsgConsumer [opciones]
 *
 *    where options are:
 *
 *   -server    <url-servidor>
 *   -user      <nombre-usuario>
 *   -password  <password>
 *   -topic     <nombre-topic>
 *   -queue     <nombre-cola>
 *   -ackmode   <modo-ack>. Por defecto es AUTO.
 *              Otros valores posbiles: DUPS_OK, CLIENT, EXPLICIT_CLIENT,
 *              EXPLICIT_CLIENT_DUPS_OK and NO.
 *
 *
 */

import javax.jms.*;

import com.tibco.tibjms.Tibjms;

public class MsgConsumer
       implements ExceptionListener
{
    /*-----------------------------------------------------------------------
     * Parametros
     *----------------------------------------------------------------------*/
     String           serverUrl   = null;
     String           userName    = null;
     String           password    = null;
     String           name        = null;
     boolean          useTopic    = true;
     int              ackMode     = Session.AUTO_ACKNOWLEDGE;

     /*-----------------------------------------------------------------------
      * Variables
      *----------------------------------------------------------------------*/
      Connection      connection  = null;
      Session         session     = null;
      MessageConsumer msgConsumer = null;
      Destination     destination = null;

    public MsgConsumer(String[] args)
    {
        parseArgs(args);

        /* print parameters */
        System.err.println("\n------------------------------------------------------------------------");
        System.err.println("tibjmsMsgConsumer SAMPLE");
        System.err.println("------------------------------------------------------------------------");
        System.err.println("Server....................... "+((serverUrl != null)?serverUrl:"localhost"));
        System.err.println("User......................... "+((userName != null)?userName:"(null)"));
        System.err.println("Destination.................. "+name);
        System.err.println("------------------------------------------------------------------------\n");

        try {
            run();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }


    /*-----------------------------------------------------------------------
     * Uso
     *----------------------------------------------------------------------*/
    void usage()
    {
        System.err.println("\nUso: MsgConsumer [opciones]");
        System.err.println("");
        System.err.println(" las opciones son:");
        System.err.println("");
        System.err.println("   -server   <server URL> - EMS server URL, default is local server");
        System.err.println("   -user     <user name>  - user name, default is null");
        System.err.println("   -password <password>   - password, default is null");
        System.err.println("   -topic    <topic-name> - topic name, default is \"topic.sample\"");
        System.err.println("   -queue    <queue-name> - queue name, no default");
        System.err.println("   -ackmode  <ack-mode>   - acknowledge mode, por defecto es AUTO");
        System.err.println("                            Otro modos posibles: CLIENT, DUPS_OK, NO,");
        System.err.println("                            EXPLICIT_CLIENT and EXPLICIT_CLIENT_DUPS_OK");
        System.exit(0);
    }

    /*-----------------------------------------------------------------------
     * parseArgs
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
            if (args[i].compareTo("-ackmode")==0)
            {
                if ((i+1) >= args.length) usage();
                if (args[i+1].compareTo("AUTO")==0)
                    ackMode = Session.AUTO_ACKNOWLEDGE;
                else if (args[i+1].compareTo("CLIENT")==0)
                    ackMode = Session.CLIENT_ACKNOWLEDGE;
                else if (args[i+1].compareTo("DUPS_OK")==0)
                    ackMode = Session.DUPS_OK_ACKNOWLEDGE;
                else if (args[i+1].compareTo("EXPLICIT_CLIENT")==0)
                    ackMode = Tibjms.EXPLICIT_CLIENT_ACKNOWLEDGE;
                else if (args[i+1].compareTo("EXPLICIT_CLIENT_DUPS_OK")==0)
                    ackMode = Tibjms.EXPLICIT_CLIENT_DUPS_OK_ACKNOWLEDGE;
                else if (args[i+1].compareTo("NO")==0)
                    ackMode = Tibjms.NO_ACKNOWLEDGE;
                else
                {
                    System.err.println("Unrecognized -ackmode: "+args[i+1]);
                    usage();
                }
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


    /*---------------------------------------------------------------------
     * onException
     *---------------------------------------------------------------------*/
     public void onException(
                      JMSException e)
    {
        /* print the connection exception status */
        System.err.println("CONNECTION EXCEPTION: " + e.getMessage());
    }

    /*-----------------------------------------------------------------------
     * run
     *----------------------------------------------------------------------*/
     void run()
          throws JMSException
     {
        Message       msg         = null;
        String        msgType     = "UNKNOWN";

        System.err.println("Subscribing to destination: "+name+"\n");

        ConnectionFactory factory = new com.tibco.tibjms.TibjmsConnectionFactory(serverUrl);

        /* create the connection */
        connection = factory.createConnection(userName,password);

        /* create the session */
        session = connection.createSession(false,ackMode);

        /* set the exception listener */
        connection.setExceptionListener(this);

        /* create the destination */
        if(useTopic)
            destination = session.createTopic(name);
        else
            destination = session.createQueue(name);

        /* create the consumer */
        msgConsumer = session.createConsumer(destination);

        /* start the connection */
        connection.start();

        /* read messages */
        while(true)
        {
            /* receive the message */
            msg = msgConsumer.receive();
            if (msg == null)
               break;

            if (ackMode == Session.CLIENT_ACKNOWLEDGE ||
                ackMode == Tibjms.EXPLICIT_CLIENT_ACKNOWLEDGE ||
                ackMode == Tibjms.EXPLICIT_CLIENT_DUPS_OK_ACKNOWLEDGE)
                msg.acknowledge();

            System.err.println("Received message: "+ msg);
        }

        /* close the connection */
        connection.close();
    }

    /*-----------------------------------------------------------------------
     * main
     *----------------------------------------------------------------------*/
    public static void main(String[] args)
    {
        new MsgConsumer(args);
    }
}
