package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.BeanCursoJsp;
import connection.SingleConnection;

public class DaoUsuario {
	
	private Connection connection;
	
	public DaoUsuario() {
		connection = SingleConnection.getConnection();
	}
	
	public void salvar(BeanCursoJsp usuario)   {
		
		try {
			String sql = "insert into usuario(login,senha,nome) values(?,?,?) ";
			PreparedStatement insert = connection.prepareStatement(sql);
	        insert.setString(1, usuario.getLogin());
	        insert.setString(2, usuario.getSenha());
	        insert.setString(3, usuario.getNome());
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
	
	public List<BeanCursoJsp> listar() throws Exception{
		
		List<BeanCursoJsp> listar = new ArrayList<BeanCursoJsp>();
		String Sql = " select * from usuario ";
		
		PreparedStatement statement = connection.prepareStatement(Sql);
		ResultSet resultSet =statement.executeQuery();
		while(resultSet.next() ) {
		BeanCursoJsp beanCursoJsp = new BeanCursoJsp();
		beanCursoJsp.setId(resultSet.getLong("id"));
		beanCursoJsp.setLogin(resultSet.getString("login"));
		beanCursoJsp.setSenha(resultSet.getString("senha"));
		beanCursoJsp.setNome(resultSet.getString("nome"));
		
		listar.add(beanCursoJsp);
		
		}
		return listar;
		
	}
	
	public void delete(String id) {
		
		try {
		String sql ="delete from usuario where id = '" + id + "' ";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.execute();
		connection.commit();
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public BeanCursoJsp cosultar(String id) throws Exception {
		
		String sql = "select * from usuario where id='" + id +"' ";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		
		if(resultSet.next()) {
			BeanCursoJsp beanCursoJsp = new BeanCursoJsp();
			beanCursoJsp.setId(resultSet.getLong("id"));
			beanCursoJsp.setLogin(resultSet.getString("login"));
			beanCursoJsp.setSenha(resultSet.getString("senha"));
			beanCursoJsp.setNome(resultSet.getString("nome"));
		
		return beanCursoJsp;
		}
		return null;
	}
	
public boolean validarLogin(String login) throws Exception {
		
		String sql = "select count(1) as qtd from usuario where login='" + login +"' ";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		if(resultSet.next()) {
		
			return resultSet.getInt("qtd") <=0; //returna verdadeiro
		}
		return false;
	}

public boolean ValidarLoginUpdate(String login,String id) throws Exception {
	
	String sql = "select count(1) as qtd from usuario where login='" + login +"' and id <> " + id;
	PreparedStatement preparedStatement = connection.prepareStatement(sql);
	ResultSet resultSet = preparedStatement.executeQuery();
	if(resultSet.next()) {
	
		return resultSet.getInt("qtd") <=0; //returna verdadeiro
	}
	return false;
}



	public void atualizar (BeanCursoJsp usuario) throws SQLException {
		
		try {
			
		String sql = "UPDATE USUARIO SET LOGIN = ? ,SENHA =?, nome=? WHERE ID =" + usuario.getId() ;
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, usuario.getLogin());
		preparedStatement.setString(2, usuario.getSenha());
		preparedStatement.setString(3, usuario.getNome());
		preparedStatement.execute();
		connection.commit();
		}catch (Exception e){
			e.printStackTrace();
			
			try {
				connection.rollback();	
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}	
		
	}
	
	public boolean validarSenha(String senha) throws Exception {
		String sql = "select count(1) as qtd from usuario where senha='" + senha + "'";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			
			return resultSet.getInt("qtd") <= 0;/*Return true*/
		}
		return false;
	}
	
}
