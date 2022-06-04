package br.com.alexandria.biblioteca.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.alexandria.biblioteca.model.TeseModel;
import br.com.alexandria.biblioteca.repository.TesesRepository;

@RestController
@RequestMapping("/teses")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class tesesController {

	@Autowired
	private TesesRepository tesesRepository;
	
	@GetMapping
	public ResponseEntity<List<TeseModel>> getAll(){
		return ResponseEntity.ok(tesesRepository.findAll());
	}
	

	@GetMapping
	public ResponseEntity<TeseModel> getById(@RequestParam(name = "id") long id) {
		return tesesRepository.findById(id)
			.map(ResponseEntity::ok)
			.orElse(ResponseEntity.notFound().build());
	}
	
	
	@GetMapping("/titulo")
	public ResponseEntity<List<TeseModel>> getByTitulo(@RequestParam(name = "titulo") String titulo){
		return ResponseEntity.ok(tesesRepository.findAllByTituloContainingIgnoreCase(titulo));
	}

	
	@PostMapping
	public ResponseEntity<TeseModel> postPostagem (@Valid @RequestBody TeseModel postagem){
		postagem.setTipo_livro("tese");
		return ResponseEntity.status(HttpStatus.CREATED).body(tesesRepository.save(postagem));
	}
	
	
	@PutMapping
	public ResponseEntity<TeseModel> putPostagem (@Valid @RequestBody TeseModel teseModel){
		
		return tesesRepository.findById(teseModel.getId())
			.map(resposta -> ResponseEntity.ok().body(tesesRepository.save(teseModel)))
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
