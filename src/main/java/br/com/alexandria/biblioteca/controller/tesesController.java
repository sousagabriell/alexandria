package br.com.alexandria.biblioteca.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.alexandria.biblioteca.model.Teses;
import br.com.alexandria.biblioteca.repository.TesesRepository;

@RestController
@RequestMapping("/teses")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class tesesController {

	@Autowired
	private TesesRepository tesesRepository;
	
	@GetMapping
	public ResponseEntity<List<Teses>> getAll(){
		return ResponseEntity.ok(tesesRepository.findAll());
	}
	

	@GetMapping("/id")
	public ResponseEntity<Teses> getById(@RequestParam long id) {
		return tesesRepository.findById(id)
			.map(resposta -> ResponseEntity.ok(resposta))
			.orElse(ResponseEntity.notFound().build());
	}
	
	
	@GetMapping("/titulo")
	public ResponseEntity<List<Teses>> getByTitulo(@RequestParam String titulo){
		return ResponseEntity.ok(tesesRepository.findAllByTituloContainingIgnoreCase(titulo));
	}

	
	@PostMapping
	public ResponseEntity<Teses> postPostagem (@Valid @RequestBody Teses postagem){
		return ResponseEntity.status(HttpStatus.CREATED).body(tesesRepository.save(postagem));
	}
	
	
	@PutMapping
	public ResponseEntity<Teses> putPostagem (@Valid @RequestBody Teses teses){
		
		return tesesRepository.findById(teses.getId())
			.map(resposta -> ResponseEntity.ok().body(tesesRepository.save(teses)))
			.orElse(ResponseEntity.notFound().build());
	}
			
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteLivros(@PathVariable long id) {
		
		return tesesRepository.findById(id)
				.map(resposta -> {
					tesesRepository.deleteById(id);
					return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				})
				.orElse(ResponseEntity.notFound().build());
}
}
