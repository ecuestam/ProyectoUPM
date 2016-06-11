package db.dao;

import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import db.connection.DbConnection;

/**
 * Clase que permite el acceso a la base de datos
 *
 */
public class ServerDAO
{

	/**
	 * Añade la información de un servidor a la BBDD
	 * @param server
	 */
	public void addServerInfo(ems.vo.ServerVO server)
	{
		DbConnection conexion = new DbConnection();
		try {
			Statement estatuto = conexion.getConnection().createStatement();
			estatuto.executeUpdate("INSERT INTO server (url, connection_count, consumer_count,"
			+ "disk_read_rate, disk_write_rate, inbound_bytes_rate, inbound_msg_count,"
			+ "inbound_msg_rate, msg_mem, outbound_msg_count, outbound_msg_rate,"
			+ "pending_msg_count, pending_msg_size, producer_count, queue_count, session_count,"
			+ "topic_count, uptime) VALUES ('" + server.getUrl() + "', '"
			+ server.getConnectionCount() + "', '" + server.getConsumerCount() + "', '"
			+ server.getDiskReadRate() + "', '" + server.getDiskWriteRate() + "', '"
			+ server.getInboundBytesRate() + "', '" + server.getInboundMsgCount() + "', '"
			+ server.getInboundMsgRate() + "', '" + server.getMsgMem() + "', '"
			+ server.getOutboundMsgCount() + "', '" + server.getOutboundMsgRate() + "', '"
			+ server.getPendingMsgCount() + "', '" + server.getPendingMsgSize() + "', '"
			+ server.getProducerCount() + "', '" + server.getQueueCount() + "', '"
			+ server.getSessionCount() + "', '" + server.getTopicCount() + "', '"
			+ server.getUpTime() + "')");
		estatuto.close();
		conexion.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se pudo realizar el registro de los datos del servidor.");
		}
	}

}
