package br.edu.ifpi.biolab.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpi.biolab.Entidade.Especie;
import br.edu.ifpi.biolab.Entidade.Genero;

public class EspecieDao extends Dao {

	public void adicionar(Especie especie) throws SQLException {
		String sql = "insert into especie " + "(nomeVulgar,nomeCientifico,id_genero) values (?,?,?)";

		PreparedStatement stmt = super.getConexao().prepareStatement(sql);

		stmt.setString(1, especie.getNomeVulgar());
		stmt.setString(2, especie.getNomeCientifico());
		stmt.setInt(3, especie.getGenero().getId());

		stmt.execute();
		stmt.close();
		System.out.println("Especie Adicionada!");
	}

	public List<Especie> buscaTodos() throws SQLException {
		List<Especie> especies = new ArrayList<>();
		Connection conexao = ConnectionFactory.getConexao();
		PreparedStatement stmt = conexao.prepareStatement("select * from especie");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Especie especie = new Especie();
			especie.setId(rs.getInt("id"));
			especie.setNomeVulgar(rs.getString("nomeVulgar"));
			especie.setNomeCientifico(rs.getString("nomeCientifico"));

			especies.add(especie);
		}
		return especies;
	}

	public Genero buscaPorID(int id) {
		return null;

	}
	
	 public void altera(Especie especie) { 
	     String sql = "update contatos set  where id=? nomeVulgar=? nomeCientifico=?"; 
	     try { 
	         PreparedStatement stmt = getConexao().prepareStatement(sql); 
	         stmt.setLong(2, especie.getId()); 
	         stmt.setString(3, especie.getNomeVulgar());
	         stmt.setString(4, especie.getNomeCientifico());
	         stmt.execute(); 
	         stmt.close(); 
	     } catch (SQLException e) { 
	         throw new RuntimeException(e); 
	     } 
	 } 

	public void remove(Especie especie) {
		try {
			PreparedStatement stmt = getConexao().prepareStatement("delete from especie where id=?");
			stmt.setLong(1, especie.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	

}
