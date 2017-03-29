package br.edu.ifpi.biolab.Controle;

import java.sql.SQLException;
import java.util.List;

import br.edu.ifpi.biolab.Dao.EspecieDao;
import br.edu.ifpi.biolab.Entidade.Especie;

public class EspecieControle {
	private EspecieDao especieDao;

	public EspecieControle() {
		especieDao = new EspecieDao();
	}

	public void adiciona(Especie especie) throws SQLException {
		especieDao.adicionar(especie);
		especieDao.fechaConexao();
	}

	public List<Especie> buscaTodos() throws SQLException {
		List<Especie> especies = especieDao.buscaTodos();
		especieDao.fechaConexao();
		return especies;

	}

	public void altera(Especie especie) throws SQLException {
		especieDao.altera(especie);
		especieDao.fechaConexao();
	}

	public void remove(Especie especie) throws SQLException {
		especieDao.remove(especie);
		especieDao.fechaConexao();
	}
}
