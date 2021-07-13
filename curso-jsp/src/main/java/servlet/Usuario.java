package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import beans.BeanCursoJsp;
import dao.DaoUsuario;

/**
 * Servlet implementation class LoginServet
 */
@WebServlet("/salvarUsuario")
public class Usuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DaoUsuario daoUsuario = new DaoUsuario();
       
    public Usuario() {
        super();
    }

    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
		
			
		String acao = request.getParameter("acao");
		String user = request.getParameter("user");
		
		if(acao.equalsIgnoreCase("delete")) {
			daoUsuario.delete(user);
			RequestDispatcher view = request.getRequestDispatcher("/cadastroUsuario.jsp");
			request.setAttribute("usuarios", daoUsuario.listar());
			view.forward(request, response);
		} 
		else if(acao.equalsIgnoreCase("editar")) {
			
			BeanCursoJsp beanCursoJsp = daoUsuario.cosultar(user);
				
				RequestDispatcher view = request
						.getRequestDispatcher("/cadastroUsuario.jsp");
				request.setAttribute("user", beanCursoJsp);
				view.forward(request, response);
			
		
		}
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//lembrete dados rececbidos da tela 
		String id = request.getParameter("id");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String nome = request.getParameter("nome");
		
		
		
		BeanCursoJsp usuario = new BeanCursoJsp();
		
		// para pegar o campo vazio !id.isEmpty()? Long.parseLong(id) : 0
		usuario.setId(!id.isEmpty()? Long.parseLong(id) : 0);
		usuario.setLogin(login);
		usuario.setSenha(senha);
		usuario.setNome(nome);
		
		
		
		if(id == null || id.isEmpty()) {
			daoUsuario.salvar(usuario);
		}else {
			try {
				daoUsuario.atualizar(usuario);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		try {
		RequestDispatcher view = request.getRequestDispatcher("/cadastroUsuario.jsp");
		request.setAttribute("usuarios", daoUsuario.listar());
		view.forward(request, response);
		
		}catch (Exception e) {
			e.printStackTrace();
		}
			
	}

}
