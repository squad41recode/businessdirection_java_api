package br.com.businessdirection.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.businessdirection.models.MentorModalidade;

public interface MentorModalidadeRepository extends JpaRepository<MentorModalidade, Long> {

	@Override
	@EntityGraph(attributePaths = { "mentor", "modalidadeMentoria" })
	List<MentorModalidade> findAll();

	@Query("SELECT mm FROM MentorModalidade mm WHERE mm.id NOT IN (SELECT emSub.mentorModalidade.id FROM EmpreendedorMentoria emSub)")
	List<MentorModalidade> listarMentoriasSemLigacaoComEmpreendedor();

	@Query("SELECT mm FROM MentorModalidade mm WHERE mm.ativo = true")
	List<MentorModalidade> findAllAtivos();
	
	@Query("SELECT mm FROM MentorModalidade mm WHERE mm.disponivel = true")
	List<MentorModalidade> findAllDisponiveis();

	MentorModalidade findByIdAndAtivo(Long id, boolean ativo);

	MentorModalidade findByIdAndDisponivel(Long id, boolean disponivel);
	
	@Override
	@EntityGraph(attributePaths = { "mentor", "modalidadeMentoria" })
	Optional<MentorModalidade> findById(Long id);
}
