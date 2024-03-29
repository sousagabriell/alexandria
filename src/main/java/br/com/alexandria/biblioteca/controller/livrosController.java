package br.com.alexandria.biblioteca.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.alexandria.biblioteca.model.FisicoModel;
import br.com.alexandria.biblioteca.repository.LivrosRepository;

@RestController
@RequestMapping("/fisico")
@CrossOrigin("*")

public class livrosController {
	
	@Autowired
	private LivrosRepository livrosRepository;
	
	@RequestMapping
	public ResponseEntity<List<FisicoModel>> getAll(){
		return ResponseEntity.ok(livrosRepository.findAll());
	}
	

	@RequestMapping(params = "id")
	public ResponseEntity<FisicoModel> getById(@RequestParam long id) {
		return livrosRepository.findById(id)
			.map(resposta -> ResponseEntity.ok(resposta))
			.orElse(ResponseEntity.notFound().build());
	}
	
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<FisicoModel>> getByTitulo(@RequestParam String titulo){
		return ResponseEntity.ok(livrosRepository.findAllByTituloContainingIgnoreCase(titulo));
	}

	
	@PostMapping
	public ResponseEntity<FisicoModel> postPostagem (@Valid @RequestBody FisicoModel postagem){
		postagem.setTipo_livro("fisico");
		return ResponseEntity.status(HttpStatus.CREATED).body(livrosRepository.save(postagem));
	}
	
	
	@PutMapping
	public ResponseEntity<FisicoModel> putPostagem (@Valid @RequestBody FisicoModel fisicoModel){
		
		return livrosRepository.findById(fisicoModel.getId())
			.map(resposta -> ResponseEntity.ok().body(livrosRepository.save(fisicoModel)))
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
