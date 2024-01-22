package br.com.businessdirection.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.businessdirection.models.Empreendedor;
import br.com.businessdirection.repositories.EmpreendedorRepository;

@Service
public class EmpreendedorService {

	@Autowired
	private EmpreendedorRepository repo;

	public Empreendedor findById(Long id) {
		Optional<Empreendedor> empreendedor = this.repo.findById(id);

		return empreendedor.orElseThrow(() -> new ObjectNotFoundException(
				"Empreendedor não encontrado Id: " + id + ", Tipo: " + Empreendedor.class.getName(), empreendedor));
	}

	public List<Empreendedor> findAll() {
		// Empreendedor empreendedor;
		// empreendedor.getMentoriasAdquiridas();
		// repo.findAllConteudosEstudados();
		// repo.

		return repo.findAll();
	}

	public Empreendedor save(Empreendedor empreendedor) {
		empreendedor.setId(null);

		return repo.save(empreendedor);
	}

	public Empreendedor update(Empreendedor empreendedor) {

		Empreendedor newEmpreendedor = findById(empreendedor.getId());
		updateEmpreendedor(empreendedor, newEmpreendedor);

		return repo.save(newEmpreendedor);
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}

	private void updateEmpreendedor(Empreendedor oldEmpreendedor, Empreendedor newEmpreendedor) {
		newEmpreendedor.setNome(oldEmpreendedor.getNome());
		newEmpreendedor.setSobrenome(oldEmpreendedor.getSobrenome());
		newEmpreendedor.setEmail(oldEmpreendedor.getEmail());
		newEmpreendedor.setDataNascimento(oldEmpreendedor.getDataNascimento());
		newEmpreendedor.setTelefone(oldEmpreendedor.getTelefone());
		newEmpreendedor.setNomeEmpresa(oldEmpreendedor.getNomeEmpresa());
		newEmpreendedor.setBairro(oldEmpreendedor.getBairro());
		newEmpreendedor.setCidade(oldEmpreendedor.getCidade());
		newEmpreendedor.setEstado(oldEmpreendedor.getEstado());
		newEmpreendedor.setCEP(oldEmpreendedor.getCEP());
		newEmpreendedor.setMentoriasAdquiridas(oldEmpreendedor.getMentoriasAdquiridas());
		newEmpreendedor.setConteudosEmpreendedor(oldEmpreendedor.getConteudosEmpreendedor());
	}
}
