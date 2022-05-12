package br.com.alexandria.biblioteca.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alexandria.biblioteca.model.Teses;

@Repository
public interface TesesRepository extends JpaRepository<Teses, Long> {
	public List <Teses> findAllByTituloContainingIgnoreCase(String titulo);

}
