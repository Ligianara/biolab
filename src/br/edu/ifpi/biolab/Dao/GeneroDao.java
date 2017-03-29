package br.edu.ifpi.biolab.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpi.biolab.Entidade.Classe;
import br.edu.ifpi.biolab.Entidade.Familia;
import br.edu.ifpi.biolab.Entidade.Genero;

public class GeneroDao extends Dao {
	public void adicionar(Genero genero) throws SQLException {
		String sql = "insert into genero " + "(nome,id,id_classe) values (?,?,?)";

		PreparedStatement stmt = super.getConexao().prepareStatement(sql);

		stmt.setString(1, genero.getNome());
		stmt.setInt(2, genero.getId());
		stmt.setInt(3, genero.getFamilia().getId());

		stmt.execute();
		stmt.close();
		System.out.println("Classe Adicionada!");
	}

	public List<Genero> buscaTodos() throws SQLException {
		List<Genero> generos = new ArrayList<>();
		Connection conexao = ConnectionFactory.getConexao();
		PreparedStatement stmt = conexao.prepareStatement("select * from classe");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Genero genero = new Genero(0, null, null);
			genero.setId(rs.getInt("id"));
			genero.setNome(rs.getString("nome"));
			generos.add(genero);
		}
		return generos;
	}

	public Familia buscaPorID(int id) {
		return null;

	}

	 public void altera(Genero genero) { 
	     String sql = "update contatos set  where id=? nomeVulgar=? nomeCientifico=?"; 
	     try { 
	         PreparedStatement stmt = getConexao().prepareStatement(sql); 
	         stmt.setLong(2, genero.getId()); 
	         stmt.setString(1, genero.getNome());
	         stmt.execute(); 
	         stmt.close(); 
	     } catch (SQLException e) { 
	         throw new RuntimeException(e); 
	     } 
	 } 

	public void remove(Genero genero) {
		try {
			PreparedStatement stmt = getConexao().prepareStatement("delete from genero where id=?");
			stmt.setLong(1, genero.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}