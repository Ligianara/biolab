package br.edu.ifpi.biolab.Visao;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.ifpi.biolab.Controle.EspecieControle;
import br.edu.ifpi.biolab.Entidade.Especie ;

public class EspecieVisao {

	
	private EspecieControle especieControle;

	public EspecieVisao()throws SQLException  {
		especieControle = new EspecieControle();
	}

	public void adiciona(Especie especie ) throws SQLException {
		especieControle.adiciona(especie );
	}

	public void altera(Especie especie ) throws SQLException {
		especieControle.altera(especie );
	}

	public void remove(Especie especie ) throws SQLException {
		especieControle.remove(especie );
	}

	public static void main(String[] args) throws SQLException {

		EspecieVisao visao = new EspecieVisao();

		int opcaoEscolhida = 1;
		 while (opcaoEscolhida  !=0){

		String menu = "1- Consultar \n 2- Adicionar\n  0-Sir";

		String valorDigitado = JOptionPane.showInputDialog(menu);
		opcaoEscolhida = Integer.parseInt(valorDigitado);
		Especie  e;

		switch (opcaoEscolhida) {
		
		
		case 1:
			List<Especie > especies = visao.buscaTodosEspecies();
			String especiesTela = "";
			for (Especie especie  : especies) {
				especiesTela = especiesTela + especie.getId() + "-" + especie.getNomeVulgar() + "\n";
			}
			JOptionPane.showMessageDialog(null, especiesTela);
			break;
		
		case 2:
			String nomeEspecie  = JOptionPane.showInputDialog("digite o nome da Especie .");
			e = new Especie ();
			visao.adicionar(e);
			break;
		
		case 3: 
			e = new Especie ();
			visao.altera(e);
			break;
			
		case 4:
			e = new Especie ();
			visao.remove (e);
			break;
		 }
	}
	}

	public List<Especie > buscaTodosEspecies() throws SQLException {
		List<Especie > especies = especieControle.buscaTodos();
		return especies;
	}

	public void adicionar(Especie especie ) throws SQLException {
		especieControle.adiciona(especie );
	}
}


