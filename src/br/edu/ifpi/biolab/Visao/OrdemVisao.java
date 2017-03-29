package br.edu.ifpi.biolab.Visao;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.ifpi.biolab.Controle.OrdemControle;
import br.edu.ifpi.biolab.Entidade.Ordem;

public class OrdemVisao {
	private OrdemControle ordemControle;

	public OrdemVisao()throws SQLException  {
		OrdemControle ordemControle = new OrdemControle();
	}

	public void adiciona(Ordem ordem) throws SQLException {
		OrdemControle.adiciona(ordem);
	}

	public void altera(Ordem ordem) throws SQLException {
		ordemControle.altera(ordem);
	}

	public void remove(Ordem ordem) throws SQLException {
		ordemControle.remove(ordem);
	}

	public static void main(String[] args) throws SQLException {

		OrdemVisao visao = new OrdemVisao();

		int opcaoEscolhida = 1;
		 while (opcaoEscolhida  !=0){

		String menu = "1- Consultar \n 2- Adicionar\n  0-Sir";

		String valorDigitado = JOptionPane.showInputDialog(menu);
		opcaoEscolhida = Integer.parseInt(valorDigitado);
		Ordem o;

		switch (opcaoEscolhida) {
		
		
		case 1:
			List<Ordem> ordems = visao.buscaTodosOrdems1();
			String ordemsTela = "";
			for (Ordem ordem : ordems) {
				ordemsTela = ordemsTela +ordem.getId() + "-" + ordem.getNome() + "\n";
			}
			JOptionPane.showMessageDialog(null, ordemsTela);
			break;
		
		case 2:
			String nomeOrdem = JOptionPane.showInputDialog("digite o nome da Ordem.");
			o = new Ordem(opcaoEscolhida, nomeOrdem, null);
			visao.adiciona(o);
			break;
		
		case 3: 
			o = new Ordem(opcaoEscolhida, "Ordem vv", null);
			visao.altera(o);
			break;
			
		case 4:
			o = new Ordem(opcaoEscolhida, "Ordem vv", null);
			visao.remove (o);
			break;
		 }
	}
	}

	private List<Ordem> buscaTodosOrdems1() {
		
		return null;
	}

	public List<Ordem> buscaTodosOrdems() throws SQLException {
		List<Ordem> ordems = ordemControle.buscaTodos();
		return ordems;
	}

	public void adicionar(Ordem ordem) throws SQLException {
		OrdemControle.adiciona(ordem);
	}
}


