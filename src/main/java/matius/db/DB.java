package matius.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
	private static DB instance = null;
	
	//should I add statistics to this database controller class?
	private DB(){
		//start the connection for first time
		Connection connection = null;
		String url = "jdbc:mariadb://localhost:3306/db1";
		String user = "root";
		String pass = "";
		try {
	        Class.forName("org.mariadb.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	        System.out.println("Error al cargar el driver JDBC");
	    }
		try {
			connection = DriverManager.getConnection(url, user, pass);
			if(connection.isValid(0)) {
				System.out.println("La conexion es valida");
			}
			
			System.out.println(connection.getClientInfo());
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static synchronized DB getInstance() {
		if(instance == null) instance = new DB();
		return instance;
	}
}
