package db.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import db.connection.DbConnection;
import ems.vo.Topic;

/**
 * Clase que permite el acceso a la base de datos
 *
 */
public class TopicDAO {

	/**
	 * Añade la información de un servidor a la BBDD
	 * @param topic
	 */
	public void addTopicInfo(ems.vo.Topic topic)
	{
		DbConnection conexion = new DbConnection();
		try {
			Statement estatuto = conexion.getConnection().createStatement();
			estatuto.executeUpdate("INSERT INTO queues VALUES ('" + topic.getName() + "', '"
			+ topic.getProducerId() + "', '" + topic.getConsumerId() + "', '"
			+ topic.getPendingMsgCount() + "', '" + topic.getPendingMsgSize() + "', '"
			+ topic.getSuscriberCount() + "', '" + topic.getInTotalMsgs() + "', '"
			+ topic.getOutTotalMsgs() + "', '" + topic.getInMsgRate() + "', '"
			+ topic.getOutMsgRate() + "')");
		//JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente","Información",JOptionPane.INFORMATION_MESSAGE);
		estatuto.close();
		conexion.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se pudo realizar el registro de los datos del topic.");
		}
	}

}
