package br.com.businessdirection.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.businessdirection.models.ConteudoOnline;
import br.com.businessdirection.services.ConteudoOnlineService;

@RestController
@RequestMapping("/api/conteudos-online")
public class ConteudoOnlineController {

	@Autowired
	private ConteudoOnlineService conteudoOnlineService;

	@GetMapping
	public ResponseEntity<List<ConteudoOnline>> findAll() {
		List<ConteudoOnline> conteudosOnline = conteudoOnlineService.findAll();
		return ResponseEntity.ok().body(conteudosOnline);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ConteudoOnline> findById(@PathVariable Long id) {
		ConteudoOnline conteudoOnline = conteudoOnlineService.findById(id);
		return ResponseEntity.ok().body(conteudoOnline);
	}

	@PostMapping
	public ResponseEntity<Void> create(@RequestBody ConteudoOnline conteudoOnline) {
		// List<ModalidadeMentoria> modalidades = modalidadeMentoriaService.findAll();
		// conteudoOnline.setModalidadeMentoria(modalidades);
		conteudoOnlineService.create(conteudoOnline,
				conteudoOnline.getModalidadeMentoria().getId());

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(conteudoOnline.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody ConteudoOnline conteudoOnline, @PathVariable Long id) {
		conteudoOnline.setId(id);
		conteudoOnlineService.update(conteudoOnline);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		conteudoOnlineService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
