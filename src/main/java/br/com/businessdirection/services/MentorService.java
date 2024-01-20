package br.com.businessdirection.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.businessdirection.models.Mentor;
import br.com.businessdirection.repositories.MentorRepository;

@Service
public class MentorService {

	@Autowired
	private MentorRepository repo;

	public Mentor findById(Long id) {
		Optional<Mentor> mentor = this.repo.findById(id);

		return mentor.orElseThrow(() -> new ObjectNotFoundException(
				"Mentor não encontrado Id: " + id + ", Tipo: " + Mentor.class.getName(), mentor));
	}

	public List<Mentor> findAll() {
		return repo.findAll();
	}

	public Mentor save(Mentor mentor) {
		mentor.setId(null);

		return repo.save(mentor);
	}

	public Mentor update(Mentor mentor) {

		Mentor newMentor = findById(mentor.getId());
		updateMentor(mentor, newMentor);

		return repo.save(newMentor);
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}

	private void updateMentor(Mentor oldMentor, Mentor newMentor) {
		newMentor.setNome(oldMentor.getNome());
		newMentor.setSobrenome(oldMentor.getSobrenome());
		newMentor.setEmail(oldMentor.getEmail());
		newMentor.setDataNascimento(oldMentor.getDataNascimento());
		newMentor.setWhatsapp(oldMentor.getWhatsapp());
		newMentor.setTipoExperiencia(oldMentor.getTipoExperiencia());
		newMentor.setMentoriasDisponiveis(oldMentor.getMentoriasDisponiveis());
	}
}
