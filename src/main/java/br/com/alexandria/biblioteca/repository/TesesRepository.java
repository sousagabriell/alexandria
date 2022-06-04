package br.com.alexandria.biblioteca.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alexandria.biblioteca.model.TeseModel;

@Repository
public interface TesesRepository extends JpaRepository<TeseModel, Long> {
	public List <TeseModel> findAllByTituloContainingIgnoreCase(String titulo);

}
