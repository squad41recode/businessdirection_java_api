package br.com.businessdirection.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.businessdirection.models.EmpreendedorMentoria;
import br.com.businessdirection.services.EmpreendedorMentoriaService;

@Controller
@RequestMapping("/api/mentorias-adquiridas")
public class EmpreendedorMentoriaController {

	@Autowired
	private EmpreendedorMentoriaService empreendedorMentoriaService;

	@GetMapping
	public ResponseEntity<List<EmpreendedorMentoria>> findAll() {
		List<EmpreendedorMentoria> conteudosOnline = empreendedorMentoriaService.findAll();
		return ResponseEntity.ok().body(conteudosOnline);
	}

	@GetMapping("/{id}")
	public ResponseEntity<EmpreendedorMentoria> findById(@PathVariable Long id) {
		EmpreendedorMentoria empreendedorMentoria = empreendedorMentoriaService.findById(id);
		return ResponseEntity.ok().body(empreendedorMentoria);
	}

	@PostMapping
	public ResponseEntity<Void> create(@RequestBody EmpreendedorMentoria empreendedorMentoria) {
		empreendedorMentoriaService.create(empreendedorMentoria, empreendedorMentoria.getEmpreendedor().getId(),
				empreendedorMentoria.getMentorModalidade().getId());

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(empreendedorMentoria.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody EmpreendedorMentoria empreendedorMentoria, @PathVariable Long id) {
		empreendedorMentoria.setId(id);
		empreendedorMentoriaService.update(empreendedorMentoria);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		empreendedorMentoriaService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
