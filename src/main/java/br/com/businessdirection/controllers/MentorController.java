package br.com.businessdirection.controllers;

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

import br.com.businessdirection.models.Mentor;
import br.com.businessdirection.services.MentorService;

@RestController
@RequestMapping("/mentores")
@Validated
public class MentorController {

	@Autowired
	private MentorService service;

	@GetMapping
	public ResponseEntity<List<Mentor>> findAll() {
		List<Mentor> mentores = service.findAll();

		return ResponseEntity.ok().body(mentores);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Mentor> findById(@PathVariable Long id) {
		Mentor mentor = service.findById(id);

		return ResponseEntity.ok().body(mentor);
	}

	@PostMapping
	public ResponseEntity<Mentor> save(@RequestBody Mentor mentor) {
		Mentor obj = service.save(mentor);

		return ResponseEntity.ok().body(obj);
	}

	@PutMapping("/editar/{id}")
	public ResponseEntity<Mentor> update(@RequestBody Mentor mentor) {
		Mentor obj = service.update(mentor);

		return ResponseEntity.ok().body(obj);
	}

	@DeleteMapping("/excluir/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		service.delete(id);

		return ResponseEntity.noContent().build();
	}

}
