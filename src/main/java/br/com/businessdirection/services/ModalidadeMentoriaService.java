package br.com.businessdirection.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.businessdirection.models.ModalidadeMentoria;
import br.com.businessdirection.repositories.ModalidadeMentoriaRepository;

@Service
public class ModalidadeMentoriaService {

	@Autowired
	private ModalidadeMentoriaRepository repo;

	public ModalidadeMentoria findById(Long id) {
		Optional<ModalidadeMentoria> modalidadeMentoria = this.repo.findById(id);

		return modalidadeMentoria.orElseThrow(() -> new RuntimeException(
				"ModalidadeMentoria não encontrado. Id: " + id + ", Tipo: " + ModalidadeMentoria.class.getName()));
	}

	public List<ModalidadeMentoria> findAll() {
		return repo.findAll();
	}

	@Transactional
	public ModalidadeMentoria create(ModalidadeMentoria modalidadeMentoria) {
		modalidadeMentoria.setId(null);
		this.repo.save(modalidadeMentoria);

		return modalidadeMentoria;
	}

	@Transactional
	public ModalidadeMentoria update(ModalidadeMentoria modalidadeMentoria) {

		ModalidadeMentoria newModalidadeMentoria = findById(modalidadeMentoria.getId());
		updateModalidadeMentoria(modalidadeMentoria, newModalidadeMentoria);

		return repo.save(newModalidadeMentoria);
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}

	private void updateModalidadeMentoria(ModalidadeMentoria oldModalidadeMentoria,
			ModalidadeMentoria newModalidadeMentoria) {
		newModalidadeMentoria.setNomeModalidade(oldModalidadeMentoria.getNomeModalidade());
		newModalidadeMentoria.setConteudoOnline(oldModalidadeMentoria.getConteudoOnline());
	}
}
