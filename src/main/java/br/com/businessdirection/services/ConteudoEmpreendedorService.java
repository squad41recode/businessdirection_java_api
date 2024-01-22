package br.com.businessdirection.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.businessdirection.models.ConteudoEmpreendedor;
import br.com.businessdirection.models.ConteudoOnline;
import br.com.businessdirection.models.Empreendedor;
import br.com.businessdirection.repositories.ConteudoEmpreendedorRepository;

@Service
public class ConteudoEmpreendedorService {

	@Autowired
	private ConteudoEmpreendedorRepository conteudoEmpreendedorRepo;

	@Autowired
	private EmpreendedorService empreendedorService;

	@Autowired
	private ConteudoOnlineService conteudoOnlineService;

	public ConteudoEmpreendedor findById(Long id) {
		Optional<ConteudoEmpreendedor> conteudoEmpreendedorOptional = this.conteudoEmpreendedorRepo.findById(id);

		ConteudoEmpreendedor conteudoEmpreendedor = conteudoEmpreendedorOptional.orElseThrow(() -> new RuntimeException(
				"ConteudoEmpreendedor não encontrado. Id: " + id + ", Tipo: " + ConteudoEmpreendedor.class.getName()));

		return conteudoEmpreendedor;
	}

	public List<ConteudoEmpreendedor> findAll() {
		return conteudoEmpreendedorRepo.findAll();
	}

	/*
	 * public List<ConteudoEmpreendedor> findAll() { return
	 * conteudoEmpreendedorRepo.findAllByEmpreendedor_Id(); }
	 */

	@Transactional
	public ConteudoEmpreendedor create(ConteudoEmpreendedor conteudoEmpreendedor, Long empreendedorId,
			Long conteudoOnlineId) {

		Empreendedor empreendedor = empreendedorService.findById(empreendedorId);
		ConteudoOnline conteudoOnline = conteudoOnlineService.findById(conteudoOnlineId);
		conteudoEmpreendedor.setId(null);
		conteudoEmpreendedor.setEmpreendedor(empreendedor);
		conteudoEmpreendedor.setConteudoOnline(conteudoOnline);
		this.conteudoEmpreendedorRepo.save(conteudoEmpreendedor);

		return conteudoEmpreendedor;
	}

	@Transactional
	public ConteudoEmpreendedor update(ConteudoEmpreendedor conteudoEmpreendedor) {

		ConteudoEmpreendedor newConteudoEmpreendedor = findById(conteudoEmpreendedor.getId());
		updateConteudoEmpreendedor(conteudoEmpreendedor, newConteudoEmpreendedor);

		return conteudoEmpreendedorRepo.save(newConteudoEmpreendedor);
	}

	public void delete(Long id) {
		conteudoEmpreendedorRepo.deleteById(id);
	}

	private void updateConteudoEmpreendedor(ConteudoEmpreendedor oldConteudoEmpreendedor,
			ConteudoEmpreendedor newConteudoEmpreendedor) {
		newConteudoEmpreendedor.setEmpreendedor(oldConteudoEmpreendedor.getEmpreendedor());
		newConteudoEmpreendedor.setConteudoOnline(oldConteudoEmpreendedor.getConteudoOnline());
		newConteudoEmpreendedor.setStatus(oldConteudoEmpreendedor.getStatus());
		newConteudoEmpreendedor.setDataInicio(oldConteudoEmpreendedor.getDataInicio());
		newConteudoEmpreendedor.setDataFim(oldConteudoEmpreendedor.getDataFim());
		newConteudoEmpreendedor.setAtivo(oldConteudoEmpreendedor.isAtivo());
	}

}
