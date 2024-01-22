package br.com.businessdirection.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.businessdirection.models.Mentor;
import br.com.businessdirection.models.MentorModalidade;
import br.com.businessdirection.models.ModalidadeMentoria;
import br.com.businessdirection.repositories.MentorModalidadeRepository;

@Service
public class MentorModalidadeService {

	@Autowired
	private MentorModalidadeRepository mentorModalidadeRepo;

	@Autowired
	private MentorService mentorService;

	@Autowired
	private ModalidadeMentoriaService modalidadeMentoriaService;

	public MentorModalidade findById(Long id) {
		Optional<MentorModalidade> mentorModalidadeOptional = this.mentorModalidadeRepo.findById(id);

		MentorModalidade mentorModalidade = mentorModalidadeOptional.orElseThrow(() -> new RuntimeException(
				"MentorModalidade não encontrado. Id: " + id + ", Tipo: " + MentorModalidade.class.getName()));

		return mentorModalidade;
	}

	public List<MentorModalidade> findAll() {
		return mentorModalidadeRepo.findAll();
	}

	@Transactional
	public MentorModalidade create(MentorModalidade mentorModalidade, Long mentorId, Long modalidadeMentoriaId) {

		Mentor mentor = mentorService.findById(mentorId);
		ModalidadeMentoria modalidadeMentoria = modalidadeMentoriaService.findById(modalidadeMentoriaId);
		mentorModalidade.setId(null);
		mentorModalidade.setMentor(mentor);
		mentorModalidade.setModalidadeMentoria(modalidadeMentoria);
		this.mentorModalidadeRepo.save(mentorModalidade);
		
		return mentorModalidade;
	}

	@Transactional
	public MentorModalidade update(MentorModalidade mentorModalidade) {

		MentorModalidade newMentorModalidade = findById(mentorModalidade.getId());
		updateMentorModalidade(mentorModalidade, newMentorModalidade);

		return mentorModalidadeRepo.save(newMentorModalidade);
	}

	public void delete(Long id) {
		mentorModalidadeRepo.deleteById(id);
	}

	private void updateMentorModalidade(MentorModalidade oldMentorModalidade, MentorModalidade newMentorModalidade) {
		newMentorModalidade.setMentor(oldMentorModalidade.getMentor());
		newMentorModalidade.setModalidadeMentoria(oldMentorModalidade.getModalidadeMentoria());
		newMentorModalidade.setDiaSemana(oldMentorModalidade.getDiaSemana());
		newMentorModalidade.setHorario(oldMentorModalidade.getHorario());
		newMentorModalidade.setAtivo(oldMentorModalidade.isAtivo());
	}

}
