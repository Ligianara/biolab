package br.edu.ifpi.biolab.Dao;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class Dao {
	private Connection conexao;

	public Dao() {
		try {
			this.conexao = ConnectionFactory.getConexao();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Connection getConexao() {
		return conexao;
	}

	public void fechaConexao() {
		try {
			this.conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}
}
