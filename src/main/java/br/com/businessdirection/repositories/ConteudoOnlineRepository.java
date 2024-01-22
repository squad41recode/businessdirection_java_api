package br.com.businessdirection.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.businessdirection.models.ConteudoOnline;

public interface ConteudoOnlineRepository extends JpaRepository<ConteudoOnline, Long> {

	@Override
	@EntityGraph(attributePaths = { "modalidadeMentoria" })
	List<ConteudoOnline> findAll();

	// @Query("SELECT co FROM ConteudoOnline co WHERE co.id = :id")
	@Override
	@EntityGraph(attributePaths = { "modalidadeMentoria" })
	Optional<ConteudoOnline> findById(Long id);

}
