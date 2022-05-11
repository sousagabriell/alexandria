package br.com.alexandria.biblioteca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alexandria.biblioteca.model.Livros;

@Repository
public interface LivrosRepository extends JpaRepository<Livros, Long> {

	public List <Livros> findAllByTituloContainingIgnoreCase(String titulo);
	
	public List <Livros> findAllByAutorContainingIgnoreCase(String autor);
	
}