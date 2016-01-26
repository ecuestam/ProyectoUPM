package db.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import db.connection.DbConnection;
import ems.vo.Consumer;

/**
 * Clase que permite el acceso a la base de datos
 *
 */
public class ConsumerDAO {

	/**
	 * Añade la información de un servidor a la BBDD
	 * @param consumer
	 */
	public void addConsumerInfo(ems.vo.Consumer consumer)
	{
		DbConnection conexion = new DbConnection();
		try {
			Statement estatuto = conexion.getConnection().createStatement();
			estatuto.executeUpdate("INSERT INTO consumers VALUES ('" + consumer.getId() + "', '"
			+ consumer.getCreateTime() + "', '"+ consumer.getDestinationName() + "', '"
			+ consumer.getDestinationType() + "', '" + consumer.getConnectionId() + "', '"
			+ consumer.getSessionId() + consumer.getMsgRate() + "', '" + consumer.getTotalMsgs() + "')");
		//JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente","Información",JOptionPane.INFORMATION_MESSAGE);
		estatuto.close();
		conexion.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se pudo realizar el registro de los datos del consumidor.");
		}
	}

}
