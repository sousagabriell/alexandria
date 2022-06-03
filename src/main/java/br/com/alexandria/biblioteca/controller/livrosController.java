package br.com.alexandria.biblioteca.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
	

	@GetMapping("/id")
	public ResponseEntity<Livros> getById(@RequestParam long id) {
		return livrosRepository.findById(id)
			.map(resposta -> ResponseEntity.ok(resposta))
			.orElse(ResponseEntity.notFound().build());
	}
	
	
	@GetMapping("/titulo")
	public ResponseEntity<List<Livros>> getByTitulo(@RequestParam String titulo){
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
