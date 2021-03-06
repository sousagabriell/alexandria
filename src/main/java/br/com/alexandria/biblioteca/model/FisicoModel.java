package br.com.alexandria.biblioteca.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_livros")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FisicoModel extends LivroAbstract {

	@NotBlank
	private String edicao;

	@NotBlank
	private String editora;

	
}
