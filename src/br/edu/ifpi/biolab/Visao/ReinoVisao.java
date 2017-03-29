package br.edu.ifpi.biolab.Visao;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.ifpi.biolab.Controle.ReinoControle;
import br.edu.ifpi.biolab.Entidade.Reino;

public class ReinoVisao {
	
	private ReinoControle reinoControle;

	public ReinoVisao()throws SQLException  {
		reinoControle = new ReinoControle();
	}

	public void adiciona(Reino reino) throws SQLException {
		reinoControle.adicionar(reino);
	}

	public void altera(Reino reino) throws SQLException {
		reinoControle.altera(reino);
	}

	public void remove(Reino reino) throws SQLException {
		reinoControle.remove(reino);
	}

	public static void main(String[] args) throws SQLException {

		ReinoVisao visao = new ReinoVisao();

		int opcaoEscolhida = 1;
		 while (opcaoEscolhida  !=0){

		String menu = "1- Consultar \n 2- Adicionar\n  0-Sir";

		String valorDigitado = JOptionPane.showInputDialog(menu);
		opcaoEscolhida = Integer.parseInt(valorDigitado);
		Reino r;

		switch (opcaoEscolhida) {
		
		
		case 1:
			List<Reino> reinos = visao.buscaTodosReinos();
			String reinosTela = "";
			for (Reino reino : reinos) {
				reinosTela = reinosTela + reino.getId() + "-" + reino.getNome() + "\n";
			}
			JOptionPane.showMessageDialog(null, reinosTela);
			break;
		
		case 2:
			String nomeReino = JOptionPane.showInputDialog("digite o nome do Reino.");
			r = new Reino(nomeReino);
			visao.adicionar(r);
			break;
		
		case 3: 
			r = new Reino("Reino vv");
			visao.altera(r);
			break;
			
		case 4:
			r = new Reino("Reino vv");
			visao.remove (r);
			break;
		 }
	}
	}

	public List<Reino> buscaTodosReinos() throws SQLException {
		List<Reino> reinos = reinoControle.buscaTodos();
		return reinos;
	}

	public void adicionar(Reino reino) throws SQLException {
		reinoControle.adicionar(reino);
	}
}
