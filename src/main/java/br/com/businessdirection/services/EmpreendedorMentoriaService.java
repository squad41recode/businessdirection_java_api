package br.com.businessdirection.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.businessdirection.models.Empreendedor;
import br.com.businessdirection.models.EmpreendedorMentoria;
import br.com.businessdirection.models.MentorModalidade;
import br.com.businessdirection.repositories.EmpreendedorMentoriaRepository;

@Service
public class EmpreendedorMentoriaService {

	@Autowired
	private EmpreendedorMentoriaRepository empreendedorMentoriaRepo;

	@Autowired
	private EmpreendedorService empreendedorService;

	@Autowired
	private MentorModalidadeService mentorModalidadeService;

	public EmpreendedorMentoria findById(Long id) {
		Optional<EmpreendedorMentoria> empreendedorMentoriaOptional = this.empreendedorMentoriaRepo.findById(id);

		EmpreendedorMentoria empreendedorMentoria = empreendedorMentoriaOptional.orElseThrow(() -> new RuntimeException(
				"EmpreendedorMentoria não encontrado. Id: " + id + ", Tipo: " + EmpreendedorMentoria.class.getName()));

		return empreendedorMentoria;
	}

	public List<EmpreendedorMentoria> findAll() {
		return empreendedorMentoriaRepo.findAll();
	}

	@Transactional
	public EmpreendedorMentoria create(EmpreendedorMentoria empreendedorMentoria, Long empreendedorId,
			Long mentorModalidadeId) {

		Empreendedor empreendedor = empreendedorService.findById(empreendedorId);
		MentorModalidade mentorModalidade = mentorModalidadeService.findById(mentorModalidadeId);
		empreendedorMentoria.setId(null);
		empreendedorMentoria.setEmpreendedor(empreendedor);
		empreendedorMentoria.setMentorModalidade(mentorModalidade);
		this.empreendedorMentoriaRepo.save(empreendedorMentoria);

		return empreendedorMentoria;
	}

	@Transactional
	public EmpreendedorMentoria update(EmpreendedorMentoria empreendedorMentoria) {

		EmpreendedorMentoria newEmpreendedorMentoria = findById(empreendedorMentoria.getId());
		updateEmpreendedorMentoria(empreendedorMentoria, newEmpreendedorMentoria);

		return empreendedorMentoriaRepo.save(newEmpreendedorMentoria);
	}

	public void delete(Long id) {
		empreendedorMentoriaRepo.deleteById(id);
	}

	private void updateEmpreendedorMentoria(EmpreendedorMentoria oldEmpreendedorMentoria,
			EmpreendedorMentoria newEmpreendedorMentoria) {
		newEmpreendedorMentoria.setEmpreendedor(oldEmpreendedorMentoria.getEmpreendedor());
		newEmpreendedorMentoria.setMentorModalidade(oldEmpreendedorMentoria.getMentorModalidade());
		newEmpreendedorMentoria.setStatus(oldEmpreendedorMentoria.getStatus());
		newEmpreendedorMentoria.setEncontrosFeitos(oldEmpreendedorMentoria.getEncontrosFeitos());
		newEmpreendedorMentoria.setFaltas(oldEmpreendedorMentoria.getFaltas());
		newEmpreendedorMentoria.setAtivo(oldEmpreendedorMentoria.isAtivo());
	}

}
