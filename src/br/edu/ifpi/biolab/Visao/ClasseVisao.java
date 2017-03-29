package br.edu.ifpi.biolab.Visao;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.ifpi.biolab.Controle.ClasseControle;
import br.edu.ifpi.biolab.Entidade.Classe;

public class ClasseVisao {

	private ClasseControle classeControle;

	public ClasseVisao()throws SQLException  {
		classeControle = new ClasseControle();
	}

	public void adiciona(Classe classe) throws SQLException {
		classeControle.adiciona(classe);
	}

	public void altera(Classe classe) throws SQLException {
		classeControle.altera(classe);
	}

	public void remove(Classe classe ) throws SQLException {
		classeControle.remove(classe );
	}

	public static void main(String[] args) throws SQLException {

		ClasseVisao visao = new ClasseVisao();

		int opcaoEscolhida = 1;
		 while (opcaoEscolhida  !=0){

		String menu = "1- Consultar \n 2- Adicionar\n  0-Sir";

		String valorDigitado = JOptionPane.showInputDialog(menu);
		opcaoEscolhida = Integer.parseInt(valorDigitado);
		Classe  c;

		switch (opcaoEscolhida) {
		
		
		case 1:
			List<Classe > classes = visao.buscaTodoclasses();
			String ClassesTela = "";
			for (Classe classe  : classes) {
				ClassesTela = ClassesTela + classe.getId() + "-" + classe.getNome() + "\n";
			}
			JOptionPane.showMessageDialog(null, ClassesTela);
			break;
		
		case 2:
			String nomeClasse  = JOptionPane.showInputDialog("digite o nome do Reino.");
			c = new Classe (opcaoEscolhida, nomeClasse, null );
			visao.adicionar(c);
			break;
		
		case 3: 
			c = new Classe (opcaoEscolhida, "Classe  vv", null);
			visao.altera(c);
			break;
			
		case 4:
			c = new Classe (opcaoEscolhida, "Classe  vv", null);
			visao.remove (c);
			break;
		 }
	}
	}

	public List<Classe> buscaTodoclasses() throws SQLException {
		List<Classe> reinos = classeControle.buscaTodos();
		return reinos;
	}

	public void adicionar(Classe classe) throws SQLException {
		classeControle.adiciona(classe);
	}
}


