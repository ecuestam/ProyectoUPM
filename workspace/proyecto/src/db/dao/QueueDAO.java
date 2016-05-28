package db.dao;

import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import db.connection.DbConnection;

/**
 * Clase que permite el acceso a la base de datos
 *
 */
public class QueueDAO {

	/**
	 * Añade la información de un servidor a la BBDD
	 * @param queue
	 */
	public void addQueueInfo(ems.vo.QueueVO queue)
	{
		DbConnection conexion = new DbConnection();
		try {
			if (queue.getName().indexOf("$") != 0) {
				Statement estatuto = conexion.getConnection().createStatement();
				estatuto.executeUpdate("INSERT INTO queues (name, "
				+ "pending_msg_count, pending_msg_size, in_total_msgs, out_total_msgs, "
				+ "in_msg_rate, out_msg_rate) VALUES ('" + queue.getName() + "', '"
				+ queue.getPendingMsgCount() + "', '" + queue.getPendingMsgSize() + "', '"
				+ queue.getInTotalMsgs() + "', '" + queue.getOutTotalMsgs() + "', '"
				+ queue.getInMsgRate() + "', '" + queue.getOutMsgRate() + "')");
				
				estatuto.close();
				conexion.desconectar();
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se pudo realizar el registro de los datos de la cola.");
		}
	}

}
