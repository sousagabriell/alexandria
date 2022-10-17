package br.com.alexandria.biblioteca.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "tb_usuarios")
@Getter
@Setter
public class Usuario {

	@Id
	@Column(name = "id_usuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "nome_usuario")
	@NotNull
	private String nome;

	@Column(name = "email_usuario")
	@NotNull
	private String email;

	@Column(name = "usuario")
	@NotNull
	private String usuario;

	@Column(name = "foto_usuario")
	@NotNull
	private String foto;

	@Column(name = "senha_usuario")
	@NotNull
	@Size(min = 6)
		private String senha;

	@Temporal(TemporalType.TIMESTAMP)
	private Date data_usuario = new java.sql.Date(System.currentTimeMillis());
}