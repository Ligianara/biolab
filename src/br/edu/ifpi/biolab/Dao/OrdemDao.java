package br.edu.ifpi.biolab.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpi.biolab.Entidade.Classe;
import br.edu.ifpi.biolab.Entidade.Ordem;


public class OrdemDao extends Dao {
	public void adicionar(Ordem ordem) throws SQLException {
		String sql = "insert into ordem " + "(nome,id,id_classe) values (?,?,?)";

		PreparedStatement stmt = super.getConexao().prepareStatement(sql);

		stmt.setString(1, ordem.getNome());
		stmt.setInt(2, ordem.getId());
		stmt.setInt(3, ordem.getClasse().getId());

		stmt.execute();
		stmt.close();
		System.out.println("Classe Adicionada!");
	}

	public List<Ordem> buscaTodos() throws SQLException {
		List<Ordem> ordens = new ArrayList<>();
		Connection conexao = ConnectionFactory.getConexao();
		PreparedStatement stmt = conexao.prepareStatement("select * from classe");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Ordem ordem = new Ordem();
			ordem.setId(rs.getInt("id"));
			ordem.setNome(rs.getString("nome"));
			ordens.add(ordem);
		}
		return ordens;
	}

	public Classe buscaPorID(int id) {
		return null;

	}

	 public void altera(Ordem ordem) { 
	     String sql = "update contatos set  where id=? nomeVulgar=? nomeCientifico=?"; 
	     try { 
	         PreparedStatement stmt = getConexao().prepareStatement(sql); 
	         stmt.setLong(2, ordem.getId()); 
	         stmt.setString(1, ordem.getNome());
	         stmt.execute(); 
	         stmt.close(); 
	     } catch (SQLException e) { 
	         throw new RuntimeException(e); 
	     } 
	 } 

	public void remove(Ordem ordem) {
		try {
			PreparedStatement stmt = getConexao().prepareStatement("delete from ordem where id=?");
			stmt.setLong(1, ordem.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
