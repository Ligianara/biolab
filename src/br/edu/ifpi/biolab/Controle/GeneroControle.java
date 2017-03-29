package br.edu.ifpi.biolab.Controle;

import java.sql.SQLException;
import java.util.List;

import br.edu.ifpi.biolab.Dao.GeneroDao;
import br.edu.ifpi.biolab.Entidade.Genero;

public class GeneroControle {
	private GeneroDao generoDao;

	public GeneroControle() {
		generoDao = new GeneroDao();
	}

	public void adiciona(Genero genero) throws SQLException {
		generoDao.adicionar(genero);
		generoDao.fechaConexao();
	}

	public List<Genero> buscaTodos() throws SQLException {
		List<Genero> generos = generoDao.buscaTodos();
		generoDao.fechaConexao();
		return generos;

	}
	public void altera(Genero genero) throws SQLException {
		generoDao.altera(genero);
		generoDao.fechaConexao();
	}
	public void remove(Genero genero) throws SQLException {
		generoDao.remove(genero);
		generoDao.fechaConexao();
	}
}
