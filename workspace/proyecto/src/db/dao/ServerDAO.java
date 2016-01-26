package db.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import db.connection.DbConnection;
import ems.vo.Server;

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
	public void addServerInfo(ems.vo.Server server)
	{
		DbConnection conexion = new DbConnection();
		try {
			Statement estatuto = conexion.getConnection().createStatement();
			estatuto.executeUpdate("INSERT INTO server VALUES ('" + server.getUrl() + "', '"
			+ server.getConnectionCount() + "', '" + server.getConsumerCount() + "', '"
			+ server.getDiskReadRate() + "', '" + server.getDiskWriteRate() + "', '"
			+ server.getInboundBytesRate() + "', '" + server.getInboundMsgCount() + "', '"
			+ server.getInboundMsgRate() + "', '" + server.getMsgMem() + "', '"
			+ server.getOutboundMsgCount() + "', '" + server.getOutboundMsgRate() + "', '"
			+ server.getPendingMsgCount() + "', '" + server.getPendingMsgSize() + "', '"
			+ server.getProducerCount() + "', '" + server.getQueueCount() + "', '"
			+ server.getSessionCount() + "', '" + server.getTopicCount() + "', '"
			+ server.getUpTime() + "')");
		//JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente","Información",JOptionPane.INFORMATION_MESSAGE);
		estatuto.close();
		conexion.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se pudo realizar el registro de los datos del servidor.");
		}
	}

}
