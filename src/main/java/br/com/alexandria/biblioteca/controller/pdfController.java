package br.com.alexandria.biblioteca.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import br.com.alexandria.biblioteca.model.PdfModel;
import br.com.alexandria.biblioteca.repository.PdfRepository;


@RestController
@RequestMapping("/pdf")
@CrossOrigin("*")
public class pdfController {
	
	@Autowired
	private PdfRepository pdfRepository;
	
	@RequestMapping
	public ResponseEntity<List<PdfModel>> getAll(){
		return ResponseEntity.ok(pdfRepository.findAll());
	}
	

	@RequestMapping(params = "id")
	public ResponseEntity<PdfModel> getById(@RequestParam long id) {
		return pdfRepository.findById(id)
			.map(resposta -> ResponseEntity.ok(resposta))
			.orElse(ResponseEntity.notFound().build());
	}
	
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<PdfModel>> getByTitulo(@RequestParam String titulo){
		return ResponseEntity.ok(pdfRepository.findAllByTituloContainingIgnoreCase(titulo));
	}

	
	@PostMapping
	public ResponseEntity<PdfModel> postPostagem (@Valid @RequestBody PdfModel postagem){
		postagem.setTipo_livro("pdf");
		return ResponseEntity.status(HttpStatus.CREATED).body(pdfRepository.save(postagem));
	}
	
	
	@PutMapping
	public ResponseEntity<PdfModel> putPostagem (@Valid @RequestBody PdfModel pdfModel){
		
		return pdfRepository.findById(pdfModel.getId())
			.map(resposta -> ResponseEntity.ok().body(pdfRepository.save(pdfModel)))
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
