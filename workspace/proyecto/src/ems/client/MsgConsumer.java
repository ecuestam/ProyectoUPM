package ems.client;

/*----------------------------------------------------------------------------------
 * Esta clase se suscribe a un destino, ya sea una cola o un topic y recibe sus
 * mensajes
 *
 * Uso:  java MsgConsumer [opciones]
 *
 *    donde las opciones son:
 *
 *   -server    <URL servidor>
 *   -user      <usuario>
 *   -password  <password>
 *   -topic     <nombre topic>
 *   -queue     <nombre cola>
 *
 *---------------------------------------------------------------------------------*/

import javax.jms.*;

import com.tibco.tibjms.Tibjms;

public class MsgConsumer
       implements ExceptionListener
{
    /*-----------------------------------------------------------------------
     * Argumentos
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
	        System.err.println("Cliente de EMS consumidor de mensajes");
	        System.err.println("--------------------------------------------------------------------------");
	        System.err.println("Servidor........................... "+this.serverUrl);
	        System.err.println("User............................... "+this.userName);
	        System.err.println("Destination........................ "+this.name);
	        System.err.println("--------------------------------------------------------------------------\n");
	
	        try {
	            run();
	        } catch (JMSException e) {
	            e.printStackTrace();
	        }
		}
    }

    /*-----------------------------------------------------------------------
     * Ayuda sobre los parámetros para lanzar el cliente que conecta al
     * servidor EMS para consumir los mensajes de una cola/topic
     *----------------------------------------------------------------------*/
    void usage()
    {
        System.err.println("\nUso: java -jar MsgConsumer [opciones]");
        System.err.println("");
        System.err.println(" las opciones son:");
        System.err.println("");
        System.err.println("   -server   <URL servidor>	- URL del servidor EMS");
        System.err.println("   -user     <usuario>  	- nombre de usuario");
        System.err.println("   -password <password>		- password de usuario");
        System.err.println("   -topic    <nombre topic>	- nombre del topic");
        System.err.println("   -queue    <nombre cola>	- nombre de la cola");
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
                this.serverUrl = args[i+1];
                i += 2;
            }
            else
            if (args[i].compareTo("-topic")==0)
            {
                this.name = args[i+1];
                i += 2;
            }
            else
            if (args[i].compareTo("-queue")==0)
            {
                this.name = args[i+1];
                i += 2;
                useTopic = false;
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
            {
                System.err.println("Parametro desconocido: "+args[i]);
                usage();
            }
        }
    }


    /*---------------------------------------------------------------------
     * Control de los eventos de conexión
     *---------------------------------------------------------------------*/
     public void onException(JMSException e)
    {
        /* Mostrar la excepción de la conexión */
        System.err.println("CONNECTION EXCEPTION: " + e.getMessage());
    }

    /*-----------------------------------------------------------------------
     * Método donde se crea la conexión con el servidor EMS y se
     * conecta un consumidor a un destino, ya sea una cola o un topic,
     * para consumir sus mensajes
     *----------------------------------------------------------------------*/
     void run()
          throws JMSException
     {
        Message       msg         = null;

        System.err.println("Suscripcion al destino: "+name+"\n");

        ConnectionFactory factory = new com.tibco.tibjms.TibjmsConnectionFactory(serverUrl);

        /* crear la conexión */
        connection = factory.createConnection(userName,password);

        /* crear la sesión */
        session = connection.createSession(false,ackMode);

        /* establecer el control de las excepciones */
        connection.setExceptionListener(this);

        /* crear el destino (cola o topic) */
        if(useTopic)
            destination = session.createTopic(name);
        else
            destination = session.createQueue(name);

        /* crear el consumidor */
        msgConsumer = session.createConsumer(destination);

        /* abrir la conexión */
        connection.start();

        /* bucle de lectura de los mensajes de un destino */
        while(true)
        {
            /* consumidor de mensajes */
            msg = msgConsumer.receive();
            if (msg == null)
               break;

            if (ackMode == Session.CLIENT_ACKNOWLEDGE ||
                ackMode == Tibjms.EXPLICIT_CLIENT_ACKNOWLEDGE ||
                ackMode == Tibjms.EXPLICIT_CLIENT_DUPS_OK_ACKNOWLEDGE)
                msg.acknowledge();

            System.out.println("Mensaje recibido: "+ msg);
        }

        /* cerrar la conexión */
        connection.close();
    }

    /*-----------------------------------------------------------------------
     * Método principal
     *----------------------------------------------------------------------*/
    public static void main(String[] args)
    {
        new MsgConsumer(args);
    }
}