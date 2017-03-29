package br.edu.ifpi.biolab.Visao;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.ifpi.biolab.Controle.FamiliaControle;
import br.edu.ifpi.biolab.Entidade.Familia;

public class FamiliaVisao {


	private FamiliaControle familiaControle;

	public FamiliaVisao()throws SQLException  {
		FamiliaControle familaControle = new FamiliaControle();
	}

	public void adiciona(Familia familia) throws SQLException {
		familiaControle.adiciona(familia);
	}

	public void altera(Familia familia) throws SQLException {
		familiaControle.altera(familia);
	}

	public void remove(Familia familia) throws SQLException {
		familiaControle.remove(familia);
	}

	public static void main(String[] args) throws SQLException {

		FamiliaVisao visao = new FamiliaVisao();

		int opcaoEscolhida = 1;
		 while (opcaoEscolhida  !=0){

		String menu = "1- Consultar \n 2- Adicionar\n  0-Sir";

		String valorDigitado = JOptionPane.showInputDialog(menu);
		opcaoEscolhida = Integer.parseInt(valorDigitado);
		Familia F;

		switch (opcaoEscolhida) {
		
		
		case 1:
			List<Familia> familias = visao.buscaTodosFamilias();
			String familiasTela = "";
			for (Familia familia :familias) {
				familiasTela = familiasTela + familia.getId() + "-" + familia.getNome() + "\n";
			}
			JOptionPane.showMessageDialog(null, familiasTela);
			break;
		
		case 2:
			String nomeFamilia = JOptionPane.showInputDialog("digite o nome do Familia");
			F = new Familia(opcaoEscolhida, nomeFamilia, null);
			visao.adicionar(F);
			break;
		
		case 3: 
			F = new Familia(opcaoEscolhida, "Familia vv", null);
			visao.altera(F);
			break;
			
		case 4:
			F = new Familia(opcaoEscolhida, "Familiavv", null);
			visao.remove (F);
			break;
		 }
	}
	}

	public List<Familia> buscaTodosFamilias() throws SQLException {
		List<Familia> familias = familiaControle.buscaTodos();
		return familias;
	}

	public void adicionar(Familia familia) throws SQLException {
		familiaControle.adiciona(familia);
	}
}

