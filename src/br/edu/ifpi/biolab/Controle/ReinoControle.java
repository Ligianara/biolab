package br.edu.ifpi.biolab.Controle;

import java.sql.SQLException;
import java.util.List;

import br.edu.ifpi.biolab.Dao.ReinoDao;
import br.edu.ifpi.biolab.Entidade.Reino;

public class ReinoControle {
	private ReinoDao reinoDao;

	public ReinoControle() {
		reinoDao = new ReinoDao();
	}

	public void adicionar(Reino reino) throws SQLException {
		reinoDao.adicionar(reino);
		reinoDao.fechaConexao();
	}

	public List<Reino> buscaTodos() throws SQLException {
		List<Reino> reinos = reinoDao.buscaTodos();
		reinoDao.fechaConexao();
		return reinos;

	}

	public void altera(Reino reino) throws SQLException {
		reinoDao.altera(reino);
		reinoDao.fechaConexao();
	}
	
	public void remove(Reino reino) throws SQLException {
		reinoDao.remove(reino);
		reinoDao.fechaConexao();
	}
}
