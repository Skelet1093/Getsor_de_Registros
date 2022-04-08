import java.sql.*;

public class MySQL {
	private static final String CNTR = "com.mysql.jdbc.Driver";
	
	static Connection conexion = null;
    static ResultSet rs;
	
	public Connection conectar() {
		try {
		Class.forName(CNTR);
		
		conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/programacion1", "root", "");
		System.out.println("Conexion exitosa");
		
		} catch (ClassNotFoundException e) {
			System.out.println("Error de carga de controlador");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error en la conexion");
			e.printStackTrace();
		}
		
		return conexion;
	}
	
	public static void cerrarConexion() {
        try {
            conexion.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	public static void insert(PreparedStatement st) {
        try {
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean update(PreparedStatement st) {
    	boolean v;
        try {
            st.executeUpdate();
            v = true;
        } catch (Exception e) {
            e.printStackTrace();
            v = false;
        }
        return v;
    }

    public static boolean eliminar(PreparedStatement st) {
        boolean v;
    	try {
            st.executeUpdate();
            v = true;
        } catch (Exception e) {
            e.printStackTrace();
            v = false;
        }
		return v;
    }

    public static ResultSet select(PreparedStatement st) {
        try {
            rs = st.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
}
