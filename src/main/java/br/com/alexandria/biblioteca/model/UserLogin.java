package br.com.alexandria.biblioteca.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLogin {

	private String nome;

	private String usuario;

	private String senha;

	private String foto;

	private String token;


}
