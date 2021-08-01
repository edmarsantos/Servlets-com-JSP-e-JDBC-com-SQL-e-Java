package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.spi.DirStateFactory.Result;

import connection.SingleConnection;

public class DaoLogin {

	private Connection connection;
	
	
	public DaoLogin() {
		
		connection = SingleConnection.getConnection();
	}
	
	public boolean validarLogin(String login,String senha) throws Exception {
		
		String sql = "Select * from usuario where login ='" + login + "' and senha ='" + senha + "' ";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		
		if(resultSet.next()) {
         return true; //possui usuario
		}else {
		 return false; //nao possui usuario
	}
	
}
}
