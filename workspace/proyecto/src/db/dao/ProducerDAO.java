package db.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import db.connection.DbConnection;
import ems.vo.Producer;

/**
 * Clase que permite el acceso a la base de datos
 *
 */
public class ProducerDAO {

	/**
	 * Añade la información de un servidor a la BBDD
	 * @param producer
	 */
	public void addProducerInfo(ems.vo.Producer producer)
	{
		DbConnection conexion = new DbConnection();
		try {
			Statement estatuto = conexion.getConnection().createStatement();
			estatuto.executeUpdate("INSERT INTO producers VALUES ('" + producer.getId() + "', '"
			+ producer.getCreateTime() + "', '"+ producer.getDestinationName() + "', '"
			+ producer.getDestinationType() + "', '" + producer.getConnectionId() + "', '"
			+ producer.getSessionId() + producer.getMsgRate() + "', '" + producer.getTotalMsgs() + "')");
		//JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente","Información",JOptionPane.INFORMATION_MESSAGE);
		estatuto.close();
		conexion.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se pudo realizar el registro de los datos del productor.");
		}
	}

}
