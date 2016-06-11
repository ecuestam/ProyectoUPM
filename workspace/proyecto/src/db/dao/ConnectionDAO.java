package db.dao;

import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import db.connection.DbConnection;

/**
 * Clase que permite el acceso a la base de datos
 *
 */
public class ConnectionDAO {

	/**
	 * Añade la información de un servidor a la BBDD
	 * @param connection
	 */
	public void addConnectionInfo(ems.vo.ConnectionVO connection)
	{
		DbConnection conexion = new DbConnection();
		try {
			Statement estatuto = conexion.getConnection().createStatement();
			estatuto.executeUpdate("INSERT INTO connections (id, type, host, address,"
			+ " consumer_count, producer_count, session_count, start_time, uptime, username)"
			+ " VALUES ('" + connection.getId() + "', '" + connection.getType() + "', '"
			+ connection.getHost() + "', '" + connection.getAddress() + "', '"
			+ connection.getConsumerCount() + "', '" + connection.getProducerCount() + "', '"
			+ connection.getSessionCount() + "', '" + connection.getStartTime() + "', '"
			+ connection.getUpTime() + "', '" + connection.getUsername() + "')");
		estatuto.close();
		conexion.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se pudo realizar el registro de los datos de la conexión.");
		}
	}

}
