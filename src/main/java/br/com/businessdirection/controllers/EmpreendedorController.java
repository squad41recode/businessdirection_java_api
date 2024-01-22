package br.com.businessdirection.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.businessdirection.models.Empreendedor;
import br.com.businessdirection.services.EmpreendedorService;

@RestController
@RequestMapping("/api/empreendedores")
@Validated
public class EmpreendedorController {

	@Autowired
	private EmpreendedorService empreendedorService;

	@GetMapping
	public ResponseEntity<List<Empreendedor>> findAll() {
		List<Empreendedor> empreendedores = empreendedorService.findAll();

		return ResponseEntity.ok().body(empreendedores);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Empreendedor> findById(@PathVariable Long id) {
		Empreendedor empreendedor = empreendedorService.findById(id);

		return ResponseEntity.ok().body(empreendedor);
	}

	@PostMapping
	public ResponseEntity<Void> create(@RequestBody Empreendedor empreendedor) {
		// UF estados = UF.values();
		this.empreendedorService.save(empreendedor);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(empreendedor.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody Empreendedor empreendedor, @PathVariable Long id) {
		empreendedor.setId(id);
		this.empreendedorService.update(empreendedor);

		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		empreendedorService.delete(id);

		return ResponseEntity.noContent().build();
	}

}
