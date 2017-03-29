package br.edu.ifpi.biolab.Entidade;

import java.util.Date;

import br.edu.ifpi.biolab.Dao.Entidade;

public class Especie implements Entidade {

	private String nomeVulgar;
	private String nomeCientifico;
	private Date datainclusao;
	private Genero genero;
	private int id;
	
	public Especie() {
	}

	public Especie(String nomeVulgar, String nomeCientifico, Date datainclusao, Genero genero, int id) {
		this.nomeVulgar = nomeVulgar;
		this.nomeCientifico = nomeCientifico;
		this.datainclusao = datainclusao;
		this.genero = genero;
		this.id = id;

	}

	public String getNomeVulgar() {
		return nomeVulgar;
	}

	public String getNomeCientifico() {
		return nomeCientifico;

	}

	public Date getDatainclusao() {
		return datainclusao;
	}

	public Genero getGenero() {
		return genero;
	}

	public int getId() {
		return id;
	}

	public void setNomeVulgar(String nomeVulgar) {
		this.nomeVulgar = nomeVulgar;
	}

	public void setNomeCientifico(String nomeCientifico) {
		this.nomeCientifico = nomeCientifico;
	}

	public void setDatainclusao(Date datainclusao) {
		this.datainclusao = datainclusao;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public void setId(int id) {
		this.id = id;
	}



}