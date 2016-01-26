package db.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import db.connection.DbConnection;
import ems.vo.Connection;

/**
 * Clase que permite el acceso a la base de datos
 *
 */
public class ConnectionDAO {

	/**
	 * Añade la información de un servidor a la BBDD
	 * @param connection
	 */
	public void addConnectionInfo(ems.vo.Connection connection)
	{
		DbConnection conexion = new DbConnection();
		try {
			Statement estatuto = conexion.getConnection().createStatement();
			estatuto.executeUpdate("INSERT INTO connections VALUES ('" + connection.getId() + "', '"
			+ connection.getType() + "', '"+ connection.getHost() + "', '" + connection.getAddress() + "', '"
			+ connection.getConsumerCount() + "', '" + connection.getProducerCount() + "', '"
			+ connection.getSessionCount() + "', '" + connection.getStartTime() + "', '"
			+ connection.getUpTime() + "', '" + connection.getUsername() + "')");
		//JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente","Información",JOptionPane.INFORMATION_MESSAGE);
		estatuto.close();
		conexion.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se pudo realizar el registro de los datos de la conexión.");
		}
	}

}
