package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.BeanCursoJsp;
import beans.Produto;
import connection.SingleConnection;

public class DaoProduto {
	
private Connection connection;
	
	public DaoProduto() {
		connection = SingleConnection.getConnection();
	}
	
	public void salvar(Produto produto)   {
		
		try {
			String sql = "insert into produto(nome,quantidade,valor) values(?,?,?) ";
			PreparedStatement insert = connection.prepareStatement(sql);
	        insert.setString(1, produto.getNome());
	        insert.setDouble(2, produto.getQuantidade());
	        insert.setDouble(3, produto.getValor());
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
	
	
public List<Produto> listar() throws Exception{
		
		List<Produto> listar = new ArrayList<Produto>();
		String Sql = " select * from produto ";
		
		PreparedStatement statement = connection.prepareStatement(Sql);
		ResultSet resultSet =statement.executeQuery();
		while(resultSet.next() ) {
		Produto produto = new Produto();
		produto.setId(resultSet.getLong("id"));
		produto.setNome(resultSet.getString("nome"));
		produto.setQuantidade(resultSet.getDouble("quantidade"));
		produto.setValor(resultSet.getDouble("valor"));
		
		listar.add(produto);
		
		}
		return listar;
		
	}
	

public void delete(String id) {
	
	try {
	String sql ="delete from produto where id = '" + id + "' ";
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


public Produto consultar(String id) throws Exception {
	
	String sql = "select * from produto where id='" + id +"' ";
	
	PreparedStatement preparedStatement = connection.prepareStatement(sql);
	ResultSet resultSet = preparedStatement.executeQuery();
	
	if(resultSet.next()) {
		Produto produto = new Produto();
		produto.setId(resultSet.getLong("id"));
		produto.setNome(resultSet.getString("nome"));
		produto.setQuantidade(resultSet.getDouble("quantidade"));
		produto.setValor(resultSet.getDouble("valor"));
	
	return produto;
	}
	return null;
}

public boolean validarNome(String nome) throws Exception {
	
	String sql = "select count(1) as qtd from produto where nome='" + nome +"' ";
	
	PreparedStatement preparedStatement = connection.prepareStatement(sql);
	ResultSet resultSet = preparedStatement.executeQuery();
	if(resultSet.next()) {
	
		return resultSet.getInt("qtd") <=0; //returna verdadeiro
	}
	return false;
}

public boolean ValidarProdutoUpdate(String login,String id) throws Exception {
	
	String sql = "select count(1) as qtd from produto where nome='" + login +"' and id <> " + id;
	PreparedStatement preparedStatement = connection.prepareStatement(sql);
	ResultSet resultSet = preparedStatement.executeQuery();
	if(resultSet.next()) {
	
		return resultSet.getInt("qtd") <=0; //returna verdadeiro
	}
	return false;
}


public void atualizar (Produto produto) throws SQLException {
	
	try {
		
	String sql = "UPDATE produto SET nome = ? ,quantidade =?, valor=? WHERE ID =" + produto.getId() ;
	PreparedStatement preparedStatement = connection.prepareStatement(sql);
	preparedStatement.setString(1, produto.getNome());
	preparedStatement.setDouble(2, produto.getQuantidade());
	preparedStatement.setDouble(3, produto.getValor());
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



}
