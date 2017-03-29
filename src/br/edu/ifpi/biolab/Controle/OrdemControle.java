package br.edu.ifpi.biolab.Controle;

import java.sql.SQLException;
import java.util.List;

import br.edu.ifpi.biolab.Dao.OrdemDao;
import br.edu.ifpi.biolab.Entidade.Ordem;

public class OrdemControle {
	private static OrdemDao ordemDao;

	public OrdemControle() {
		ordemDao = new OrdemDao();
	}

	public static void adiciona(Ordem ordem) throws SQLException {
		ordemDao.adicionar(ordem);
		ordemDao.fechaConexao();
	}

	public List<Ordem> buscaTodos() throws SQLException {
		List<Ordem> ordens = ordemDao.buscaTodos();
		ordemDao.fechaConexao();
		return ordens;

	}
	public void altera(Ordem ordem) throws SQLException {
		ordemDao.altera(ordem);
		ordemDao.fechaConexao();
	}
	public void remove(Ordem ordem) throws SQLException {
		ordemDao.remove(ordem);
		ordemDao.fechaConexao();
}
}
