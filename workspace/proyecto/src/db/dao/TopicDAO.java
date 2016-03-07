package db.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import db.connection.DbConnection;
import ems.vo.TopicVO;

/**
 * Clase que permite el acceso a la base de datos
 *
 */
public class TopicDAO {

	/**
	 * Añade la información de un servidor a la BBDD
	 * @param topic
	 */
	public void addTopicInfo(ems.vo.TopicVO topic)
	{
		DbConnection conexion = new DbConnection();
		try {
			Statement estatuto = conexion.getConnection().createStatement();
			estatuto.executeUpdate("INSERT INTO topics (name, "
			+ "pending_msg_count, pending_msg_size, subscriber_count, in_total_msgs, out_total_msgs, "
			+ "in_msg_rate, out_msg_rate) VALUES ('" + topic.getName() + "', '"
			+ topic.getPendingMsgCount() + "', '" + topic.getPendingMsgSize() + "', '"
			+ topic.getSubscriberCount() + "', '" + topic.getInTotalMsgs() + "', '"
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
