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

import br.com.businessdirection.models.MentorModalidade;
import br.com.businessdirection.services.MentorModalidadeService;

@RestController
@RequestMapping("/api/mentorias-disponiveis")
public class MentorModalidadeController {

	@Autowired
	private MentorModalidadeService mentorModalidadeService;

	@GetMapping("/incluir-indisponiveis")
	public ResponseEntity<List<MentorModalidade>> findAll() {
		List<MentorModalidade> todasMentorias = mentorModalidadeService.findAll();
		return ResponseEntity.ok().body(todasMentorias);
	}

	@GetMapping
	public ResponseEntity<List<MentorModalidade>> findAllDisponiveis() {
		List<MentorModalidade> mentoriasDisponiveis = mentorModalidadeService.findAllDisponiveis();
		return ResponseEntity.ok().body(mentoriasDisponiveis);
	}

	@GetMapping("/{id}")
	public ResponseEntity<MentorModalidade> findById(@PathVariable Long id) {
		MentorModalidade mentorModalidade = mentorModalidadeService.findById(id);
		return ResponseEntity.ok().body(mentorModalidade);
	}

	@PostMapping
	public ResponseEntity<Void> create(@RequestBody MentorModalidade mentorModalidade) {
		// List<ModalidadeMentoria> modalidades = modalidadeMentoriaService.findAll();
		// mentorModalidade.setModalidadeMentoria(modalidades);
		mentorModalidadeService.create(mentorModalidade,
				mentorModalidade.getMentor().getId(),
				mentorModalidade.getModalidadeMentoria().getId());

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(mentorModalidade.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody MentorModalidade mentorModalidade, @PathVariable Long id) {
		mentorModalidade.setId(id);
		mentorModalidadeService.update(mentorModalidade);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		mentorModalidadeService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
