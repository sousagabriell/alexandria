package br.com.alexandria.biblioteca.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.alexandria.biblioteca.model.Kindle;
import br.com.alexandria.biblioteca.repository.KindleRepository;


@RestController
@RequestMapping("livroskindle")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class kindleController {
	
	@Autowired
	private KindleRepository kindleRepository;
	
	@GetMapping
	public ResponseEntity<List<Kindle>> getAll(){
		return ResponseEntity.ok(kindleRepository.findAll());
	}
	

	@GetMapping("/id")
	public ResponseEntity<Kindle> getById(@RequestParam long id) {
		return kindleRepository.findById(id)
			.map(resposta -> ResponseEntity.ok(resposta))
			.orElse(ResponseEntity.notFound().build());
	}


	@GetMapping("/titulo")
	public ResponseEntity<List<Kindle>> getByTitulo(@RequestParam String titulo){
		return ResponseEntity.ok(kindleRepository.findAllByTituloContainingIgnoreCase(titulo));
	}

	
	@PostMapping
	public ResponseEntity<Kindle> postPostagem (@Valid @RequestBody Kindle postagem){
		return ResponseEntity.status(HttpStatus.CREATED).body(kindleRepository.save(postagem));
	}
	
	
	@PutMapping
	public ResponseEntity<Kindle> putPostagem (@Valid @RequestBody Kindle kindle){
		
		return kindleRepository.findById(kindle.getId())
			.map(resposta -> ResponseEntity.ok().body(kindleRepository.save(kindle)))
			.orElse(ResponseEntity.notFound().build());
	}
			
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteKindle(@PathVariable long id) {
		
		return kindleRepository.findById(id)
				.map(resposta -> {
					kindleRepository.deleteById(id);
					return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				})
				.orElse(ResponseEntity.notFound().build());
}
}
