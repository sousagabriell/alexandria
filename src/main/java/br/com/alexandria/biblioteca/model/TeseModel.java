package br.com.alexandria.biblioteca.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="tb_teses")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TeseModel extends LivroAbstract{

	@NotBlank
	private String instituicao;

	@NotBlank
	private String pasta;

	@NotBlank
	private String tipo;
}
