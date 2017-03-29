package br.edu.ifpi.biolab.Visao;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.ifpi.biolab.Controle.FiloControle;
import br.edu.ifpi.biolab.Entidade.Filo;

public class FiloVisao {

	
	private FiloControle filoControle;

	public FiloVisao()throws SQLException  {
		filoControle = new FiloControle();
	}

	public void adiciona(Filo filo) throws SQLException {
		filoControle.adiciona(filo);
	}

	public void altera(Filo filo) throws SQLException {
		filoControle.altera(filo);
	}

	public void remove(Filo filo) throws SQLException {
		filoControle.remove(filo);
	}

	public static void main(String[] args) throws SQLException {

		FiloVisao visao = new FiloVisao();

		int opcaoEscolhida = 1;
		 while (opcaoEscolhida  !=0){

		String menu = "1- Consultar \n 2- Adicionar\n  0-Sir";

		String valorDigitado = JOptionPane.showInputDialog(menu);
		opcaoEscolhida = Integer.parseInt(valorDigitado);
		Filo f;

		switch (opcaoEscolhida) {
		
		
		case 1:
			List<Filo> filos = visao.buscaTodosFilos();
			String filosTela = "";
			for (Filo filo : filos) {
				filosTela = filosTela + filo.getId() + "-" + filo.getNome() + "\n";
			}
			JOptionPane.showMessageDialog(null, filosTela);
			break;
		
		case 2:
			String nomeFilo = JOptionPane.showInputDialog("digite o nome do Filo.");
			f = new Filo(opcaoEscolhida, nomeFilo, null);
			visao.adicionar(f);
			break;
		
		case 3: 
			f = new Filo(opcaoEscolhida, "Filo vv", null);
			visao.altera(f);
			break;
			
		case 4:
			f = new Filo(opcaoEscolhida, "Filovv", null);
			visao.remove (f);
			break;
		 }
	}
	}

	public List<Filo> buscaTodosFilos() throws SQLException {
		List<Filo> filos = filoControle.buscaTodos();
		return filos;
	}

	public void adicionar(Filo filo) throws SQLException {
		filoControle.adiciona(filo);
	}
}



