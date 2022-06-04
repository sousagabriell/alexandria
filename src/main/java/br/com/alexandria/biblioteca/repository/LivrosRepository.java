package br.com.alexandria.biblioteca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alexandria.biblioteca.model.FisicoModel;

@Repository
public interface LivrosRepository extends JpaRepository<FisicoModel, Long> {

	public List <FisicoModel> findAllByTituloContainingIgnoreCase(String titulo);
	
	public List <FisicoModel> findAllByAutorContainingIgnoreCase(String autor);
	
}