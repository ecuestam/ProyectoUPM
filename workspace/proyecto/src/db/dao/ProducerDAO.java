package db.dao;

import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import db.connection.DbConnection;

/**
 * Clase que permite el acceso a la base de datos
 *
 */
public class ProducerDAO {

	/**
	 * Añade la información de un servidor a la BBDD
	 * @param producer
	 */
	public void addProducerInfo(ems.vo.ProducerVO producer)
	{
		DbConnection conexion = new DbConnection();
		try {
			if (producer.getDestinationName().indexOf("$") != 0) {
				Statement estatuto = conexion.getConnection().createStatement();
				estatuto.executeUpdate("INSERT INTO producers (id, create_time, destination_name,"
				+ " destination_type, connection_id, session_id, msg_rate, total_msgs)"
				+ " VALUES ('" + producer.getId() + "', '" + producer.getCreateTime() + "', '"
				+ producer.getDestinationName() + "', '" + producer.getDestinationType() + "', '"
				+ producer.getConnectionId() + "', '" + producer.getSessionId() + "', '"
				+ producer.getMsgRate() + "', '" + producer.getTotalMsgs() + "')");
				estatuto.close();
				conexion.desconectar();
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se pudo realizar el registro de los datos del productor.");
		}
	}

}
