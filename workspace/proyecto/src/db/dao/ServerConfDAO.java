package db.dao;

import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import db.connection.DbConnection;

/**
 * Clase que permite el acceso a la base de datos
 *
 */
public class ServerConfDAO
{

	/**
	 * Añade la información relativa a la configuración de un servidor a la BBDD (previamente se borran datos
	 * anteriores)
	 * @param server
	 */
	public void addServerConfInfo(ems.vo.ServerConfVO server_conf)
	{
		DbConnection conexion = new DbConnection();
		try {
			Statement estatuto = conexion.getConnection().createStatement();
			estatuto.executeUpdate("DELETE FROM server_conf");
			estatuto.executeUpdate("INSERT INTO server_conf (name, start_time,"
			+ "max_client_msg_size, max_connections, max_msg_memory) VALUES ('"
			+ server_conf.getName() + "', '" + server_conf.getStartTime() + "', '"
			+ server_conf.getMaxClientMsgSize() + "', '" + server_conf.getMaxConnections() + "', '"
			+ server_conf.getMaxMsgMemory() + "')");
		estatuto.close();
		conexion.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se pudo realizar el registro de los datos de configuración del servidor.");
		}
	}

}
