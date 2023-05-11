package sistema;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.cj.jdbc.PreparedStatementWrapper;

public class DataProducto {
	Connection cx;

	public Connection conectar() {
		try {
			cx = DriverManager.getConnection("jdbc:mysql://localhost/0acertificacion", "root", "");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cx;
	}

	public DataProducto() {

	}

	public boolean insertarProducto(NegocioProducto np) {
		PreparedStatement ps = null;
		try {
			ps = conectar().prepareStatement("INSERT INTO producto VALUES(?,?,?,?) ");
			ps.setString(1, np.getId());
			ps.setString(2, np.getNombre());
			ps.setString(3, np.getPrecio());
			ps.setString(4, np.getProveedor());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	public boolean cargarProducto(String id) {
		try {
			PreparedStatement ps=conectar().prepareStatement("SELECT");
			if() {
				
				
				
				
				return true;
			}else {
				return false;
			}
		}catch(Exception e){
			return false;
		}
	}

	public boolean eliminarProducto(String id) {
		return true;
	}

	public boolean actualizarProducto(NegocioProducto np) {
		return true;
	}
}