package br.edu.ifpi.biolab.Entidade;

public class Ordem {
	private int id;
	private String nome;
	private Classe classe;

	public Ordem(){
		
	}
	
	public Ordem(int id, String nome, Classe classe) {
		this.id = id;
		this.nome = nome;
		this.classe = classe;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
}
