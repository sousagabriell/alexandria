package br.com.alexandria.biblioteca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alexandria.biblioteca.model.Pdf;

@Repository
public interface PdfRepository extends JpaRepository <Pdf, Long> {
	public List <Pdf> findAllByTituloContainingIgnoreCase(String titulo);
}
