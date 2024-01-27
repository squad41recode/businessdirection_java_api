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

import br.com.businessdirection.models.ModalidadeMentoria;
import br.com.businessdirection.services.ModalidadeMentoriaService;

@Controller
@RequestMapping("/api/modalidades-mentorias")
public class ModalidadeMentoriaController {

	@Autowired
	private ModalidadeMentoriaService service;

	@GetMapping
	public ResponseEntity<List<ModalidadeMentoria>> findAll() {
		List<ModalidadeMentoria> modalidadeMentorias = service.findAll();

		return ResponseEntity.ok().body(modalidadeMentorias);
	}

    @GetMapping("/sem-conteudo")
    public ResponseEntity<List<ModalidadeMentoria>> findAllWithoutConteudo() {
        List<ModalidadeMentoria> modalidadesSemConteudo = service.findAllWithoutConteudo();
        return ResponseEntity.ok().body(modalidadesSemConteudo);
    }

	@GetMapping("/{id}")
	public ResponseEntity<ModalidadeMentoria> findById(@PathVariable Long id) {
		ModalidadeMentoria modalidadeMentoria = service.findById(id);

		return ResponseEntity.ok().body(modalidadeMentoria);
	}

	@PostMapping
	public ResponseEntity<Void> create(@RequestBody ModalidadeMentoria modalidadeMentoria) {
		// UF estados = UF.values();
		this.service.create(modalidadeMentoria);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(modalidadeMentoria.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody ModalidadeMentoria modalidadeMentoria, @PathVariable Long id) {
		modalidadeMentoria.setId(id);
		this.service.update(modalidadeMentoria);

		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		service.delete(id);

		return ResponseEntity.noContent().build();
	}
}
