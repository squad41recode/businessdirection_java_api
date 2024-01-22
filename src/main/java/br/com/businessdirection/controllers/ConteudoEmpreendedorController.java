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

import br.com.businessdirection.models.ConteudoEmpreendedor;
import br.com.businessdirection.services.ConteudoEmpreendedorService;

@Controller
@RequestMapping("/api/conteudos-estudados")
public class ConteudoEmpreendedorController {

	@Autowired
	private ConteudoEmpreendedorService conteudoEmpreendedorService;

	@GetMapping
	public ResponseEntity<List<ConteudoEmpreendedor>> findAll() {
		List<ConteudoEmpreendedor> conteudosOnline = conteudoEmpreendedorService.findAll();
		return ResponseEntity.ok().body(conteudosOnline);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ConteudoEmpreendedor> findById(@PathVariable Long id) {
		ConteudoEmpreendedor conteudoEmpreendedor = conteudoEmpreendedorService.findById(id);
		return ResponseEntity.ok().body(conteudoEmpreendedor);
	}

	@PostMapping
	public ResponseEntity<Void> create(@RequestBody ConteudoEmpreendedor conteudoEmpreendedor) {
		conteudoEmpreendedorService.create(conteudoEmpreendedor, conteudoEmpreendedor.getEmpreendedor().getId(),
				conteudoEmpreendedor.getConteudoOnline().getId());

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(conteudoEmpreendedor.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody ConteudoEmpreendedor conteudoEmpreendedor, @PathVariable Long id) {
		conteudoEmpreendedor.setId(id);
		conteudoEmpreendedorService.update(conteudoEmpreendedor);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		conteudoEmpreendedorService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
