package db.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import db.connection.DbConnection;
import ems.vo.Store;

/**
 * Clase que permite el acceso a la base de datos
 *
 */
public class StoreDAO {

	/**
	 * Añade la información de un servidor a la BBDD
	 * @param store
	 */
	public void addStoreInfo(ems.vo.Store store)
	{
		DbConnection conexion = new DbConnection();
		try {
			Statement estatuto = conexion.getConnection().createStatement();
			estatuto.executeUpdate("INSERT INTO store VALUES ('" + store.getName() + "', '"
			+ store.getFileName() + "', '" + store.getFileSize() + "', '"
			+ store.getFreeSpace() + "', '" + store.getUsedSpace() + "', '"
			+ store.getFragmentation() + "', '" + store.getMsgSize() + "', '"
			+ store.getMsgCount() + "')");
		//JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente","Información",JOptionPane.INFORMATION_MESSAGE);
		estatuto.close();
		conexion.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se pudo realizar el registro de los datos del almacenamiento.");
		}
	}

}
