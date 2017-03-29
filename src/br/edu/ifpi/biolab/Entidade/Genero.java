package br.edu.ifpi.biolab.Entidade;

public class Genero {
	private int id;
	private String nome;
	private Familia familia;
	
	public Genero(String nome) {
		this.nome = nome;
	}

	public Genero(int id, String nome, Familia familia) {
		this.id = id;
		this.nome = nome;
		this.familia = familia;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;

	}

	public Familia getFamilia() {
		return familia;
	}

	public Genero getOrdem() {
		return null;
	}

	public void setId(int int1) {
		
	}

	public void setNome(String string) {
	}

}
