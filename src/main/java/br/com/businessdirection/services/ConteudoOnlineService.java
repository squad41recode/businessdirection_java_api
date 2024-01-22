package br.com.businessdirection.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.businessdirection.models.ConteudoOnline;
import br.com.businessdirection.models.ModalidadeMentoria;
import br.com.businessdirection.repositories.ConteudoOnlineRepository;

@Service
public class ConteudoOnlineService {

	@Autowired
	private ConteudoOnlineRepository conteudoOnlineRepo;

	@Autowired
	private ModalidadeMentoriaService modalidadeMentoriaService;

	/*
	 * public ConteudoOnline findById(Long id) { Optional<ConteudoOnline>
	 * conteudoOnline = this.conteudoOnlineRepo.findById(id);
	 * modalidadeMentoriaService.findById(conteudoOnline.getModalidadeMentoria().
	 * getId()); //conteudoOnline. //ModalidadeMentoria modalidadeMentoria =
	 * modalidadeMentoriaService.findById(modalidadeMentoriaId);
	 * //.findById(conteudoOnline.getModalidadeMentoria().getId());
	 *
	 * Long modalidadeMentoriaId =
	 * conteudoOnline.get(modalidadeMentoriaService.findById(id));
	 * //conteudoOnline.getModalidadeMentoria(modalidadeMentoria);
	 * //conteudoOnline.getModalidadeMentoria(modalidadeMentoriaService.findById(
	 * modalidadeMentoriaId )); return conteudoOnline.orElseThrow(() -> new
	 * ObjectNotFoundException( "ConteudoOnline não encontrado. Id: " + id +
	 * ", Tipo: " + ConteudoOnline.class.getName(), conteudoOnline)); }
	 */

	public ConteudoOnline findById(Long id) {
		Optional<ConteudoOnline> conteudoOnlineOptional = this.conteudoOnlineRepo.findById(id);

		ConteudoOnline conteudoOnline = conteudoOnlineOptional.orElseThrow(() -> new RuntimeException(
				"ConteudoOnline não encontrado. Id: " + id + ", Tipo: " + ConteudoOnline.class.getName()));

		// Desanexa a entidade do contexto de persistência
		// Hibernate.initialize(conteudoOnline.getModalidadeMentoria());
		return conteudoOnline;
	}

	public List<ConteudoOnline> findAll() {
		return conteudoOnlineRepo.findAll();
	}

	@Transactional
	public ConteudoOnline create(ConteudoOnline conteudoOnline, Long modalidadeMentoriaId) {

		// Optional<ModalidadeMentoria> modalidadeMenOptional =
		// this.modalidadeMentoriaRepo.findById(modalidadeMentoria.getId());
		// this.modalidadeMentoriaService.findById(modalidadeMentoria.getId());
		/*
		 * ModalidadeMentoria modalidadeMentoria = this.modalidadeMentoriaService
		 * .findById(modalidadeMentoria.getId()); conteudoOnline.setId(null);
		 * conteudoOnline.setModalidadeMentoria(modalidadeMentoria);
		 */
		ModalidadeMentoria modalidadeMentoria = modalidadeMentoriaService.findById(modalidadeMentoriaId);
		conteudoOnline.setId(null);
		conteudoOnline.setModalidadeMentoria(modalidadeMentoria);
		this.conteudoOnlineRepo.save(conteudoOnline);

		return conteudoOnline;
	}

	@Transactional
	public ConteudoOnline update(ConteudoOnline conteudoOnline) {

		ConteudoOnline newConteudoOnline = findById(conteudoOnline.getId());
		updateConteudoOnline(conteudoOnline, newConteudoOnline);

		return conteudoOnlineRepo.save(newConteudoOnline);
	}

	public void delete(Long id) {
		conteudoOnlineRepo.deleteById(id);
	}

	private void updateConteudoOnline(ConteudoOnline oldConteudoOnline, ConteudoOnline newConteudoOnline) {
		newConteudoOnline.setModalidadeMentoria(oldConteudoOnline.getModalidadeMentoria());
		newConteudoOnline.setConteudo(oldConteudoOnline.getConteudo());
		newConteudoOnline.setConteudosEmpreendedor(oldConteudoOnline.getConteudosEmpreendedor());
	}

}
