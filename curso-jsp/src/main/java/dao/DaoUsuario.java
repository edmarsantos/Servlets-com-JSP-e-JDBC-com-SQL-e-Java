package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.BeanCursoJsp;
import connection.SingleConnection;

public class DaoUsuario {
	
	private Connection connection;
	
	public DaoUsuario() {
		connection = SingleConnection.getConnection();
		
	}
	
	public void salvar(BeanCursoJsp usuario)   {
		
		try {
			String sql = "insert into usuario(login,senha) values(? , ?) ";
			PreparedStatement insert = connection.prepareStatement(sql);
	        insert.setString(1, usuario.getLogin());
	        insert.setString(2, usuario.getSenha());
	        insert.execute();
	        connection.commit();
	        
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		     	
		}
		
		
	}
	

}