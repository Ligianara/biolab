package br.edu.ifpi.biolab.Controle;

import java.sql.SQLException;
import java.util.List;

import br.edu.ifpi.biolab.Dao.ClasseDao;
import br.edu.ifpi.biolab.Dao.GeneroDao;
import br.edu.ifpi.biolab.Entidade.Classe;
import br.edu.ifpi.biolab.Entidade.Genero;

public class ClasseControle {
	private ClasseDao classeDao;

	public ClasseControle() {
		classeDao = new ClasseDao();
	}

	public void adiciona(Classe classe) throws SQLException {
		classeDao.adicionar(classe);
		classeDao.fechaConexao();
	}

	public List<Classe> buscaTodos() throws SQLException {
		List<Classe> classes = classeDao.buscaTodos();
		classeDao.fechaConexao();
		return classes;

	}
	public void altera(Classe classe) throws SQLException {
		classeDao.altera(classe);
		classeDao.fechaConexao();
	}
	public void remove(Classe classe) throws SQLException {
		classeDao.remove(classe);
		classeDao.fechaConexao();
	}

}
