package br.com.alexandria.biblioteca.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alexandria.biblioteca.model.Livros;
import br.com.alexandria.biblioteca.repository.LivrosRepository;

@RestController
@RequestMapping("/livrosfisicos")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class livrosController {
	
	@Autowired
	private LivrosRepository livrosRepository;
	
	@GetMapping
	public ResponseEntity<List<Livros>> getAll(){
		return ResponseEntity.ok(livrosRepository.findAll());
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<Livros> getById(@PathVariable long id) {
		return livrosRepository.findById(id)
			.map(resposta -> ResponseEntity.ok(resposta))
			.orElse(ResponseEntity.notFound().build());
	}
	
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Livros>> getByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(livrosRepository.findAllByTituloContainingIgnoreCase(titulo));
	}

	
	@PostMapping
	public ResponseEntity<Livros> postPostagem (@Valid @RequestBody Livros postagem){
		return ResponseEntity.status(HttpStatus.CREATED).body(livrosRepository.save(postagem));
	}
	
	
	@PutMapping
	public ResponseEntity<Livros> putPostagem (@Valid @RequestBody Livros livros){
		
		return livrosRepository.findById(livros.getId())
			.map(resposta -> ResponseEntity.ok().body(livrosRepository.save(livros)))
			.orElse(ResponseEntity.notFound().build());
	}
			
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteLivros(@PathVariable long id) {
		
		return livrosRepository.findById(id)
				.map(resposta -> {
					livrosRepository.deleteById(id);
					return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				})
				.orElse(ResponseEntity.notFound().build());
}
}
