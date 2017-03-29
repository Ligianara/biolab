package br.edu.ifpi.biolab.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpi.biolab.Entidade.Filo;
import br.edu.ifpi.biolab.Entidade.Reino;

public class FiloDao extends Dao {
	public void adicionar(Filo filo) throws SQLException {
		String sql = "insert into filo " + "(nome,id,id_reino) values (?,?,?)";

		PreparedStatement stmt = super.getConexao().prepareStatement(sql);

		stmt.setString(1, filo.getNome());
		stmt.setInt(2, filo.getId());
		stmt.setInt(3, filo.getReino().getId());

		stmt.execute();
		stmt.close();
		System.out.println("Filo Adicionado!");
	}

	public List<Filo> buscaTodos() throws SQLException {
		List<Filo> filos = new ArrayList<>();
		Connection conexao = ConnectionFactory.getConexao();
		PreparedStatement stmt = conexao.prepareStatement("select * from filo");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Filo filo = new Filo();
			filo.setId(rs.getInt("id"));
			filo.setNome(rs.getString("nome"));

			filos.add(filo);
		}
		return filos;
	}

	public Reino buscaPorID(int id) {
		return null;

	}

	 public void altera(Filo filo) { 
	     String sql = "update contatos set  where id=? nomeVulgar=? nomeCientifico=?"; 
	     try { 
	         PreparedStatement stmt = getConexao().prepareStatement(sql); 
	         stmt.setLong(2, filo.getId()); 
	         stmt.setString(1, filo.getNome());
	         stmt.execute(); 
	         stmt.close(); 
	     } catch (SQLException e) { 
	         throw new RuntimeException(e); 
	     } 
	 } 

	public void remove(Filo filo) {
		try {
			PreparedStatement stmt = getConexao().prepareStatement("delete from filo where id=?");
			stmt.setLong(1, filo.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	

}
