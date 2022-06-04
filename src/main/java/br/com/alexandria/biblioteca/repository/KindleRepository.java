package br.com.alexandria.biblioteca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alexandria.biblioteca.model.KindleModel;

@Repository
public interface KindleRepository extends JpaRepository<KindleModel, Long>{
	
	public List <KindleModel> findAllByTituloContainingIgnoreCase(String titulo);

}
