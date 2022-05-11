package br.com.alexandria.biblioteca.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="tb_pdf")
public class Pdf {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	

	@NotBlank
	private String autor;
	
	@NotBlank
	private String titulo;
	
	private String subtitulo;
	
	@NotBlank
	private String edicao;
	
	@NotBlank
	private String ano;
	
	@NotBlank
	private String editora;
	
	@NotBlank
	private String cidade;
	
	@NotBlank
	private String genero;
	
	@NotBlank
	private String subgenero;
	
	@NotBlank
	private boolean nacional;
	
	@NotBlank
	private String idioma;
	
	@NotBlank
	private String pasta;
	
	@NotBlank
	private boolean kindle;
	@NotBlank
	private boolean fisico;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSubtitulo() {
		return subtitulo;
	}

	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}

	public String getEdicao() {
		return edicao;
	}

	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getSubgenero() {
		return subgenero;
	}

	public void setSubgenero(String subgenero) {
		this.subgenero = subgenero;
	}

	public boolean isNacional() {
		return nacional;
	}

	public void setNacional(boolean nacional) {
		this.nacional = nacional;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getPasta() {
		return pasta;
	}

	public void setPasta(String pasta) {
		this.pasta = pasta;
	}

	public boolean isKindle() {
		return kindle;
	}

	public void setKindle(boolean kindle) {
		this.kindle = kindle;
	}

	public boolean isFisico() {
		return fisico;
	}

	public void setFisico(boolean fisico) {
		this.fisico = fisico;
	}
	
	
	
}
