package br.edu.ifpi.biolab.Controle;

import java.sql.SQLException;
import java.util.List;

import br.edu.ifpi.biolab.Dao.FiloDao;
import br.edu.ifpi.biolab.Entidade.Filo;

public class FiloControle {
	private FiloDao filoDao;

	public FiloControle() {
		filoDao = new FiloDao();
	}

	public void adiciona(Filo filo) throws SQLException {
		filoDao.adicionar(filo);
		filoDao.fechaConexao();
	}

	public List<Filo> buscaTodos() throws SQLException {
		List<Filo> filos = filoDao.buscaTodos();
		filoDao.fechaConexao();
		return filos;

	}
	public void altera(Filo filo) throws SQLException {
		filoDao.altera(filo);
		filoDao.fechaConexao();
	}
	public void remove(Filo filo) throws SQLException {
		filoDao.remove(filo);
		filoDao.fechaConexao();
	}
}
