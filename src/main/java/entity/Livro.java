package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Livro { 
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer id;
	
	@Column( nullable = false )
	private String titulo;
	
	private String tituloOriginal;
	
	@Column( nullable = false )
	private String nomeAutor;
	
	private String editora;
	
	@Column( name = "no_paginas" )
	private Integer numeroPaginas;

	@Column( name = "no_edicao" )
	private Integer numeroEdicao;

	public Livro() {
 	}
	
	public Livro( Integer id, String titulo, String tituloOriginal,
			String nomeAutor, String editora,
			Integer numeroPaginas, Integer numeroEdicao ) {
		this.id = id;
		this.titulo = titulo;
		this.tituloOriginal = tituloOriginal;
		this.nomeAutor = nomeAutor;
		this.editora = editora;
		this.numeroPaginas = numeroPaginas;
		this.numeroEdicao = numeroEdicao;
	}

	public Integer getId() {
		return id;
	}

	public void setId( Integer id ) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo( String titulo ) {
		this.titulo = titulo;
	}

	public String getTituloOriginal() {
		return tituloOriginal;
	}

	public void setTituloOriginal( String tituloOriginal ) {
		this.tituloOriginal = tituloOriginal;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public void setNomeAutor( String nomeAutor ) {
		this.nomeAutor = nomeAutor;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora( String editora ) {
		this.editora = editora;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas( Integer numeroPaginas ) {
		this.numeroPaginas = numeroPaginas;
	}

	public Integer getNumeroEdicao() {
		return numeroEdicao;
	}

	public void setNumeroEdicao( Integer numeroEdicao ) {
		this.numeroEdicao = numeroEdicao;
	}

	@Override
	public String toString() {
		return "Livro [id=" + id + ", titulo=" + titulo + ", tituloOriginal=" + tituloOriginal + ", nomeAutor="
				+ nomeAutor + ", editora=" + editora + ", numeroPaginas=" + numeroPaginas + ", numeroEdicao="
				+ numeroEdicao + "]";
	}
	
	
}
