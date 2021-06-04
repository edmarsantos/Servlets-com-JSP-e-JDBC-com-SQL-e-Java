package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {
	
	
	private static String banco;
	private static String password;
	private static String user;
	private static Connection connection;
	
	
	static{
		conectar();
	}
	
	public SingleConnection() {
		conectar();
	}
	
	
	private static void conectar() {
		try {
			if (connection == null) {
				Class.forName("org.postgresql.Driver");
				connection =DriverManager.getConnection(banco,  user, password);
				connection.setAutoCommit(false);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("Erro ao conectar com o banco de dados");
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}
}
