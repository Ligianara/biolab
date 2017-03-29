package br.edu.ifpi.biolab.Dao.teste;

import java.sql.Connection;
import java.sql.SQLException;

import br.edu.ifpi.biolab.Dao.ConnectionFactory;

public class ConexaoTeste {
	
 public static void main(String[] args) throws SQLException {
	 Connection conexao = ConnectionFactory.getConexao();
	 System.out.println("Conectado!");
	 conexao.close();
	
}
}
