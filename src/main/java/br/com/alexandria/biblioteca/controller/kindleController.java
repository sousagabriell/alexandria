package br.com.alexandria.biblioteca.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.alexandria.biblioteca.model.KindleModel;
import br.com.alexandria.biblioteca.repository.KindleRepository;


@RestController
@RequestMapping("/kindle")
@CrossOrigin("*")
public class kindleController {
	
	@Autowired
	private KindleRepository kindleRepository;
	
	@RequestMapping
	public ResponseEntity<List<KindleModel>> getAll(){
		return ResponseEntity.ok(kindleRepository.findAll());
	}
	

	@RequestMapping(params = "id")
	public ResponseEntity<KindleModel> getById(@RequestParam long id) {
		return kindleRepository.findById(id)
			.map(resposta -> ResponseEntity.ok(resposta))
			.orElse(ResponseEntity.notFound().build());
	}


	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<KindleModel>> getByTitulo(@RequestParam String titulo){
		return ResponseEntity.ok(kindleRepository.findAllByTituloContainingIgnoreCase(titulo));
	}

	
	@PostMapping
	public ResponseEntity<KindleModel> postPostagem (@Valid @RequestBody KindleModel postagem){
		postagem.setTipo_livro("kindle");
		return ResponseEntity.status(HttpStatus.CREATED).body(kindleRepository.save(postagem));
	}
	
	
	@PutMapping
	public ResponseEntity<KindleModel> putPostagem (@Valid @RequestBody KindleModel kindleModel){
		
		return kindleRepository.findById(kindleModel.getId())
			.map(resposta -> ResponseEntity.ok().body(kindleRepository.save(kindleModel)))
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
