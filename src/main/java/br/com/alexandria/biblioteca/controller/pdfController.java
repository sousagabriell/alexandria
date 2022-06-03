package br.com.alexandria.biblioteca.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import br.com.alexandria.biblioteca.model.Pdf;
import br.com.alexandria.biblioteca.repository.PdfRepository;


@RestController
@RequestMapping("/livrospdf")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class pdfController {
	
	@Autowired
	private PdfRepository pdfRepository;
	
	@GetMapping
	public ResponseEntity<List<Pdf>> getAll(){
		return ResponseEntity.ok(pdfRepository.findAll());
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<Pdf> getById(@RequestParam long id) {
		return pdfRepository.findById(id)
			.map(resposta -> ResponseEntity.ok(resposta))
			.orElse(ResponseEntity.notFound().build());
	}
	
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Pdf>> getByTitulo(@RequestParam String titulo){
		return ResponseEntity.ok(pdfRepository.findAllByTituloContainingIgnoreCase(titulo));
	}

	
	@PostMapping
	public ResponseEntity<Pdf> postPostagem (@Valid @RequestBody Pdf postagem){
		return ResponseEntity.status(HttpStatus.CREATED).body(pdfRepository.save(postagem));
	}
	
	
	@PutMapping
	public ResponseEntity<Pdf> putPostagem (@Valid @RequestBody Pdf pdf){
		
		return pdfRepository.findById(pdf.getId())
			.map(resposta -> ResponseEntity.ok().body(pdfRepository.save(pdf)))
			.orElse(ResponseEntity.notFound().build());
	}
			
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteLivros(@PathVariable long id) {
		
		return pdfRepository.findById(id)
				.map(resposta -> {
					pdfRepository.deleteById(id);
					return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				})
				.orElse(ResponseEntity.notFound().build());
}

}
