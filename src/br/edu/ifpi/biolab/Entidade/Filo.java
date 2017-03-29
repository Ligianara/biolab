package br.edu.ifpi.biolab.Entidade;

public class Filo {

	private int id;
	private String nome;
	private Reino reino;

	public Filo(){
		
	}
	
	public Filo(int id, String nome, Reino reino) {
		this.id = id;
		this.nome = nome;
		this.reino = reino;

	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Reino getReino() {
		return reino;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setReino(Reino reino) {
		this.reino = reino;
	}
	
	

}
