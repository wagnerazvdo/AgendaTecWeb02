package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

import dao.FabricaConexao;
import dao.JDBCContatoDAO;
import model.Contato;


@WebServlet("/InserirContato")
public class InserirContato extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public InserirContato() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		
		Contato novoContato = new Contato();
		novoContato.setNome(nome);
		novoContato.setEmail(email);
		novoContato.setTelefone(telefone);
		
		FabricaConexao fabrica = new FabricaConexao();
		Connection conexao = fabrica.fazConexao();
		
		JDBCContatoDAO dao = new JDBCContatoDAO(conexao);
		dao.inserir(novoContato);
		
		fabrica.fecharConexao();
		
		RequestDispatcher rd = request.getRequestDispatcher("listarContatos.jsp");
		rd.forward(request, response);
		
	}

}
