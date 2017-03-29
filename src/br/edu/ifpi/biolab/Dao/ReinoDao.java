package br.edu.ifpi.biolab.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpi.biolab.Entidade.Especie;
import br.edu.ifpi.biolab.Entidade.Reino;

public class ReinoDao extends Dao {

	public void adicionar(Reino reino) throws SQLException {
		String sql = "insert into reino " + "(nome) values (?)";

		PreparedStatement stmt = super.getConexao().prepareStatement(sql);

		stmt.setString(1, reino.getNome());

		stmt.execute();
		stmt.close();
		System.out.println("Reino Adicionado!");
	}

	public List<Reino> buscaTodos() throws SQLException {
		List<Reino> reinos = new ArrayList<>();
		Connection conexao = ConnectionFactory.getConexao();
		PreparedStatement stmt = conexao.prepareStatement("select * from reino");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Reino reino = new Reino();
			reino.setId(rs.getInt("id"));
			reino.setNome(rs.getString("nome"));

			reinos.add(reino);
		}
		return reinos;
	}

	public Especie buscaPorID(int id) {
		return null;

	}

	 public void altera(Reino  reino) { 
	     String sql = "update contatos set  where id=? nomeVulgar=? nomeCientifico=?"; 
	     try { 
	         PreparedStatement stmt = getConexao().prepareStatement(sql); 
	         stmt.setLong(2, reino.getId()); 
	         stmt.setString(1, reino.getNome());
	         stmt.execute(); 
	         stmt.close(); 
	     } catch (SQLException e) { 
	         throw new RuntimeException(e); 
	     } 
	 } 

	public void remove(Reino reino) {
		try {
			PreparedStatement stmt = getConexao().prepareStatement("delete from reino where id=?");
			stmt.setLong(1, reino.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	

}
