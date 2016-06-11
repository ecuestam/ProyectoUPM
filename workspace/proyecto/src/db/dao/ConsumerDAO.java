package db.dao;

import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import db.connection.DbConnection;

/**
 * Clase que permite el acceso a la base de datos
 *
 */
public class ConsumerDAO {

	/**
	 * Añade la información de un servidor a la BBDD
	 * @param consumer
	 */
	public void addConsumerInfo(ems.vo.ConsumerVO consumer)
	{
		DbConnection conexion = new DbConnection();
		try {
			if (consumer.getDestinationName().indexOf("$") != 0) {
				Statement estatuto = conexion.getConnection().createStatement();
				estatuto.executeUpdate("INSERT INTO consumers (id, create_time, destination_name,"
				+ " destination_type, connection_id, session_id, msg_rate, total_msgs)"
				+ " VALUES ('" + consumer.getId() + "', '" + consumer.getCreateTime() + "', '"
				+ consumer.getDestinationName() + "', '" + consumer.getDestinationType() + "', '"
				+ consumer.getConnectionId() + "', '" + consumer.getSessionId() + "', '"
				+ consumer.getMsgRate() + "', '" + consumer.getTotalMsgs() + "')");
				
				estatuto.close();
			}
			conexion.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se pudo realizar el registro de los datos del consumidor.");
		}
	}

}
