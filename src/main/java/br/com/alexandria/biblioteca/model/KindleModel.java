package br.com.alexandria.biblioteca.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_kindle")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class KindleModel extends LivroAbstract{

	@NotBlank
	private String edicao;

	@NotBlank
	private String editora;

	@NotNull
	private boolean fisico;
}
