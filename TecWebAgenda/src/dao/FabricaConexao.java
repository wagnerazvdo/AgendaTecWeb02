package dao;

import com.mysql.jdbc.Connection;

public class FabricaConexao {
	
	private java.sql.Connection conexao;
	
	public Connection fazConexao() {
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			conexao = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda", "root", "d12345");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return conexao;
	}
	
	public void fecharConexao() {
		try {
			conexao.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
