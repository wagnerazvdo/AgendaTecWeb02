package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import model.Contato;

public class JDBCContatoDAO implements ContatoDAO{
	
	Connection conexao; 
	
	public JDBCContatoDAO(Connection conexao) {
		this.conexao = conexao;
		
	}

	@Override
	public void inserir(Contato contato) {
		String comando = "insert into Contato (nome, email, telefone)"+
			"values(?,?,?)";
		
		PreparedStatement p;
		try {
			p = this.conexao.prepareStatement(comando);
			p.setString(1, contato.getNome());
			p.setString(2, contato.getEmail());
			p.setString(3, contato.getTelefone());
			
			p.execute();
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		

	}

	@Override
	public List<Contato> listarTodos() {
		List<Contato> contatos = new ArrayList<Contato>();
		
		String comando = "select * from Contato";
		
		try {
			
			java.sql.Statement stat = conexao.createStatement();
			ResultSet rs = stat.executeQuery(comando);
			
			while( rs.next()) {
				Contato contato = new Contato();
				
				
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				String telefone = rs.getString("telefone");
				
				
				contato.setNome(nome);
				contato.setEmail(email);
				contato.setTelefone(telefone);
				
				
				contatos.add(contato);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contatos;
	}

}
