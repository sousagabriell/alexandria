package br.com.alexandria.biblioteca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alexandria.biblioteca.model.PdfModel;

@Repository
public interface PdfRepository extends JpaRepository <PdfModel, Long> {
	public List <PdfModel> findAllByTituloContainingIgnoreCase(String titulo);
}
