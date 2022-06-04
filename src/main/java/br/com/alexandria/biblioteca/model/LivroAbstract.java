package br.com.alexandria.biblioteca.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public abstract class LivroAbstract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String autor;

    @NotBlank
    private String titulo;

    private String subtitulo;

    @NotBlank
    private String ano;

    @NotBlank
    private String cidade;

    @NotBlank
    private String genero;

    @NotBlank
    private String subgenero;

    private boolean nacional;

    @NotBlank
    private String idioma;

    @NotBlank
    private String tipo;
}
